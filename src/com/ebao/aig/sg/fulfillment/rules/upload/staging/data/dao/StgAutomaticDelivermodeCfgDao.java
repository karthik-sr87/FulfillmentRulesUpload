package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao;

import java.sql.*;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgAutomaticDelivermodeCfg;
import com.ebao.pub.framework.*;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface StgAutomaticDelivermodeCfgDao {
  public Long create(StgAutomaticDelivermodeCfg entity) throws GenericException;
  
  public void update(StgAutomaticDelivermodeCfg entity) throws GenericException;
  
  public void remove() throws GenericException;
  
  public StgAutomaticDelivermodeCfg load() throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public StgAutomaticDelivermodeCfg fillEntity(ResultSet rs) throws SQLException;
  
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}