package com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo;

import java.io.Serializable;

public class TSgImpNoticeSeqConfig implements Serializable {
	
	private java.lang.Long seqListId;
    private java.lang.Long impNoticeId;
    private java.lang.Long impNoticeLetterId;
    private java.lang.Integer sequenceValue;
    private java.util.Date insertionEffDate;
    private java.util.Date insertionExpDate;
    private java.util.Date insertTime =	new java.util.Date();
    private java.util.Date updateTime =	new java.util.Date() ;
    private java.lang.Long insertedBy;
    private java.lang.Long updatedBy;
    
    public java.lang.Long getSeqListId() {
		return seqListId;
	}
	public void setSeqListId(java.lang.Long seqListId) {
		this.seqListId = seqListId;
	}
	public java.lang.Long getImpNoticeId() {
		return impNoticeId;
	}
	public void setImpNoticeId(java.lang.Long impNoticeId) {
		this.impNoticeId = impNoticeId;
	}
	public java.lang.Long getImpNoticeLetterId() {
		return impNoticeLetterId;
	}
	public void setImpNoticeLetterId(java.lang.Long impNoticeLetterId) {
		this.impNoticeLetterId = impNoticeLetterId;
	}
	public java.lang.Integer getSequenceValue() {
		return sequenceValue;
	}
	public void setSequenceValue(java.lang.Integer sequenceValue) {
		this.sequenceValue = sequenceValue;
	}
	public java.util.Date getInsertionEffDate() {
		return insertionEffDate;
	}
	public void setInsertionEffDate(java.util.Date insertionEffDate) {
		this.insertionEffDate = insertionEffDate;
	}
	public java.util.Date getInsertionExpDate() {
		return insertionExpDate;
	}
	public void setInsertionExpDate(java.util.Date insertionExpDate) {
		this.insertionExpDate = insertionExpDate;
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
	


}
