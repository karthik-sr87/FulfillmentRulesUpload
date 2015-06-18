package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgCustEmailExcepConfig;
import com.ebao.pub.framework.GenericException;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface TSgCustEmailExcepConfigDao {
  public java.lang.Long create(TSgCustEmailExcepConfig entity) throws GenericException;
  
  public void update(TSgCustEmailExcepConfig entity) throws GenericException;
  
  public void remove( java.lang.Long custSmsExpId ) throws GenericException;
  
  public TSgCustEmailExcepConfig load( java.lang.Long custSmsExpId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public TSgCustEmailExcepConfig fillEntity(ResultSet rs) throws SQLException;
  
public int getSequenceID() throws SQLException, ClassNotFoundException;
  


  
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}