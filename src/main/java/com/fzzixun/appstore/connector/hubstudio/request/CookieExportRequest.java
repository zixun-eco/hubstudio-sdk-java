package com.fzzixun.appstore.connector.hubstudio.request;

/**
 * 导出指定环境的cookie
 */
public class CookieExportRequest extends BaseRequest {

    @Override
    public String getCommand() {
        return "/api/v1/env/export-cookie";
    }
}
