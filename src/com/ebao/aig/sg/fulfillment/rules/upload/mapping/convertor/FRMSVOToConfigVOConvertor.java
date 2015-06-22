package com.ebao.aig.sg.fulfillment.rules.upload.mapping.convertor;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.parser.vo.FRMSFieldVO;
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
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgFrmsMasterConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.validator.ErrorCodeVO;
import com.ebao.aig.sg.fulfillment.rules.upload.validator.FRMSRulesValidator;

public class FRMSVOToConfigVOConvertor {

	private static final Log LOG = LogFactory.getLog(FRMSVOToConfigVOConvertor.class);
	
	public static ConvertorVO convertor(List fieldVOList)throws Exception{
		ConvertorVO convertorVO = new ConvertorVO();
		List configVOList = new ArrayList();
		List masterErrorList = new ArrayList();
		Map<String, List> sortedMap = returnSortedMap(fieldVOList);
	    // printSortedMapList(sortedMap);
	    List masterRuleList = translateRulesMap(sortedMap);
	    LOG.info("Master Rule Count : "+masterRuleList.size());
		if(masterRuleList!=null){
			Iterator ruleListItr = masterRuleList.iterator();
			while(ruleListItr.hasNext()){
				StgFrmsMasterConfig configVO = (StgFrmsMasterConfig )ruleListItr.next();
				LOG.info("Start Validating Rule ID : "+configVO.getRuleId());
				FRMSRulesValidator validator = new FRMSRulesValidator();
				validator.setConfigVO(configVO);
				TSgFrmsMasterConfig MasterConfigVO = validator.validateMasterConfigRule();
				configVOList.add(MasterConfigVO);
				List errorList = validator.getErrorList();
				if(errorList!=null && !errorList.isEmpty()){
					Iterator errorListItr = validator.getErrorList().iterator();
					while(errorListItr.hasNext()){
						masterErrorList.add((ErrorCodeVO)errorListItr.next());
					}
				}
				LOG.info("Finished Validating Rule ID : "+configVO.getRuleId());
			}
			
			convertorVO.setConfigVOList(configVOList);
			convertorVO.setMasterErrorList(masterErrorList);
		}
		return convertorVO;
	}
	
	public static Map returnSortedMap(List<FRMSFieldVO> rules){
		  Map<String, List> sortedMap = new LinkedHashMap<String, List>();
	      Iterator itr = rules.iterator();
	      List<FRMSFieldVO> ruleList;
	      while(itr.hasNext()){
	    	  FRMSFieldVO vo = (FRMSFieldVO) itr.next();
	    	  String masterRuleId = vo.getMasterRuleId();
	    	  if(!nullOrEmptyCheck(masterRuleId)){
		    	  if(sortedMap.containsKey(masterRuleId)){
		    		  ruleList = sortedMap.get(masterRuleId);
		    		  ruleList.add(vo);
		    		  sortedMap.put(masterRuleId, ruleList);
		    	  }else{
		    		  ruleList = new ArrayList<FRMSFieldVO>();
		    		  ruleList.add(vo);
		    		  sortedMap.put(masterRuleId, ruleList);
		    	  }
	    	  }
	      }
	      return sortedMap;
	  }
	
