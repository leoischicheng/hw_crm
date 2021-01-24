package com.smartbee.crm.controller.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Leo
 * @Date :2021/1/24
 */
@ApiModel(description= "Client update dto")
@Data
public class ClientUpdateDto extends ClientCreateDto{
    @ApiModelProperty(name = "client id")
    private Integer id;

}
