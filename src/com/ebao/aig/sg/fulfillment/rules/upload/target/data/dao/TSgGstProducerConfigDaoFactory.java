package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl.TSgGstProducerConfigDaoOracleImpl;

public class TSgGstProducerConfigDaoFactory {
    private static TSgGstProducerConfigDao dao=new TSgGstProducerConfigDaoOracleImpl();

	public static TSgGstProducerConfigDao getTSgGstProducerConfigDao(){
		return dao;
	}
}