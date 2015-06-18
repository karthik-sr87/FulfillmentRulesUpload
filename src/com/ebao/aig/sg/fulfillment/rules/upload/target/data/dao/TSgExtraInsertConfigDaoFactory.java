package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl.TSgExtraInsertConfigDaoOracleImpl;


public class TSgExtraInsertConfigDaoFactory {
    private static TSgExtraInsertConfigDao dao=new TSgExtraInsertConfigDaoOracleImpl();

	public static TSgExtraInsertConfigDao getTSgExtraInsertConfigDao(){
		return dao;
	}
}