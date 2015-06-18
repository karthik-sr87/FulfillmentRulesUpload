package com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo;

public class TSgPlatformSpecificConfig {

    private java.lang.Long ruleId;
    private java.lang.Long platformRuleId;
    private java.lang.Integer platform;
    private java.util.Date insertTime =	new java.util.Date();
    private java.util.Date updateTime =	new java.util.Date();
    private java.lang.Long insertedBy;
    private java.lang.Long updatedBy;
    private java.util.List documentMappingList;
	public java.lang.Long getRuleId() {
		return ruleId;
	}
	public void setRuleId(java.lang.Long ruleId) {
		this.ruleId = ruleId;
	}
	public java.lang.Long getPlatformRuleId() {
		return platformRuleId;
	}
	public void setPlatformRuleId(java.lang.Long platformRuleId) {
		this.platformRuleId = platformRuleId;
	}
	public java.lang.Integer getPlatform() {
		return platform;
	}
	public void setPlatform(java.lang.Integer platform) {
		this.platform = platform;
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
	public java.util.List getDocumentMappingList() {
		return documentMappingList;
	}
	public void setDocumentMappingList(java.util.List documentMappingList) {
		this.documentMappingList = documentMappingList;
	}

    
}
