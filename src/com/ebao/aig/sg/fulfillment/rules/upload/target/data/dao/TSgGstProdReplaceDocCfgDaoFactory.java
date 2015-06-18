package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl.TSgGstProdReplaceDocCfgDaoOracleImpl;

public class TSgGstProdReplaceDocCfgDaoFactory {
    private static TSgGstProdReplaceDocCfgDao dao=new TSgGstProdReplaceDocCfgDaoOracleImpl();

	public static TSgGstProdReplaceDocCfgDao getTSgGstProdReplaceDocCfgDao(){
		return dao;
	}
	
}