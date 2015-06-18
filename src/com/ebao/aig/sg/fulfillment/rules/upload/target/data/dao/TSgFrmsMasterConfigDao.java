package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgFrmsMasterConfig;
import com.ebao.pub.framework.GenericException;

public interface TSgFrmsMasterConfigDao {

	  public java.lang.Long create(TSgFrmsMasterConfig entity) throws GenericException;
	  
	  public void update(TSgFrmsMasterConfig entity) throws GenericException;
	  
	  public void remove( java.lang.Long ruleId ) throws GenericException;
	  
	  public TSgFrmsMasterConfig load( java.lang.Long ruleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
	  
	  public TSgFrmsMasterConfig fillEntity(ResultSet rs) throws SQLException;
	  
	///////////////ManualMethodBegin///////////////
	///////////////ManualMethodEnd///////////////
	public Long getSequenceID() throws SQLException, ClassNotFoundException;

	public void updateOnFinalSubmit(TSgFrmsMasterConfig masterConfigVO) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;

}
