package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgVoucherMappingConfig;
import com.ebao.pub.framework.GenericException;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface StgVoucherMappingConfigDao {
  public java.lang.Long create(StgVoucherMappingConfig entity) throws GenericException;
  
  public void update(StgVoucherMappingConfig entity) throws GenericException;
  
  public void remove( java.lang.Long voucherRuleId ) throws GenericException;
  
  public StgVoucherMappingConfig load( java.lang.Long voucherRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public StgVoucherMappingConfig fillEntity(ResultSet rs) throws SQLException;
  
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}