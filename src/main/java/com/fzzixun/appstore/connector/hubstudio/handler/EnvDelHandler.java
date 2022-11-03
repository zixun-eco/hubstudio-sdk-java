package com.fzzixun.appstore.connector.hubstudio.handler;

import com.fzzixun.appstore.connector.hubstudio.common.CommandClient;
import com.fzzixun.appstore.connector.hubstudio.config.CommandConfig;
import com.fzzixun.appstore.connector.hubstudio.model.EnvDelModel;
import com.fzzixun.appstore.connector.hubstudio.request.EnvDelRequest;
import com.fzzixun.appstore.connector.hubstudio.response.BaseResponse;

import java.util.Collections;
import java.util.List;

public class EnvDelHandler {

    /**
     * 删除环境
     */
    public static boolean deleteEnv(CommandClient client, Long containerCode) {
        return deleteEnvList(client, Collections.singletonList(containerCode));
    }

    /**
     * 批量删除环境
     */
    public static boolean deleteEnvList(CommandClient client, List<Long> containerCodes) {
        EnvDelRequest request = new EnvDelRequest();
        EnvDelModel model = new EnvDelModel();
        model.setContainerCodes(containerCodes);

        request.setBizModel(model);
        BaseResponse response = client.execute(request);
        if (response.isSuccess()) {
            System.out.println("删除环境成功:" + response.getResult());
            return true;
        } else {
            System.out.println("删除环境失败:" + response.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        CommandClient client = new CommandClient(CommandConfig.APP_ID, CommandConfig.PRIVATE_KEY);
        EnvDelHandler.deleteEnv(client, 51225755L);
    }
}
