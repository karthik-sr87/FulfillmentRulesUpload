package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.impl.StgInsertMappingConfigDaoOracleImpl;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.mysql.dao.impl.StgInsertMappingConfigDaoMysqlImpl;
import com.ebao.foundation.common.config.Env;

public class StgInsertMappingConfigDaoFactory {
    private static StgInsertMappingConfigDao dao=new StgInsertMappingConfigDaoOracleImpl();

	public static StgInsertMappingConfigDao getStgInsertMappingConfigDao(){
		String databaseType = Env.getValue("DATABASE_TYPE");
		System.out.println("Database Name : "+databaseType);
		if(databaseType.equalsIgnoreCase("MYSQL"))
			dao = new StgInsertMappingConfigDaoMysqlImpl();
		return dao;
	}
}