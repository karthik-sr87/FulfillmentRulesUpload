package com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo;

import java.io.Serializable;

public class TSgUserGrpDelivermodeCfg implements Serializable {

    private java.lang.Long deliveryModeId;
    private java.lang.Long userGroup;
    private java.lang.Integer deliveryMode;
    private java.lang.Integer emailCheck;
    private java.lang.Integer offlineCheck;
    private java.lang.Integer onlineCheck;
    private java.util.Date insertTime =	new java.util.Date();
    private java.util.Date updateTime =	new java.util.Date();
    private java.lang.Long insertedBy;
    private java.lang.Long updatedBy;
	/**
	 * @return the deliveryModeIdofflineCheck
	 */
	public java.lang.Long getDeliveryModeId() {
		return deliveryModeId;
	}
	/**
	 * @param deliveryModeId the deliveryModeId to set
	 */
	public void setDeliveryModeId(java.lang.Long deliveryModeId) {
		this.deliveryModeId = deliveryModeId;
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
	 * @return the deliveryMode
	 */
	public java.lang.Integer getDeliveryMode() {
		return deliveryMode;
	}
	/**
	 * @param deliveryMode the deliveryMode to set
	 */
	public void setDeliveryMode(java.lang.Integer deliveryMode) {
		this.deliveryMode = deliveryMode;
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
	 * @return the offlineCheck
	 */
	public java.lang.Integer getOfflineCheck() {
		return offlineCheck;
	}
	/**
	 * @param offlineCheck the offlineCheck to set
	 */
	public void setOfflineCheck(java.lang.Integer offlineCheck) {
		this.offlineCheck = offlineCheck;
	}
	/**
	 * @return the onlineCheck
	 */
	public java.lang.Integer getOnlineCheck() {
		return onlineCheck;
	}
	/**
	 * @param onlineCheck the onlineCheck to set
	 */
	public void setOnlineCheck(java.lang.Integer onlineCheck) {
		this.onlineCheck = onlineCheck;
	}
	/**
	 * @return the emailCheck
	 */
	public java.lang.Integer getEmailCheck() {
		return emailCheck;
	}
	/**
	 * @param emailCheck the emailCheck to set
	 */
	public void setEmailCheck(java.lang.Integer emailCheck) {
		this.emailCheck = emailCheck;
	}
    

}
