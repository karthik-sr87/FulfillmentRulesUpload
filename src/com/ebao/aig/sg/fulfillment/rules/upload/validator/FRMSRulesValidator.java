package com.ebao.aig.sg.fulfillment.rules.upload.validator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ebao.aig.sg.fulfillment.rules.upload.codetable.loader.CodeTableLoader;
import com.ebao.aig.sg.fulfillment.rules.upload.constants.FieldConstants;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgAutoProdCtDocMapCfg;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgAutoSpecConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgAutomaticDelivermodeCfg;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgCampaignMappingConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgCoverTypeSpecConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgDocMappingConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgFrmsMasterConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgInsertMappingConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgOfflineConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgPlatformSpecificConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgProducerSpecificConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgSmsEmailMappingConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgVoucherMappingConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgAutoProdCtMapCfg;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgAutoSpecConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgAutomaticDelivermodeCfg;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgCampaignMappingConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgCoverTypeSpecConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgDocMappingConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgFrmsMasterConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgInsertMappingConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgOfflineConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgPlatformSpecificConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgProducerSpecificConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgSmsEmailMappingConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgVoucherMappingConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.utility.ValidationUtils;
import com.ebao.foundation.common.lang.StringUtils;

public class FRMSRulesValidator {
	
	private List errorList = new ArrayList();
	private StgFrmsMasterConfig configVO;
	private TSgFrmsMasterConfig masterConfigVO;
	private String moduleName;
	
	public void validateFRMSRules(StgFrmsMasterConfig configVO)throws Exception{
		this.configVO = configVO;
	}
	
	public TSgFrmsMasterConfig validateMasterConfigRule()throws Exception{
		masterConfigVO = new TSgFrmsMasterConfig();
		validateFRMSMasterConfig();
		validateCommonDocList(configVO.getDocMappingList());
		validatePlatformMappingList(configVO.getPlatformMappingList());
		validateProducerMappingList(configVO.getProducerMappingList());
		validateCoverMappingList(configVO.getCoverTypeMappingList());
		validateAutoMappingList(configVO.getAutoMappingList());
		validateRenewalAutoMappingList(configVO.getRenewalAutoMappingList());
		validateOfflineMappingList(configVO.getOfflineMappingList());
		validateVoucherMappingList(configVO.getVoucherMappingList());
		validateCampaignMappingList(configVO.getCampaignMappingList());
		validateAutoFulfillMappingList(configVO.getAutoFulfillMappingList());
		validateSmsEmailMappingConfig(configVO.getSmsEmailMappingConfig());
		masterConfigVO.setErrorList(errorList);
		return masterConfigVO;
	}
	
