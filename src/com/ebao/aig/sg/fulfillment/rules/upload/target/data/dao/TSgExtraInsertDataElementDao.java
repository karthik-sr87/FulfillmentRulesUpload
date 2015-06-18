package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgExtraInsertDataElement;
import com.ebao.pub.framework.GenericException;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface TSgExtraInsertDataElementDao {
  public java.lang.Long create(TSgExtraInsertDataElement entity) throws GenericException;
  
  public void update(TSgExtraInsertDataElement entity) throws GenericException;
  
  public void remove( java.lang.Long listId ) throws GenericException;
  
  public TSgExtraInsertDataElement load( java.lang.Long listId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public TSgExtraInsertDataElement fillEntity(ResultSet rs) throws SQLException;

public Collection<TSgExtraInsertDataElement> getdataelementlist(Long extraInsertId)
		throws Exception;
  
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}