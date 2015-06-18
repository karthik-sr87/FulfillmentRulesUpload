package com.ebao.aig.sg.fulfillment.rules.upload.rules.saver;

import java.util.Iterator;
import java.util.List;

import javax.transaction.UserTransaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.StgAutoProdCtDocMapCfgDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.StgAutoSpecConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.StgAutomaticDelivermodeCfgDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.StgCampaignMappingConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.StgCoverTypeSpecConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.StgDocMappingConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.StgDocMappingConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.StgFrmsMasterConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.StgInsertMappingConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.StgInsertMappingConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.StgOfflineConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.StgPlatformSpecificConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.StgProducerSpecificConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.StgSmsEmailMappingConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.StgVoucherMappingConfigDaoFactory;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgAutoProdCtDocMapCfg;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgAutoSpecConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgAutomaticDelivermodeCfg;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgCampaignMappingConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgCoverTypeSpecConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgDocMappingConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgFrmsMasterConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgInsertMappingConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgOfflineConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgPlatformSpecificConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgProducerSpecificConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgSmsEmailMappingConfig;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgVoucherMappingConfig;
import com.ebao.pub.util.Trans;

public class StgFRMSRulesSaver {

	private static final Log LOG = LogFactory.getLog(StgFRMSRulesSaver.class);
	
	private StgDocMappingConfigDao docConfigDao = StgDocMappingConfigDaoFactory.getStgDocMappingConfigDao();
	private StgInsertMappingConfigDao insertConfigDao = StgInsertMappingConfigDaoFactory.getStgInsertMappingConfigDao();
	private StgFrmsMasterConfig configVO;
	public void saveRules(List masterRuleList)throws Exception{
		Iterator ruleListItr = masterRuleList.iterator();
		while(ruleListItr.hasNext()){
			StgFrmsMasterConfig configVO = (StgFrmsMasterConfig )ruleListItr.next();
			LOG.info("Start Save Rule ID : "+configVO.getRuleId());
			saveMasterRule(configVO);
			LOG.info("Finished Processing Rule ID : "+configVO.getRuleId());
		}
	}
	
	public void saveMasterRule(StgFrmsMasterConfig configVO)throws Exception{
		UserTransaction ut = null;
		try{
			ut = Trans.getUserTransaction();
			ut.begin();
			this.configVO = configVO;
			StgFrmsMasterConfigDaoFactory.getStgFrmsMasterConfigDao().create(configVO);
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
			StgDocMappingConfig docVO = (StgDocMappingConfig)docMappingListItr.next();
			docConfigDao.create(docVO);
		}
	}
	
	public void saveCoverMappingList(List coverMappingList)throws Exception{
		Iterator coverMappingListItr = coverMappingList.iterator();
		while(coverMappingListItr.hasNext()){
			StgCoverTypeSpecConfig coverTypeVO = (StgCoverTypeSpecConfig)coverMappingListItr.next();
			Long coverTypeRuleId = StgCoverTypeSpecConfigDaoFactory.getStgCoverTypeSpecConfigDao().create(coverTypeVO);
			configVO.getCoverTyepeRuleDescMap().put(coverTypeVO.getDescription(), coverTypeRuleId);
			Iterator coverDocItr = coverTypeVO.getDocumentMappingConfig().iterator();
			while(coverDocItr.hasNext()){
				StgDocMappingConfig docVO = (StgDocMappingConfig)coverDocItr.next();
				docVO.setCoverTypeRuleId(coverTypeRuleId);
				docConfigDao.create(docVO);
			}
		}
	}
	
	public void savePlatformMappingList(List platformMappingList)throws Exception{
		Iterator platformMappingListItr = platformMappingList.iterator();
		while(platformMappingListItr.hasNext()){
			StgPlatformSpecificConfig platformVO = (StgPlatformSpecificConfig)platformMappingListItr.next();
			Long platformRuleId= StgPlatformSpecificConfigDaoFactory.getStgPlatformSpecificConfigDao().create(platformVO);
			Iterator platformDocItr = platformVO.getDocumentMappingConfig().iterator();
			while(platformDocItr.hasNext()){
				StgDocMappingConfig docVO = (StgDocMappingConfig)platformDocItr.next();
				docVO.setPlatformRuleId(platformRuleId);
				docConfigDao.create(docVO);
			}
		}
	}
	
	public void saveProducerMappingList(List producerMappingList)throws Exception{
		Iterator producerMappingListItr = producerMappingList.iterator();
		while(producerMappingListItr.hasNext()){
			StgProducerSpecificConfig producerVO = (StgProducerSpecificConfig)producerMappingListItr.next();
			Long producerRuleId = StgProducerSpecificConfigDaoFactory.getStgProducerSpecificConfigDao().create(producerVO);
			configVO.getProducerRuleDescMap().put(producerVO.getDescription(), producerRuleId);
		}
	}
	
