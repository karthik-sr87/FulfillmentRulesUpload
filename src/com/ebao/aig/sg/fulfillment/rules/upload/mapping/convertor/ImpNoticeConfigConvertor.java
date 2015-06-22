package com.ebao.aig.sg.fulfillment.rules.upload.mapping.convertor;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ebao.aig.sg.fulfillment.rules.upload.constants.FieldConstants;
import com.ebao.aig.sg.fulfillment.rules.upload.parser.vo.ImpNoticeFieldVO;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgImpNoticeConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgImpNoticeSeqConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.utility.ValidationUtils;
import com.ebao.aig.sg.fulfillment.rules.upload.validator.ErrorCodeVO;
import com.ebao.foundation.common.lang.StringUtils;


public class ImpNoticeConfigConvertor {

	public static ConvertorVO convertor(List fieldVOList)throws Exception{
		ConvertorVO convertorVO = new ConvertorVO();
		List configVOList = new ArrayList();
		List masterErrorList = new ArrayList();
		if(fieldVOList!=null){
			Map configVOMap = new LinkedHashMap();
			Iterator fieldVOListItr = fieldVOList.iterator();
			while(fieldVOListItr.hasNext()){
				ImpNoticeFieldVO fieldVO = (ImpNoticeFieldVO)fieldVOListItr.next();
				configVOMap = convert(configVOMap, fieldVO);
			}
			Iterator configVOMapItr = configVOMap.values().iterator();
			while(configVOMapItr.hasNext()){
				TSgImpNoticeConfig configVO = (TSgImpNoticeConfig)configVOMapItr.next();
				configVOList.add(configVO);
				List errorList = configVO.getErrorList();
				if(errorList!=null && !errorList.isEmpty()){
					Iterator errorListItr = errorList.iterator();
					while(errorListItr.hasNext()){
						masterErrorList.add(errorListItr.next());
					}
				}
			}
		}
		convertorVO.setConfigVOList(configVOList);
		convertorVO.setMasterErrorList(masterErrorList);
		return convertorVO;
	}
	
	public static Map convert(Map impNotSeqMap, ImpNoticeFieldVO fieldVO)throws Exception{
		String impNoticeId = fieldVO.getImpNoticeId();
		ValidationUtils util = new ValidationUtils(FieldConstants.impNoticeConfigurator);
		if(!util.nullOrEmptyCheck(FieldConstants.impNoticeId, impNoticeId)){
			TSgImpNoticeConfig configVO = new TSgImpNoticeConfig();
			List seqList = new ArrayList();
			try{
				if(impNotSeqMap.containsKey(impNoticeId)){
					configVO = (TSgImpNoticeConfig)impNotSeqMap.get(impNoticeId);
					if(configVO.getLetterSeqList()!=null)
						seqList = configVO.getLetterSeqList();
				}else{
					configVO.setImpNoticeId(Long.parseLong(impNoticeId));
					String prodSubType = util.getIdByDesc(FieldConstants.prodSubType, fieldVO.getProducerSubType());
					if(!StringUtils.isNullOrEmpty(prodSubType))
						configVO.setProducerSubType(Integer.parseInt(prodSubType));
					String vehicleType = util.getIdByDesc(FieldConstants.VehicleType, fieldVO.getVehicleType());
					if(!StringUtils.isNullOrEmpty(vehicleType))
						configVO.setVehicleType(Integer.parseInt(vehicleType));
					String templateId = util.getIdByDesc(FieldConstants.TemplateName, fieldVO.getTemplateId());
					if(!StringUtils.isNullOrEmpty(templateId))
						configVO.setTemplateId(Long.parseLong(templateId));
					Date effDate = util.convertStringToDate(FieldConstants.effectiveDate, fieldVO.getEffectiveDate());
					configVO.setEffectiveDate(effDate);
					Date expDate = util.convertStringToDate(FieldConstants.expiryDate, fieldVO.getExpiryDate());
					configVO.setExpiryDate(expDate);
				}
					
					TSgImpNoticeSeqConfig configSeqVO = new TSgImpNoticeSeqConfig();
					configSeqVO.setImpNoticeId(Long.parseLong(impNoticeId));
					String letterId = util.getIdByDesc(FieldConstants.impNotice, fieldVO.getImpNoticeLetterId());
					if(!StringUtils.isNullOrEmpty(letterId))
						configSeqVO.setImpNoticeLetterId(Long.parseLong(letterId));
					if(!util.nullOrEmptyCheck(FieldConstants.impNoticeSeq, fieldVO.getSequenceValue()))
						configSeqVO.setSequenceValue(Integer.parseInt(fieldVO.getSequenceValue()));
					Date insEffDate = util.convertStringToDate(FieldConstants.effectiveDate, fieldVO.getInsertionEffDate());
					configSeqVO.setInsertionEffDate(insEffDate);
					Date insExpDate = util.convertStringToDate(FieldConstants.expiryDate, fieldVO.getInsertionExpDate());
					configSeqVO.setInsertionExpDate(insExpDate);
					seqList.add(configSeqVO);
					configVO.setLetterSeqList(seqList);
				}catch(Exception ex){
					ErrorCodeVO errorVo = new ErrorCodeVO();
					//errorVo.setRuleId(configVO.getRuleId());
					errorVo.setModuleName(FieldConstants.impNoticeConfigurator);
					errorVo.setFieldName(FieldConstants.impNoticeId);
					errorVo.setErrorDesc(ex.getMessage());
					util.getErrorList().add(errorVo);
				}finally{
					configVO.setErrorList(util.getErrorList());
					impNotSeqMap.put(impNoticeId, configVO);
				}
			}
		return impNotSeqMap;
	}
		
}
