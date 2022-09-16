package com.fzzixun.appstore.connector.hubstudio.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("更新代理-请求参数")
public class ProxyUpdateModel {

    @ApiModelProperty(value = "团队code", required = true)
    private Long groupCode;

    @ApiModelProperty(value = "环境id", required = true)
    private Long containerCode;

    @ApiModelProperty(value = "使用方式 1静态 2动态", required = true)
    private Integer asDynamicType;

    @ApiModelProperty("代理主机地址")
    private String proxyHost;

    @ApiModelProperty("代理端口")
    private Integer proxyPort;

    @ApiModelProperty("代理帐号")
    private String proxyAccount;

    @ApiModelProperty("代理密码")
    private String proxyPassword;

    @ApiModelProperty("代理类型")
    private String proxyTypeName;

    @ApiModelProperty("参考城市")
    private String referenceCity;

    @ApiModelProperty("参考国家代码")
    private String referenceCountryCode;

    @ApiModelProperty("参考州")
    private String referenceRegionCode;

}