	public void validateFRMSMasterConfig()throws Exception{
		masterConfigVO.setRuleId(configVO.getRuleId());
		this.setModuleName(FieldConstants.MasterConfigurator);
		String transactionTypeId = getIdByDesc("TransactionType",configVO.getTransactionType());
		if(!StringUtils.isNullOrEmpty(transactionTypeId))
			masterConfigVO.setTransactionType(Integer.parseInt(transactionTypeId));
		String documentTypeId = getIdByDesc("DocumentType", configVO.getDocumentType());
		if(!StringUtils.isNullOrEmpty(documentTypeId))
			masterConfigVO.setDocumentType(Integer.parseInt(documentTypeId));
		String lobId = getIdByDesc("LOB", configVO.getLobId());
		if(!StringUtils.isNullOrEmpty(lobId))
			masterConfigVO.setLobId(lobId);
		String productId = getIdByDesc("Product", configVO.getProductCode());
		if(!StringUtils.isNullOrEmpty(productId))
			masterConfigVO.setProductCode(productId);
		String planGroupId = getIdByDesc("PlanGroup", configVO.getPlanGroupId());
		if(!StringUtils.isNullOrEmpty(planGroupId))
			masterConfigVO.setPlanGroupId(Long.parseLong(planGroupId));
		String planId = getIdByDesc("Plan", configVO.getPlanName());
		if(!StringUtils.isNullOrEmpty(planId))
			masterConfigVO.setPlanName(Long.parseLong(planId));
		String platformSpecificCheck = getIdByDesc("PlatformRuleCheck", configVO.getPlatformSpcRuleChk());
		if(!StringUtils.isNullOrEmpty(platformSpecificCheck))
			masterConfigVO.setPlatformSpcRuleChk(Integer.parseInt(platformSpecificCheck));
		String producerSpecificRuleCheck = getIdByDesc("ProducerRuleCheck", configVO.getProducerRuleChk());
		if(!StringUtils.isNullOrEmpty(producerSpecificRuleCheck))
			masterConfigVO.setProducerRuleChk(Integer.parseInt(producerSpecificRuleCheck));
		String dnmFlagCheck = getIdByDesc("DNMFlagCheck", configVO.getDnmChk());
		if(!StringUtils.isNullOrEmpty(dnmFlagCheck))
			masterConfigVO.setDnmChk(Integer.parseInt(dnmFlagCheck));
		String prodExpCheck = getIdByDesc("ProducerExceptionCheck", configVO.getProducerExpChk());
		if(!StringUtils.isNullOrEmpty(prodExpCheck))
			masterConfigVO.setProducerExpChk(Integer.parseInt(prodExpCheck));
		String gstProdCheck = getIdByDesc("GSTProducerCheck", configVO.getGstProducerChk());
		if(!StringUtils.isNullOrEmpty(gstProdCheck))
			masterConfigVO.setGstProducerChk(Integer.parseInt(gstProdCheck));
		String autoRuleCheck = getIdByDesc("AutoRuleCheck", configVO.getAutoSpcRuleChk());
		if(!StringUtils.isNullOrEmpty(autoRuleCheck))
			masterConfigVO.setAutoSpcRuleChk(Integer.parseInt(autoRuleCheck));
		String campaignRuleCheck = getIdByDesc("CampaignRuleCheck", configVO.getCheckCampaign());
		if(!StringUtils.isNullOrEmpty(campaignRuleCheck))
			masterConfigVO.setCheckCampaign(Integer.parseInt(campaignRuleCheck));
		String voucherRuleCheck = getIdByDesc("VoucherRuleCheck", configVO.getVoucherAplcbl());
		if(!StringUtils.isNullOrEmpty(voucherRuleCheck))
			masterConfigVO.setVoucherAplcbl(Integer.parseInt(voucherRuleCheck));
		String coverTypeRuleCheck = getIdByDesc("CoverTypeRuleCheck", configVO.getCvrTypeRuleAplcbl());
		if(!StringUtils.isNullOrEmpty(coverTypeRuleCheck))
			masterConfigVO.setCvrTypeRuleAplcbl(Integer.parseInt(coverTypeRuleCheck));
		String status = getIdByDesc("MasterRuleStatus", configVO.getStatusId());
		if(!StringUtils.isNullOrEmpty(status))
			masterConfigVO.setStatusId(Integer.parseInt(status));
		if(nullCheck("RuleEffectiveDate",configVO.getEffectiveDate())!=null)
			masterConfigVO.setEffectiveDate(configVO.getEffectiveDate());
		if(nullCheck("RuleExpiryDate",configVO.getExpiryDate())!=null)
			masterConfigVO.setExpiryDate(configVO.getExpiryDate());
	}
	
	public void validateCommonDocList(List docMappingList)throws Exception{
		this.setModuleName(FieldConstants.CommonDocumentConfigurator);
		List docList = validateDocMappingList(docMappingList);
		masterConfigVO.setDocMappingList(docList);
	}
	
	public List validateDocMappingList(List docMappingList) throws Exception{
		Iterator docMappingListItr = docMappingList.iterator();
		List docList = new ArrayList();
		while(docMappingListItr.hasNext()){
			StgDocMappingConfig docVO = (StgDocMappingConfig)docMappingListItr.next();
			TSgDocMappingConfig docConfigVO = new TSgDocMappingConfig();
			docConfigVO.setRuleId(masterConfigVO.getRuleId());
			String templateId = getIdByDesc("TemplateName",docVO.getTemplateId());
			if(!StringUtils.isNullOrEmpty(templateId))
				docConfigVO.setTemplateId(Long.parseLong(templateId));
			String sequence = (String)nullCheck("TemplateSequence",docVO.getSequenceNo());
			if(!StringUtils.isNullOrEmpty(sequence))
				docConfigVO.setSequenceNo(Integer.parseInt(sequence));
			String docClubType = getIdByDesc("DocumentClubType", docVO.getDocumentClubType());
			if(!StringUtils.isNullOrEmpty(docClubType))
				docConfigVO.setDocumentClubType(Integer.parseInt(docClubType));
			String recipient = getIdByDesc("Recipient", docVO.getRecipient());
			if(!StringUtils.isNullOrEmpty(recipient))
				docConfigVO.setRecipient(Integer.parseInt(recipient));
			if(!StringUtils.isNullOrEmpty(docVO.getMarketingLetter())){
				String marketingLetter = getIdByDesc("MarketingLetter", docVO.getMarketingLetter());
				if(!StringUtils.isNullOrEmpty(marketingLetter))
					docConfigVO.setMarketingLetter(Long.parseLong(marketingLetter));
			}
			docList.add(docConfigVO);
		}
		return docList;
	}
	
