package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgImpNoticeSeqConfig;
import com.ebao.pub.framework.GenericException;


public interface TSgImpNoticeSeqConfigDao {
	 public java.lang.Long create(TSgImpNoticeSeqConfig entity) throws GenericException;
  
  public void update(TSgImpNoticeSeqConfig entity) throws GenericException;
  
  public void remove( java.lang.Long seqListId ) throws GenericException;
  
  public TSgImpNoticeSeqConfig load( java.lang.Long seqListId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public TSgImpNoticeSeqConfig fillEntity(ResultSet rs) throws SQLException;
  
  public  Collection getImpSeqList(Long impNoticeId) throws Exception;

}