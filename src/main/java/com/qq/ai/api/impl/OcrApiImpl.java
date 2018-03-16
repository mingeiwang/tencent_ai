package com.qq.ai.api.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.qq.ai.util.HttpUtil;
import com.qq.ai.util.URLConstants;

/**
 * 证件识别api
 * 
 * @author csxx_wmw
 *
 */

public class OcrApiImpl {

	private static final Logger log = LoggerFactory.getLogger(OcrApiImpl.class);
	
	private String appid;
	private String secret;
	
	
	public OcrApiImpl(String appid, String secret) {
		super();
		this.appid = appid;
		this.secret = secret;
	}
	
	

	public OcrApiImpl() {
		super();
	}


	

	public String getAppid() {
		return appid;
	}



	public void setAppid(String appid) {
		this.appid = appid;
	}



	public String getSecret() {
		return secret;
	}



	public void setSecret(String secret) {
		this.secret = secret;
	}



	/**
	 * 身份证OCR识别
	 * @param appid
	 * 			appid
	 * @param time_stamp
	 * 			时间戳，精确到秒
	 * @param nonceStr
	 * 			随机字符串，非空，且小于32字节
	 * @param sign
	 * 			签名
	 * @param image
	 * 			上传的身份证照片，原始图片小于1MB
	 * @param cardType
	 * 			身份证图片类型：0-正面，1-反面
	 * @return
	 */
	public JSONObject idCardOcr(String appid, int time_stamp, String nonceStr, String sign, 
			String image, int cardType) {
		StringBuffer paramater = new StringBuffer();
		paramater.append("appid=").append(appid)
				.append("&").append("time_stanp=").append(time_stamp)
				.append("&").append("nonce_str=").append(nonceStr)
				.append("&").append("sign=").append(sign)
				.append("&").append("image=").append(image)
				.append("&").append("card_type=").append(cardType);
		log.debug("OCR身份证识别，请求参数：{}",paramater.toString());
		return HttpUtil.sendPost(URLConstants.OCR_ID_CARD, paramater.toString());
	}
	
	/**
	 * OCR名片识别
	 * @param appid
	 * 			appid
	 * @param time_stamp
	 * 			时间戳，精确到秒
	 * @param nonceStr
	 * 			随机字符串，上限32字节
	 * @param sign
	 * 			签名
	 * @param image
	 * 			图片base64编码，限制原始图片小于1MB
	 * @return
	 */
	public JSONObject bcOcr(String appid, int time_stamp, String nonceStr, String sign, 
			String image) {
		StringBuffer paramater = new StringBuffer();
		paramater.append("appid=").append(appid)
				.append("&").append("time_stanp=").append(time_stamp)
				.append("&").append("nonce_str=").append(nonceStr)
				.append("&").append("sign=").append(sign)
				.append("&").append("image=").append(image);
		log.debug("OCR名片识别，请求参数：{}",paramater.toString());
		return HttpUtil.sendPost(URLConstants.OCR_BC_OCR, paramater.toString());
	}
	
	/**
	 * 行驶证，驾驶证识别
	 * @param appid
	 * 			appid
	 * @param time_stamp
	 * 			时间戳，精确到秒
	 * @param nonceStr
	 * 			随机字符串
	 * @param sign
	 * 			数字签名
	 * @param image
	 * 			行驶证、驾驶证base64编码，原始图片大小不超过1MB
	 * @param type
	 * 			识别类型：0-行驶证识别，2 驾驶证识别
	 * @return
	 */
	public JSONObject driverLicenseOcr(String appid, int time_stamp, String nonceStr, String sign, 
			String image, int type) {
		StringBuffer paramater = new StringBuffer();
		paramater.append("appid=").append(appid)
				.append("&").append("time_stanp=").append(time_stamp)
				.append("&").append("nonce_str=").append(nonceStr)
				.append("&").append("sign=").append(sign)
				.append("&").append("image=").append(image)
				.append("&").append("type").append(type);
		log.debug("OCR行驶证、驾驶证识别，请求参数：{}",paramater.toString());
		return HttpUtil.sendPost(URLConstants.OCR_DRIVERLINCE, paramater.toString());
	}
	
	/**
	 * 营业执照识别
	 * @param appid
	 * @param time_stamp
	 * @param nonceStr
	 * @param sign
	 * @param image
	 * @return
	 */
	public JSONObject bizLicenseOcr(String appid, int time_stamp, String nonceStr, String sign, 
			String image) {
		StringBuffer paramater = new StringBuffer();
		paramater.append("appid=").append(appid)
				.append("&").append("time_stanp=").append(time_stamp)
				.append("&").append("nonce_str=").append(nonceStr)
				.append("&").append("sign=").append(sign)
				.append("&").append("image=").append(image);
		log.debug("OCR营业执照识别，请求参数：{}",paramater.toString());
		return HttpUtil.sendPost(URLConstants.OCR_BIZLICENSE, paramater.toString());
	}
	
	/**
	 * 银行卡识别
	 * @param appid
	 * 			appid
	 * @param time_stamp
	 * 			时间戳，精确到秒
	 * @param nonceStr
	 * 			随机字符串，不超过32字节
	 * @param sign
	 * 			签名
	 * @param image
	 * 			图片base64编码。原图不超过1MB
	 * @return
	 */
	public JSONObject creditCardOcr(String appid, int time_stamp, String nonceStr, String sign, 
			String image) {
		StringBuffer paramater = commonParamater(appid, time_stamp, nonceStr, sign, image);
		log.debug("OCR银行卡识别，请求参数：{}",paramater.toString());
		return HttpUtil.sendPost(URLConstants.OCR_BIZLICENSE, paramater.toString());
	}
	
	/**
	 * 公共请求参数生成
	 * @param appid
	 * 			appid
	 * @param time_stamp
	 * 			时间戳
	 * @param nonceStr
	 * 			随机字符串
	 * @param sign
	 * 			签名
	 * @param image
	 * 			图片base64 编码
	 * @return
	 */
	private StringBuffer commonParamater(String appid,int time_stamp,String nonceStr, String sign,
			String image){
		StringBuffer paramater = new StringBuffer();
		paramater.append("appid=").append(appid)
				.append("&").append("time_stanp=").append(time_stamp)
				.append("&").append("nonce_str=").append(nonceStr)
				.append("&").append("sign=").append(sign)
				.append("&").append("image=").append(image);
		return paramater;
	}
}
