package one.block.eosiojavarpcprovider.implementations;
//
// Copyright © 2017-2019 block.one.
//

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import one.block.eosiojava.models.rpcProvider.request.GetBlockRequest;
import one.block.eosiojava.models.rpcProvider.request.GetRawAbiRequest;
import one.block.eosiojava.models.rpcProvider.request.GetRequiredKeysRequest;
import one.block.eosiojava.models.rpcProvider.request.PushTransactionRequest;
import one.block.eosiojava.models.rpcProvider.response.GetBlockResponse;
import one.block.eosiojava.models.rpcProvider.response.GetInfoResponse;
import one.block.eosiojava.models.rpcProvider.response.GetRawAbiResponse;
import one.block.eosiojava.models.rpcProvider.response.GetRequiredKeysResponse;
import one.block.eosiojava.models.rpcProvider.response.PushTransactionResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Retrofit definitions for communication with the EOSIO blockchain.
 */
public interface IEosioJavaRpcProviderApi {

    //region Model supported APIs

    /**
     * Retrofit POST call to "chain/get_info" to an EOSIO blockchain.
     * This method gets called from {@link EosioJavaRpcProviderImpl#getInfo()} to get latest information about the pointing chain.
     *
     * @return Executable {@link Call} to return {@link GetInfoResponse} has latest information about a chain.
     */
    @POST("v1/chain/get_info")
    Call<GetInfoResponse> getInfo();

    /**
     * Retrofit POST call to "chain/get_block" to an EOSIO blockchain.
     * This method gets called from {@link EosioJavaRpcProviderImpl#getBlock(GetBlockRequest)} to get info/status of a specific block in the request.
     *
     * @param getBlockRequest Info of a specific block.
     * @return Executable {@link Call} to return {@link GetBlockResponse} has the info/status of a specific block in the request.
     */
    @POST("v1/chain/get_block")
    Call<GetBlockResponse> getBlock(@Body GetBlockRequest getBlockRequest);

    /**
     * Retrofit POST call to "chain/get_raw_abi" to an EOSIO blockchain.
     * This method gets called from {@link EosioJavaRpcProviderImpl#getRawAbi(GetRawAbiRequest)} to get serialized ABI of a smart contract in the request.
     *
     * @param getRawAbiRequest Info of a specific smart contract.
     * @return Executable {@link Call} to return {@link GetRawAbiResponse} has the serialized ABI of a smart contract in the request.
     */
    @POST("v1/chain/get_raw_abi")
    Call<GetRawAbiResponse> getRawAbi(@Body GetRawAbiRequest getRawAbiRequest);

    /**
     * Retrofit POST call to "chain/get_required_keys" to an EOSIO blockchain.
     * This method gets called from {@link EosioJavaRpcProviderImpl#getRequiredKeys(GetRequiredKeysRequest)} to get required keys to sign a transaction
     *
     * @param getRequiredKeysRequest Info to get required keys
     * @return Executable {@link Call} to return {@link GetRequiredKeysResponse} has the required keys to sign a transaction
     */
    @POST("v1/chain/get_required_keys")
    Call<GetRequiredKeysResponse> getRequiredKeys(@Body GetRequiredKeysRequest getRequiredKeysRequest);

    /**
     * Retrofit POST call to "chain/push_transaction" to an EOSIO blockchain.
     * This method gets called from {@link EosioJavaRpcProviderImpl#pushTransaction(PushTransactionRequest)} to Push transaction RPC call to broadcast a transaction to backend
     *
     * @param pushTransactionRequest the transaction to push with signatures.
     * @return Executable {@link Call} to return {@link PushTransactionResponse} has the push transaction response
     */
    @POST("v1/chain/push_transaction")
    Call<PushTransactionResponse> pushTransaction(@Body PushTransactionRequest pushTransactionRequest);
    //endregion


    //region Extra APIs
    // Chain APIs
    /**
     * Retrofit POST call to "chain/get_account" to an EOSIO blockchain.
     * This method gets called from {@link EosioJavaRpcProviderImpl#getAccount(RequestBody)}
     *
     * @param requestBody the request body to call 'get_account' API
     * @return Executable {@link Call} to return {@link ResponseBody} of 'get_account' API
     */
    @POST("v1/chain/get_account")
    Call<ResponseBody> getAccount(@Body RequestBody requestBody);

    /**
     * Retrofit POST call to "chain/push_transactions" to an EOSIO blockchain.
     * This method gets called from {@link EosioJavaRpcProviderImpl#pushTransactions(RequestBody)}
     *
     * @param requestBody the request body to call 'push_transactions' API
     * @return Executable {@link Call} to return {@link ResponseBody} of 'push_transactions' API
     */
    @POST("v1/chain/push_transactions")
    Call<ResponseBody> pushTransactions(@Body RequestBody requestBody);

    /**
     * Retrofit POST call to "chain/get_block_header_state" to an EOSIO blockchain.
     * This method get called from {@link EosioJavaRpcProviderImpl#getBlockHeaderState(RequestBody)}
     *
     * @param requestBody the request body to call 'get_block_header_state' API
     * @return Executable {@link Call} to return {@link ResponseBody} of 'get_block_header_state' API
     */
    @POST("v1/chain/get_block_header_state")
    Call<ResponseBody> getBlockHeaderState(@Body RequestBody requestBody);

    /**
     * Retrofit POST call to "chain/get_abi" to an EOSIO blockchain.
     * This method gets called from {@link EosioJavaRpcProviderImpl#getAbi(RequestBody)}
     *
     * @param requestBody the request body to call 'get_abi' API
     * @return Executable {@link Call} to return {@link ResponseBody} of 'get_abi' API
     */
    @POST("v1/chain/get_abi")
    Call<ResponseBody> getAbi(@Body RequestBody requestBody);

