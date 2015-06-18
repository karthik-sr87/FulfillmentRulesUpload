package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgDnmReplaceLetterConfig;
import com.ebao.pub.framework.GenericException;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface TSgDnmReplaceLetterConfigDao {
  public java.lang.Long create(TSgDnmReplaceLetterConfig entity) throws GenericException;
  
  public void update(TSgDnmReplaceLetterConfig configVO) throws GenericException;
  
  public void remove( java.lang.Long dnmReplId ) throws GenericException;
  
  public TSgDnmReplaceLetterConfig load( java.lang.Long dnmReplId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public TSgDnmReplaceLetterConfig fillEntity(ResultSet rs) throws SQLException;
  
  public int getSequenceID() throws SQLException, ClassNotFoundException;
  
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}
