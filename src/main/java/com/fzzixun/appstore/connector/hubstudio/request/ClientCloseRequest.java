package com.fzzixun.appstore.connector.hubstudio.request;

/**
 * 关闭客户端
 */
public class ClientCloseRequest extends BaseRequest {

    @Override
    public String getCommand() {
        return "client-close";
    }
}
