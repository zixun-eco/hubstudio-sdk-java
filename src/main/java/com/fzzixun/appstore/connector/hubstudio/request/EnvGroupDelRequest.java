package com.fzzixun.appstore.connector.hubstudio.request;

/**
 * 删除环境分组
 */
public class EnvGroupDelRequest extends BaseRequest {

    @Override
    public String getCommand() {
        return "/api/v1/group/del";
    }
}
