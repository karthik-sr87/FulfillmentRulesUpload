package com.ebao.aig.sg.fulfillment.rules.upload.utility;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.codetable.loader.CodeTableLoader;
import com.ebao.aig.sg.fulfillment.rules.upload.validator.ErrorCodeVO;
import com.ebao.foundation.common.config.Env;
import com.ebao.foundation.common.lang.StringUtils;

public class ValidationUtils {

	private static final Log LOG = LogFactory.getLog(ValidationUtils.class);
	
	private String ruleId;
	private String moduleName;
	private SimpleDateFormat sdf = new SimpleDateFormat(Env.getValue("DATE_FORMAT"));
	
	private List errorList = new ArrayList();
	
	public ValidationUtils(String ModuleName){
		this.moduleName = ModuleName;
	}
	
	public boolean nullOrEmptyCheck(String fieldName, String value){
		boolean result = true;
		if(value!=null && value!="" && !value.equalsIgnoreCase("NA"))
			result = false;
		else{
			ErrorCodeVO errorVo = new ErrorCodeVO();
			//errorVo.setRuleId(configVO.getRuleId());
			errorVo.setModuleName(moduleName);
			errorVo.setFieldName(fieldName);
			errorVo.setErrorDesc(fieldName+" field is null");
			errorList.add(errorVo);
		}
		return result;
	}
	
	public boolean isNullOrEmpty(String value){
		boolean result = true;
		if(value!=null && value!="" && !value.equalsIgnoreCase("NA"))
			result = false;
		return result;
	}
	
	public Date convertStringToDate(String fieldName, String value){
		Date result = null;
		try{
		if(!nullOrEmptyCheck(fieldName, value))
			result = sdf.parse(value);
		}catch(Exception ex){
			LOG.error("Unparsable Date : "+ex.getMessage());
			ErrorCodeVO errorVo = new ErrorCodeVO();
			//errorVo.setRuleId(configVO.getRuleId());
			errorVo.setModuleName(moduleName);
			errorVo.setFieldName(fieldName);
			errorVo.setErrorDesc(fieldName+" Invalid Date Format");
			errorList.add(errorVo);
		}
		return result;
	}
	
		
	public String getIdByDesc(String fieldName, String desc)throws Exception{
		String descValue = null;
		if(StringUtils.isNullOrEmpty(desc)){
			ErrorCodeVO errorVo = new ErrorCodeVO();
			//errorVo.setRuleId(configVO.getRuleId());
			errorVo.setModuleName(moduleName);
			errorVo.setFieldName(fieldName);
			errorVo.setErrorDesc(fieldName+" field is null");
			errorList.add(errorVo);
		}else{
			descValue = CodeTableLoader.getCodeTableIdByDesc(fieldName, desc.trim());
			if(StringUtils.isNullOrEmpty(descValue)){
				ErrorCodeVO errorVo = new ErrorCodeVO();
				//errorVo.setRuleId(configVO.getRuleId());
				errorVo.setModuleName(moduleName);
				errorVo.setFieldName(fieldName);
				errorVo.setErrorDesc("Invalid Description for "+fieldName+" field with value : "+desc);
				errorList.add(errorVo);
			}
		}
		return descValue;
	}

	public String getRuleId() {
		return ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public List getErrorList() {
		return errorList;
	}

	public void setErrorList(List errorList) {
		this.errorList = errorList;
	}
}
