package com.fzzixun.appstore.connector.hubstudio.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("分组列表-请求参数")
public class EnvGroupListModel {

    @ApiModelProperty(value = "团队code", required = true)
    private Long groupCode;

}
