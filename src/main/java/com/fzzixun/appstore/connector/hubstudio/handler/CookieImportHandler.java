package com.fzzixun.appstore.connector.hubstudio.handler;

import com.fzzixun.appstore.connector.hubstudio.common.CommandClient;
import com.fzzixun.appstore.connector.hubstudio.config.CommandConfig;
import com.fzzixun.appstore.connector.hubstudio.model.CookieImportModel;
import com.fzzixun.appstore.connector.hubstudio.request.CookieImportRequest;
import com.fzzixun.appstore.connector.hubstudio.response.BaseResponse;

public class CookieImportHandler {

    /**
     * 向环境导入cookie
     */
    public static String importCookie(CommandClient client, Long containerCode, String cookie) {
        CookieImportRequest request = new CookieImportRequest();
        CookieImportModel model = new CookieImportModel();
        model.setContainerCode(containerCode);
        model.setCookie(cookie);

        request.setBizModel(model);
        BaseResponse response = client.execute(request);
        if (response.isSuccess()) {
            System.out.println("导入cookie成功:" + response.getResult());
            return response.getResult();
        } else {
            System.out.println("导入cookie失败:" + response.getMessage());
            return "";
        }
    }

    public static void main(String[] args) {
        CommandClient client = new CommandClient(CommandConfig.APP_ID, CommandConfig.PRIVATE_KEY);
        CookieImportHandler.importCookie(client, 51225755L,
                "[{\"Name\":\"CONSENT\",\"Value\":\"PENDING+571\",\"Domain\":\".google.com\",\"Path\":\"/\",\"Secure\":true,\"HttpOnly\":false,\"Persistent\":\"1\",\"Creation\":\"2022-09-14T15:18:07.389+08:00\",\"LastAccess\":\"2024-09-13T15:18:07.389+08:00\",\"Expires\":\"2024-09-13T15:18:07.389+08:00\",\"Priority\":\"1\",\"HasExpires\":\"1\",\"Samesite\":\"-1\",\"SourceScheme\":\"2\",\"Firstpartyonly\":\"\",\"schemeMap\":false,\"isSelf\":false}]");
    }
}
