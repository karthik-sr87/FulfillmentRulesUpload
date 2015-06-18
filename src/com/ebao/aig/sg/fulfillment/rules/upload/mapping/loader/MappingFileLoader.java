package com.ebao.aig.sg.fulfillment.rules.upload.mapping.loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.codetable.loader.CodeTableLoader;
import com.ebao.foundation.common.config.Env;

public class MappingFileLoader {

	private static final Log LOG = LogFactory.getLog(MappingFileLoader.class);
	
	private static Map<String,Map> masterConfigMap;
	
	
	static{
		
	}
	
	public static Map readExcelMappingFile(InputStream is)throws Exception{
		BufferedReader br = null;
		Map mappingFileList = new LinkedHashMap();
		try {
 			String sCurrentLine;
 			br = new BufferedReader(new InputStreamReader(is));
 			while ((sCurrentLine = br.readLine()) != null) {
				LOG.debug("Excel Mapping Line : "+sCurrentLine);
				String[] columns = sCurrentLine.split(",");
				if(columns.length==2){
					mappingFileList.put(columns[0], columns[1]);
				}else{
					LOG.error("Invalid Entry at Excel Mapping File");
				}
			}
 
		} catch (IOException e) {
			LOG.error("Exception in reading Excel Mapping File : "+e.getMessage() ); 
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				LOG.error("Exception in Closing Excel Mapping File. Cause : "+ex.getMessage());
			}
		}
		return mappingFileList;
	}
	
	public static Map readConfigMappingFile(String configName, InputStream is)throws Exception{
		BufferedReader br = null;
		Map mappingFileList = new LinkedHashMap();
		try {
 			String sCurrentLine;
 			br = new BufferedReader(new InputStreamReader(is));
 			while ((sCurrentLine = br.readLine()) != null) {
				LOG.debug("Config Mapping Line : "+sCurrentLine);
				String[] columns = sCurrentLine.split(",");
				if(columns.length==2){
					mappingFileList.put(columns[0], columns[1]);
				}else{
					LOG.error("Invalid Entry at Config Mapping File : "+configName);
				}
			}
 
		} catch (IOException e) {
			LOG.error("Exception in reading Config Mapping File "+configName+" : "+e.getMessage() ); 
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				LOG.error("Exception in Closing Config Mapping File. Cause : "+ex.getMessage());
			}
		}
		return mappingFileList;
	}

	public static Map getMasterConfigMap() {
		if(masterConfigMap==null){
			InputStream is = null;
			try{
				masterConfigMap = new LinkedHashMap<String,Map>();
				String excelMappingFile = Env.getValue("EXCEL_MAPPING_FILE");
				is = MappingFileLoader.class.getResourceAsStream(excelMappingFile);
				Map excelMap = readExcelMappingFile(is);
				Iterator itr = excelMap.entrySet().iterator();
				while(itr.hasNext()){
					Entry excelEntry = (Entry) itr.next();
					String configName = (String) excelEntry.getKey();
					String mappingFileName = (String) excelEntry.getValue();
					is = CodeTableLoader.class.getResourceAsStream(mappingFileName);
					Map configMap = readConfigMappingFile(configName, is);
					masterConfigMap.put(configName, configMap);
					LOG.info("Completed Processing for file : "+mappingFileName);
				}
			}catch(Exception ex){
				LOG.error("Unable to process ExcelMapping File : "+ex.getCause());
				ex.printStackTrace();
			}finally{
				try{
				if(is!=null)
					is.close();
				}catch(Exception ex){
					LOG.error("Unable to close Input Stream");
					
				}
			}
		}
		return masterConfigMap;
	}

	public static void setMasterConfigMap(Map masterConfigMap) {
		MappingFileLoader.masterConfigMap = masterConfigMap;
	}

	public static Map<String,String> getModuleConfigMap(String configName) {
		getMasterConfigMap();
		Map<String,String> moduleConfigMap = null;
		if(masterConfigMap.containsKey(configName)){
			moduleConfigMap = (Map)masterConfigMap.get(configName);
		}
		return moduleConfigMap;
	}
}
