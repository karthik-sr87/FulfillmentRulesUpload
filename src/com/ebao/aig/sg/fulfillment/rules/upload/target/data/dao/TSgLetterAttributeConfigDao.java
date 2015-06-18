package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgLetterAttributeConfig;
import com.ebao.pub.framework.GenericException;


public interface TSgLetterAttributeConfigDao {
  public java.lang.Long create(TSgLetterAttributeConfig entity) throws GenericException;
  
  public void update(TSgLetterAttributeConfig entity) throws GenericException;
  
  public void remove( java.lang.Long letterAttributeId ) throws GenericException;
  
  public TSgLetterAttributeConfig load( java.lang.Long letterAttributeId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public TSgLetterAttributeConfig fillEntity(ResultSet rs) throws SQLException;

  public int getSequenceID() throws SQLException, ClassNotFoundException;
}