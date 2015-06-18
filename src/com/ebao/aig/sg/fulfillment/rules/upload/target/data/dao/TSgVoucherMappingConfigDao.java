package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgVoucherMappingConfig;
import com.ebao.pub.framework.GenericException;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface TSgVoucherMappingConfigDao {
  public java.lang.Long create(TSgVoucherMappingConfig entity) throws GenericException;
  
  public void update(TSgVoucherMappingConfig entity) throws GenericException;
  
  public void remove( java.lang.Long voucherRuleId ) throws GenericException;
  
  public TSgVoucherMappingConfig load( java.lang.Long voucherRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public TSgVoucherMappingConfig fillEntity(ResultSet rs) throws SQLException;


///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}