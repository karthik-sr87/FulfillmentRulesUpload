package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl.TSgProdEmailExcepConfigDaoOracleImpl;

public class TSgProdEmailExcepConfigDaoFactory {
    private static TSgProdEmailExcepConfigDao dao=new TSgProdEmailExcepConfigDaoOracleImpl();

	public static TSgProdEmailExcepConfigDao getTSgProdEmailExcepConfigDao(){
		return dao;
	}
}