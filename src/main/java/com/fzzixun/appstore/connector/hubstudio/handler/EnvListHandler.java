package com.fzzixun.appstore.connector.hubstudio.handler;

import com.alibaba.fastjson.JSON;
import com.fzzixun.appstore.connector.hubstudio.common.CommandClient;
import com.fzzixun.appstore.connector.hubstudio.config.CommandConfig;
import com.fzzixun.appstore.connector.hubstudio.model.EnvListModel;
import com.fzzixun.appstore.connector.hubstudio.request.EnvListRequest;
import com.fzzixun.appstore.connector.hubstudio.response.BaseResponse;
import com.fzzixun.appstore.connector.hubstudio.response.EnvListResponse;

public class EnvListHandler {

    /**
     * 获取环境列表
     */
    public EnvListResponse listEnv(CommandClient client) {
        EnvListRequest request = new EnvListRequest();
        EnvListModel model = new EnvListModel();
        model.setGroupCode(10814480L);
//        model.setContainerCodes(Arrays.asList(8252570L, 8252572L));
//        model.setNoTag(1);
        model.setCurrent(1);
        model.setSize(10);
        request.setBizModel(model);

        BaseResponse response = client.execute(request);
        EnvListResponse envListResponse;
        if (response.isSuccess()) {
            System.out.println(response.getResult());
            envListResponse = JSON.parseObject(response.getResult(), EnvListResponse.class);
        } else {
            System.out.println("获取环境列表失败:" + response.getMessage());
            envListResponse = null;
        }
        return envListResponse;
    }

    public static void main(String[] args) {
        EnvListHandler handler = new EnvListHandler();
        CommandClient client = new CommandClient(CommandConfig.APP_ID, CommandConfig.PRIVATE_KEY);
        EnvListResponse envListResponse = handler.listEnv(client);
    }
}
