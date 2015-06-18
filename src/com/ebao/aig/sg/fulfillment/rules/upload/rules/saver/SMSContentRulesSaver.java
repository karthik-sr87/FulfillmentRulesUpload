package com.ebao.aig.sg.fulfillment.rules.upload.rules.saver;

import java.util.Iterator;
import java.util.List;

import javax.transaction.UserTransaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgSmsContentConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgSmsContentConfig;
import com.ebao.pub.util.Trans;

public class SMSContentRulesSaver {

	private static final Log LOG = LogFactory.getLog(SMSContentRulesSaver.class);
	
	public void saveRules(List ruleList)throws Exception{
		Iterator ruleListItr = ruleList.iterator();
		while(ruleListItr.hasNext()){
			TSgSmsContentConfig configVO = (TSgSmsContentConfig)ruleListItr.next();
			if(configVO.getErrorList()==null||configVO.getErrorList().isEmpty()){
				LOG.info("Start Save Rule ID : "+configVO.getSmsId());
				saveRule(configVO);
				LOG.info("Finished Processing Rule ID : "+configVO.getSmsId());
			}
		}
	}
	
	public void saveRule(TSgSmsContentConfig configVO)throws Exception{
		UserTransaction ut = null;
		try{
			ut = Trans.getUserTransaction();
			ut.begin();
			TSgSmsContentConfigDaoFactory.getTSgSmsContentConfigDao().create(configVO);
			ut.commit();
		}catch(Exception ex){
			LOG.error("Exception in Saving SMS Content Config rule ID : "+configVO.getSmsId()+" Exception Message : "+ex.getMessage());
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
