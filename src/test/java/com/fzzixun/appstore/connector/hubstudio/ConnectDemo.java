package com.fzzixun.appstore.connector.hubstudio;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fzzixun.appstore.connector.hubstudio.common.CommandClient;
import com.fzzixun.appstore.connector.hubstudio.config.CommandConfig;
import com.fzzixun.appstore.connector.hubstudio.handler.ClientOpenHandler;
import com.fzzixun.appstore.connector.hubstudio.handler.EnvOpenHandler;
import com.fzzixun.appstore.connector.hubstudio.handler.WebdriverHandler;
import com.fzzixun.appstore.connector.hubstudio.response.BaseResponse;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ConnectDemo {

    @Test
    public void test() throws InterruptedException, IOException {
        CommandClient client = new CommandClient(CommandConfig.APP_ID, CommandConfig.PRIVATE_KEY);

        ClientOpenHandler openHandler = new ClientOpenHandler();
        openHandler.openClient(client, "填写团队code");

        EnvOpenHandler envOpenHandler = new EnvOpenHandler();
        BaseResponse response = envOpenHandler.openEnv(client, "填写团队code", "填写环境code");
        JSONObject jsonObject = JSON.parseObject(response.getResult());
        Integer debuggingPort = jsonObject.getInteger("debuggingPort");

        // 获取webdriver
        ChromeDriver driver = WebdriverHandler.getDriver(debuggingPort);

        // 打开百度首页
        driver.get("https://www.baidu.com");
        // 获取输入框，输入hubstudio
        driver.findElement(By.id("kw")).sendKeys("hubstudio");
        // 获取“百度一下”按钮，进行搜索
        driver.findElement(By.id("su")).click();
        TimeUnit.SECONDS.sleep(5);

    }
}
