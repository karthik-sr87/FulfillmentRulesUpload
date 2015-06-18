package com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo;

import java.io.Serializable;

public class TSgLetterMasterConfig implements Serializable {
    private java.lang.Long letterId;
    private java.lang.String letterCode;
    private java.lang.String letterName;
    private java.lang.Long templateId;
    private java.util.Date insertTime =	new java.util.Date();
    private java.util.Date updateTime =	new java.util.Date();
    private java.lang.Long insertedBy;
    private java.lang.Long updatedBy;
    private java.util.List errorList;
	/**
	 * @return the letterId
	 */
	public java.lang.Long getLetterId() {
		return letterId;
	}
	/**
	 * @param letterId the letterId to set
	 */
	public void setLetterId(java.lang.Long letterId) {
		this.letterId = letterId;
	}
	/**
	 * @return the letterCode
	 */
	public java.lang.String getLetterCode() {
		return letterCode;
	}
	/**
	 * @param letterCode the letterCode to set
	 */
	public void setLetterCode(java.lang.String letterCode) {
		this.letterCode = letterCode;
	}
	/**
	 * @return the letterName
	 */
	public java.lang.String getLetterName() {
		return letterName;
	}
	/**
	 * @param letterName the letterName to set
	 */
	public void setLetterName(java.lang.String letterName) {
		this.letterName = letterName;
	}
	/**
	 * @return the templateId
	 */
	public java.lang.Long getTemplateId() {
		return templateId;
	}
	/**
	 * @param templateId the templateId to set
	 */
	public void setTemplateId(java.lang.Long templateId) {
		this.templateId = templateId;
	}
	/**
	 * @return the insertTime
	 */
	public java.util.Date getInsertTime() {
		return insertTime;
	}
	/**
	 * @param insertTime the insertTime to set
	 */
	public void setInsertTime(java.util.Date insertTime) {
		this.insertTime = insertTime;
	}
	/**
	 * @return the updateTime
	 */
	public java.util.Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * @return the insertedBy
	 */
	public java.lang.Long getInsertedBy() {
		return insertedBy;
	}
	/**
	 * @param insertedBy the insertedBy to set
	 */
	public void setInsertedBy(java.lang.Long insertedBy) {
		this.insertedBy = insertedBy;
	}
	/**
	 * @return the updatedBy
	 */
	public java.lang.Long getUpdatedBy() {
		return updatedBy;
	}
	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(java.lang.Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	public java.util.List getErrorList() {
		return errorList;
	}
	public void setErrorList(java.util.List errorList) {
		this.errorList = errorList;
	}
	

}
