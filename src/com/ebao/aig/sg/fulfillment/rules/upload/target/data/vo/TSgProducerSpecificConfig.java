package com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo;

import java.io.Serializable;

public class TSgProducerSpecificConfig implements Serializable{
    private java.lang.Long ruleId;
    private java.lang.Long producerRuleId;
    private java.lang.Long producerType;
    private java.lang.String producerCodeFrom;
    private java.lang.String producerCodeTo;
    private java.lang.String producersExcluded;
    private java.lang.Long letterId;
    private java.lang.String description;
    private java.util.Date insertTime =	new java.util.Date();
    private java.util.Date updateTime =	new java.util.Date();
    private java.lang.Long insertedBy;
    private java.lang.Long updatedBy;
	public java.lang.Long getRuleId() {
		return ruleId;
	}
	public void setRuleId(java.lang.Long ruleId) {
		this.ruleId = ruleId;
	}
	public java.lang.Long getProducerRuleId() {
		return producerRuleId;
	}
	public void setProducerRuleId(java.lang.Long producerRuleId) {
		this.producerRuleId = producerRuleId;
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
	public java.lang.String getProducersExcluded() {
		return producersExcluded;
	}
	public void setProducersExcluded(java.lang.String producersExcluded) {
		this.producersExcluded = producersExcluded;
	}
	public java.lang.Long getLetterId() {
		return letterId;
	}
	public void setLetterId(java.lang.Long letterId) {
		this.letterId = letterId;
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

}
