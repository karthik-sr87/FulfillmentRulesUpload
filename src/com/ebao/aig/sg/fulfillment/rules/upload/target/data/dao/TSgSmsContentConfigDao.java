package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgSmsContentConfig;
import com.ebao.pub.framework.GenericException;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface TSgSmsContentConfigDao {
	  public Long create(TSgSmsContentConfig entity) throws GenericException;
	  
	  public void update(TSgSmsContentConfig entity) throws GenericException;
	  
	  public void remove( java.lang.Long smsId ) throws GenericException;
	  
	  public TSgSmsContentConfig load( java.lang.Long smsId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
	  
	  public TSgSmsContentConfig fillEntity(ResultSet rs) throws SQLException;
	  
	}
	 
	