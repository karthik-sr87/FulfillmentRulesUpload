package com.ebao.aig.sg.fulfillment.rules.upload.rules.saver;

import java.util.Iterator;
import java.util.List;

import javax.transaction.UserTransaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgProducerSubTypeConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgProducerSubTypeConfig;
import com.ebao.pub.util.Trans;

public class ProdSubTypeRulesSaver {

	private static final Log LOG = LogFactory.getLog(ProdSubTypeRulesSaver.class);
	
	public void saveRules(List ruleList)throws Exception{
		Iterator ruleListItr = ruleList.iterator();
		while(ruleListItr.hasNext()){
			TSgProducerSubTypeConfig configVO = (TSgProducerSubTypeConfig)ruleListItr.next();
			if(configVO.getErrorList()==null||configVO.getErrorList().isEmpty()){
				LOG.info("Start Save Rule ID : "+configVO.getProducerListId());
				saveRule(configVO);
				LOG.info("Finished Processing Rule ID : "+configVO.getProducerListId());
			}
		}
	}
	
	public void saveRule(TSgProducerSubTypeConfig configVO)throws Exception{
		UserTransaction ut = null;
		try{
			ut = Trans.getUserTransaction();
			ut.begin();
			TSgProducerSubTypeConfigDaoFactory.getTSgProducerSubTypeConfigDao().create(configVO);
			ut.commit();
		}catch(Exception ex){
			LOG.error("Exception in Saving Producer Sub Type Config rule ID : "+configVO.getProducerListId()+" Exception Message : "+ex.getMessage());
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
