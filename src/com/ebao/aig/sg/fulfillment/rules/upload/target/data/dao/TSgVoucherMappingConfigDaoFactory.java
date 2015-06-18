package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl.TSgVoucherMappingConfigDaoOracleImpl;

public class TSgVoucherMappingConfigDaoFactory {
    private static TSgVoucherMappingConfigDao dao=new TSgVoucherMappingConfigDaoOracleImpl();

	public static TSgVoucherMappingConfigDao getTSgVoucherMappingConfigDao(){
		return dao;
	}
}