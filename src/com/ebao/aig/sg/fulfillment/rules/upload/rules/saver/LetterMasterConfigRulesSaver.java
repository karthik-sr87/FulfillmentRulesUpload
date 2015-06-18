package com.ebao.aig.sg.fulfillment.rules.upload.rules.saver;

import java.util.Iterator;
import java.util.List;

import javax.transaction.UserTransaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgLetterMasterConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgLetterMasterConfig;
import com.ebao.pub.util.Trans;

public class LetterMasterConfigRulesSaver {

	private static final Log LOG = LogFactory.getLog(LetterMasterConfigRulesSaver.class);
	
	public void saveRules(List ruleList)throws Exception{
		Iterator ruleListItr = ruleList.iterator();
		while(ruleListItr.hasNext()){
			TSgLetterMasterConfig configVO = (TSgLetterMasterConfig)ruleListItr.next();
			if(configVO.getErrorList()==null||configVO.getErrorList().isEmpty()){
				LOG.info("Start Save Rule ID : "+configVO.getLetterId());
				saveRule(configVO);
				LOG.info("Finished Processing Rule ID : "+configVO.getLetterId());
			}
		}
	}
	
	public void saveRule(TSgLetterMasterConfig configVO)throws Exception{
		UserTransaction ut = null;
		try{
			ut = Trans.getUserTransaction();
			ut.begin();
			TSgLetterMasterConfigDaoFactory.getTSgLetterMasterConfigDao().create(configVO);
			ut.commit();
		}catch(Exception ex){
			LOG.error("Exception in Saving Letter Master Config rule ID : "+configVO.getLetterId()+" Exception Message : "+ex.getMessage());
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
