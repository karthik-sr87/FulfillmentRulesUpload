package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl.TSgCustEmailExcepConfigDaoOracleImpl;

public class TSgCustEmailExcepConfigDaoFactory {
    private static TSgCustEmailExcepConfigDao dao=new TSgCustEmailExcepConfigDaoOracleImpl();

	public static TSgCustEmailExcepConfigDao getTSgCustEmailExcepConfigDao(){
		return dao;
	}
}