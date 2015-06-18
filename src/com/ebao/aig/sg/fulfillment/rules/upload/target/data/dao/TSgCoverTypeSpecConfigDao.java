package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgCoverTypeSpecConfig;
import com.ebao.pub.framework.GenericException;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface TSgCoverTypeSpecConfigDao {
  public java.lang.Long create(TSgCoverTypeSpecConfig entity) throws GenericException;
  
  public void update(TSgCoverTypeSpecConfig entity) throws GenericException;
  
  public void remove( java.lang.Long coverTypeRuleId ) throws GenericException;
  
  public TSgCoverTypeSpecConfig load( java.lang.Long coverTypeRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public TSgCoverTypeSpecConfig fillEntity(ResultSet rs) throws SQLException;



public Long getSequenceID(Long masterRule) throws SQLException, ClassNotFoundException;

public Collection<TSgCoverTypeSpecConfig> getCoverDocuList(long masterruleId) throws ClassNotFoundException, SQLException;

;
  
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}