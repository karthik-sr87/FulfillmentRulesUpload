package com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo;
import java.io.Serializable;

public class TSgDnmReplaceLetterConfig implements Serializable {

	private java.lang.Long dnmReplId;
    private java.lang.Long originalLetter;
    private java.lang.Long replacementLetter;
    private java.util.Date replacementEffDate;
    private java.util.Date replacementExpDate;
    private java.util.Date insertTime;
    private java.util.Date updateTime;
    private java.lang.Long insertedBy;
    private java.lang.Long updatedBy;
    private java.util.List errorList;
    
    
   
	/**
	 * @return the dnmReplId
	 */
	public java.lang.Long getDnmReplId() {
		return dnmReplId;
	}
	/**
	 * @param dnmReplId the dnmReplId to set
	 */
	public void setDnmReplId(java.lang.Long dnmReplId) {
		this.dnmReplId = dnmReplId;
	}
	/**
	 * @return the originalLetter
	 */
	public java.lang.Long getOriginalLetter() {
		return originalLetter;
	}
	/**
	 * @param originalLetter the originalLetter to set
	 */
	public void setOriginalLetter(java.lang.Long originalLetter) {
		this.originalLetter = originalLetter;
	}
	/**
	 * @return the replacementLetter
	 */
	public java.lang.Long getReplacementLetter() {
		return replacementLetter;
	}
	/**
	 * @param replacementLetter the replacementLetter to set
	 */
	public void setReplacementLetter(java.lang.Long replacementLetter) {
		this.replacementLetter = replacementLetter;
	}
	/**
	 * @return the replacementEffDate
	 */
	public java.util.Date getReplacementEffDate() {
		return replacementEffDate;
	}
	/**
	 * @param replacementEffDate the replacementEffDate to set
	 */
	public void setReplacementEffDate(java.util.Date replacementEffDate) {
		this.replacementEffDate = replacementEffDate;
	}
	/**
	 * @return the replacementExpDate
	 */
	public java.util.Date getReplacementExpDate() {
		return replacementExpDate;
	}
	/**
	 * @param replacementExpDate the replacementExpDate to set
	 */
	public void setReplacementExpDate(java.util.Date replacementExpDate) {
		this.replacementExpDate = replacementExpDate;
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
	public java.util.List getErrorList() {
		return errorList;
	}
	public void setErrorList(java.util.List errorList) {
		this.errorList = errorList;
	}
		
}