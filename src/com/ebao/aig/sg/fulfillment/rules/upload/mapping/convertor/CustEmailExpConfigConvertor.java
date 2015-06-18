package com.ebao.aig.sg.fulfillment.rules.upload.mapping.convertor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.constants.FieldConstants;
import com.ebao.aig.sg.fulfillment.rules.upload.parser.vo.CustEmailExpFieldVO;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgCustEmailExcepConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.utility.ValidationUtils;
import com.ebao.foundation.common.lang.StringUtils;

public class CustEmailExpConfigConvertor {
	private static final Log LOG = LogFactory.getLog(CustEmailExpConfigConvertor.class);
	
	public static ConvertorVO convertor(List fieldVOList)throws Exception{
		ConvertorVO convertorVO = new ConvertorVO();
		List configVOList = new ArrayList();
		List masterErrorList = new ArrayList();
		if(fieldVOList!=null){
			Iterator fieldVOListItr = fieldVOList.iterator();
			while(fieldVOListItr.hasNext()){
				CustEmailExpFieldVO fieldVO = (CustEmailExpFieldVO)fieldVOListItr.next();
				TSgCustEmailExcepConfig configVO = convert(fieldVO);
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
	
	public static TSgCustEmailExcepConfig convert(CustEmailExpFieldVO fieldVO)throws Exception{
		ValidationUtils util = new ValidationUtils(FieldConstants.custEmailExpConfigurator);
		TSgCustEmailExcepConfig configVO = new TSgCustEmailExcepConfig();
		String id = fieldVO.getCustEmailExpId();
		if(!util.nullOrEmptyCheck(id, FieldConstants.custEmailExpId))
			configVO.setCustEmailExpId(Long.parseLong(fieldVO.getCustEmailExpId()));
		String lob = util.getIdByDesc(fieldVO.getLobCode(), FieldConstants.Lob);
		if(!StringUtils.isNullOrEmpty(lob))
			configVO.setLobCode(Long.parseLong(lob));
		String productCode = util.getIdByDesc(fieldVO.getProductCode(), FieldConstants.Product);
		if(!StringUtils.isNullOrEmpty(productCode))
			configVO.setProductCode(productCode);
		String planGroup = util.getIdByDesc(fieldVO.getPlanGroupId(), FieldConstants.PlanGroup);
		if(!StringUtils.isNullOrEmpty(planGroup))
			configVO.setPlanGroupId(Long.parseLong(planGroup));
		String plan = util.getIdByDesc(fieldVO.getPlans(), FieldConstants.Plan);
		if(!StringUtils.isNullOrEmpty(plan))
			configVO.setPlans(Long.parseLong(plan));
		if(!StringUtils.isNullOrEmpty(fieldVO.getProducerType())){
			configVO.setProducerType(Long.parseLong(fieldVO.getProducerType()));
		}
		if(!StringUtils.isNullOrEmpty(fieldVO.getProducerCodeFrom()))
			configVO.setProducerCodeFrom(fieldVO.getProducerCodeFrom());
		if(!StringUtils.isNullOrEmpty(fieldVO.getProducerCodeTo()))
			configVO.setProducerCodeTo(fieldVO.getProducerCodeTo());
		if(!StringUtils.isNullOrEmpty(fieldVO.getProducersExcluded()))
			configVO.setProducersExcluded(fieldVO.getProducersExcluded());
		configVO.setErrorList(util.getErrorList());
		return configVO;
	}
	
	
}
