package one.block.eosiojavarpcprovider.implementations;

import com.google.gson.Gson;
import java.util.Locale;
import okhttp3.OkHttpClient;
import one.block.eosiojava.error.rpcProvider.GetBlockRpcError;
import one.block.eosiojava.error.rpcProvider.GetInfoRpcError;
import one.block.eosiojava.error.rpcProvider.GetRawAbiRpcError;
import one.block.eosiojava.error.rpcProvider.GetRequiredKeysRpcError;
import one.block.eosiojava.error.rpcProvider.PushTransactionRpcError;
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
import one.block.eosiojava.models.rpcProvider.response.RpcError;
import one.block.eosiojavarpcprovider.error.EosioJavaRpcErrorConstants;
import one.block.eosiojavarpcprovider.error.EosioJavaRpcProviderCallError;
import one.block.eosiojavarpcprovider.error.EosioJavaRpcProviderInitializerError;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//
// EosioJavaRpcProviderImpl
// eosio-java-android-rpc-provider
//
// Created by mccoole on 4/5/19
// Copyright © 2017-2019 block.one.
//

/**
 * Simple implementation of an RPC provider for communicating with the blockchain.
 * The calls are implemented synchronously.  It is assumed that the developer will
 * wrap them in asynchronous semantics such as AsyncTask in normal use.
 */
public class EosioJavaRpcProviderImpl implements IRPCProvider {

    @NotNull
    private String baseURL;

    @NotNull
    private Retrofit retrofit;

    @NotNull
    private IEosioJavaRpcProviderApi rpcProviderApi;

    /**
     * Construct a new RPC Provider instance given the base URL to use for building requests.
     * @param baseURL - Base URL to use for building requests.
     * @throws EosioJavaRpcProviderInitializerError - thrown if the base URL passed in is null.
     */
    public EosioJavaRpcProviderImpl(@NotNull String baseURL) throws EosioJavaRpcProviderInitializerError {
        if(baseURL == null || baseURL.isEmpty()) {
            throw new EosioJavaRpcProviderInitializerError(EosioJavaRpcErrorConstants.RPC_PROVIDER_BASE_URL_EMPTY);
        }

        this.baseURL = baseURL;
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
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
     * @param call - Retrofit call to execute.
     * @param <O> - Response type to use for decoding.
     * @return - Response type given in signature.
     * @throws Exception - Can throw EosioJavaRpcProviderCallError errors for RPC Provider specific
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
     * Issue a get_info call to the blockchain and process the response.
     * @return - GetInfoResponse on successful return.
     * @throws GetInfoRpcError - Thrown if any errors occur calling or processing the request.
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
     * Issue a get_block call to the blockchain and process the response.
     * @param getBlockRequest Info of a specific block.
     * @return - GetBlockRsponse on successful return.
     * @throws GetBlockRpcError - Thrown if any errors occur calling or processing the request.
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
     * Issue a get_raw_abi request to the blockchain and process the response.
     * @param getRawAbiRequest Info of a specific smart contract.
     * @return - GetRawAbiResponse on successful return.
     * @throws GetRawAbiRpcError - Thrown if any errors occur calling or processing the request.
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
     * Issue a get_required_keys request to the blockchain and process the response.
     * @param getRequiredKeysRequest Info to get required keys
     * @return - GetRequiredKeysResponse on successful return.
     * @throws GetRequiredKeysRpcError - Thrown if any errors occur calling or processing the request.
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
     * @return - PushTransactionResponse on successful return.
     * @throws PushTransactionRpcError - Thrown if any errors occur calling or processing the request.
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
}
