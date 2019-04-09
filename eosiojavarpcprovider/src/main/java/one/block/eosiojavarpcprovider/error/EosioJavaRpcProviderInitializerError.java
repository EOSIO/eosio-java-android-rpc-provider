package one.block.eosiojavarpcprovider.error;

import one.block.eosiojava.error.rpcProvider.RpcProviderError;
import org.jetbrains.annotations.NotNull;

//
// Copyright © 2017-2019 block.one.
//

/**
 * Error thrown when there is an issue initializing the RPC Provider.
 */
public class EosioJavaRpcProviderInitializerError extends RpcProviderError {

    public EosioJavaRpcProviderInitializerError() {
    }

    public EosioJavaRpcProviderInitializerError(
            @NotNull String message) {
        super(message);
    }

    public EosioJavaRpcProviderInitializerError(
            @NotNull String message,
            @NotNull Exception exception) {
        super(message, exception);
    }

    public EosioJavaRpcProviderInitializerError(
            @NotNull Exception exception) {
        super(exception);
    }

}
