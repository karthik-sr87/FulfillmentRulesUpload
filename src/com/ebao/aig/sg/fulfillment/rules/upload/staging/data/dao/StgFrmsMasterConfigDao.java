package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgFrmsMasterConfig;
import com.ebao.pub.framework.GenericException;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface StgFrmsMasterConfigDao {
  public java.lang.Long create(StgFrmsMasterConfig entity) throws GenericException;
  
  public void update(StgFrmsMasterConfig entity) throws GenericException;
  
  public void remove( java.lang.Long ruleId ) throws GenericException;
  
  public StgFrmsMasterConfig load( java.lang.Long ruleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public StgFrmsMasterConfig fillEntity(ResultSet rs) throws SQLException;
  
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}