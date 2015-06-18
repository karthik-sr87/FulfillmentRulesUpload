package com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo;

import java.io.Serializable;

public class TSgUserGroupDocClubCfg implements Serializable {
    private java.lang.Long docClubListId;
    private java.lang.Long userGroup;
    private java.lang.Integer documentSet;
    private Long customerSet;
    private Long commonSet;
    private Long producerSet;
    private Long internalSet;
    private java.util.Date insertTime =	new java.util.Date();
    private java.util.Date updateTime =	new java.util.Date();
    private java.lang.Long insertedBy;
    private java.lang.Long updatedBy;
	/**
	 * @return the docClubListId
	 */
	public java.lang.Long getDocClubListId() {
		return docClubListId;
	}
	/**
	 * @param docClubListId the docClubListId to set
	 */
	public void setDocClubListId(java.lang.Long docClubListId) {
		this.docClubListId = docClubListId;
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
	 * @return the documentSet
	 */
	public java.lang.Integer getDocumentSet() {
		return documentSet;
	}
	/**
	 * @param documentSet the documentSet to set
	 */
	public void setDocumentSet(java.lang.Integer documentSet) {
		this.documentSet = documentSet;
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
	 * @return the customerSet
	 */
	public Long getCustomerSet() {
		return customerSet;
	}
	/**
	 * @param customerSet the customerSet to set
	 */
	public void setCustomerSet(Long customerSet) {
		this.customerSet = customerSet;
	}
	/**
	 * @return the commonSet
	 */
	public Long getCommonSet() {
		return commonSet;
	}
	/**
	 * @param commonSet the commonSet to set
	 */
	public void setCommonSet(Long commonSet) {
		this.commonSet = commonSet;
	}
	/**
	 * @return the producerSet
	 */
	public Long getProducerSet() {
		return producerSet;
	}
	/**
	 * @param producerSet the producerSet to set
	 */
	public void setProducerSet(Long producerSet) {
		this.producerSet = producerSet;
	}
	/**
	 * @return the internalSet
	 */
	public Long getInternalSet() {
		return internalSet;
	}
	/**
	 * @param internalSet the internalSet to set
	 */
	public void setInternalSet(Long internalSet) {
		this.internalSet = internalSet;
	}

}
