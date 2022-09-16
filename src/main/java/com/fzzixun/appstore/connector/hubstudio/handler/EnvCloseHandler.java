package com.fzzixun.appstore.connector.hubstudio.handler;

import com.fzzixun.appstore.connector.hubstudio.common.CommandClient;
import com.fzzixun.appstore.connector.hubstudio.config.CommandConfig;
import com.fzzixun.appstore.connector.hubstudio.model.EnvCloseModel;
import com.fzzixun.appstore.connector.hubstudio.request.EnvCloseRequest;
import com.fzzixun.appstore.connector.hubstudio.response.BaseResponse;

public class EnvCloseHandler {

    /**
     * 关闭环境
     */
    public void closeEnv(CommandClient client, EnvCloseModel model) {
        EnvCloseRequest request = new EnvCloseRequest();

        request.setBizModel(model);

        BaseResponse response = client.execute(request);
        if (response.isSuccess()) {
            System.out.println(response.getResult());
        } else {
            System.out.println("关闭环境失败:" + response.getMessage());
        }
    }

    public void closeEnv(CommandClient client, String groupCode, String containerCode) {
        EnvCloseModel model = new EnvCloseModel();
        model.setGroupCode(groupCode);
        model.setContainerCode(containerCode);
        this.closeEnv(client, model);
    }

    public static void main(String[] args) {
        EnvCloseHandler handler = new EnvCloseHandler();
        CommandClient client = new CommandClient(CommandConfig.APP_ID, CommandConfig.PRIVATE_KEY);
        handler.closeEnv(client, "紫讯科技23-4", "754110928");
    }
}
