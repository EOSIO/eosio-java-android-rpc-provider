package one.block.eosiojavarpcprovider;

public class RpcTestConstants {

    public static final String GET_INFO_RESPONSE = "{\n"
            + "    \"server_version\": \"0f6695cb\",\n"
            + "    \"chain_id\": \"687fa513e18843ad3e820744f4ffcf93b1354036d80737db8dc444fe4b15ad17\",\n"
            + "    \"head_block_num\": 20583056,\n"
            + "    \"last_irreversible_block_num\": 20583039,\n"
            + "    \"last_irreversible_block_id\": \"013a127fab9a79403a20b55914cdc7e1ac136618387325ad3c1914d27528a1f1\",\n"
            + "    \"head_block_id\": \"013a129048f4486ce8a5ac8380870a8ce1bcbd4ff45b40fd0792503dc44c427d\",\n"
            + "    \"head_block_time\": \"2019-01-25T16:39:38.000\",\n"
            + "    \"head_block_producer\": \"blkproducer1\",\n"
            + "    \"virtual_block_cpu_limit\": 200000000,\n"
            + "    \"virtual_block_net_limit\": 1048576000,\n"
            + "    \"block_cpu_limit\": 199900,\n"
            + "    \"block_net_limit\": 1048576,\n"
            + "    \"server_version_string\": \"v1.3.0\"\n"
            + "}";

    public static final String GET_BLOCK_RESPONSE = "{\n"
            + "    \"timestamp\": \"2019-02-21T18:31:40.000\",\n"
            + "    \"producer\": \"blkproducer2\",\n"
            + "    \"confirmed\": 0,\n"
            + "    \"previous\": \"01816fffa4548475add3c45d0e0620f59468a6817426137b37851c23ccafa9cc\",\n"
            + "    \"transaction_mroot\": \"0000000000000000000000000000000000000000000000000000000000000000\",\n"
            + "    \"action_mroot\": \"de5493939e3abdca80deeab2fc9389cc43dc1982708653cfe6b225eb788d6659\",\n"
            + "    \"schedule_version\": 3,\n"
            + "    \"new_producers\": null,\n"
            + "    \"header_extensions\": [],\n"
            + "    \"producer_signature\": \"SIG_K1_KZ3ptku7orAgcyMzd9FKW4jPC9PvjW9BGadFoyxdJFWM44VZdjW28DJgDe6wkNHAxnpqCWSzaBHB1AfbXBUn3HDzetemoA\",\n"
            + "    \"transactions\": [],\n"
            + "    \"block_extensions\": [],\n"
            + "    \"id\": \"0181700002e623f2bf291b86a10a5cec4caab4954d4231f31f050f4f86f26116\",\n"
            + "    \"block_num\": 25260032,\n"
            + "    \"ref_block_prefix\": 2249927103\n"
            + "}";

    public static final String GET_RAW_EOSIO_TOKEN_ABI_RESPONSE = "{\n"
            + "    \"account_name\": \"eosio.token\",\n"
            + "    \"code_hash\": \"3e0cf4172ab025f9fff5f1db11ee8a34d44779492e1d668ae1dc2d129e865348\",\n"
            + "    \"abi_hash\": \"43864d5af0fe294d44d19c612036cbe8c098414c4a12a5a7bb0bfe7db1556248\",\n"
            + "    \"abi\": \"DmVvc2lvOjphYmkvMS4wAQxhY2NvdW50X25hbWUEbmFtZQUIdHJhbnNmZXIABARmcm9tDGFjY291bnRfbmFtZQJ0bwxhY2NvdW50X25hbWUIcXVhbnRpdHkFYXNzZXQEbWVtbwZzdHJpbmcGY3JlYXRlAAIGaXNzdWVyDGFjY291bnRfbmFtZQ5tYXhpbXVtX3N1cHBseQVhc3NldAVpc3N1ZQADAnRvDGFjY291bnRfbmFtZQhxdWFudGl0eQVhc3NldARtZW1vBnN0cmluZwdhY2NvdW50AAEHYmFsYW5jZQVhc3NldA5jdXJyZW5jeV9zdGF0cwADBnN1cHBseQVhc3NldAptYXhfc3VwcGx5BWFzc2V0Bmlzc3VlcgxhY2NvdW50X25hbWUDAAAAVy08zc0IdHJhbnNmZXK8By0tLQp0aXRsZTogVG9rZW4gVHJhbnNmZXIKc3VtbWFyeTogVHJhbnNmZXIgdG9rZW5zIGZyb20gb25lIGFjY291bnQgdG8gYW5vdGhlci4KaWNvbjogaHR0cHM6Ly9jZG4udGVzdG5ldC5kZXYuYjFvcHMubmV0L3Rva2VuLXRyYW5zZmVyLnBuZyNjZTUxZWY5ZjllZWNhMzQzNGU4NTUwN2UwZWQ0OWU3NmZmZjEyNjU0MjJiZGVkMDI1NWYzMTk2ZWE1OWM4YjBjCi0tLQoKIyMgVHJhbnNmZXIgVGVybXMgJiBDb25kaXRpb25zCgpJLCB7e2Zyb219fSwgY2VydGlmeSB0aGUgZm9sbG93aW5nIHRvIGJlIHRydWUgdG8gdGhlIGJlc3Qgb2YgbXkga25vd2xlZGdlOgoKMS4gSSBjZXJ0aWZ5IHRoYXQge3txdWFudGl0eX19IGlzIG5vdCB0aGUgcHJvY2VlZHMgb2YgZnJhdWR1bGVudCBvciB2aW9sZW50IGFjdGl2aXRpZXMuCjIuIEkgY2VydGlmeSB0aGF0LCB0byB0aGUgYmVzdCBvZiBteSBrbm93bGVkZ2UsIHt7dG99fSBpcyBub3Qgc3VwcG9ydGluZyBpbml0aWF0aW9uIG9mIHZpb2xlbmNlIGFnYWluc3Qgb3RoZXJzLgozLiBJIGhhdmUgZGlzY2xvc2VkIGFueSBjb250cmFjdHVhbCB0ZXJtcyAmIGNvbmRpdGlvbnMgd2l0aCByZXNwZWN0IHRvIHt7cXVhbnRpdHl9fSB0byB7e3RvfX0uCgpJIHVuZGVyc3RhbmQgdGhhdCBmdW5kcyB0cmFuc2ZlcnMgYXJlIG5vdCByZXZlcnNpYmxlIGFmdGVyIHRoZSB7eyR0cmFuc2FjdGlvbi5kZWxheV9zZWN9fSBzZWNvbmRzIG9yIG90aGVyIGRlbGF5IGFzIGNvbmZpZ3VyZWQgYnkge3tmcm9tfX0ncyBwZXJtaXNzaW9ucy4KCklmIHRoaXMgYWN0aW9uIGZhaWxzIHRvIGJlIGlycmV2ZXJzaWJseSBjb25maXJtZWQgYWZ0ZXIgcmVjZWl2aW5nIGdvb2RzIG9yIHNlcnZpY2VzIGZyb20gJ3t7dG99fScsIEkgYWdyZWUgdG8gZWl0aGVyIHJldHVybiB0aGUgZ29vZHMgb3Igc2VydmljZXMgb3IgcmVzZW5kIHt7cXVhbnRpdHl9fSBpbiBhIHRpbWVseSBtYW5uZXIuAAAAAAClMXYFaXNzdWUAAAAAAKhs1EUGY3JlYXRlAAIAAAA4T00RMgNpNjQBCGN1cnJlbmN5AQZ1aW50NjQHYWNjb3VudAAAAAAAkE3GA2k2NAEIY3VycmVuY3kBBnVpbnQ2NA5jdXJyZW5jeV9zdGF0cwAAAAA==\"\n"
            + "}";


