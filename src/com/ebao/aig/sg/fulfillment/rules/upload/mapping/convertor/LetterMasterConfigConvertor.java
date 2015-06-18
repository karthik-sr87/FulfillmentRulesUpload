package com.ebao.aig.sg.fulfillment.rules.upload.mapping.convertor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.constants.FieldConstants;
import com.ebao.aig.sg.fulfillment.rules.upload.parser.vo.LetterMasterFieldVO;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgLetterMasterConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.utility.ValidationUtils;
import com.ebao.foundation.common.lang.StringUtils;

public class LetterMasterConfigConvertor {


	private static final Log LOG = LogFactory.getLog(LetterMasterConfigConvertor.class);
	
	public static ConvertorVO convertor(List fieldVOList)throws Exception{
		ConvertorVO convertorVO = new ConvertorVO();
		List configVOList = new ArrayList();
		List masterErrorList = new ArrayList();
		if(fieldVOList!=null){
			Iterator fieldVOListItr = fieldVOList.iterator();
			while(fieldVOListItr.hasNext()){
				LetterMasterFieldVO fieldVO = (LetterMasterFieldVO)fieldVOListItr.next();
				TSgLetterMasterConfig configVO = convert(fieldVO);
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
	
	public static TSgLetterMasterConfig convert(LetterMasterFieldVO fieldVO)throws Exception{
		TSgLetterMasterConfig configVO = new TSgLetterMasterConfig();
		ValidationUtils util = new ValidationUtils(FieldConstants.letterMasterConfigurator);
		if(!util.nullOrEmptyCheck(FieldConstants.letterRuleId, fieldVO.getLetterId()))
			configVO.setLetterId(Long.parseLong(fieldVO.getLetterId()));
		if(!util.nullOrEmptyCheck(FieldConstants.letterCode, fieldVO.getLetterCode()))
			configVO.setLetterCode(fieldVO.getLetterCode());
		if(!util.nullOrEmptyCheck(FieldConstants.letterName, fieldVO.getLetterName()))
			configVO.setLetterName(fieldVO.getLetterName());
		String id = util.getIdByDesc(FieldConstants.TemplateName, fieldVO.getTemplateId());
		if(!StringUtils.isNullOrEmpty(id))
			configVO.setTemplateId(Long.parseLong(id));
		configVO.setErrorList(util.getErrorList());
		return configVO;
	}
	
	

}
