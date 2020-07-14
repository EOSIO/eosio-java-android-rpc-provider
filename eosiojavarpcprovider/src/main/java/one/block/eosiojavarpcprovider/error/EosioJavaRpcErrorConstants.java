package one.block.eosiojavarpcprovider.error;
//
// Copyright © 2017-2019 block.one.
//

import okhttp3.RequestBody;
import one.block.eosiojava.models.rpcProvider.request.GetBlockRequest;
import one.block.eosiojava.models.rpcProvider.request.GetRawAbiRequest;
import one.block.eosiojava.models.rpcProvider.request.GetRequiredKeysRequest;
import one.block.eosiojava.models.rpcProvider.request.PushTransactionRequest;
import one.block.eosiojava.models.rpcProvider.request.SendTransactionRequest;
import one.block.eosiojava.models.rpcProvider.response.RPCResponseError;
import one.block.eosiojavarpcprovider.implementations.EosioJavaRpcProviderImpl;

/**
 * Error constants used in error messages thrown by the RPC Provider.
 */
public class EosioJavaRpcErrorConstants {

    // region EosioRpcProvderImpl errors

    /**
     * Error message gets thrown if input Base URL is empty.
     */
    public static final String RPC_PROVIDER_BASE_URL_EMPTY = "Base URL cannot be empty or null.";

    /**
     * Error message gets thrown if {@link EosioJavaRpcProviderImpl#getInfo()} returns error.
     */
    public static final String RPC_PROVIDER_ERROR_GETTING_CHAIN_INFO = "Error retrieving chain information.";

    /**
     * Error message gets thrown if {@link EosioJavaRpcProviderImpl#getBlock(GetBlockRequest)} returns error.
     */
    public static final String RPC_PROVIDER_ERROR_GETTING_BLOCK_INFO = "Error retrieving block information.";

    /**
     * Error message gets thrown if {@link EosioJavaRpcProviderImpl#getRawAbi(GetRawAbiRequest)} returns error.
     */
    public static final String RPC_PROVIDER_ERROR_GETTING_RAW_ABI = "Error retrieving raw ABI.";

    /**
     * Error message gets thrown if {@link EosioJavaRpcProviderImpl#getRequiredKeys(GetRequiredKeysRequest)} returns error.
     */
    public static final String RPC_PROVIDER_ERROR_GETTING_REQUIRED_KEYS = "Error retrieving required keys.";

    /**
     * Error message gets thrown if {@link EosioJavaRpcProviderImpl#pushTransaction(PushTransactionRequest)} returns error.
     */
    public static final String RPC_PROVIDER_ERROR_PUSHING_TRANSACTION = "Error pushing transaction.";

    /**
     * Error message gets thrown if {@link EosioJavaRpcProviderImpl#sendTransaction(SendTransactionRequest)} returns error.
     */
    public static final String RPC_PROVIDER_ERROR_SENDING_TRANSACTION = "Error sending transaction.";

    /**
     * Error message gets thrown if {@link EosioJavaRpcProviderImpl#pushTransactions(RequestBody)} returns error.
     */
    public static final String RPC_PROVIDER_ERROR_PUSHING_TRANSACTIONS = "Error pushing transactions.";

    /**
     * Error message gets thrown if {@link EosioJavaRpcProviderImpl#getAccount(RequestBody)} returns error.
     */
    public static final String RPC_PROVIDER_ERROR_GET_ACCOUNT = "Error get account.";

    /**
     * Error message gets thrown if {@link EosioJavaRpcProviderImpl#getBlock(GetBlockRequest)} returns error.
     */
    public static final String RPC_PROVIDER_ERROR_GET_BLOCK_HEADER_STATE = "Error get block header state.";

    /**
     * Error message gets thrown if {@link EosioJavaRpcProviderImpl#getAbi(RequestBody)} returns error.
     */
    public static final String RPC_PROVIDER_ERROR_GET_ABI = "Error get abi.";

    /**
     * Error message gets thrown if {@link EosioJavaRpcProviderImpl#getCurrencyBalance(RequestBody)} returns error.
     */
    public static final String RPC_PROVIDER_ERROR_GET_CURRENT_BALANCE = "Error get current balance.";

    /**
     * Error message gets thrown if {@link EosioJavaRpcProviderImpl#getCurrencyStats(RequestBody)} returns error.
     */
    public static final String RPC_PROVIDER_ERROR_GET_CURRENT_STATS = "Error get current stats.";

    /**
     * Error message gets thrown if {@link EosioJavaRpcProviderImpl#getProducers(RequestBody)} returns error.
     */
    public static final String RPC_PROVIDER_ERROR_GET_PRODUCERS = "Error get producers.";

    /**
     * Error message gets thrown if {@link EosioJavaRpcProviderImpl#getRawCodeAndAbi(RequestBody)} returns error.
     */
    public static final String RPC_PROVIDER_ERROR_GET_RAW_CODE_AND_ABI = "Error get raw code and abi.";

    /**
     * Error message gets thrown if {@link EosioJavaRpcProviderImpl#getTableByScope(RequestBody)} returns error.
     */
    public static final String RPC_PROVIDER_ERROR_GET_TABLE_BY_SCOPE = "Error get table by scope.";

    /**
     * Error message gets thrown if {@link EosioJavaRpcProviderImpl#getTableRows(RequestBody)} returns error.
     */
    public static final String RPC_PROVIDER_ERROR_GET_TABLE_ROWS = "Error get table rows.";

    /**
     * Error message gets thrown if {@link EosioJavaRpcProviderImpl#getCode(RequestBody)} returns error.
     */
    public static final String RPC_PROVIDER_ERROR_GET_CODE = "Error get code.";

    /**
     * Error message gets thrown if {@link EosioJavaRpcProviderImpl#getActions(RequestBody)} returns error.
     */
    public static final String RPC_PROVIDER_ERROR_GET_ACTION = "Error get action.";

    /**
     * Error message gets thrown if {@link EosioJavaRpcProviderImpl#getTransaction(RequestBody)} returns error.
     */
    public static final String RPC_PROVIDER_ERROR_GET_TRANSACTION = "Error get transaction.";

    /**
     * Error message gets thrown if {@link EosioJavaRpcProviderImpl#getKeyAccounts(RequestBody)} returns error.
     */
    public static final String RPC_PROVIDER_ERROR_GET_KEY_ACCOUNTS = "Error get key accounts.";

    /**
     * Error message gets thrown if {@link EosioJavaRpcProviderImpl#getControlledAccounts(RequestBody)} returns error.
     */
    public static final String RPC_PROVIDER_ERROR_GET_CONTROLLED_ACCOUNTS = "Error get controlled accounts.";

    /**
     * Error message gets thrown if RPC call returns bad status code from server.
     */
    public static final String RPC_PROVIDER_BAD_STATUS_CODE_RETURNED = "Bad status code: %d (%s), returned from server. Additional error information: %s";

    /**
     * Error message gets thrown if RPC call returns empty response.
     */
    public static final String RPC_PROVIDER_EMPTY_RESPONSE_RETURNED = "Empty response returned from the server.";

    /**
     * Default error message for failed RPC call if there is no expected error return.
     */
    public static final String RPC_PROVIDER_NO_FURTHER_ERROR_INFO = "No further error information available.";

    /**
     * Error message is a reference to {@link RPCResponseError} for additional information.
     */
    public static final String RPC_PROVIDER_SEE_FURTHER_ERROR_INFO = "See further error information in RPCProviderError.";

    // endregion

}