    public static final String GET_REQUIRED_KEYS_RESPONSE = "{\n"
            + "    \"required_keys\": [\n"
            + "        \"EOS5j67P1W2RyBXAL8sNzYcDLox3yLpxyrxgkYy1xsXzVCvzbYpba\"\n"
            + "    ]\n"
            + "}";

    public static final String PUSH_TRANSACTION_RESPONSE = "{\n"
            + "    \"transaction_id\": \"ae735820e26a7b771e1b522186294d7cbba035d0c31ca88237559d6c0a3bf00a\",\n"
            + "    \"processed\": {\n"
            + "        \"id\": \"ae735820e26a7b771e1b522186294d7cbba035d0c31ca88237559d6c0a3bf00a\",\n"
            + "        \"block_num\": 21098575,\n"
            + "        \"block_time\": \"2019-01-28T16:15:37.500\",\n"
            + "        \"producer_block_id\": null,\n"
            + "        \"receipt\": {\n"
            + "            \"status\": \"executed\",\n"
            + "            \"cpu_usage_us\": 3837,\n"
            + "            \"net_usage_words\": 36\n"
            + "        },\n"
            + "        \"elapsed\": 3837,\n"
            + "        \"net_usage\": 288,\n"
            + "        \"scheduled\": false,\n"
            + "        \"action_traces\": [\n"
            + "            {\n"
            + "                \"receipt\": {\n"
            + "                    \"receiver\": \"eosio.assert\",\n"
            + "                    \"act_digest\": \"a4caeedd5e5824dd916c1aaabc84f0a114ddbda83728c8c23ba859d4a8a93721\",\n"
            + "                    \"global_sequence\": 21103875,\n"
            + "                    \"recv_sequence\": 332,\n"
            + "                    \"auth_sequence\": [],\n"
            + "                    \"code_sequence\": 1,\n"
            + "                    \"abi_sequence\": 1\n"
            + "                },\n"
            + "                \"act\": {\n"
            + "                    \"account\": \"eosio.assert\",\n"
            + "                    \"name\": \"require\",\n"
            + "                    \"authorization\": [],\n"
            + "                    \"data\": {\n"
            + "                        \"chain_params_hash\": \"cbdd956f52acd910c3c958136d72f8560d1846bc7cf3157f5fbfb72d3001de45\",\n"
            + "                        \"manifest_id\": \"97f4a1fdbecda6d59c96a43009fc5e5d7b8f639b1269c77cec718460dcc19cb3\",\n"
            + "                        \"actions\": [\n"
            + "                            {\n"
            + "                                \"contract\": \"eosio.token\",\n"
            + "                                \"action\": \"transfer\"\n"
            + "                            }\n"
            + "                        ],\n"
            + "                        \"abi_hashes\": [\n"
            + "                            \"43864d5af0fe294d44d19c612036cbe8c098414c4a12a5a7bb0bfe7db1556248\"\n"
            + "                        ]\n"
            + "                    },\n"
            + "                    \"hex_data\": \"cbdd956f52acd910c3c958136d72f8560d1846bc7cf3157f5fbfb72d3001de4597f4a1fdbecda6d59c96a43009fc5e5d7b8f639b1269c77cec718460dcc19cb30100a6823403ea3055000000572d3ccdcd0143864d5af0fe294d44d19c612036cbe8c098414c4a12a5a7bb0bfe7db1556248\"\n"
            + "                },\n"
            + "                \"context_free\": false,\n"
            + "                \"elapsed\": 1264,\n"
            + "                \"cpu_usage\": 0,\n"
            + "                \"console\": \"\",\n"
            + "                \"total_cpu_usage\": 0,\n"
            + "                \"trx_id\": \"ae735820e26a7b771e1b522186294d7cbba035d0c31ca88237559d6c0a3bf00a\",\n"
            + "                \"block_num\": 21098575,\n"
            + "                \"block_time\": \"2019-01-28T16:15:37.500\",\n"
            + "                \"producer_block_id\": null,\n"
            + "                \"account_ram_deltas\": [],\n"
            + "                \"inline_traces\": []\n"
            + "            },\n"
            + "            {\n"
            + "                \"receipt\": {\n"
            + "                    \"receiver\": \"eosio.token\",\n"
            + "                    \"act_digest\": \"9eab239d66d13c34b9cc35a6f79fb2f6d61a2d9df9a484075c82e65d73a0cbc8\",\n"
            + "                    \"global_sequence\": 21103876,\n"
            + "                    \"recv_sequence\": 1366,\n"
            + "                    \"auth_sequence\": [\n"
            + "                        [\n"
            + "                            \"cryptkeeper\",\n"
            + "                            875\n"
            + "                        ]\n"
            + "                    ],\n"
            + "                    \"code_sequence\": 1,\n"
            + "                    \"abi_sequence\": 4\n"
            + "                },\n"
            + "                \"act\": {\n"
            + "                    \"account\": \"eosio.token\",\n"
            + "                    \"name\": \"transfer\",\n"
            + "                    \"authorization\": [\n"
            + "                        {\n"
            + "                            \"actor\": \"cryptkeeper\",\n"
            + "                            \"permission\": \"active\"\n"
            + "                        }\n"
            + "                    ],\n"
            + "                    \"data\": {\n"
            + "                        \"from\": \"cryptkeeper\",\n"
            + "                        \"to\": \"brandon\",\n"
            + "                        \"quantity\": \"42.0000 EOS\",\n"
            + "                        \"memo\": \"the grasshopper lies heavy\"\n"
            + "                    },\n"
            + "                    \"hex_data\": \"00aeaa4ac15cfd4500000060d234cd3da06806000000000004454f53000000001a746865206772617373686f70706572206c696573206865617679\"\n"
            + "                },\n"
            + "                \"context_free\": false,\n"
            + "                \"elapsed\": 2197,\n"
            + "                \"cpu_usage\": 0,\n"
            + "                \"console\": \"\",\n"
            + "                \"total_cpu_usage\": 0,\n"
            + "                \"trx_id\": \"ae735820e26a7b771e1b522186294d7cbba035d0c31ca88237559d6c0a3bf00a\",\n"
            + "                \"block_num\": 21098575,\n"
            + "                \"block_time\": \"2019-01-28T16:15:37.500\",\n"
            + "                \"producer_block_id\": null,\n"
            + "                \"account_ram_deltas\": [],\n"
            + "                \"inline_traces\": [\n"
            + "                    {\n"
            + "                        \"receipt\": {\n"
            + "                            \"receiver\": \"cryptkeeper\",\n"
            + "                            \"act_digest\": \"9eab239d66d13c34b9cc35a6f79fb2f6d61a2d9df9a484075c82e65d73a0cbc8\",\n"
            + "                            \"global_sequence\": 21103877,\n"
            + "                            \"recv_sequence\": 496,\n"
            + "                            \"auth_sequence\": [\n"
            + "                                [\n"
            + "                                    \"cryptkeeper\",\n"
            + "                                    876\n"
            + "                                ]\n"
            + "                            ],\n"
            + "                            \"code_sequence\": 1,\n"
            + "                            \"abi_sequence\": 4\n"
            + "                        },\n"
            + "                        \"act\": {\n"
            + "                            \"account\": \"eosio.token\",\n"
            + "                            \"name\": \"transfer\",\n"
            + "                            \"authorization\": [\n"
            + "                                {\n"
            + "                                    \"actor\": \"cryptkeeper\",\n"
            + "                                    \"permission\": \"active\"\n"
            + "                                }\n"
            + "                            ],\n"
            + "                            \"data\": {\n"
            + "                                \"from\": \"cryptkeeper\",\n"
            + "                                \"to\": \"brandon\",\n"
            + "                                \"quantity\": \"42.0000 EOS\",\n"
            + "                                \"memo\": \"the grasshopper lies heavy\"\n"
            + "                            },\n"
            + "                            \"hex_data\": \"00aeaa4ac15cfd4500000060d234cd3da06806000000000004454f53000000001a746865206772617373686f70706572206c696573206865617679\"\n"
            + "                        },\n"
            + "                        \"context_free\": false,\n"
            + "                        \"elapsed\": 6,\n"
            + "                        \"cpu_usage\": 0,\n"
            + "                        \"console\": \"\",\n"
            + "                        \"total_cpu_usage\": 0,\n"
            + "                        \"trx_id\": \"ae735820e26a7b771e1b522186294d7cbba035d0c31ca88237559d6c0a3bf00a\",\n"
            + "                        \"block_num\": 21098575,\n"
            + "                        \"block_time\": \"2019-01-28T16:15:37.500\",\n"
            + "                        \"producer_block_id\": null,\n"
            + "                        \"account_ram_deltas\": [],\n"
            + "                        \"inline_traces\": []\n"
            + "                    },\n"
            + "                    {\n"
            + "                        \"receipt\": {\n"
            + "                            \"receiver\": \"brandon\",\n"
            + "                            \"act_digest\": \"9eab239d66d13c34b9cc35a6f79fb2f6d61a2d9df9a484075c82e65d73a0cbc8\",\n"
            + "                            \"global_sequence\": 21103878,\n"
            + "                            \"recv_sequence\": 582,\n"
            + "                            \"auth_sequence\": [\n"
            + "                                [\n"
            + "                                    \"cryptkeeper\",\n"
            + "                                    877\n"
            + "                                ]\n"
            + "                            ],\n"
            + "                            \"code_sequence\": 1,\n"
            + "                            \"abi_sequence\": 4\n"
            + "                        },\n"
            + "                        \"act\": {\n"
            + "                            \"account\": \"eosio.token\",\n"
            + "                            \"name\": \"transfer\",\n"
            + "                            \"authorization\": [\n"
            + "                                {\n"
            + "                                    \"actor\": \"cryptkeeper\",\n"
            + "                                    \"permission\": \"active\"\n"
            + "                                }\n"
            + "                            ],\n"
            + "                            \"data\": {\n"
            + "                                \"from\": \"cryptkeeper\",\n"
            + "                                \"to\": \"brandon\",\n"
            + "                                \"quantity\": \"42.0000 EOS\",\n"
            + "                                \"memo\": \"the grasshopper lies heavy\"\n"
            + "                            },\n"
            + "                            \"hex_data\": \"00aeaa4ac15cfd4500000060d234cd3da06806000000000004454f53000000001a746865206772617373686f70706572206c696573206865617679\"\n"
            + "                        },\n"
            + "                        \"context_free\": false,\n"
            + "                        \"elapsed\": 5,\n"
            + "                        \"cpu_usage\": 0,\n"
            + "                        \"console\": \"\",\n"
            + "                        \"total_cpu_usage\": 0,\n"
            + "                        \"trx_id\": \"ae735820e26a7b771e1b522186294d7cbba035d0c31ca88237559d6c0a3bf00a\",\n"
            + "                        \"block_num\": 21098575,\n"
            + "                        \"block_time\": \"2019-01-28T16:15:37.500\",\n"
            + "                        \"producer_block_id\": null,\n"
            + "                        \"account_ram_deltas\": [],\n"
            + "                        \"inline_traces\": []\n"
            + "                    }\n"
            + "                ]\n"
            + "            }\n"
            + "        ],\n"
            + "        \"except\": null\n"
            + "    }\n"
            + "}";

