package com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo;

import java.io.Serializable;

public class TSgCoverTypeSpecConfig implements Serializable{

    private java.lang.Long coverTypeRuleId;
    private java.lang.Long ruleId;
    private java.lang.String coverTypeCode;
    private java.lang.Integer availableFlag;
    private java.lang.Integer dnmFlag;
    private java.lang.String description;
    private java.util.Date insertTime =	new java.util.Date();
    private java.util.Date updateTime =	new java.util.Date();
    private java.lang.Long insertedBy;
    private java.lang.Long updatedBy;
    private java.util.List documentMappingList;
	public java.lang.Long getCoverTypeRuleId() {
		return coverTypeRuleId;
	}
	public void setCoverTypeRuleId(java.lang.Long coverTypeRuleId) {
		this.coverTypeRuleId = coverTypeRuleId;
	}
	public java.lang.Long getRuleId() {
		return ruleId;
	}
	public void setRuleId(java.lang.Long ruleId) {
		this.ruleId = ruleId;
	}
	public java.lang.String getCoverTypeCode() {
		return coverTypeCode;
	}
	public void setCoverTypeCode(java.lang.String coverTypeCode) {
		this.coverTypeCode = coverTypeCode;
	}
	public java.lang.Integer getAvailableFlag() {
		return availableFlag;
	}
	public void setAvailableFlag(java.lang.Integer availableFlag) {
		this.availableFlag = availableFlag;
	}
	public java.lang.Integer getDnmFlag() {
		return dnmFlag;
	}
	public void setDnmFlag(java.lang.Integer dnmFlag) {
		this.dnmFlag = dnmFlag;
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
	public java.lang.String getDescription() {
		return description;
	}
	public void setDescription(java.lang.String description) {
		this.description = description;
	}
	public java.util.List getDocumentMappingList() {
		return documentMappingList;
	}
	public void setDocumentMappingList(java.util.List documentMappingList) {
		this.documentMappingList = documentMappingList;
	}
    
    

}
