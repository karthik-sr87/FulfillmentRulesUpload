package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgSmsEmailMappingConfig;
import com.ebao.pub.framework.GenericException;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface TSgSmsEmailMappingConfigDao {
  public java.lang.Long create(TSgSmsEmailMappingConfig entity) throws GenericException;
  
  public void update(TSgSmsEmailMappingConfig entity) throws GenericException;
  
  public void remove( java.lang.Long ruleId ) throws GenericException;
  
  public TSgSmsEmailMappingConfig load( java.lang.Long ruleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public TSgSmsEmailMappingConfig fillEntity(ResultSet rs) throws SQLException;
  
  

  
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}