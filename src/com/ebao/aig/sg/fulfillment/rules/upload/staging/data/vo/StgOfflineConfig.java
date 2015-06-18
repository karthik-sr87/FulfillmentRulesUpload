package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo;

public class StgOfflineConfig {

	private java.lang.Long ruleId;
    private java.lang.Long offlineRuleId;
    private java.lang.String documentClubType;
    private java.lang.String envelope;
    private java.lang.String colour;
    private java.util.List extraInsertList;
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
	public java.lang.String getDocumentClubType() {
		return documentClubType;
	}
	public void setDocumentClubType(java.lang.String documentClubType) {
		this.documentClubType = documentClubType;
	}
	public java.lang.String getEnvelope() {
		return envelope;
	}
	public void setEnvelope(java.lang.String envelope) {
		this.envelope = envelope;
	}
	public java.lang.String getColour() {
		return colour;
	}
	public void setColour(java.lang.String colour) {
		this.colour = colour;
	}
	public java.util.List getExtraInsertList() {
		return extraInsertList;
	}
	public void setExtraInsertList(java.util.List extraInsertList) {
		this.extraInsertList = extraInsertList;
	}
}
