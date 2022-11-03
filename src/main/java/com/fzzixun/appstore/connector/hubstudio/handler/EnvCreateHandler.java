package com.fzzixun.appstore.connector.hubstudio.handler;

import com.alibaba.fastjson.JSON;
import com.fzzixun.appstore.connector.hubstudio.common.CommandClient;
import com.fzzixun.appstore.connector.hubstudio.config.CommandConfig;
import com.fzzixun.appstore.connector.hubstudio.model.EnvCreateModel;
import com.fzzixun.appstore.connector.hubstudio.request.EnvCreateRequest;
import com.fzzixun.appstore.connector.hubstudio.response.BaseResponse;
import com.fzzixun.appstore.connector.hubstudio.response.EnvCreateResponse;

public class EnvCreateHandler {

    /**
     * 创建环境
     */
    public static EnvCreateResponse createEnv(CommandClient client) {
        EnvCreateRequest request = new EnvCreateRequest();
        EnvCreateModel model = new EnvCreateModel();
        model.setAsDynamicType(2);
        model.setContainerName("新环境5");
        model.setProxyTypeName("不使用代理");
        request.setBizModel(model);

        BaseResponse response = client.execute(request);
        EnvCreateResponse envCreateResponse;
        if (response.isSuccess()) {
            System.out.println(response.getResult());
            envCreateResponse = JSON.parseObject(response.getResult(), EnvCreateResponse.class);
        } else {
            System.out.println("创建环境失败:" + response.getMessage());
            envCreateResponse = null;
        }
        return envCreateResponse;
    }

    public static void main(String[] args) {
        CommandClient client = new CommandClient(CommandConfig.APP_ID, CommandConfig.PRIVATE_KEY);
        EnvCreateResponse response = EnvCreateHandler.createEnv(client);
        System.out.println(response.getContainerCode());
        System.out.println(response.getCoreVersion());
    }
}
