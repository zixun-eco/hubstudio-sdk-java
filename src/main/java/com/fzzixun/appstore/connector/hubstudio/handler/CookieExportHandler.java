package com.fzzixun.appstore.connector.hubstudio.handler;

import com.fzzixun.appstore.connector.hubstudio.common.CommandClient;
import com.fzzixun.appstore.connector.hubstudio.config.CommandConfig;
import com.fzzixun.appstore.connector.hubstudio.model.CookieExportModel;
import com.fzzixun.appstore.connector.hubstudio.request.CookieExportRequest;
import com.fzzixun.appstore.connector.hubstudio.response.BaseResponse;

public class CookieExportHandler {

    /**
     * 导出环境的cookie
     */
    public static String exportCookie(CommandClient client, Long containerCode) {
        CookieExportRequest request = new CookieExportRequest();
        CookieExportModel model = new CookieExportModel();
        model.setContainerCode(containerCode);

        request.setBizModel(model);
        BaseResponse response = client.execute(request);
        if (response.isSuccess()) {
            System.out.println("导出cookie成功:" + response.getResult());
            return response.getResult();
        } else {
            System.out.println("导出cookie失败:" + response.getMessage());
            return "";
        }
    }

    public static void main(String[] args) {
        CommandClient client = new CommandClient(CommandConfig.APP_ID, CommandConfig.PRIVATE_KEY);
        CookieExportHandler.exportCookie(client, 51225755L);
    }
}
