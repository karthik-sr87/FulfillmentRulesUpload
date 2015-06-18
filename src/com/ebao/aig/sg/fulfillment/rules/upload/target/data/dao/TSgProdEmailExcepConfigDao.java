package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgProdEmailExcepConfig;
import com.ebao.pub.framework.GenericException;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface TSgProdEmailExcepConfigDao {
  public java.lang.Long create(TSgProdEmailExcepConfig entity) throws GenericException;
  
  public void update(TSgProdEmailExcepConfig entity) throws GenericException;
  
  public void remove( java.lang.Long prodEmailExpId ) throws GenericException;
  
  public TSgProdEmailExcepConfig load( java.lang.Long prodEmailExpId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public TSgProdEmailExcepConfig fillEntity(ResultSet rs) throws SQLException;
  
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}