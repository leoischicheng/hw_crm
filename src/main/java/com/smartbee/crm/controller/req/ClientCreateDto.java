package com.smartbee.crm.controller.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Leo
 * @Date :2021/1/24
 */
@ApiModel(description= "Client create dto")
@Data
public class ClientCreateDto {
    @ApiModelProperty(name = "Client compon id ")
    private Integer companyId;
    @ApiModelProperty(name = "Client name")
    private String name;
    @ApiModelProperty(name = "company email")
    private String email;
    @ApiModelProperty(name = "company phone")
    private String phone;
}
