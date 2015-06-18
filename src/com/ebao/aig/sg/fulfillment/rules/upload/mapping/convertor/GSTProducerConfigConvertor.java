package com.ebao.aig.sg.fulfillment.rules.upload.mapping.convertor;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.constants.FieldConstants;
import com.ebao.aig.sg.fulfillment.rules.upload.parser.vo.GSTProducerFieldVO;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgGstProducerConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.utility.ValidationUtils;
import com.ebao.foundation.common.lang.StringUtils;

public class GSTProducerConfigConvertor {

	private static final Log LOG = LogFactory.getLog(GSTProducerConfigConvertor.class);
	
	public static ConvertorVO convertor(List fieldVOList)throws Exception{
		ConvertorVO convertorVO = new ConvertorVO();
		List configVOList = new ArrayList();
		List masterErrorList = new ArrayList();
		if(fieldVOList!=null){
			Iterator fieldVOListItr = fieldVOList.iterator();
			while(fieldVOListItr.hasNext()){
				GSTProducerFieldVO fieldVO = (GSTProducerFieldVO)fieldVOListItr.next();
				TSgGstProducerConfig configVO = convert(fieldVO);
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
	
	public static TSgGstProducerConfig convert(GSTProducerFieldVO fieldVO)throws Exception{
		TSgGstProducerConfig configVO = new TSgGstProducerConfig();
		ValidationUtils util = new ValidationUtils(FieldConstants.gstProducerConfigurator);
		if(!util.nullOrEmptyCheck(FieldConstants.gstId, fieldVO.getGstProducerRuleId()))
			configVO.setGstProducerRuleId(Long.parseLong(fieldVO.getGstProducerRuleId()));
		if(!util.nullOrEmptyCheck(FieldConstants.gstProducerCode, fieldVO.getGstProducerCode()))
			configVO.setGstProducerCode(fieldVO.getGstProducerCode());
		String bigProdFlag = util.getIdByDesc(FieldConstants.gstBigProdFlag, fieldVO.getBigProducerFlag());
		if(!StringUtils.isNullOrEmpty(bigProdFlag))
			configVO.setBigProducerFlag(Integer.parseInt(bigProdFlag));
				
		Date effDate = util.convertStringToDate(FieldConstants.effectiveDate, fieldVO.getEffectiveDate());
		configVO.setEffectiveDate(effDate);
				
		Date expDate = util.convertStringToDate(FieldConstants.expiryDate, fieldVO.getExpiryDate());
		configVO.setExpiryDate(expDate);
		configVO.setErrorList(util.getErrorList());
		return configVO;
	}
	
	


}