	public static List translateRulesMap(Map configMap){
		List masterRuleList = new ArrayList();
		Iterator itr = configMap.entrySet().iterator();
		  while(itr.hasNext()){
			  StgFrmsMasterConfig masterConfigVO = null;
			  List docMappingList = new ArrayList();
			  Map<String, Object> platformMap = new LinkedHashMap<String, Object>();
			  Map<String, Object> coverTypeMap = new LinkedHashMap<String, Object>();
			  List producerMappingList = new ArrayList();
			  List autoMappingList = new ArrayList();
			  Map<String, Object> renewalAutoMap = new LinkedHashMap<String, Object>();
			  Map<String, Object> offlineMap = new LinkedHashMap<String, Object>();
			  Map<String, Object> voucherMap = new LinkedHashMap<String, Object>();
			  List campaignList = new ArrayList();
			  List autoFulfillList = new ArrayList();
			  StgSmsEmailMappingConfig smsEmailConfigVO = new StgSmsEmailMappingConfig();
			  			  
			  Entry entry = (Entry)itr.next();
			  String ruleId = (String)entry.getKey();
			  Long masterRuleId = Long.parseLong(ruleId);
			  LOG.info("Master rule ID :"+ruleId);
			  smsEmailConfigVO.setRuleId(masterRuleId);
			  List ruleList = (List) entry.getValue();
			  Iterator ruleListItr = ruleList.iterator();
			  while(ruleListItr.hasNext()){
				  FRMSFieldVO configVO = (FRMSFieldVO) ruleListItr.next();
				  FRMSVOToConfigVOConvertor.setMasterRuleId(masterRuleId);
				  masterConfigVO = FRMSVOToConfigVOConvertor.convertMasterConfigVO(masterConfigVO, configVO);
				  FRMSVOToConfigVOConvertor.convertDocumentConfigVO(docMappingList, configVO);
				  FRMSVOToConfigVOConvertor.convertPlatformConfigVO(platformMap, configVO);
				  FRMSVOToConfigVOConvertor.convertCoverTypeConfigVO(coverTypeMap, configVO);
				  FRMSVOToConfigVOConvertor.convertProducerConfigVO(producerMappingList, configVO);
				  FRMSVOToConfigVOConvertor.convertAutoConfigVO(autoMappingList, configVO);
				  FRMSVOToConfigVOConvertor.convertRenewalAutoConfigVO(renewalAutoMap, configVO);
				  FRMSVOToConfigVOConvertor.convertOfflineConfigVO(offlineMap, configVO);
				  FRMSVOToConfigVOConvertor.convertVoucherConfigVO(voucherMap, configVO);
				  FRMSVOToConfigVOConvertor.convertCampaignConfigVO(campaignList, configVO);
				  FRMSVOToConfigVOConvertor.convertAutoFulfillConfigVO(autoFulfillList, configVO);
				  FRMSVOToConfigVOConvertor.convertSmsEmailConfigVO(smsEmailConfigVO, configVO);
				}
			  
			  masterConfigVO.setDocMappingList(docMappingList);
			  LOG.info("Document Mapping Count : "+docMappingList.size());
			  if(platformMap.values()!=null){
				  List platformList = new ArrayList();
				  Iterator platformMapItr =  platformMap.values().iterator();
				  while(platformMapItr.hasNext()){
					  platformList.add(platformMapItr.next());
				  }
				  masterConfigVO.setPlatformMappingList(platformList);
				  LOG.info("Platform Mapping Count : "+platformList.size());
			  }
			  if(coverTypeMap.values()!=null){
				  List coverTypeList = new ArrayList();
				  Iterator coverTypeMapItr = coverTypeMap.values().iterator();
				  while(coverTypeMapItr.hasNext()){
					  coverTypeList.add(coverTypeMapItr.next());
				  }
				  masterConfigVO.setCoverTypeMappingList(coverTypeList);
				  LOG.info("Cover Type Mapping Count : "+coverTypeList.size());
			  }
			  masterConfigVO.setProducerMappingList(producerMappingList);
			  LOG.info("Producer Mapping Count : "+producerMappingList.size());
			  masterConfigVO.setAutoMappingList(autoMappingList);
			  LOG.info("Auto Rule Mapping Count : "+autoMappingList.size());
			  if(renewalAutoMap.values()!=null){
				  List renewalAutoList = new ArrayList();
				  Iterator renewalAutoMapItr = renewalAutoMap.values().iterator();
				  while(renewalAutoMapItr.hasNext()){
					  renewalAutoList.add(renewalAutoMapItr.next());
				  }
				  masterConfigVO.setRenewalAutoMappingList(renewalAutoList);
				  LOG.info("Renewal Auto Mapping Count : "+renewalAutoList.size());
			  }
			  if(offlineMap.values()!=null){
				  List offlineList = new ArrayList();
				  Iterator offlineMapItr = offlineMap.values().iterator();
				  while(offlineMapItr.hasNext()){
					  offlineList.add(offlineMapItr.next());
				  }
				  masterConfigVO.setOfflineMappingList(offlineList);
				  LOG.info("Offline Mapping Count : "+offlineList.size());
			  }
			  if(voucherMap.values()!=null){
				  List voucherList = new ArrayList();
				  Iterator voucherMapItr = voucherMap.values().iterator();
				  while(voucherMapItr.hasNext()){
					  voucherList.add(voucherMapItr.next());
				  }
				  masterConfigVO.setVoucherMappingList(voucherList);
				  LOG.info("Voucher Mapping Count : "+voucherList.size());
			  }
			  masterConfigVO.setCampaignMappingList(campaignList);
			  LOG.info("Campaign Mapping Count : "+campaignList.size());
			  masterConfigVO.setAutoFulfillMappingList(autoFulfillList);
			  LOG.info("Automatic Fulfillment Mapping Count : "+autoFulfillList.size());
			  masterConfigVO.setSmsEmailMappingConfig(smsEmailConfigVO);
			  //LOG.info("SMS & Email Mapping Count : "+);
			  masterRuleList.add(masterConfigVO);
		  }
		  return masterRuleList;
	}
	
