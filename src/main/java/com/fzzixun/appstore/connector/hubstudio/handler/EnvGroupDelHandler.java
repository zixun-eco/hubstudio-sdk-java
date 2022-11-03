package com.fzzixun.appstore.connector.hubstudio.handler;

import com.fzzixun.appstore.connector.hubstudio.common.CommandClient;
import com.fzzixun.appstore.connector.hubstudio.config.CommandConfig;
import com.fzzixun.appstore.connector.hubstudio.model.EnvGroupDelModel;
import com.fzzixun.appstore.connector.hubstudio.request.EnvGroupDelRequest;
import com.fzzixun.appstore.connector.hubstudio.response.BaseResponse;

public class EnvGroupDelHandler {

    /**
     * 删除分组
     */
    public static boolean deleteGroup(CommandClient client, Long tagCode) {
        EnvGroupDelRequest request = new EnvGroupDelRequest();
        EnvGroupDelModel model = new EnvGroupDelModel();
        model.setTagCode(tagCode);

        request.setBizModel(model);
        BaseResponse response = client.execute(request);
        if (response.isSuccess()) {
            System.out.println("删除分组成功:" + response.getResult());
            return true;
        } else {
            System.out.println("删除分组失败:" + response.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        CommandClient client = new CommandClient(CommandConfig.APP_ID, CommandConfig.PRIVATE_KEY);
        EnvGroupDelHandler.deleteGroup(client, 8368345L);
    }
}
