package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgEmailContentConfig;
import com.ebao.pub.framework.GenericException;

public interface TSgEmailContentConfigDao {
  public java.lang.Long create(TSgEmailContentConfig entity) throws GenericException;
  
  public void update(TSgEmailContentConfig entity) throws GenericException;
  
  public void remove( java.lang.Long emailId ) throws GenericException;
  
  public TSgEmailContentConfig load( java.lang.Long emailId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public TSgEmailContentConfig fillEntity(ResultSet rs) throws SQLException;
  
 }