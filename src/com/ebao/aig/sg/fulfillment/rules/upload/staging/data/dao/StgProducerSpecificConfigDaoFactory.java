package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.impl.StgProducerSpecificConfigDaoOracleImpl;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.mysql.dao.impl.StgProducerSpecificConfigDaoMysqlImpl;
import com.ebao.foundation.common.config.Env;

public class StgProducerSpecificConfigDaoFactory {
    private static StgProducerSpecificConfigDao dao=new StgProducerSpecificConfigDaoOracleImpl();

	public static StgProducerSpecificConfigDao getStgProducerSpecificConfigDao(){
		String databaseType = Env.getValue("DATABASE_TYPE");
		System.out.println("Database Name : "+databaseType);
		if(databaseType.equalsIgnoreCase("MYSQL"))
			dao = new StgProducerSpecificConfigDaoMysqlImpl();
		return dao;
	}
}