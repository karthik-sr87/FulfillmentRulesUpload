package com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo;
import java.io.Serializable;
public class TSgSmsEmailMappingConfig implements Serializable{
	
	  private java.lang.Long ruleId;
	    private java.lang.Integer customerSmsFlag;
	    private java.lang.Long customerSmsTemplateId;
	    private java.lang.Integer customerEmailFlag;
	    private java.lang.Long customerEmailTemplateId;
	    private java.lang.Integer producerSmsFlag;
	    private java.lang.Long producerSmsTemplateId;
	    private java.lang.Integer producerEmailFlag;
	    private java.lang.Long producerEmailTemplateId;
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
		public java.lang.Integer getCustomerSmsFlag() {
			return customerSmsFlag;
		}
		public void setCustomerSmsFlag(java.lang.Integer customerSmsFlag) {
			this.customerSmsFlag = customerSmsFlag;
		}
		public java.lang.Long getCustomerSmsTemplateId() {
			return customerSmsTemplateId;
		}
		public void setCustomerSmsTemplateId(java.lang.Long customerSmsTemplateId) {
			this.customerSmsTemplateId = customerSmsTemplateId;
		}
		public java.lang.Integer getCustomerEmailFlag() {
			return customerEmailFlag;
		}
		public void setCustomerEmailFlag(java.lang.Integer customerEmailFlag) {
			this.customerEmailFlag = customerEmailFlag;
		}
		public java.lang.Long getCustomerEmailTemplateId() {
			return customerEmailTemplateId;
		}
		public void setCustomerEmailTemplateId(java.lang.Long customerEmailTemplateId) {
			this.customerEmailTemplateId = customerEmailTemplateId;
		}
		public java.lang.Integer getProducerSmsFlag() {
			return producerSmsFlag;
		}
		public void setProducerSmsFlag(java.lang.Integer producerSmsFlag) {
			this.producerSmsFlag = producerSmsFlag;
		}
		public java.lang.Long getProducerSmsTemplateId() {
			return producerSmsTemplateId;
		}
		public void setProducerSmsTemplateId(java.lang.Long producerSmsTemplateId) {
			this.producerSmsTemplateId = producerSmsTemplateId;
		}
		public java.lang.Integer getProducerEmailFlag() {
			return producerEmailFlag;
		}
		public void setProducerEmailFlag(java.lang.Integer producerEmailFlag) {
			this.producerEmailFlag = producerEmailFlag;
		}
		public java.lang.Long getProducerEmailTemplateId() {
			return producerEmailTemplateId;
		}
		public void setProducerEmailTemplateId(java.lang.Long producerEmailTemplateId) {
			this.producerEmailTemplateId = producerEmailTemplateId;
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

}
