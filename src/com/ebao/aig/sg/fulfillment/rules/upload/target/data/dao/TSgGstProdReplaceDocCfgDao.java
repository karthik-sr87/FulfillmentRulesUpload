package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgGstProdReplaceDocCfg;
import com.ebao.pub.framework.GenericException;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface TSgGstProdReplaceDocCfgDao {
  public java.lang.Long create(TSgGstProdReplaceDocCfg entity) throws GenericException;
  
  public void update(TSgGstProdReplaceDocCfg entity) throws GenericException;
  
  public void remove( java.lang.Long gstReplaceRuleId ) throws GenericException;
  
  public TSgGstProdReplaceDocCfg load( java.lang.Long gstReplaceRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public TSgGstProdReplaceDocCfg fillEntity(ResultSet rs) throws SQLException;
  
  public int getSequenceID() throws SQLException, ClassNotFoundException;
  

///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}