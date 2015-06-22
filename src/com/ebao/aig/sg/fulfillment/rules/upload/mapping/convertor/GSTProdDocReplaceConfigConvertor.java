package com.ebao.aig.sg.fulfillment.rules.upload.mapping.convertor;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.constants.FieldConstants;
import com.ebao.aig.sg.fulfillment.rules.upload.parser.vo.GSTProdDocReplaceFieldVO;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgGstProdReplaceDocCfg;
import com.ebao.aig.sg.fulfillment.rules.upload.utility.ValidationUtils;
import com.ebao.aig.sg.fulfillment.rules.upload.validator.ErrorCodeVO;
import com.ebao.foundation.common.lang.StringUtils;

public class GSTProdDocReplaceConfigConvertor {

	private static final Log LOG = LogFactory.getLog(GSTProdDocReplaceConfigConvertor.class);
	
	public static ConvertorVO convertor(List fieldVOList)throws Exception{
		ConvertorVO convertorVO = new ConvertorVO();
		List configVOList = new ArrayList();
		List masterErrorList = new ArrayList();
		if(fieldVOList!=null){
			Iterator fieldVOListItr = fieldVOList.iterator();
			while(fieldVOListItr.hasNext()){
				GSTProdDocReplaceFieldVO fieldVO = (GSTProdDocReplaceFieldVO)fieldVOListItr.next();
				TSgGstProdReplaceDocCfg configVO = convert(fieldVO);
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
	
	public static TSgGstProdReplaceDocCfg convert(GSTProdDocReplaceFieldVO fieldVO)throws Exception{
		TSgGstProdReplaceDocCfg configVO = new TSgGstProdReplaceDocCfg();
		ValidationUtils util = new ValidationUtils(FieldConstants.gstDocReplaceConfigurator);
		try{
			if(!util.nullOrEmptyCheck(FieldConstants.gstReplaceRuleId, fieldVO.getGstReplaceRuleId()))
				configVO.setGstReplaceRuleId(Long.parseLong(fieldVO.getGstReplaceRuleId()));
			String originalDocument = util.getIdByDesc(FieldConstants.gstOriginalDoc, fieldVO.getOriginalDocId());
			if(!StringUtils.isNullOrEmpty(originalDocument))
				configVO.setOriginalDocId(Long.parseLong(originalDocument));
			String replaceDocument = util.getIdByDesc(FieldConstants.gstReplaceDoc, fieldVO.getReplacementDocId());
			if(!StringUtils.isNullOrEmpty(replaceDocument))
				configVO.setReplacementDocId(Long.parseLong(replaceDocument));		
			Date effDate = util.convertStringToDate(FieldConstants.effectiveDate, fieldVO.getReplacementEffDate());
			configVO.setReplacementEffDate(effDate);
					
			Date expDate = util.convertStringToDate(FieldConstants.expiryDate, fieldVO.getReplacementExpDate());
			configVO.setReplacementExpDate(expDate);
		}catch(Exception ex){
			ErrorCodeVO errorVo = new ErrorCodeVO();
			//errorVo.setRuleId(configVO.getRuleId());
			errorVo.setModuleName(FieldConstants.gstDocReplaceConfigurator);
			errorVo.setFieldName(FieldConstants.gstReplaceRuleId);
			errorVo.setErrorDesc(ex.getMessage());
			util.getErrorList().add(errorVo);
		}finally{
			configVO.setErrorList(util.getErrorList());
		}
		return configVO;
	}
	
	



}
