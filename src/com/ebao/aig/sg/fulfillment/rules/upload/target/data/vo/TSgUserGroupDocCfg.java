package com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo;

import java.io.Serializable;

public class TSgUserGroupDocCfg implements Serializable {
    private java.lang.Long docTypeListId;
    private java.lang.Long userGroup;
    private java.lang.Integer transactionId;
    private java.lang.Integer documentType;
    private java.util.Date insertTime =	new java.util.Date()
;
    private java.util.Date updateTime =	new java.util.Date()
;
    private java.lang.Long insertedBy;
    private java.lang.Long updatedBy;
	/**
	 * @return the docTypeListId
	 */
	public java.lang.Long getDocTypeListId() {
		return docTypeListId;
	}
	/**
	 * @param docTypeListId the docTypeListId to set
	 */
	public void setDocTypeListId(java.lang.Long docTypeListId) {
		this.docTypeListId = docTypeListId;
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
	 * @return the transactionId
	 */
	public java.lang.Integer getTransactionId() {
		return transactionId;
	}
	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(java.lang.Integer transactionId) {
		this.transactionId = transactionId;
	}
	/**
	 * @return the documentType
	 */
	public java.lang.Integer getDocumentType() {
		return documentType;
	}
	/**
	 * @param documentType the documentType to set
	 */
	public void setDocumentType(java.lang.Integer documentType) {
		this.documentType = documentType;
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
    
}
