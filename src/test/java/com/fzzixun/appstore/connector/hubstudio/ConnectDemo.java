package com.fzzixun.appstore.connector.hubstudio;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fzzixun.appstore.connector.hubstudio.common.CommandClient;
import com.fzzixun.appstore.connector.hubstudio.config.CommandConfig;
import com.fzzixun.appstore.connector.hubstudio.handler.ClientOpenHandler;
import com.fzzixun.appstore.connector.hubstudio.handler.EnvCreateHandler;
import com.fzzixun.appstore.connector.hubstudio.handler.EnvOpenHandler;
import com.fzzixun.appstore.connector.hubstudio.handler.WebdriverHandler;
import com.fzzixun.appstore.connector.hubstudio.response.BaseResponse;
import com.fzzixun.appstore.connector.hubstudio.response.EnvCreateResponse;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ConnectDemo {

    @Test
    public void test() throws InterruptedException, IOException {
        CommandClient client = new CommandClient(CommandConfig.APP_ID, CommandConfig.PRIVATE_KEY);

        boolean openResult = ClientOpenHandler.openClient(client, "11236255");
        if (!openResult) {
            return;
        }
        // 创建环境
        EnvCreateResponse envCreateResponse = EnvCreateHandler.createEnv(client);
        // 打开环境
        BaseResponse response = EnvOpenHandler.openEnv(client, envCreateResponse.getContainerCode().toString());
        JSONObject jsonObject = JSON.parseObject(response.getResult());
        Integer debuggingPort = jsonObject.getInteger("debuggingPort");

        // 获取webdriver
        ChromeDriver driver = WebdriverHandler.getDriverByVersion(envCreateResponse.getCoreVersion(), debuggingPort);

        // 打开百度首页
        driver.get("https://www.baidu.com");
        // 获取输入框，输入hubstudio
        driver.findElement(By.id("kw")).sendKeys("hubstudio");
        // 获取“百度一下”按钮，进行搜索
        driver.findElement(By.id("su")).click();
        TimeUnit.SECONDS.sleep(5);

    }
}
