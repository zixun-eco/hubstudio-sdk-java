package com.fzzixun.appstore.connector.hubstudio.handler;

import com.fzzixun.appstore.connector.hubstudio.common.CommandClient;
import com.fzzixun.appstore.connector.hubstudio.config.CommandConfig;
import com.fzzixun.appstore.connector.hubstudio.model.EnvCreateModel;
import com.fzzixun.appstore.connector.hubstudio.request.EnvCreateRequest;
import com.fzzixun.appstore.connector.hubstudio.response.BaseResponse;

public class EnvCreateHandler {

    /**
     * 创建环境
     */
    public void createEnv(CommandClient client) {
        EnvCreateRequest request = new EnvCreateRequest();
        EnvCreateModel model = new EnvCreateModel();
        model.setGroupCode(10814480L);
        model.setAsDynamicType(2);
        model.setContainerName("新环境5");
        model.setProxyTypeName("HTTP");
        request.setBizModel(model);

        BaseResponse response = client.execute(request);
        if (response.isSuccess()) {
            System.out.println(response.getResult());
        } else {
            System.out.println("创建环境失败:" + response.getMessage());
        }
    }

    public static void main(String[] args) {
        EnvCreateHandler handler = new EnvCreateHandler();
        CommandClient client = new CommandClient(CommandConfig.APP_ID, CommandConfig.PRIVATE_KEY);
        handler.createEnv(client);
    }
}
