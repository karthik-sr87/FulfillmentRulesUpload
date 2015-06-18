package com.ebao.aig.sg.fulfillment.rules.upload.rules.saver;

import java.util.Iterator;
import java.util.List;

import javax.transaction.UserTransaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgEmailContentConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgEmailContentConfig;
import com.ebao.pub.util.Trans;

public class EmailContentRulesSaver {

	private static final Log LOG = LogFactory.getLog(EmailContentRulesSaver.class);
	
	public void saveRules(List ruleList)throws Exception{
		Iterator ruleListItr = ruleList.iterator();
		while(ruleListItr.hasNext()){
			TSgEmailContentConfig configVO = (TSgEmailContentConfig)ruleListItr.next();
			if(configVO.getErrorList()==null||configVO.getErrorList().isEmpty()){
				LOG.info("Start Save Rule ID : "+configVO.getEmailId());
				saveRule(configVO);
				LOG.info("Finished Processing Rule ID : "+configVO.getEmailId());
			}
		}
	}
	
	public void saveRule(TSgEmailContentConfig configVO)throws Exception{
		UserTransaction ut = null;
		try{
			ut = Trans.getUserTransaction();
			ut.begin();
			TSgEmailContentConfigDaoFactory.getTSgEmailContentConfigDao().create(configVO);
			ut.commit();
		}catch(Exception ex){
			LOG.error("Exception in Saving Email Content rule ID : "+configVO.getEmailId()+" Exception Message : "+ex.getMessage());
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
