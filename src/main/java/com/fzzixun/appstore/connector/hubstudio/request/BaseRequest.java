package com.fzzixun.appstore.connector.hubstudio.request;

import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;

public abstract class BaseRequest {

    @ApiModelProperty(value = "请求参数对象")
    private Object bizModel;

    @ApiModelProperty(value = "命令")
    private String command;

    @ApiModelProperty(value = "请求id")
    private String requestId;

    public BaseRequest() {
        this.requestId = UUID.randomUUID().toString();
    }

    public BaseRequest(String command) {
        this.command = command;
        this.requestId = UUID.randomUUID().toString();
    }

    public BaseRequest(String command, String requestId) {
        this.command = command;
        this.requestId = requestId;
    }

    public Object getBizModel() {
        return bizModel;
    }

    public void setBizModel(Object bizModel) {
        this.bizModel = bizModel;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
