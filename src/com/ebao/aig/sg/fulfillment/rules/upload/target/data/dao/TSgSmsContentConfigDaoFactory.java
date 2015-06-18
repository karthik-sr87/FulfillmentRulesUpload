package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl.TSgSmsContentConfigDaoOracleImpl;

public class TSgSmsContentConfigDaoFactory {
    private static TSgSmsContentConfigDao dao=new TSgSmsContentConfigDaoOracleImpl();

	public static TSgSmsContentConfigDao getTSgSmsContentConfigDao(){
		return dao;
	}
}