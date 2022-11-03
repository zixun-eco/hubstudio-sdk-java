package com.fzzixun.appstore.connector.hubstudio.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("创建分组-请求参数")
public class EnvGroupCreateModel {

    @ApiModelProperty(value = "分组",required = true)
    private String tagName;

}
