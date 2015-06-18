package com.ebao.aig.sg.fulfillment.rules.upload.rules.saver;

import java.util.Iterator;
import java.util.List;

import javax.transaction.UserTransaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgAutoSpecConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgAutomaticDelivermodeCfgDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgCampaignMappingConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgCoverTypeSpecConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgDocMappingConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgDocMappingConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgFrmsMasterConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgInsertMappingConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgInsertMappingConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgOfflineConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgPlatformSpecificConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgProducerSpecificConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgSmsEmailMappingConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgVoucherMappingConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgAutoProdCtMapCfg;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgAutoSpecConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgAutomaticDelivermodeCfg;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgCampaignMappingConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgCoverTypeSpecConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgDocMappingConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgFrmsMasterConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgInsertMappingConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgOfflineConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgPlatformSpecificConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgProducerSpecificConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgSmsEmailMappingConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgVoucherMappingConfig;
import com.ebao.pub.util.Trans;

public class FRMSRulesSaver {

	private static final Log LOG = LogFactory.getLog(FRMSRulesSaver.class);
	
	private TSgDocMappingConfigDao docConfigDao = TSgDocMappingConfigDaoFactory.getTSgDocMappingConfigDao();
	private TSgInsertMappingConfigDao insertConfigDao = TSgInsertMappingConfigDaoFactory.getTSgInsertMappingConfigDao();
	private TSgFrmsMasterConfig configVO;
	public void saveRules(List masterRuleList)throws Exception{
		Iterator ruleListItr = masterRuleList.iterator();
		while(ruleListItr.hasNext()){
			TSgFrmsMasterConfig configVO = (TSgFrmsMasterConfig)ruleListItr.next();
			if(configVO.getErrorList()==null||configVO.getErrorList().isEmpty()){
				LOG.info("Start Save Rule ID : "+configVO.getRuleId());
				saveMasterRule(configVO);
				LOG.info("Finished Processing Rule ID : "+configVO.getRuleId());
			}
		}
	}
	
