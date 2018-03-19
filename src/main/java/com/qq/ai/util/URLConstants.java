package com.qq.ai.util;
/**
 * 请求的url地址
 * @author csxx_wmw
 *
 */
public abstract class URLConstants {

	/*ocr识别类*/
	/**
	 * 身份证识别ocr地址
	 */
	public static final String OCR_ID_CARD = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_idcardocr";
	/**
	 * 名片识别ocr地址
	 */
	public static final String OCR_BC_OCR = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_bcocr";
	/**
	 * 行驶证、驾驶证识别ocr地址
	 */
	public static final String OCR_DRIVERLINCE = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_driverlicenseocr";
	/**
	 * 营业执照识别
	 */
	public static final String OCR_BIZLICENSE = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_bizlicenseocr";
	/**
	 * 银行卡识别地址
	 */
	public static final String OCR_DREDITCARD = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_creditcardocr";
	/**
	 * 通用识别地址
	 */
	public static final String OCR_GENERAL = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_generalocr";
	
	/*face人脸类*/
	/**
	 * 多人脸检测
	 */
	public static final String FACE_DETECTMULTI  = "https://api.ai.qq.com/fcgi-bin/face/face_detectmultiface";
	/**
	 * 人脸对比
	 */
	public static final String FACE_COMPARE  = "https://api.ai.qq.com/fcgi-bin/face/face_facecompare";
	
	/**
	 * 人脸检测与分析
	 */
	public static final String FACE_DETECT  = "https://api.ai.qq.com/fcgi-bin/face/face_detectface";
	
	/**
	 * 跨年龄人脸识别
	 */
	public static final String FACE_DETECT_CROSS_AGE  = "https://api.ai.qq.com/fcgi-bin/face/face_detectcrossageface";
	
	/**
	 * 五官定位	
	 */
	public static final String FACE_SHAPE  = "https://api.ai.qq.com/fcgi-bin/face/face_faceshape";
	
	/**
	 * 五官定位	
	 */
	public static final String FACE_IDENTIFY  = "https://api.ai.qq.com/fcgi-bin/face/face_faceidentify";
	
	
}