    public static final String PUSH_TRANSACTION_ERROR_RESPONSE = "{\n"
            + "    \"code\": 500,\n"
            + "    \"message\": \"Internal Service Error\",\n"
            + "    \"error\": {\n"
            + "        \"code\": 3040005,\n"
            + "        \"name\": \"expired_tx_exception\",\n"
            + "        \"what\": \"Expired Transaction\",\n"
            + "        \"details\": [\n"
            + "            {\n"
            + "                \"message\": \"expired transaction ae735820e26a7b771e1b522186294d7cbba035d0c31ca88237559d6c0a3bf00a\",\n"
            + "                \"file\": \"producer_plugin.cpp\",\n"
            + "                \"line_number\": 378,\n"
            + "                \"method\": \"on_incoming_transaction_async\"\n"
            + "            }\n"
            + "        ]\n"
            + "    }\n"
            + "}";

    public static final String GET_ACCOUNT_RESPONSE = "{\n" +
            "    \"account_name\": \"test_account\",\n" +
            "    \"head_block_num\": 33869724,\n" +
            "    \"head_block_time\": \"2019-04-12T19:59:45.500\",\n" +
            "    \"privileged\": false,\n" +
            "    \"last_code_update\": \"1970-01-01T00:00:00.000\",\n" +
            "    \"created\": \"2019-04-09T15:05:50.000\",\n" +
            "    \"ram_quota\": 9549,\n" +
            "    \"net_weight\": 1000000,\n" +
            "    \"cpu_weight\": 1000000,\n" +
            "    \"net_limit\": {\n" +
            "        \"used\": 0,\n" +
            "        \"available\": \"55039480545\",\n" +
            "        \"max\": \"55039480545\"\n" +
            "    },\n" +
            "    \"cpu_limit\": {\n" +
            "        \"used\": 0,\n" +
            "        \"available\": \"10497947797\",\n" +
            "        \"max\": \"10497947797\"\n" +
            "    },\n" +
            "    \"ram_usage\": 2996,\n" +
            "    \"permissions\": [\n" +
            "        {\n" +
            "            \"perm_name\": \"active\",\n" +
            "            \"parent\": \"owner\",\n" +
            "            \"required_auth\": {\n" +
            "                \"threshold\": 1,\n" +
            "                \"keys\": [\n" +
            "                    {\n" +
            "                        \"key\": \"sample key\",\n" +
            "                        \"weight\": 1\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"accounts\": [],\n" +
            "                \"waits\": []\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"perm_name\": \"owner\",\n" +
            "            \"parent\": \"\",\n" +
            "            \"required_auth\": {\n" +
            "                \"threshold\": 1,\n" +
            "                \"keys\": [\n" +
            "                    {\n" +
            "                        \"key\": \"sample key\",\n" +
            "                        \"weight\": 1\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"accounts\": [],\n" +
            "                \"waits\": []\n" +
            "            }\n" +
            "        }\n" +
            "    ],\n" +
            "    \"total_resources\": {\n" +
            "        \"owner\": \"test_account\",\n" +
            "        \"net_weight\": \"100.0000 EOS\",\n" +
            "        \"cpu_weight\": \"100.0000 EOS\",\n" +
            "        \"ram_bytes\": 8149\n" +
            "    },\n" +
            "    \"self_delegated_bandwidth\": null,\n" +
            "    \"refund_request\": null,\n" +
            "    \"voter_info\": null\n" +
            "}";

