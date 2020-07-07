package one.block.eosiojavarpcprovider.implementations;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.util.Locale;

import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import one.block.eosiojava.error.rpcProvider.GetBlockRpcError;
import one.block.eosiojava.error.rpcProvider.GetInfoRpcError;
import one.block.eosiojava.error.rpcProvider.GetRawAbiRpcError;
import one.block.eosiojava.error.rpcProvider.GetRequiredKeysRpcError;
import one.block.eosiojava.error.rpcProvider.PushTransactionRpcError;
import one.block.eosiojava.error.rpcProvider.RpcProviderError;
import one.block.eosiojava.interfaces.IRPCProvider;
import one.block.eosiojava.models.rpcProvider.request.GetBlockRequest;
import one.block.eosiojava.models.rpcProvider.request.GetRawAbiRequest;
import one.block.eosiojava.models.rpcProvider.request.GetRequiredKeysRequest;
import one.block.eosiojava.models.rpcProvider.request.PushTransactionRequest;
import one.block.eosiojava.models.rpcProvider.response.GetBlockResponse;
import one.block.eosiojava.models.rpcProvider.response.GetInfoResponse;
import one.block.eosiojava.models.rpcProvider.response.GetRawAbiResponse;
import one.block.eosiojava.models.rpcProvider.response.GetRequiredKeysResponse;
import one.block.eosiojava.models.rpcProvider.response.PushTransactionResponse;
import one.block.eosiojava.models.rpcProvider.response.RPCResponseError;
//import one.block.eosiojavarpcprovider.BuildConfig;
import one.block.eosiojavarpcprovider.error.EosioJavaRpcErrorConstants;
import one.block.eosiojavarpcprovider.error.EosioJavaRpcProviderCallError;
import one.block.eosiojavarpcprovider.error.EosioJavaRpcProviderInitializerError;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//
// Copyright © 2017-2019 block.one.
//

/**
 * Simple implementation of an RPC provider for communicating with the blockchain.
 * The calls are implemented synchronously.  It is assumed that the developer will
 * wrap them in asynchronous semantics such as AsyncTask in normal use...
 */
public class EosioJavaRpcProviderImpl implements IRPCProvider {

    @NotNull
    private String baseURL;

    @NotNull
    private Retrofit retrofit;

    @NotNull
    private IEosioJavaRpcProviderApi rpcProviderApi;

    /**
     * Construct a new RPC provider instance given the base URL to use for building requests.
     * @param baseURL Base URL to use for building requests.
     * @throws EosioJavaRpcProviderInitializerError thrown if the base URL passed in is null.
     */
    public EosioJavaRpcProviderImpl(@NotNull String baseURL) throws EosioJavaRpcProviderInitializerError {
        this(baseURL, false);
    }

    /**
     * Construct a new RPC provider instance given the base URL to use for building requests.
     * @param baseURL Base URL to use for building requests.
     * @param enableDebug Enable Network Log at {@link Level#BODY} level
     * @throws EosioJavaRpcProviderInitializerError thrown if the base URL passed in is null.
     */
    public EosioJavaRpcProviderImpl(@NotNull String baseURL, boolean enableDebug) throws EosioJavaRpcProviderInitializerError {
        if(baseURL == null || baseURL.isEmpty()) {
            throw new EosioJavaRpcProviderInitializerError(EosioJavaRpcErrorConstants.RPC_PROVIDER_BASE_URL_EMPTY);
        }

        this.baseURL = baseURL;
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        if (enableDebug) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(Level.BODY);
            httpClient.addInterceptor(httpLoggingInterceptor);
        }

        this.retrofit = new Retrofit.Builder()
                .baseUrl(this.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        this.rpcProviderApi = this.retrofit.create(IEosioJavaRpcProviderApi.class);
    }

