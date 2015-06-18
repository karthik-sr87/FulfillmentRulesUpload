package com.ebao.aig.sg.fulfillment.rules.upload.rules.saver;

import java.util.Iterator;
import java.util.List;

import javax.transaction.UserTransaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgLetterAttributeConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgLetterAttributeConfig;
import com.ebao.pub.util.Trans;

public class LetterAttrConfigRulesSaver {

	private static final Log LOG = LogFactory.getLog(LetterAttrConfigRulesSaver.class);
	
	public void saveRules(List ruleList)throws Exception{
		Iterator ruleListItr = ruleList.iterator();
		while(ruleListItr.hasNext()){
			TSgLetterAttributeConfig configVO = (TSgLetterAttributeConfig)ruleListItr.next();
			if(configVO.getErrorList()==null||configVO.getErrorList().isEmpty()){
				LOG.info("Start Save Rule ID : "+configVO.getLetterAttributeId());
				saveRule(configVO);
				LOG.info("Finished Processing Rule ID : "+configVO.getLetterAttributeId());
			}
		}
	}
	
	public void saveRule(TSgLetterAttributeConfig configVO)throws Exception{
		UserTransaction ut = null;
		try{
			ut = Trans.getUserTransaction();
			ut.begin();
			TSgLetterAttributeConfigDaoFactory.getTSgLetterAttributeConfigDao().create(configVO);
			ut.commit();
		}catch(Exception ex){
			LOG.error("Exception in Saving Letter Attribute Config rule ID : "+configVO.getLetterAttributeId()+" Exception Message : "+ex.getMessage());
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
