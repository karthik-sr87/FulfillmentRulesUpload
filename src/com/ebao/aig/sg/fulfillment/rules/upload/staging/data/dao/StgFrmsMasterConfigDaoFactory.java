package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.impl.StgFrmsMasterConfigDaoOracleImpl;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.mysql.dao.impl.StgFrmsMasterConfigDaoMysqlImpl;
import com.ebao.foundation.common.config.Env;

public class StgFrmsMasterConfigDaoFactory {
    private static StgFrmsMasterConfigDao dao=new StgFrmsMasterConfigDaoOracleImpl();

	public static StgFrmsMasterConfigDao getStgFrmsMasterConfigDao(){
		String databaseType = Env.getValue("DATABASE_TYPE");
		System.out.println("Database Name : "+databaseType);
		if(databaseType.equalsIgnoreCase("MYSQL"))
			dao = new StgFrmsMasterConfigDaoMysqlImpl();
		return dao;
	}
}