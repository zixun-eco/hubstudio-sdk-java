package com.fzzixun.appstore.connector.hubstudio.handler;

import com.fzzixun.appstore.connector.hubstudio.common.CommandClient;
import com.fzzixun.appstore.connector.hubstudio.config.CommandConfig;
import com.fzzixun.appstore.connector.hubstudio.model.EnvGroupListModel;
import com.fzzixun.appstore.connector.hubstudio.request.EnvGroupListRequest;
import com.fzzixun.appstore.connector.hubstudio.response.BaseResponse;

public class EnvGroupListHandler {

    /**
     * 获取分组列表
     */
    public void listEnvGroup(CommandClient client, Long groupCode) {
        EnvGroupListRequest request = new EnvGroupListRequest();
        EnvGroupListModel model = new EnvGroupListModel();
        model.setGroupCode(groupCode);
        request.setBizModel(model);

        BaseResponse response = client.execute(request);
        if (response.isSuccess()) {
            System.out.println(response.getResult());
        } else {
            System.out.println("获取分组列表失败:" + response.getMessage());
        }
    }

    public static void main(String[] args) {
        EnvGroupListHandler handler = new EnvGroupListHandler();
        CommandClient client = new CommandClient(CommandConfig.APP_ID, CommandConfig.PRIVATE_KEY);
        handler.listEnvGroup(client, 10814480L);
    }
}
