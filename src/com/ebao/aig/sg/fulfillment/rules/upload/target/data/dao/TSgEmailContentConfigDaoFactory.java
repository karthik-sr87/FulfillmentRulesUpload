package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl.TSgEmailContentConfigDaoOracleImpl;

public class TSgEmailContentConfigDaoFactory {
    private static TSgEmailContentConfigDao dao=new TSgEmailContentConfigDaoOracleImpl();

	public static TSgEmailContentConfigDao getTSgEmailContentConfigDao(){
		return dao;
	}
}