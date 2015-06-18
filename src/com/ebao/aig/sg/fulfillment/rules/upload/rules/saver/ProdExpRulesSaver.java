package com.ebao.aig.sg.fulfillment.rules.upload.rules.saver;

import java.util.Iterator;
import java.util.List;

import javax.transaction.UserTransaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgProducerExceptionConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgProducerExceptionConfig;
import com.ebao.pub.util.Trans;

public class ProdExpRulesSaver {

	private static final Log LOG = LogFactory.getLog(ProdExpRulesSaver.class);
	
	public void saveRules(List ruleList)throws Exception{
		Iterator ruleListItr = ruleList.iterator();
		while(ruleListItr.hasNext()){
			TSgProducerExceptionConfig configVO = (TSgProducerExceptionConfig)ruleListItr.next();
			if(configVO.getErrorList()==null||configVO.getErrorList().isEmpty()){
				LOG.info("Start Save Rule ID : "+configVO.getPdcrExcpRuleId());
				saveRule(configVO);
				LOG.info("Finished Processing Rule ID : "+configVO.getPdcrExcpRuleId());
			}
		}
	}
	
	public void saveRule(TSgProducerExceptionConfig configVO)throws Exception{
		UserTransaction ut = null;
		try{
			ut = Trans.getUserTransaction();
			ut.begin();
			TSgProducerExceptionConfigDaoFactory.getTSgProducerExceptionConfigDao().create(configVO);
			ut.commit();
		}catch(Exception ex){
			LOG.error("Exception in Saving Producer Exception Config rule ID : "+configVO.getPdcrExcpRuleId()+" Exception Message : "+ex.getMessage());
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
