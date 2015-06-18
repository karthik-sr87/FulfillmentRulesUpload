package com.ebao.aig.sg.fulfillment.rules.upload.rules.saver;

import java.util.Iterator;
import java.util.List;

import javax.transaction.UserTransaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgExtraInsertConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgExtraInsertConfig;
import com.ebao.pub.util.Trans;

public class ExtraInsertConfigRulesSaver {

	private static final Log LOG = LogFactory.getLog(ExtraInsertConfigRulesSaver.class);
	
	public void saveRules(List ruleList)throws Exception{
		Iterator ruleListItr = ruleList.iterator();
		while(ruleListItr.hasNext()){
			TSgExtraInsertConfig configVO = (TSgExtraInsertConfig)ruleListItr.next();
			if(configVO.getErrorList()==null||configVO.getErrorList().isEmpty()){
				LOG.info("Start Save Rule ID : "+configVO.getExtraInsertId());
				saveRule(configVO);
				LOG.info("Finished Processing Rule ID : "+configVO.getExtraInsertId());
			}
		}
	}
	
	public void saveRule(TSgExtraInsertConfig configVO)throws Exception{
		UserTransaction ut = null;
		try{
			ut = Trans.getUserTransaction();
			ut.begin();
			TSgExtraInsertConfigDaoFactory.getTSgExtraInsertConfigDao().create(configVO);
			ut.commit();
		}catch(Exception ex){
			LOG.error("Exception in Saving Extra Insert Config rule ID : "+configVO.getExtraInsertId()+" Exception Message : "+ex.getMessage());
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
