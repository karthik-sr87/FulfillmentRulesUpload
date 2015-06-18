package com.ebao.aig.sg.fulfillment.rules.upload.rules.saver;

import java.util.Iterator;
import java.util.List;

import javax.transaction.UserTransaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgGstProdReplaceDocCfgDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgGstProdReplaceDocCfg;
import com.ebao.pub.util.Trans;

public class GSTProdDocReplaceRulesSaver {

	private static final Log LOG = LogFactory.getLog(GSTProdDocReplaceRulesSaver.class);
	
	public void saveRules(List ruleList)throws Exception{
		Iterator ruleListItr = ruleList.iterator();
		while(ruleListItr.hasNext()){
			TSgGstProdReplaceDocCfg configVO = (TSgGstProdReplaceDocCfg)ruleListItr.next();
			if(configVO.getErrorList()==null||configVO.getErrorList().isEmpty()){
				LOG.info("Start Save Rule ID : "+configVO.getGstReplaceRuleId());
				saveRule(configVO);
				LOG.info("Finished Processing Rule ID : "+configVO.getGstReplaceRuleId());
			}
		}
	}
	
	public void saveRule(TSgGstProdReplaceDocCfg configVO)throws Exception{
		UserTransaction ut = null;
		try{
			ut = Trans.getUserTransaction();
			ut.begin();
			TSgGstProdReplaceDocCfgDaoFactory.getTSgGstProdReplaceDocCfgDao().create(configVO);
			ut.commit();
		}catch(Exception ex){
			LOG.error("Exception in Saving the GST Prod Doc Replacement rule ID : "+configVO.getGstReplaceRuleId()+" Exception Message : "+ex.getMessage());
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
