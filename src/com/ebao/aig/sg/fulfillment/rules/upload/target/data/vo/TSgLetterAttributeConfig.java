/**
 * 
 */
package com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo;

/**
 * @author hcl168
 *
 */
public class TSgLetterAttributeConfig {
    private java.lang.Long letterAttributeId;
    private java.lang.Long letterId;
    private java.lang.String letterAttributeName;
    private java.lang.Integer letterAttributeType;
    private java.lang.String content;
    private java.util.Date insertTime =	new java.util.Date();
    private java.util.Date updateTime =	new java.util.Date();
    private java.lang.Long insertedBy;
    private java.lang.Long updatedBy;
    private java.util.List errorList;
	/**
	 * @return the letterAttributeId
	 */
	public java.lang.Long getLetterAttributeId() {
		return letterAttributeId;
	}
	/**
	 * @param letterAttributeId the letterAttributeId to set
	 */
	public void setLetterAttributeId(java.lang.Long letterAttributeId) {
		this.letterAttributeId = letterAttributeId;
	}
	/**
	 * @return the letterId
	 */
	public java.lang.Long getLetterId() {
		return letterId;
	}
	/**
	 * @param letterId the letterId to set
	 */
	public void setLetterId(java.lang.Long letterId) {
		this.letterId = letterId;
	}
	/**
	 * @return the letterAttributeName
	 */
	public java.lang.String getLetterAttributeName() {
		return letterAttributeName;
	}
	/**
	 * @param letterAttributeName the letterAttributeName to set
	 */
	public void setLetterAttributeName(java.lang.String letterAttributeName) {
		this.letterAttributeName = letterAttributeName;
	}
	/**
	 * @return the letterAttributeType
	 */
	public java.lang.Integer getLetterAttributeType() {
		return letterAttributeType;
	}
	/**
	 * @param letterAttributeType the letterAttributeType to set
	 */
	public void setLetterAttributeType(java.lang.Integer letterAttributeType) {
		this.letterAttributeType = letterAttributeType;
	}
	/**
	 * @return the content
	 */
	public java.lang.String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(java.lang.String content) {
		this.content = content;
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