	public static Long masterRuleId;
	public static StgFrmsMasterConfig convertMasterConfigVO(StgFrmsMasterConfig masterVO, FRMSFieldVO configVO){
		if(masterVO == null){
			masterVO = new StgFrmsMasterConfig();
			masterVO.setRuleId(masterRuleId);
			masterVO.setTransactionType(configVO.getTransactionType());
			masterVO.setDocumentType(configVO.getDocumentType());
			masterVO.setLobId(configVO.getLob());
			masterVO.setProductCode(configVO.getProduct());
			masterVO.setPlanGroupId(configVO.getPlanGroup());
			masterVO.setPlanName(configVO.getPlan());
			masterVO.setPlatformSpcRuleChk(configVO.getPlatformRuleCheck());
			masterVO.setProducerRuleChk(configVO.getProducerRuleCheck());
			masterVO.setDnmChk(configVO.getDnmFlagCheck());
			masterVO.setProducerExpChk(configVO.getProducerExceptionCheck());
			masterVO.setGstProducerChk(configVO.getGstProducerCheck());
			masterVO.setAutoSpcRuleChk(configVO.getAutoRuleCheck());
			masterVO.setCheckCampaign(configVO.getCampaignRuleCheck());
			masterVO.setVoucherAplcbl(configVO.getVoucherRuleCheck());
			masterVO.setCvrTypeRuleAplcbl(configVO.getCovertypeRuleCheck());
			masterVO.setEffectiveDate(parseDate(configVO.getEffectiveDate()));
			masterVO.setExpiryDate(parseDate(configVO.getExpiryDate()));
			masterVO.setRuleDescription(configVO.getRuleDescription());
			masterVO.setStatusId(configVO.getStatus());
		}
		return masterVO;
	}
	
	public static List convertDocumentConfigVO(List docMappingList, FRMSFieldVO configVO){
		 String dmcTemplateName = configVO.getDmcTemplateName();
		  if(!nullOrEmptyCheck(dmcTemplateName)){
			  //Create new instance for dmcConfig and set values
			  StgDocMappingConfig docVO = new StgDocMappingConfig();
			  docVO.setRuleId(masterRuleId);
			  docVO.setTemplateId(dmcTemplateName);
			  docVO.setSequenceNo(returnCheckedValue(configVO.getDmcSequence()));
			  docVO.setDocumentClubType(returnCheckedValue(configVO.getDmcClubType()));
			  docVO.setRecipient(returnCheckedValue(configVO.getDmcRecipient()));
			  docMappingList.add(docVO);
		  }
		  return docMappingList;
	}
	
	public static Map convertPlatformConfigVO(Map platformMap, FRMSFieldVO configVO){
		String platform = configVO.getPlatform();
		String templateName = configVO.getPmcTemplateName();
		  if(!nullOrEmptyCheck(platform)){
			  StgPlatformSpecificConfig platformVO = new StgPlatformSpecificConfig();
			  List docList = new ArrayList();
			  if(platformMap.containsKey(platform)){
				  platformVO = (StgPlatformSpecificConfig)platformMap.get(platform);
				  if(platformVO.getDocumentMappingConfig()!=null)
					  docList = platformVO.getDocumentMappingConfig(); 
			  }else{
	    		  platformVO.setRuleId(masterRuleId);
	    		  platformVO.setPlatform(platform);
			  }
			  if(!nullOrEmptyCheck(templateName)){
				  StgDocMappingConfig docVO = new StgDocMappingConfig();
				  docVO.setRuleId(masterRuleId);
				  docVO.setTemplateId(returnCheckedValue(configVO.getPmcTemplateName()));
				  docVO.setSequenceNo(returnCheckedValue(configVO.getPmcSequence()));
				  docVO.setDocumentClubType(returnCheckedValue(configVO.getPmcClubType()));
				  docVO.setRecipient(returnCheckedValue(configVO.getPmcRecipient()));
				  docList.add(docVO);
				  platformVO.setDocumentMappingConfig(docList);
		    	}
		    	platformMap.put(platform, platformVO);
	    	  }
	    		      		  
	     return platformMap;
	}
	
