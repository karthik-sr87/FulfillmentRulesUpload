package com.ebao.aig.sg.fulfillment.rules.upload.rules.saver;

import java.util.Iterator;
import java.util.List;

import javax.transaction.UserTransaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgProdSmsExcepConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgProdSmsExcepConfig;
import com.ebao.pub.util.Trans;

public class ProdSMSExpRulesSaver {

	private static final Log LOG = LogFactory.getLog(ProdSMSExpRulesSaver.class);
	
	public void saveRules(List ruleList)throws Exception{
		Iterator ruleListItr = ruleList.iterator();
		while(ruleListItr.hasNext()){
			TSgProdSmsExcepConfig configVO = (TSgProdSmsExcepConfig)ruleListItr.next();
			if(configVO.getErrorList()==null||configVO.getErrorList().isEmpty()){
				LOG.info("Start Save Rule ID : "+configVO.getProdSmsExpId());
				saveRule(configVO);
				LOG.info("Finished Processing Rule ID : "+configVO.getProdSmsExpId());
			}
		}
	}
	
	public void saveRule(TSgProdSmsExcepConfig configVO)throws Exception{
		UserTransaction ut = null;
		try{
			ut = Trans.getUserTransaction();
			ut.begin();
			TSgProdSmsExcepConfigDaoFactory.getTSgProdSmsExcepConfigDao().create(configVO);
			ut.commit();
		}catch(Exception ex){
			LOG.error("Exception in Saving Producer SMS Exception Config rule ID : "+configVO.getProdSmsExpId()+" Exception Message : "+ex.getMessage());
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
