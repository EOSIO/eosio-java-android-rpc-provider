package one.block.eosiojavarpcprovider;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import okhttp3.RequestBody;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.SocketPolicy;
import one.block.eosiojava.error.rpcProvider.GetBlockRpcError;
import one.block.eosiojava.models.rpcProvider.Action;
import one.block.eosiojava.models.rpcProvider.Authorization;
import one.block.eosiojava.models.rpcProvider.Transaction;
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
import one.block.eosiojavarpcprovider.error.EosioJavaRpcProviderCallError;
import one.block.eosiojavarpcprovider.implementations.EosioJavaRpcProviderImpl;

import static one.block.eosiojavarpcprovider.RpcTestConstants.*;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private JSONParser parser;

    @Before
    public void setup() {
        this.parser = new JSONParser();
    }

    @Test
    public void getInfoTest() {

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(200).setBody(GET_INFO_RESPONSE));

        try {
            server.start();
            String baseUrl = server.url("/").toString();

            EosioJavaRpcProviderImpl rpcProvider = new EosioJavaRpcProviderImpl(
                    baseUrl);
            GetInfoResponse response = rpcProvider.getInfo();
            assertNotNull(response);
            assertEquals("687fa513e18843ad3e820744f4ffcf93b1354036d80737db8dc444fe4b15ad17",
                    response.getChainId());
            assertEquals("0f6695cb", response.getServerVersion());
            assertEquals("v1.3.0", response.getServerVersionString());
        } catch (Exception ex) {
            fail("Should not get exception when calling getInfo(): " + "\n" + getStackTraceString(ex));
        } finally {
            try {
                server.shutdown();
            } catch (Exception ex) {
                // No need for anything here.
            }
        }

    }

    @Test
    public void getBlockTest() {

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(200).setBody(GET_BLOCK_RESPONSE));

        try {
            server.start();
            String baseUrl = server.url("/").toString();

            EosioJavaRpcProviderImpl rpcProvider = new EosioJavaRpcProviderImpl(
                    baseUrl);
            GetBlockRequest request = new GetBlockRequest("25260032");
            GetBlockResponse response = rpcProvider.getBlock(request);
            assertNotNull(response);
            assertEquals("0181700002e623f2bf291b86a10a5cec4caab4954d4231f31f050f4f86f26116",
                    response.getId());
            assertEquals(new BigInteger("2249927103"), response.getRefBlockPrefix());
            assertEquals("de5493939e3abdca80deeab2fc9389cc43dc1982708653cfe6b225eb788d6659",
                    response.getActionMroot());
        } catch (Exception ex) {
            fail("Should not get exception when calling getBlock(): " + ex.getLocalizedMessage()
                    + "\n" + getStackTraceString(ex));
        } finally {
            try {
                server.shutdown();
            } catch (Exception ex) {
                // No need for anything here.
            }
        }

    }

    @Test
    public void getRawAbiTest() {

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(200).setBody(GET_RAW_EOSIO_TOKEN_ABI_RESPONSE));

        try {
            server.start();
            String baseUrl = server.url("/").toString();

            EosioJavaRpcProviderImpl rpcProvider = new EosioJavaRpcProviderImpl(
                    baseUrl);
            GetRawAbiRequest request = new GetRawAbiRequest("eosio.token");
            GetRawAbiResponse response = rpcProvider.getRawAbi(request);
            assertNotNull(response);
            assertEquals("eosio.token", response.getAccountName());
            assertEquals("43864d5af0fe294d44d19c612036cbe8c098414c4a12a5a7bb0bfe7db1556248", response.getAbiHash());
            assertEquals("DmVvc2lvOjphYmkvMS4wAQxhY2NvdW50X25hbWUEbmFtZQUIdHJhbnNmZXIABARmcm9tDGFjY291bnRfbmFtZQJ0bwxhY2NvdW50X25hbWUIcXVhbnRpdHkFYXNzZXQEbWVtbwZzdHJpbmcGY3JlYXRlAAIGaXNzdWVyDGFjY291bnRfbmFtZQ5tYXhpbXVtX3N1cHBseQVhc3NldAVpc3N1ZQADAnRvDGFjY291bnRfbmFtZQhxdWFudGl0eQVhc3NldARtZW1vBnN0cmluZwdhY2NvdW50AAEHYmFsYW5jZQVhc3NldA5jdXJyZW5jeV9zdGF0cwADBnN1cHBseQVhc3NldAptYXhfc3VwcGx5BWFzc2V0Bmlzc3VlcgxhY2NvdW50X25hbWUDAAAAVy08zc0IdHJhbnNmZXK8By0tLQp0aXRsZTogVG9rZW4gVHJhbnNmZXIKc3VtbWFyeTogVHJhbnNmZXIgdG9rZW5zIGZyb20gb25lIGFjY291bnQgdG8gYW5vdGhlci4KaWNvbjogaHR0cHM6Ly9jZG4udGVzdG5ldC5kZXYuYjFvcHMubmV0L3Rva2VuLXRyYW5zZmVyLnBuZyNjZTUxZWY5ZjllZWNhMzQzNGU4NTUwN2UwZWQ0OWU3NmZmZjEyNjU0MjJiZGVkMDI1NWYzMTk2ZWE1OWM4YjBjCi0tLQoKIyMgVHJhbnNmZXIgVGVybXMgJiBDb25kaXRpb25zCgpJLCB7e2Zyb219fSwgY2VydGlmeSB0aGUgZm9sbG93aW5nIHRvIGJlIHRydWUgdG8gdGhlIGJlc3Qgb2YgbXkga25vd2xlZGdlOgoKMS4gSSBjZXJ0aWZ5IHRoYXQge3txdWFudGl0eX19IGlzIG5vdCB0aGUgcHJvY2VlZHMgb2YgZnJhdWR1bGVudCBvciB2aW9sZW50IGFjdGl2aXRpZXMuCjIuIEkgY2VydGlmeSB0aGF0LCB0byB0aGUgYmVzdCBvZiBteSBrbm93bGVkZ2UsIHt7dG99fSBpcyBub3Qgc3VwcG9ydGluZyBpbml0aWF0aW9uIG9mIHZpb2xlbmNlIGFnYWluc3Qgb3RoZXJzLgozLiBJIGhhdmUgZGlzY2xvc2VkIGFueSBjb250cmFjdHVhbCB0ZXJtcyAmIGNvbmRpdGlvbnMgd2l0aCByZXNwZWN0IHRvIHt7cXVhbnRpdHl9fSB0byB7e3RvfX0uCgpJIHVuZGVyc3RhbmQgdGhhdCBmdW5kcyB0cmFuc2ZlcnMgYXJlIG5vdCByZXZlcnNpYmxlIGFmdGVyIHRoZSB7eyR0cmFuc2FjdGlvbi5kZWxheV9zZWN9fSBzZWNvbmRzIG9yIG90aGVyIGRlbGF5IGFzIGNvbmZpZ3VyZWQgYnkge3tmcm9tfX0ncyBwZXJtaXNzaW9ucy4KCklmIHRoaXMgYWN0aW9uIGZhaWxzIHRvIGJlIGlycmV2ZXJzaWJseSBjb25maXJtZWQgYWZ0ZXIgcmVjZWl2aW5nIGdvb2RzIG9yIHNlcnZpY2VzIGZyb20gJ3t7dG99fScsIEkgYWdyZWUgdG8gZWl0aGVyIHJldHVybiB0aGUgZ29vZHMgb3Igc2VydmljZXMgb3IgcmVzZW5kIHt7cXVhbnRpdHl9fSBpbiBhIHRpbWVseSBtYW5uZXIuAAAAAAClMXYFaXNzdWUAAAAAAKhs1EUGY3JlYXRlAAIAAAA4T00RMgNpNjQBCGN1cnJlbmN5AQZ1aW50NjQHYWNjb3VudAAAAAAAkE3GA2k2NAEIY3VycmVuY3kBBnVpbnQ2NA5jdXJyZW5jeV9zdGF0cwAAAAA==",
                    response.getAbi());
        } catch (Exception ex) {
            fail("Should not get exception when calling getRawAbi(): " + ex.getLocalizedMessage()
                    + "\n" + getStackTraceString(ex));
        } finally {
            try {
                server.shutdown();
            } catch (Exception ex) {
                // No need for anything here.
            }
        }

    }

    @Test
    public void getRequiredKeysTest() {

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(200).setBody(GET_REQUIRED_KEYS_RESPONSE));

        try {
            server.start();
            String baseUrl = server.url("/").toString();

            EosioJavaRpcProviderImpl rpcProvider = new EosioJavaRpcProviderImpl(
                    baseUrl);

            GetRequiredKeysRequest request = new GetRequiredKeysRequest(availableKeys(), transactionForRequiredKeys());
            GetRequiredKeysResponse response = rpcProvider.getRequiredKeys(request);
            assertNotNull(response);
            assertFalse(response.getRequiredKeys().isEmpty());
            assertNotNull(response.getRequiredKeys().get(0));
            assertEquals("EOS5j67P1W2RyBXAL8sNzYcDLox3yLpxyrxgkYy1xsXzVCvzbYpba",
                    response.getRequiredKeys().get(0));
        } catch (Exception ex) {
            fail("Should not get exception when calling getRequiredKeys(): " + ex.getLocalizedMessage()
                    + "\n" + getStackTraceString(ex));
        } finally {
            try {
                server.shutdown();
            } catch (Exception ex) {
                // No need for anything here.
            }
        }

    }

    @Test
    public void pushTransactionTest() {

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(200).setBody(PUSH_TRANSACTION_RESPONSE));

        try {
            server.start();
            String baseUrl = server.url("/").toString();

            EosioJavaRpcProviderImpl rpcProvider = new EosioJavaRpcProviderImpl(
                    baseUrl);

            List<String> signatures = new ArrayList<>();
            signatures.add("SIG_K1_JzFA9ffefWfrTBvpwMwZi81kR6tvHF4mfsRekVXrBjLWWikg9g1FrS9WupYuoGaRew5mJhr4d39tHUjHiNCkxamtEfxi68");
            PushTransactionRequest request = new PushTransactionRequest(signatures,
                    0,
                    "",
                    "C62A4F5C1CEF3D6D71BD000000000290AFC2D800EA3055000000405DA7ADBA0072CBDD956F52ACD910C3C958136D72F8560D1846BC7CF3157F5FBFB72D3001DE4597F4A1FDBECDA6D59C96A43009FC5E5D7B8F639B1269C77CEC718460DCC19CB30100A6823403EA3055000000572D3CCDCD0143864D5AF0FE294D44D19C612036CBE8C098414C4A12A5A7BB0BFE7DB155624800A6823403EA3055000000572D3CCDCD0100AEAA4AC15CFD4500000000A8ED32323B00AEAA4AC15CFD4500000060D234CD3DA06806000000000004454F53000000001A746865206772617373686F70706572206C69657320686561767900");
            PushTransactionResponse response = rpcProvider.pushTransaction(request);
            assertNotNull(response);
            assertEquals("ae735820e26a7b771e1b522186294d7cbba035d0c31ca88237559d6c0a3bf00a",
                    response.getTransactionId());
        } catch (Exception ex) {
            fail("Should not get exception when calling pushTransaction(): " + ex.getLocalizedMessage()
                    + "\n" + getStackTraceString(ex));
        } finally {
            try {
                server.shutdown();
            } catch (Exception ex) {
                // No need for anything here.
            }
        }

    }

    @Test
    public void pushTransactionErrorTest() {

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(500).setBody(PUSH_TRANSACTION_ERROR_RESPONSE));

        try {
            server.start();
            String baseUrl = server.url("/").toString();

            EosioJavaRpcProviderImpl rpcProvider = new EosioJavaRpcProviderImpl(
                    baseUrl);

            List<String> signatures = new ArrayList<>();
            signatures.add("SIG_K1_JzFA9ffefWfrTBvpwMwZi81kR6tvHF4mfsRekVXrBjLWWikg9g1FrS9WupYuoGaRew5mJhr4d39tHUjHiNCkxamtEfxi68");
            PushTransactionRequest request = new PushTransactionRequest(signatures,
                    0,
                    "",
                    "C62A4F5C1CEF3D6D71BD000000000290AFC2D800EA3055000000405DA7ADBA0072CBDD956F52ACD910C3C958136D72F8560D1846BC7CF3157F5FBFB72D3001DE4597F4A1FDBECDA6D59C96A43009FC5E5D7B8F639B1269C77CEC718460DCC19CB30100A6823403EA3055000000572D3CCDCD0143864D5AF0FE294D44D19C612036CBE8C098414C4A12A5A7BB0BFE7DB155624800A6823403EA3055000000572D3CCDCD0100AEAA4AC15CFD4500000000A8ED32323B00AEAA4AC15CFD4500000060D234CD3DA06806000000000004454F53000000001A746865206772617373686F70706572206C69657320686561767900");
            PushTransactionResponse response = rpcProvider.pushTransaction(request);
            fail("Push transaction should not succeed.");
        } catch (Exception ex) {
            assertEquals("Error pushing transaction.", ex.getLocalizedMessage());
            assertNotNull(ex.getCause());
            assertEquals("Bad status code: 500 (Server Error), returned from server. Additional error information: See further error information in RPCProviderError.", ex.getCause().getMessage());
            RPCResponseError rpcResponseError = ((EosioJavaRpcProviderCallError)ex.getCause()).getRpcResponseError();
            assertNotNull(rpcResponseError);
            assertEquals(new BigInteger("500"), rpcResponseError.getCode());
            assertEquals("Internal Service Error", rpcResponseError.getMessage());
            RpcError rpcError = rpcResponseError.getError();
            assertNotNull(rpcError);
            assertEquals(new BigInteger("3040005"), rpcError.getCode());
            assertEquals("Expired Transaction", rpcError.getWhat());
        } finally {
            try {
                server.shutdown();
            } catch (Exception ex) {
                // No need for anything here.
            }
        }

    }

    @Test
    public void getInfoTimeoutTest() {

        MockWebServer server = new MockWebServer();
        MockResponse mockResponse = new MockResponse().setResponseCode(200).setBody(GET_INFO_RESPONSE);
        // This will cause the call to time out.
        mockResponse.setSocketPolicy(SocketPolicy.NO_RESPONSE);
        server.enqueue(mockResponse);

        try {
            server.start();
            String baseUrl = server.url("/").toString();

            EosioJavaRpcProviderImpl rpcProvider = new EosioJavaRpcProviderImpl(
                    baseUrl);
            GetInfoResponse response = rpcProvider.getInfo();
            fail("Should not succeed when calling getInfo().  Should time out.");
        } catch (Exception ex) {
            assertEquals("Error retrieving chain information.", ex.getMessage());
            assertNotNull(ex.getCause());
            assertTrue(ex.getCause() instanceof SocketTimeoutException);
            assertEquals("timeout", ex.getCause().getMessage());
        } finally {
            try {
                server.shutdown();
            } catch (Exception ex) {
                // No need for anything here.
            }
        }

    }

    // Is this test necessary?
