package com.fzzixun.appstore.connector.hubstudio.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("更新环境-请求参数")
public class EnvUpdateModel {

    @ApiModelProperty(value = "环境id", required = true)
    private Long containerCode;

    @ApiModelProperty("环境名")
    private String containerName;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("分组")
    private String tagName;

}
