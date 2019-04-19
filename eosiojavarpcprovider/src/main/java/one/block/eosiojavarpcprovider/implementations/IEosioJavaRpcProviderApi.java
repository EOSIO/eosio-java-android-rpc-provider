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
    @POST("v1/chain/get_info")
    public Call<GetInfoResponse> getInfo();

    @POST("v1/chain/get_block")
    public Call<GetBlockResponse> getBlock(@Body GetBlockRequest getBlockRequest);

    @POST("v1/chain/get_raw_abi")
    public Call<GetRawAbiResponse> getRawAbi(@Body GetRawAbiRequest getRawAbiRequest);

    @POST("v1/chain/get_required_keys")
    public Call<GetRequiredKeysResponse> getRequiredKeys(@Body GetRequiredKeysRequest getRequiredKeysRequest);

    @POST("v1/chain/push_transaction")
    public Call<PushTransactionResponse> pushTransaction(@Body PushTransactionRequest pushTransactionRequest);
    //endregion

    //region Extra APIs
    // Chain APIs
    @POST("v1/chain/get_account")
    public Call<ResponseBody> getAccount(@Body RequestBody requestBody);

    @POST("v1/chain/push_transactions")
    public Call<ResponseBody> pushTransactions(@Body RequestBody requestBody);

    @POST("v1/chain/get_block_header_state")
    public Call<ResponseBody> getBlockHeaderState(@Body RequestBody requestBody);

    @POST("v1/chain/get_abi")
    public Call<ResponseBody> getAbi(@Body RequestBody requestBody);

    @POST("v1/chain/get_currency_balance")
    public Call<ResponseBody> getCurrencyBalance(@Body RequestBody requestBody);

    @POST("v1/chain/get_currency_stats")
    public Call<ResponseBody> getCurrencyStats(@Body RequestBody requestBody);

    @POST("v1/chain/get_producers")
    public Call<ResponseBody> getProducers(@Body RequestBody requestBody);

    @POST("v1/chain/get_raw_code_and_abi")
    public Call<ResponseBody> getRawCodeAndAbi(@Body RequestBody requestBody);

    @POST("v1/chain/get_table_by_scope")
    public Call<ResponseBody> getTableByScope(@Body RequestBody requestBody);

    @POST("v1/chain/get_table_rows")
    public Call<ResponseBody> getTableRows(@Body RequestBody requestBody);

    @POST("v1/chain/get_code")
    public Call<ResponseBody> getCode(@Body RequestBody requestBody);

    //History APIs

    @POST("v1/history/get_actions")
    public Call<ResponseBody> getActions(@Body RequestBody requestBody);

    @POST("v1/history/get_transaction")
    public Call<ResponseBody> getTransaction(@Body RequestBody requestBody);

    @POST("v1/history/get_key_accounts")
    public Call<ResponseBody> getKeyAccounts(@Body RequestBody requestBody);

    @POST("v1/history/get_controlled_accounts")
    public Call<ResponseBody> getControlledAccounts(@Body RequestBody requestBody);

    //endregion
}