	public List validateInsertMappingList(List insertMappingList)throws Exception{
		List insertConfigList = new ArrayList();
		Iterator insertMappingListItr = insertMappingList.iterator();
		while(insertMappingListItr.hasNext()){
			StgInsertMappingConfig insertVO = (StgInsertMappingConfig)insertMappingListItr.next();
			TSgInsertMappingConfig insertConfigVO = new TSgInsertMappingConfig();
			insertConfigVO.setRuleId(insertVO.getRuleId());
			String insertName = getIdByDesc("InsertName", insertVO.getInsertName());
			if(!StringUtils.isNullOrEmpty(insertName))
				insertConfigVO.setInsertName(Long.parseLong(insertName));
			String sequence = (String)nullCheck("InsertSequence",insertVO.getSequenceNo());
			if(!StringUtils.isNullOrEmpty(sequence))
				insertConfigVO.setSequenceNo(Integer.parseInt(sequence));
			String excludeRefulfilFlag = getIdByDesc("ExcludeRefulfillFlag", insertVO.getExcludeReFulfillment());
			if(!StringUtils.isNullOrEmpty(excludeRefulfilFlag))
				insertConfigVO.setExcludeReFulfillment(Integer.parseInt(excludeRefulfilFlag));
			if(nullCheck("InsertionEffectiveDate", insertVO.getInsertionEffectiveDate())!=null)
				insertConfigVO.setInsertionEffectiveDate(insertVO.getInsertionEffectiveDate());
			if(nullCheck("InserttionExpiryDate", insertVO.getInsertionExpiryDate())!=null)
				insertConfigVO.setInsertionExpiryDate(insertVO.getInsertionExpiryDate());
			insertConfigList.add(insertConfigVO);
		}
		return insertConfigList;
	}
	
	public List validateVoucherInsertList(List insertMappingList)throws Exception{
		List insertConfigList = new ArrayList();
		Iterator insertMappingListItr = insertMappingList.iterator();
		while(insertMappingListItr.hasNext()){
			StgInsertMappingConfig insertVO = (StgInsertMappingConfig)insertMappingListItr.next();
			TSgInsertMappingConfig insertConfigVO = new TSgInsertMappingConfig();
			insertConfigVO.setRuleId(insertVO.getRuleId());
			String insertName = getIdByDesc("VoucherName", insertVO.getInsertName());
			if(!StringUtils.isNullOrEmpty(insertName))
				insertConfigVO.setInsertName(Long.parseLong(insertName));
			String sequence = (String)nullCheck("VoucherSequence",insertVO.getSequenceNo());
			if(!StringUtils.isNullOrEmpty(sequence))
				insertConfigVO.setSequenceNo(Integer.parseInt(sequence));
			String excludeRefulfilFlag = getIdByDesc("ExcludeRefulfillFlag", insertVO.getExcludeReFulfillment());
			if(!StringUtils.isNullOrEmpty(excludeRefulfilFlag))
				insertConfigVO.setExcludeReFulfillment(Integer.parseInt(excludeRefulfilFlag));
			if(nullCheck("InsertionEffectiveDate", insertVO.getInsertionEffectiveDate())!=null)
				insertConfigVO.setInsertionEffectiveDate(insertVO.getInsertionEffectiveDate());
			if(nullCheck("InserttionExpiryDate", insertVO.getInsertionExpiryDate())!=null)
				insertConfigVO.setInsertionExpiryDate(insertVO.getInsertionExpiryDate());
			insertConfigList.add(insertConfigVO);
		}
		return insertConfigList;
	}
	
	public void validateCoverMappingList(List coverMappingList)throws Exception{
		this.setModuleName(FieldConstants.CoverTypeConfigurator);
		List coverConfigVOList = new ArrayList();
		if(coverMappingList!=null){
			Iterator coverMappingListItr = coverMappingList.iterator();
			while(coverMappingListItr.hasNext()){
				StgCoverTypeSpecConfig stgCoverVO = (StgCoverTypeSpecConfig) coverMappingListItr.next();
				TSgCoverTypeSpecConfig coverConfigVO = new TSgCoverTypeSpecConfig();
				coverConfigVO.setRuleId(coverConfigVO.getRuleId());
				String coverTypeCode = getIdByDesc("CoverTypeCode", stgCoverVO.getCoverTypeCode());
				if(!StringUtils.isNullOrEmpty(coverTypeCode))
					coverConfigVO.setCoverTypeCode(coverTypeCode);
				String availableFlag = getIdByDesc("AvailableFlag", stgCoverVO.getAvailableFlag());
				if(!StringUtils.isNullOrEmpty(availableFlag))
					coverConfigVO.setAvailableFlag(Integer.parseInt(availableFlag));
				String dnmFlag = getIdByDesc("DNMFlag", stgCoverVO.getDnmFlag());
				if(!StringUtils.isNullOrEmpty(dnmFlag))
					coverConfigVO.setDnmFlag(Integer.parseInt(dnmFlag));
				coverConfigVO.setDescription(stgCoverVO.getDescription());
				if(stgCoverVO.getDocumentMappingConfig()!=null){
					List coverDocList = validateDocMappingList(stgCoverVO.getDocumentMappingConfig());
					coverConfigVO.setDocumentMappingList(coverDocList);
				}
				coverConfigVOList.add(coverConfigVO);
			}
		}
		masterConfigVO.setCoverTypeMappingList(coverConfigVOList);
	}
	
