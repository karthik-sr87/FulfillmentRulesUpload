package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.impl.StgSmsEmailMappingConfigDaoOracleImpl;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.mysql.dao.impl.StgSmsEmailMappingConfigDaoMysqlImpl;
import com.ebao.foundation.common.config.Env;

public class StgSmsEmailMappingConfigDaoFactory {
    private static StgSmsEmailMappingConfigDao dao=new StgSmsEmailMappingConfigDaoOracleImpl();

	public static StgSmsEmailMappingConfigDao getStgSmsEmailMappingConfigDao(){
		String databaseType = Env.getValue("DATABASE_TYPE");
		System.out.println("Database Name : "+databaseType);
		if(databaseType.equalsIgnoreCase("MYSQL"))
			dao = new StgSmsEmailMappingConfigDaoMysqlImpl();
		return dao;
	}
}