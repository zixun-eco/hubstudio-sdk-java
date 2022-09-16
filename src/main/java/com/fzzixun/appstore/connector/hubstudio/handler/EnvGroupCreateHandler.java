package com.fzzixun.appstore.connector.hubstudio.handler;

import com.fzzixun.appstore.connector.hubstudio.common.CommandClient;
import com.fzzixun.appstore.connector.hubstudio.config.CommandConfig;
import com.fzzixun.appstore.connector.hubstudio.model.EnvGroupCreateModel;
import com.fzzixun.appstore.connector.hubstudio.request.EnvGroupCreateRequest;
import com.fzzixun.appstore.connector.hubstudio.response.BaseResponse;

public class EnvGroupCreateHandler {

    /**
     * 创建环境分组
     */
    public void createEnvGroup(CommandClient client) {
        EnvGroupCreateRequest request = new EnvGroupCreateRequest();
        EnvGroupCreateModel model = new EnvGroupCreateModel();
        model.setGroupCode(10814480L);
        model.setTagName("测试分组8.29");
        request.setBizModel(model);

        BaseResponse response = client.execute(request);
        if (response.isSuccess()) {
            System.out.println(response.getResult());
        } else {
            System.out.println("创建环境分组失败:" + response.getMessage());
        }
    }

    public static void main(String[] args) {
        EnvGroupCreateHandler handler = new EnvGroupCreateHandler();
        CommandClient client = new CommandClient(CommandConfig.APP_ID, CommandConfig.PRIVATE_KEY);
        handler.createEnvGroup(client);
    }
}
