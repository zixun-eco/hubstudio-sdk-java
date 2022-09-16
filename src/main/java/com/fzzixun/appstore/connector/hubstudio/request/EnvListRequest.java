package com.fzzixun.appstore.connector.hubstudio.request;

/**
 * 环境列表
 */
public class EnvListRequest extends BaseRequest {

    @Override
    public String getCommand() {
        return "env-list";
    }
}