    /**
     * Process a retrofit call, setting arguments, checking responses and decoding responses and errors
     * as necessary.
     * @param call Retrofit call to execute.
     * @param <O> Response type to use for decoding.
     * @return Response type given in signature.
     * @throws Exception Can throw EosioJavaRpcProviderCallError for RPC provider specific
     * processing errors or Java IO or network errors from Retrofit.
     */
    @NotNull
    private <O> O processCall(Call<O> call) throws Exception {
        Response<O> response = call.execute();
        if (!response.isSuccessful()) {
            String additionalErrInfo = EosioJavaRpcErrorConstants.RPC_PROVIDER_NO_FURTHER_ERROR_INFO;

            RPCResponseError rpcResponseError = null;
            if (response.errorBody() != null) {
                Gson gson = new Gson();
                rpcResponseError = gson.fromJson(response.errorBody().charStream(), RPCResponseError.class);
                if (rpcResponseError == null) {
                    additionalErrInfo = response.errorBody().string();
                } else {
                    additionalErrInfo = EosioJavaRpcErrorConstants.RPC_PROVIDER_SEE_FURTHER_ERROR_INFO;
                }
            }

            String msg = String.format(Locale.getDefault(), EosioJavaRpcErrorConstants.RPC_PROVIDER_BAD_STATUS_CODE_RETURNED,
                    response.code(), response.message(), additionalErrInfo);
            throw new EosioJavaRpcProviderCallError(msg, rpcResponseError);
        }
        if (response.body() == null) {
            throw new EosioJavaRpcProviderCallError(EosioJavaRpcErrorConstants.RPC_PROVIDER_EMPTY_RESPONSE_RETURNED);
        }
        return response.body();
    }

    /**
     * Issue a getInfo() call to the blockchain and process the response.
     * @return GetInfoResponse on successful return.
     * @throws GetInfoRpcError Thrown if any errors occur calling or processing the request.
     */
    @Override
    public @NotNull GetInfoResponse getInfo() throws GetInfoRpcError {
        try {
            Call<GetInfoResponse> syncCall = this.rpcProviderApi.getInfo();
            return processCall(syncCall);
        } catch (Exception ex) {
            throw new GetInfoRpcError(EosioJavaRpcErrorConstants.RPC_PROVIDER_ERROR_GETTING_CHAIN_INFO,
                    ex);
        }
    }

    /**
     * Issue a getBlock() call to the blockchain and process the response.
     * @param getBlockRequest Info about a specific block.
     * @return GetBlockRsponse on successful return.
     * @throws GetBlockRpcError Thrown if any errors occur calling or processing the request.
     */
    @Override
    public @NotNull GetBlockResponse getBlock(GetBlockRequest getBlockRequest)
            throws GetBlockRpcError {
        try {
            Call<GetBlockResponse> syncCall = this.rpcProviderApi.getBlock(getBlockRequest);
            return processCall(syncCall);
        } catch (Exception ex) {
            throw new GetBlockRpcError(EosioJavaRpcErrorConstants.RPC_PROVIDER_ERROR_GETTING_BLOCK_INFO,
                    ex);
        }
    }

    /**
     * Issue a getRawAbi() request to the blockchain and process the response.
     * @param getRawAbiRequest Info about a specific smart contract.
     * @return GetRawAbiResponse on successful return.
     * @throws GetRawAbiRpcError Thrown if any errors occur calling or processing the request.
     */
    @Override
    public @NotNull GetRawAbiResponse getRawAbi(GetRawAbiRequest getRawAbiRequest)
            throws GetRawAbiRpcError {
        try {
            Call<GetRawAbiResponse> syncCall = this.rpcProviderApi.getRawAbi(getRawAbiRequest);
            return processCall(syncCall);
        } catch (Exception ex) {
            throw new GetRawAbiRpcError(EosioJavaRpcErrorConstants.RPC_PROVIDER_ERROR_GETTING_RAW_ABI,
                    ex);
        }
    }

    /**
     * Issue a getRequiredKeys() request to the blockchain and process the response.
     * @param getRequiredKeysRequest Info to get required keys
     * @return GetRequiredKeysResponse on successful return.
     * @throws GetRequiredKeysRpcError Thrown if any errors occur calling or processing the request.
     */
    @Override
    public @NotNull GetRequiredKeysResponse getRequiredKeys(
            GetRequiredKeysRequest getRequiredKeysRequest) throws GetRequiredKeysRpcError {
        try {
            Call<GetRequiredKeysResponse> syncCall = this.rpcProviderApi.getRequiredKeys(getRequiredKeysRequest);
            return processCall(syncCall);
        } catch (Exception ex) {
            throw new GetRequiredKeysRpcError(EosioJavaRpcErrorConstants.RPC_PROVIDER_ERROR_GETTING_REQUIRED_KEYS,
                    ex);
        }
    }