    public static final String PUSH_TRANSACTIONS_REQUEST = "[\n" +
            "\t{\n" +
            "\t\t\"signatures\": [\n" +
            "\t\t\t\"signature 1\"\n" +
            "\t\t],\n" +
            "\t\t\"compression\": 0,\n" +
            "\t\t\"packed_context_free_data\": \"\",\n" +
            "\t\t\"packed_trx\": \"transaction 1\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"signatures\": [\n" +
            "\t\t\t\"signature 2\"\n" +
            "\t\t],\n" +
            "\t\t\"compression\": 0,\n" +
            "\t\t\"packed_context_free_data\": \"\",\n" +
            "\t\t\"packed_trx\": \"transaction 2\"\n" +
            "\t}\n" +
            "]";

    public static final String PUSH_TRANSACTIONS_RESPONSE = "[" +
            PUSH_TRANSACTION_RESPONSE + "," +
            PUSH_TRANSACTION_RESPONSE +
            "]";

    public static final String GET_BLOCK_HEADER_STATE_REQUEST = "{\n" +
            "\"block_num_or_id\" : \"34341092\"\n" +
            "}";

    public static final String GET_BLOCK_HEADER_STATE_RESPONSE = "{\n" +
            "    \"id\": \"020c00e41e66ca6a0fa489c9b2df391fd06089426a3daed5e4859cebc1d41b73\",\n" +
            "    \"block_num\": 34341092,\n" +
            "    \"header\": {\n" +
            "        \"timestamp\": \"2019-04-15T13:27:49.500\",\n" +
            "        \"producer\": \"blkproducer3\",\n" +
            "        \"confirmed\": 0,\n" +
            "        \"previous\": \"020c00e3f28a0b2527e99dbd4a3fa9ee5741da5da54a6c24eebebdd3e4982d02\",\n" +
            "        \"transaction_mroot\": \"0000000000000000000000000000000000000000000000000000000000000000\",\n" +
            "        \"action_mroot\": \"aceb0c73b6339dd384a8ad88687717f031098ce686181827f5d3dba4cc713f48\",\n" +
            "        \"schedule_version\": 3,\n" +
            "        \"header_extensions\": [],\n" +
            "        \"producer_signature\": \"SIG_K1_K3F1T4GQw94Qj9FB2LcxErbkhScbCMKxS7VTbGnJFHuMzLTRWrbBgRsypsa2e95368AfNY7qynyNG9FuvD5WiJZSteraze\"\n" +
            "    },\n" +
            "    \"dpos_proposed_irreversible_blocknum\": 34341076,\n" +
            "    \"dpos_irreversible_blocknum\": 34341052,\n" +
            "    \"bft_irreversible_blocknum\": 0,\n" +
            "    \"pending_schedule_lib_num\": 21818600,\n" +
            "    \"pending_schedule_hash\": \"a978d8d8f20419e226a3c6a1d38ae67a922950b06aa318b2612be9c13f1ede67\",\n" +
            "    \"pending_schedule\": {\n" +
            "        \"version\": 3,\n" +
            "        \"producers\": []\n" +
            "    },\n" +
            "    \"active_schedule\": {\n" +
            "        \"version\": 3,\n" +
            "        \"producers\": [\n" +
            "            {\n" +
            "                \"producer_name\": \"blkproducer1\",\n" +
            "                \"block_signing_key\": \"EOS5DgtLq5fSqsc6SD3SD98Tu5P7dirfNdnD3pjCLtURiDWTQ6pzV\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"producer_name\": \"blkproducer2\",\n" +
            "                \"block_signing_key\": \"EOS8QEPQ1wiZrdHavectXNpMy3TpcyYGXSVfkVGhyVTaJ7FT8bzCZ\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"producer_name\": \"blkproducer3\",\n" +
            "                \"block_signing_key\": \"EOS7YTjjzt7coagRE5i64JhZB4ucH23Nz5mDhXdzU6QC7gfXwy8M9\"\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"blockroot_merkle\": {\n" +
            "        \"_active_nodes\": [\n" +
            "            \"020c00e3f28a0b2527e99dbd4a3fa9ee5741da5da54a6c24eebebdd3e4982d02\",\n" +
            "            \"0880dd1f0cc29ef284d6ec727efebd6369c0df6265d3483c45308877f7198af5\",\n" +
            "            \"d2b8eddf6f9e5493183b66e6a2443aa349ed00feabd7a830344ba6cc157285ca\",\n" +
            "            \"40ff3c15876905f6835eb00b792c53d7507149d24128a4b4444641a6be89b21a\",\n" +
            "            \"796459e92ba4b2118d1651e6823de7fda882726ec2697c32a5324c555891f95a\",\n" +
            "            \"e12e1f5104074d76612e49a3166c65ae9ee3198d22c35fa1d1c79e8cb6e53f8f\",\n" +
            "            \"d9d005c528ecfda513f954d0b7164b33bb2289f5271ac7a0d93234ae5a0ba59c\",\n" +
            "            \"f541345de34d499b2bf108c5bbf797c7081e3437263ec69cc420fe4668f20910\",\n" +
            "            \"2168cb08f341c52ae3267461f8cc859dde530782fe7d6ed17dad50d126b55d89\"\n" +
            "        ],\n" +
            "        \"_node_count\": 34341091\n" +
            "    },\n" +
            "    \"producer_to_last_produced\": [\n" +
            "        [\n" +
            "            \"blkproducer1\",\n" +
            "            34341076\n" +
            "        ],\n" +
            "        [\n" +
            "            \"blkproducer2\",\n" +
            "            34341088\n" +
            "        ],\n" +
            "        [\n" +
            "            \"blkproducer3\",\n" +
            "            34341092\n" +
            "        ]\n" +
            "    ],\n" +
            "    \"producer_to_last_implied_irb\": [\n" +
            "        [\n" +
            "            \"blkproducer1\",\n" +
            "            34341052\n" +
            "        ],\n" +
            "        [\n" +
            "            \"blkproducer2\",\n" +
            "            34341064\n" +
            "        ],\n" +
            "        [\n" +
            "            \"blkproducer3\",\n" +
            "            34341076\n" +
            "        ]\n" +
            "    ],\n" +
            "    \"block_signing_key\": \"EOS7YTjjzt7coagRE5i64JhZB4ucH23Nz5mDhXdzU6QC7gfXwy8M9\",\n" +
            "    \"confirm_count\": [\n" +
            "        1,\n" +
            "        1,\n" +
            "        1,\n" +
            "        1,\n" +
            "        1,\n" +
            "        1,\n" +
            "        1,\n" +
            "        1,\n" +
            "        1,\n" +
            "        1,\n" +
            "        1,\n" +
            "        1,\n" +
            "        2,\n" +
            "        2,\n" +
            "        2,\n" +
            "        2\n" +
            "    ],\n" +
            "    \"confirmations\": []\n" +
            "}";

