package one.block.eosiojavarpcprovider.error;

import one.block.eosiojava.error.rpcProvider.RpcProviderError;
import org.jetbrains.annotations.NotNull;

//
// EosioJavaRpcProviderCallError
// eosio-java-android-rpc-provider
//
// Created by mccoole on 4/8/19
// Copyright © 2017-2019 block.one.
//

/**
 * Error thrown when there is a lower level processing error sending or receiving an RPC call.
 */
public class EosioJavaRpcProviderCallError extends RpcProviderError {

    public EosioJavaRpcProviderCallError() {
    }

    public EosioJavaRpcProviderCallError(@NotNull String message) {
        super(message);
    }

    public EosioJavaRpcProviderCallError(@NotNull String message,
            @NotNull Exception exception) {
        super(message, exception);
    }

    public EosioJavaRpcProviderCallError(
            @NotNull Exception exception) {
        super(exception);
    }
}
