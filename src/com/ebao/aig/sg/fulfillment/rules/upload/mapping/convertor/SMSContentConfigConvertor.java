package com.ebao.aig.sg.fulfillment.rules.upload.mapping.convertor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.constants.FieldConstants;
import com.ebao.aig.sg.fulfillment.rules.upload.parser.vo.SMSContentFieldVO;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgSmsContentConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.utility.ValidationUtils;
import com.ebao.aig.sg.fulfillment.rules.upload.validator.ErrorCodeVO;
import com.ebao.foundation.common.lang.StringUtils;

public class SMSContentConfigConvertor {


	private static final Log LOG = LogFactory.getLog(SMSContentConfigConvertor.class);
	
	public static ConvertorVO convertor(List fieldVOList)throws Exception{
		ConvertorVO convertorVO = new ConvertorVO();
		List configVOList = new ArrayList();
		List masterErrorList = new ArrayList();
		if(fieldVOList!=null){
			Iterator fieldVOListItr = fieldVOList.iterator();
			while(fieldVOListItr.hasNext()){
				SMSContentFieldVO fieldVO = (SMSContentFieldVO)fieldVOListItr.next();
				TSgSmsContentConfig configVO = convert(fieldVO);
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
	
	public static TSgSmsContentConfig convert(SMSContentFieldVO fieldVO)throws Exception{
		TSgSmsContentConfig configVO = new TSgSmsContentConfig();
		ValidationUtils util = new ValidationUtils(FieldConstants.smsContentConfigurator);
		try{
			if(!util.nullOrEmptyCheck(FieldConstants.smsId, fieldVO.getSmsId()))
				configVO.setSmsId(Long.parseLong(fieldVO.getSmsId()));
			if(!util.nullOrEmptyCheck(FieldConstants.smsCode, fieldVO.getSmsCode()))
				configVO.setSmsCode(fieldVO.getSmsCode());
			if(!util.nullOrEmptyCheck(FieldConstants.smsName, fieldVO.getSmsName()))
				configVO.setSmsName(fieldVO.getSmsName());
			String id = util.getIdByDesc(FieldConstants.smsRecipient, fieldVO.getRecipient());
			if(!StringUtils.isNullOrEmpty(id))
				configVO.setRecipient(Integer.parseInt(id));
			if(!util.nullOrEmptyCheck(FieldConstants.smsContent, fieldVO.getSmsContent()))
				configVO.setSmsContent(fieldVO.getSmsContent());
		}catch(Exception ex){
			ErrorCodeVO errorVo = new ErrorCodeVO();
			//errorVo.setRuleId(configVO.getRuleId());
			errorVo.setModuleName(FieldConstants.smsContentConfigurator);
			errorVo.setFieldName(FieldConstants.smsId);
			errorVo.setErrorDesc(ex.getMessage());
			util.getErrorList().add(errorVo);
		}finally{
			configVO.setErrorList(util.getErrorList());
		}
		return configVO;
	}
	
	



}
