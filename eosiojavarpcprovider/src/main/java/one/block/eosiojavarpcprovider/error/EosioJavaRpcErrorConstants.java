package one.block.eosiojavarpcprovider.error;
//
// Copyright © 2017-2019 block.one.
//

/**
 * Error constants used in error messages thrown by the RPC Provider.
 */
public class EosioJavaRpcErrorConstants {

    // region EosioRpcProvderImpl errors

    public static final String RPC_PROVIDER_BASE_URL_EMPTY = "Base URL cannot be empty or null.";
    public static final String RPC_PROVIDER_ERROR_GETTING_CHAIN_INFO = "Error retrieving chain information.";
    public static final String RPC_PROVIDER_ERROR_GETTING_BLOCK_INFO = "Error retrieving block information.";
    public static final String RPC_PROVIDER_ERROR_GETTING_RAW_ABI = "Error retrieving raw ABI.";
    public static final String RPC_PROVIDER_ERROR_GETTING_REQUIRED_KEYS = "Error retrieving required keys.";
    public static final String RPC_PROVIDER_ERROR_PUSHING_TRANSACTION = "Error pushing transaction.";
    public static final String RPC_PROVIDER_ERROR_PUSHING_TRANSACTIONS = "Error pushing transactions.";
    public static final String RPC_PROVIDER_ERROR_GET_ACCOUNT = "Error get account.";
    public static final String RPC_PROVIDER_ERROR_GET_BLOCK_HEADER_STATE = "Error get block header state.";
    public static final String RPC_PROVIDER_ERROR_GET_ABI = "Error get abi.";
    public static final String RPC_PROVIDER_ERROR_GET_CURRENT_BALANCE = "Error get current balance.";
    public static final String RPC_PROVIDER_ERROR_GET_CURRENT_STATS = "Error get current stats.";
    public static final String RPC_PROVIDER_ERROR_GET_PRODUCERS = "Error get producers.";
    public static final String RPC_PROVIDER_ERROR_GET_RAW_CODE_AND_ABI = "Error get raw code and abi.";
    public static final String RPC_PROVIDER_ERROR_GET_TABLE_BY_SCOPE = "Error get table by scope.";
    public static final String RPC_PROVIDER_ERROR_GET_TABLE_ROWS = "Error get table rows.";
    public static final String RPC_PROVIDER_ERROR_GET_CODE = "Error get code.";
    public static final String RPC_PROVIDER_ERROR_GET_ACTION = "Error get action.";
    public static final String RPC_PROVIDER_ERROR_GET_TRANSACTION = "Error get transaction.";
    public static final String RPC_PROVIDER_ERROR_GET_KEY_ACCOUNTS = "Error get key accounts.";
    public static final String RPC_PROVIDER_ERROR_GET_CONTROLLED_ACCOUNTS = "Error get controlled accounts.";

    public static final String RPC_PROVIDER_BAD_STATUS_CODE_RETURNED = "Bad status code: %d (%s), returned from server. Additional error information: %s";
    public static final String RPC_PROVIDER_EMPTY_RESPONSE_RETURNED = "Empty response returned from the server.";
    public static final String RPC_PROVIDER_NO_FURTHER_ERROR_INFO = "No further error information available.";
    public static final String RPC_PROVIDER_SEE_FURTHER_ERROR_INFO = "See further error information in RPCProviderError.";

    // endregion

}
