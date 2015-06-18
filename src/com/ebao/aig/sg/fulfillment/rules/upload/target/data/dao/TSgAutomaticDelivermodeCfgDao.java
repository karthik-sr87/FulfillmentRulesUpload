package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgAutomaticDelivermodeCfg;
import com.ebao.pub.framework.GenericException;


public interface TSgAutomaticDelivermodeCfgDao {
  public java.lang.Long create(TSgAutomaticDelivermodeCfg entity) throws GenericException;
  
  public void update(TSgAutomaticDelivermodeCfg entity) throws GenericException;
  
  public void remove( java.lang.Long automaticRuleId ) throws GenericException;
  
  public TSgAutomaticDelivermodeCfg load( java.lang.Long automaticRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public TSgAutomaticDelivermodeCfg fillEntity(ResultSet rs) throws SQLException;

  public int getSequenceID() throws SQLException, ClassNotFoundException;

 // public Collection getAutoDlvrModeList(String condition, List sqlParams,AgentPageUtil page)throws Exception;
}