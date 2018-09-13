package com.szdx.lifeAssistant.common.exception;
/*
 * 业务异常定义
 */
public class BizException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public BizException() {
        super();
    }
	
	public BizException(String message) {
        super(message);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }
}
