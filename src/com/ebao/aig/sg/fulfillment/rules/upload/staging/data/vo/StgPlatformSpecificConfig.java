package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo;

public class StgPlatformSpecificConfig {

	private java.lang.Long ruleId;
    private java.lang.Long platformRuleId;
    private java.lang.String platform;
    private java.util.List documentMappingConfig;
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
	public java.lang.String getPlatform() {
		return platform;
	}
	public void setPlatform(java.lang.String platform) {
		this.platform = platform;
	}
	public java.util.List getDocumentMappingConfig() {
		return documentMappingConfig;
	}
	public void setDocumentMappingConfig(java.util.List documentMappingConfig) {
		this.documentMappingConfig = documentMappingConfig;
	}
}