	public void validatePlatformMappingList(List platformMappingList)throws Exception{
		this.setModuleName(FieldConstants.PlatformConfigurator);
		List platformConfigVOList = new ArrayList();
		Iterator platformMappingListItr = platformMappingList.iterator();
		while(platformMappingListItr.hasNext()){
			StgPlatformSpecificConfig stgPlatformVO = (StgPlatformSpecificConfig)platformMappingListItr.next();
			TSgPlatformSpecificConfig platformConfigVO = new TSgPlatformSpecificConfig();
			platformConfigVO.setRuleId(stgPlatformVO.getRuleId());
			String platform = getIdByDesc("Platform", stgPlatformVO.getPlatform());
			if(!StringUtils.isNullOrEmpty(platform))
				platformConfigVO.setPlatform(Integer.parseInt(platform));
			List documentMappingList = stgPlatformVO.getDocumentMappingConfig();
			if(documentMappingList!=null){
				List platformDocList = validateDocMappingList(documentMappingList);
				platformConfigVO.setDocumentMappingList(platformDocList);
			}
			platformConfigVOList.add(platformConfigVO);
		}
		masterConfigVO.setPlatformMappingList(platformConfigVOList);
	}
	
	public void validateProducerMappingList(List producerMappingList)throws Exception{
		this.setModuleName(FieldConstants.ProducerConfigurator);
		List producerConfigList = new ArrayList();
		Iterator producerMappingListItr = producerMappingList.iterator();
		while(producerMappingListItr.hasNext()){
			StgProducerSpecificConfig producerVO = (StgProducerSpecificConfig)producerMappingListItr.next();
			TSgProducerSpecificConfig producerConfig = new TSgProducerSpecificConfig();
			producerConfig.setRuleId(producerVO.getRuleId());
			if(!StringUtils.isNullOrEmpty(producerVO.getProducerType())){
				String producerType = getIdByDesc("ProducerType", producerVO.getProducerType());
				if(!StringUtils.isNullOrEmpty(producerType))
					producerConfig.setProducerType(Long.parseLong(producerType));
			}
			producerConfig.setProducerCodeFrom(producerVO.getProducerCodeFrom());
			producerConfig.setProducerCodeTo(producerVO.getProducerCodeTo());
			producerConfig.setProducersExcluded(producerVO.getProducersExcluded());
			if(!StringUtils.isNullOrEmpty(producerVO.getLetterId())){
				String letterId = getIdByDesc("ProducerLetterId", producerVO.getLetterId());
				if(!StringUtils.isNullOrEmpty(letterId))
					producerConfig.setLetterId(Long.parseLong(letterId));
					
			}
			producerConfig.setDescription(producerVO.getDescription());
			producerConfigList.add(producerConfig);
		}
		masterConfigVO.setProducerMappingList(producerConfigList);
	}
	
