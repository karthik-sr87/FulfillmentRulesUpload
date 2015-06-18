package com.ebao.aig.sg.fulfillment.rules.upload.mapping.convertor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.constants.FieldConstants;
import com.ebao.aig.sg.fulfillment.rules.upload.parser.vo.DNMReplaceLetterFieldVO;
import com.ebao.aig.sg.fulfillment.rules.upload.parser.vo.EmailContentFieldVO;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgDnmReplaceLetterConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgEmailContentConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.utility.ValidationUtils;
import com.ebao.foundation.common.lang.StringUtils;

public class EmailContentConfigConvertor {

	private static final Log LOG = LogFactory.getLog(EmailContentConfigConvertor.class);
		
	public static ConvertorVO convertor(List fieldVOList)throws Exception{
		ConvertorVO convertorVO = new ConvertorVO();
		List configVOList = new ArrayList();
		List masterErrorList = new ArrayList();
		if(fieldVOList!=null){
			Iterator fieldVOListItr = fieldVOList.iterator();
			while(fieldVOListItr.hasNext()){
				EmailContentFieldVO fieldVO = (EmailContentFieldVO)fieldVOListItr.next();
				TSgEmailContentConfig configVO = convert(fieldVO);
				configVOList.add(configVO);
				List errorList = configVO.getErrorList();
				if(errorList!=null){
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
	
	public static TSgEmailContentConfig convert(EmailContentFieldVO fieldVO)throws Exception{
		TSgEmailContentConfig configVO = new TSgEmailContentConfig();
		ValidationUtils util = new ValidationUtils(FieldConstants.emailContentConfigurator);
		if(!util.nullOrEmptyCheck(FieldConstants.emailId, fieldVO.getEmailId()))
			configVO.setEmailId(Long.parseLong(fieldVO.getEmailId()));
		if(!util.nullOrEmptyCheck(FieldConstants.emailCode, fieldVO.getEmailCode()))
			configVO.setEmailCode(fieldVO.getEmailCode());
		if(!util.nullOrEmptyCheck(FieldConstants.emailName, fieldVO.getEmailName()))
			configVO.setEmailName(fieldVO.getEmailName());
		String id = util.getIdByDesc(FieldConstants.emailRecipient, fieldVO.getRecipient());
		if(!StringUtils.isNullOrEmpty(id))
			configVO.setRecipient(Integer.parseInt(id));
		if(!util.nullOrEmptyCheck(FieldConstants.emailContent, fieldVO.getEmailContent()))
			configVO.setEmailContent(fieldVO.getEmailContent());
		configVO.setErrorList(util.getErrorList());
		return configVO;
	}
	
	




}
