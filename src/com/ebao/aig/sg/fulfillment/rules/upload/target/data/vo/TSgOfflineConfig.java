package com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo;

import java.io.Serializable;

public class TSgOfflineConfig implements Serializable {
	  private java.lang.Long ruleId;
	    private java.lang.Long offlineRuleId;
	    private java.lang.Integer documentClubType;
	    private java.lang.Integer envelope;
	    private java.lang.Integer colour;
	    private java.util.Date insertTime =	new java.util.Date();
	    private java.util.Date updateTime =	new java.util.Date();
	    private java.lang.Long insertedBy;
	    private java.lang.Long updatedBy;
	    private java.util.List extraInsertList;
	    private String searchDocClubType;
		private String searchExtraInsertName;
		
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
		public java.lang.Integer getDocumentClubType() {
			return documentClubType;
		}
		public void setDocumentClubType(java.lang.Integer documentClubType) {
			this.documentClubType = documentClubType;
		}
		public java.lang.Integer getEnvelope() {
			return envelope;
		}
		public void setEnvelope(java.lang.Integer envelope) {
			this.envelope = envelope;
		}
		public java.lang.Integer getColour() {
			return colour;
		}
		public void setColour(java.lang.Integer colour) {
			this.colour = colour;
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
		public String getSearchDocClubType() {
			return searchDocClubType;
		}
		public void setSearchDocClubType(String searchDocClubType) {
			this.searchDocClubType = searchDocClubType;
		}
		public String getSearchExtraInsertName() {
			return searchExtraInsertName;
		}
		public void setSearchExtraInsertName(String searchExtraInsertName) {
			this.searchExtraInsertName = searchExtraInsertName;
		}
		public java.util.List getExtraInsertList() {
			return extraInsertList;
		}
		public void setExtraInsertList(java.util.List extraInsertList) {
			this.extraInsertList = extraInsertList;
		}

}