	public void saveMasterRule(TSgFrmsMasterConfig configVO)throws Exception{
		UserTransaction ut = null;
		try{
			ut = Trans.getUserTransaction();
			ut.begin();
			this.configVO = configVO;
			TSgFrmsMasterConfigDaoFactory.getTSgFrmsMasterConfigDao().create(configVO);
			List docMappingList = configVO.getDocMappingList();
			saveDocMappingList(docMappingList);
			savePlatformMappingList(configVO.getPlatformMappingList());
			saveProducerMappingList(configVO.getProducerMappingList());
			saveCoverMappingList(configVO.getCoverTypeMappingList());
			saveAutoMappingList(configVO.getAutoMappingList());
			saveRenewalAutoMappingList(configVO.getRenewalAutoMappingList());
			saveOfflineMappingList(configVO.getOfflineMappingList());
			saveVoucherMappingList(configVO.getVoucherMappingList());
			saveCampaignMappingList(configVO.getCampaignMappingList());
			saveAutoFulfillMappingList(configVO.getAutoFulfillMappingList());
			saveSmsEmailMappingConfig(configVO.getSmsEmailMappingConfig());
			ut.commit();
		}catch(Exception ex){
			LOG.error("Exception in Saving the rule ID : "+configVO.getRuleId()+" Exception Message : "+ex.getMessage());
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
	
	public void saveDocMappingList(List docMappingList) throws Exception{
		Iterator docMappingListItr = docMappingList.iterator();
		while(docMappingListItr.hasNext()){
			TSgDocMappingConfig docVO = (TSgDocMappingConfig)docMappingListItr.next();
			docConfigDao.create(docVO);
		}
	}
	
	public void saveCoverMappingList(List coverMappingList)throws Exception{
		Iterator coverMappingListItr = coverMappingList.iterator();
		while(coverMappingListItr.hasNext()){
			TSgCoverTypeSpecConfig coverTypeVO = (TSgCoverTypeSpecConfig)coverMappingListItr.next();
			Long coverTypeRuleId = TSgCoverTypeSpecConfigDaoFactory.getTSgCoverTypeSpecConfigDao().create(coverTypeVO);
			configVO.getCoverTyepeRuleDescMap().put(coverTypeVO.getDescription(), coverTypeRuleId);
			Iterator coverDocItr = coverTypeVO.getDocumentMappingList().iterator();
			while(coverDocItr.hasNext()){
				TSgDocMappingConfig docVO = (TSgDocMappingConfig)coverDocItr.next();
				docVO.setCoverTypeRuleId(coverTypeRuleId);
				docConfigDao.create(docVO);
			}
		}
	}
	
	public void savePlatformMappingList(List platformMappingList)throws Exception{
		Iterator platformMappingListItr = platformMappingList.iterator();
		while(platformMappingListItr.hasNext()){
			TSgPlatformSpecificConfig platformVO = (TSgPlatformSpecificConfig)platformMappingListItr.next();
			Long platformRuleId= TSgPlatformSpecificConfigDaoFactory.getTSgPlatformSpecificConfigDao().create(platformVO);
			Iterator platformDocItr = platformVO.getDocumentMappingList().iterator();
			while(platformDocItr.hasNext()){
				TSgDocMappingConfig docVO = (TSgDocMappingConfig)platformDocItr.next();
				docVO.setPlatformRuleId(platformRuleId);
				docConfigDao.create(docVO);
			}
		}
	}
	
	public void saveProducerMappingList(List producerMappingList)throws Exception{
		Iterator producerMappingListItr = producerMappingList.iterator();
		while(producerMappingListItr.hasNext()){
			TSgProducerSpecificConfig producerVO = (TSgProducerSpecificConfig)producerMappingListItr.next();
			Long producerRuleId = TSgProducerSpecificConfigDaoFactory.getTSgProducerSpecificConfigDao().create(producerVO);
			configVO.getProducerRuleDescMap().put(producerVO.getDescription(), producerRuleId);
		}
	}
	
	public void saveAutoMappingList(List autoMappingList)throws Exception{
		Iterator autoMappingListItr = autoMappingList.iterator();
		while(autoMappingListItr.hasNext()){
			TSgAutoSpecConfig autoVO = (TSgAutoSpecConfig) autoMappingListItr.next();
			Long autoRuleId = TSgAutoSpecConfigDaoFactory.getTSgAutoSpecConfigDao().create(autoVO);
			configVO.getAutoRuleDescMap().put(autoVO.getAutoRuleDescription(), autoRuleId);
		}
	}
	
	public void saveRenewalAutoMappingList(List renewalAutoMappingList)throws Exception{
		Iterator renewalAutoMappingListItr = renewalAutoMappingList.iterator();
		while(renewalAutoMappingListItr.hasNext()){
			TSgAutoProdCtMapCfg renewalAutoVO = (TSgAutoProdCtMapCfg) renewalAutoMappingListItr.next();
			String coverRuleDesc = renewalAutoVO.getCoverTypeRuleDescription();
			String autoRuleDesc = renewalAutoVO.getAutoRuleDescription();
			String producerRuleDesc = renewalAutoVO.getProducerRuleDescription();
			if(coverRuleDesc!=null)
				renewalAutoVO.setCoverTypeRuleId((Long)configVO.getCoverTyepeRuleDescMap().get(coverRuleDesc));
			else
				renewalAutoVO.setCoverTypeRuleId(new Long(99));
			if(autoRuleDesc!=null)
				renewalAutoVO.setAutoRuleId((Long)configVO.getAutoRuleDescMap().get(autoRuleDesc));
			else
				renewalAutoVO.setAutoRuleId(new Long(99));
			if(producerRuleDesc!=null)
				renewalAutoVO.setProducerRuleId((Long)configVO.getProducerRuleDescMap().get(producerRuleDesc));
			else
				renewalAutoVO.setProducerRuleId(new Long(99));
			//Long autoProducerCtMapId = TSgAutoProdCtMapCfgDaoFactory.getStgAutoProdCtDocMapCfgDao().create(renewalAutoVO);
			Iterator renewalAutoDocItr = renewalAutoVO.getDocumentMappingConfig().iterator();
			while(renewalAutoDocItr.hasNext()){
				TSgDocMappingConfig docVO = (TSgDocMappingConfig)renewalAutoDocItr.next();
				//docVO.setAutoProducerCtMapId(autoProducerCtMapId);
				docConfigDao.create(docVO);
			}
		}
	}
	
	public void saveOfflineMappingList(List offlineMappingList)throws Exception{
		Iterator offlineMappingListItr = offlineMappingList.iterator();
		while(offlineMappingListItr.hasNext()){
			TSgOfflineConfig offlineVO = (TSgOfflineConfig)offlineMappingListItr.next();
			Long offlineRuleId = TSgOfflineConfigDaoFactory.getTSgOfflineConfigDao().create(offlineVO);
			Iterator offlineInsertItr = offlineVO.getExtraInsertList().iterator();
			while(offlineInsertItr.hasNext()){
				TSgInsertMappingConfig extraInsertVO = (TSgInsertMappingConfig)offlineInsertItr.next();
				extraInsertVO.setOfflineRuleId(offlineRuleId);
				insertConfigDao.create(extraInsertVO);
			}
		}
	}
	
	public void saveVoucherMappingList(List voucherMappingList)throws Exception{
		Iterator voucherMappingListItr = voucherMappingList.iterator();
		while(voucherMappingListItr.hasNext()){
			TSgVoucherMappingConfig voucherVO = (TSgVoucherMappingConfig)voucherMappingListItr.next();
			//DaoFactory.create();
			Long voucherRuleId = TSgVoucherMappingConfigDaoFactory.getTSgVoucherMappingConfigDao().create(voucherVO);
			Iterator voucherInsertItr = voucherVO.getExtraInsertList().iterator();
			while(voucherInsertItr.hasNext()){
				TSgInsertMappingConfig extraInsertVO = (TSgInsertMappingConfig)voucherInsertItr.next();
				extraInsertVO.setVoucherRuleId(voucherRuleId);
				insertConfigDao.create(extraInsertVO);
			}
		}
	}
	
	public void saveCampaignMappingList(List campaignMappingList)throws Exception{
		Iterator campaignMappingListItr = campaignMappingList.iterator();
		while(campaignMappingListItr.hasNext()){
			TSgCampaignMappingConfig campaignVO = (TSgCampaignMappingConfig)campaignMappingListItr.next();
			TSgCampaignMappingConfigDaoFactory.getTSgCampaignMappingConfigDao().create(campaignVO);
			Long campaignRuleId = new Long(0);
			Integer attachmentType = campaignVO.getAttachmentType();
			if(attachmentType.intValue()==1){
				TSgDocMappingConfig docVO = campaignVO.getDocumentMappingConfig();
				docVO.setCampaignRuleId(campaignRuleId);
				docConfigDao.create(docVO);
			}else if(attachmentType.intValue()==2){
				TSgInsertMappingConfig extraInsertVO = campaignVO.getInsertMappingConfig();
				extraInsertVO.setCampaignRuleId(campaignRuleId);
				insertConfigDao.create(extraInsertVO);
			}
		}
	}
	
	public void saveAutoFulfillMappingList(List autoFulfillMappingList)throws Exception{
		Iterator autoFulfillMappingListItr = autoFulfillMappingList.iterator();
		while(autoFulfillMappingListItr.hasNext()){
			TSgAutomaticDelivermodeCfg autoFulfillVO = (TSgAutomaticDelivermodeCfg) autoFulfillMappingListItr.next();
			TSgAutomaticDelivermodeCfgDaoFactory.getTSgAutomaticDelivermodeCfgDao().create(autoFulfillVO);
		}
	}
	
	public void saveSmsEmailMappingConfig(TSgSmsEmailMappingConfig smsEmailVO)throws Exception{
		TSgSmsEmailMappingConfigDaoFactory.getTSgSmsEmailMappingConfigDao().create(smsEmailVO);
	}

	public TSgFrmsMasterConfig getConfigVO() {
		return configVO;
	}

	public void setConfigVO(TSgFrmsMasterConfig configVO) {
		this.configVO = configVO;
	}

}
