package com.fzzixun.appstore.connector.hubstudio.handler;

import com.fzzixun.appstore.connector.hubstudio.common.CommandClient;
import com.fzzixun.appstore.connector.hubstudio.config.CommandConfig;
import com.fzzixun.appstore.connector.hubstudio.model.ProxyUpdateModel;
import com.fzzixun.appstore.connector.hubstudio.request.ProxyUpdateRequest;
import com.fzzixun.appstore.connector.hubstudio.response.BaseResponse;

public class ProxyUpdateHandler {

    /**
     * 更新代理
     */
    public void updateProxy(CommandClient client) {
        ProxyUpdateRequest request = new ProxyUpdateRequest();
        ProxyUpdateModel model = new ProxyUpdateModel();
        model.setGroupCode(10814480L);
        model.setContainerCode(8252570L);
        model.setAsDynamicType(2);
        model.setProxyTypeName("不使用代理");
        request.setBizModel(model);

        BaseResponse response = client.execute(request);
        if (response.isSuccess()) {
            System.out.println(response.getResult());
        } else {
            System.out.println("更新代理失败:" + response.getMessage());
        }
    }

    public static void main(String[] args) {
        ProxyUpdateHandler handler = new ProxyUpdateHandler();
        CommandClient client = new CommandClient(CommandConfig.APP_ID, CommandConfig.PRIVATE_KEY);
        handler.updateProxy(client);
    }
}
