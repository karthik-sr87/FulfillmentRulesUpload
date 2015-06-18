package com.ebao.aig.sg.fulfillment.rules.upload.codetable.loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.foundation.common.config.Env;
import com.ebao.foundation.common.lang.StringUtils;
import com.ebao.pub.framework.ExceptionFactory;
import com.ebao.pub.util.DBean;


public class CodeTableLoader {

	private static final Log LOG = LogFactory.getLog(CodeTableLoader.class);
	
	public static Map codeTablesMap;
	public static Map fieldCodeTableMap;
	
	public static Map loadCodeTables(InputStream is)throws Exception{
		Map codeTableMap = new LinkedHashMap();
		List codeTableList = readCodeTablePropertyFile(is);
		Iterator codeTableListItr = codeTableList.iterator();
		while(codeTableListItr.hasNext()){
			CodeTableVO codeTableVO = (CodeTableVO)codeTableListItr.next();
			Map codeTableValueMap = retieveCodeTableValues(codeTableVO);
			codeTableMap.put(codeTableVO.getTableName(), codeTableValueMap);
		}
		return codeTableMap;
	}
	
	public static Map retieveCodeTableValues(CodeTableVO codeTableVO)throws Exception{
		 DBean db = new DBean();
		 Map codeTableValueMap = new LinkedHashMap();
			PreparedStatement ps = null;
			ResultSet rs = null;
			StringBuffer buf = new StringBuffer();
			buf.append("select lower(");
			buf.append(codeTableVO.getDescColumnName());
			buf.append(") , ");
			buf.append(codeTableVO.getIdColumnName());
			buf.append(" from ");
			buf.append(codeTableVO.getTableName());
			
			LOG.debug(buf.toString());
			try {
			  db.connect();
			  Connection con = db.getConnection();
			  ps = con.prepareStatement(buf.toString());
		      rs = ps.executeQuery();
		      while(rs.next()){
		    	  codeTableValueMap.put(rs.getString(1), rs.getString(2));
		      }
			  
			} catch (SQLException e) {
			  LOG.error("Unable to retrive code table values for table "+codeTableVO.getTableName()+". Cause : "+e.getMessage());
			} catch (ClassNotFoundException e) {
			  throw ExceptionFactory.parse(e);
			} finally {
			  DBean.closeAll(rs, ps, db);
			}
			return codeTableValueMap;
	}
	
	public static List readCodeTablePropertyFile(InputStream is)throws Exception{
		BufferedReader br = null;
		List codeTableList = new ArrayList();
		try {
 			String sCurrentLine;
 			br = new BufferedReader(new InputStreamReader(is));
 			while ((sCurrentLine = br.readLine()) != null) {
				LOG.debug("Code Table Value Line : "+sCurrentLine);
				String[] columns = sCurrentLine.split(",");
				if(columns.length==3){
					CodeTableVO codeTableVO = new CodeTableVO();
					//codeTableVO.setKeyName(columns[0]);
					codeTableVO.setTableName(columns[0]);
					codeTableVO.setIdColumnName(columns[1]);
					codeTableVO.setDescColumnName(columns[2]);
					codeTableList.add(codeTableVO);
				}else{
					LOG.error("Invalid Entry at Code Table Property File");
				}
			}
 
		} catch (IOException e) {
			LOG.error("Exception in reading Code table property File : "+e.getMessage() ); 
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				LOG.error("Exception in Closing Code Table Property File. Cause : "+ex.getMessage());
			}
		}
		return codeTableList;
	}
	
	public static Map loadFieldCodeTableMappingFile(InputStream is){
		BufferedReader br = null;
		Map fieldcodeTableList = new LinkedHashMap();
		try {
 			String sCurrentLine;
 			br = new BufferedReader(new InputStreamReader(is));
 			while ((sCurrentLine = br.readLine()) != null) {
				LOG.debug("Code Table Value Line : "+sCurrentLine);
				String[] columns = sCurrentLine.split(",");
				if(columns.length==2){
					fieldcodeTableList.put(columns[0], columns[1]);
				}else{
					LOG.error("Invalid Entry at Field Code Table Mapping Property File");
				}
			}
 
		} catch (IOException e) {
			LOG.error("Exception in reading Field Code table Mapping property File : "+e.getMessage() ); 
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				LOG.error("Exception in closing Field Code Table Mapping Property File. Cause : "+ex.getMessage());
			}
		}
		return fieldcodeTableList;
	}

	public static Map getFieldCodeTableMap(){
		if(fieldCodeTableMap==null){
			try{
				//URL resourceURL = CodeTableLoader.class.getResource("/META-INF/icp/env/FieldCodeTableMapping.txt");
				String fieldCodeTableFile = Env.getValue("FIELD_CODE_TABLE_MAPPING_FILE");
				InputStream is = CodeTableLoader.class.getResourceAsStream(fieldCodeTableFile);
				fieldCodeTableMap = loadFieldCodeTableMappingFile(is);
			}catch(Exception ex){
				LOG.error("Unable to Retrieve Field Code table values : "+ex.getMessage());
			}
		}
		return fieldCodeTableMap;
	}
	
	public static Map getCodeTablesMap() {
		if(codeTablesMap == null){
			try{
				String codeTableFile = Env.getValue("CODE_TABLE_PROPERTY_FILE");
				InputStream is = CodeTableLoader.class.getResourceAsStream(codeTableFile);
				codeTablesMap = loadCodeTables(is);
			}catch(Exception ex){
				LOG.error("Unable to Retrieve Code table values : "+ex.getMessage());
			}
		}
		return codeTablesMap;
	}
	
	public static void setCodeTablesMap(Map codeTablesMap) {
		CodeTableLoader.codeTablesMap = codeTablesMap;
	}
	
	public static String getCodeTableNameByFieldName(String fieldName){
		String tableName = null;
		Map fielCodeTableMap = getFieldCodeTableMap();
		if(fielCodeTableMap!=null){
			tableName = (String) fielCodeTableMap.get(fieldName);
		}
		return tableName;
	}
	
	public static Map getCodeTableMap(String keyName) {
		Map codeTableMap;
		if(codeTablesMap==null){
			getCodeTablesMap();
		}
		codeTableMap = (Map) codeTablesMap.get(keyName);
		return codeTableMap;
	}
	
	public static String getCodeTableId(String codeTableName, String desc){
		String id = null;
		Map codeTableMap = getCodeTableMap(codeTableName);
		if(codeTableMap!=null){
			id = (String) codeTableMap.get(desc);
		}
		return id;
	}
	
	public static String getCodeTableIdByDesc(String fieldName, String desc){
		String id = null;
		String tableName = getCodeTableNameByFieldName(fieldName);
		if(StringUtils.isNullOrEmpty(tableName)){
			LOG.error("Unable to get Code Table Name for field : "+fieldName);
		}else{
			id = getCodeTableId(tableName, desc.toLowerCase());
		}
		return id;
	}	
	
}