	public static Map convertCoverTypeConfigVO(Map coverTypeMap, FRMSFieldVO configVO){
		String coverType = configVO.getCoverTypeId();
		String templateName = configVO.getCtmcTemplateName();
		  if(!nullOrEmptyCheck(coverType)){
			  StgCoverTypeSpecConfig coverTypeVO = new StgCoverTypeSpecConfig();
			  List docList = new ArrayList();
			    String coverTypeCondition = configVO.getCoverTypeId()+configVO.getAvailableFlag()+configVO.getDnmFlag();
			    if(coverTypeMap.containsKey(coverTypeCondition)){
			    	coverTypeVO = (StgCoverTypeSpecConfig)coverTypeMap.get(coverTypeCondition);
			    	if(coverTypeVO.getDocumentMappingConfig()!=null)
			    		docList = coverTypeVO.getDocumentMappingConfig();
			    }
			    else{
		    		  coverTypeVO.setRuleId(masterRuleId);
		    		  coverTypeVO.setCoverTypeCode(returnCheckedValue(configVO.getCoverTypeId()));
		    		  coverTypeVO.setAvailableFlag(returnCheckedValue(configVO.getAvailableFlag()));
		    		  coverTypeVO.setDnmFlag(returnCheckedValue(configVO.getDnmFlag()));
		    		  coverTypeVO.setDescription(returnCheckedValue(configVO.getCtmcRuleDescription()));
		    	  }
			    if(!nullOrEmptyCheck(templateName)){
			    		  StgDocMappingConfig docVO = new StgDocMappingConfig();
			    		  docVO.setRuleId(masterRuleId);
			    		  docVO.setTemplateId(returnCheckedValue(configVO.getCtmcTemplateName()));
			    		  docVO.setSequenceNo(returnCheckedValue(configVO.getCtmcSequence()));
			    		  docVO.setDocumentClubType(returnCheckedValue(configVO.getCtmcClubType()));
			    		  docVO.setRecipient(returnCheckedValue(configVO.getCtmcRecipient()));
			    		  docVO.setMarketingLetter(returnCheckedValue(configVO.getCtmcMarketingLetter()));
			    		  docList.add(docVO);
			  }
	    	   coverTypeMap.put(coverTypeCondition, coverTypeVO);
	    	  }
		  return coverTypeMap;
	}
	
	public static List convertProducerConfigVO(List producerLetterList, FRMSFieldVO configVO){
		String producerType = configVO.getPrmcProducerType();
		String producerCodeFrom = configVO.getPrmcProducerCodeFrom();
		if(!nullOrEmptyCheck(producerType)||!nullOrEmptyCheck(producerCodeFrom)){
			StgProducerSpecificConfig producerConfig = new StgProducerSpecificConfig();
			producerConfig.setRuleId(masterRuleId);
			producerConfig.setProducerType(returnCheckedValue(producerType));
			producerConfig.setProducerCodeFrom(returnCheckedValue(producerCodeFrom));
			producerConfig.setProducerCodeTo(returnCheckedValue(configVO.getPrmcProducerCodeTo()));
			producerConfig.setProducersExcluded(returnCheckedValue(configVO.getPrmcProducerExcluded()));
			producerConfig.setLetterId(returnCheckedValue(configVO.getPrmcMarketingLetter()));
			producerConfig.setDescription(returnCheckedValue(configVO.getPrmcRuleDescription()));
			producerLetterList.add(producerConfig);
		}
		return producerLetterList;
	}
	
