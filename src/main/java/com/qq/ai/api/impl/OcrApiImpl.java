package com.qq.ai.api.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.qq.ai.bean.AiResult;
import com.qq.ai.bean.IDCardOcrResult;
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
	
	private String appId;
	private String secret;
	
	
	public OcrApiImpl(String appId, String secret) {
		super();
		this.appId = appId;
		this.secret = secret;
	}
	
	

	public OcrApiImpl() {
		super();
	}


	

	public String getAppId() {
		return appId;
	}



	public void setAppId(String appId) {
		this.appId = appId;
	}



	public String getSecret() {
		return secret;
	}



	public void setSecret(String secret) {
		this.secret = secret;
	}



	/**
	 * 身份证OCR识别
	 * @param appId
	 * 			appId
	 * @param timeStamp
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
	public JSONObject idCardOcr(String appId, int timeStamp, String nonceStr, String sign, 
			String image, int cardType) {
		StringBuffer paramater = commonParamater(appId, timeStamp, nonceStr, sign, image);
		paramater.append("&").append("card_type=").append(cardType);
		log.debug("OCR身份证识别，请求参数：{}",paramater.toString());
		return HttpUtil.sendPost(URLConstants.OCR_ID_CARD, paramater.toString());
	}
	/**
	 * 身份证识别，返回对象
	 * @param appId
	 * 			appId
	 * @param timeStamp
	 * 			时间戳
	 * @param nonceStr
	 * 			随机字符串32字节
	 * @param sign
	 * 			签名
	 * @param image
	 * 			上传的身份证照片，原始图片小于1MB
	 * @param cardType
	 * 			身份证图片类型：0-正面，1-反面
	 * @return
	 * 		返回对应数据生成的bean
	 */
	public AiResult<IDCardOcrResult> idCardOcrToBean(String appId, int timeStamp, String nonceStr, String sign, 
			String image, int cardType){
		JSONObject json = idCardOcr(appId, timeStamp, nonceStr, sign, image, cardType);
		AiResult<IDCardOcrResult> idAiResult = null;
		if(json == null){
			idAiResult = IDCardOcrResult.createAiResult(json);
		}
		return idAiResult;
	}
	
	/**
	 * 身份证识别，返回对象
	 * @param timeStamp
	 * 			时间戳
	 * @param nonceStr
	 * 			随机字符串32字节
	 * @param sign
	 * 			签名
	 * @param image
	 * 			上传的身份证照片，原始图片小于1MB
	 * @param cardType
	 * 			身份证图片类型：0-正面，1-反面
	 * @return
	 * 		返回对应数据生成的bean，appId使用对象中appId
	 */
	public AiResult<IDCardOcrResult> idCardOcrToBean(int timeStamp, String nonceStr, String sign, 
			String image, int cardType){
		JSONObject json = idCardOcr(appId, timeStamp, nonceStr, sign, image, cardType);
		AiResult<IDCardOcrResult> idAiResult = null;
		if(json == null){
			idAiResult = IDCardOcrResult.createAiResult(json);
		}
		return idAiResult;
	}
	
	/**
	 * OCR名片识别
	 * @param appId
	 * 			appId
	 * @param timeStamp
	 * 			时间戳，精确到秒
	 * @param nonceStr
	 * 			随机字符串，上限32字节
	 * @param sign
	 * 			签名
	 * @param image
	 * 			图片base64编码，限制原始图片小于1MB
	 * @return
	 */
	public JSONObject bcOcr(String appId, int timeStamp, String nonceStr, String sign, 
			String image) {
		StringBuffer paramater = commonParamater(appId, timeStamp, nonceStr, sign, image);
		log.debug("OCR名片识别，请求参数：{}",paramater.toString());
		return HttpUtil.sendPost(URLConstants.OCR_BC_OCR, paramater.toString());
	}
	
	/**
	 * 行驶证，驾驶证识别
	 * @param appId
	 * 			appId
	 * @param timeStamp
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
	public JSONObject driverLicenseOcr(String appId, int timeStamp, String nonceStr, String sign, 
			String image, int type) {
		StringBuffer paramater = new StringBuffer();
		paramater.append("appid=").append(appId)
				.append("&").append("time_stanp=").append(timeStamp)
				.append("&").append("nonce_str=").append(nonceStr)
				.append("&").append("sign=").append(sign)
				.append("&").append("image=").append(image)
				.append("&").append("type").append(type);
		log.debug("OCR行驶证、驾驶证识别，请求参数：{}",paramater.toString());
		return HttpUtil.sendPost(URLConstants.OCR_DRIVERLINCE, paramater.toString());
	}
	
	/**
	 * 营业执照识别
	 * @param appId
	 * @param timeStamp
	 * @param nonceStr
	 * @param sign
	 * @param image
	 * @return
	 */
	public JSONObject bizLicenseOcr(String appId, int timeStamp, String nonceStr, String sign, 
			String image) {
		StringBuffer paramater = commonParamater(appId, timeStamp, nonceStr, sign, image);
		log.debug("OCR营业执照识别，请求参数：{}",paramater.toString());
		return HttpUtil.sendPost(URLConstants.OCR_BIZLICENSE, paramater.toString());
	}
	
	/**
	 * 银行卡识别
	 * @param appId
	 * 			appId
	 * @param timeStamp
	 * 			时间戳，精确到秒
	 * @param nonceStr
	 * 			随机字符串，不超过32字节
	 * @param sign
	 * 			签名
	 * @param image
	 * 			图片base64编码。原图不超过1MB
	 * @return
	 */
	public JSONObject creditCardOcr(String appid, int timeStamp, String nonceStr, String sign, 
			String image) {
		StringBuffer paramater = commonParamater(appId, timeStamp, nonceStr, sign, image);
		log.debug("OCR银行卡识别，请求参数：{}",paramater.toString());
		return HttpUtil.sendPost(URLConstants.OCR_DREDITCARD, paramater.toString());
	}
	/**
	 * 通用识别
	 * @param appId
	 * 			appId
	 * @param timeStamp
	 * 			时间戳，精确到秒
	 * @param nonceStr
	 * 			随机字符串，不超过32字节
	 * @param sign
	 * 			签名
	 * @param image
	 * 			图片base64编码。原图不超过1MB
	 * @return
	 */
	public JSONObject generalOcr(String appId, int timeStamp, String nonceStr, String sign, 
			String image) {
		StringBuffer paramater = commonParamater(appId, timeStamp, nonceStr, sign, image);
		log.debug("OCR通用识别，请求参数：{}",paramater.toString());
		return HttpUtil.sendPost(URLConstants.OCR_GENERAL, paramater.toString());
	}
	
	/**
	 * 公共请求参数生成
	 * @param appId
	 * 			appId
	 * @param timeStamp
	 * 			时间戳
	 * @param nonceStr
	 * 			随机字符串
	 * @param sign
	 * 			签名
	 * @param image
	 * 			图片base64 编码
	 * @return
	 */
	private StringBuffer commonParamater(String appId,int timeStamp,String nonceStr, String sign,
			String image){
		StringBuffer paramater = new StringBuffer();
		paramater.append("appid=").append(appId)
				.append("&").append("time_stamp=").append(timeStamp)
				.append("&").append("nonce_str=").append(nonceStr)
				.append("&").append("sign=").append(sign)
				.append("&").append("image=").append(image);
		return paramater;
	}
}
