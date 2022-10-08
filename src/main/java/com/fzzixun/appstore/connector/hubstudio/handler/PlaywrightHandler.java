package com.fzzixun.appstore.connector.hubstudio.handler;

import com.microsoft.playwright.*;

public class PlaywrightHandler {

    /**
     * 获取浏览器会话
     * @param port 调试端口
     */
    public static BrowserContext getBrowserContext(int port) {
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.connectOverCDP("http://127.0.0.1:" + port);
        return browser.contexts().get(0);
    }

    public static void openBaidu(BrowserContext browserContext) {
        // 第一个标签页
        Page page = browserContext.pages().get(0);
        page.navigate("https://playwright.dev/");
        System.out.println(page.title());

        // 新建标签页
        Page newPage = browserContext.newPage();
        // 打开百度
        newPage.navigate("https://www.baidu.com");
        System.out.println(newPage.title());
        // 输入hubstudio并搜索
        newPage.fill("input[name=\"wd\"]", "hubstudio");
        newPage.press("input[id=\"su\"]", "Enter");
    }

    public static void main(String[] args) {
        BrowserContext browserContext = getBrowserContext(48164);
        openBaidu(browserContext);
    }
}