	public static Map convertRenewalAutoConfigVO(Map renewalAutoMap, FRMSFieldVO configVO){
		String coverRuleDescription = configVO.getCapCoverDescription();
		String autoRuleDescription = configVO.getCapAutoDescription();
		String producerRuleDescription = configVO.getCapProducerDescription();
		String templateName = configVO.getCapTemplateName();
		if(!nullOrEmptyCheck(coverRuleDescription)||!nullOrEmptyCheck(autoRuleDescription)||!nullOrEmptyCheck(producerRuleDescription)){
			StgAutoProdCtDocMapCfg autoRenewalConfig = new StgAutoProdCtDocMapCfg();
			List documentMappingList = new ArrayList();
			String capRuleCondition = coverRuleDescription+autoRuleDescription+producerRuleDescription;
			if(renewalAutoMap.containsKey(capRuleCondition)){
				autoRenewalConfig = (StgAutoProdCtDocMapCfg)renewalAutoMap.get(capRuleCondition);
				if(autoRenewalConfig.getDocumentMappingConfig()!=null)
					documentMappingList = autoRenewalConfig.getDocumentMappingConfig();
			}else{
				autoRenewalConfig.setRuleId(masterRuleId);
				autoRenewalConfig.setCoverTypeRuleDescription(returnCheckedValue(coverRuleDescription));
				autoRenewalConfig.setAutoRuleDescription(returnCheckedValue(autoRuleDescription));
				autoRenewalConfig.setProducerRuleDescription(returnCheckedValue(producerRuleDescription));
			}
				if(!nullOrEmptyCheck(templateName)){
					StgDocMappingConfig docVo = new StgDocMappingConfig();
					docVo.setRuleId(masterRuleId);
					docVo.setTemplateId(returnCheckedValue(configVO.getCapTemplateName()));
					docVo.setSequenceNo(returnCheckedValue(configVO.getCapSequence()));
					docVo.setDocumentClubType(returnCheckedValue(configVO.getCapClubType()));
					docVo.setRecipient(returnCheckedValue(configVO.getCapRecipient()));
					docVo.setMarketingLetter(returnCheckedValue(configVO.getCapMarketingLetter()));
					documentMappingList.add(docVo);
					autoRenewalConfig.setDocumentMappingConfig(documentMappingList);
				}
				renewalAutoMap.put(capRuleCondition, autoRenewalConfig);
			}
		return renewalAutoMap;
	}
		
	
	public static Map convertOfflineConfigVO(Map offlineMap, FRMSFieldVO configVO){
		String docClubType = configVO.getOmcDocClubType();
		String insertName = configVO.getOmcExtraInsertName();
		if(!nullOrEmptyCheck(docClubType)){
			StgOfflineConfig offlineVO = new StgOfflineConfig();
			List insertList = new ArrayList();
			if(offlineMap.containsKey(docClubType)){
				offlineVO = (StgOfflineConfig)offlineMap.get(docClubType);
				if(offlineVO.getExtraInsertList()!=null)
					insertList = offlineVO.getExtraInsertList();
				}else{
					offlineVO.setDocumentClubType(docClubType);
					offlineVO.setRuleId(masterRuleId);
					offlineVO.setColour(returnCheckedValue(configVO.getOmcColour()));
					offlineVO.setEnvelope(returnCheckedValue(configVO.getOmcEnvelope()));
				}
				if(!nullOrEmptyCheck(insertName)){
					StgInsertMappingConfig insertVO = new StgInsertMappingConfig();
					insertVO.setRuleId(masterRuleId);
					insertVO.setInsertName(returnCheckedValue(configVO.getOmcExtraInsertName()));
					insertVO.setSequenceNo(returnCheckedValue(configVO.getOmcExtraInsertSequence()));
					insertVO.setExcludeReFulfillment(returnCheckedValue(configVO.getOmcExcludeRefulfillment()));
					insertList.add(insertVO);
					offlineVO.setExtraInsertList(insertList);
				}
				offlineMap.put(docClubType, offlineVO);
			}
		return offlineMap;
	}
		
	
	
	public static List convertAutoConfigVO(List autoList, FRMSFieldVO configVO){
		String premiumFrom = configVO.getPremiumFrom();
		if(!nullOrEmptyCheck(premiumFrom)){
			StgAutoSpecConfig autoVO = new StgAutoSpecConfig();
			autoVO.setRuleId(masterRuleId);
			autoVO.setVehicleAgeFrom(returnCheckedValue(configVO.getVehicleAgeFrom()));
			autoVO.setVehicleAgeTo(returnCheckedValue(configVO.getVehicleAgeTo()));
			autoVO.setNcdFrom(returnCheckedValue(configVO.getNcdFrom()));
			autoVO.setNcdTo(returnCheckedValue(configVO.getNcdTo()));
			//if(nullOrEmptyCheck(configVO.getPremiumFrom()))
				autoVO.setPremiumFrom(BigDecimal.ZERO);
			//else
				//autoVO.setPremiumFrom(new BigDecimal(configVO.getPremiumFrom()));
			//if(nullOrEmptyCheck(configVO.getPremiumTo()))
				autoVO.setPremiumTo(new BigDecimal("9999999999"));
			//else
				//autoVO.setPremiumTo(new BigDecimal(configVO.getPremiumTo()));
			autoVO.setVehicleType(returnCheckedValue(configVO.getVehicleType()));
			autoVO.setBubbleBoxLetter(returnCheckedValue(configVO.getBubbleBoxText()));
			autoVO.setImprtNoticeFlag(returnCheckedValue(configVO.getImpNoticeFlag()));
			autoVO.setAutoRuleDescription(returnCheckedValue(configVO.getAutoRuleDescription()));
			autoList.add(autoVO);
		}
		return autoList;
	}
	
