package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl.TSgCoverTypeSpecConfigDaoOracleImpl;

public class TSgCoverTypeSpecConfigDaoFactory {
    private static TSgCoverTypeSpecConfigDao dao=new TSgCoverTypeSpecConfigDaoOracleImpl();

	public static TSgCoverTypeSpecConfigDao getTSgCoverTypeSpecConfigDao(){
		return dao;
	}
}