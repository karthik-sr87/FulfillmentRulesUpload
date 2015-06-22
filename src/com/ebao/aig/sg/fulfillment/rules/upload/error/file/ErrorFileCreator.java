package com.ebao.aig.sg.fulfillment.rules.upload.error.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ebao.aig.sg.fulfillment.rules.upload.validator.ErrorCodeVO;
import com.ebao.foundation.common.config.Env;

public class ErrorFileCreator {

	private static final Log LOG = LogFactory.getLog(ErrorFileCreator.class);
	
	public void createErrorFile(Map errorMap)throws Exception{
		
		//create a new workbook
		Workbook wb = new XSSFWorkbook();
		
		//add a new sheet to the workbook
		Iterator errorMapIterator = errorMap.entrySet().iterator();
		while(errorMapIterator.hasNext()){
			Entry errorMapEntry = (Entry)errorMapIterator.next();
			String sheetName = (String) errorMapEntry.getKey();
			LOG.info("Started creating Error Sheet : "+sheetName);
			Sheet sheet = wb.createSheet(sheetName);
			createHeaderRow(sheet, 0);
			List errorValueList = (List) errorMapEntry.getValue();
			if(errorValueList!=null){
				for(int i=0; i<errorValueList.size();i++){
					ErrorCodeVO errorCodeVO = (ErrorCodeVO) errorValueList.get(i);
					createDetailRow(sheet, i+1, errorCodeVO);
				}
			}
			LOG.info("Finished creating Error Sheet : "+sheetName);
		}
		try {
			String errorFilePath = Env.getValue("ERROR_FILE_PATH");
	    	FileOutputStream fileOut = new FileOutputStream(errorFilePath);
			wb.write(fileOut);
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void createHeaderRow(Sheet sheet, int rowNum)throws Exception{
		Row headerRow = sheet.createRow(rowNum);
		
		Cell row1col1 = headerRow.createCell(0);
		Cell row1col2 = headerRow.createCell(1);
		Cell row1col3 = headerRow.createCell(2);
		Cell row1col4 = headerRow.createCell(3);
		
		//add data to the cells
		row1col1.setCellValue("Rule ID");
		row1col2.setCellValue("Module");
		row1col3.setCellValue("Field Name");
		row1col4.setCellValue("Error Description");
	}
	
	public void createDetailRow(Sheet sheet, int rowNum, ErrorCodeVO errorCodeVO)throws Exception{
		Row headerRow = sheet.createRow(rowNum);
		
		Cell row1col1 = headerRow.createCell(0);
		Cell row1col2 = headerRow.createCell(1);
		Cell row1col3 = headerRow.createCell(2);
		Cell row1col4 = headerRow.createCell(3);
		
		//add data to the cells
		if(errorCodeVO.getRuleId()!=null)
			row1col1.setCellValue(errorCodeVO.getRuleId());
		if(errorCodeVO.getModuleName()!=null)
			row1col2.setCellValue(errorCodeVO.getModuleName());
		if(errorCodeVO.getFieldName()!=null)
			row1col3.setCellValue(errorCodeVO.getFieldName());
		if(errorCodeVO.getErrorDesc()!=null)
			row1col4.setCellValue(errorCodeVO.getErrorDesc());
	}
}