    public static final String GET_ABI_REQUEST = "{\n" +
            "\"account_name\" : \"eosio.token\"\n" +
            "}";
    public static final String GET_ABI_RESPONSE = "{\n" +
            "    \"account_name\": \"eosio.token\",\n" +
            "    \"abi\": {\n" +
            "        \"version\": \"eosio::abi/1.0\",\n" +
            "        \"types\": [\n" +
            "            {\n" +
            "                \"new_type_name\": \"account_name\",\n" +
            "                \"type\": \"name\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"structs\": [\n" +
            "            {\n" +
            "                \"name\": \"transfer\",\n" +
            "                \"base\": \"\",\n" +
            "                \"fields\": [\n" +
            "                    {\n" +
            "                        \"name\": \"from\",\n" +
            "                        \"type\": \"account_name\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"to\",\n" +
            "                        \"type\": \"account_name\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"quantity\",\n" +
            "                        \"type\": \"asset\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"memo\",\n" +
            "                        \"type\": \"string\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            },\n" +
            "            {\n" +
            "                \"name\": \"create\",\n" +
            "                \"base\": \"\",\n" +
            "                \"fields\": [\n" +
            "                    {\n" +
            "                        \"name\": \"issuer\",\n" +
            "                        \"type\": \"account_name\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"maximum_supply\",\n" +
            "                        \"type\": \"asset\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            },\n" +
            "            {\n" +
            "                \"name\": \"issue\",\n" +
            "                \"base\": \"\",\n" +
            "                \"fields\": [\n" +
            "                    {\n" +
            "                        \"name\": \"to\",\n" +
            "                        \"type\": \"account_name\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"quantity\",\n" +
            "                        \"type\": \"asset\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"memo\",\n" +
            "                        \"type\": \"string\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            },\n" +
            "            {\n" +
            "                \"name\": \"account\",\n" +
            "                \"base\": \"\",\n" +
            "                \"fields\": [\n" +
            "                    {\n" +
            "                        \"name\": \"balance\",\n" +
            "                        \"type\": \"asset\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            },\n" +
            "            {\n" +
            "                \"name\": \"currency_stats\",\n" +
            "                \"base\": \"\",\n" +
            "                \"fields\": [\n" +
            "                    {\n" +
            "                        \"name\": \"supply\",\n" +
            "                        \"type\": \"asset\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"max_supply\",\n" +
            "                        \"type\": \"asset\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"issuer\",\n" +
            "                        \"type\": \"account_name\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            }\n" +
            "        ],\n" +
            "        \"actions\": [\n" +
            "            {\n" +
            "                \"name\": \"transfer\",\n" +
            "                \"type\": \"transfer\",\n" +
            "                \"ricardian_contract\": \"---\\ntitle: Token Transfer\\nsummary: Transfer tokens from one account to another.\\nicon: https://cdn.testnet.dev.b1ops.net/token-transfer.png#ce51ef9f9eeca3434e85507e0ed49e76fff1265422bded0255f3196ea59c8b0c\\n---\\n\\n## Transfer Terms & Conditions\\n\\nI, {{from}}, certify the following to be true to the best of my knowledge:\\n\\n1. I certify that {{quantity}} is not the proceeds of fraudulent or violent activities.\\n2. I certify that, to the best of my knowledge, {{to}} is not supporting initiation of violence against others.\\n3. I have disclosed any contractual terms & conditions with respect to {{quantity}} to {{to}}.\\n\\nI understand that funds transfers are not reversible after the {{$transaction.delay_sec}} seconds or other delay as configured by {{from}}'s permissions.\\n\\nIf this action fails to be irreversibly confirmed after receiving goods or services from '{{to}}', I agree to either return the goods or services or resend {{quantity}} in a timely manner.\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"name\": \"issue\",\n" +
            "                \"type\": \"issue\",\n" +
            "                \"ricardian_contract\": \"\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"name\": \"create\",\n" +
            "                \"type\": \"create\",\n" +
            "                \"ricardian_contract\": \"\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"tables\": [\n" +
            "            {\n" +
            "                \"name\": \"accounts\",\n" +
            "                \"index_type\": \"i64\",\n" +
            "                \"key_names\": [\n" +
            "                    \"currency\"\n" +
            "                ],\n" +
            "                \"key_types\": [\n" +
            "                    \"uint64\"\n" +
            "                ],\n" +
            "                \"type\": \"account\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"name\": \"stat\",\n" +
            "                \"index_type\": \"i64\",\n" +
            "                \"key_names\": [\n" +
            "                    \"currency\"\n" +
            "                ],\n" +
            "                \"key_types\": [\n" +
            "                    \"uint64\"\n" +
            "                ],\n" +
            "                \"type\": \"currency_stats\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"ricardian_clauses\": [],\n" +
            "        \"error_messages\": [],\n" +
            "        \"abi_extensions\": [],\n" +
            "        \"variants\": []\n" +
            "    }\n" +
            "}";

    public static final String GET_CURRENT_BALANCE_REQUEST = "{\n" +
            "\t\"code\" : \"eosio.token\"\n" +
            "\t\"account\" : \"test_account\"\n" +
            "}";
    public static final String GET_CURRENT_BALANCE_RESPONSE = "[\n" +
            "    \"1.0000 EOS\"\n" +
            "]";

    public static final String GET_CURRENT_STATS_REQUEST = "{\n" +
            "\t\"code\" : \"eosio.token\"\n" +
            "\t\"symbol\" : \"EOS\"\n" +
            "}";

    public static final String GET_CURRENT_STATS_RESPONSE = "{\n" +
            "    \"EOS\": {\n" +
            "        \"supply\": \"100000000.0000 EOS\",\n" +
            "        \"max_supply\": \"10000000000.0000 EOS\",\n" +
            "        \"issuer\": \"eosio\"\n" +
            "    }\n" +
            "}";

    public static final String GET_PRODUCER_REQUEST = "{\"limit\":\"10\",\"lower_bound\":\"blkproducer2\",\"json\":true}";

    public static final String GET_PRODUCER_RESPONSE = "{\n" +
            "    \"rows\": [\n" +
            "        {\n" +
            "            \"owner\": \"blkproducer2\",\n" +
            "            \"total_votes\": \"0.00000000000000000\",\n" +
            "            \"producer_key\": \"EOS8QEPQ1wiZrdHavectXNpMy3TpcyYGXSVfkVGhyVTaJ7FT8bzCZ\",\n" +
            "            \"is_active\": 1,\n" +
            "            \"url\": \"\",\n" +
            "            \"unpaid_blocks\": 0,\n" +
            "            \"last_claim_time\": \"1970-01-01T00:00:00.000\",\n" +
            "            \"location\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"owner\": \"blkproducer3\",\n" +
            "            \"total_votes\": \"0.00000000000000000\",\n" +
            "            \"producer_key\": \"EOS7YTjjzt7coagRE5i64JhZB4ucH23Nz5mDhXdzU6QC7gfXwy8M9\",\n" +
            "            \"is_active\": 1,\n" +
            "            \"url\": \"\",\n" +
            "            \"unpaid_blocks\": 0,\n" +
            "            \"last_claim_time\": \"2019-01-31T22:50:21.500\",\n" +
            "            \"location\": 0\n" +
            "        }\n" +
            "    ],\n" +
            "    \"total_producer_vote_weight\": \"0.00000000000000000\",\n" +
            "    \"more\": \"\"\n" +
            "}";

