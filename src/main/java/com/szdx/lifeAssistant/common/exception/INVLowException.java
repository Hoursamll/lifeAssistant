package com.szdx.lifeAssistant.common.exception;

public class INVLowException extends BizException{
	private static final long serialVersionUID = 1L;

	public INVLowException() {
        super();
    }

	public INVLowException(String message) {
        super(message);
    }

    public INVLowException(Throwable cause) {
        super(cause);
    }

    public INVLowException(String message, Throwable cause) {
        super(message, cause);
    }
}