//    @Test
//    public void getBlockAsyncTest() {
//
//        // This test shows how an RPC provider call might be made asynchronously.
//
//        final CountDownLatch testLock = new CountDownLatch(1);
//
//        MockWebServer server = new MockWebServer();
//        server.enqueue(new MockResponse().setResponseCode(200).setBody(GET_BLOCK_RESPONSE));
//
//        try {
//            server.start();
//            String baseUrl = server.url("/").toString();
//
//            final EosioJavaRpcProviderImpl rpcProvider = new EosioJavaRpcProviderImpl(
//                    baseUrl);
//            GetBlockRequest[] request = { new GetBlockRequest("25260032") };
//
//            AsyncTask<GetBlockRequest, Void, GetBlockResponse> asyncTask = new AsyncTask<GetBlockRequest, Void, GetBlockResponse>() {
//                GetBlockRpcError getBlockError = null;
//                @Override
//                protected GetBlockResponse doInBackground(GetBlockRequest... getBlockRequests) {
//                    // Here we are on a background thread.
//                    GetBlockResponse response = null;
//                    try {
//                        response = rpcProvider.getBlock(getBlockRequests[0]);
//                    } catch (GetBlockRpcError err) {
//                        getBlockError = err;
//                    }
//                    return response;
//                }
//
//                protected void onPostExecute(GetBlockResponse response) {
//                    // Here we are back on the main thread and could update the UI.
//                    assertNotNull(response);
//                    assertEquals("0181700002e623f2bf291b86a10a5cec4caab4954d4231f31f050f4f86f26116",
//                            response.getId());
//                    assertEquals(new BigInteger("2249927103"), response.getRefBlockPrefix());
//                    assertEquals("de5493939e3abdca80deeab2fc9389cc43dc1982708653cfe6b225eb788d6659",
//                            response.getActionMroot());
//                    testLock.countDown();
//                }
//            }.execute(request);
//
//            try {
//                testLock.await(5000, TimeUnit.MILLISECONDS);
//            } catch (InterruptedException interruptedException) {
//                fail("Interrupted waiting for getBlock() to complete: " +
//                        interruptedException.getLocalizedMessage());
//            }
//
//        } catch (Exception ex) {
//            fail("Should not get exception when calling getBlock(): " + ex.getLocalizedMessage());
//        } finally {
//            try {
//                server.shutdown();
//            } catch (Exception ex) {
//                // No need for anything here.
//            }
//        }
//
//    }

    @Test
    public void testGetAccountRpcCall() {
        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(200).setBody(GET_ACCOUNT_RESPONSE));

        try {
            server.start();
            String baseUrl = server.url("/").toString();

            EosioJavaRpcProviderImpl rpcProvider = new EosioJavaRpcProviderImpl(
                    baseUrl);
            String testAccount = "test_account";

            RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), "{\"name\":\""+testAccount+"\"}");
            String response = rpcProvider.getAccount(requestBody);
            assertNotNull(response);

            JSONObject jsonObject = (JSONObject)parser.parse(response);

            assertEquals(testAccount, jsonObject.get("account_name"));
        } catch (Exception ex) {
            fail("Should not get exception when calling getAccount(): " + ex.getLocalizedMessage()
                    + "\n" + getStackTraceString(ex));
        } finally {
            try {
                server.shutdown();
            } catch (Exception ex) {
                // No need for anything here.
            }
        }
    }

    @Test
    public void testPushTransactionsRpcCall() {
        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(200).setBody(PUSH_TRANSACTIONS_RESPONSE));

        try {
            server.start();
            String baseUrl = server.url("/").toString();

            EosioJavaRpcProviderImpl rpcProvider = new EosioJavaRpcProviderImpl(
                    baseUrl);

            RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), PUSH_TRANSACTIONS_REQUEST);
            String response = rpcProvider.pushTransactions(requestBody);
            assertNotNull(response);

            JSONArray jsonArray = (JSONArray)parser.parse(response);
            assertEquals(2, jsonArray.size());
            JSONObject firstObject = (JSONObject)jsonArray.get(0);
            JSONObject secondObject = (JSONObject)jsonArray.get(1);
            assertEquals("ae735820e26a7b771e1b522186294d7cbba035d0c31ca88237559d6c0a3bf00a", firstObject.get("transaction_id"));
            assertEquals("ae735820e26a7b771e1b522186294d7cbba035d0c31ca88237559d6c0a3bf00a", secondObject.get("transaction_id"));
        } catch (Exception ex) {
            fail("Should not get exception when calling pushTransactions(): " + ex.getLocalizedMessage()
                    + "\n" + getStackTraceString(ex));
        } finally {
            try {
                server.shutdown();
            } catch (Exception ex) {
                // No need for anything here.
            }
        }
    }

    @Test
    public void testGetBlockHeaderStateRpcCall() {
        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(200).setBody(GET_BLOCK_HEADER_STATE_RESPONSE));

        try {
            server.start();
            String baseUrl = server.url("/").toString();

            EosioJavaRpcProviderImpl rpcProvider = new EosioJavaRpcProviderImpl(
                    baseUrl);

            RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), GET_BLOCK_HEADER_STATE_REQUEST);
            String response = rpcProvider.getBlockHeaderState(requestBody);
            assertNotNull(response);

            JSONObject jsonObject = (JSONObject)parser.parse(response);
            assertEquals("020c00e41e66ca6a0fa489c9b2df391fd06089426a3daed5e4859cebc1d41b73", jsonObject.get("id"));
        } catch (Exception ex) {
            fail("Should not get exception when calling getBlockHeaderState(): " + ex.getLocalizedMessage()
                    + "\n" + getStackTraceString(ex));
        } finally {
            try {
                server.shutdown();
            } catch (Exception ex) {
                // No need for anything here.
            }
        }
    }

    @Test
    public void testGetAbiRpcCall() {
        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(200).setBody(GET_ABI_RESPONSE));

        try {
            server.start();
            String baseUrl = server.url("/").toString();

            EosioJavaRpcProviderImpl rpcProvider = new EosioJavaRpcProviderImpl(
                    baseUrl);

            RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), GET_ABI_REQUEST);
            String response = rpcProvider.getAbi(requestBody);
            assertNotNull(response);

            JSONObject jsonObject = (JSONObject)parser.parse(response);
            assertEquals("eosio.token", jsonObject.get("account_name"));
        } catch (Exception ex) {
            fail("Should not get exception when calling getAbi(): " + ex.getLocalizedMessage()
                    + "\n" + getStackTraceString(ex));
        } finally {
            try {
                server.shutdown();
            } catch (Exception ex) {
                // No need for anything here.
            }
        }
    }

    @Test
    public void testGetCurrencyBalanceRpcCall() {
        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(200).setBody(GET_CURRENT_BALANCE_RESPONSE));

        try {
            server.start();
            String baseUrl = server.url("/").toString();

            EosioJavaRpcProviderImpl rpcProvider = new EosioJavaRpcProviderImpl(
                    baseUrl);

            RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), GET_CURRENT_BALANCE_REQUEST);
            String response = rpcProvider.getCurrencyBalance(requestBody);
            assertNotNull(response);

            JSONArray jsonArray = (JSONArray)parser.parse(response);
            assertEquals("1.0000 EOS", jsonArray.get(0));
        } catch (Exception ex) {
            fail("Should not get exception when calling getCurrencyBalance(): " + ex.getLocalizedMessage()
                    + "\n" + getStackTraceString(ex));
        } finally {
            try {
                server.shutdown();
            } catch (Exception ex) {
                // No need for anything here.
            }
        }
    }

    @Test
    public void testGetCurrencyStatsRpcCall() {
        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(200).setBody(GET_CURRENT_STATS_RESPONSE));

        try {
            server.start();
            String baseUrl = server.url("/").toString();

            EosioJavaRpcProviderImpl rpcProvider = new EosioJavaRpcProviderImpl(
                    baseUrl);

            RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), GET_CURRENT_STATS_REQUEST);
            String response = rpcProvider.getCurrencyStats(requestBody);
            assertNotNull(response);

            JSONObject jsonObject = (JSONObject)parser.parse(response);
            JSONObject eosJsonObject = (JSONObject)jsonObject.get("EOS");
            assertEquals("100000000.0000 EOS", eosJsonObject.get("supply"));
            assertEquals("10000000000.0000 EOS", eosJsonObject.get("max_supply"));
        } catch (Exception ex) {
            fail("Should not get exception when calling getCurrencyStats(): " + ex.getLocalizedMessage()
                    + "\n" + getStackTraceString(ex));
        } finally {
            try {
                server.shutdown();
            } catch (Exception ex) {
                // No need for anything here.
            }
        }
    }

    @Test
    public void testGetProducersRpcCall() {
        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(200).setBody(GET_PRODUCER_RESPONSE));

        try {
            server.start();
            String baseUrl = server.url("/").toString();

            EosioJavaRpcProviderImpl rpcProvider = new EosioJavaRpcProviderImpl(
                    baseUrl);

            RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), GET_PRODUCER_REQUEST);
            String response = rpcProvider.getProducers(requestBody);
            assertNotNull(response);

            JSONObject jsonObject = (JSONObject)parser.parse(response);
            JSONArray rowsArray = (JSONArray)jsonObject.get("rows");
            assertEquals(2, rowsArray.size());
            JSONObject firstObject = (JSONObject)rowsArray.get(0);
            JSONObject secondObject = (JSONObject)rowsArray.get(1);
            assertEquals("blkproducer2", firstObject.get("owner"));
            assertEquals("blkproducer3", secondObject.get("owner"));
        } catch (Exception ex) {
            fail("Should not get exception when calling getProducers(): " + ex.getLocalizedMessage()
                    + "\n" + getStackTraceString(ex));
        } finally {
            try {
                server.shutdown();
            } catch (Exception ex) {
                // No need for anything here.
            }
        }
    }

    @Test
    public void testGetRawCodeAndAbiRpcCall() {
        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(200).setBody(GET_RAW_CODE_AND_ABI_RESPONSE));

        try {
            server.start();
            String baseUrl = server.url("/").toString();

            EosioJavaRpcProviderImpl rpcProvider = new EosioJavaRpcProviderImpl(
                    baseUrl);

            RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), GET_RAW_CODE_AND_ABI_REQUEST);
            String response = rpcProvider.getRawCodeAndAbi(requestBody);
            assertNotNull(response);

            JSONObject jsonObject = (JSONObject)parser.parse(response);
            assertEquals("eosio.token", jsonObject.get("account_name"));
        } catch (Exception ex) {
            fail("Should not get exception when calling getRawCodeAndAbi(): " + ex.getLocalizedMessage()
                    + "\n" + getStackTraceString(ex));
        } finally {
            try {
                server.shutdown();
            } catch (Exception ex) {
                // No need for anything here.
            }
        }
    }

    @Test
    public void testGetTableByScopeRpcCall() {
        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(200).setBody(GET_TABLE_BY_SCOPE_RESPONSE));

        try {
            server.start();
            String baseUrl = server.url("/").toString();

            EosioJavaRpcProviderImpl rpcProvider = new EosioJavaRpcProviderImpl(
                    baseUrl);

            RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), GET_TABLE_BY_SCOPE_REQUEST);
            String response = rpcProvider.getTableByScope(requestBody);
            assertNotNull(response);

            JSONObject jsonObject = (JSONObject)parser.parse(response);
            JSONArray jsonArray = (JSONArray)jsonObject.get("rows");
            assertEquals(10, jsonArray.size());
            JSONObject firstObject = (JSONObject)jsonArray.get(0);
            JSONObject secondObject = (JSONObject)jsonArray.get(1);
            JSONObject thirdObject = (JSONObject)jsonArray.get(2);
            JSONObject fourthObject = (JSONObject)jsonArray.get(3);
            assertEquals("eosio.token", firstObject.get("code"));
            assertEquals("test_account_1", firstObject.get("scope"));
            assertEquals("test_account_2", secondObject.get("scope"));
            assertEquals("test_account_7", thirdObject.get("scope"));
            assertEquals("test_account_3", fourthObject.get("scope"));
        } catch (Exception ex) {
            fail("Should not get exception when calling getTableByScope(): " + ex.getLocalizedMessage()
                    + "\n" + getStackTraceString(ex));
        } finally {
            try {
                server.shutdown();
            } catch (Exception ex) {
                // No need for anything here.
            }
        }
    }

    @Test
    public void testGetTableRowsRpcCall() {
        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(200).setBody(GET_TABLE_ROWS_RESPONSE));

        try {
            server.start();
            String baseUrl = server.url("/").toString();

            EosioJavaRpcProviderImpl rpcProvider = new EosioJavaRpcProviderImpl(
                    baseUrl);

            RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), GET_TABLE_ROWS_REQUEST);
            String response = rpcProvider.getTableRows(requestBody);
            assertNotNull(response);

            JSONObject jsonObject = (JSONObject)parser.parse(response);
            JSONArray jsonArray = (JSONArray)jsonObject.get("rows");
            assertEquals(1, jsonArray.size());
            JSONObject firstObject = (JSONObject)jsonArray.get(0);
            assertEquals("1000.0000 EOS", firstObject.get("balance"));
        } catch (Exception ex) {
            fail("Should not get exception when calling getTableRows(): " + ex.getLocalizedMessage()
                    + "\n" + getStackTraceString(ex));
        } finally {
            try {
                server.shutdown();
            } catch (Exception ex) {
                // No need for anything here.
            }
        }
    }

    @Test
    public void testGetCodeRpcCall() {
        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(200).setBody(GET_CODE_RESPONSE));

        try {
            server.start();
            String baseUrl = server.url("/").toString();

            EosioJavaRpcProviderImpl rpcProvider = new EosioJavaRpcProviderImpl(
                    baseUrl);

            RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), GET_CODE_REQUEST);
            String response = rpcProvider.getCode(requestBody);
            assertNotNull(response);

            JSONObject jsonObject = (JSONObject)parser.parse(response);
            assertEquals(new Long(500), jsonObject.get("code"));
        } catch (Exception ex) {
            fail("Should not get exception when calling getCode(): " + ex.getLocalizedMessage()
                    + "\n" + getStackTraceString(ex));
        } finally {
            try {
                server.shutdown();
            } catch (Exception ex) {
                // No need for anything here.
            }
        }
    }

    @Test
    public void testGetActionsRpcCall() {
        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(200).setBody(GET_ACTIONS_RESPONSE));

        try {
            server.start();
            String baseUrl = server.url("/").toString();

            EosioJavaRpcProviderImpl rpcProvider = new EosioJavaRpcProviderImpl(
                    baseUrl);

            RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), GET_ACTIONS_REQUEST);
            String response = rpcProvider.getActions(requestBody);
            assertNotNull(response);

            JSONObject jsonObject = (JSONObject)parser.parse(response);
            assertEquals(new Long(34394836), jsonObject.get("last_irreversible_block"));
        } catch (Exception ex) {
            fail("Should not get exception when calling getActions(): " + ex.getLocalizedMessage()
                    + "\n" + getStackTraceString(ex));
        } finally {
            try {
                server.shutdown();
            } catch (Exception ex) {
                // No need for anything here.
            }
        }
    }

    @Test
    public void testGetTransactionRpcCall() {
        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(200).setBody(GET_TRANSACTION_RESPONSE));

        try {
            server.start();
            String baseUrl = server.url("/").toString();

            EosioJavaRpcProviderImpl rpcProvider = new EosioJavaRpcProviderImpl(
                    baseUrl);

            RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), GET_TRANSACTION_REQUEST);
            String response = rpcProvider.getTransaction(requestBody);
            assertNotNull(response);

            JSONObject jsonObject = (JSONObject)parser.parse(response);
            assertEquals("transaction id", jsonObject.get("id"));
            assertEquals(new Long(49420058), jsonObject.get("block_num"));
        } catch (Exception ex) {
            fail("Should not get exception when calling getTransaction(): " + ex.getLocalizedMessage()
                    + "\n" + getStackTraceString(ex));
        } finally {
            try {
                server.shutdown();
            } catch (Exception ex) {
                // No need for anything here.
            }
        }
    }

    @Test
    public void testGetKeyAccountsRpcCall() {
        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(200).setBody(GET_KEY_ACCOUNTS_RESPONSE));

        try {
            server.start();
            String baseUrl = server.url("/").toString();

            EosioJavaRpcProviderImpl rpcProvider = new EosioJavaRpcProviderImpl(
                    baseUrl);

            RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), GET_KEY_ACCOUNTS_REQUEST);
            String response = rpcProvider.getKeyAccounts(requestBody);
            assertNotNull(response);

            JSONObject jsonObject = (JSONObject)parser.parse(response);
            JSONArray jsonArray = (JSONArray)jsonObject.get("account_names");
            assertEquals(1, jsonArray.size());
            assertEquals("test_account", jsonArray.get(0));
        } catch (Exception ex) {
            fail("Should not get exception when calling getKeyAccounts(): " + ex.getLocalizedMessage()
                    + "\n" + getStackTraceString(ex));
        } finally {
            try {
                server.shutdown();
            } catch (Exception ex) {
                // No need for anything here.
            }
        }
    }

    @Test
    public void testGetControlledAccountsRpcCall() {
        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(200).setBody(GET_CONTROLLED_ACCOUNTS_RESPONSE));

        try {
            server.start();
            String baseUrl = server.url("/").toString();

            EosioJavaRpcProviderImpl rpcProvider = new EosioJavaRpcProviderImpl(
                    baseUrl);

            RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), GET_CONTROLLED_ACCOUNTS_REQUEST);
            String response = rpcProvider.getControlledAccounts(requestBody);
            assertNotNull(response);

            JSONObject jsonObject = (JSONObject)parser.parse(response);
            JSONArray jsonArray = (JSONArray)jsonObject.get("controlled_accounts");
            assertEquals(0, jsonArray.size());
        } catch (Exception ex) {
            fail("Should not get exception when calling getControlledAccounts(): " + ex.getLocalizedMessage()
                    + "\n" + getStackTraceString(ex));
        } finally {
            try {
                server.shutdown();
            } catch (Exception ex) {
                // No need for anything here.
            }
        }
    }

    private String getStackTraceString(Exception ex) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ex.printStackTrace(printWriter);
        return stringWriter.toString();
    }

    private List<String> availableKeys() {

        List<String> availableKeys = new ArrayList<>();
        availableKeys.add("PUB_K1_5j67P1W2RyBXAL8sNzYcDLox3yLpxyrxgkYy1xsXzVCw1oi9eG");
        return availableKeys;

    }

    private Transaction transactionForRequiredKeys() {
        List<Authorization> authList = new ArrayList<>();
        authList.add(new Authorization("cryptkeeper", "active"));

        List<Action> actionList = new ArrayList<>();
        Action action = new Action("eosio.token",
                "transfer",
                authList,
                "00AEAA4AC15CFD4500000060D234CD3DA06806000000000004454F53000000001A746865206772617373686F70706572206C696573206865617679"
        );
        actionList.add(action);

        Transaction transaction = new Transaction(
                "2019-01-25T22:13:55",
                new BigInteger("44503"),
                new BigInteger("1776994640"),
                BigInteger.ZERO,
                BigInteger.ZERO,
                BigInteger.ZERO,
                new ArrayList<Action>(),
                actionList,
                new ArrayList<String>()
        );

        return transaction;
    }
}