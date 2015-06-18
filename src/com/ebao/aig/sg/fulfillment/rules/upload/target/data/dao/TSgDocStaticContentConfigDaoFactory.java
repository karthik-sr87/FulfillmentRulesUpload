package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl.TSgDocStaticContentConfigDaoOracleImpl;

public class TSgDocStaticContentConfigDaoFactory {
    private static TSgDocStaticContentConfigDao dao=new TSgDocStaticContentConfigDaoOracleImpl();

	public static TSgDocStaticContentConfigDao getTSgDocStaticContentConfigDao(){
		return dao;
	}
}