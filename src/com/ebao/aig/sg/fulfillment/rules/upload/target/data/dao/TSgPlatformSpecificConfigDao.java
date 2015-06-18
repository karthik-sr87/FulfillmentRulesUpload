package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgPlatformSpecificConfig;
import com.ebao.pub.framework.GenericException;

///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface TSgPlatformSpecificConfigDao {
  public java.lang.Long create(TSgPlatformSpecificConfig entity) throws GenericException;
  
  public void update(TSgPlatformSpecificConfig entity) throws GenericException;
  
  public void remove( java.lang.Long platformRuleId ) throws GenericException;
  
  public TSgPlatformSpecificConfig load( java.lang.Long platformRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public TSgPlatformSpecificConfig fillEntity(ResultSet rs) throws SQLException;



  
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}