package com.ebao.aig.sg.fulfillment.rules.upload.mapping.convertor;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.constants.FieldConstants;
import com.ebao.aig.sg.fulfillment.rules.upload.parser.vo.ExtraInsertFieldVO;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgExtraInsertConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgExtraInsertDataElement;
import com.ebao.aig.sg.fulfillment.rules.upload.utility.ValidationUtils;
import com.ebao.foundation.common.lang.StringUtils;

public class VoucherConfigConvertor {


	private static final Log LOG = LogFactory.getLog(VoucherConfigConvertor.class);
	
	public static ConvertorVO convertor(List fieldVOList)throws Exception{
		ConvertorVO convertorVO = new ConvertorVO();
		List configVOList = new ArrayList();
		List masterErrorList = new ArrayList();
		if(fieldVOList!=null){
			Map configVOMap = new LinkedHashMap();
			Iterator fieldVOListItr = fieldVOList.iterator();
			while(fieldVOListItr.hasNext()){
				ExtraInsertFieldVO fieldVO = (ExtraInsertFieldVO)fieldVOListItr.next();
				configVOMap = convert(configVOMap, fieldVO);
			}
			Iterator configVOMapItr = configVOMap.values().iterator();
			while(configVOMapItr.hasNext()){
				TSgExtraInsertConfig configVO = (TSgExtraInsertConfig)configVOMapItr.next();
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
	
	public static Map convert(Map extraInsertMap, ExtraInsertFieldVO fieldVO)throws Exception{
		String extraInsId = fieldVO.getExtraInsertId();
		ValidationUtils util = new ValidationUtils(FieldConstants.extraInsConfigurator);
		if(util.nullOrEmptyCheck(FieldConstants.extraInsId, extraInsId)){
			TSgExtraInsertConfig configVO = new TSgExtraInsertConfig();
			List dataElementList = new ArrayList();
			if(extraInsertMap.containsKey(extraInsId)){
				configVO = (TSgExtraInsertConfig) extraInsertMap.get(extraInsId);
				if(configVO.getDataElementList()!=null)
					dataElementList = configVO.getDataElementList();
			}
			else{
				configVO.setExtraInsertId(Long.parseLong(extraInsId));
				if(!util.nullOrEmptyCheck(FieldConstants.extraInsCode, fieldVO.getExtraInsertCode()))
					configVO.setExtraInsertCode(fieldVO.getExtraInsertCode());
				if(!util.nullOrEmptyCheck(FieldConstants.extraInsName, fieldVO.getExtraInsertName()))
					configVO.setExtraInsertName(fieldVO.getExtraInsertName());
				Date effDate = util.convertStringToDate(FieldConstants.effectiveDate, fieldVO.getEffectiveDate());
				configVO.setEffectiveDate(effDate);
				Date expDate = util.convertStringToDate(FieldConstants.expiryDate, fieldVO.getExpiryDate());
				configVO.setExpiryDate(expDate);
			}
				
				TSgExtraInsertDataElement dataElementConfigVO = new TSgExtraInsertDataElement();
				dataElementConfigVO.setExtraInsertId(Long.parseLong(extraInsId));
				String dataElementId = util.getIdByDesc(FieldConstants.dataElementName, fieldVO.getDataElementId());
				if(!StringUtils.isNullOrEmpty(dataElementId))
					dataElementConfigVO.setDataElementId(Long.parseLong(dataElementId));
				dataElementList.add(dataElementConfigVO);
				configVO.setDataElementList(dataElementList);
				configVO.setErrorList(util.getErrorList());
				extraInsertMap.put(extraInsId, configVO);
			}
		return extraInsertMap;
	}

}
