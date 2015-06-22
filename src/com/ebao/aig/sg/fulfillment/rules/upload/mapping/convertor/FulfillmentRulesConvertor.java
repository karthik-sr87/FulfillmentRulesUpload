package com.ebao.aig.sg.fulfillment.rules.upload.mapping.convertor;

import java.util.LinkedHashMap;
import java.util.Map;

import com.ebao.aig.sg.fulfillment.rules.upload.constants.FieldConstants;
import com.ebao.aig.sg.fulfillment.rules.upload.error.file.ErrorFileCreator;
import com.ebao.aig.sg.fulfillment.rules.upload.parser.vo.FulfillmentModules;
import com.ebao.aig.sg.fulfillment.rules.upload.rules.saver.CustEmailExpRulesSaver;
import com.ebao.aig.sg.fulfillment.rules.upload.rules.saver.CustSMSExpRulesSaver;
import com.ebao.aig.sg.fulfillment.rules.upload.rules.saver.DNMReplaceLetterRulesSaver;
import com.ebao.aig.sg.fulfillment.rules.upload.rules.saver.EmailContentRulesSaver;
import com.ebao.aig.sg.fulfillment.rules.upload.rules.saver.ExtraInsertConfigRulesSaver;
import com.ebao.aig.sg.fulfillment.rules.upload.rules.saver.FRMSRulesSaver;
import com.ebao.aig.sg.fulfillment.rules.upload.rules.saver.GSTProdDocReplaceRulesSaver;
import com.ebao.aig.sg.fulfillment.rules.upload.rules.saver.GSTProducerConfigRulesSaver;
import com.ebao.aig.sg.fulfillment.rules.upload.rules.saver.ImpNoticeConfigRulesSaver;
import com.ebao.aig.sg.fulfillment.rules.upload.rules.saver.LetterAttrConfigRulesSaver;
import com.ebao.aig.sg.fulfillment.rules.upload.rules.saver.LetterMasterConfigRulesSaver;
import com.ebao.aig.sg.fulfillment.rules.upload.rules.saver.ProdEmailExpRulesSaver;
import com.ebao.aig.sg.fulfillment.rules.upload.rules.saver.ProdExpRulesSaver;
import com.ebao.aig.sg.fulfillment.rules.upload.rules.saver.ProdSMSExpRulesSaver;
import com.ebao.aig.sg.fulfillment.rules.upload.rules.saver.ProdSubTypeRulesSaver;
import com.ebao.aig.sg.fulfillment.rules.upload.rules.saver.SMSContentRulesSaver;
import com.ebao.aig.sg.fulfillment.rules.upload.rules.saver.VoucherConfigRulesSaver;

public class FulfillmentRulesConvertor {

