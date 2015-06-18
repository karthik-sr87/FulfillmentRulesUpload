package com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo;

import java.io.Serializable;

public class TSgCampaignMappingConfig implements Serializable{
    private java.lang.Long ruleId;
    private java.lang.Long campaignRuleId;
    private java.lang.String campaignCode;
    private java.lang.Integer attachmentType;
    private java.util.Date insertionEffectiveDate;
    private java.util.Date insertionExpiryDate;
    private java.lang.Integer excludeReFulfillment;
    private java.util.Date insertTime =	new java.util.Date();
    private java.util.Date updateTime =	new java.util.Date();
    private java.lang.Long insertedBy;
    private java.lang.Long updatedBy;
    private TSgInsertMappingConfig insertMappingConfig;
    private TSgDocMappingConfig documentMappingConfig;
    
    private Long searchVoucherName;
    private Long searchDoucmentName;
	public java.lang.Long getRuleId() {
		return ruleId;
	}
	public void setRuleId(java.lang.Long ruleId) {
		this.ruleId = ruleId;
	}
	public java.lang.Long getCampaignRuleId() {
		return campaignRuleId;
	}
	public void setCampaignRuleId(java.lang.Long campaignRuleId) {
		this.campaignRuleId = campaignRuleId;
	}
	public java.lang.String getCampaignCode() {
		return campaignCode;
	}
	public void setCampaignCode(java.lang.String campaignCode) {
		this.campaignCode = campaignCode;
	}
	public java.lang.Integer getAttachmentType() {
		return attachmentType;
	}
	public void setAttachmentType(java.lang.Integer attachmentType) {
		this.attachmentType = attachmentType;
	}
	public java.util.Date getInsertionEffectiveDate() {
		return insertionEffectiveDate;
	}
	public void setInsertionEffectiveDate(java.util.Date insertionEffectiveDate) {
		this.insertionEffectiveDate = insertionEffectiveDate;
	}
	public java.util.Date getInsertionExpiryDate() {
		return insertionExpiryDate;
	}
	public void setInsertionExpiryDate(java.util.Date insertionExpiryDate) {
		this.insertionExpiryDate = insertionExpiryDate;
	}
	public java.lang.Integer getExcludeReFulfillment() {
		return excludeReFulfillment;
	}
	public void setExcludeReFulfillment(java.lang.Integer excludeReFulfillment) {
		this.excludeReFulfillment = excludeReFulfillment;
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
	public Long getSearchVoucherName() {
		return searchVoucherName;
	}
	public void setSearchVoucherName(Long searchVoucherName) {
		this.searchVoucherName = searchVoucherName;
	}
	public Long getSearchDoucmentName() {
		return searchDoucmentName;
	}
	public void setSearchDoucmentName(Long searchDoucmentName) {
		this.searchDoucmentName = searchDoucmentName;
	}
	public TSgInsertMappingConfig getInsertMappingConfig() {
		return insertMappingConfig;
	}
	public void setInsertMappingConfig(TSgInsertMappingConfig insertMappingConfig) {
		this.insertMappingConfig = insertMappingConfig;
	}
	public TSgDocMappingConfig getDocumentMappingConfig() {
		return documentMappingConfig;
	}
	public void setDocumentMappingConfig(TSgDocMappingConfig documentMappingConfig) {
		this.documentMappingConfig = documentMappingConfig;
	}


}
