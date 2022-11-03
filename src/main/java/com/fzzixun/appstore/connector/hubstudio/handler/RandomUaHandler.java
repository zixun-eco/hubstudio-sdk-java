package com.fzzixun.appstore.connector.hubstudio.handler;

import com.fzzixun.appstore.connector.hubstudio.common.CommandClient;
import com.fzzixun.appstore.connector.hubstudio.config.CommandConfig;
import com.fzzixun.appstore.connector.hubstudio.model.RandomUaModel;
import com.fzzixun.appstore.connector.hubstudio.request.RandomUaRequest;
import com.fzzixun.appstore.connector.hubstudio.response.BaseResponse;

import java.util.Arrays;
import java.util.List;

public class RandomUaHandler {

    /**
     * 获取随机UA
     */
    public static String randomUa(CommandClient client, String systemType) {
        return randomUa(client, systemType, null, null);
    }

    public static String randomUa(CommandClient client, String systemType, String phoneModel, List<Integer> version) {
        RandomUaRequest request = new RandomUaRequest();
        RandomUaModel model = new RandomUaModel();
        model.setType(systemType);
        model.setPhoneModel(phoneModel);
        model.setVersion(version);

        request.setBizModel(model);
        BaseResponse response = client.execute(request);
        if (response.isSuccess()) {
            System.out.println("获取随机UA成功:" + response.getResult());
            return response.getResult();
        } else {
            System.out.println("获取随机UA失败:" + response.getMessage());
            return "";
        }
    }

    public static void main(String[] args) {
        CommandClient client = new CommandClient(CommandConfig.APP_ID, CommandConfig.PRIVATE_KEY);
        System.out.println(RandomUaHandler.randomUa(client, "windows"));
        System.out.println(RandomUaHandler.randomUa(client, "windows", null, Arrays.asList(100, 101)));
        System.out.println(RandomUaHandler.randomUa(client, "android", "三星Galaxy S9+", Arrays.asList(105, 98)));
    }
}
