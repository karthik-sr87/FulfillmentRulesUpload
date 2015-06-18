package com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo;

import java.io.Serializable;

public class TSgProdSmsExcepConfig implements Serializable {
	
	 private java.lang.Long prodSmsExpId;
	    private java.lang.Long lobCode;
	    private java.lang.String productCode;
	    private java.lang.Long planGroupId;
	    private java.lang.Long plans;
	    private java.lang.Long producerType;
	    private java.lang.String producerCodeFrom;
	    private java.lang.String producerCodeTo;
	    private java.lang.String producersExcluded;
	    private java.util.Date insertTime;
	    private java.util.Date updateTime;
	    private java.lang.Long insertedBy;
	    private java.lang.Long updatedBy;
	    private java.util.List errorList;
	    	    
		public java.lang.Long getProdSmsExpId() {
			return prodSmsExpId;
		}
		public void setProdSmsExpId(java.lang.Long prodSmsExpId) {
			this.prodSmsExpId = prodSmsExpId;
		}
		public java.lang.Long getLobCode() {
			return lobCode;
		}
		public void setLobCode(java.lang.Long lobCode) {
			this.lobCode = lobCode;
		}
		public java.lang.String getProductCode() {
			return productCode;
		}
		public void setProductCode(java.lang.String productCode) {
			this.productCode = productCode;
		}
		public java.lang.Long getPlanGroupId() {
			return planGroupId;
		}
		public void setPlanGroupId(java.lang.Long planGroupId) {
			this.planGroupId = planGroupId;
		}
		public java.lang.Long getPlans() {
			return plans;
		}
		public void setPlans(java.lang.Long plans) {
			this.plans = plans;
		}
		public java.lang.Long getProducerType() {
			return producerType;
		}
		public void setProducerType(java.lang.Long producerType) {
			this.producerType = producerType;
		}
		public java.lang.String getProducerCodeFrom() {
			return producerCodeFrom;
		}
		public void setProducerCodeFrom(java.lang.String producerCodeFrom) {
			this.producerCodeFrom = producerCodeFrom;
		}
		public java.lang.String getProducerCodeTo() {
			return producerCodeTo;
		}
		public void setProducerCodeTo(java.lang.String producerCodeTo) {
			this.producerCodeTo = producerCodeTo;
		}
		public java.lang.String getProducersExcluded() {
			return producersExcluded;
		}
		public void setProducersExcluded(java.lang.String producersExcluded) {
			this.producersExcluded = producersExcluded;
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
