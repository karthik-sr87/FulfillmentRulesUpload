package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgAutoSpecConfig;
import com.ebao.pub.framework.GenericException;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface TSgAutoSpecConfigDao {
  public java.lang.Long create(TSgAutoSpecConfig entity) throws GenericException;
  
  public void update(TSgAutoSpecConfig entity) throws GenericException;
  
  public void remove( java.lang.Long autoRuleId ) throws GenericException;
  
  public TSgAutoSpecConfig load( java.lang.Long autoRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public TSgAutoSpecConfig fillEntity(ResultSet rs) throws SQLException;




///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}