    /**
     * Push a given transaction to the blockchain and process the response.
     * @param pushTransactionRequest the transaction to push with signatures.
     * @return PushTransactionResponse on successful return.
     * @throws PushTransactionRpcError Thrown if any errors occur calling or processing the request.
     */
    @Override
    public @NotNull PushTransactionResponse pushTransaction(
            PushTransactionRequest pushTransactionRequest) throws PushTransactionRpcError {
        try {
            Call<PushTransactionResponse> syncCall = this.rpcProviderApi.pushTransaction(pushTransactionRequest);
            return processCall(syncCall);
        } catch (Exception ex) {
            throw new PushTransactionRpcError(EosioJavaRpcErrorConstants.RPC_PROVIDER_ERROR_PUSHING_TRANSACTION,
                    ex);
        }
    }

    /**
     * Issue a get_account call to the blockchain and process the response.
     * @param requestBody request body of get_account API
     * @return String content of ResponseBody on successful return.
     * @throws RpcProviderError Thrown if any errors occur calling or processing the request.
     */
    public @NotNull String getAccount(RequestBody requestBody) throws RpcProviderError {
        try {
            Call<ResponseBody> syncCall = this.rpcProviderApi.getAccount(requestBody);
            try(ResponseBody responseBody = processCall(syncCall)) {
                return responseBody.string();
            }
        } catch (Exception ex) {
            throw new RpcProviderError(EosioJavaRpcErrorConstants.RPC_PROVIDER_ERROR_GET_ACCOUNT, ex);
        }
    }

    /**
     * Issue a pushTransactions() call to the blockchain and process the response.
     * @param requestBody request body of push_transactions API
     * @return String content of ResponseBody on successful return.
     * @throws RpcProviderError Thrown if any errors occur calling or processing the request.
     */
    public @NotNull String pushTransactions(RequestBody requestBody) throws RpcProviderError {
        try {
            Call<ResponseBody> syncCall = this.rpcProviderApi.pushTransactions(requestBody);
            try(ResponseBody responseBody = processCall(syncCall)) {
                return responseBody.string();
            }
        } catch (Exception ex) {
            throw new RpcProviderError(EosioJavaRpcErrorConstants.RPC_PROVIDER_ERROR_PUSHING_TRANSACTIONS, ex);
        }
    }

    /**
     * Issue a getBlockHeaderState() call to the blockchain and process the response.
     * @param requestBody request body of get_block_header_state API
     * @return String content of ResponseBody on successful return.
     * @throws RpcProviderError Thrown if any errors occur calling or processing the request.
     */
    public @NotNull String getBlockHeaderState(RequestBody requestBody) throws RpcProviderError {
        try {
            Call<ResponseBody> syncCall = this.rpcProviderApi.getBlockHeaderState(requestBody);
            try(ResponseBody responseBody = processCall(syncCall)) {
                return responseBody.string();
            }
        } catch (Exception ex) {
            throw new RpcProviderError(EosioJavaRpcErrorConstants.RPC_PROVIDER_ERROR_GET_BLOCK_HEADER_STATE, ex);
        }
    }

    /**
     * Issue a getAbi() call to the blockchain and process the response.
     * @param requestBody request body of get_abi API
     * @return String content of ResponseBody on successful return.
     * @throws RpcProviderError Thrown if any errors occur calling or processing the request.
     */
    public @NotNull String getAbi(RequestBody requestBody) throws RpcProviderError {
        try {
            Call<ResponseBody> syncCall = this.rpcProviderApi.getAbi(requestBody);
            try(ResponseBody responseBody = processCall(syncCall)) {
                return responseBody.string();
            }
        } catch (Exception ex) {
            throw new RpcProviderError(EosioJavaRpcErrorConstants.RPC_PROVIDER_ERROR_GET_ABI, ex);
        }
    }

