package com.fzzixun.appstore.connector.hubstudio.handler;

import com.fzzixun.appstore.connector.hubstudio.common.CommandClient;
import com.fzzixun.appstore.connector.hubstudio.config.CommandConfig;
import com.fzzixun.appstore.connector.hubstudio.model.EnvUpdateModel;
import com.fzzixun.appstore.connector.hubstudio.request.EnvUpdateRequest;
import com.fzzixun.appstore.connector.hubstudio.response.BaseResponse;

public class EnvUpdateHandler {

    /**
     * 更新环境
     */
    public void updateEnv(CommandClient client) {
        EnvUpdateRequest request = new EnvUpdateRequest();
        EnvUpdateModel model = new EnvUpdateModel();
        model.setGroupCode(10814480L);
        model.setContainerCode(8253330L);
        model.setContainerName("新环境5-更新");
        model.setRemark("测试更新");
        model.setTagName("更新分组");
        request.setBizModel(model);

        BaseResponse response = client.execute(request);
        if (response.isSuccess()) {
            System.out.println(response.getResult());
        } else {
            System.out.println("更新环境失败:" + response.getMessage());
        }
    }

    public static void main(String[] args) {
        EnvUpdateHandler handler = new EnvUpdateHandler();
        CommandClient client = new CommandClient(CommandConfig.APP_ID, CommandConfig.PRIVATE_KEY);
        handler.updateEnv(client);
    }
}
