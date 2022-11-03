package com.fzzixun.appstore.connector.hubstudio.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("导入cookie-请求参数")
public class CookieImportModel {

    @ApiModelProperty(value = "环境id", required = true)
    private Long containerCode;

    @ApiModelProperty(value = "cookie", required = true)
    private String cookie;

}
