package com.fzzixun.appstore.connector.hubstudio.handler;

import com.fzzixun.appstore.connector.hubstudio.common.CommandClient;
import com.fzzixun.appstore.connector.hubstudio.config.CommandConfig;
import com.fzzixun.appstore.connector.hubstudio.request.ClientCloseRequest;
import com.fzzixun.appstore.connector.hubstudio.response.BaseResponse;

import java.util.UUID;

public class ClientCloseHandler {

    /**
     * 关闭客户端并释放坐席
     */
    public void closeClient(CommandClient client) {
        ClientCloseRequest request = new ClientCloseRequest();
        request.setRequestId(UUID.randomUUID().toString());

        BaseResponse response = client.execute(request);
        if (response.isSuccess()) {
            System.out.println(response.getResult());
        } else {
            System.out.println(response.getMessage());
        }
    }

    public static void main(String[] args) {
        ClientCloseHandler handler = new ClientCloseHandler();
        CommandClient client = new CommandClient(CommandConfig.APP_ID, CommandConfig.PRIVATE_KEY);
        handler.closeClient(client);
    }
}
