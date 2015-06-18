package com.ebao.aig.sg.fulfillment.rules.upload.mapping.convertor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.constants.FieldConstants;
import com.ebao.aig.sg.fulfillment.rules.upload.parser.vo.GSTProducerFieldVO;
import com.ebao.aig.sg.fulfillment.rules.upload.parser.vo.LetterAttributeFieldVO;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgGstProducerConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgLetterAttributeConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.utility.ValidationUtils;
import com.ebao.foundation.common.lang.StringUtils;

public class LetterAttributeConfigConvertor {

	private static final Log LOG = LogFactory.getLog(LetterAttributeConfigConvertor.class);
	
	public static ConvertorVO convertor(List fieldVOList)throws Exception{
		ConvertorVO convertorVO = new ConvertorVO();
		List configVOList = new ArrayList();
		List masterErrorList = new ArrayList();
		if(fieldVOList!=null){
			Iterator fieldVOListItr = fieldVOList.iterator();
			while(fieldVOListItr.hasNext()){
				LetterAttributeFieldVO fieldVO = (LetterAttributeFieldVO)fieldVOListItr.next();
				TSgLetterAttributeConfig configVO = convert(fieldVO);
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
	
	public static TSgLetterAttributeConfig convert(LetterAttributeFieldVO fieldVO)throws Exception{
		TSgLetterAttributeConfig configVO = new TSgLetterAttributeConfig();
		ValidationUtils util = new ValidationUtils(FieldConstants.letterAttributeConfigurator);
		if(!util.nullOrEmptyCheck(FieldConstants.letterAttrId, fieldVO.getLetterAttributeId()))
			configVO.setLetterAttributeId(Long.parseLong(fieldVO.getLetterAttributeId()));
		if(!util.nullOrEmptyCheck(FieldConstants.letterRuleId, fieldVO.getLetterId()))
			configVO.setLetterId(Long.parseLong(fieldVO.getLetterId()));
		if(!util.nullOrEmptyCheck(FieldConstants.letterAttrName, fieldVO.getLetterAttributeName()))
			configVO.setLetterAttributeName(fieldVO.getLetterAttributeName());
		String id = util.getIdByDesc(FieldConstants.letterAttrType, fieldVO.getLetterAttributeType());
		if(!StringUtils.isNullOrEmpty(id))
			configVO.setLetterAttributeType(Integer.parseInt(id));
		if(!util.nullOrEmptyCheck(FieldConstants.letterContent, fieldVO.getContent()))
			configVO.setContent(fieldVO.getContent());
		configVO.setErrorList(util.getErrorList());
		return configVO;
	}
	
	


}
