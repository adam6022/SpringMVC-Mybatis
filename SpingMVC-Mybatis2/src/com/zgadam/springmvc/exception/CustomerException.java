package com.zgadam.springmvc.exception;
/**
 * �Զ����쳣��
 * @author Apple
 *
 */
public class CustomerException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String msg;

	public CustomerException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
