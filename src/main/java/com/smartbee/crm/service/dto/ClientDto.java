package com.smartbee.crm.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author Leo
 * @Date :2021/1/24
 */
@ApiModel(description = "CLIENT")
@Data
public class ClientDto {
    @ApiModelProperty(value = "client id")
    private Integer id;
    @ApiModelProperty(value = "client company id")
    private Integer companyId;
    @ApiModelProperty(value = "client name")
    private String name;
    @ApiModelProperty(value = "client address")
    private String email;
    @ApiModelProperty(value = "client phone")
    private String phone;
    @ApiModelProperty(value = "client creator")
    private String createdBy;
    @ApiModelProperty(value = "create time")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createdAt;
    @ApiModelProperty(value = "client last updater")
    private String updatedBy;
    @ApiModelProperty(value = "update time")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp updatedAt;

}
