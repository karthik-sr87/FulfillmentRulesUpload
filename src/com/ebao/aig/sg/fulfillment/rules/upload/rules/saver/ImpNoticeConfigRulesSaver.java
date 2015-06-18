package com.ebao.aig.sg.fulfillment.rules.upload.rules.saver;

import java.util.Iterator;
import java.util.List;

import javax.transaction.UserTransaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgImpNoticeConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgImpNoticeSeqConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgImpNoticeConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgImpNoticeSeqConfig;
import com.ebao.pub.util.Trans;

public class ImpNoticeConfigRulesSaver {

	private static final Log LOG = LogFactory.getLog(ImpNoticeConfigRulesSaver.class);
	
	public void saveRules(List ruleList)throws Exception{
		Iterator ruleListItr = ruleList.iterator();
		while(ruleListItr.hasNext()){
			TSgImpNoticeConfig configVO = (TSgImpNoticeConfig)ruleListItr.next();
			if(configVO.getErrorList()==null||configVO.getErrorList().isEmpty()){
				LOG.info("Start Save Rule ID : "+configVO.getImpNoticeId());
				saveRule(configVO);
				LOG.info("Finished Processing Rule ID : "+configVO.getImpNoticeId());
			}
		}
	}
	
	public void saveRule(TSgImpNoticeConfig configVO)throws Exception{
		UserTransaction ut = null;
		try{
			ut = Trans.getUserTransaction();
			ut.begin();
			TSgImpNoticeConfigDaoFactory.getTSgImpNoticeConfigDao().create(configVO);
			saveImpNoticeSeqConfig(configVO.getLetterSeqList());
			ut.commit();
		}catch(Exception ex){
			LOG.error("Exception in Saving Important Notice Config rule ID : "+configVO.getImpNoticeId()+" Exception Message : "+ex.getMessage());
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
	
	public void saveImpNoticeSeqConfig(List seqList)throws Exception{
		Iterator seqListItr = seqList.iterator();
		while(seqListItr.hasNext()){
			TSgImpNoticeSeqConfig seqConfig = (TSgImpNoticeSeqConfig)seqListItr.next();
			TSgImpNoticeSeqConfigDaoFactory.getTSgImpNoticeSeqConfigDao().create(seqConfig);
		}
	}

}
