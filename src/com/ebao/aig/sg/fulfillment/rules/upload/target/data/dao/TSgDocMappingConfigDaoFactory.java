package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;


import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl.TSgDocMappingConfigDaoOracleImpl;

public class TSgDocMappingConfigDaoFactory {
    private static TSgDocMappingConfigDao dao=new TSgDocMappingConfigDaoOracleImpl();

	public static TSgDocMappingConfigDao getTSgDocMappingConfigDao(){
		return dao;
	}
}