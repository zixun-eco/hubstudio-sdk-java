package com.fzzixun.appstore.connector.hubstudio.handler;

import com.fzzixun.appstore.connector.hubstudio.common.CommandClient;
import com.fzzixun.appstore.connector.hubstudio.config.CommandConfig;
import com.fzzixun.appstore.connector.hubstudio.model.ClientOpenModel;
import com.fzzixun.appstore.connector.hubstudio.request.ClientOpenRequest;
import com.fzzixun.appstore.connector.hubstudio.response.BaseResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientOpenHandler {

    /**
     * 打开客户端-首次启动
     */
    public static boolean openClient(CommandClient client, String groupCode) throws IOException {
        Process process = Runtime.getRuntime().exec(CommandConfig.CONNECTOR_PATH +
                " --client_path=" + CommandConfig.HUBSTUDIO_PATH +
                " --socket_port=" + CommandConfig.SOCKET_PORT);
        String s;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        while((s=bufferedReader.readLine()) != null) {
            System.out.println(s);
            if ("Startup complete".equals(s)) { // 判断程序正确执行完毕后退出到后台执行
                break;
            }
            if (("Update complete, need reopen").equals(s)) { // 判断更新完成需要重新启动
                System.out.println("程序更新完成，请重新启动");
                return false;
            }
            if (s.contains("Program started")) {    // 判断程序已启动
                System.out.println("程序已启动，无需重复启动");
                return true;
            }
        }

        return openClientChangeTeam(client, groupCode);
    }

    /**
     * 打开客户端-更换团队
     */
    public static boolean openClientChangeTeam(CommandClient client, String groupCode) {
        // 打开客户端
        System.out.println("打开客户端，获取坐席...");
        ClientOpenRequest request = new ClientOpenRequest();
        ClientOpenModel model = new ClientOpenModel();
        model.setGroupCode(groupCode);
        request.setBizModel(model);

        BaseResponse response = client.execute(request);
        if (response.isSuccess()) {
            System.out.println(response.getResult());
            return true;
        } else {
            System.out.println(response.getMessage());
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        CommandClient client = new CommandClient(CommandConfig.APP_ID, CommandConfig.PRIVATE_KEY);
        ClientOpenHandler.openClient(client, "11236255");
    }
}
