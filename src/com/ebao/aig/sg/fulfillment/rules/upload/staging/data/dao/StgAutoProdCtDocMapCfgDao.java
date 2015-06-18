package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgAutoProdCtDocMapCfg;
import com.ebao.pub.framework.GenericException;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface StgAutoProdCtDocMapCfgDao {
  public java.lang.Long create(StgAutoProdCtDocMapCfg entity) throws GenericException;
  
  public void update(StgAutoProdCtDocMapCfg entity) throws GenericException;
  
  public void remove( java.lang.Long autoProducerCtMapId ) throws GenericException;
  
  public StgAutoProdCtDocMapCfg load( java.lang.Long autoProducerCtMapId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public StgAutoProdCtDocMapCfg fillEntity(ResultSet rs) throws SQLException;
  
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}