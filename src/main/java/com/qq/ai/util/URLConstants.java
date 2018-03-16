package com.qq.ai.util;
/**
 * 请求的url地址
 * @author csxx_wmw
 *
 */
public abstract class URLConstants {

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
}
