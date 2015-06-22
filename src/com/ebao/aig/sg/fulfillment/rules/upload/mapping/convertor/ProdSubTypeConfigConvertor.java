package com.ebao.aig.sg.fulfillment.rules.upload.mapping.convertor;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.constants.FieldConstants;
import com.ebao.aig.sg.fulfillment.rules.upload.parser.vo.ProdSubTypeConfigFieldVO;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgProducerSubTypeConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.utility.ValidationUtils;
import com.ebao.aig.sg.fulfillment.rules.upload.validator.ErrorCodeVO;
import com.ebao.foundation.common.lang.StringUtils;

public class ProdSubTypeConfigConvertor {


	private static final Log LOG = LogFactory.getLog(ProdSubTypeConfigConvertor.class);
	
	public static ConvertorVO convertor(List fieldVOList)throws Exception{
		ConvertorVO convertorVO = new ConvertorVO();
		List configVOList = new ArrayList();
		List masterErrorList = new ArrayList();
		if(fieldVOList!=null){
			Iterator fieldVOListItr = fieldVOList.iterator();
			while(fieldVOListItr.hasNext()){
				ProdSubTypeConfigFieldVO fieldVO = (ProdSubTypeConfigFieldVO)fieldVOListItr.next();
				TSgProducerSubTypeConfig configVO = convert(fieldVO);
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
	
	public static TSgProducerSubTypeConfig convert(ProdSubTypeConfigFieldVO fieldVO)throws Exception{
		TSgProducerSubTypeConfig configVO = new TSgProducerSubTypeConfig();
		ValidationUtils util = new ValidationUtils(FieldConstants.prodSubTypeConfigurator);
		try{
			if(!util.nullOrEmptyCheck(FieldConstants.prodSubTypeListId, fieldVO.getProducerListId()))
				configVO.setProducerListId(Long.parseLong(fieldVO.getProducerListId()));
			if(!util.nullOrEmptyCheck(FieldConstants.prodCodeFrom, fieldVO.getProducerCodeFrom()))
				configVO.setProducerCodeFrom(fieldVO.getProducerCodeFrom());
			if(!util.nullOrEmptyCheck(FieldConstants.prodCodeTo, fieldVO.getProducerCodeTo()))
				configVO.setProducerCodeTo(fieldVO.getProducerCodeTo());
			String prodSubType = util.getIdByDesc(FieldConstants.prodSubType, fieldVO.getProducerSubType());
			if(!StringUtils.isNullOrEmpty(prodSubType))
				configVO.setProducerSubType(Integer.parseInt(prodSubType));
				
			Date effDate = util.convertStringToDate(FieldConstants.effectiveDate, fieldVO.getEffectiveDate());
			configVO.setEffectiveDate(effDate);
					
			Date expDate = util.convertStringToDate(FieldConstants.expiryDate, fieldVO.getExpiryDate());
			configVO.setExpiryDate(expDate);
		}catch(Exception ex){
			ErrorCodeVO errorVo = new ErrorCodeVO();
			//errorVo.setRuleId(configVO.getRuleId());
			errorVo.setModuleName(FieldConstants.prodSubTypeConfigurator);
			errorVo.setFieldName(FieldConstants.prodSubTypeListId);
			errorVo.setErrorDesc(ex.getMessage());
			util.getErrorList().add(errorVo);
		}finally{
			configVO.setErrorList(util.getErrorList());
		}
		return configVO;
	}
	
	




}
