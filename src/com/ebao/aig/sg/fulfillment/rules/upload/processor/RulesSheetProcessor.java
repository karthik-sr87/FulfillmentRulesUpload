package com.ebao.aig.sg.fulfillment.rules.upload.processor;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;

import com.ebao.aig.sg.fulfillment.rules.upload.handler.ExcelSheetCallback;
import com.ebao.aig.sg.fulfillment.rules.upload.handler.ExcelSheetCallbackImpl;
import com.ebao.aig.sg.fulfillment.rules.upload.handler.ExcelWorkSheetHandler;
import com.ebao.aig.sg.fulfillment.rules.upload.mapping.loader.MappingFileLoader;
import com.ebao.aig.sg.fulfillment.rules.upload.utility.ExcelReader;

public class RulesSheetProcessor {
	
	private static final Log LOG = LogFactory.getLog(RulesSheetProcessor.class);

	public static List process(OPCPackage pkg, SheetDetailsVO detailsVO) throws Exception{
	    // Excel Cell Mapping
		List configList = null;
	    Map<String, String> cellMapping = MappingFileLoader.getModuleConfigMap(detailsVO.getModuleName());
	    LOG.info("Mapping Count : "+cellMapping.size());

	    try {
	    	
	      ExcelWorkSheetHandler workSheetHandler = new ExcelWorkSheetHandler(Class.forName(detailsVO.getMappingVoClassName()), cellMapping);
	      workSheetHandler.setVerifiyHeader(detailsVO.isVerifyHeader());
	      workSheetHandler.setSkipRows(detailsVO.getSkipRows());
	      ExcelSheetCallback sheetCallback = new ExcelSheetCallbackImpl();
	      ExcelReader reader = new ExcelReader(pkg, workSheetHandler, sheetCallback);
	      reader.process(detailsVO.getSheetNo());
	      
	      if (workSheetHandler.getValueList().isEmpty()) {
	        // No data present
	        LOG.error(detailsVO.getModuleName()+" Config Rule List is empty");
	      } else {
	        LOG.info(workSheetHandler.getValueList().size()+ " no. of records read from "+detailsVO.getModuleName()+" worksheet successfully.");
	        configList = workSheetHandler.getValueList();
	        //LOG.info("Config Object Count : "+configList.size());
	      }
	    } catch (RuntimeException are) {
	    	LOG.error(are.getMessage()+ are.getCause());
	    } catch (InvalidFormatException ife) {
	    	LOG.error(ife.getMessage()+ ife.getCause());
	    } catch (IOException ioe) {
	    	LOG.error(ioe.getMessage()+ ioe.getCause());
	    } finally {
	      
	    }
	    return configList;
	}

}
