package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.impl.StgVoucherMappingConfigDaoOracleImpl;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.mysql.dao.impl.StgVoucherMappingConfigDaoMysqlImpl;
import com.ebao.foundation.common.config.Env;

public class StgVoucherMappingConfigDaoFactory {
    private static StgVoucherMappingConfigDao dao=new StgVoucherMappingConfigDaoOracleImpl();

	public static StgVoucherMappingConfigDao getStgVoucherMappingConfigDao(){
		String databaseType = Env.getValue("DATABASE_TYPE");
		System.out.println("Database Name : "+databaseType);
		if(databaseType.equalsIgnoreCase("MYSQL"))
			dao = new StgVoucherMappingConfigDaoMysqlImpl();
		return dao;
	}
}