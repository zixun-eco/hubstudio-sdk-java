package com.fzzixun.appstore.connector.hubstudio.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class EnvListResponse {

    private List<EnvInfo> list;

    @Data
    public static class EnvInfo {

        @ApiModelProperty("环境code")
        private String containerCode;

        @ApiModelProperty("环境名")
        private String containerName;

        @ApiModelProperty("分组")
        private String tagName;

        @ApiModelProperty("备注")
        private String remark;

        @ApiModelProperty("代理类型")
        private String proxyTypeName;

        @ApiModelProperty(value = "使用方式 1静态 2动态")
        private Integer asDynamicType;

        @ApiModelProperty("代理主机")
        private String proxyHost;

        @ApiModelProperty("代理端口")
        private Integer proxyPort;


        @ApiModelProperty("最后使用ip")
        private String lastUsedIp;

        @ApiModelProperty("")
        private String lastCountry;

        @ApiModelProperty("")
        private String lastRegion;

        @ApiModelProperty("")
        private String lastCity;


        @ApiModelProperty("参考城市")
        private String referenceCity;

        @ApiModelProperty("参考国家名")
        private String referenceCountryName;

        @ApiModelProperty("参考国家代码")
        private String referenceCountryCode;

        @ApiModelProperty("参考州")
        private String referenceRegionCode;

        @ApiModelProperty("打开时间")
        private String openTime;

        @ApiModelProperty("打开时间")
        private String allOpenTime;

        @ApiModelProperty("创建时间")
        private String createTime;
    }
}
