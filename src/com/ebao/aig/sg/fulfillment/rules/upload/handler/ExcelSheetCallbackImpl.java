package com.ebao.aig.sg.fulfillment.rules.upload.handler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class ExcelSheetCallbackImpl implements ExcelSheetCallback{

	private static final Log LOG = LogFactory.getLog(ExcelSheetCallbackImpl.class);
	
	private int sheetNumber = 0;

    @Override
    public void startSheet(int sheetNum, String sheetName) {
      this.sheetNumber = sheetNum;
      LOG.info("Started processing sheet number=" + sheetNumber
          + " and Sheet Name is '" + sheetName + "'");
    }

    @Override
    public void endSheet() {
      LOG.info("Processing completed for sheet number=" + sheetNumber);
    }
}
