package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl.TSgProducerSpecificConfigDaoOracleImpl;


public class TSgProducerSpecificConfigDaoFactory {
    private static TSgProducerSpecificConfigDao dao=new TSgProducerSpecificConfigDaoOracleImpl();

	public static TSgProducerSpecificConfigDao getTSgProducerSpecificConfigDao(){
		return dao;
	}
}