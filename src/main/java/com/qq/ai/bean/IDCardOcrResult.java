package com.qq.ai.bean;

import com.alibaba.fastjson.JSONObject;

/**
 * 身份证识别返回的数据
 * @author csxx_wmw
 *
 */
public class IDCardOcrResult {
	/*返回的数据字典名称*/
	public static String NAME = "name";
	public static String SEX = "sex";
	public static String NATION = "nation";
	public static String BIRTH = "birth";
	public static String ADDRESS = "address";
	public static String CARD_ID = "id";
	public static String FRONTIMAGE = "frontimage";
	public static String AUTHROITY = "authority";
	public static String VALID_DATE = "valid_date";
	public static String BACKIMAGE = "backimage";
	
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 民族
	 */
	private String nation;
	/**
	 * 生日
	 */
	private String birth;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 身份证号码
	 */
	private String cardId;
	/**
	 * 正面照片base64编码
	 */
	private String frontImage;
	/**
	 * 有效期
	 */
	private String validDate;
	/**
	 * 发证机关
	 */
	private String authority;
	/**
	 * 身份证反面base64编码
	 */
	private String backImage;
	
	
	
	public IDCardOcrResult(String name, String sex, String nation, String birth, String address, String cardId,
			String frontImage, String validDate, String authority, String backImage) {
		super();
		this.name = name;
		this.sex = sex;
		this.nation = nation;
		this.birth = birth;
		this.address = address;
		this.cardId = cardId;
		this.frontImage = frontImage;
		this.validDate = validDate;
		this.authority = authority;
		this.backImage = backImage;
	}
	
	
	public IDCardOcrResult() {
		super();
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getValidDate() {
		return validDate;
	}
	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getFrontImage() {
		return frontImage;
	}

	public void setFrontImage(String frontImage) {
		this.frontImage = frontImage;
	}

	public String getBackImage() {
		return backImage;
	}

	public void setBackImage(String backImage) {
		this.backImage = backImage;
	}

	public static IDCardOcrResult create(JSONObject json){
		IDCardOcrResult idCardOcrResult = new IDCardOcrResult();
		
		idCardOcrResult.setName(json.getString(NAME));
		idCardOcrResult.setAddress(json.getString(ADDRESS));
		idCardOcrResult.setAuthority(json.getString(AUTHROITY));
		idCardOcrResult.setBackImage(json.getString(BACKIMAGE));
		idCardOcrResult.setBirth(json.getString(BIRTH));
		idCardOcrResult.setCardId(json.getString(CARD_ID));
		idCardOcrResult.setFrontImage(json.getString(FRONTIMAGE));
		idCardOcrResult.setNation(json.getString(NATION));
		idCardOcrResult.setSex(json.getString(SEX));
		idCardOcrResult.setValidDate(json.getString(VALID_DATE));
		
		return idCardOcrResult;
	}
	
	public static AiResult<IDCardOcrResult> createAiResult(JSONObject json){
		AiResult<IDCardOcrResult> aiResult = new AiResult<>();
		aiResult.setRet(json.getIntValue(AiResult.RET));
		aiResult.setMsg(json.getString(AiResult.MSG));
		aiResult.setData(create(json.getJSONObject(AiResult.DATA)));
		return aiResult;
	}
}
