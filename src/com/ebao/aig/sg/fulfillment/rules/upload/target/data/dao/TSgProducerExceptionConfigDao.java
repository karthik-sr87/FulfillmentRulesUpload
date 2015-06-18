package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgProducerExceptionConfig;
import com.ebao.pub.framework.GenericException;


public interface TSgProducerExceptionConfigDao {
  public java.lang.Long create(TSgProducerExceptionConfig entity) throws GenericException;
  
  public void update(TSgProducerExceptionConfig entity) throws GenericException;
  
  public void remove( java.lang.Long pdcrExcpRuleId ) throws GenericException;
  
  public TSgProducerExceptionConfig load( java.lang.Long pdcrExcpRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public TSgProducerExceptionConfig fillEntity(ResultSet rs) throws SQLException;
  
  public int getSequenceID()throws SQLException, ClassNotFoundException;
}