package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl.TSgAutomaticDelivermodeCfgDaoOracleImpl;


public class TSgAutomaticDelivermodeCfgDaoFactory {
    private static TSgAutomaticDelivermodeCfgDao dao=new TSgAutomaticDelivermodeCfgDaoOracleImpl();

	public static TSgAutomaticDelivermodeCfgDao getTSgAutomaticDelivermodeCfgDao(){
		return dao;
	}
}