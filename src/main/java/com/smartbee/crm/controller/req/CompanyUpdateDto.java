package com.smartbee.crm.controller.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Leo
 * @Date :2021/1/24
 */
@ApiModel(description= "Company update dto")
@Data
public class CompanyUpdateDto extends CompanyCreateDto{
    @ApiModelProperty(name = "company id")
    private Integer id;

}
