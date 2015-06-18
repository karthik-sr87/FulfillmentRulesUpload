package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.impl.StgPlatformSpecificConfigDaoOracleImpl;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.mysql.dao.impl.StgPlatformSpecificConfigDaoMysqlImpl;
import com.ebao.foundation.common.config.Env;

public class StgPlatformSpecificConfigDaoFactory {
    private static StgPlatformSpecificConfigDao dao=new StgPlatformSpecificConfigDaoOracleImpl();

	public static StgPlatformSpecificConfigDao getStgPlatformSpecificConfigDao(){
		String databaseType = Env.getValue("DATABASE_TYPE");
		System.out.println("Database Name : "+databaseType);
		if(databaseType.equalsIgnoreCase("MYSQL"))
			dao = new StgPlatformSpecificConfigDaoMysqlImpl();
		return dao;
	}
}