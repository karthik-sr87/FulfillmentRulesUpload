package com.ebao.aig.sg.fulfillment.rules.upload.mapping.convertor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.constants.FieldConstants;
import com.ebao.aig.sg.fulfillment.rules.upload.parser.vo.ProdEmailExpFieldVO;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgProdEmailExcepConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.utility.ValidationUtils;
import com.ebao.foundation.common.lang.StringUtils;

public class ProdEmailExpConfigConvertor {


	private static final Log LOG = LogFactory.getLog(ProdEmailExpConfigConvertor.class);
	
	public static ConvertorVO convertor(List fieldVOList)throws Exception{
		ConvertorVO convertorVO = new ConvertorVO();
		List configVOList = new ArrayList();
		List masterErrorList = new ArrayList();
		if(fieldVOList!=null){
			Iterator fieldVOListItr = fieldVOList.iterator();
			while(fieldVOListItr.hasNext()){
				ProdEmailExpFieldVO fieldVO = (ProdEmailExpFieldVO)fieldVOListItr.next();
				TSgProdEmailExcepConfig configVO = convert(fieldVO);
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
	
	public static TSgProdEmailExcepConfig convert(ProdEmailExpFieldVO fieldVO)throws Exception{
		TSgProdEmailExcepConfig configVO = new TSgProdEmailExcepConfig();
		ValidationUtils util = new ValidationUtils(FieldConstants.prodEmailExpConfigurator);
		String id = fieldVO.getProdEmailExpId();
		if(!util.nullOrEmptyCheck(id, FieldConstants.prodEmailExpId))
			configVO.setProdEmailExpId(Long.parseLong(fieldVO.getProdEmailExpId()));
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
