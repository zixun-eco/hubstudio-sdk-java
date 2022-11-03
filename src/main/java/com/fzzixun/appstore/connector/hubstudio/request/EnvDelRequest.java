package com.fzzixun.appstore.connector.hubstudio.request;

/**
 * 删除环境
 */
public class EnvDelRequest extends BaseRequest {

    @Override
    public String getCommand() {
        return "/api/v1/env/del";
    }
}
