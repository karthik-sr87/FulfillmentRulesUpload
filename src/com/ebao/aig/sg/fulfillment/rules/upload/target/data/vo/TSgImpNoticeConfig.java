package com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo;

import java.io.Serializable;

public class TSgImpNoticeConfig implements Serializable {
    private java.lang.Long impNoticeId;
    private java.lang.Integer producerSubType;
    private java.lang.Integer vehicleType;
    private java.lang.Long templateId;
    private java.util.Date effectiveDate;
    private java.util.Date expiryDate;
    private java.util.Date insertTime =	new java.util.Date();
    private java.util.Date updateTime =	new java.util.Date();
    private java.lang.Long insertedBy;
    private java.lang.Long updatedBy;
    private java.util.List letterSeqList;
    private java.util.List errorList;
	/**
	 * @return the impNoticeId
	 */
	public java.lang.Long getImpNoticeId() {
		return impNoticeId;
	}
	/**
	 * @param impNoticeId the impNoticeId to set
	 */
	public void setImpNoticeId(java.lang.Long impNoticeId) {
		this.impNoticeId = impNoticeId;
	}
	/**
	 * @return the producerSubType
	 */
	
	/**
	 * @return the vehicleType
	 */
	
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
	 * @return the effectiveDate
	 */
	public java.util.Date getEffectiveDate() {
		return effectiveDate;
	}
	/**
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(java.util.Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	/**
	 * @return the expiryDate
	 */
	public java.util.Date getExpiryDate() {
		return expiryDate;
	}
	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(java.util.Date expiryDate) {
		this.expiryDate = expiryDate;
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
	public java.lang.Integer getProducerSubType() {
		return producerSubType;
	}
	public void setProducerSubType(java.lang.Integer producerSubType) {
		this.producerSubType = producerSubType;
	}
	public java.lang.Integer getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(java.lang.Integer vehicleType) {
		this.vehicleType = vehicleType;
	}
	public java.util.List getLetterSeqList() {
		return letterSeqList;
	}
	public void setLetterSeqList(java.util.List letterSeqList) {
		this.letterSeqList = letterSeqList;
	}
	public java.util.List getErrorList() {
		return errorList;
	}
	public void setErrorList(java.util.List errorList) {
		this.errorList = errorList;
	}
	

}
