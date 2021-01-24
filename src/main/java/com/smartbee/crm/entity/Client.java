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
@Table(name = "client")
public class Client extends BaseEntity {
    @Column
    private Long companyId;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String phone;
}
