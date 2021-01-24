package com.smartbee.crm.handler;

import com.smartbee.crm.common.constants.WebErrorCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Leo
 * @Date :2021/1/24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BusinessException extends RuntimeException{

    private static final long serialVersionUID = -6651262405626297138L;

    private Object data;
    private Object responseData;
    private WebErrorCode webErrorCode;

    public BusinessException(WebErrorCode webErrorCode) {
        super(webErrorCode.getMessage());
        this.webErrorCode=webErrorCode;
    }

    public BusinessException(WebErrorCode webErrorCode, Object data) {
        super(webErrorCode.getMessage());
        this.webErrorCode = webErrorCode;
        this.data = data;
    }
}
