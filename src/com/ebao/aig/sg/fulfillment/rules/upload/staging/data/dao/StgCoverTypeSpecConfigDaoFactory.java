package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.impl.StgCoverTypeSpecConfigDaoOracleImpl;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.mysql.dao.impl.StgCoverTypeSpecConfigDaoMysqlImpl;
import com.ebao.foundation.common.config.Env;

public class StgCoverTypeSpecConfigDaoFactory {
    private static StgCoverTypeSpecConfigDao dao=new StgCoverTypeSpecConfigDaoOracleImpl();

	public static StgCoverTypeSpecConfigDao getStgCoverTypeSpecConfigDao(){
		String databaseType = Env.getValue("DATABASE_TYPE");
		System.out.println("Database Name : "+databaseType);
		if(databaseType.equalsIgnoreCase("MYSQL"))
			dao = new StgCoverTypeSpecConfigDaoMysqlImpl();
		return dao;
	}
}