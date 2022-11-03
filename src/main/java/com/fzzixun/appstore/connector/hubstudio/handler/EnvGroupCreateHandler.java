package com.fzzixun.appstore.connector.hubstudio.handler;

import com.alibaba.fastjson.JSON;
import com.fzzixun.appstore.connector.hubstudio.common.CommandClient;
import com.fzzixun.appstore.connector.hubstudio.config.CommandConfig;
import com.fzzixun.appstore.connector.hubstudio.model.EnvGroupCreateModel;
import com.fzzixun.appstore.connector.hubstudio.request.EnvGroupCreateRequest;
import com.fzzixun.appstore.connector.hubstudio.response.BaseResponse;
import com.fzzixun.appstore.connector.hubstudio.response.EnvGroupCreateResponse;

public class EnvGroupCreateHandler {

    /**
     * 创建环境分组
     */
    public static EnvGroupCreateResponse createEnvGroup(CommandClient client, String tagName) {
        EnvGroupCreateRequest request = new EnvGroupCreateRequest();
        EnvGroupCreateModel model = new EnvGroupCreateModel();
        model.setTagName(tagName);
        request.setBizModel(model);

        BaseResponse response = client.execute(request);
        EnvGroupCreateResponse envGroupCreateResponse;
        if (response.isSuccess()) {
            System.out.println("创建环境分组成功:" + response.getResult());
            envGroupCreateResponse = JSON.parseObject(response.getResult(), EnvGroupCreateResponse.class);
        } else {
            System.out.println("创建环境分组失败:" + response.getMessage());
            envGroupCreateResponse = null;
        }
        return envGroupCreateResponse;
    }

    public static void main(String[] args) {
        CommandClient client = new CommandClient(CommandConfig.APP_ID, CommandConfig.PRIVATE_KEY);
        EnvGroupCreateResponse response = EnvGroupCreateHandler.createEnvGroup(client, "测试分组");
        if (response != null) {
            System.out.println(response.getTagCode());
        }
    }
}
