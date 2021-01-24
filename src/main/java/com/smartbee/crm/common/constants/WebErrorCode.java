package com.smartbee.crm.common.constants;

/**
 * 通用回應錯誤碼
 * @author Leo
 */
public enum WebErrorCode {
    //成功回應
    SUCCESS("0000", "Success"),
    DB_ERROR("0001", "DB error"),
    UNKOW_ERROR("0002", "Unknown error"),
    PARA_MISSED_OR_FORMAT_FAILED("0003", "Some parameter missed or format failed"),
    DATA_NOT_FOUNT_ERROR("0004", "Data not found");

    private final String code;
    private final String message;

    WebErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + ": " + message;
    }
}
