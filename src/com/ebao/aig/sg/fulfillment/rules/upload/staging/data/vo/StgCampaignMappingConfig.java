package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo;

import java.util.Date;


public class StgCampaignMappingConfig {

	private java.lang.Long ruleId;
    private java.lang.Long campaignRuleId;
    private java.lang.String campaignCode;
    private java.lang.String attachmentType;
    private Date insertionEffectiveDate;
    private Date insertionExpiryDate;
    private java.lang.String excludeReFulfillment;
    private StgInsertMappingConfig insertMappingConfig;
    private StgDocMappingConfig documentMappingConfig;
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
	public java.lang.String getAttachmentType() {
		return attachmentType;
	}
	public void setAttachmentType(java.lang.String attachmentType) {
		this.attachmentType = attachmentType;
	}
	public StgInsertMappingConfig getInsertMappingConfig() {
		return insertMappingConfig;
	}
	public void setInsertMappingConfig(StgInsertMappingConfig insertMappingConfig) {
		this.insertMappingConfig = insertMappingConfig;
	}
	public StgDocMappingConfig getDocumentMappingConfig() {
		return documentMappingConfig;
	}
	public void setDocumentMappingConfig(StgDocMappingConfig documentMappingConfig) {
		this.documentMappingConfig = documentMappingConfig;
	}
	public Date getInsertionEffectiveDate() {
		return insertionEffectiveDate;
	}
	public void setInsertionEffectiveDate(Date insertionEffectiveDate) {
		this.insertionEffectiveDate = insertionEffectiveDate;
	}
	public Date getInsertionExpiryDate() {
		return insertionExpiryDate;
	}
	public void setInsertionExpiryDate(Date insertionExpiryDate) {
		this.insertionExpiryDate = insertionExpiryDate;
	}
	public java.lang.String getExcludeReFulfillment() {
		return excludeReFulfillment;
	}
	public void setExcludeReFulfillment(java.lang.String excludeReFulfillment) {
		this.excludeReFulfillment = excludeReFulfillment;
	}
}
