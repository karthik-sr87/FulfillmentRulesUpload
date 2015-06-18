package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgDocMappingConfig;
import com.ebao.pub.framework.GenericException;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface StgDocMappingConfigDao {
  public java.lang.Long create(StgDocMappingConfig entity) throws GenericException;
  
  public void update(StgDocMappingConfig entity) throws GenericException;
  
  public void remove( java.lang.Long docRuleId ) throws GenericException;
  
  public StgDocMappingConfig load( java.lang.Long docRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public StgDocMappingConfig fillEntity(ResultSet rs) throws SQLException;
  
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}