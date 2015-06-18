package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgDocStaticContentConfig;
import com.ebao.pub.framework.GenericException;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface TSgDocStaticContentConfigDao {
  public java.lang.Long create(TSgDocStaticContentConfig entity) throws GenericException;
  
  public void update(TSgDocStaticContentConfig entity) throws GenericException;
  
  public void remove( java.lang.Long staticContentId ) throws GenericException;
  
  public TSgDocStaticContentConfig load( java.lang.Long staticContentId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public TSgDocStaticContentConfig fillEntity(ResultSet rs) throws SQLException;
  
  public int getSequenceID() throws SQLException, ClassNotFoundException;
  
    
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}