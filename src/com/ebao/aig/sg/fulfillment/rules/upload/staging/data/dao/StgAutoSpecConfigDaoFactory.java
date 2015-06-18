package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.impl.StgAutoSpecConfigDaoOracleImpl;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.mysql.dao.impl.StgAutoSpecConfigDaoMysqlImpl;
import com.ebao.foundation.common.config.Env;

public class StgAutoSpecConfigDaoFactory {
    private static StgAutoSpecConfigDao dao=new StgAutoSpecConfigDaoOracleImpl();

	public static StgAutoSpecConfigDao getStgAutoSpecConfigDao(){
		String databaseType = Env.getValue("DATABASE_TYPE");
		System.out.println("Database Name : "+databaseType);
		if(databaseType.equalsIgnoreCase("MYSQL"))
			dao = new StgAutoSpecConfigDaoMysqlImpl();
		return dao;
	}
}