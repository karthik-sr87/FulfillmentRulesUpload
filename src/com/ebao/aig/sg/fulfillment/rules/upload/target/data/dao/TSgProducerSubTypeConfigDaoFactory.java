package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl.TSgProducerSubTypeConfigDaoOracleImpl;

public class TSgProducerSubTypeConfigDaoFactory {
	 private static TSgProducerSubTypeConfigDao dao=new TSgProducerSubTypeConfigDaoOracleImpl();

		public static TSgProducerSubTypeConfigDao getTSgProducerSubTypeConfigDao(){
			return dao;
	}
}