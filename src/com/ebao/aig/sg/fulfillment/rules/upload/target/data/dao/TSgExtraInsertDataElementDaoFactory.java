package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl.TSgExtraInsertDataElementDaoOracleImpl;


public class TSgExtraInsertDataElementDaoFactory {
    private static TSgExtraInsertDataElementDao dao=new TSgExtraInsertDataElementDaoOracleImpl();

	public static TSgExtraInsertDataElementDao getTSgExtraInsertDataElementDao(){
		return dao;
	}
}