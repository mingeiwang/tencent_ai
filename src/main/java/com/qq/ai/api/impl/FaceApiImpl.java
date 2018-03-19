package com.qq.ai.api.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.qq.ai.util.HttpUtil;
import com.qq.ai.util.URLConstants;

/**
 * 人脸相关接口实现
 * @author csxx_wmw
 *
 */
public class FaceApiImpl {

	private static final Logger log = LoggerFactory.getLogger(FaceApiImpl.class);
	
	private String appId;
	private String appKey;
	public FaceApiImpl(String appId, String appKey) {
		super();
		this.appId = appId;
		this.appKey = appKey;
	}
	public FaceApiImpl() {
		super();
	}
	
	
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppKey() {
		return appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	/**
	 * 多人脸检测
	 * @param appId
	 * @param timeStamp
	 * @param nonceStr
	 * @param sign
	 * @param image
	 * @return
	 */
	public JSONObject detectmultiFace(String appId, int timeStamp, String nonceStr, String sign, 
			String image){
		StringBuffer paramater = commonParamater(appId, timeStamp, nonceStr, sign, image);
		log.debug("FACE多人脸检测，请求参数：{}",paramater.toString());
		return HttpUtil.sendPost(URLConstants.FACE_DETECTMULTI, paramater.toString());
	}
	/**
	 * 人脸比较，请求包体的总大小不能超过2MB
	 * @param appId
	 * @param timeStamp
	 * @param nonceStr
	 * @param sign
	 * @param imageA
	 * 			比较图片A，最大1MB
	 * @param imageB
	 * 			比较图片B， 最大1MB
	 * @return
	 */
	public JSONObject faceCompare(String appId, int timeStamp, String nonceStr, String sign, 
			String imageA, String imageB){
		StringBuffer paramater = commonParamater(appId, timeStamp, nonceStr, sign);
		paramater.append("&").append("image_a").append(imageA)
		.append("&").append("image_b").append(imageB);
		log.debug("FACE人脸比较，请求参数：{}",paramater.toString());
		return HttpUtil.sendPost(URLConstants.FACE_COMPARE, paramater.toString());
	}
	
	/**
	 * <pre>
	 * 人脸检测与分析，识别上传图像上面的人脸信息
	 * 接口详情：https://ai.qq.com/doc/detectface.shtml
	 * </pre>
	 * @param appId
	 * 			appid
	 * @param timeStamp
	 * 			时间戳，精确到秒
	 * @param nonceStr
	 * 			随机字符串，不超过32字节
	 * @param sign
	 * 			签名
	 * @param image
	 * 			原始图片的base64编码数据（原图大小上限1MB，支持JPG、PNG、BMP格式）
	 * @param model
	 * 			检测模式，0-正常，1-大脸模式（默认1）
	 * @return
	 */
	public JSONObject faceDetect(String appId, int timeStamp, String nonceStr, String sign, 
			String image, int model){
		StringBuffer paramater = commonParamater(appId, timeStamp, nonceStr, sign,image);
		paramater.append("&").append("model=").append(model);
		log.debug("FACE人脸检测与分析，请求参数：{}",paramater.toString());
		return HttpUtil.sendPost(URLConstants.FACE_DETECT, paramater.toString());
	}
	
	/**
	 * <pre>
	 * 	跨年龄人脸识别
	 * </pre>
	 * @param appId
	 * @param timeStamp
	 * @param nonceStr
	 * @param sign
	 * @param sourceImage
	 * @param targetImage
	 * @return
	 */
	public JSONObject faceDetectCrossAge(String appId, int timeStamp, String nonceStr, String sign,
			String sourceImage, String targetImage){
		StringBuffer paramater = commonParamater(appId, timeStamp, nonceStr, sign);
		paramater.append("&").append("source_image=").append(sourceImage)
		.append("&").append("target_image=").append(targetImage);
		log.debug("FACE跨年龄人脸识别，请求参数：{}",paramater.toString());
		return HttpUtil.sendPost(URLConstants.FACE_DETECT_CROSS_AGE, paramater.toString());
	}
	/**
	 * <pre>
	 * 	五官定位
	 * 详情参见：https://api.ai.qq.com/fcgi-bin/face/face_faceshape
	 * </pre>
	 * @param appId
	 * @param timeStamp
	 * @param nonceStr
	 * @param sign
	 * @param mode
	 * @param image
	 * @return
	 */
	public JSONObject faceShape(String appId, int timeStamp, String nonceStr, String sign,
			String image, int mode){
		StringBuffer paramater = commonParamater(appId, timeStamp, nonceStr, sign, image);
		paramater.append("&").append("model=").append(mode);
		log.debug("FACE五官定位，请求参数：{}",paramater.toString());
		return HttpUtil.sendPost(URLConstants.FACE_SHAPE, paramater.toString());
	}
	
	/**
	 * <pre>
	 * 	人脸识别
	 * 	详情见：http://ai.qq.com/doc/faceidentify.shtml
	 * </pre>
	 * @param appId
	 * @param timeStamp
	 * @param nonceStr
	 * @param sign
	 * @param image
	 * @param groupId
	 * @param topn
	 * @return
	 */
	public JSONObject faceIdentify(String appId, int timeStamp, String nonceStr, String sign,
			String image, String groupId, int topn){
		StringBuffer paramater = commonParamater(appId, timeStamp, nonceStr, sign, image);
		paramater.append("&").append("groupId=").append(groupId);
		paramater.append("&").append("topn=").append(topn);
		log.debug("FACE人脸定位，请求参数：{}",paramater.toString());
		return HttpUtil.sendPost(URLConstants.FACE_IDENTIFY, paramater.toString());
	}
	
	/**
	 * 公共请求参数生成
	 * @param appId
	 * 			appId
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
	private StringBuffer commonParamater(String appId,int timeStamp,String nonceStr, String sign,
			String image){
		return commonParamater(appId, timeStamp, nonceStr, sign)
				.append("&").append("image=").append(image);
	}
	
	/**
	 * 公共请求参数生成
	 * @param appId
	 * 			appId
	 * @param timeStamp
	 * 		 	时间戳，
	 * @param nonceStr
	 * 			随机字符串
	 * @param sign
	 * 			签名
	 * @return
	 */
	private StringBuffer commonParamater(String appId,int timeStamp,String nonceStr, String sign){
		StringBuffer paramater = new StringBuffer();
		 return paramater.append("appid=").append(appId)
				.append("&").append("time_stanp=").append(timeStamp)
				.append("&").append("nonce_str=").append(nonceStr)
				.append("&").append("sign=").append(sign);
	}
}
