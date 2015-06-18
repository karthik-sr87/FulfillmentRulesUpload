package com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo;

import java.io.Serializable;

public class TSgProducerExceptionConfig implements Serializable{
    private java.lang.Long pdcrExcpRuleId;
    private java.lang.Long lobId;
    private java.lang.String pdcrCodeFrom;
    private java.lang.String pdcrCodeTo;
    private java.lang.String excludePdcrCode;
    private java.lang.Integer sprsCustEmail;
    private java.lang.Integer sprsCustOffline;
    private java.lang.Integer sprsPdcrOffline;
    private java.util.Date effectiveDate;
    private java.util.Date expiryDate;
    private java.util.Date insertTime =	new java.util.Date();
    private java.util.Date updateTime =	new java.util.Date();
    private java.lang.Long insertedBy;
    private java.lang.Long updatedBy;
    private java.util.List errorList;
	/**
	 * @return the pdcrExcpRuleId
	 */
	public java.lang.Long getPdcrExcpRuleId() {
		return pdcrExcpRuleId;
	}
	/**
	 * @param pdcrExcpRuleId the pdcrExcpRuleId to set
	 */
	public void setPdcrExcpRuleId(java.lang.Long pdcrExcpRuleId) {
		this.pdcrExcpRuleId = pdcrExcpRuleId;
	}
	/**
	 * @return the lobId
	 */
	public java.lang.Long getLobId() {
		return lobId;
	}
	/**
	 * @param lobId the lobId to set
	 */
	public void setLobId(java.lang.Long lobId) {
		this.lobId = lobId;
	}
	/**
	 * @return the pdcrCodeFrom
	 */
	public java.lang.String getPdcrCodeFrom() {
		return pdcrCodeFrom;
	}
	/**
	 * @param pdcrCodeFrom the pdcrCodeFrom to set
	 */
	public void setPdcrCodeFrom(java.lang.String pdcrCodeFrom) {
		this.pdcrCodeFrom = pdcrCodeFrom;
	}
	/**
	 * @return the pdcrCodeTo
	 */
	public java.lang.String getPdcrCodeTo() {
		return pdcrCodeTo;
	}
	/**
	 * @param pdcrCodeTo the pdcrCodeTo to set
	 */
	public void setPdcrCodeTo(java.lang.String pdcrCodeTo) {
		this.pdcrCodeTo = pdcrCodeTo;
	}
	/**
	 * @return the excludePdcrCode
	 */
	public java.lang.String getExcludePdcrCode() {
		return excludePdcrCode;
	}
	/**
	 * @param excludePdcrCode the excludePdcrCode to set
	 */
	public void setExcludePdcrCode(java.lang.String excludePdcrCode) {
		this.excludePdcrCode = excludePdcrCode;
	}
	/**
	 * @return the sprsCustEmail
	 */
	public java.lang.Integer getSprsCustEmail() {
		return sprsCustEmail;
	}
	/**
	 * @param sprsCustEmail the sprsCustEmail to set
	 */
	public void setSprsCustEmail(java.lang.Integer sprsCustEmail) {
		this.sprsCustEmail = sprsCustEmail;
	}
	/**
	 * @return the sprsCustOffline
	 */
	public java.lang.Integer getSprsCustOffline() {
		return sprsCustOffline;
	}
	/**
	 * @param sprsCustOffline the sprsCustOffline to set
	 */
	public void setSprsCustOffline(java.lang.Integer sprsCustOffline) {
		this.sprsCustOffline = sprsCustOffline;
	}
	/**
	 * @return the sprsPdcrOffline
	 */
	public java.lang.Integer getSprsPdcrOffline() {
		return sprsPdcrOffline;
	}
	/**
	 * @param sprsPdcrOffline the sprsPdcrOffline to set
	 */
	public void setSprsPdcrOffline(java.lang.Integer sprsPdcrOffline) {
		this.sprsPdcrOffline = sprsPdcrOffline;
	}
	/**
	 * @return the effectiveDate
	 */
	public java.util.Date getEffectiveDate() {
		return effectiveDate;
	}
	/**
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(java.util.Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	/**
	 * @return the expiryDate
	 */
	public java.util.Date getExpiryDate() {
		return expiryDate;
	}
	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(java.util.Date expiryDate) {
		this.expiryDate = expiryDate;
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
