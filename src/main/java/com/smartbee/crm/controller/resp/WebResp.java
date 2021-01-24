package com.smartbee.crm.controller.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.smartbee.crm.common.constants.WebErrorCode;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @author Leo
 * @Date :2021/1/24
 */
@Data
@ApiModel(description= "API通用回傳物件")
public class WebResp<T> {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Timestamp timestamp;
    private String code;
    private String msg;
    private T data;

    public WebResp() {
        this.setCode(WebErrorCode.SUCCESS.getCode());
        this.setMsg(WebErrorCode.SUCCESS.getMessage());
        this.setTimestamp(new Timestamp(System.currentTimeMillis()));
    }

    public WebResp(String errorCode, String message, T data) {
        this.setCode(errorCode);
        this.setMsg(message);
        this.setData(data);
    }

    public WebResp(String errorCode, String message) {
        this.setCode(errorCode);
        this.setMsg(message);
        this.timestamp = new Timestamp(System.currentTimeMillis()) ;
    }

    public WebResp(T data) {
        this.setCode(WebErrorCode.SUCCESS.getCode());
        this.setMsg(WebErrorCode.SUCCESS.getMessage());
        this.setTimestamp(new Timestamp(System.currentTimeMillis()));
        this.setData(data);
    }
}