	public void validateAutoMappingList(List autoMappingList)throws Exception{
		this.setModuleName(FieldConstants.AutoConfigurator);
		List autoConfigVOList = new ArrayList();
		Iterator autoMappingListItr = autoMappingList.iterator();
		while(autoMappingListItr.hasNext()){
			StgAutoSpecConfig autoVO = (StgAutoSpecConfig) autoMappingListItr.next();
			TSgAutoSpecConfig autoConfigVO = new TSgAutoSpecConfig();
			autoConfigVO.setRuleId(autoVO.getRuleId());
			String vehicleAgeFrom = (String)nullCheck("VehicleAgeFrom", autoVO.getVehicleAgeFrom());
			if(!StringUtils.isNullOrEmpty(vehicleAgeFrom))
				autoConfigVO.setVehicleAgeFrom(Integer.parseInt(vehicleAgeFrom));
			String vehicleAgeTo = (String)nullCheck("VehicleAgeTo", autoVO.getVehicleAgeTo());
			if(!StringUtils.isNullOrEmpty(vehicleAgeTo))
				autoConfigVO.setVehicleAgeFrom(Integer.parseInt(vehicleAgeTo));
			String ncdFrom = getIdByDesc("NCDFrom", autoVO.getNcdFrom());
			if(!StringUtils.isNullOrEmpty(ncdFrom))
				autoConfigVO.setNcdFrom(Integer.parseInt(ncdFrom));
			String ncdTo = getIdByDesc("NCDTo", autoVO.getNcdTo());
			if(!StringUtils.isNullOrEmpty(ncdTo))
				autoConfigVO.setNcdTo(Integer.parseInt(ncdTo));
			BigDecimal premiumFrom = (BigDecimal) nullCheck("PremiumFrom", autoVO.getPremiumFrom());
			autoConfigVO.setPremiumFrom(premiumFrom);
			BigDecimal premiumTo = (BigDecimal) nullCheck("PremiumTo", autoVO.getPremiumTo());
			autoConfigVO.setPremiumTo(premiumTo);
			String vehicleType = getIdByDesc("VehicleType", autoVO.getVehicleType());
			if(!StringUtils.isNullOrEmpty(vehicleType))
				autoConfigVO.setVehicleType(Integer.parseInt(vehicleType));
			if(!StringUtils.isNullOrEmpty(autoVO.getBubbleBoxLetter())){
				String bubbleBox = getIdByDesc("BubbleBoxLetter", autoVO.getBubbleBoxLetter());
				if(!StringUtils.isNullOrEmpty(bubbleBox))
					autoConfigVO.setBubbleBoxLetter(Long.parseLong(bubbleBox));
			}
			String impNoticeFlag = getIdByDesc("ImportantNoticeFlag", autoVO.getImprtNoticeFlag());
			if(!StringUtils.isNullOrEmpty(impNoticeFlag))
				autoConfigVO.setImprtNoticeFlag(Integer.parseInt(impNoticeFlag));
			autoConfigVO.setAutoRuleDescription(autoVO.getAutoRuleDescription());
			autoConfigVOList.add(autoConfigVO);
		}
		masterConfigVO.setAutoMappingList(autoConfigVOList);
	}
	
	public void validateRenewalAutoMappingList(List renewalAutoMappingList)throws Exception{
		this.setModuleName(FieldConstants.RenewalAutoConfigurator);
		List renewalAutoConfigList = new ArrayList();
		Iterator renewalAutoMappingListItr = renewalAutoMappingList.iterator();
		while(renewalAutoMappingListItr.hasNext()){
			StgAutoProdCtDocMapCfg renewalAutoVO = (StgAutoProdCtDocMapCfg) renewalAutoMappingListItr.next();
			TSgAutoProdCtMapCfg autoProdCTMapCfg = new TSgAutoProdCtMapCfg();
			autoProdCTMapCfg.setRuleId(renewalAutoVO.getRuleId());
			autoProdCTMapCfg.setAutoRuleDescription(renewalAutoVO.getAutoRuleDescription());
			autoProdCTMapCfg.setCoverTypeRuleDescription(renewalAutoVO.getCoverTypeRuleDescription());
			autoProdCTMapCfg.setProducerRuleDescription(renewalAutoVO.getProducerRuleDescription());
			String coverRuleDesc = renewalAutoVO.getCoverTypeRuleDescription();
			String autoRuleDesc = renewalAutoVO.getAutoRuleDescription();
			String producerRuleDesc = renewalAutoVO.getProducerRuleDescription();
			List docMappingList = renewalAutoVO.getDocumentMappingConfig();
			if(docMappingList!=null){
				List docList = validateDocMappingList(docMappingList);
				autoProdCTMapCfg.setDocumentMappingConfig(docList);
			}
			renewalAutoConfigList.add(autoProdCTMapCfg);
		}
		masterConfigVO.setRenewalAutoMappingList(renewalAutoConfigList);
	}
	
	public void validateOfflineMappingList(List offlineMappingList)throws Exception{
		this.setModuleName(FieldConstants.OfflineConfigurator);
		List offlineConfigVOList = new ArrayList();
		Iterator offlineMappingListItr = offlineMappingList.iterator();
		while(offlineMappingListItr.hasNext()){
			StgOfflineConfig offlineVO = (StgOfflineConfig)offlineMappingListItr.next();
			TSgOfflineConfig offlineConfigVO = new TSgOfflineConfig();
			offlineConfigVO.setRuleId(offlineVO.getRuleId());
			String docClubType = getIdByDesc("OfflineDocumentClubType", offlineVO.getDocumentClubType());
			if(!StringUtils.isNullOrEmpty(docClubType))
				offlineConfigVO.setDocumentClubType(Integer.parseInt(docClubType));
			String envelopeName = getIdByDesc("Envelope", offlineVO.getEnvelope());
			if(!StringUtils.isNullOrEmpty(envelopeName))
				offlineConfigVO.setEnvelope(Integer.parseInt(envelopeName));
			String colour = getIdByDesc("Colour", offlineVO.getColour());
			if(!StringUtils.isNullOrEmpty(colour))
				offlineConfigVO.setColour(Integer.parseInt(colour));
			List insertMappingList = offlineVO.getExtraInsertList();
			if(insertMappingList!=null){
				List extraInsertList = validateInsertMappingList(insertMappingList);
				offlineConfigVO.setExtraInsertList(extraInsertList);
			}
			offlineConfigVOList.add(offlineConfigVO);
		}
		masterConfigVO.setOfflineMappingList(offlineConfigVOList);
	}
	
