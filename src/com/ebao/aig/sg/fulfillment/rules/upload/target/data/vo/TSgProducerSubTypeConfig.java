package com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo;

import java.io.Serializable;

public class TSgProducerSubTypeConfig implements Serializable{
    private java.lang.Long producerListId;
    private java.lang.Integer producerSubType;
    private java.lang.String producerCodeFrom;
    private java.lang.String producerCodeTo;
    private java.lang.String producersExcluded;
    private java.util.Date effectiveDate;
    private java.util.Date expiryDate;
    private java.util.Date insertTime =	new java.util.Date();
    private java.util.Date updateTime =	new java.util.Date();
    private java.lang.Long insertedBy;
    private java.lang.Long updatedBy;
    private java.util.List errorList;
    
	public java.lang.Long getProducerListId() {
		return producerListId;
	}
	public void setProducerListId(java.lang.Long producerListId) {
		this.producerListId = producerListId;
	}
	public java.lang.Integer getProducerSubType() {
		return producerSubType;
	}
	public void setProducerSubType(java.lang.Integer producerSubType) {
		this.producerSubType = producerSubType;
	}
	public java.lang.String getProducerCodeFrom() {
		return producerCodeFrom;
	}
	public void setProducerCodeFrom(java.lang.String producerCodeFrom) {
		this.producerCodeFrom = producerCodeFrom;
	}
	public java.lang.String getProducerCodeTo() {
		return producerCodeTo;
	}
	public void setProducerCodeTo(java.lang.String producerCodeTo) {
		this.producerCodeTo = producerCodeTo;
	}
	public java.lang.String getProducersExcluded() {
		return producersExcluded;
	}
	public void setProducersExcluded(java.lang.String producersExcluded) {
		this.producersExcluded = producersExcluded;
	}
	public java.util.Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(java.util.Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public java.util.Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(java.util.Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public java.util.Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(java.util.Date insertTime) {
		this.insertTime = insertTime;
	}
	public java.util.Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}
	public java.lang.Long getInsertedBy() {
		return insertedBy;
	}
	public void setInsertedBy(java.lang.Long insertedBy) {
		this.insertedBy = insertedBy;
	}
	public java.lang.Long getUpdatedBy() {
		return updatedBy;
	}
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
