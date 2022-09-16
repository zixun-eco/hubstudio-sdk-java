package com.fzzixun.appstore.connector.hubstudio.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("打开客户端-请求参数")
public class ClientOpenModel {

    @ApiModelProperty("团队code")
    private String groupCode;
}