	public void validateVoucherMappingList(List voucherMappingList)throws Exception{
		this.setModuleName(FieldConstants.VoucherConfigurator);
		List voucherConfigList = new ArrayList();
		Iterator voucherMappingListItr = voucherMappingList.iterator();
		while(voucherMappingListItr.hasNext()){
			StgVoucherMappingConfig voucherVO = (StgVoucherMappingConfig)voucherMappingListItr.next();
			TSgVoucherMappingConfig voucherConfig = new TSgVoucherMappingConfig();
			
			voucherConfig.setRuleId(voucherVO.getRuleId());
			if(!StringUtils.isNullOrEmpty(voucherVO.getProducerType())){
				String producerType = getIdByDesc("ProducerType", voucherVO.getProducerType());
				if(!StringUtils.isNullOrEmpty(producerType))
					voucherConfig.setProducerType(Long.parseLong(producerType));
			}
			voucherConfig.setProducerCodeFrom(voucherVO.getProducerCodeFrom());
			voucherConfig.setProducerCodeTo(voucherVO.getProducerCodeTo());
			voucherConfig.setProducerExcluded(voucherVO.getProducerExcluded());
			List voucherInsertList = voucherVO.getExtraInsertList();
			if(voucherInsertList!=null){
				List voucherInsertConfigList = validateVoucherInsertList(voucherInsertList);
				voucherConfig.setExtraInsertList(voucherInsertConfigList);
			}
			voucherConfigList.add(voucherConfig);
		}
		masterConfigVO.setVoucherMappingList(voucherConfigList);
	}
	
	public void validateCampaignMappingList(List campaignMappingList)throws Exception{
		this.setModuleName(FieldConstants.CampaignConfigurator);
		List campaignConfigList = new ArrayList();
		Iterator campaignMappingListItr = campaignMappingList.iterator();
		while(campaignMappingListItr.hasNext()){
			StgCampaignMappingConfig campaignVO = (StgCampaignMappingConfig)campaignMappingListItr.next();
			TSgCampaignMappingConfig campaignConfig = new TSgCampaignMappingConfig();
			campaignConfig.setRuleId(campaignVO.getRuleId());
			String campaignCode = getIdByDesc("CampaignCode", campaignVO.getCampaignCode());
			if(!StringUtils.isNullOrEmpty(campaignCode))
				campaignConfig.setCampaignCode(campaignCode);
			campaignConfig.setInsertionEffectiveDate(campaignVO.getInsertionEffectiveDate());
			campaignConfig.setInsertionExpiryDate(campaignVO.getInsertionExpiryDate());
			String exludedRefulfillment = getIdByDesc("ExcludeRefulfillFlag", campaignVO.getExcludeReFulfillment());
			if(!StringUtils.isNullOrEmpty(exludedRefulfillment))
				campaignConfig.setExcludeReFulfillment(Integer.parseInt(exludedRefulfillment));
			String stgAttachmentType = campaignVO.getAttachmentType();
			String attachmentType = getIdByDesc("AttachmentType", campaignVO.getAttachmentType());
			if(!StringUtils.isNullOrEmpty(attachmentType))
				campaignConfig.setAttachmentType(Integer.parseInt(attachmentType));
			if(stgAttachmentType.equalsIgnoreCase("Document")){
				StgDocMappingConfig docVO = campaignVO.getDocumentMappingConfig();
				TSgDocMappingConfig docConfigVO = new TSgDocMappingConfig();
				docConfigVO.setRuleId(masterConfigVO.getRuleId());
				String templateId = getIdByDesc("TemplateName",docVO.getTemplateId());
				if(!StringUtils.isNullOrEmpty(templateId))
					docConfigVO.setTemplateId(Long.parseLong(templateId));
				String sequence = (String)nullCheck("TemplateSequence",docVO.getSequenceNo());
				if(!StringUtils.isNullOrEmpty(sequence))
					docConfigVO.setSequenceNo(Integer.parseInt(sequence));
				String docClubType = getIdByDesc("DocumentClubType", docVO.getDocumentClubType());
				if(!StringUtils.isNullOrEmpty(docClubType))
					docConfigVO.setDocumentClubType(Integer.parseInt(docClubType));
				String recipient = getIdByDesc("Recipient", docVO.getRecipient());
				if(!StringUtils.isNullOrEmpty(recipient))
					docConfigVO.setRecipient(Integer.parseInt(recipient));
				if(!StringUtils.isNullOrEmpty(docVO.getMarketingLetter())){
					String marketingLetter = getIdByDesc("MarketingLetter", docVO.getMarketingLetter());
					if(!StringUtils.isNullOrEmpty(marketingLetter))
						docConfigVO.setMarketingLetter(Long.parseLong(marketingLetter));
				}
				campaignConfig.setDocumentMappingConfig(docConfigVO);
			}else if(stgAttachmentType.equalsIgnoreCase("Voucher")){
				StgInsertMappingConfig extraInsertVO = campaignVO.getInsertMappingConfig();
				TSgInsertMappingConfig insertConfigVO = new TSgInsertMappingConfig();
				insertConfigVO.setRuleId(extraInsertVO.getRuleId());
				String insertName = getIdByDesc("InsertName", extraInsertVO.getInsertName());
				if(!StringUtils.isNullOrEmpty(insertName))
					insertConfigVO.setInsertName(Long.parseLong(insertName));
				String sequence = (String)nullCheck("InsertSequence",extraInsertVO.getSequenceNo());
				if(!StringUtils.isNullOrEmpty(sequence))
					insertConfigVO.setSequenceNo(Integer.parseInt(sequence));
				String excludeRefulfilFlag = getIdByDesc("ExcludeRefulfillFlag", extraInsertVO.getExcludeReFulfillment());
				if(!StringUtils.isNullOrEmpty(excludeRefulfilFlag))
					insertConfigVO.setExcludeReFulfillment(Integer.parseInt(excludeRefulfilFlag));
				if(nullCheck("InsertionEffectiveDate", extraInsertVO.getInsertionEffectiveDate())!=null)
					insertConfigVO.setInsertionEffectiveDate(extraInsertVO.getInsertionEffectiveDate());
				if(nullCheck("InserttionExpiryDate", extraInsertVO.getInsertionExpiryDate())!=null)
					insertConfigVO.setInsertionExpiryDate(extraInsertVO.getInsertionExpiryDate());
				campaignConfig.setInsertMappingConfig(insertConfigVO);
			}
			campaignConfigList.add(campaignConfig);
		}
		masterConfigVO.setCampaignMappingList(campaignConfigList);
	}
	
