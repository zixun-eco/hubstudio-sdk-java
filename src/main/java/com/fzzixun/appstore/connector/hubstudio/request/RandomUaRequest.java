package com.fzzixun.appstore.connector.hubstudio.request;

/**
 * 获取随机UA
 */
public class RandomUaRequest extends BaseRequest {

    @Override
    public String getCommand() {
        return "/api/v1/env/random-ua";
    }
}
