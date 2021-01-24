package com.smartbee.crm.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Leo
 * @Date :2021/1/24
 */
@Data
@Entity
@Table(name = "company")
public class Company extends BaseEntity{
    @Column
    private String name;
    @Column
    private String address;
}
