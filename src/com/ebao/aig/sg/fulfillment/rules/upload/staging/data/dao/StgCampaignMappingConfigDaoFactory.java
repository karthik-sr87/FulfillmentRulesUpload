package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.impl.StgCampaignMappingConfigDaoOracleImpl;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.mysql.dao.impl.StgCampaignMappingConfigDaoMysqlImpl;
import com.ebao.foundation.common.config.Env;

public class StgCampaignMappingConfigDaoFactory {
    private static StgCampaignMappingConfigDao dao=new StgCampaignMappingConfigDaoOracleImpl();

	public static StgCampaignMappingConfigDao getStgCampaignMappingConfigDao(){
		String databaseType = Env.getValue("DATABASE_TYPE");
		System.out.println("Database Name : "+databaseType);
		if(databaseType.equalsIgnoreCase("MYSQL"))
			dao = new StgCampaignMappingConfigDaoMysqlImpl();
		return dao;
	}
}