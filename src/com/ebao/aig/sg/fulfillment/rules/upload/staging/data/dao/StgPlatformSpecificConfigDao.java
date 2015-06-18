package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao;

import java.sql.*;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgPlatformSpecificConfig;
import com.ebao.pub.framework.*;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface StgPlatformSpecificConfigDao {
  public java.lang.Long create(StgPlatformSpecificConfig entity) throws GenericException;
  
  public void update(StgPlatformSpecificConfig entity) throws GenericException;
  
  public void remove( java.lang.Long platformRuleId ) throws GenericException;
  
  public StgPlatformSpecificConfig load( java.lang.Long platformRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public StgPlatformSpecificConfig fillEntity(ResultSet rs) throws SQLException;
  
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}