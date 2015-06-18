package com.ebao.aig.sg.fulfillment.rules.upload.rules.saver;

import java.util.Iterator;
import java.util.List;

import javax.transaction.UserTransaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgCustEmailExcepConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgCustEmailExcepConfig;
import com.ebao.pub.util.Trans;

public class CustEmailExpRulesSaver {

	private static final Log LOG = LogFactory.getLog(CustEmailExpRulesSaver.class);
	
	public void saveRules(List ruleList)throws Exception{
		Iterator ruleListItr = ruleList.iterator();
		while(ruleListItr.hasNext()){
			TSgCustEmailExcepConfig configVO = (TSgCustEmailExcepConfig)ruleListItr.next();
			if(configVO.getErrorList()==null||configVO.getErrorList().isEmpty()){
				LOG.info("Start Save Rule ID : "+configVO.getCustEmailExpId());
				saveRule(configVO);
				LOG.info("Finished Processing Rule ID : "+configVO.getCustEmailExpId());
			}
		}
	}
	
	public void saveRule(TSgCustEmailExcepConfig configVO)throws Exception{
		UserTransaction ut = null;
		try{
			ut = Trans.getUserTransaction();
			ut.begin();
			TSgCustEmailExcepConfigDaoFactory.getTSgCustEmailExcepConfigDao().create(configVO);
			ut.commit();
		}catch(Exception ex){
			LOG.error("Exception in Saving the Customer Email Exception rule ID : "+configVO.getCustEmailExpId()+" Exception Message : "+ex.getMessage());
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
