package com.fzzixun.appstore.connector.hubstudio.request;

/**
 * 分组列表
 */
public class EnvGroupListRequest extends BaseRequest {

    @Override
    public String getCommand() {
        return "env-group-list";
    }
}
