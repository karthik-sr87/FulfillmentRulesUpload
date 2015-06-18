package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl.TSgFrmsMasterConfigDaoOracleImpl;




public class TSgFrmsMasterConfigDaoFactory {

    private static TSgFrmsMasterConfigDao dao=new TSgFrmsMasterConfigDaoOracleImpl();

	public static TSgFrmsMasterConfigDao getTSgFrmsMasterConfigDao(){
		return dao;
	}

}
