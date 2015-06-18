package com.ebao.aig.sg.fulfillment.rules.upload.processor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.util.IOUtils;

import com.ebao.aig.sg.fulfillment.rules.upload.constants.ModuleConstants;
import com.ebao.aig.sg.fulfillment.rules.upload.mapping.loader.ModuleDetailsLoader;
import com.ebao.aig.sg.fulfillment.rules.upload.parser.vo.FulfillmentModules;
import com.ebao.foundation.common.config.Env;

public class FulfillmentRulesProcessor {

	private static final Log LOG = LogFactory.getLog(FulfillmentRulesProcessor.class);

	public static FulfillmentModules readRulesExcel(String filePath)throws Exception{
		FulfillmentModules modules = new FulfillmentModules();
		File file = new File(filePath);
		InputStream inputStream = new FileInputStream(file);
		// The package open is instantaneous, as it should be.
		OPCPackage pkg = null;
		try {
			pkg = OPCPackage.open(inputStream);
			
			if(Env.getValue(ModuleConstants.FRMSConfigurator).equalsIgnoreCase("Y")){
				SheetDetailsVO detailsVO = ModuleDetailsLoader.getSheetDetailsByModuleName(ModuleConstants.FRMSConfigurator);
				List frmsFieldVOList = RulesSheetProcessor.process(pkg,detailsVO);
				modules.setFrmsFieldVOList(frmsFieldVOList);
			}
			if(Env.getValue(ModuleConstants.AutoFRMSConfigurator).equalsIgnoreCase("Y")){
				SheetDetailsVO detailsVO = ModuleDetailsLoader.getSheetDetailsByModuleName(ModuleConstants.AutoFRMSConfigurator);
				List autoFrmsFieldVOList = RulesSheetProcessor.process(pkg,detailsVO);
				modules.setAutoFrmsFieldVOList(autoFrmsFieldVOList);
			}
			if(Env.getValue(ModuleConstants.CustEmailExpConfigurator).equalsIgnoreCase("Y")){
				SheetDetailsVO detailsVO = ModuleDetailsLoader.getSheetDetailsByModuleName(ModuleConstants.CustEmailExpConfigurator);
				List custEmailExpFieldVOList = RulesSheetProcessor.process(pkg,detailsVO);
				modules.setCustEmailExpFieldVOList(custEmailExpFieldVOList);
			}
			if(Env.getValue(ModuleConstants.CustSMSExpConfigurator).equalsIgnoreCase("Y")){
				SheetDetailsVO detailsVO = ModuleDetailsLoader.getSheetDetailsByModuleName(ModuleConstants.CustSMSExpConfigurator);
				List custSMSExpFieldVOList = RulesSheetProcessor.process(pkg,detailsVO);
				modules.setCustSMSExpFieldVOList(custSMSExpFieldVOList);
			}
			if(Env.getValue(ModuleConstants.DNMReplacementConfigurator).equalsIgnoreCase("Y")){
				SheetDetailsVO detailsVO = ModuleDetailsLoader.getSheetDetailsByModuleName(ModuleConstants.DNMReplacementConfigurator);
				List dnmReplaceLetterFieldVOList = RulesSheetProcessor.process(pkg,detailsVO);
				modules.setDnmReplaceLetterFieldVOList(dnmReplaceLetterFieldVOList);
			}
			if(Env.getValue(ModuleConstants.EmailContentConfigurator).equalsIgnoreCase("Y")){
				SheetDetailsVO detailsVO = ModuleDetailsLoader.getSheetDetailsByModuleName(ModuleConstants.EmailContentConfigurator);
				List emailContentFieldVOList= RulesSheetProcessor.process(pkg,detailsVO);
				modules.setEmailContentFieldVOList(emailContentFieldVOList);
			}
			if(Env.getValue(ModuleConstants.ExtraInsertConfigurator).equalsIgnoreCase("Y")){
				SheetDetailsVO detailsVO = ModuleDetailsLoader.getSheetDetailsByModuleName(ModuleConstants.ExtraInsertConfigurator);
				List extraInsertFieldVOList = RulesSheetProcessor.process(pkg,detailsVO);
				modules.setExtraInsertFieldVOList(extraInsertFieldVOList);
			}
			if(Env.getValue(ModuleConstants.GSTProdDocReplacementConfigurator).equalsIgnoreCase("Y")){
				SheetDetailsVO detailsVO = ModuleDetailsLoader.getSheetDetailsByModuleName(ModuleConstants.GSTProdDocReplacementConfigurator);
				List gstProdDocReplFieldVOList = RulesSheetProcessor.process(pkg,detailsVO);
				modules.setGstProdDocReplFieldVOList(gstProdDocReplFieldVOList);
			}
			if(Env.getValue(ModuleConstants.GSTProducerConfigurator).equalsIgnoreCase("Y")){
				SheetDetailsVO detailsVO = ModuleDetailsLoader.getSheetDetailsByModuleName(ModuleConstants.GSTProducerConfigurator);
				List gstProdFieldVOList = RulesSheetProcessor.process(pkg,detailsVO);
				modules.setGstProdFieldVOList(gstProdFieldVOList);
			}
			if(Env.getValue(ModuleConstants.ImpNoticeConfigurator).equalsIgnoreCase("Y")){
				SheetDetailsVO detailsVO = ModuleDetailsLoader.getSheetDetailsByModuleName(ModuleConstants.ImpNoticeConfigurator);
				List impNoticeFieldVOList = RulesSheetProcessor.process(pkg,detailsVO);
				modules.setImpNoticeFieldVOList(impNoticeFieldVOList);
			}
			if(Env.getValue(ModuleConstants.LetterAttributeConfigurator).equalsIgnoreCase("Y")){
				SheetDetailsVO detailsVO = ModuleDetailsLoader.getSheetDetailsByModuleName(ModuleConstants.LetterAttributeConfigurator);
				List letterAttrFieldVOList = RulesSheetProcessor.process(pkg,detailsVO);
				modules.setLetterAttrFieldVOList(letterAttrFieldVOList);
			}
			if(Env.getValue(ModuleConstants.LetterMasterConfigurator).equalsIgnoreCase("Y")){
				SheetDetailsVO detailsVO = ModuleDetailsLoader.getSheetDetailsByModuleName(ModuleConstants.LetterMasterConfigurator);
				List letterMasterFieldVOList = RulesSheetProcessor.process(pkg,detailsVO);
				modules.setLetterMasterFieldVOList(letterMasterFieldVOList);
			}
			if(Env.getValue(ModuleConstants.ProdEmailExpConfigurator).equalsIgnoreCase("Y")){
				SheetDetailsVO detailsVO = ModuleDetailsLoader.getSheetDetailsByModuleName(ModuleConstants.ProdEmailExpConfigurator);
				List prodEmailExpFieldVOList = RulesSheetProcessor.process(pkg,detailsVO);
				modules.setProdEmailExpFieldVOList(prodEmailExpFieldVOList);
			}
			if(Env.getValue(ModuleConstants.ProdSMSExpConfigurator).equalsIgnoreCase("Y")){
				SheetDetailsVO detailsVO = ModuleDetailsLoader.getSheetDetailsByModuleName(ModuleConstants.ProdSMSExpConfigurator);
				List prodSMSExpFieldVOList= RulesSheetProcessor.process(pkg,detailsVO);
				modules.setProdSMSExpFieldVOList(prodSMSExpFieldVOList);
			}
			if(Env.getValue(ModuleConstants.ProducerExceptionConfigurator).equalsIgnoreCase("Y")){
				SheetDetailsVO detailsVO = ModuleDetailsLoader.getSheetDetailsByModuleName(ModuleConstants.ProducerExceptionConfigurator);
				List prodExpFieldVOList = RulesSheetProcessor.process(pkg,detailsVO);
				modules.setProdExpFieldVOList(prodExpFieldVOList);
			}
			if(Env.getValue(ModuleConstants.ProdSubTypeConfigurator).equalsIgnoreCase("Y")){
				SheetDetailsVO detailsVO = ModuleDetailsLoader.getSheetDetailsByModuleName(ModuleConstants.ProdSubTypeConfigurator);
				List prodSubTypeFiledVOList = RulesSheetProcessor.process(pkg,detailsVO);
				modules.setProdSubTypeFiledVOList(prodSubTypeFiledVOList);
			}
			if(Env.getValue(ModuleConstants.SMSContentConfigurator).equalsIgnoreCase("Y")){
				SheetDetailsVO detailsVO = ModuleDetailsLoader.getSheetDetailsByModuleName(ModuleConstants.SMSContentConfigurator);
				List smsContentFieldVOList = RulesSheetProcessor.process(pkg,detailsVO);
				modules.setSmsContentFieldVOList(smsContentFieldVOList);
			}
			if(Env.getValue(ModuleConstants.VoucherMasterConfigurator).equalsIgnoreCase("Y")){
				SheetDetailsVO detailsVO = ModuleDetailsLoader.getSheetDetailsByModuleName(ModuleConstants.VoucherMasterConfigurator);
				List voucherMasterFieldVOList = RulesSheetProcessor.process(pkg,detailsVO);
				modules.setVoucherMasterFieldVOList(voucherMasterFieldVOList);
			}
			
			
		} catch (RuntimeException are) {
			LOG.error(are.getMessage() + are.getCause() + are);
			are.printStackTrace();
		} catch (InvalidFormatException ife) {
			LOG.error(ife.getMessage() + ife.getCause());
			ife.printStackTrace();
		} catch (IOException ioe) {
			LOG.error(ioe.getMessage() + ioe.getCause());
			ioe.printStackTrace();
		} finally {
			IOUtils.closeQuietly(inputStream);
			try {
				if (null != pkg) {
					pkg.close();
				}
			} catch (IOException e) {
				// just ignore IO exception
			}
		}
		return modules;
	}

	

}