	public static Map convertVoucherConfigVO(Map voucherMap, FRMSFieldVO configVO){
		String producerType = configVO.getVmcProducerType();
		String producerCodeFrom = configVO.getVmcProducerCodeFrom();
		String voucherName = configVO.getVmcVoucherName();
		if(!nullOrEmptyCheck(producerType)||!nullOrEmptyCheck(producerCodeFrom)){
			StgVoucherMappingConfig voucherVO = new StgVoucherMappingConfig();
			List insertList = new ArrayList();
			String voucherCondition = configVO.getVmcProducerType()+configVO.getVmcProducerCodeFrom()+configVO.getVmcProducerCodeTo();
			if(voucherMap.containsKey(voucherCondition)){
				voucherVO = (StgVoucherMappingConfig)voucherMap.get(voucherCondition);
				if(voucherVO.getExtraInsertList()!=null)
					insertList = voucherVO.getExtraInsertList();
			}else{
				voucherVO.setRuleId(masterRuleId);
				voucherVO.setProducerType(returnCheckedValue(configVO.getVmcProducerType()));
				voucherVO.setProducerCodeFrom(returnCheckedValue(configVO.getVmcProducerCodeFrom()));
				voucherVO.setProducerCodeTo(returnCheckedValue(configVO.getVmcProducerCodeTo()));
				voucherVO.setProducerExcluded(returnCheckedValue(configVO.getVmcProducerExcluded()));
			}
			if(!nullOrEmptyCheck(voucherName)){
				StgInsertMappingConfig insertVO = new StgInsertMappingConfig();
				insertVO.setRuleId(masterRuleId);
				insertVO.setInsertName(returnCheckedValue(configVO.getVmcVoucherName()));
				insertVO.setSequenceNo(returnCheckedValue(configVO.getVmcVoucherSequence()));
				insertVO.setInsertionEffectiveDate(parseDate(configVO.getVmcInsEffectiveDate()));
				insertVO.setInsertionExpiryDate(parseDate(configVO.getVmcInsExpiryDate()));
				insertVO.setExcludeReFulfillment(returnCheckedValue(configVO.getVmcExcludeRefulfillment()));
				insertList.add(insertVO);
				voucherVO.setExtraInsertList(insertList);
			}
			voucherMap.put(voucherCondition, voucherVO);
		}
		return voucherMap;
	}
	
	public static List convertCampaignConfigVO(List campaignList, FRMSFieldVO configVO){
		String campaignCode = configVO.getCampaignCode();
		String templateName = configVO.getCmcTemplateName();
		String voucherName = configVO.getCmcVoucherName();
		if(!nullOrEmptyCheck(campaignCode)){
			StgCampaignMappingConfig campaignVO = new StgCampaignMappingConfig();
			campaignVO.setRuleId(masterRuleId);
			campaignVO.setCampaignCode(campaignCode);
			
			String attachmentType = configVO.getCmcAttachmentType();
			if(attachmentType.equalsIgnoreCase("document")){
				if(!nullOrEmptyCheck(templateName)){
					StgDocMappingConfig docVO = new StgDocMappingConfig();
					docVO.setRuleId(masterRuleId);
					docVO.setTemplateId(returnCheckedValue(configVO.getCmcTemplateName()));
					docVO.setSequenceNo(returnCheckedValue(configVO.getCmcTemplateSequence()));
					docVO.setDocumentClubType(returnCheckedValue(configVO.getCmcDocClubType()));
					docVO.setRecipient(returnCheckedValue(configVO.getCmcRecipient()));
					campaignVO.setDocumentMappingConfig(docVO);
				}
				
			}else if(attachmentType.equalsIgnoreCase("voucher")){
				if(!nullOrEmptyCheck(voucherName)){
					StgInsertMappingConfig insertVO = new StgInsertMappingConfig();
					insertVO.setRuleId(masterRuleId);
					insertVO.setInsertName(returnCheckedValue(configVO.getCmcVoucherName()));
					insertVO.setSequenceNo(returnCheckedValue(configVO.getCmcVoucherSequence()));
					insertVO.setInsertionEffectiveDate(parseDate(configVO.getCmcInsEffectiveDate()));
					insertVO.setInsertionExpiryDate(parseDate(configVO.getCmcInsExpiryDate()));
					//insertVO.setExcludeReFulfillment((configVO.getcm));
					campaignVO.setInsertMappingConfig(insertVO);
				}
			}
			campaignVO.setAttachmentType(returnCheckedValue(attachmentType));
			campaignList.add(campaignVO);		
		}
		return campaignList;
	}
	
