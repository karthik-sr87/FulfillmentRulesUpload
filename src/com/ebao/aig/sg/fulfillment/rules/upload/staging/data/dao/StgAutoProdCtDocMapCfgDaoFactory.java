package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.impl.StgAutoProdCtDocMapCfgDaoOracleImpl;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.mysql.dao.impl.StgAutoProdCtDocMapCfgDaoMysqlImpl;
import com.ebao.foundation.common.config.Env;

public class StgAutoProdCtDocMapCfgDaoFactory {
    private static StgAutoProdCtDocMapCfgDao dao=new StgAutoProdCtDocMapCfgDaoOracleImpl();

	public static StgAutoProdCtDocMapCfgDao getStgAutoProdCtDocMapCfgDao(){
		String databaseType = Env.getValue("DATABASE_TYPE");
		System.out.println("Database Name : "+databaseType);
		if(databaseType.equalsIgnoreCase("MYSQL"))
			dao = new StgAutoProdCtDocMapCfgDaoMysqlImpl();
		return dao;
	}
}