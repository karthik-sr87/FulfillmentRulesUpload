package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.impl.StgAutomaticDelivermodeCfgDaoOracleImpl;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.mysql.dao.impl.StgAutomaticDelivermodeCfgDaoMysqlImpl;
import com.ebao.foundation.common.config.Env;

public class StgAutomaticDelivermodeCfgDaoFactory {
    private static StgAutomaticDelivermodeCfgDao dao=new StgAutomaticDelivermodeCfgDaoOracleImpl();

	public static StgAutomaticDelivermodeCfgDao getStgAutomaticDelivermodeCfgDao(){
		String databaseType = Env.getValue("DATABASE_TYPE");
		System.out.println("Database Name : "+databaseType);
		if(databaseType.equalsIgnoreCase("MYSQL"))
			dao = new StgAutomaticDelivermodeCfgDaoMysqlImpl();
		return dao;
		
	}
}