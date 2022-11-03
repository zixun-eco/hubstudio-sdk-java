package com.fzzixun.appstore.connector.hubstudio.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("删除分组-请求参数")
public class EnvGroupDelModel {

    @ApiModelProperty("分组id")
    private Long tagCode;
}
