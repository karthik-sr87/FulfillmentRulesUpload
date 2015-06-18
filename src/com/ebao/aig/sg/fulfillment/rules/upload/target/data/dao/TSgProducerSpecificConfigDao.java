package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgProducerSpecificConfig;
import com.ebao.pub.framework.GenericException;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface TSgProducerSpecificConfigDao {
  public java.lang.Long create(TSgProducerSpecificConfig entity) throws GenericException;
  
  public void update(TSgProducerSpecificConfig entity) throws GenericException;
   
  public void remove( java.lang.Long producerRuleId ) throws GenericException;
  
  public TSgProducerSpecificConfig load( java.lang.Long producerRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public TSgProducerSpecificConfig fillEntity(ResultSet rs) throws SQLException;


///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}