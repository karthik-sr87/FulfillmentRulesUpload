package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgGstProducerConfig;
import com.ebao.pub.framework.GenericException;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface TSgGstProducerConfigDao {
  public java.lang.Long create(TSgGstProducerConfig entity) throws GenericException;
  
  public void update(TSgGstProducerConfig entity) throws GenericException;
  
  public void remove( java.lang.Long gstProducerRuleId ) throws GenericException;
  
  public TSgGstProducerConfig load( java.lang.Long gstProducerRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public TSgGstProducerConfig fillEntity(ResultSet rs) throws SQLException;
  
  public int getSequenceID() throws SQLException, ClassNotFoundException;
  
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}