	public void validateAutoFulfillMappingList(List autoFulfillMappingList)throws Exception{
		this.setModuleName(FieldConstants.AutoFulfillConfigurator);
		List autoFulfillConfigList = new ArrayList();
		Iterator autoFulfillMappingListItr = autoFulfillMappingList.iterator();
		while(autoFulfillMappingListItr.hasNext()){
			StgAutomaticDelivermodeCfg autoFulfillVO = (StgAutomaticDelivermodeCfg) autoFulfillMappingListItr.next();
			TSgAutomaticDelivermodeCfg autoFulfillConfig = new TSgAutomaticDelivermodeCfg();
			autoFulfillConfig.setRuleId(autoFulfillVO.getRuleId());
			String docClubType = getIdByDesc("AutoFulfillDocumentClubType", autoFulfillVO.getDocClubType());
			if(!StringUtils.isNullOrEmpty(docClubType))
				autoFulfillConfig.setDocClubType(Integer.parseInt(docClubType));
			String userGroup = getIdByDesc("UserGroup", autoFulfillVO.getUserGroup());
			if(!StringUtils.isNullOrEmpty(userGroup))
				autoFulfillConfig.setUserGroup(Long.parseLong(userGroup));
			String autoDeliver = getIdByDesc("AutoFulfillFlag",autoFulfillVO.getAutoDeliver());
			if(!StringUtils.isNullOrEmpty(autoDeliver))
				autoFulfillConfig.setAutoDeliver(Integer.parseInt(autoDeliver));
			String autoDeliverMode = getIdByDesc("AutoFulfillDeliverMode", autoFulfillVO.getAutoDeliverMode());
			if(!StringUtils.isNullOrEmpty(autoDeliverMode))
				autoFulfillConfig.setAutoDeliverMode(Integer.parseInt(autoDeliverMode));
			autoFulfillConfigList.add(autoFulfillConfig);
		}
		masterConfigVO.setAutoFulfillMappingList(autoFulfillConfigList);
	}
	
