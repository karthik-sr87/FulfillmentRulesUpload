package com.ebao.aig.sg.fulfillment.rules.upload.mapping.convertor;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.constants.FieldConstants;
import com.ebao.aig.sg.fulfillment.rules.upload.parser.vo.CustSMSExpFieldVO;
import com.ebao.aig.sg.fulfillment.rules.upload.parser.vo.DNMReplaceLetterFieldVO;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgCustSmsExcepConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgDnmReplaceLetterConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.utility.ValidationUtils;
import com.ebao.foundation.common.lang.StringUtils;

public class DNMReplacementConfigConvertor {


	private static final Log LOG = LogFactory.getLog(DNMReplacementConfigConvertor.class);
	
	public static ConvertorVO convertor(List fieldVOList)throws Exception{
		ConvertorVO convertorVO = new ConvertorVO();
		List configVOList = new ArrayList();
		List masterErrorList = new ArrayList();
		if(fieldVOList!=null){
			Iterator fieldVOListItr = fieldVOList.iterator();
			while(fieldVOListItr.hasNext()){
				DNMReplaceLetterFieldVO fieldVO = (DNMReplaceLetterFieldVO)fieldVOListItr.next();
				TSgDnmReplaceLetterConfig configVO = convert(fieldVO);
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
	
	public static TSgDnmReplaceLetterConfig convert(DNMReplaceLetterFieldVO fieldVO)throws Exception{
		TSgDnmReplaceLetterConfig configVO = new TSgDnmReplaceLetterConfig();
		ValidationUtils util = new ValidationUtils(FieldConstants.dnmReplaceConfigurator);
		if(!util.nullOrEmptyCheck(FieldConstants.dnmReplaceId, fieldVO.getDnmReplId()))
			configVO.setDnmReplId(Long.parseLong(fieldVO.getDnmReplId()));
		String originalLettter = util.getIdByDesc(FieldConstants.dnmOriginalLetter, fieldVO.getOriginalLetter());
		if(!StringUtils.isNullOrEmpty(originalLettter))
			configVO.setOriginalLetter(Long.parseLong(originalLettter));
		String replaceLettter = util.getIdByDesc(FieldConstants.dnmReplaceLetter, fieldVO.getReplacementLetter());
		if(!StringUtils.isNullOrEmpty(replaceLettter))
			configVO.setReplacementLetter(Long.parseLong(replaceLettter));
		
		Date effDate = util.convertStringToDate(FieldConstants.effectiveDate, fieldVO.getReplacementEffDate());
		configVO.setReplacementEffDate(effDate);
				
		Date expDate = util.convertStringToDate(FieldConstants.expiryDate, fieldVO.getReplacementExpDate());
		configVO.setReplacementExpDate(expDate);
		configVO.setErrorList(util.getErrorList());
		return configVO;
	}
	
	

}
