package com.ebao.aig.sg.fulfillment.rules.upload.processor;

public class SheetDetailsVO {

	private String sheetName;
	private int sheetNo;
	private String mappingVoClassName;
	private String moduleName;
	private boolean verifyHeader;
	private int skipRows;
	public String getSheetName() {
		return sheetName;
	}
	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}
	public int getSheetNo() {
		return sheetNo;
	}
	public void setSheetNo(int sheetNo) {
		this.sheetNo = sheetNo;
	}
	public String getMappingVoClassName() {
		return mappingVoClassName;
	}
	public void setMappingVoClassName(String mappingVoClassName) {
		this.mappingVoClassName = mappingVoClassName;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public boolean isVerifyHeader() {
		return verifyHeader;
	}
	public void setVerifyHeader(boolean verifyHeader) {
		this.verifyHeader = verifyHeader;
	}
	public int getSkipRows() {
		return skipRows;
	}
	public void setSkipRows(int skipRows) {
		this.skipRows = skipRows;
	}
}
