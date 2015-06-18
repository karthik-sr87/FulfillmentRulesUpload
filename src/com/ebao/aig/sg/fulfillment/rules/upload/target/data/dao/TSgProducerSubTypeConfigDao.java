package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgProducerSubTypeConfig;
import com.ebao.pub.framework.GenericException;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface TSgProducerSubTypeConfigDao {
	 /*public Long create(TSgProducerSubTypeConfig entity) throws GenericException;
	  
	  public void update(TSgProducerSubTypeConfig entity) throws GenericException;
	  
	  public void remove(java.lang.Long producerListId) throws GenericException;
	  
	  public TSgProducerSubTypeConfig load(java.lang.Long pdcrExcpRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
	  
	  public TSgProducerSubTypeConfig fillEntity(ResultSet rs) throws SQLException;
	  public Collection getProducerList(String condition, List sqlParams,AgentPageUtil page) throws Exception;*/
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////


	 public java.lang.Long create(TSgProducerSubTypeConfig entity) throws GenericException;
	  
	  public void update(TSgProducerSubTypeConfig entity) throws GenericException;
	  
	  public void remove( java.lang.Long producerListId ) throws GenericException;
	  
	  public TSgProducerSubTypeConfig load( java.lang.Long producerListId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
	  
	  public TSgProducerSubTypeConfig fillEntity(ResultSet rs) throws SQLException;
	  
	  public int getSequenceID() throws SQLException, ClassNotFoundException;


}