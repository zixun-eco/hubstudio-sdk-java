package com.fzzixun.appstore.connector.hubstudio.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("导出环境的cookie-请求参数")
public class CookieExportModel {

    @ApiModelProperty(value = "环境id", required = true)
    private Long containerCode;

}
