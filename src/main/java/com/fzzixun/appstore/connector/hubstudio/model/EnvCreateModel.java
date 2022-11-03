package com.fzzixun.appstore.connector.hubstudio.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("创建环境-请求参数")
public class EnvCreateModel {

    @ApiModelProperty(value = "使用方式 1静态 2动态")
    private Integer asDynamicType;

    @ApiModelProperty("环境名")
    private String containerName;

    @ApiModelProperty("代理帐号")
    private String proxyAccount;

    @ApiModelProperty("代理密码")
    private String proxyPassword;

    @ApiModelProperty("代理端口")
    private Integer proxyPort;

    @ApiModelProperty("代理主机")
    private String proxyServer;

    @ApiModelProperty("代理类型")
    private String proxyTypeName;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("分组")
    private String tagName;

    @ApiModelProperty("cookie")
    private String cookie;

    @ApiModelProperty("参考城市")
    private String referenceCity;

    @ApiModelProperty("参考国家代码")
    private String referenceCountryCode;

    @ApiModelProperty("参考州")
    private String referenceRegionCode;

}
