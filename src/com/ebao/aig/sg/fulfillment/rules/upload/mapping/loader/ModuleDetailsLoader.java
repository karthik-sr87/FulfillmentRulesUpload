package com.ebao.aig.sg.fulfillment.rules.upload.mapping.loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.processor.SheetDetailsVO;
import com.ebao.foundation.common.config.Env;

public class ModuleDetailsLoader {

	private static final Log LOG = LogFactory.getLog(ModuleDetailsLoader.class);
	
	private static Map<String,SheetDetailsVO> moduleConfigMap;
	
	public static Map readModuleConfigFile(InputStream is)throws Exception{
		BufferedReader br = null;
		Map<String, SheetDetailsVO> moduleConfigList = new LinkedHashMap<String, SheetDetailsVO>();
		try {
 			String sCurrentLine;
 			br = new BufferedReader(new InputStreamReader(is));
 			while ((sCurrentLine = br.readLine()) != null) {
				LOG.debug("Module Config Line : "+sCurrentLine);
				String[] columns = sCurrentLine.split(",");
				if(columns.length==5){
					SheetDetailsVO detailsVO = new SheetDetailsVO();
					detailsVO.setModuleName(columns[0]);
					detailsVO.setSheetNo(Integer.valueOf(columns[1]));
					String verifyHeader = columns[2];
					if(verifyHeader.equalsIgnoreCase("N"))
						detailsVO.setVerifyHeader(false);
					else
						detailsVO.setVerifyHeader(true);
					detailsVO.setSkipRows(Integer.valueOf(columns[3]));
					detailsVO.setMappingVoClassName(columns[4]);
					moduleConfigList.put(columns[0], detailsVO);
				}else{
					LOG.error("Invalid Entry at Module Config File");
				}
			}
 
		} catch (IOException e) {
			LOG.error("Exception in reading Module Config File : "+e.getMessage() ); 
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				LOG.error("Exception in Closing Module Config File. Cause : "+ex.getMessage());
			}
		}
		return moduleConfigList;
	}

	public static Map getModuleConfigMap() {
		if(moduleConfigMap==null){
			InputStream is = null;
			try{
				String excelMappingFile = Env.getValue("MODULE_CONFIG_FILE");
				is = ModuleDetailsLoader.class.getResourceAsStream(excelMappingFile);
				moduleConfigMap = readModuleConfigFile(is);
				LOG.info("Module Config file processing completed!!!");
			}catch(Exception ex){
				LOG.error("Unable to process Module Config File : "+ex.getCause());
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
		return moduleConfigMap;
	}
	
	public static SheetDetailsVO getSheetDetailsByModuleName(String moduleName){
		SheetDetailsVO detailsVO = null;
		Map configMap = getModuleConfigMap();
		if(configMap!=null)
			detailsVO = (SheetDetailsVO)configMap.get(moduleName);
		return 	detailsVO;
	}
}
