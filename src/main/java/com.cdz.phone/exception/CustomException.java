package com.soa.mdm.exception;

/**
 * 系统自定义异常类
 * @author 曾兵
 * @company 
 * @createTime 2017年10月22日
 * @projectName phone
 * @className CustomException
 */
@SuppressWarnings("serial")
public class CustomException extends Exception{

    //异常信息
    public String message;

    /**
     * @param message
     */
    public CustomException(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
