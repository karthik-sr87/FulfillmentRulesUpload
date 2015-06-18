package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgProdSmsExcepConfig;
import com.ebao.pub.framework.GenericException;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface TSgProdSmsExcepConfigDao {
  public java.lang.Long create(TSgProdSmsExcepConfig entity) throws GenericException;
  
  public void update(TSgProdSmsExcepConfig entity) throws GenericException;
  
  public void remove( java.lang.Long prodSmsExpId ) throws GenericException;
  
  public TSgProdSmsExcepConfig load( java.lang.Long prodSmsExpId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public TSgProdSmsExcepConfig fillEntity(ResultSet rs) throws SQLException;
  
  public int getSequenceID() throws SQLException, ClassNotFoundException;
  
 
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}