package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgCoverTypeSpecConfig;
import com.ebao.pub.framework.GenericException;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface StgCoverTypeSpecConfigDao {
  public java.lang.Long create(StgCoverTypeSpecConfig entity) throws GenericException;
  
  public void update(StgCoverTypeSpecConfig entity) throws GenericException;
  
  public void remove( java.lang.Long coverTypeRuleId ) throws GenericException;
  
  public StgCoverTypeSpecConfig load( java.lang.Long coverTypeRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public StgCoverTypeSpecConfig fillEntity(ResultSet rs) throws SQLException;
  
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}