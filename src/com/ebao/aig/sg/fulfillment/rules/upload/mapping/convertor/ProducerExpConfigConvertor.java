package com.ebao.aig.sg.fulfillment.rules.upload.mapping.convertor;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.constants.FieldConstants;
import com.ebao.aig.sg.fulfillment.rules.upload.parser.vo.ProducerExceptionFieldVO;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgProducerExceptionConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.utility.ValidationUtils;
import com.ebao.aig.sg.fulfillment.rules.upload.validator.ErrorCodeVO;
import com.ebao.foundation.common.lang.StringUtils;

public class ProducerExpConfigConvertor {

	private static final Log LOG = LogFactory.getLog(ProducerExpConfigConvertor.class);
	
	public static ConvertorVO convertor(List fieldVOList)throws Exception{
		ConvertorVO convertorVO = new ConvertorVO();
		List configVOList = new ArrayList();
		List masterErrorList = new ArrayList();
		if(fieldVOList!=null){
			Iterator fieldVOListItr = fieldVOList.iterator();
			while(fieldVOListItr.hasNext()){
				ProducerExceptionFieldVO fieldVO = (ProducerExceptionFieldVO)fieldVOListItr.next();
				TSgProducerExceptionConfig configVO = convert(fieldVO);
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
	
	public static TSgProducerExceptionConfig convert(ProducerExceptionFieldVO fieldVO)throws Exception{
		TSgProducerExceptionConfig configVO = new TSgProducerExceptionConfig();
		ValidationUtils util = new ValidationUtils(FieldConstants.prodExpConfigurator);
		try{
			if(!util.nullOrEmptyCheck(FieldConstants.prodExpRuleId, fieldVO.getPdcrExcpRuleId())){
				configVO.setPdcrExcpRuleId(Long.parseLong(fieldVO.getPdcrExcpRuleId()));
				util.setRuleId(fieldVO.getPdcrExcpRuleId());
			}
			String lob = util.getIdByDesc(FieldConstants.Lob, fieldVO.getLobId());
			if(!StringUtils.isNullOrEmpty(lob))
				configVO.setLobId(Long.parseLong(lob));
			if(!util.nullOrEmptyCheck(FieldConstants.prodCodeFrom, fieldVO.getPdcrCodeFrom()))
				configVO.setPdcrCodeFrom(fieldVO.getPdcrCodeFrom());
			if(!util.nullOrEmptyCheck(FieldConstants.prodCodeTo, fieldVO.getPdcrCodeTo()))
				configVO.setPdcrCodeTo(fieldVO.getPdcrCodeTo());
			if(!util.isNullOrEmpty(fieldVO.getExcludePdcrCode()))
				configVO.setExcludePdcrCode(fieldVO.getExcludePdcrCode());
			if(!util.isNullOrEmpty(fieldVO.getSprsCustEmail())){
				String id = util.getIdByDesc(FieldConstants.sendToProducerViaEmail, fieldVO.getSprsCustEmail());
				if(!util.isNullOrEmpty(id))
					configVO.setSprsCustEmail(Integer.parseInt(id));
			}
			if(!util.isNullOrEmpty(fieldVO.getSprsCustOffline())){
				String id = util.getIdByDesc(FieldConstants.sendToProducerViaOffline, fieldVO.getSprsCustOffline());
				if(!util.isNullOrEmpty(id))
					configVO.setSprsCustOffline(Integer.parseInt(id));
			}
			if(!util.isNullOrEmpty(fieldVO.getSprsPdcrOffline())){
				String id = util.getIdByDesc(FieldConstants.supressProdEmailToOffline, fieldVO.getSprsPdcrOffline());
				if(!util.isNullOrEmpty(id))
					configVO.setSprsPdcrOffline(Integer.parseInt(id));
			}
			Date effDate = util.convertStringToDate(FieldConstants.effectiveDate, fieldVO.getEffectiveDate());
			configVO.setEffectiveDate(effDate);
					
			Date expDate = util.convertStringToDate(FieldConstants.expiryDate, fieldVO.getExpiryDate());
			configVO.setExpiryDate(expDate);
		}catch(Exception ex){
			ErrorCodeVO errorVo = new ErrorCodeVO();
			//errorVo.setRuleId(configVO.getRuleId());
			errorVo.setModuleName(FieldConstants.prodExpConfigurator);
			errorVo.setFieldName(FieldConstants.prodExpRuleId);
			errorVo.setErrorDesc(ex.getMessage());
			util.getErrorList().add(errorVo);
		}finally{
			configVO.setErrorList(util.getErrorList());
		}
		return configVO;
	}
	
	
}
