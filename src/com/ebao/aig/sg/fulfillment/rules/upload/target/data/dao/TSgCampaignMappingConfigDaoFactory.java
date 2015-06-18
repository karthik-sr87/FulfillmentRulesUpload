package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl.TSgCampaignMappingConfigDaoOracleImpl;

public class TSgCampaignMappingConfigDaoFactory {
    private static TSgCampaignMappingConfigDao dao=new TSgCampaignMappingConfigDaoOracleImpl();

	public static TSgCampaignMappingConfigDao getTSgCampaignMappingConfigDao(){
		return dao;
	}
}