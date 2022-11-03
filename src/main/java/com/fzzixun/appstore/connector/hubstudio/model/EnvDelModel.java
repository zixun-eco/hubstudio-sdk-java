package com.fzzixun.appstore.connector.hubstudio.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("删除环境-请求参数")
public class EnvDelModel {

    @ApiModelProperty(value = "环境id列表")
    private List<Long> containerCodes;
}
