package com.smartbee.crm.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * @author Leo
 * @Date :2021/1/24
 */
@ApiModel(description = "COMPANY")
@Data
public class CompanyDto {
    @ApiModelProperty(value = "company id")
    private Integer id;
    @ApiModelProperty(value = "company name")
    private String name;
    @ApiModelProperty(value = "company address")
    private String address;
    @ApiModelProperty(value = "company creator")
    private String createdBy;
    @ApiModelProperty(value = "create time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createdAt;
    @ApiModelProperty(value = "company last updater")
    private String updatedBy;
    @ApiModelProperty(value = "update time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp updatedAt;

}
