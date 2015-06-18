package com.ebao.aig.sg.fulfillment.rules.upload.rules.saver;

import java.util.Iterator;
import java.util.List;

import javax.transaction.UserTransaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgDnmReplaceLetterConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgDnmReplaceLetterConfig;
import com.ebao.pub.util.Trans;

public class DNMReplaceLetterRulesSaver {

	private static final Log LOG = LogFactory.getLog(DNMReplaceLetterRulesSaver.class);
	
	public void saveRules(List ruleList)throws Exception{
		Iterator ruleListItr = ruleList.iterator();
		while(ruleListItr.hasNext()){
			TSgDnmReplaceLetterConfig configVO = (TSgDnmReplaceLetterConfig)ruleListItr.next();
			if(configVO.getErrorList()==null||configVO.getErrorList().isEmpty()){
				LOG.info("Start Save Rule ID : "+configVO.getDnmReplId());
				saveRule(configVO);
				LOG.info("Finished Processing Rule ID : "+configVO.getDnmReplId());
			}
		}
	}
	
	public void saveRule(TSgDnmReplaceLetterConfig configVO)throws Exception{
		UserTransaction ut = null;
		try{
			ut = Trans.getUserTransaction();
			ut.begin();
			TSgDnmReplaceLetterConfigDaoFactory.getTSgDnmReplaceLetterConfigDao().create(configVO);
			ut.commit();
		}catch(Exception ex){
			LOG.error("Exception in Saving the DNM Replace Letter rule ID : "+configVO.getDnmReplId()+" Exception Message : "+ex.getMessage());
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
