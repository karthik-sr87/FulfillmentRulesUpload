package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgCustSmsExcepConfig;
import com.ebao.pub.framework.GenericException;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface TSgCustSmsExcepConfigDao {
  public java.lang.Long create(TSgCustSmsExcepConfig entity) throws GenericException;
  
  public void update(TSgCustSmsExcepConfig entity) throws GenericException;
  
  public void remove( java.lang.Long custSmsExpId ) throws GenericException;
  
  public TSgCustSmsExcepConfig load( java.lang.Long custSmsExpId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public TSgCustSmsExcepConfig fillEntity(ResultSet rs) throws SQLException;
  
 public int getSequenceID() throws SQLException, ClassNotFoundException;
  

  
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}