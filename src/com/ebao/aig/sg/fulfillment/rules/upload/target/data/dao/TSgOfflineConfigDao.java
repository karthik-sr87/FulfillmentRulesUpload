package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgOfflineConfig;
import com.ebao.pub.framework.GenericException;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface TSgOfflineConfigDao {
  public java.lang.Long create(TSgOfflineConfig entity) throws GenericException;
  
  public void update(TSgOfflineConfig entity) throws GenericException;
  
  public void remove( java.lang.Long offlineRuleId ) throws GenericException;
  
  public TSgOfflineConfig load( java.lang.Long offlineRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public TSgOfflineConfig fillEntity(ResultSet rs) throws SQLException;
  
}