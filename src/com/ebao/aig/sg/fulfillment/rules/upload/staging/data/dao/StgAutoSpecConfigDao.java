package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao;

import java.sql.*;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgAutoSpecConfig;
import com.ebao.pub.framework.*;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface StgAutoSpecConfigDao {
  public java.lang.Long create(StgAutoSpecConfig entity) throws GenericException;
  
  public void update(StgAutoSpecConfig entity) throws GenericException;
  
  public void remove( java.lang.Long autoRuleId ) throws GenericException;
  
  public StgAutoSpecConfig load( java.lang.Long autoRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public StgAutoSpecConfig fillEntity(ResultSet rs) throws SQLException;
  
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}