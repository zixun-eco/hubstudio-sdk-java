package com.fzzixun.appstore.connector.hubstudio.common;

import com.alibaba.fastjson.JSON;
import com.fzzixun.appstore.connector.hubstudio.config.CommandConfig;
import com.fzzixun.appstore.connector.hubstudio.request.BaseRequest;
import com.fzzixun.appstore.connector.hubstudio.response.BaseResponse;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CommandClient {

    /**
     * 平台提供的appId
     */
    private final String appId;

    /**
     * 开放平台提供的私钥
     */
    private final String privateKey;


    private final int socketPort;

    public CommandClient(String appId, String privateKey) {
        this.appId = appId;
        this.privateKey = privateKey;
        this.socketPort = CommandConfig.SOCKET_PORT;
    }

    public CommandClient(String appId, String privateKey, int socketPort) {
        this.appId = appId;
        this.privateKey = privateKey;
        this.socketPort = socketPort;
    }

    public BaseResponse execute(BaseRequest request) {
        String params = buildParams(request);
        try {
            String response = sendSocket(params, this.socketPort);
            return JSON.parseObject(response, BaseResponse.class);
        } catch (IOException e) {
            throw new RuntimeException("请求失败:" + e.getMessage());
        }
    }

    public String buildParams(BaseRequest request) {
        Map<String, Object> params = new HashMap<>();
        params.put("command", request.getCommand());
        params.put("appId", this.appId);
        params.put("privateKey", this.privateKey);
        String requestId = request.getRequestId();
        if (requestId == null || requestId.length() == 0) {
            requestId = UUID.randomUUID().toString();
        }
        params.put("requestId", requestId);
        params.put("bizContent", request.getBizModel());
        return JSON.toJSONString(params);
    }

    public String sendSocket(String message, int socketPort) throws IOException {
//        System.out.println("请求数据:" + message);
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", socketPort);
        Socket socket = null;
        BufferedWriter writer;
        String result = null;
        try {
            socket = new Socket();
            socket.setSoTimeout(CommandConfig.SOCKET_SO_TIMEOUT);
            socket.connect(socketAddress, CommandConfig.SOCKET_CONNECT_TIMEOUT);

            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
            writer.write(message);
            writer.write("\r\n");
            writer.flush();
            result = receiveData(socket);
            socket.close();
            socket = null;
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
        return result;
    }

    public String receiveData(Socket socket) throws IOException {
        InputStream socketInputStream = socket.getInputStream();
        InputStream inputStream = new BufferedInputStream(socketInputStream);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String result = reader.readLine();
        reader.close();
        return result;
    }
}
