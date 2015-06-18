package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao; 

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl.TSgLetterAttributeConfigDaoOracleImpl;

public class TSgLetterAttributeConfigDaoFactory {
    private static TSgLetterAttributeConfigDao dao=new TSgLetterAttributeConfigDaoOracleImpl();

	public static TSgLetterAttributeConfigDao getTSgLetterAttributeConfigDao(){
		return dao;
	}
}