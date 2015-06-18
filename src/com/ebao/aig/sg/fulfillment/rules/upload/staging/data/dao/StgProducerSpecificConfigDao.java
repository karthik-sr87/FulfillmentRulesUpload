package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgProducerSpecificConfig;
import com.ebao.pub.framework.GenericException;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface StgProducerSpecificConfigDao {
  public java.lang.Long create(StgProducerSpecificConfig entity) throws GenericException;
  
  public void update(StgProducerSpecificConfig entity) throws GenericException;
  
  public void remove( java.lang.Long producerRuleId ) throws GenericException;
  
  public StgProducerSpecificConfig load( java.lang.Long producerRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public StgProducerSpecificConfig fillEntity(ResultSet rs) throws SQLException;
  
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}