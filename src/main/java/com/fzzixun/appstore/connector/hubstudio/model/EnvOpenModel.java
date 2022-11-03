package com.fzzixun.appstore.connector.hubstudio.model;

import com.google.common.collect.ImmutableList;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel("打开环境-请求参数")
public class EnvOpenModel {

    @ApiModelProperty("环境code")
    private String containerCode;

    @ApiModelProperty("是否无头模式")
    private Boolean isHeadless = false;

    @ApiModelProperty("")
    private Boolean isWebDriverReadOnlyMode = true;

    @ApiModelProperty("启动参数")
    private final List<String> args = new ArrayList<>();

    public EnvOpenModel addArguments(String... arguments) {
        addArguments(ImmutableList.copyOf(arguments));
        return this;
    }

    public EnvOpenModel addArguments(List<String> arguments) {
        args.addAll(arguments);
        return this;
    }

    public List<String> getArgs() {
        return args;
    }
}
