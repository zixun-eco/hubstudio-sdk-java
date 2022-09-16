package com.fzzixun.appstore.connector.hubstudio.request;

/**
 * 更新代理
 */
public class ProxyUpdateRequest extends BaseRequest {

    @Override
    public String getCommand() {
        return "proxy-update";
    }
}
