package com.fzzixun.appstore.connector.hubstudio.handler;

import com.fzzixun.appstore.connector.hubstudio.common.CommandClient;
import com.fzzixun.appstore.connector.hubstudio.config.CommandConfig;
import com.fzzixun.appstore.connector.hubstudio.model.EnvOpenModel;
import com.fzzixun.appstore.connector.hubstudio.request.EnvOpenRequest;
import com.fzzixun.appstore.connector.hubstudio.response.BaseResponse;

public class EnvOpenHandler {

    /**
     * 打开环境
     */
    public static BaseResponse openEnv(CommandClient client, String containerCode) {
        EnvOpenRequest request = new EnvOpenRequest();
        EnvOpenModel model = new EnvOpenModel();
        model.setContainerCode(containerCode);
        model.addArguments("--disable-extensions"); // 禁用插件
        model.addArguments("--blink-settings=imagesEnabled=false"); // 禁止加载图片
        request.setBizModel(model);

        BaseResponse response = client.execute(request);
        if (response.isSuccess()) {
            System.out.println(response.getResult());
        } else {
            System.out.println("打开环境失败:" + response.getMessage());
        }
        return response;
    }

    public static void main(String[] args) {
        CommandClient client = new CommandClient(CommandConfig.APP_ID, CommandConfig.PRIVATE_KEY);
        EnvOpenHandler.openEnv(client, "570114613");
    }
}
