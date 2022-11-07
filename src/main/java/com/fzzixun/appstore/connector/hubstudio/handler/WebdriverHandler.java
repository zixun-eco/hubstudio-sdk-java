package com.fzzixun.appstore.connector.hubstudio.handler;

import com.fzzixun.appstore.connector.hubstudio.config.CommandConfig;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

public class WebdriverHandler {

    private static String init(int coreVersion) {
        String fileName;
        String resourceName;
        if (coreVersion == 100) {
            fileName = "./chromedriver100.exe";
            resourceName = "webdriver/chromedriver100.exe";
        } else if (coreVersion == 105) {
            fileName = "./chromedriver105.exe";
            resourceName = "webdriver/chromedriver105.exe";
        } else {
            throw new NullPointerException("未找到对应版本webdriver。版本:" + coreVersion);
        }
        File file = new File(fileName);
        if (!file.exists()) {
            InputStream inputStream = WebdriverHandler.class.getClassLoader().getResourceAsStream(resourceName);
            try {
                FileUtils.copyInputStreamToFile(inputStream, file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileName;
    }
    
    /**
     * 获取webdriver(100内核)
     */
    public static ChromeDriver getDriver(int port) {
        return getDriverByVersion(100, port);
    }

    /**
     * 根据内核版本获取webdriver
     */
    public static synchronized ChromeDriver getDriverByVersion(int coreVersion, int port) {
        init(coreVersion);
        if (coreVersion == 100) {
            System.setProperty("webdriver.chrome.driver", CommandConfig.WEBDRIVER_PATH_100);
        } else if (coreVersion == 105) {
            System.setProperty("webdriver.chrome.driver", CommandConfig.WEBDRIVER_PATH_105);
        }
        ChromeOptions chromeOptions = new ChromeOptions();
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
