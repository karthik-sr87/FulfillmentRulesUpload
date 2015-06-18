package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl.TSgAutoSpecConfigDaoOracleImpl;

public class TSgAutoSpecConfigDaoFactory {
    private static TSgAutoSpecConfigDao dao=new TSgAutoSpecConfigDaoOracleImpl();

	public static TSgAutoSpecConfigDao getTSgAutoSpecConfigDao(){
		return dao;
	}
}