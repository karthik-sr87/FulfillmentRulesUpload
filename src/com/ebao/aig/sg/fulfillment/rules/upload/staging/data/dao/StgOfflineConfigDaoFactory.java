package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.impl.StgOfflineConfigDaoOracleImpl;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.mysql.dao.impl.StgOfflineConfigDaoMysqlImpl;
import com.ebao.foundation.common.config.Env;

public class StgOfflineConfigDaoFactory {
    private static StgOfflineConfigDao dao=new StgOfflineConfigDaoOracleImpl();

	public static StgOfflineConfigDao getStgOfflineConfigDao(){
		String databaseType = Env.getValue("DATABASE_TYPE");
		System.out.println("Database Name : "+databaseType);
		if(databaseType.equalsIgnoreCase("MYSQL"))
			dao = new StgOfflineConfigDaoMysqlImpl();
		return dao;
	}
}