	public void validateSmsEmailMappingConfig(StgSmsEmailMappingConfig smsEmailVO)throws Exception{
		this.setModuleName(FieldConstants.SmsEmailMappingConfigurator);
		TSgSmsEmailMappingConfig smsEmailConfig = new TSgSmsEmailMappingConfig();
		smsEmailConfig.setRuleId(smsEmailVO.getRuleId());
		String cusEmailFlag = getIdByDesc("CustomerEmailFlag", smsEmailVO.getCustomerEmailFlag());
		if(!StringUtils.isNullOrEmpty(cusEmailFlag))
			smsEmailConfig.setCustomerEmailFlag(Integer.parseInt(cusEmailFlag));
		String cusEmailTemplate = smsEmailVO.getCustomerEmailTemplateId();
		if(!StringUtils.isNullOrEmpty(cusEmailTemplate)){
			String emailTemplate = getIdByDesc("CustomerEmailTemplate", cusEmailTemplate);
			if(!StringUtils.isNullOrEmpty(emailTemplate))
				smsEmailConfig.setCustomerEmailTemplateId(Long.parseLong(emailTemplate));
		}
		String cusSmsFlag = getIdByDesc("CustomerSmsFlag", smsEmailVO.getCustomerSmsFlag());
		if(!StringUtils.isNullOrEmpty(cusSmsFlag))
			smsEmailConfig.setCustomerSmsFlag(Integer.parseInt(cusSmsFlag));
		String cusSmsTemplate = smsEmailVO.getCustomerSmsTemplateId();
		if(!StringUtils.isNullOrEmpty(cusSmsTemplate)){
			String smsTemplate = getIdByDesc("CustomerSmsTemplate", cusSmsTemplate);
			if(!StringUtils.isNullOrEmpty(smsTemplate))
				smsEmailConfig.setCustomerSmsTemplateId(Long.parseLong(smsTemplate));
		}
		
		String prodEmailFlag = getIdByDesc("ProducerEmailFlag", smsEmailVO.getProducerEmailFlag());
		if(!StringUtils.isNullOrEmpty(prodEmailFlag))
			smsEmailConfig.setProducerEmailFlag(Integer.parseInt(prodEmailFlag));
		String prodEmailTemplate = smsEmailVO.getProducerEmailTemplateId();
		if(!StringUtils.isNullOrEmpty(prodEmailTemplate)){
			String emailTemplate = getIdByDesc("ProducerEmailTemplate", prodEmailTemplate);
			if(!StringUtils.isNullOrEmpty(emailTemplate))
				smsEmailConfig.setProducerEmailTemplateId(Long.parseLong(emailTemplate));
		}
		String prodSmsFlag = getIdByDesc("ProducerSmsFlag", smsEmailVO.getProducerSmsFlag());
		if(!StringUtils.isNullOrEmpty(prodSmsFlag))
			smsEmailConfig.setProducerSmsFlag(Integer.parseInt(prodSmsFlag));
		String prodSmsTemplate = smsEmailVO.getProducerSmsTemplateId();
		if(!StringUtils.isNullOrEmpty(prodSmsTemplate)){
			String smsTemplate = getIdByDesc("ProducerSmsTemplate", prodSmsTemplate);
			if(!StringUtils.isNullOrEmpty(smsTemplate))
				smsEmailConfig.setProducerSmsTemplateId(Long.parseLong(smsTemplate));
		}
		masterConfigVO.setSmsEmailMappingConfig(smsEmailConfig);
	}

	
	public String getIdByDesc(String fieldName, String desc)throws Exception{
		String descValue = null;
		if(StringUtils.isNullOrEmpty(desc)){
			ErrorCodeVO errorVo = new ErrorCodeVO();
			errorVo.setRuleId(configVO.getRuleId());
			errorVo.setModuleName(this.getModuleName());
			errorVo.setFieldName(fieldName);
			errorVo.setErrorDesc(fieldName+" field is null");
			errorList.add(errorVo);
		}else{
			descValue = CodeTableLoader.getCodeTableIdByDesc(fieldName, desc);
			if(StringUtils.isNullOrEmpty(descValue)){
				ErrorCodeVO errorVo = new ErrorCodeVO();
				errorVo.setRuleId(configVO.getRuleId());
				errorVo.setModuleName(this.getModuleName());
				errorVo.setFieldName(fieldName);
				errorVo.setErrorDesc("Invalid Description for "+fieldName+" field with value : "+desc);
				errorList.add(errorVo);
			}
		}
		return descValue;
	}
	
	
	public Object nullCheck(String fieldName, Object value)throws Exception{
		if(value==null){
			ErrorCodeVO errorVo = new ErrorCodeVO();
			errorVo.setRuleId(configVO.getRuleId());
			errorVo.setModuleName(this.getModuleName());
			errorVo.setFieldName(fieldName);
			errorVo.setErrorDesc(fieldName+" field is null");
			errorList.add(errorVo);
		}
		return value;
	}

	public StgFrmsMasterConfig getConfigVO() {
		return configVO;
	}

	public void setConfigVO(StgFrmsMasterConfig configVO) {
		this.configVO = configVO;
	}

	public TSgFrmsMasterConfig getMasterConfigVO() {
		return masterConfigVO;
	}

	public void setMasterConfigVO(TSgFrmsMasterConfig masterConfigVO) {
		this.masterConfigVO = masterConfigVO;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public List getErrorList() {
		return errorList;
	}

	public void setErrorList(List errorList) {
		this.errorList = errorList;
	}
	
	
}