    /**
     * Retrofit POST call to "chain/get_currency_balance" to an EOSIO blockchain.
     * This method gets called from {@link EosioJavaRpcProviderImpl#getCurrencyBalance(RequestBody)}
     *
     * @param requestBody the request body to call 'get_currency_balance' API
     * @return Executable {@link Call} to return {@link ResponseBody} of 'get_currency_balance' API
     */
    @POST("v1/chain/get_currency_balance")
    Call<ResponseBody> getCurrencyBalance(@Body RequestBody requestBody);

    /**
     * Retrofit POST call to "chain/get_currency_stats" to an EOSIO blockchain.
     * This method gets called from {@link EosioJavaRpcProviderImpl#getCurrencyStats(RequestBody)}
     *
     * @param requestBody the request body to call 'get_currency_stats' API
     * @return Executable {@link Call} to return {@link ResponseBody} of 'get_currency_stats' API
     */
    @POST("v1/chain/get_currency_stats")
    Call<ResponseBody> getCurrencyStats(@Body RequestBody requestBody);

    /**
     * Retrofit POST call to "chain/get_producers" to an EOSIO blockchain.
     * This method gets called from {@link EosioJavaRpcProviderImpl#getProducers(RequestBody)}
     *
     * @param requestBody the request body to call 'get_producers' API
     * @return Executable {@link Call} to return {@link ResponseBody} of 'get_producers' API
     */
    @POST("v1/chain/get_producers")
    Call<ResponseBody> getProducers(@Body RequestBody requestBody);

    /**
     * Retrofit POST call to "chain/get_raw_code_and_abi" to an EOSIO blockchain.
     * This method gets called from {@link EosioJavaRpcProviderImpl#getRawCodeAndAbi(RequestBody)}
     *
     * @param requestBody the request body to call 'get_raw_code_and_abi' API
     * @return Executable {@link Call} to return {@link ResponseBody} of 'get_raw_code_and_abi' API
     */
    @POST("v1/chain/get_raw_code_and_abi")
    Call<ResponseBody> getRawCodeAndAbi(@Body RequestBody requestBody);

    /**
     * Retrofit POST call to "chain/get_table_by_scope" to an EOSIO blockchain.
     * This method get called from {@link EosioJavaRpcProviderImpl#getTableByScope(RequestBody)}
     *
     * @param requestBody the request body to call 'get_table_by_scope' API
     * @return Executable {@link Call} to return {@link ResponseBody} of 'get_table_by_scope' API
     */
    @POST("v1/chain/get_table_by_scope")
    Call<ResponseBody> getTableByScope(@Body RequestBody requestBody);

    /**
     * Retrofit POST call to "chain/get_table_rows" to an EOSIO blockchain.
     * This method gets called from {@link EosioJavaRpcProviderImpl#getTableRows(RequestBody)}
     *
     * @param requestBody the request body to call 'get_table_rows' API
     * @return Executable {@link Call} to return {@link ResponseBody} of 'get_table_rows' API
     */
    @POST("v1/chain/get_table_rows")
    Call<ResponseBody> getTableRows(@Body RequestBody requestBody);

    /**
     * Retrofit POST call to "chain/get_code" to an EOSIO blockchain.
     * This method gets called from {@link EosioJavaRpcProviderImpl#getCode(RequestBody)}
     *
     * @param requestBody the request body to call 'get_code' API
     * @return Executable {@link Call} to return {@link ResponseBody} of 'get_code' API
     */
    @POST("v1/chain/get_code")
    Call<ResponseBody> getCode(@Body RequestBody requestBody);

    //History APIs

    /**
     * Retrofit POST call to "chain/get_actions" to an EOSIO blockchain.
     * This method gets called from {@link EosioJavaRpcProviderImpl#getActions(RequestBody)}
     *
     * @param requestBody the request body to call 'get_actions' API
     * @return Executable {@link Call} to return {@link ResponseBody} of 'get_actions' API
     */
    @POST("v1/history/get_actions")
    Call<ResponseBody> getActions(@Body RequestBody requestBody);

    /**
     * Retrofit POST call to "chain/get_transaction" to an EOSIO blockchain.
     * This method gets called from {@link EosioJavaRpcProviderImpl#getTransaction(RequestBody)}
     *
     * @param requestBody the request body to call 'get_transaction' API
     * @return Executable {@link Call} to return {@link ResponseBody} of 'get_transaction' API
     */
    @POST("v1/history/get_transaction")
    Call<ResponseBody> getTransaction(@Body RequestBody requestBody);

    /**
     * Retrofit POST call to "chain/get_key_accounts" to an EOSIO blockchain.
     * This method gets called from {@link EosioJavaRpcProviderImpl#getKeyAccounts(RequestBody)}
     *
     * @param requestBody the request body to call 'get_key_accounts' API
     * @return Executable {@link Call} to return {@link ResponseBody} of 'get_key_accounts' API
     */
    @POST("v1/history/get_key_accounts")
    Call<ResponseBody> getKeyAccounts(@Body RequestBody requestBody);

    /**
     * Retrofit POST call to "chain/get_controlled_accounts" to an EOSIO blockchain.
     * This method gets called from {@link EosioJavaRpcProviderImpl#getControlledAccounts(RequestBody)}
     *
     * @param requestBody the request body to call 'get_controlled_accounts' API
     * @return Executable {@link Call} to return {@link ResponseBody} of 'get_controlled_accounts' API
     */
    @POST("v1/history/get_controlled_accounts")
    Call<ResponseBody> getControlledAccounts(@Body RequestBody requestBody);

    //endregion
}
