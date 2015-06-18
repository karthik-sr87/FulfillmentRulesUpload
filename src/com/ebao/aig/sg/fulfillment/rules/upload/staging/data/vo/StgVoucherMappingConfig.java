package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo;

import java.util.Date;

public class StgVoucherMappingConfig {

	private java.lang.Long voucherRuleId;
    private java.lang.Long ruleId;
    private java.lang.String producerType;
    private java.lang.String producerCodeFrom;
    private java.lang.String producerCodeTo;
    private java.lang.String producerExcluded;
    private Date ruleEffectiveDate;
    private Date ruleExpiryDate;
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
	public java.lang.String getProducerType() {
		return producerType;
	}
	public void setProducerType(java.lang.String producerType) {
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
	public java.util.List getExtraInsertList() {
		return extraInsertList;
	}
	public void setExtraInsertList(java.util.List extraInsertList) {
		this.extraInsertList = extraInsertList;
	}
	public Date getRuleEffectiveDate() {
		return ruleEffectiveDate;
	}
	public void setRuleEffectiveDate(Date ruleEffectiveDate) {
		this.ruleEffectiveDate = ruleEffectiveDate;
	}
	public Date getRuleExpiryDate() {
		return ruleExpiryDate;
	}
	public void setRuleExpiryDate(Date ruleExpiryDate) {
		this.ruleExpiryDate = ruleExpiryDate;
	}
}
