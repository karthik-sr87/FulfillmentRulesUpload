package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl.TSgInsertMappingConfigDaoOracleImpl;

public class TSgInsertMappingConfigDaoFactory {
    private static TSgInsertMappingConfigDao dao=new TSgInsertMappingConfigDaoOracleImpl();

	public static TSgInsertMappingConfigDao getTSgInsertMappingConfigDao(){
		return dao;
	}
}