package com.smartbee.crm.handler;

import com.smartbee.crm.common.constants.WebErrorCode;
import com.smartbee.crm.controller.resp.WebResp;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.HashMap;

/**
 * @author Leo
 * @Date :2021/1/24
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 捕獲  Exception 異常
     *
     * @param request  request
     * @param e        exception
     * @param response response
     * @return 響應結果
     */
    @ExceptionHandler(Exception.class)
    public WebResp globalExceptionHandler(HttpServletRequest request, final Exception e, HttpServletResponse response) {
        log.error("Exception happened:" , e);
        String message = e.getMessage();
        Throwable inner = null;
        Throwable root = e;
        while ((inner = root.getCause()) != null)
        {
            message += " " + inner.getMessage();
            root = inner;
        }

        String errMessage = e.getMessage();
        if(StringUtils.isBlank(errMessage)) {
            errMessage = WebErrorCode.UNKOW_ERROR.getMessage();
        }

        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        WebResp result = new WebResp(
                WebErrorCode.UNKOW_ERROR.getCode(),
                errMessage + ":" + message,
                currentTime
        );
        return result;
    }


    /**
     * 捕獲  DataAccessException 異常(DAO Exception)
     *
     * @param request  request
     * @param e        exception
     * @param response response
     * @return 響應結果
     */
    @ExceptionHandler(DataAccessException.class)
    public WebResp dataAccessExceptionHandler(HttpServletRequest request, final Exception e, HttpServletResponse response) {
        log.error("DB Exception happened:" , e);
        String message = e.getMessage();
        Throwable inner = null;
        Throwable root = e;
        while ((inner = root.getCause()) != null)
        {
            message += " " + inner.getMessage();
            root = inner;
        }
        return new WebResp(WebErrorCode.DB_ERROR.getCode(), WebErrorCode.DB_ERROR.getMessage() + ": " + message);
    }


//    /**
//     * bean validation 未通過Exception (Override handleMethodArgumentNotValid即可，無須另行宣告ExceptionHandler method)
//     *
//     */
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        BindingResult result = ex.getBindingResult();
//        String message = "";
//        if(result.hasErrors()){
//            List<ObjectError> list = result.getAllErrors();
//            StringBuffer errorMsgBuffer = new StringBuffer();
//            for(ObjectError error:list){
//                if (error instanceof FieldError) {
//                    FieldError errorMessage = (FieldError) error;
//                    errorMsgBuffer = errorMsgBuffer.append(errorMessage.getField() + " " + errorMessage.getDefaultMessage()+",");
//                }
//            }
//            //返回信息格式處理
//            message = errorMsgBuffer.toString().substring(0,errorMsgBuffer.length()-1);
//        }
//        WebResp webRespResult = new WebResp(WebErrorCode.PARA_MISSED_OR_FORMAT_FAILED.getCode() , WebErrorCode.PARA_MISSED_OR_FORMAT_FAILED.getMessage() + ": " + message);
//        return new ResponseEntity<>(webRespResult, headers, status);
//    }

    @ExceptionHandler(BusinessException.class)
    public WebResp handleException(BusinessException e){
        log.info("handleException BusinessErrorException:" + e.getMessage());
        log.info("handleException BusinessErrorException Data:" + e.getData());
        WebErrorCode status = e.getWebErrorCode();
        Object responseData = (null != e.getResponseData()) ? e.getResponseData() : new HashMap<>();
        return new WebResp(status.getCode(), e.getData().toString(), responseData);
    }
}
