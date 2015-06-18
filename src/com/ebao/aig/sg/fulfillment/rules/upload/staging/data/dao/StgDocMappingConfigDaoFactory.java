package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.impl.StgDocMappingConfigDaoOracleImpl;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.mysql.dao.impl.StgDocMappingConfigDaoMysqlImpl;
import com.ebao.foundation.common.config.Env;

public class StgDocMappingConfigDaoFactory {
    private static StgDocMappingConfigDao dao=new StgDocMappingConfigDaoOracleImpl();

	public static StgDocMappingConfigDao getStgDocMappingConfigDao(){
		String databaseType = Env.getValue("DATABASE_TYPE");
		System.out.println("Database Name : "+databaseType);
		if(databaseType.equalsIgnoreCase("MYSQL"))
			dao = new StgDocMappingConfigDaoMysqlImpl();
		return dao;
	}
}