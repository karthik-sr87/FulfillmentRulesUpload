package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl.TSgLetterMasterConfigDaoOracleImpl;

public class TSgLetterMasterConfigDaoFactory {
    private static TSgLetterMasterConfigDao dao=new TSgLetterMasterConfigDaoOracleImpl();

	public static TSgLetterMasterConfigDao getTSgLetterMasterConfigDao(){
		return dao;
	}
}