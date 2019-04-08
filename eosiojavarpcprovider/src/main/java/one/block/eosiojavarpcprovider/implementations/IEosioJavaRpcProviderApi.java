package one.block.eosiojavarpcprovider.implementations;
//
// IEosioJavaRpcProviderApi
// eosio-java-android-rpc-provider
//
// Created by mccoole on 4/5/19
// Copyright © 2017-2019 block.one.
//

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

}