    public static final String GET_RAW_CODE_AND_ABI_REQUEST = "{{\n" +
            "\"account_name\" : \"eosio.token\"\n" +
            "}";
    public static final String GET_RAW_CODE_AND_ABI_RESPONSE = "{\n" +
            "    \"account_name\": \"eosio.token\",\n" +
            "    \"wasm\": \"AGFzbQEAAAABfhVgA39+fwBgBX9+fn9/AGAEf35/fwBgAABgAAF+YAJ+fgBgAX4AYAJ/fwBgBH5+fn4Bf2AGfn5+fn9/AX9gA39/fwF/YAF+AX9gAX8AYAABf2ACf38Bf2ABfwF/YAR/f39/AGAEf35/fgBgBH5+f38AYAN/fn8Bf2ADfn5+AALFAhEDZW52BWFib3J0AAMDZW52EGFjdGlvbl9kYXRhX3NpemUADQNlbnYQY3VycmVudF9yZWNlaXZlcgAEA2VudgxjdXJyZW50X3RpbWUABANlbnYLZGJfZmluZF9pNjQACANlbnYKZGJfZ2V0X2k2NAAKA2Vudg1kYl9yZW1vdmVfaTY0AAwDZW52DGRiX3N0b3JlX2k2NAAJA2Vudg1kYl91cGRhdGVfaTY0AAIDZW52DGVvc2lvX2Fzc2VydAAHA2Vudgppc19hY2NvdW50AAsDZW52Bm1lbWNweQAKA2VudhByZWFkX2FjdGlvbl9kYXRhAA4DZW52DHJlcXVpcmVfYXV0aAAGA2Vudg1yZXF1aXJlX2F1dGgyAAUDZW52EXJlcXVpcmVfcmVjaXBpZW50AAYDZW52C3NlbmRfaW5saW5lAAcDMTAODg4NDAAODwcQBwIREgcHBw4ODg4QARMAEwcUDg4OBwcODgcPDAwHDA4KDw4PDAMEBQFwAQQEBQMBAAEH9wMPBm1lbW9yeQIAFl9aZXFSSzExY2hlY2tzdW0yNTZTMV8AERZfWmVxUksxMWNoZWNrc3VtMTYwUzFfABIWX1puZVJLMTFjaGVja3N1bTE2MFMxXwATA25vdwAUMF9aTjVlb3NpbzEycmVxdWlyZV9hdXRoRVJLTlNfMTZwZXJtaXNzaW9uX2xldmVsRQAVIl9aTjVlb3NpbzV0b2tlbjZjcmVhdGVFeU5TXzVhc3NldEUAFmFfWk41ZW9zaW81dG9rZW41aXNzdWVFeU5TXzVhc3NldEVOU3QzX18xMTJiYXNpY19zdHJpbmdJY05TMl8xMWNoYXJfdHJhaXRzSWNFRU5TMl85YWxsb2NhdG9ySWNFRUVFABwpX1pONWVvc2lvNXRva2VuMTFhZGRfYmFsYW5jZUV5TlNfNWFzc2V0RXkAHWVfWk41ZW9zaW81dG9rZW44dHJhbnNmZXJFeXlOU181YXNzZXRFTlN0M19fMTEy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QQgQCxogB0F4cUEIR0GAAxAJIAogA0EIakEIEAsaIAUgATYCFCAJIAU2AhggCSAFQQhqKQMAQgiIIgg3AxAgCSAFKAIUIgc2AgwCQAJAIABBHGoiASgCACIGIABBIGooAgBPDQAgBiAINwMIIAYgBzYCECAJQQA2AhggBiAFNgIAIAEgBkEYajYCAAwBCyACIAlBGGogCUEQaiAJQQxqECYLIAkoAhghBiAJQQA2AhggBkUNACAGEDYLQQAgCUEgajYCBCAFC6oDAQR/AkACQCAAKAIEIAAoAgAiBmtBGG0iBEEBaiIFQavVqtUATw0AQarVqtUAIQcCQAJAIAAoAgggBmtBGG0iBkHUqtUqSw0AIAUgBkEBdCIHIAcgBUkbIgdFDQELIAdBGGwQNSEGDAILQQAhB0EAIQYMAQsgABA5AAsgASgCACEFIAFBADYCACAGIARBGGxqIgEgBTYCACABIAIpAwA3AwggASADKAIANgIQIAYgB0EYbGohBCABQRhqIQUCQAJAIABBBGooAgAiBiAAKAIAIgdGDQADQCAGQWhqIgIoAgAhAyACQQA2AgAgAUFoaiADNgIAIAFBeGogBkF4aigCADYCACABQXRqIAZBdGooAgA2AgAgAUFwaiAGQXBqKAIANgIAIAFBaGohASACIQYgByACRw0ACyAAQQRqKAIAIQcgACgCACEGDAELIAchBgsgACABNgIAIABBBGogBTYCACAAQQhqIAQ2AgACQCAHIAZGDQADQCAHQWhqIgcoAgAhASAHQQA2AgACQCABRQ0AIAEQNgsgBiAHRw0ACwsCQCAGRQ0AIAYQNgsLogUGAX4BfwF+AX8BfgJ/QQBBACgCBEHwAGsiCzYCBCABIAJSQeAHEAkgARANIAIQCkGACBAJIAMpAwghBUEAIQggC0HoAGpBADYCACALIAVCCIgiCTcDUCALQn83A1ggC0IANwNgIAsgACkDADcDSCALQcgAaiAJQaAIECghBiABEA8gAhAPAkAgAykDACIHQv//////////P3xC/v//////////AFYNAEEAIQoCQANAIAmnQRh0Qf////97akH+///XAUsNAQJAIAlCCIgiCUL/AYNCAFINAANAIAlCCIgiCUL/AYNCAFINAyAKQQFqIgpBB0gNAAsLQQEhCCAKQQFqIgpBB0gNAAwCCwtBACEI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YXNzZWQgdG8gbW9kaWZ5IGlzIG5vdCBpbiBtdWx0aV9pbmRleAAAQbAFCzNjYW5ub3QgbW9kaWZ5IG9iamVjdHMgaW4gdGFibGUgb2YgYW5vdGhlciBjb250cmFjdAAAQfAFCythdHRlbXB0IHRvIGFkZCBhc3NldCB3aXRoIGRpZmZlcmVudCBzeW1ib2wAAEGgBgsTYWRkaXRpb24gdW5kZXJmbG93AABBwAYLEmFkZGl0aW9uIG92ZXJmbG93AABB4AYLO3VwZGF0ZXIgY2Fubm90IGNoYW5nZSBwcmltYXJ5IGtleSB3aGVuIG1vZGlmeWluZyBhbiBvYmplY3QAAEGgBwsHYWN0aXZlAABBsAcLI2Nhbm5vdCBwYXNzIGVuZCBpdGVyYXRvciB0byBtb2RpZnkAAEHgBwsYY2Fubm90IHRyYW5zZmVyIHRvIHNlbGYAAEGACAsadG8gYWNjb3VudCBkb2VzIG5vdCBleGlzdAAAQaAICxN1bmFibGUgdG8gZmluZCBrZXkAAEHACAsgbXVzdCB0cmFuc2ZlciBwb3NpdGl2ZSBxdWFudGl0eQAAQeAICxhubyBiYWxhbmNlIG9iamVjdCBmb3VuZAAAQYAJCxJvdmVyZHJhd24gYmFsYW5jZQAAQaAJCzBhdHRlbXB0IHRvIHN1YnRyYWN0IGFzc2V0IHdpdGggZGlmZmVyZW50IHN5bWJvbAAAQdAJCxZzdWJ0cmFjdGlvbiB1bmRlcmZsb3cAAEHwCQsVc3VidHJhY3Rpb24gb3ZlcmZsb3cAAEGQCgstb2JqZWN0IHBhc3NlZCB0byBlcmFzZSBpcyBub3QgaW4gbXVsdGlfaW5kZXgAAEHACgsyY2Fubm90IGVyYXNlIG9iamVjdHMgaW4gdGFibGUgb2YgYW5vdGhlciBjb250cmFjdAAAQYALCzVhdHRlbXB0IHRvIHJlbW92ZSBvYmplY3QgdGhhdCB3YXMgbm90IGluIG11bHRpX2luZGV4AABBwAsLCG9uZXJyb3IAAEHQCwsGZW9zaW8AAEHgCwtAb25lcnJvciBhY3Rpb24ncyBhcmUgb25seSB2YWxpZCBmcm9tIHRoZSAiZW9zaW8iIHN5c3RlbSBhY2NvdW50AABBoAwLBGdldAAAQYDOAAtWbWFsbG9jX2Zyb21fZnJlZWQgd2FzIGRlc2lnbmVkIHRvIG9ubHkgYmUgY2FsbGVkIGFmdGVyIF9oZWFwIHdhcyBjb21wbGV0ZWx5IGFsbG9jYXRlZAA==\",\n" +
            "    \"abi\": \"DmVvc2lvOjphYmkvMS4wAQxhY2NvdW50X25hbWUEbmFtZQUIdHJhbnNmZXIABARmcm9tDGFjY291bnRfbmFtZQJ0bwxhY2NvdW50X25hbWUIcXVhbnRpdHkFYXNzZXQEbWVtbwZzdHJpbmcGY3JlYXRlAAIGaXNzdWVyDGFjY291bnRfbmFtZQ5tYXhpbXVtX3N1cHBseQVhc3NldAVpc3N1ZQADAnRvDGFjY291bnRfbmFtZQhxdWFudGl0eQVhc3NldARtZW1vBnN0cmluZwdhY2NvdW50AAEHYmFsYW5jZQVhc3NldA5jdXJyZW5jeV9zdGF0cwADBnN1cHBseQVhc3NldAptYXhfc3VwcGx5BWFzc2V0Bmlzc3VlcgxhY2NvdW50X25hbWUDAAAAVy08zc0IdHJhbnNmZXK8By0tLQp0aXRsZTogVG9rZW4gVHJhbnNmZXIKc3VtbWFyeTogVHJhbnNmZXIgdG9rZW5zIGZyb20gb25lIGFjY291bnQgdG8gYW5vdGhlci4KaWNvbjogaHR0cHM6Ly9jZG4udGVzdG5ldC5kZXYuYjFvcHMubmV0L3Rva2VuLXRyYW5zZmVyLnBuZyNjZTUxZWY5ZjllZWNhMzQzNGU4NTUwN2UwZWQ0OWU3NmZmZjEyNjU0MjJiZGVkMDI1NWYzMTk2ZWE1OWM4YjBjCi0tLQoKIyMgVHJhbnNmZXIgVGVybXMgJiBDb25kaXRpb25zCgpJLCB7e2Zyb219fSwgY2VydGlmeSB0aGUgZm9sbG93aW5nIHRvIGJlIHRydWUgdG8gdGhlIGJlc3Qgb2YgbXkga25vd2xlZGdlOgoKMS4gSSBjZXJ0aWZ5IHRoYXQge3txdWFudGl0eX19IGlzIG5vdCB0aGUgcHJvY2VlZHMgb2YgZnJhdWR1bGVudCBvciB2aW9sZW50IGFjdGl2aXRpZXMuCjIuIEkgY2VydGlmeSB0aGF0LCB0byB0aGUgYmVzdCBvZiBteSBrbm93bGVkZ2UsIHt7dG99fSBpcyBub3Qgc3VwcG9ydGluZyBpbml0aWF0aW9uIG9mIHZpb2xlbmNlIGFnYWluc3Qgb3RoZXJzLgozLiBJIGhhdmUgZGlzY2xvc2VkIGFueSBjb250cmFjdHVhbCB0ZXJtcyAmIGNvbmRpdGlvbnMgd2l0aCByZXNwZWN0IHRvIHt7cXVhbnRpdHl9fSB0byB7e3RvfX0uCgpJIHVuZGVyc3RhbmQgdGhhdCBmdW5kcyB0cmFuc2ZlcnMgYXJlIG5vdCByZXZlcnNpYmxlIGFmdGVyIHRoZSB7eyR0cmFuc2FjdGlvbi5kZWxheV9zZWN9fSBzZWNvbmRzIG9yIG90aGVyIGRlbGF5IGFzIGNvbmZpZ3VyZWQgYnkge3tmcm9tfX0ncyBwZXJtaXNzaW9ucy4KCklmIHRoaXMgYWN0aW9uIGZhaWxzIHRvIGJlIGlycmV2ZXJzaWJseSBjb25maXJtZWQgYWZ0ZXIgcmVjZWl2aW5nIGdvb2RzIG9yIHNlcnZpY2VzIGZyb20gJ3t7dG99fScsIEkgYWdyZWUgdG8gZWl0aGVyIHJldHVybiB0aGUgZ29vZHMgb3Igc2VydmljZXMgb3IgcmVzZW5kIHt7cXVhbnRpdHl9fSBpbiBhIHRpbWVseSBtYW5uZXIuAAAAAAClMXYFaXNzdWUAAAAAAKhs1EUGY3JlYXRlAAIAAAA4T00RMgNpNjQBCGN1cnJlbmN5AQZ1aW50NjQHYWNjb3VudAAAAAAAkE3GA2k2NAEIY3VycmVuY3kBBnVpbnQ2NA5jdXJyZW5jeV9zdGF0cwAAAAA==\"\n" +
            "}";

