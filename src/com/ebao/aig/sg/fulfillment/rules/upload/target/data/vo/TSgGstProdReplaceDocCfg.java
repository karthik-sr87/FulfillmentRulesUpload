package com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo;

import java.io.Serializable;

public class TSgGstProdReplaceDocCfg implements Serializable {
	
	private java.lang.Long gstReplaceRuleId;
    private java.lang.Long originalDocId;
    private java.lang.Long replacementDocId;
    private java.util.Date replacementEffDate;
    private java.util.Date replacementExpDate; 
    private java.util.Date insertTime;
    private java.util.Date updateTime;
    private java.lang.Long insertedBy;
    private java.lang.Long updatedBy;
    private java.util.List errorList;
   
       
	public java.lang.Long getGstReplaceRuleId() {
		return gstReplaceRuleId;
	}
	public void setGstReplaceRuleId(java.lang.Long gstReplaceRuleId) {
		this.gstReplaceRuleId = gstReplaceRuleId;
	}
	public java.lang.Long getOriginalDocId() {
		return originalDocId;
	}
	public void setOriginalDocId(java.lang.Long originalDocId) {
		this.originalDocId = originalDocId;
	}
	public java.lang.Long getReplacementDocId() {
		return replacementDocId;
	}
	public void setReplacementDocId(java.lang.Long replacementDocId) {
		this.replacementDocId = replacementDocId;
	}
	public java.util.Date getReplacementEffDate() {
		return replacementEffDate;
	}
	public void setReplacementEffDate(java.util.Date replacementEffDate) {
		this.replacementEffDate = replacementEffDate;
	}
	public java.util.Date getReplacementExpDate() {
		return replacementExpDate;
	}
	public void setReplacementExpDate(java.util.Date replacementExpDate) {
		this.replacementExpDate = replacementExpDate;
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
