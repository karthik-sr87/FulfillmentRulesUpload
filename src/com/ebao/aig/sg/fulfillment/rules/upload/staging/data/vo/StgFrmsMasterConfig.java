package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo;

import java.util.HashMap;


public class StgFrmsMasterConfig {

	private java.lang.Long ruleId;
    private java.lang.String transactionType;
    private java.lang.String documentType;
    private java.lang.String lobId;
    private java.lang.String productCode;
    private java.lang.String planGroupId;
    private java.lang.String planName;
    private java.util.Date effectiveDate;
    private java.util.Date expiryDate;
    private java.lang.String statusId;
    private java.lang.String priority;
    private java.lang.String cvrTypeRuleAplcbl;
    private java.lang.String platformSpcRuleChk;
    private java.lang.String producerRuleChk;
    private java.lang.String autoSpcRuleChk;
    private java.lang.String voucherAplcbl;
    private java.lang.String checkCampaign;
    private java.lang.String producerExpChk;
    private java.lang.String gstProducerChk;
    private java.lang.String dnmChk;
    private java.lang.String ruleDescription;
    private java.util.Date insertTime =	new java.util.Date();
    private java.util.Date updateTime =	new java.util.Date();
    private java.lang.String insertedBy;
    private java.lang.String updatedBy;
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
    private StgSmsEmailMappingConfig smsEmailMappingConfig;
    private java.util.Map autoRuleDescMap= new HashMap();
    private java.util.Map coverTyepeRuleDescMap = new HashMap();
    private java.util.Map producerRuleDescMap = new HashMap();
	public java.lang.Long getRuleId() {
		return ruleId;
	}
	public void setRuleId(java.lang.Long ruleId) {
		this.ruleId = ruleId;
	}
	public java.lang.String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(java.lang.String transactionType) {
		this.transactionType = transactionType;
	}
	public java.lang.String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(java.lang.String documentType) {
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
	public java.lang.String getPlanGroupId() {
		return planGroupId;
	}
	public void setPlanGroupId(java.lang.String planGroupId) {
		this.planGroupId = planGroupId;
	}
	public java.lang.String getPlanName() {
		return planName;
	}
	public void setPlanName(java.lang.String planName) {
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
	public java.lang.String getStatusId() {
		return statusId;
	}
	public void setStatusId(java.lang.String statusId) {
		this.statusId = statusId;
	}
	public java.lang.String getPriority() {
		return priority;
	}
	public void setPriority(java.lang.String priority) {
		this.priority = priority;
	}
	public java.lang.String getCvrTypeRuleAplcbl() {
		return cvrTypeRuleAplcbl;
	}
	public void setCvrTypeRuleAplcbl(java.lang.String cvrTypeRuleAplcbl) {
		this.cvrTypeRuleAplcbl = cvrTypeRuleAplcbl;
	}
	public java.lang.String getPlatformSpcRuleChk() {
		return platformSpcRuleChk;
	}
	public void setPlatformSpcRuleChk(java.lang.String platformSpcRuleChk) {
		this.platformSpcRuleChk = platformSpcRuleChk;
	}
	public java.lang.String getProducerRuleChk() {
		return producerRuleChk;
	}
	public void setProducerRuleChk(java.lang.String producerRuleChk) {
		this.producerRuleChk = producerRuleChk;
	}
	public java.lang.String getAutoSpcRuleChk() {
		return autoSpcRuleChk;
	}
	public void setAutoSpcRuleChk(java.lang.String autoSpcRuleChk) {
		this.autoSpcRuleChk = autoSpcRuleChk;
	}
	public java.lang.String getVoucherAplcbl() {
		return voucherAplcbl;
	}
	public void setVoucherAplcbl(java.lang.String voucherAplcbl) {
		this.voucherAplcbl = voucherAplcbl;
	}
	public java.lang.String getCheckCampaign() {
		return checkCampaign;
	}
	public void setCheckCampaign(java.lang.String checkCampaign) {
		this.checkCampaign = checkCampaign;
	}
	public java.lang.String getProducerExpChk() {
		return producerExpChk;
	}
	public void setProducerExpChk(java.lang.String producerExpChk) {
		this.producerExpChk = producerExpChk;
	}
	public java.lang.String getGstProducerChk() {
		return gstProducerChk;
	}
	public void setGstProducerChk(java.lang.String gstProducerChk) {
		this.gstProducerChk = gstProducerChk;
	}
	public java.lang.String getDnmChk() {
		return dnmChk;
	}
	public void setDnmChk(java.lang.String dnmChk) {
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
	public java.lang.String getInsertedBy() {
		return insertedBy;
	}
	public void setInsertedBy(java.lang.String insertedBy) {
		this.insertedBy = insertedBy;
	}
	public java.lang.String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(java.lang.String updatedBy) {
		this.updatedBy = updatedBy;
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
	public StgSmsEmailMappingConfig getSmsEmailMappingConfig() {
		return smsEmailMappingConfig;
	}
	public void setSmsEmailMappingConfig(
			StgSmsEmailMappingConfig smsEmailMappingConfig) {
		this.smsEmailMappingConfig = smsEmailMappingConfig;
	}
	public java.util.List getRenewalAutoMappingList() {
		return renewalAutoMappingList;
	}
	public void setRenewalAutoMappingList(java.util.List renewalAutoMappingList) {
		this.renewalAutoMappingList = renewalAutoMappingList;
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
