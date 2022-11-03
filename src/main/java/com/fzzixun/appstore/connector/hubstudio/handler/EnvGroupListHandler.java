package com.fzzixun.appstore.connector.hubstudio.handler;

import com.alibaba.fastjson.JSON;
import com.fzzixun.appstore.connector.hubstudio.common.CommandClient;
import com.fzzixun.appstore.connector.hubstudio.config.CommandConfig;
import com.fzzixun.appstore.connector.hubstudio.request.EnvGroupListRequest;
import com.fzzixun.appstore.connector.hubstudio.response.BaseResponse;
import com.fzzixun.appstore.connector.hubstudio.response.EnvGroupResponse;

import java.util.List;

public class EnvGroupListHandler {

    /**
     * 获取分组列表
     */
    public static List<EnvGroupResponse> listEnvGroup(CommandClient client) {
        EnvGroupListRequest request = new EnvGroupListRequest();

        BaseResponse response = client.execute(request);
        List<EnvGroupResponse> envGroupResponse;
        if (response.isSuccess()) {
            System.out.println(response.getResult());
            envGroupResponse = JSON.parseArray(response.getResult(), EnvGroupResponse.class);
        } else {
            System.out.println("获取分组列表失败:" + response.getMessage());
            envGroupResponse = null;
        }
        return envGroupResponse;
    }

    public static void main(String[] args) {
        CommandClient client = new CommandClient(CommandConfig.APP_ID, CommandConfig.PRIVATE_KEY);
        List<EnvGroupResponse> envGroupResponses = EnvGroupListHandler.listEnvGroup(client);
    }
}
