package com.qq.ai.bean;

import com.alibaba.fastjson.JSONObject;

/**
 * ai请求返回的参数
 * @author csxx_wmw
 *
 */
public class AiResult<T> {

	public static String RET = "ret";
	public static String MSG = "msg";
	public static String DATA = "data";
	
	/**
	 * 返回码，0表示成功，非0表示出错
	 */
	private int ret;
	/**
	 * 返回信息；ret非0时表示出错时错误原因
	 */
	private String msg;
	/**
	 * 返回的数据
	 */
	private T data;
	
	
	
	public AiResult(int ret, String msg, T data) {
		super();
		this.ret = ret;
		this.msg = msg;
		this.data = data;
	}
	
	
	public AiResult() {
		super();
	}


	public int getRet() {
		return ret;
	}
	public void setRet(int ret) {
		this.ret = ret;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
