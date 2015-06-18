package com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo;

import java.io.Serializable;

public class TSgVoucherMappingConfig implements Serializable{
    private java.lang.Long voucherRuleId;
    private java.lang.Long ruleId;
    private java.lang.Long producerType;
    private java.lang.String producerCodeFrom;
    private java.lang.String producerCodeTo;
    private java.lang.String producerExcluded;
    private java.util.Date ruleEffectiveDate;
    private java.util.Date ruleExpiryDate;
    private java.util.Date insertTime =	new java.util.Date();
    private java.util.Date updateTime =	new java.util.Date();
    private java.lang.Long insertedBy;
    private java.lang.Long updatedBy;
    private java.util.List extraInsertList;
   
	public java.lang.Long getVoucherRuleId() {
		return voucherRuleId;
	}
	public void setVoucherRuleId(java.lang.Long voucherRuleId) {
		this.voucherRuleId = voucherRuleId;
	}
	public java.lang.Long getRuleId() {
		return ruleId;
	}
	public void setRuleId(java.lang.Long ruleId) {
		this.ruleId = ruleId;
	}
	public java.lang.Long getProducerType() {
		return producerType;
	}
	public void setProducerType(java.lang.Long producerType) {
		this.producerType = producerType;
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
	public java.lang.String getProducerExcluded() {
		return producerExcluded;
	}
	public void setProducerExcluded(java.lang.String producerExcluded) {
		this.producerExcluded = producerExcluded;
	}
	public java.util.Date getRuleEffectiveDate() {
		return ruleEffectiveDate;
	}
	public void setRuleEffectiveDate(java.util.Date ruleEffectiveDate) {
		this.ruleEffectiveDate = ruleEffectiveDate;
	}
	public java.util.Date getRuleExpiryDate() {
		return ruleExpiryDate;
	}
	public void setRuleExpiryDate(java.util.Date ruleExpiryDate) {
		this.ruleExpiryDate = ruleExpiryDate;
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
	public java.util.List getExtraInsertList() {
		return extraInsertList;
	}
	public void setExtraInsertList(java.util.List extraInsertList) {
		this.extraInsertList = extraInsertList;
	}
	
	


}
