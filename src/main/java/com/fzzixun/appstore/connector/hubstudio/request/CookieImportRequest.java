package com.fzzixun.appstore.connector.hubstudio.request;

/**
 * 向指定环境导入cookie
 */
public class CookieImportRequest extends BaseRequest {

    @Override
    public String getCommand() {
        return "/api/v1/env/import-cookie";
    }
}
