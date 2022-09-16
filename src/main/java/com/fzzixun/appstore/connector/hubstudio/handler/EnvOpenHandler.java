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
    public BaseResponse openEnv(CommandClient client, String groupCode, String containerCode) {
        EnvOpenRequest request = new EnvOpenRequest();
        EnvOpenModel model = new EnvOpenModel();
        model.setGroupCode(groupCode);
        model.setContainerCode(containerCode);
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
        EnvOpenHandler handler = new EnvOpenHandler();
        CommandClient client = new CommandClient(CommandConfig.APP_ID, CommandConfig.PRIVATE_KEY);
        handler.openEnv(client, "紫讯科技23-4", "570114613");
    }
}
