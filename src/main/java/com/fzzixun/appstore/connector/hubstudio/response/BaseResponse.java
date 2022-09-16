package com.fzzixun.appstore.connector.hubstudio.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BaseResponse {

    @ApiModelProperty("请求id")
    protected String requestId;

    @ApiModelProperty("是否成功")
    protected boolean success;

    @ApiModelProperty("返回结果")
    protected String result;

    @ApiModelProperty("错误信息")
    protected String message;

    public boolean isSuccess() {
        return this.success;
    }
}