    public static final String GET_TABLE_ROWS_REQUEST = "{\n" +
            "\t\"scope\" : \"test_account\"\n" +
            "\t\"code\" : \"eosio.token\"\n" +
            "\t\"table\" : \"accounts\"\n" +
            "\t\"json\" : true\n" +
            "\t\"limit\" : 10\n" +
            "}";
    public static final String GET_TABLE_ROWS_RESPONSE = "{\n" +
            "    \"rows\": [\n" +
            "        {\n" +
            "            \"balance\": \"1000.0000 EOS\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"more\": false\n" +
            "}";

    public static final String GET_TABLE_BY_SCOPE_REQUEST = "{\n" +
            "\t\"code\" : \"eosio.token\"\n" +
            "\t\"table\" : \"accounts\"\n" +
            "\t\"limit\" : 10\n" +
            "}";

    public static final String GET_TABLE_BY_SCOPE_RESPONSE = "{\n" +
            "    \"rows\": [\n" +
            "        {\n" +
            "            \"code\": \"eosio.token\",\n" +
            "            \"scope\": \"test_account_1\",\n" +
            "            \"table\": \"accounts\",\n" +
            "            \"payer\": \"test_account_10\",\n" +
            "            \"count\": 1\n" +
            "        },\n" +
            "        {\n" +
            "            \"code\": \"eosio.token\",\n" +
            "            \"scope\": \"test_account_2\",\n" +
            "            \"table\": \"accounts\",\n" +
            "            \"payer\": \"eosio\",\n" +
            "            \"count\": 1\n" +
            "        },\n" +
            "        {\n" +
            "            \"code\": \"eosio.token\",\n" +
            "            \"scope\": \"test_account_7\",\n" +
            "            \"table\": \"accounts\",\n" +
            "            \"payer\": \"eosio\",\n" +
            "            \"count\": 1\n" +
            "        },\n" +
            "        {\n" +
            "            \"code\": \"eosio.token\",\n" +
            "            \"scope\": \"test_account_3\",\n" +
            "            \"table\": \"accounts\",\n" +
            "            \"payer\": \"cryptkeeper\",\n" +
            "            \"count\": 1\n" +
            "        },\n" +
            "        {\n" +
            "            \"code\": \"eosio.token\",\n" +
            "            \"scope\": \"test_account_4\",\n" +
            "            \"table\": \"accounts\",\n" +
            "            \"payer\": \"test_account_1\",\n" +
            "            \"count\": 1\n" +
            "        },\n" +
            "        {\n" +
            "            \"code\": \"eosio.token\",\n" +
            "            \"scope\": \"test_account_5\",\n" +
            "            \"table\": \"accounts\",\n" +
            "            \"payer\": \"eosio\",\n" +
            "            \"count\": 1\n" +
            "        },\n" +
            "        {\n" +
            "            \"code\": \"eosio.token\",\n" +
            "            \"scope\": \"test_account_6\",\n" +
            "            \"table\": \"accounts\",\n" +
            "            \"payer\": \"eosio\",\n" +
            "            \"count\": 1\n" +
            "        },\n" +
            "        {\n" +
            "            \"code\": \"eosio.token\",\n" +
            "            \"scope\": \"test_account_7\",\n" +
            "            \"table\": \"accounts\",\n" +
            "            \"payer\": \"eosio\",\n" +
            "            \"count\": 1\n" +
            "        },\n" +
            "        {\n" +
            "            \"code\": \"eosio.token\",\n" +
            "            \"scope\": \"test_account_8\",\n" +
            "            \"table\": \"accounts\",\n" +
            "            \"payer\": \"eosio\",\n" +
            "            \"count\": 1\n" +
            "        },\n" +
            "        {\n" +
            "            \"code\": \"eosio.token\",\n" +
            "            \"scope\": \"eosio\",\n" +
            "            \"table\": \"accounts\",\n" +
            "            \"payer\": \"eosio\",\n" +
            "            \"count\": 1\n" +
            "        }\n" +
            "    ],\n" +
            "    \"more\": \"eosio.ram\"\n" +
            "}";