    /**
     * Issue a getCurrencyBalance call to the blockchain and process the response.
     * @param requestBody request body of get_currency_balance API
     * @return String content of ResponseBody on successful return.
     * @throws RpcProviderError Thrown if any errors occur calling or processing the request.
     */
    public @NotNull String getCurrencyBalance(RequestBody requestBody) throws RpcProviderError {
        try {
            Call<ResponseBody> syncCall = this.rpcProviderApi.getCurrencyBalance(requestBody);
            try(ResponseBody responseBody = processCall(syncCall)) {
                return responseBody.string();
            }
        } catch (Exception ex) {
            throw new RpcProviderError(EosioJavaRpcErrorConstants.RPC_PROVIDER_ERROR_GET_CURRENT_BALANCE, ex);
        }
    }

    /**
     * Issue a getCurrencyStats() call to the blockchain and process the response.
     * @param requestBody request body of get_currency_stats API
     * @return String content of ResponseBody on successful return.
     * @throws RpcProviderError Thrown if any errors occur calling or processing the request.
     */
    public @NotNull String getCurrencyStats(RequestBody requestBody) throws RpcProviderError {
        try {
            Call<ResponseBody> syncCall = this.rpcProviderApi.getCurrencyStats(requestBody);
            try(ResponseBody responseBody = processCall(syncCall)) {
                return responseBody.string();
            }
        } catch (Exception ex) {
            throw new RpcProviderError(EosioJavaRpcErrorConstants.RPC_PROVIDER_ERROR_GET_CURRENT_STATS, ex);
        }
    }

    /**
     * Issue a getProducers() call to the blockchain and process the response.
     * @param requestBody request body of get_producers API
     * @return String content of ResponseBody on successful return.
     * @throws RpcProviderError Thrown if any errors occur calling or processing the request.
     */
    public @NotNull String getProducers(RequestBody requestBody) throws RpcProviderError {
        try {
            Call<ResponseBody> syncCall = this.rpcProviderApi.getProducers(requestBody);
            try(ResponseBody responseBody = processCall(syncCall)) {
                return responseBody.string();
            }
        } catch (Exception ex) {
            throw new RpcProviderError(EosioJavaRpcErrorConstants.RPC_PROVIDER_ERROR_GET_PRODUCERS, ex);
        }
    }

    /**
     * Issue a getRawCodeAndAbi() call to the blockchain and process the response.
     * @param requestBody request body of get_raw_code_and_abi API
     * @return String content of ResponseBody on successful return.
     * @throws RpcProviderError Thrown if any errors occur calling or processing the request.
     */
    public @NotNull String getRawCodeAndAbi(RequestBody requestBody) throws RpcProviderError {
        try {
            Call<ResponseBody> syncCall = this.rpcProviderApi.getRawCodeAndAbi(requestBody);
            try(ResponseBody responseBody = processCall(syncCall)) {
                return responseBody.string();
            }
        } catch (Exception ex) {
            throw new RpcProviderError(EosioJavaRpcErrorConstants.RPC_PROVIDER_ERROR_GET_RAW_CODE_AND_ABI, ex);
        }
    }

    /**
     * Issue a getTableByScope() call to the blockchain and process the response.
     * @param requestBody request body of get_table_by_scope API
     * @return String content of ResponseBody on successful return.
     * @throws RpcProviderError Thrown if any errors occur calling or processing the request.
     */
    public @NotNull String getTableByScope(RequestBody requestBody) throws RpcProviderError {
        try {
            Call<ResponseBody> syncCall = this.rpcProviderApi.getTableByScope(requestBody);
            try(ResponseBody responseBody = processCall(syncCall)) {
                return responseBody.string();
            }
        } catch (Exception ex) {
            throw new RpcProviderError(EosioJavaRpcErrorConstants.RPC_PROVIDER_ERROR_GET_TABLE_BY_SCOPE, ex);
        }
    }

