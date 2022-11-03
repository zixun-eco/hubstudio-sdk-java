package com.fzzixun.appstore.connector.hubstudio.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EnvCreateResponse {

    @ApiModelProperty("环境code")
    private Long containerCode;

    @ApiModelProperty("内核版本")
    private Integer coreVersion;
}
