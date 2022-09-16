package com.fzzixun.appstore.connector.hubstudio.handler;

import com.fzzixun.appstore.connector.hubstudio.config.CommandConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class WebdriverHandler {

    /**
     * 获取webdriver
     */
    public static ChromeDriver getDriver(int port) {
        System.setProperty("webdriver.chrome.driver", CommandConfig.WEBDRIVER_PATH);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.setExperimentalOption("debuggerAddress", "127.0.0.1:" + port);
        return new ChromeDriver(chromeOptions);
    }

    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = WebdriverHandler.getDriver(123);
        // 打开百度首页
        driver.get("https://www.baidu.com");
        // 获取输入框，输入hubstudio
        driver.findElement(By.id("kw")).sendKeys("hubstudio");
        // 获取“百度一下”按钮，进行搜索
        driver.findElement(By.id("su")).click();
        TimeUnit.SECONDS.sleep(5);
    }
}
