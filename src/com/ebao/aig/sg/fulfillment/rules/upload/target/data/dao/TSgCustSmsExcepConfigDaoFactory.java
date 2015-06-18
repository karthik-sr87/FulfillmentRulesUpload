package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl.TSgCustSmsExcepConfigDaoOracleImpl;

public class TSgCustSmsExcepConfigDaoFactory {
    private static TSgCustSmsExcepConfigDao dao=new TSgCustSmsExcepConfigDaoOracleImpl();

	public static TSgCustSmsExcepConfigDao getTSgCustSmsExcepConfigDao(){
		return dao;
	
	}
}