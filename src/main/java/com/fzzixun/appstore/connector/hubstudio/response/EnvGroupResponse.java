package com.fzzixun.appstore.connector.hubstudio.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EnvGroupResponse {

    @ApiModelProperty("分组id")
    private Long tagCode;

    @ApiModelProperty("分组名称")
    private String tagName;
}
