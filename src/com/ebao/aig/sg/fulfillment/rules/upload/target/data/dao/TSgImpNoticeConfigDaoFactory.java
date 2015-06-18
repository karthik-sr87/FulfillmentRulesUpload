package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl.TSgImpNoticeConfigDaoOracleImpl;

public class TSgImpNoticeConfigDaoFactory {
    private static TSgImpNoticeConfigDao dao=new TSgImpNoticeConfigDaoOracleImpl();

	public static TSgImpNoticeConfigDao getTSgImpNoticeConfigDao(){
		return dao;
	}
}