	public static void convertRules(FulfillmentModules modules)throws Exception{
		FulfillmentModules convertModules = new FulfillmentModules();
		Map masterErrorMap = new LinkedHashMap();
		
		
		if(modules.getExtraInsertFieldVOList()!=null){
			ConvertorVO convertorVO = ExtraInsertConfigConvertor.convertor(modules.getExtraInsertFieldVOList());
			masterErrorMap.put(FieldConstants.extraInsConfigurator, convertorVO.getMasterErrorList());
			convertModules.setExtraInsertFieldVOList(convertorVO.getConfigVOList());
			ExtraInsertConfigRulesSaver saver = new ExtraInsertConfigRulesSaver();
			saver.saveRules(convertorVO.getConfigVOList());
		}
		if(modules.getVoucherMasterFieldVOList()!=null){
			ConvertorVO convertorVO = VoucherConfigConvertor.convertor(modules.getVoucherMasterFieldVOList());
			masterErrorMap.put(FieldConstants.VoucherConfigurator, convertorVO.getMasterErrorList());
			convertModules.setVoucherMasterFieldVOList(convertorVO.getConfigVOList());
			VoucherConfigRulesSaver saver = new VoucherConfigRulesSaver();
			//saver.saveRules(convertorVO.getConfigVOList());
		}
		if(modules.getCustEmailExpFieldVOList()!=null){
			ConvertorVO convertorVO = CustEmailExpConfigConvertor.convertor(modules.getCustEmailExpFieldVOList());
			masterErrorMap.put(FieldConstants.custEmailExpConfigurator, convertorVO.getMasterErrorList());
			convertModules.setCustEmailExpFieldVOList(convertorVO.getConfigVOList());
			CustEmailExpRulesSaver saver = new CustEmailExpRulesSaver();
			saver.saveRules(convertorVO.getConfigVOList());
		}
		if(modules.getCustSMSExpFieldVOList()!=null){
			ConvertorVO convertorVO = CustSMSExpConfigConvertor.convertor(modules.getCustSMSExpFieldVOList());
			masterErrorMap.put(FieldConstants.custSMSExpConfigurator, convertorVO.getMasterErrorList());
			convertModules.setCustSMSExpFieldVOList(convertorVO.getConfigVOList());
			CustSMSExpRulesSaver saver = new CustSMSExpRulesSaver();
			saver.saveRules(convertorVO.getConfigVOList());
		}
		if(modules.getProdEmailExpFieldVOList()!=null){
			ConvertorVO convertorVO = ProdEmailExpConfigConvertor.convertor(modules.getProdEmailExpFieldVOList());
			masterErrorMap.put(FieldConstants.prodEmailExpConfigurator, convertorVO.getMasterErrorList());
			convertModules.setProdEmailExpFieldVOList(convertorVO.getConfigVOList());
			ProdEmailExpRulesSaver saver = new ProdEmailExpRulesSaver();
			saver.saveRules(convertorVO.getConfigVOList());
		}
		if(modules.getProdSMSExpFieldVOList()!=null){
			ConvertorVO convertorVO = ProdSMSExpConfigConvertor.convertor(modules.getProdSMSExpFieldVOList());
			masterErrorMap.put(FieldConstants.prodSMSExpConfigurator, convertorVO.getMasterErrorList());
			convertModules.setProdSMSExpFieldVOList(convertorVO.getConfigVOList());
			ProdSMSExpRulesSaver saver = new ProdSMSExpRulesSaver();
			saver.saveRules(convertorVO.getConfigVOList());
		}
		if(modules.getEmailContentFieldVOList()!=null){
			ConvertorVO convertorVO = EmailContentConfigConvertor.convertor(modules.getEmailContentFieldVOList());
			masterErrorMap.put(FieldConstants.emailContentConfigurator, convertorVO.getMasterErrorList());
			convertModules.setEmailContentFieldVOList(convertorVO.getConfigVOList());
			EmailContentRulesSaver saver = new EmailContentRulesSaver();
			saver.saveRules(convertorVO.getConfigVOList());
		}
		if(modules.getSmsContentFieldVOList()!=null){
			ConvertorVO convertorVO = SMSContentConfigConvertor.convertor(modules.getSmsContentFieldVOList());
			masterErrorMap.put(FieldConstants.smsContentConfigurator, convertorVO.getMasterErrorList());
			convertModules.setSmsContentFieldVOList(convertorVO.getConfigVOList());
			SMSContentRulesSaver saver = new SMSContentRulesSaver();
			saver.saveRules(convertorVO.getConfigVOList());
		}
		if(modules.getProdSubTypeFiledVOList()!=null){
			ConvertorVO convertorVO = ProdSubTypeConfigConvertor.convertor(modules.getProdSubTypeFiledVOList());
			masterErrorMap.put(FieldConstants.prodSubTypeConfigurator, convertorVO.getMasterErrorList());
			convertModules.setProdSubTypeFiledVOList(convertorVO.getConfigVOList());
			ProdSubTypeRulesSaver saver = new ProdSubTypeRulesSaver();
			saver.saveRules(convertorVO.getConfigVOList());
		}
		if(modules.getProdExpFieldVOList()!=null){
			ConvertorVO convertorVO = ProducerExpConfigConvertor.convertor(modules.getProdExpFieldVOList());
			masterErrorMap.put(FieldConstants.prodExpConfigurator, convertorVO.getMasterErrorList());
			convertModules.setProdExpFieldVOList(convertorVO.getConfigVOList());
			ProdExpRulesSaver saver = new ProdExpRulesSaver();
			saver.saveRules(convertorVO.getConfigVOList());
		}
		if(modules.getGstProdFieldVOList()!=null){
			ConvertorVO convertorVO = GSTProducerConfigConvertor.convertor(modules.getGstProdFieldVOList());
			masterErrorMap.put(FieldConstants.gstProducerConfigurator, convertorVO.getMasterErrorList());
			convertModules.setGstProdFieldVOList(convertorVO.getConfigVOList());
			GSTProducerConfigRulesSaver saver = new GSTProducerConfigRulesSaver();
			saver.saveRules(convertorVO.getConfigVOList());
		}
		if(modules.getGstProdDocReplFieldVOList()!=null){
			ConvertorVO convertorVO = GSTProdDocReplaceConfigConvertor.convertor(modules.getGstProdDocReplFieldVOList());
			masterErrorMap.put(FieldConstants.gstDocReplaceConfigurator, convertorVO.getMasterErrorList());
			convertModules.setGstProdDocReplFieldVOList(convertorVO.getConfigVOList());
			GSTProdDocReplaceRulesSaver saver = new GSTProdDocReplaceRulesSaver();
			saver.saveRules(convertorVO.getConfigVOList());
		}
		if(modules.getLetterMasterFieldVOList()!=null){
			ConvertorVO convertorVO = LetterMasterConfigConvertor.convertor(modules.getLetterMasterFieldVOList());
			masterErrorMap.put(FieldConstants.letterMasterConfigurator, convertorVO.getMasterErrorList());
			convertModules.setLetterMasterFieldVOList(convertorVO.getConfigVOList());
			LetterMasterConfigRulesSaver saver = new LetterMasterConfigRulesSaver();
			saver.saveRules(convertorVO.getConfigVOList());
		}
		if(modules.getLetterAttrFieldVOList()!=null){
			ConvertorVO convertorVO = LetterAttributeConfigConvertor.convertor(modules.getLetterAttrFieldVOList());
			masterErrorMap.put(FieldConstants.letterAttributeConfigurator, convertorVO.getMasterErrorList());
			convertModules.setLetterAttrFieldVOList(convertorVO.getConfigVOList());
			LetterAttrConfigRulesSaver saver = new LetterAttrConfigRulesSaver();
			saver.saveRules(convertorVO.getConfigVOList());
		}
		if(modules.getDnmReplaceLetterFieldVOList()!=null){
			ConvertorVO convertorVO = DNMReplacementConfigConvertor.convertor(modules.getDnmReplaceLetterFieldVOList());
			masterErrorMap.put(FieldConstants.dnmReplaceConfigurator, convertorVO.getMasterErrorList());
			convertModules.setDnmReplaceLetterFieldVOList(convertorVO.getConfigVOList());
			DNMReplaceLetterRulesSaver saver = new DNMReplaceLetterRulesSaver();
			saver.saveRules(convertorVO.getConfigVOList());
		}
		if(modules.getImpNoticeFieldVOList()!=null){
			ConvertorVO convertorVO = ImpNoticeConfigConvertor.convertor(modules.getImpNoticeFieldVOList());
			masterErrorMap.put(FieldConstants.impNoticeConfigurator, convertorVO.getMasterErrorList());
			convertModules.setImpNoticeFieldVOList(convertorVO.getConfigVOList());
			ImpNoticeConfigRulesSaver saver = new ImpNoticeConfigRulesSaver();
			saver.saveRules(convertorVO.getConfigVOList());
		}
		if(modules.getAutoFrmsFieldVOList()!=null){
			ConvertorVO convertorVO = FRMSVOToConfigVOConvertor.convertor(modules.getAutoFrmsFieldVOList());
			masterErrorMap.put(FieldConstants.AutoFRMSConfigurator, convertorVO.getMasterErrorList());
			convertModules.setAutoFrmsFieldVOList(convertorVO.getConfigVOList());
			FRMSRulesSaver saver = new FRMSRulesSaver();
			saver.saveRules(convertorVO.getConfigVOList());
		}
		if(modules.getFrmsFieldVOList()!=null){
			ConvertorVO convertorVO = FRMSVOToConfigVOConvertor.convertor(modules.getFrmsFieldVOList());
			masterErrorMap.put(FieldConstants.FRMSConfigurator, convertorVO.getMasterErrorList());
			convertModules.setFrmsFieldVOList(convertorVO.getConfigVOList());
			FRMSRulesSaver saver = new FRMSRulesSaver();
			saver.saveRules(convertorVO.getConfigVOList());
		}
				
		ErrorFileCreator creator = new ErrorFileCreator();
		creator.createErrorFile(masterErrorMap);
		
	}
}