    public static final String GET_CODE_REQUEST = "{\n" +
            "\"account_name\" : \"eosio.token\"\n" +
            "}";

    public static final String GET_CODE_RESPONSE = "{\n" +
            "    \"code\": 500,\n" +
            "    \"message\": \"Internal Service Error\",\n" +
            "    \"error\": {\n" +
            "        \"code\": 3100008,\n" +
            "        \"name\": \"unsupported_feature\",\n" +
            "        \"what\": \"Feature is currently unsupported\",\n" +
            "        \"details\": [\n" +
            "            {\n" +
            "                \"message\": \"Returning WAST from get_code is no longer supported\",\n" +
            "                \"file\": \"chain_plugin.cpp\",\n" +
            "                \"line_number\": 1682,\n" +
            "                \"method\": \"get_code\"\n" +
            "            }\n" +
            "        ]\n" +
            "    }\n" +
            "}";

    public static final String GET_ACTIONS_REQUEST = "{\n" +
            "\t\"pos\": 100,\n" +
            "\t\"offset\": 50,\n" +
            "\t\"account_name\" : \"eosio.token\"\n" +
            "}";

    public static final String GET_ACTIONS_RESPONSE = "{\n" +
            "    \"actions\": [],\n" +
            "    \"last_irreversible_block\": 34394836\n" +
            "}";

    public static final String GET_TRANSACTION_REQUEST = "{\n" +
            "\t\"id\": \"transaction id\",\n" +
            "\t\t\"block_num_hint\": 49420058\n" +
            "}";

    public static final String GET_TRANSACTION_RESPONSE = "{\n" +
            "    \"id\": \"transaction id\",\n" +
            "    \"trx\": {\n" +
            "        \"receipt\": {\n" +
            "            \"status\": \"executed\",\n" +
            "            \"cpu_usage_us\": 112,\n" +
            "            \"net_usage_words\": 0,\n" +
            "            \"trx\": [\n" +
            "                0,\n" +
            "                \"transaction id\"\n" +
            "            ]\n" +
            "        }\n" +
            "    },\n" +
            "    \"block_time\": \"2019-03-25T06:08:05.000\",\n" +
            "    \"block_num\": 49420058,\n" +
            "    \"last_irreversible_block\": 53153351,\n" +
            "    \"traces\": [\n" +
            "        {\n" +
            "            \"receipt\": {\n" +
            "                \"receiver\": \"receiver1\",\n" +
            "                \"act_digest\": \"digest\",\n" +
            "                \"global_sequence\": \"5768776417\",\n" +
            "                \"recv_sequence\": 142,\n" +
            "                \"auth_sequence\": [\n" +
            "                    [\n" +
            "                        \"receiver2\",\n" +
            "                        2366\n" +
            "                    ]\n" +
            "                ],\n" +
            "                \"code_sequence\": 2,\n" +
            "                \"abi_sequence\": 2\n" +
            "            },\n" +
            "            \"act\": {\n" +
            "                \"account\": \"eosio.token\",\n" +
            "                \"name\": \"transfer\",\n" +
            "                \"authorization\": [\n" +
            "                    {\n" +
            "                        \"actor\": \"receiver2\",\n" +
            "                        \"permission\": \"active\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"data\": {\n" +
            "                    \"from\": \"receiver2\",\n" +
            "                    \"to\": \"receiver1\",\n" +
            "                    \"quantity\": \"330.0000 EOS\",\n" +
            "                    \"memo\": \"2018-3 payroll\"\n" +
            "                },\n" +
            "                \"hex_data\": \"hex data\"\n" +
            "            },\n" +
            "            \"context_free\": false,\n" +
            "            \"elapsed\": 6,\n" +
            "            \"console\": \"\",\n" +
            "            \"trx_id\": \"transaction id\",\n" +
            "            \"block_num\": 49420058,\n" +
            "            \"block_time\": \"2019-03-25T06:08:05.000\",\n" +
            "            \"producer_block_id\": \"block id\",\n" +
            "            \"account_ram_deltas\": [],\n" +
            "            \"except\": null,\n" +
            "            \"inline_traces\": []\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    public static final String GET_KEY_ACCOUNTS_REQUEST = "{\n"+
            "\t\"public_key\": \"EOS public key\"\n"+
            "}";

    public static final String GET_KEY_ACCOUNTS_RESPONSE = "{\n" +
            "    \"account_names\": [\n" +
            "        \"test_account\"\n" +
            "    ]\n" +
            "}";

    public static final String GET_CONTROLLED_ACCOUNTS_REQUEST = "{\n" +
            "\t\"controlling_account\": \"test_account\"\n" +
            "}";

    public static final String GET_CONTROLLED_ACCOUNTS_RESPONSE = "{\n" +
            "    \"controlled_accounts\": []\n" +
            "}";
}

