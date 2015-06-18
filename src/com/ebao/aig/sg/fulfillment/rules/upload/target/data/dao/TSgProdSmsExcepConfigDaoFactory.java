package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl.TSgProdSmsExcepConfigDaoOracleImpl;

public class TSgProdSmsExcepConfigDaoFactory {
    private static TSgProdSmsExcepConfigDao dao=new TSgProdSmsExcepConfigDaoOracleImpl();    

	public static TSgProdSmsExcepConfigDao getTSgProdSmsExcepConfigDao(){
		return dao;
	}
}