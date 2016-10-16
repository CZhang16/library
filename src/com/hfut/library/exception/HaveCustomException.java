package com.hfut.library.exception;
/**
 * 自定义用户名存在异常类
 * @author ZC
 *
 */
@SuppressWarnings("serial")
public class HaveCustomException extends Exception {
	public HaveCustomException(String msg){
		super(msg);
	}
}