    /**
     * Issue a getTableRows() call to the blockchain and process the response.
     * @param requestBody request body of get_table_rows API
     * @return String content of ResponseBody on successful return.
     * @throws RpcProviderError Thrown if any errors occur calling or processing the request.
     */
    public @NotNull String getTableRows(RequestBody requestBody) throws RpcProviderError {
        try {
            Call<ResponseBody> syncCall = this.rpcProviderApi.getTableRows(requestBody);
            try(ResponseBody responseBody = processCall(syncCall)) {
                return responseBody.string();
            }
        } catch (Exception ex) {
            throw new RpcProviderError(EosioJavaRpcErrorConstants.RPC_PROVIDER_ERROR_GET_TABLE_ROWS, ex);
        }
    }

    /**
     * Issue a getCode() call to the blockchain and process the response.
     * @param requestBody request body of get_code API
     * @return String content of ResponseBody on successful return.
     * @throws RpcProviderError Thrown if any errors occur calling or processing the request.
     */
    public @NotNull String getCode(RequestBody requestBody) throws RpcProviderError {
        try {
            Call<ResponseBody> syncCall = this.rpcProviderApi.getCode(requestBody);
            try(ResponseBody responseBody = processCall(syncCall)) {
                return responseBody.string();
            }
        } catch (Exception ex) {
            throw new RpcProviderError(EosioJavaRpcErrorConstants.RPC_PROVIDER_ERROR_GET_CODE, ex);
        }
    }

    /**
     * Issue a getActions() call to the blockchain and process the response.
     * @param requestBody request body of get_actions API
     * @return String content of ResponseBody on successful return.
     * @throws RpcProviderError Thrown if any errors occur calling or processing the request.
     */
    public @NotNull String getActions(RequestBody requestBody) throws RpcProviderError {
        try {
            Call<ResponseBody> syncCall = this.rpcProviderApi.getActions(requestBody);
            try(ResponseBody responseBody = processCall(syncCall)) {
                return responseBody.string();
            }
        } catch (Exception ex) {
            throw new RpcProviderError(EosioJavaRpcErrorConstants.RPC_PROVIDER_ERROR_GET_ACTION, ex);
        }
    }

    /**
     * Issue a getTransaction() call to the blockchain and process the response.
     * @param requestBody request body of get_transaction API
     * @return String content of ResponseBody on successful return.
     * @throws RpcProviderError Thrown if any errors occur calling or processing the request.
     */
    public @NotNull String getTransaction(RequestBody requestBody) throws RpcProviderError {
        try {
            Call<ResponseBody> syncCall = this.rpcProviderApi.getTransaction(requestBody);
            try(ResponseBody responseBody = processCall(syncCall)) {
                return responseBody.string();
            }
        } catch (Exception ex) {
            throw new RpcProviderError(EosioJavaRpcErrorConstants.RPC_PROVIDER_ERROR_GET_TRANSACTION, ex);
        }
    }

    /**
     * Issue a getKeyAccounts() call to the blockchain and process the response.
     * @param requestBody request body of get_key_accounts API
     * @return String content of ResponseBody on successful return.
     * @throws RpcProviderError Thrown if any errors occur calling or processing the request.
     */
    public @NotNull String getKeyAccounts(RequestBody requestBody) throws RpcProviderError {
        try {
            Call<ResponseBody> syncCall = this.rpcProviderApi.getKeyAccounts(requestBody);
            try(ResponseBody responseBody = processCall(syncCall)) {
                return responseBody.string();
            }
        } catch (Exception ex) {
            throw new RpcProviderError(EosioJavaRpcErrorConstants.RPC_PROVIDER_ERROR_GET_KEY_ACCOUNTS, ex);
        }
    }

    /**
     * Issue a getControlledAccounts() call to the blockchain and process the response.
     * @param requestBody request body of get_controlled_accounts API
     * @return String content of ResponseBody on successful return.
     * @throws RpcProviderError Thrown if any errors occur calling or processing the request.
     */
    public @NotNull String getControlledAccounts(RequestBody requestBody) throws RpcProviderError {
        try {
            Call<ResponseBody> syncCall = this.rpcProviderApi.getControlledAccounts(requestBody);
            try(ResponseBody responseBody = processCall(syncCall)) {
                return responseBody.string();
            }
        } catch (Exception ex) {
            throw new RpcProviderError(EosioJavaRpcErrorConstants.RPC_PROVIDER_ERROR_GET_CONTROLLED_ACCOUNTS, ex);
        }
    }
}
