package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl.TSgSmsEmailMappingConfigDaoOracleImpl;

public class TSgSmsEmailMappingConfigDaoFactory {
    private static TSgSmsEmailMappingConfigDao dao=new TSgSmsEmailMappingConfigDaoOracleImpl();

	public static TSgSmsEmailMappingConfigDao getTSgSmsEmailMappingConfigDao(){
		return dao;
	}
}