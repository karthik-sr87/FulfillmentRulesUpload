package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao;

import java.sql.*;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgSmsEmailMappingConfig;
import com.ebao.pub.framework.*;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface StgSmsEmailMappingConfigDao {
  public void create(StgSmsEmailMappingConfig entity) throws GenericException;
  
  public void update(StgSmsEmailMappingConfig entity) throws GenericException;
  
  public void remove() throws GenericException;
  
  public StgSmsEmailMappingConfig load() throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public StgSmsEmailMappingConfig fillEntity(ResultSet rs) throws SQLException;
  
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}