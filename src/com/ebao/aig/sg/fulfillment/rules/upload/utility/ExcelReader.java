package com.ebao.aig.sg.fulfillment.rules.upload.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler;
import org.apache.poi.xssf.model.StylesTable;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.ebao.aig.sg.fulfillment.rules.upload.handler.ExcelSheetCallback;




public class ExcelReader {



	  private static final Log LOG = LogFactory.getLog(ExcelReader.class);

	  private static final int READ_ALL = -1;

	  private OPCPackage xlsxPackage;
	  private SheetContentsHandler sheetContentsHandler;
	  private ExcelSheetCallback sheetCallback;

	  /**
	   * Constructor: Microsoft Excel File (XSLX) Reader
	   * 
	   * @param pkg a {@link OPCPackage} object - The package to process XLSX
	   * @param sheetContentsHandler a {@link SheetContentsHandler} object - WorkSheet contents handler
	   * @param sheetCallback a {@link ExcelSheetCallback} object - WorkSheet callback for sheet
	   *        processing begin and end (can be null)
	   */
	  public ExcelReader(OPCPackage pkg, SheetContentsHandler sheetContentsHandler,
	      ExcelSheetCallback sheetCallback) {
	    this.xlsxPackage = pkg;
	    this.sheetContentsHandler = sheetContentsHandler;
	    this.sheetCallback = sheetCallback;
	  }

	  /**
	   * Constructor: Microsoft Excel File (XSLX) Reader
	   * 
	   * @param filePath a {@link String} object - The path of XLSX file
	   * @param sheetContentsHandler a {@link SheetContentsHandler} object - WorkSheet contents handler
	   * @param sheetCallback a {@link ExcelSheetCallback} object - WorkSheet callback for sheet
	   *        processing begin and end (can be null)
	   */
	  public ExcelReader(String filePath, SheetContentsHandler sheetContentsHandler,
	      ExcelSheetCallback sheetCallback) throws Exception {
	    this(getOPCPackage(getFile(filePath)), sheetContentsHandler, sheetCallback);
	  }

	  /**
	   * Constructor: Microsoft Excel File (XSLX) Reader
	   * 
	   * @param file a {@link File} object - The File object of XLSX file
	   * @param sheetContentsHandler a {@link SheetContentsHandler} object - WorkSheet contents handler
	   * @param sheetCallback a {@link ExcelSheetCallback} object - WorkSheet callback for sheet
	   *        processing begin and end (can be null)
	   */
	  public ExcelReader(File file, SheetContentsHandler sheetContentsHandler,
	      ExcelSheetCallback sheetCallback) throws Exception {
	    this(getOPCPackage(file), sheetContentsHandler, sheetCallback);
	  }

	  /**
	   * Processing all the WorkSheet from XLSX Workbook.
	   * 
	   * <br>
	   * <br>
	   * <strong>Example 1:</strong><br>
	   * <code>ExcelReader excelReader = new ExcelReader("src/main/resources/Sample-Person-Data.xlsx", workSheetHandler, sheetCallback);
	   * <br>excelReader.process();</code> <br>
	   * <br>
	   * <strong>Example 2:</strong><br>
	   * <code>ExcelReader excelReader = new ExcelReader(file, workSheetHandler, sheetCallback);
	   * <br>excelReader.process();</code> <br>
	   * <br>
	   * <strong>Example 3:</strong><br>
	   * <code>ExcelReader excelReader = new ExcelReader(pkg, workSheetHandler, sheetCallback);
	   * <br>excelReader.process();</code>
	   * 
	   * @throws Exception
	   */
	  public void process() throws Exception {
	    read(READ_ALL);
	  }

	  /**
	   * Processing of particular WorkSheet (zero based) from XLSX Workbook.
	   * 
	   * <br>
	   * <br>
	   * <strong>Example 1:</strong><br>
	   * <code>ExcelReader excelReader = new ExcelReader("src/main/resources/Sample-Person-Data.xlsx", workSheetHandler, sheetCallback);
	   * <br>excelReader.process(2);</code> <br>
	   * <br>
	   * <strong>Example 2:</strong><br>
	   * <code>ExcelReader excelReader = new ExcelReader(file, workSheetHandler, sheetCallback);
	   * <br>excelReader.process(2);</code> <br>
	   * <br>
	   * <strong>Example 3:</strong><br>
	   * <code>ExcelReader excelReader = new ExcelReader(pkg, workSheetHandler, sheetCallback);
	   * <br>excelReader.process(2);</code>
	   * 
	   * @param sheetNumber a int object
	   * @throws Exception
	   */
	  public void process(int sheetNumber) throws Exception {
	    read(sheetNumber);
	  }

	  private void read(int sheetNumber) throws RuntimeException {
	    ReadOnlySharedStringsTable strings;
	    try {
	      strings = new ReadOnlySharedStringsTable(this.xlsxPackage);
	      XSSFReader xssfReader = new XSSFReader(this.xlsxPackage);
	      StylesTable styles = xssfReader.getStylesTable();
	      XSSFReader.SheetIterator worksheets = (XSSFReader.SheetIterator) xssfReader.getSheetsData();

	      for (int sheetIndex = 0; worksheets.hasNext(); sheetIndex++) {
	        InputStream stream = worksheets.next();
	        if ((READ_ALL == sheetNumber) || (sheetIndex == sheetNumber)) {
	        	if (null != sheetCallback)
	  	          this.sheetCallback.startSheet(sheetIndex, worksheets.getSheetName());
	          readSheet(styles, strings, stream);
	          if (null != sheetCallback)
		          this.sheetCallback.endSheet();
	        }
	        IOUtils.closeQuietly(stream);
	      }
	    } catch (IOException ioe) {
	      LOG.error(ioe.getMessage(), ioe.getCause());
	    } catch (SAXException se) {
	      LOG.error(se.getMessage(), se.getCause());
	    } catch (OpenXML4JException oxe) {
	      LOG.error(oxe.getMessage(), oxe.getCause());
	    } catch (ParserConfigurationException pce) {
	      LOG.error(pce.getMessage(), pce.getCause());
	    }
	  }

	  /**
	   * Parses the content of one sheet using the specified styles and shared-strings tables.
	   * 
	   * @param styles a {@link StylesTable} object
	   * @param sharedStringsTable a {@link ReadOnlySharedStringsTable} object
	   * @param sheetInputStream a {@link InputStream} object
	   * @throws IOException
	   * @throws ParserConfigurationException
	   * @throws SAXException
	   */
	  private void readSheet(StylesTable styles, ReadOnlySharedStringsTable sharedStringsTable,
	      InputStream sheetInputStream) throws IOException, ParserConfigurationException, SAXException {

	    SAXParserFactory saxFactory = SAXParserFactory.newInstance();
	    XMLReader sheetParser = saxFactory.newSAXParser().getXMLReader();

	    ContentHandler handler =
	        new XSSFSheetXMLHandler(styles, sharedStringsTable, sheetContentsHandler, true);

	    sheetParser.setContentHandler(handler);
	    sheetParser.parse(new InputSource(sheetInputStream));
	  }

	  private static File getFile(String filePath) throws Exception {
	    if (null == filePath || filePath.isEmpty()) {
	      throw new Exception("File path cannot be null");
	    }

	    return new File(filePath);
	  }

	  private static OPCPackage getOPCPackage(File file) throws Exception {
	    if (null == file || !file.canRead()) {
	      throw new Exception("File object is null or cannot have read permission");
	    }

	    return OPCPackage.open(new FileInputStream(file));
	  }

}
