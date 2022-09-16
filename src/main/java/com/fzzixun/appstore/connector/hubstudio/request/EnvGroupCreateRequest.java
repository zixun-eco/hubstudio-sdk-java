package com.fzzixun.appstore.connector.hubstudio.request;

/**
 * 分组创建
 */
public class EnvGroupCreateRequest extends BaseRequest {

    @Override
    public String getCommand() {
        return "env-group-create";
    }
}