	public void saveAutoMappingList(List autoMappingList)throws Exception{
		Iterator autoMappingListItr = autoMappingList.iterator();
		while(autoMappingListItr.hasNext()){
			StgAutoSpecConfig autoVO = (StgAutoSpecConfig) autoMappingListItr.next();
			Long autoRuleId = StgAutoSpecConfigDaoFactory.getStgAutoSpecConfigDao().create(autoVO);
			configVO.getAutoRuleDescMap().put(autoVO.getAutoRuleDescription(), autoRuleId);
		}
	}
	
	public void saveRenewalAutoMappingList(List renewalAutoMappingList)throws Exception{
		Iterator renewalAutoMappingListItr = renewalAutoMappingList.iterator();
		while(renewalAutoMappingListItr.hasNext()){
			StgAutoProdCtDocMapCfg renewalAutoVO = (StgAutoProdCtDocMapCfg) renewalAutoMappingListItr.next();
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
			Long autoProducerCtMapId = StgAutoProdCtDocMapCfgDaoFactory.getStgAutoProdCtDocMapCfgDao().create(renewalAutoVO);
			Iterator renewalAutoDocItr = renewalAutoVO.getDocumentMappingConfig().iterator();
			while(renewalAutoDocItr.hasNext()){
				StgDocMappingConfig docVO = (StgDocMappingConfig)renewalAutoDocItr.next();
				docVO.setAutoProducerCtMapId(autoProducerCtMapId);
				docConfigDao.create(docVO);
			}
		}
	}
	
	public void saveOfflineMappingList(List offlineMappingList)throws Exception{
		Iterator offlineMappingListItr = offlineMappingList.iterator();
		while(offlineMappingListItr.hasNext()){
			StgOfflineConfig offlineVO = (StgOfflineConfig)offlineMappingListItr.next();
			Long offlineRuleId = StgOfflineConfigDaoFactory.getStgOfflineConfigDao().create(offlineVO);
			Iterator offlineInsertItr = offlineVO.getExtraInsertList().iterator();
			while(offlineInsertItr.hasNext()){
				StgInsertMappingConfig extraInsertVO = (StgInsertMappingConfig)offlineInsertItr.next();
				extraInsertVO.setOfflineRuleId(offlineRuleId);
				insertConfigDao.create(extraInsertVO);
			}
		}
	}
	
	public void saveVoucherMappingList(List voucherMappingList)throws Exception{
		Iterator voucherMappingListItr = voucherMappingList.iterator();
		while(voucherMappingListItr.hasNext()){
			StgVoucherMappingConfig voucherVO = (StgVoucherMappingConfig)voucherMappingListItr.next();
			//DaoFactory.create();
			Long voucherRuleId = StgVoucherMappingConfigDaoFactory.getStgVoucherMappingConfigDao().create(voucherVO);
			Iterator voucherInsertItr = voucherVO.getExtraInsertList().iterator();
			while(voucherInsertItr.hasNext()){
				StgInsertMappingConfig extraInsertVO = (StgInsertMappingConfig)voucherInsertItr.next();
				extraInsertVO.setVoucherRuleId(voucherRuleId);
				insertConfigDao.create(extraInsertVO);
			}
		}
	}
	
	public void saveCampaignMappingList(List campaignMappingList)throws Exception{
		Iterator campaignMappingListItr = campaignMappingList.iterator();
		while(campaignMappingListItr.hasNext()){
			StgCampaignMappingConfig campaignVO = (StgCampaignMappingConfig)campaignMappingListItr.next();
			StgCampaignMappingConfigDaoFactory.getStgCampaignMappingConfigDao().create(campaignVO);
			Long campaignRuleId = new Long(0);
			String attachmentType = campaignVO.getAttachmentType();
			if(attachmentType.equalsIgnoreCase("Document")){
				StgDocMappingConfig docVO = campaignVO.getDocumentMappingConfig();
				docVO.setCampaignRuleId(campaignRuleId);
				docConfigDao.create(docVO);
			}else if(attachmentType.equalsIgnoreCase("Voucher")){
				StgInsertMappingConfig extraInsertVO = campaignVO.getInsertMappingConfig();
				extraInsertVO.setCampaignRuleId(campaignRuleId);
				insertConfigDao.create(extraInsertVO);
			}
		}
	}
	
	public void saveAutoFulfillMappingList(List autoFulfillMappingList)throws Exception{
		Iterator autoFulfillMappingListItr = autoFulfillMappingList.iterator();
		while(autoFulfillMappingListItr.hasNext()){
			StgAutomaticDelivermodeCfg autoFulfillVO = (StgAutomaticDelivermodeCfg) autoFulfillMappingListItr.next();
			StgAutomaticDelivermodeCfgDaoFactory.getStgAutomaticDelivermodeCfgDao().create(autoFulfillVO);
		}
	}
	
	public void saveSmsEmailMappingConfig(StgSmsEmailMappingConfig smsEmailVO)throws Exception{
		StgSmsEmailMappingConfigDaoFactory.getStgSmsEmailMappingConfigDao().create(smsEmailVO);
	}

	public StgFrmsMasterConfig getConfigVO() {
		return configVO;
	}

	public void setConfigVO(StgFrmsMasterConfig configVO) {
		this.configVO = configVO;
	}
}
