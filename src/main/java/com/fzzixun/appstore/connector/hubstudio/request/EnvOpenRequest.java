package com.fzzixun.appstore.connector.hubstudio.request;

/**
 * 启动环境
 */
public class EnvOpenRequest extends BaseRequest {

    @Override
    public String getCommand() {
        return "env-open";
    }
}
