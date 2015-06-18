package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgExtraInsertConfig;
import com.ebao.pub.framework.GenericException;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface TSgExtraInsertConfigDao {
  public java.lang.Long create(TSgExtraInsertConfig entity) throws GenericException;
  
  public void update(TSgExtraInsertConfig entity) throws GenericException;
  
  public void remove( java.lang.Long extraInsertId ) throws GenericException;
  
  public TSgExtraInsertConfig load( java.lang.Long extraInsertId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public TSgExtraInsertConfig fillEntity(ResultSet rs) throws SQLException;

  
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}