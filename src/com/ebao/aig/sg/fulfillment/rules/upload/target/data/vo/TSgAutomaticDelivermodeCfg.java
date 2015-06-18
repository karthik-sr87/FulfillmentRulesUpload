package com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo;

import java.io.Serializable;

public class TSgAutomaticDelivermodeCfg implements Serializable {
    private java.lang.Long ruleId;
    private java.lang.Long automaticRuleId;
    private java.lang.Long userGroup;
    private java.lang.Integer docClubType;
    private java.lang.Integer autoDeliver;
    private java.lang.Integer autoDeliverMode;
    private java.util.Date insertTime =	new java.util.Date();
    private java.util.Date updateTime =	new java.util.Date();
    private java.lang.Long insertedBy;
    private java.lang.Long updatedBy;
    private Long searchRuleId;
    private Long searchUserGroup;
    private Long searchDocClubType;
	/**
	 * @return the ruleId
	 */
	public java.lang.Long getRuleId() {
		return ruleId;
	}
	/**
	 * @param ruleId the ruleId to set
	 */
	public void setRuleId(java.lang.Long ruleId) {
		this.ruleId = ruleId;
	}
	/**
	 * @return the automaticRuleId
	 */
	public java.lang.Long getAutomaticRuleId() {
		return automaticRuleId;
	}
	/**
	 * @param automaticRuleId the automaticRuleId to set
	 */
	public void setAutomaticRuleId(java.lang.Long automaticRuleId) {
		this.automaticRuleId = automaticRuleId;
	}
	/**
	 * @return the userGroup
	 */
	public java.lang.Long getUserGroup() {
		return userGroup;
	}
	/**
	 * @param userGroup the userGroup to set
	 */
	public void setUserGroup(java.lang.Long userGroup) {
		this.userGroup = userGroup;
	}
	/**
	 * @return the docClubType
	 */
	public java.lang.Integer getDocClubType() {
		return docClubType;
	}
	/**
	 * @param docClubType the docClubType to set
	 */
	public void setDocClubType(java.lang.Integer docClubType) {
		this.docClubType = docClubType;
	}
	/**
	 * @return the autoDeliver
	 */
	public java.lang.Integer getAutoDeliver() {
		return autoDeliver;
	}
	/**
	 * @param autoDeliver the autoDeliver to set
	 */
	public void setAutoDeliver(java.lang.Integer autoDeliver) {
		this.autoDeliver = autoDeliver;
	}
	/**
	 * @return the autoDeliverMode
	 */
	public java.lang.Integer getAutoDeliverMode() {
		return autoDeliverMode;
	}
	/**
	 * @param autoDeliverMode the autoDeliverMode to set
	 */
	public void setAutoDeliverMode(java.lang.Integer autoDeliverMode) {
		this.autoDeliverMode = autoDeliverMode;
	}
	/**
	 * @return the insertTime
	 */
	public java.util.Date getInsertTime() {
		return insertTime;
	}
	/**
	 * @param insertTime the insertTime to set
	 */
	public void setInsertTime(java.util.Date insertTime) {
		this.insertTime = insertTime;
	}
	/**
	 * @return the updateTime
	 */
	public java.util.Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * @return the insertedBy
	 */
	public java.lang.Long getInsertedBy() {
		return insertedBy;
	}
	/**
	 * @param insertedBy the insertedBy to set
	 */
	public void setInsertedBy(java.lang.Long insertedBy) {
		this.insertedBy = insertedBy;
	}
	/**
	 * @return the updatedBy
	 */
	public java.lang.Long getUpdatedBy() {
		return updatedBy;
	}
	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(java.lang.Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	/**
	 * @return the searchRuleId
	 */
	public Long getSearchRuleId() {
		return searchRuleId;
	}
	/**
	 * @param searchRuleId the searchRuleId to set
	 */
	public void setSearchRuleId(Long searchRuleId) {
		this.searchRuleId = searchRuleId;
	}
	/**
	 * @return the searchUserGroup
	 */
	public Long getSearchUserGroup() {
		return searchUserGroup;
	}
	/**
	 * @param searchUserGroup the searchUserGroup to set
	 */
	public void setSearchUserGroup(Long searchUserGroup) {
		this.searchUserGroup = searchUserGroup;
	}
	/**
	 * @return the searchDocClubType
	 */
	public Long getSearchDocClubType() {
		return searchDocClubType;
	}
	/**
	 * @param searchDocClubType the searchDocClubType to set
	 */
	public void setSearchDocClubType(Long searchDocClubType) {
		this.searchDocClubType = searchDocClubType;
	}

}
