package com.smartbee.crm.controller.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Leo
 * @Date :2021/1/24
 */
@ApiModel(description= "Company create dto")
@Data
public class CompanyCreateDto {
    @ApiModelProperty(name = "company name")
    private String name;
    @ApiModelProperty(name = "company address")
    private String address;

}
