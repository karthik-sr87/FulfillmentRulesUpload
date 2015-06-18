package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl.TSgOfflineConfigDaoOracleImpl;


public class TSgOfflineConfigDaoFactory {
    private static TSgOfflineConfigDao dao=new TSgOfflineConfigDaoOracleImpl();

	public static TSgOfflineConfigDao getTSgOfflineConfigDao(){
		return dao;
	}
}