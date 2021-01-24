package com.smartbee.crm.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

/**
 * @author Leo
 * @Date :2021/1/24
 */
@Data
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String createdBy;
    @CreationTimestamp
    private Timestamp createdAt;
    private String updatedBy;
    @UpdateTimestamp
    private Timestamp updatedAt;
}
