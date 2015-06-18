package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl.TSgProducerExceptionConfigDaoOracleImpl;

public class TSgProducerExceptionConfigDaoFactory {
    private static TSgProducerExceptionConfigDao dao=new TSgProducerExceptionConfigDaoOracleImpl();

	public static TSgProducerExceptionConfigDao getTSgProducerExceptionConfigDao(){
		return dao;
	}
}