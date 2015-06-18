package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgLetterMasterConfig;
import com.ebao.pub.framework.GenericException;

public interface TSgLetterMasterConfigDao {
  public java.lang.Long create(TSgLetterMasterConfig entity) throws GenericException;
  
  public void update(TSgLetterMasterConfig entity) throws GenericException;
  
  public void remove( java.lang.Long letterId ) throws GenericException;
  
  public TSgLetterMasterConfig load( java.lang.Long letterId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public TSgLetterMasterConfig fillEntity(ResultSet rs) throws SQLException;

  public int getSequenceID() throws SQLException, ClassNotFoundException;

}