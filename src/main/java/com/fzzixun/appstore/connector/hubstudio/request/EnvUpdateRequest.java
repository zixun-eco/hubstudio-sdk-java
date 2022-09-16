package com.fzzixun.appstore.connector.hubstudio.request;

/**
 * 更新环境
 */
public class EnvUpdateRequest extends BaseRequest {

    @Override
    public String getCommand() {
        return "env-update";
    }
}
