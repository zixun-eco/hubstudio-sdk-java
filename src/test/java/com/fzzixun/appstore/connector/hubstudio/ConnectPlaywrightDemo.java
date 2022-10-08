package com.fzzixun.appstore.connector.hubstudio;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fzzixun.appstore.connector.hubstudio.common.CommandClient;
import com.fzzixun.appstore.connector.hubstudio.config.CommandConfig;
import com.fzzixun.appstore.connector.hubstudio.handler.ClientOpenHandler;
import com.fzzixun.appstore.connector.hubstudio.handler.EnvOpenHandler;
import com.fzzixun.appstore.connector.hubstudio.handler.PlaywrightHandler;
import com.fzzixun.appstore.connector.hubstudio.response.BaseResponse;
import com.microsoft.playwright.BrowserContext;
import org.junit.Test;

import java.io.IOException;

public class ConnectPlaywrightDemo {

    @Test
    public void test() throws IOException {
        CommandClient client = new CommandClient(CommandConfig.APP_ID, CommandConfig.PRIVATE_KEY);

        ClientOpenHandler openHandler = new ClientOpenHandler();
        openHandler.openClient(client, "11236255");

        EnvOpenHandler envOpenHandler = new EnvOpenHandler();
        BaseResponse response = envOpenHandler.openEnv(client, "11236255", "36767766");
        JSONObject jsonObject = JSON.parseObject(response.getResult());
        Integer debuggingPort = jsonObject.getInteger("debuggingPort");

        // 获取playwright浏览器会话
        BrowserContext browserContext = PlaywrightHandler.getBrowserContext(debuggingPort);
        // 运行脚本
        PlaywrightHandler.openBaidu(browserContext);

    }
}
