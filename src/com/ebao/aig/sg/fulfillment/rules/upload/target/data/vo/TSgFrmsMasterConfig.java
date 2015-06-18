package com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo;
import java.io.Serializable;
import java.util.HashMap;

public class TSgFrmsMasterConfig implements Serializable  {
	   private java.lang.Long ruleId;
	    private java.lang.Integer transactionType;
	    private java.lang.Integer documentType;
	    private java.lang.String lobId;
	    private java.lang.String productCode;
	    private java.lang.Long planGroupId;
	    private java.lang.Long planName;
	    private java.util.Date effectiveDate;
	    private java.util.Date expiryDate;
	    private java.lang.Integer statusId;
	    private java.lang.Integer priority;
	    private java.lang.Integer cvrTypeRuleAplcbl;
	    private java.lang.Integer platformSpcRuleChk;
	    private java.lang.Integer producerRuleChk;
	    private java.lang.Integer autoSpcRuleChk;
	    private java.lang.Integer voucherAplcbl;
	    private java.lang.Integer checkCampaign;
	    private java.lang.Integer producerExpChk;
	    private java.lang.Integer gstProducerChk;
	    private java.lang.Integer dnmChk;
	    private java.lang.String ruleDescription;
	    private java.util.Date insertTime =	new java.util.Date();
	    private java.util.Date updateTime =	new java.util.Date();
	    private java.lang.Long insertedBy;
	    private java.lang.Long updatedBy;
	    private java.util.List errorList;
	    private java.util.List docMappingList;
	    private java.util.List platformMappingList;
	    private java.util.List coverTypeMappingList;
	    private java.util.List autoMappingList;
	    private java.util.List producerMappingList;
	    private java.util.List renewalAutoMappingList;
	    private java.util.List offlineMappingList;
	    private java.util.List voucherMappingList;
	    private java.util.List campaignMappingList;
	    private java.util.List autoFulfillMappingList;
	    private TSgSmsEmailMappingConfig smsEmailMappingConfig;
	    private java.util.Map autoRuleDescMap= new HashMap();
	    private java.util.Map coverTyepeRuleDescMap = new HashMap();
	    private java.util.Map producerRuleDescMap = new HashMap();
		public java.lang.Long getRuleId() {
			return ruleId;
		}
		public void setRuleId(java.lang.Long ruleId) {
			this.ruleId = ruleId;
		}
		public java.lang.Integer getTransactionType() {
			return transactionType;
		}
		public void setTransactionType(java.lang.Integer transactionType) {
			this.transactionType = transactionType;
		}
		public java.lang.Integer getDocumentType() {
			return documentType;
		}
		public void setDocumentType(java.lang.Integer documentType) {
			this.documentType = documentType;
		}
		public java.lang.String getLobId() {
			return lobId;
		}
		public void setLobId(java.lang.String lobId) {
			this.lobId = lobId;
		}
		public java.lang.String getProductCode() {
			return productCode;
		}
		public void setProductCode(java.lang.String productCode) {
			this.productCode = productCode;
		}
		public java.lang.Long getPlanGroupId() {
			return planGroupId;
		}
		public void setPlanGroupId(java.lang.Long planGroupId) {
			this.planGroupId = planGroupId;
		}
		public java.lang.Long getPlanName() {
			return planName;
		}
		public void setPlanName(java.lang.Long planName) {
			this.planName = planName;
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
		public java.lang.Integer getStatusId() {
			return statusId;
		}
		public void setStatusId(java.lang.Integer statusId) {
			this.statusId = statusId;
		}
		public java.lang.Integer getPriority() {
			return priority;
		}
		public void setPriority(java.lang.Integer priority) {
			this.priority = priority;
		}
		public java.lang.Integer getCvrTypeRuleAplcbl() {
			return cvrTypeRuleAplcbl;
		}
		public void setCvrTypeRuleAplcbl(java.lang.Integer cvrTypeRuleAplcbl) {
			this.cvrTypeRuleAplcbl = cvrTypeRuleAplcbl;
		}
		public java.lang.Integer getPlatformSpcRuleChk() {
			return platformSpcRuleChk;
		}
		public void setPlatformSpcRuleChk(java.lang.Integer platformSpcRuleChk) {
			this.platformSpcRuleChk = platformSpcRuleChk;
		}
		public java.lang.Integer getProducerRuleChk() {
			return producerRuleChk;
		}
		public void setProducerRuleChk(java.lang.Integer producerRuleChk) {
			this.producerRuleChk = producerRuleChk;
		}
		public java.lang.Integer getAutoSpcRuleChk() {
			return autoSpcRuleChk;
		}
		public void setAutoSpcRuleChk(java.lang.Integer autoSpcRuleChk) {
			this.autoSpcRuleChk = autoSpcRuleChk;
		}
		public java.lang.Integer getVoucherAplcbl() {
			return voucherAplcbl;
		}
		public void setVoucherAplcbl(java.lang.Integer voucherAplcbl) {
			this.voucherAplcbl = voucherAplcbl;
		}
		public java.lang.Integer getCheckCampaign() {
			return checkCampaign;
		}
		public void setCheckCampaign(java.lang.Integer checkCampaign) {
			this.checkCampaign = checkCampaign;
		}
		public java.lang.Integer getProducerExpChk() {
			return producerExpChk;
		}
		public void setProducerExpChk(java.lang.Integer producerExpChk) {
			this.producerExpChk = producerExpChk;
		}
		public java.lang.Integer getGstProducerChk() {
			return gstProducerChk;
		}
		public void setGstProducerChk(java.lang.Integer gstProducerChk) {
			this.gstProducerChk = gstProducerChk;
		}
		public java.lang.Integer getDnmChk() {
			return dnmChk;
		}
		public void setDnmChk(java.lang.Integer dnmChk) {
			this.dnmChk = dnmChk;
		}
		public java.lang.String getRuleDescription() {
			return ruleDescription;
		}
		public void setRuleDescription(java.lang.String ruleDescription) {
			this.ruleDescription = ruleDescription;
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
		public java.util.List getDocMappingList() {
			return docMappingList;
		}
		public void setDocMappingList(java.util.List docMappingList) {
			this.docMappingList = docMappingList;
		}
		public java.util.List getPlatformMappingList() {
			return platformMappingList;
		}
		public void setPlatformMappingList(java.util.List platformMappingList) {
			this.platformMappingList = platformMappingList;
		}
		public java.util.List getCoverTypeMappingList() {
			return coverTypeMappingList;
		}
		public void setCoverTypeMappingList(java.util.List coverTypeMappingList) {
			this.coverTypeMappingList = coverTypeMappingList;
		}
		public java.util.List getAutoMappingList() {
			return autoMappingList;
		}
		public void setAutoMappingList(java.util.List autoMappingList) {
			this.autoMappingList = autoMappingList;
		}
		public java.util.List getProducerMappingList() {
			return producerMappingList;
		}
		public void setProducerMappingList(java.util.List producerMappingList) {
			this.producerMappingList = producerMappingList;
		}
		public java.util.List getRenewalAutoMappingList() {
			return renewalAutoMappingList;
		}
		public void setRenewalAutoMappingList(java.util.List renewalAutoMappingList) {
			this.renewalAutoMappingList = renewalAutoMappingList;
		}
		public java.util.List getOfflineMappingList() {
			return offlineMappingList;
		}
		public void setOfflineMappingList(java.util.List offlineMappingList) {
			this.offlineMappingList = offlineMappingList;
		}
		public java.util.List getVoucherMappingList() {
			return voucherMappingList;
		}
		public void setVoucherMappingList(java.util.List voucherMappingList) {
			this.voucherMappingList = voucherMappingList;
		}
		public java.util.List getCampaignMappingList() {
			return campaignMappingList;
		}
		public void setCampaignMappingList(java.util.List campaignMappingList) {
			this.campaignMappingList = campaignMappingList;
		}
		public java.util.List getAutoFulfillMappingList() {
			return autoFulfillMappingList;
		}
		public void setAutoFulfillMappingList(java.util.List autoFulfillMappingList) {
			this.autoFulfillMappingList = autoFulfillMappingList;
		}
		public TSgSmsEmailMappingConfig getSmsEmailMappingConfig() {
			return smsEmailMappingConfig;
		}
		public void setSmsEmailMappingConfig(
				TSgSmsEmailMappingConfig smsEmailMappingConfig) {
			this.smsEmailMappingConfig = smsEmailMappingConfig;
		}
		public java.util.Map getAutoRuleDescMap() {
			return autoRuleDescMap;
		}
		public void setAutoRuleDescMap(java.util.Map autoRuleDescMap) {
			this.autoRuleDescMap = autoRuleDescMap;
		}
		public java.util.Map getCoverTyepeRuleDescMap() {
			return coverTyepeRuleDescMap;
		}
		public void setCoverTyepeRuleDescMap(java.util.Map coverTyepeRuleDescMap) {
			this.coverTyepeRuleDescMap = coverTyepeRuleDescMap;
		}
		public java.util.Map getProducerRuleDescMap() {
			return producerRuleDescMap;
		}
		public void setProducerRuleDescMap(java.util.Map producerRuleDescMap) {
			this.producerRuleDescMap = producerRuleDescMap;
		}

}

