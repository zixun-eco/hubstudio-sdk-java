package com.fzzixun.appstore.connector.hubstudio.request;

/**
 * 关闭环境
 */
public class EnvCloseRequest extends BaseRequest {

    @Override
    public String getCommand() {
        return "env-close";
    }
}
