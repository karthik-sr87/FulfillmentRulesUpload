package com.ebao.aig.sg.fulfillment.rules.upload.rules.saver;

import java.util.Iterator;
import java.util.List;

import javax.transaction.UserTransaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgCustSmsExcepConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgCustSmsExcepConfig;
import com.ebao.pub.util.Trans;

public class CustSMSExpRulesSaver {

	private static final Log LOG = LogFactory.getLog(CustSMSExpRulesSaver.class);
	
	public void saveRules(List ruleList)throws Exception{
		Iterator ruleListItr = ruleList.iterator();
		while(ruleListItr.hasNext()){
			TSgCustSmsExcepConfig configVO = (TSgCustSmsExcepConfig)ruleListItr.next();
			if(configVO.getErrorList()==null||configVO.getErrorList().isEmpty()){
				LOG.info("Start Save Rule ID : "+configVO.getCustSmsExpId());
				saveRule(configVO);
				LOG.info("Finished Processing Rule ID : "+configVO.getCustSmsExpId());
			}
		}
	}
	
	public void saveRule(TSgCustSmsExcepConfig configVO)throws Exception{
		UserTransaction ut = null;
		try{
			ut = Trans.getUserTransaction();
			ut.begin();
			TSgCustSmsExcepConfigDaoFactory.getTSgCustSmsExcepConfigDao().create(configVO);
			ut.commit();
		}catch(Exception ex){
			LOG.error("Exception in Saving the Customer SMS Exception rule ID : "+configVO.getCustSmsExpId()+" Exception Message : "+ex.getMessage());
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
