package com.fzzixun.appstore.connector.hubstudio.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("环境列表-请求参数")
public class EnvListModel {

    @ApiModelProperty(value = "环境id列表")
    private List<Long> containerCodes;

    @ApiModelProperty(value = "环境名称")
    private String containerName;

    @ApiModelProperty(value = "创建开始时间")
    private String createStartTime;

    @ApiModelProperty(value = "创建结束时间")
    private String createEndTime;

    @ApiModelProperty(value = "环境类型 1自建环境 2环境转移")
    private Integer createType;

    @ApiModelProperty(value = "代理ip查询")
    private String ipAddress;

    @ApiModelProperty(value = "代理ip类型列表")
    private List<String> proxyTypeNames;

    @ApiModelProperty(value = "不为空既是查询未分组")
    private Integer noTag;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "环境分组名称数组")
    private List<String> tagNames;

    @ApiModelProperty(value = "分页第几页偏移量")
    private Integer current;
    
    @ApiModelProperty(value = "分页条数")
    private Integer size;

}
