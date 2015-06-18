package com.ebao.aig.sg.fulfillment.rules.upload.handler;

public interface ExcelSheetCallback {

  /**
   * Callback for Worksheet start
   * 
   * @param sheetNum
   * @param sheetName
   */
  void startSheet(int sheetNum, String sheetName);

  /**
   * Callback for Worksheet end
   */
  void endSheet();

}
