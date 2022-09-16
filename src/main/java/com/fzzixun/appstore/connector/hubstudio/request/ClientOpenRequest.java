package com.fzzixun.appstore.connector.hubstudio.request;

/**
 * 启动客户端
 */
public class ClientOpenRequest extends BaseRequest {

    @Override
    public String getCommand() {
        return "client-open";
    }
}
