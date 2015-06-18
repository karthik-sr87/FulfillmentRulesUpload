package com.ebao.aig.sg.fulfillment.rules.upload.codetable.loader;

public class CodeTableVO {

	private String keyName;
	private String tableName;
	private String idColumnName;
	private String descColumnName;
	public String getKeyName() {
		return keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getIdColumnName() {
		return idColumnName;
	}
	public void setIdColumnName(String idColumnName) {
		this.idColumnName = idColumnName;
	}
	public String getDescColumnName() {
		return descColumnName;
	}
	public void setDescColumnName(String descColumnName) {
		this.descColumnName = descColumnName;
	}
}
