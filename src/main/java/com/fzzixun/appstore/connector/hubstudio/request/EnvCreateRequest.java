package com.fzzixun.appstore.connector.hubstudio.request;

/**
 * 创建环境
 */
public class EnvCreateRequest extends BaseRequest {

    @Override
    public String getCommand() {
        return "env-create";
    }
}
