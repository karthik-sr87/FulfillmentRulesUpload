package com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo;

import java.io.Serializable;

public class TSgInsertMappingConfig implements Serializable {
    private java.lang.Long listId;
    private java.lang.Long ruleId;
    private java.lang.Long offlineRuleId;
    private java.lang.Long voucherRuleId;
    private java.lang.Long campaignRuleId;
    private java.lang.Long insertName;
    private java.lang.Integer sequenceNo;
    private java.util.Date insertionEffectiveDate;
    private java.util.Date insertionExpiryDate;
    private java.lang.Integer excludeReFulfillment;
    private Boolean checkReFulfill;
    private java.util.Date insertTime =	new java.util.Date();
    private java.util.Date updateTime =	new java.util.Date();
    private java.lang.Long insertedBy;
    private java.lang.Long updatedBy;
    
    private String rsInsertionEffDate;
    private String rsinsertionExpDate;
   
	public java.lang.Long getListId() {
		return listId;
	}
	public void setListId(java.lang.Long listId) {
		this.listId = listId;
	}
	public java.lang.Long getRuleId() {
		return ruleId;
	}
	public void setRuleId(java.lang.Long ruleId) {
		this.ruleId = ruleId;
	}
	public java.lang.Long getOfflineRuleId() {
		return offlineRuleId;
	}
	public void setOfflineRuleId(java.lang.Long offlineRuleId) {
		this.offlineRuleId = offlineRuleId;
	}
	public java.lang.Long getVoucherRuleId() {
		return voucherRuleId;
	}
	public void setVoucherRuleId(java.lang.Long voucherRuleId) {
		this.voucherRuleId = voucherRuleId;
	}
	public java.lang.Long getCampaignRuleId() {
		return campaignRuleId;
	}
	public void setCampaignRuleId(java.lang.Long campaignRuleId) {
		this.campaignRuleId = campaignRuleId;
	}
	public java.lang.Long getInsertName() {
		return insertName;
	}
	public void setInsertName(java.lang.Long insertName) {
		this.insertName = insertName;
	}
	public java.lang.Integer getSequenceNo() {
		return sequenceNo;
	}
	public void setSequenceNo(java.lang.Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
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
	public Boolean getCheckReFulfill() {
		return checkReFulfill;
	}
	public void setCheckReFulfill(Boolean checkReFulfill) {
		this.checkReFulfill = checkReFulfill;
	}
	public String getRsInsertionEffDate() {
		return rsInsertionEffDate;
	}
	public void setRsInsertionEffDate(String rsInsertionEffDate) {
		this.rsInsertionEffDate = rsInsertionEffDate;
	}
	public String getRsinsertionExpDate() {
		return rsinsertionExpDate;
	}
	public void setRsinsertionExpDate(String rsinsertionExpDate) {
		this.rsinsertionExpDate = rsinsertionExpDate;
	}
	   
}