	public static List convertAutoFulfillConfigVO(List autoFulfillList, FRMSFieldVO configVO){
		String docClubType = configVO.getAmcDocClubType();
		if(!nullOrEmptyCheck(docClubType)){
			StgAutomaticDelivermodeCfg autoFulfillVO = new StgAutomaticDelivermodeCfg();
			autoFulfillVO.setDocClubType(docClubType);
			autoFulfillVO.setRuleId(masterRuleId);
			autoFulfillVO.setUserGroup(returnCheckedValue(configVO.getAmcUserGroup()));
			autoFulfillVO.setAutoDeliver(returnCheckedValue(configVO.getAmcAutomaticDelivery()));
			autoFulfillVO.setAutoDeliverMode(returnCheckedValue(configVO.getAmcAutoDeliveryMode()));
			autoFulfillList.add(autoFulfillVO);
		}
		return autoFulfillList;
	}
	
	public static StgSmsEmailMappingConfig convertSmsEmailConfigVO(StgSmsEmailMappingConfig smsEmailConfigVO, FRMSFieldVO configVO){
		String cusEmailFlag = configVO.getCusEmailFlag();
		String cusSmsFlag = configVO.getCusSMSFlag();
		String prodEmailFlag = configVO.getProdEmailFlag();
		String prodSmsFlag = configVO.getProdSMSFlag();
		if(!nullOrEmptyCheck(cusSmsFlag)||!nullOrEmptyCheck(cusEmailFlag)||!nullOrEmptyCheck(prodSmsFlag)||!nullOrEmptyCheck(prodEmailFlag)){
			smsEmailConfigVO.setRuleId(masterRuleId);
			smsEmailConfigVO.setCustomerEmailFlag(cusEmailFlag);
			smsEmailConfigVO.setCustomerEmailTemplateId(returnCheckedValue(configVO.getCusEmailTemplate()));
			smsEmailConfigVO.setCustomerSmsFlag(cusSmsFlag);
			smsEmailConfigVO.setCustomerSmsTemplateId(returnCheckedValue(configVO.getCusSMSTemplate()));
			smsEmailConfigVO.setProducerEmailFlag(prodEmailFlag);
			smsEmailConfigVO.setProducerEmailTemplateId(returnCheckedValue(configVO.getProdEmailTemplate()));
			smsEmailConfigVO.setProducerSmsFlag(prodSmsFlag);
			smsEmailConfigVO.setProducerSmsTemplateId(returnCheckedValue(configVO.getProdSMSTemplate()));
		}
		return smsEmailConfigVO;
	}
	
	public static boolean nullOrEmptyCheck(String value){
		boolean result = true;
		if(value!=null && value!="" && !value.equalsIgnoreCase("NA"))
			result = false;
		return result;
	}
	
	public static String returnCheckedValue(String value){
		String result=null;
		value = StringUtils.trim(value);
		if(value!=null && value!="" && !value.equalsIgnoreCase("NA"))
			result = StringUtils.trim(value);
		return result;
	}
	
	public static Date parseDate(String value){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date result = null;
		try{
			result = sdf.parse(value);
		}catch(Exception ex){
			LOG.error("Unable to Parse Date : "+ex.getMessage());
		}
		return result;
	}

	public static Long getMasterRuleId() {
		return masterRuleId;
	}

	public static void setMasterRuleId(Long masterRuleId) {
		FRMSVOToConfigVOConvertor.masterRuleId = masterRuleId;
	}

}
