package com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo;
import java.io.Serializable;

public class TSgSmsContentConfig implements Serializable 
{
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private java.lang.Long smsId;
	    private java.lang.String smsCode;
	    private java.lang.String smsName;
	    private java.lang.Integer recipient;
	    private java.lang.String smsContent;
	    private java.util.Date insertTime =	new java.util.Date();
	    private java.util.Date updateTime =	new java.util.Date();
	    private java.lang.Long insertedBy;
	    private java.lang.Long updatedBy; 
	    private java.util.List errorList;
	    
		public java.lang.Long getSmsId() {
			return smsId;
		}
		public void setSmsId(java.lang.Long smsId) {
			this.smsId = smsId;
		}
		public java.lang.String getSmsCode() {
			return smsCode;
		}
		public void setSmsCode(java.lang.String smsCode) {
			this.smsCode = smsCode;
		}
		public java.lang.String getSmsName() {
			return smsName;
		}
		public void setSmsName(java.lang.String smsName) {
			this.smsName = smsName;
		}
		public java.lang.Integer getRecipient() {
			return recipient;
		}
		public void setRecipient(java.lang.Integer recipient) {
			this.recipient = recipient;
		}
		public java.lang.String getSmsContent() {
			return smsContent;
		}
		public void setSmsContent(java.lang.String smsContent) {
			this.smsContent = smsContent;
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
