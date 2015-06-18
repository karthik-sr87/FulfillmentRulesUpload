package com.ebao.aig.sg.fulfillment.rules.upload.rules.saver;

import java.util.Iterator;
import java.util.List;

import javax.transaction.UserTransaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgProdEmailExcepConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgProdEmailExcepConfig;
import com.ebao.pub.util.Trans;

public class ProdEmailExpRulesSaver {

	private static final Log LOG = LogFactory.getLog(ProdEmailExpRulesSaver.class);
	
	public void saveRules(List ruleList)throws Exception{
		Iterator ruleListItr = ruleList.iterator();
		while(ruleListItr.hasNext()){
			TSgProdEmailExcepConfig configVO = (TSgProdEmailExcepConfig)ruleListItr.next();
			if(configVO.getErrorList()==null||configVO.getErrorList().isEmpty()){
				LOG.info("Start Save Rule ID : "+configVO.getProdEmailExpId());
				saveRule(configVO);
				LOG.info("Finished Processing Rule ID : "+configVO.getProdEmailExpId());
			}
		}
	}
	
	public void saveRule(TSgProdEmailExcepConfig configVO)throws Exception{
		UserTransaction ut = null;
		try{
			ut = Trans.getUserTransaction();
			ut.begin();
			TSgProdEmailExcepConfigDaoFactory.getTSgProdEmailExcepConfigDao().create(configVO);
			ut.commit();
		}catch(Exception ex){
			LOG.error("Exception in Saving Producer Email Exp Config rule ID : "+configVO.getProdEmailExpId()+" Exception Message : "+ex.getMessage());
			ex.printStackTrace();
			if(ut!=null){
				try{
					ut.rollback();
				}catch(Exception e){
					LOG.error("Unable to Rollback : "+e.getMessage());
				}
			}
		}
	}
}
