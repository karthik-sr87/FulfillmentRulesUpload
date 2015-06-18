package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao;

import java.sql.*;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgOfflineConfig;
import com.ebao.pub.framework.*;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface StgOfflineConfigDao {
  public java.lang.Long create(StgOfflineConfig entity) throws GenericException;
  
  public void update(StgOfflineConfig entity) throws GenericException;
  
  public void remove( java.lang.Long offlineRuleId ) throws GenericException;
  
  public StgOfflineConfig load( java.lang.Long offlineRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public StgOfflineConfig fillEntity(ResultSet rs) throws SQLException;
  
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}