package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;


import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl.TSgPlatformSpecificConfigDaoOracleImpl;


public class TSgPlatformSpecificConfigDaoFactory {
    private static TSgPlatformSpecificConfigDao dao=new TSgPlatformSpecificConfigDaoOracleImpl();

	public static TSgPlatformSpecificConfigDao getTSgPlatformSpecificConfigDao(){
		return dao;
	}
}