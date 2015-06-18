package com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo;

import java.io.Serializable;

public class TSgEmailContentConfig implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private java.lang.Long emailId;
    private java.lang.String emailCode;
    private java.lang.String emailName;
    private java.lang.Integer recipient;
    private java.lang.String emailContent;
    private java.util.Date insertTime =	new java.util.Date();
    private java.util.Date updateTime =	new java.util.Date();
    private java.lang.Long insertedBy;
    private java.lang.Long updatedBy;
    private java.util.List errorList;
    
    
	public java.lang.Long getEmailId() {
		return emailId;
	}
	public void setEmailId(java.lang.Long emailId) {
		this.emailId = emailId;
	}
	public java.lang.String getEmailCode() {
		return emailCode;
	}
	
	public void setEmailCode(java.lang.String emailCode) {
		this.emailCode = emailCode;
	}
	public java.lang.String getEmailName() {
		return emailName;
	}
	public void setEmailName(java.lang.String emailName) {
		this.emailName = emailName;
	}
	public java.lang.Integer getRecipient() {
		return recipient;
	}
	public void setRecipient(java.lang.Integer recipient) {
		this.recipient = recipient;
	}
	public java.lang.String getEmailContent() {
		return emailContent;
	}
	public void setEmailContent(java.lang.String emailContent) {
		this.emailContent = emailContent;
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
}
