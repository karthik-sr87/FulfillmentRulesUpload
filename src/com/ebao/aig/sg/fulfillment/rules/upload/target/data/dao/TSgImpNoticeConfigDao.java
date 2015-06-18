package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgImpNoticeConfig;
import com.ebao.pub.framework.GenericException;


public interface TSgImpNoticeConfigDao {
  public java.lang.Long create(TSgImpNoticeConfig entity) throws GenericException;
  
  public void update(TSgImpNoticeConfig entity) throws GenericException;
  
  public void remove( java.lang.Long impNoticeId ) throws GenericException;
  
  public TSgImpNoticeConfig load( java.lang.Long impNoticeId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public TSgImpNoticeConfig fillEntity(ResultSet rs) throws SQLException;
  
  public int getImpSequenceId() throws SQLException,ClassNotFoundException;

}