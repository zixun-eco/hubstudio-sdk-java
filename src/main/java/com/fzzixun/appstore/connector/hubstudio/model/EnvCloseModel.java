package com.fzzixun.appstore.connector.hubstudio.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("关闭环境-请求参数")
public class EnvCloseModel {

    @ApiModelProperty("环境code")
    private String containerCode;

}
