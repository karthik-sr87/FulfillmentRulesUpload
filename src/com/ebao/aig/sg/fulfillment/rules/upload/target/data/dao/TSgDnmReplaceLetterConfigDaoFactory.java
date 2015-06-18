package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl.TSgDnmReplaceLetterConfigDaoOracleImpl;

public class TSgDnmReplaceLetterConfigDaoFactory {
    private static TSgDnmReplaceLetterConfigDao dao=new TSgDnmReplaceLetterConfigDaoOracleImpl();

	public static TSgDnmReplaceLetterConfigDao getTSgDnmReplaceLetterConfigDao(){
		return dao;
	}
}
