package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgInsertMappingConfig;
import com.ebao.pub.framework.GenericException;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface StgInsertMappingConfigDao {
  public java.lang.Long create(StgInsertMappingConfig entity) throws GenericException;
  
  public void update(StgInsertMappingConfig entity) throws GenericException;
  
  public void remove( java.lang.Long listId ) throws GenericException;
  
  public StgInsertMappingConfig load( java.lang.Long listId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public StgInsertMappingConfig fillEntity(ResultSet rs) throws SQLException;
  
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}