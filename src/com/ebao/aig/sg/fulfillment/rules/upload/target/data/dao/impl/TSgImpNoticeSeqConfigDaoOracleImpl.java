package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgImpNoticeSeqConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgImpNoticeSeqConfig;
import com.ebao.foundation.common.config.Env;
import com.ebao.gs.pub.util.HibernateUtil;
import com.ebao.pub.framework.AppContext;
import com.ebao.pub.framework.ExceptionFactory;
import com.ebao.pub.framework.GenericException;
import com.ebao.pub.framework.data.internal.OracleSequencePKGenerator;
import com.ebao.pub.util.DBean;
import com.ebao.pub.util.Log;


public class TSgImpNoticeSeqConfigDaoOracleImpl implements TSgImpNoticeSeqConfigDao{
  private static String table;
  private static HashMap columns = new HashMap();
  private static HashMap columnTypes = new HashMap();
  protected String getTable() {
    return table;
  }
  protected HashMap getColumns() {
    return columns;
  }
  protected HashMap getColumnTypes() {
    return columnTypes;
  }

  static {
      table = "T_SG_IMP_NOTICE_SEQ_CONFIG";
      columns.put("seqListId", "SEQ_LIST_ID");
      columnTypes.put("seqListId", "java.lang.Long");
      columns.put("impNoticeId", "IMP_NOTICE_ID");
      columnTypes.put("impNoticeId", "java.lang.Long");
      columns.put("impNoticeLetterId", "IMP_NOTICE_LETTER_ID");
      columnTypes.put("impNoticeLetterId", "java.lang.Long");
      columns.put("sequenceValue", "SEQUENCE_VALUE");
      columnTypes.put("sequenceValue", "java.lang.Integer");
      columns.put("insertionEffDate", "INSERTION_EFF_DATE");
      columnTypes.put("insertionEffDate", "java.util.Date");
      columns.put("insertionExpDate", "INSERTION_EXP_DATE");
      columnTypes.put("insertionExpDate", "java.util.Date");
      columns.put("insertTime", "INSERT_TIME");
      columnTypes.put("insertTime", "java.util.Date");
      columns.put("updateTime", "UPDATE_TIME");
      columnTypes.put("updateTime", "java.util.Date");
      columns.put("insertedBy", "INSERTED_BY");
      columnTypes.put("insertedBy", "java.lang.Long");
      columns.put("updatedBy", "UPDATED_BY");
      columnTypes.put("updatedBy", "java.lang.Long");
  }

  protected Object fillObject(ResultSet rs) throws SQLException {
    return fillEntity(rs);
  }
  
  public TSgImpNoticeSeqConfig fillEntity(ResultSet rs) throws SQLException {
      TSgImpNoticeSeqConfig entity = new TSgImpNoticeSeqConfig();
      entity.setSeqListId(new Long(rs.getLong("SEQ_LIST_ID")));
      if (rs.wasNull()) {
          entity.setSeqListId(null);
      }
      entity.setImpNoticeId(rs.getLong("IMP_NOTICE_ID"));
      entity.setImpNoticeLetterId(rs.getLong("IMP_NOTICE_LETTER_ID"));
      entity.setSequenceValue(rs.getInt("SEQUENCE_VALUE"));
      if (rs.wasNull()) {
          entity.setSequenceValue(null);
      }
      entity.setInsertionEffDate(rs.getTimestamp("INSERTION_EFF_DATE"));
      entity.setInsertionExpDate(rs.getTimestamp("INSERTION_EXP_DATE"));
      entity.setInsertTime(rs.getTimestamp("INSERT_TIME"));
      entity.setUpdateTime(rs.getTimestamp("UPDATE_TIME"));
      entity.setInsertedBy(new Long(rs.getLong("INSERTED_BY")));
      if (rs.wasNull()) {
          entity.setInsertedBy(null);
      }
      entity.setUpdatedBy(new Long(rs.getLong("UPDATED_BY")));
      if (rs.wasNull()) {
          entity.setUpdatedBy(null);
      }
      return entity;
  }
  
  public java.lang.Long create(TSgImpNoticeSeqConfig entity) throws GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       java.lang.Long id;
       try {
         Session session = HibernateUtil.currentSession();
         Serializable key = session.save(entity);
	 session.flush();
         id = new java.lang.Long(key.toString());
       } 
       catch(HibernateException e) {
         throw ExceptionFactory.parse(e);
       }
       finally {
          try {
	    HibernateUtil.closeSession();
	  }
	  catch(HibernateException e) {
	    throw ExceptionFactory.parse(e);
	  } 
      }
       return id;
     }
      //set sequence primary key
if ( entity.getSeqListId() == null || entity.getSeqListId().longValue()<=0 ) {
      entity.setSeqListId(OracleSequencePKGenerator.getInstance().getNextPKValue("S_SG_IMP_NOTICE_SEQ_CONFIG__SE"));
}
      DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into T_SG_IMP_NOTICE_SEQ_CONFIG(");
	buf.append("SEQ_LIST_ID");
	buf.append(",IMP_NOTICE_ID");
	buf.append(",IMP_NOTICE_LETTER_ID");
	buf.append(",SEQUENCE_VALUE");
	buf.append(",INSERTION_EFF_DATE");
	buf.append(",INSERTION_EXP_DATE");
	buf.append(",INSERT_TIME");
	buf.append(",UPDATE_TIME");
	buf.append(",INSERTED_BY");
	buf.append(",UPDATED_BY");
	buf.append(")");
	buf.append(" values(");
    for (int i=0; i<10; i++) {
	  buf.append(i==0 ? "?" : ",?");
	}
	buf.append(")");
	Log.debug(TSgImpNoticeSeqConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getSeqListId() != null) ps.setLong(pos++, entity.getSeqListId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgImpNoticeSeqConfigDao.class, "seqListId:" + entity.getSeqListId());
	  ps.setLong(pos++, entity.getImpNoticeId());
	  Log.debug(TSgImpNoticeSeqConfigDao.class, "impNoticeId:" + entity.getImpNoticeId());
	  ps.setLong(pos++, entity.getImpNoticeLetterId());
	  Log.debug(TSgImpNoticeSeqConfigDao.class, "impNoticeLetterId:" + entity.getImpNoticeLetterId());
	  if(entity.getSequenceValue() != null) ps.setInt(pos++, entity.getSequenceValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgImpNoticeSeqConfigDao.class, "sequenceValue:" + entity.getSequenceValue());
	  ps.setTimestamp(pos++, entity.getInsertionEffDate() != null ? new java.sql.Timestamp(entity.getInsertionEffDate().getTime()) : null);
	  Log.debug(TSgImpNoticeSeqConfigDao.class, "insertionEffDate:" + entity.getInsertionEffDate());
	  ps.setTimestamp(pos++, entity.getInsertionExpDate() != null ? new java.sql.Timestamp(entity.getInsertionExpDate().getTime()) : null);
	  Log.debug(TSgImpNoticeSeqConfigDao.class, "insertionExpDate:" + entity.getInsertionExpDate());
	  ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  Log.debug(TSgImpNoticeSeqConfigDao.class, "insertTime:" + entity.getInsertTime());
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  Log.debug(TSgImpNoticeSeqConfigDao.class, "updateTime:" + entity.getUpdateTime());
	  //if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if (entity.getInsertedBy() != null)
          ps.setLong(pos++, entity.getInsertedBy().longValue());
        else
          ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  Log.debug(TSgImpNoticeSeqConfigDao.class, "insertedBy:" + entity.getInsertedBy());
	 // if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if (entity.getUpdatedBy() != null)
          ps.setLong(pos++, entity.getUpdatedBy().longValue());
        else
          ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  Log.debug(TSgImpNoticeSeqConfigDao.class, "updatedBy:" + entity.getUpdatedBy());
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}
    return entity.getSeqListId();
  }
  
  public void update(TSgImpNoticeSeqConfig entity) throws GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       try {
         Session session = HibernateUtil.currentSession();
         session.merge(entity);
	 session.flush();
       }
       catch(HibernateException e) {
         throw ExceptionFactory.parse(e);
       }
       finally {
          try {
	    HibernateUtil.closeSession();
	  }
	  catch(HibernateException e) {
	    throw ExceptionFactory.parse(e);
	  } 
      }
       return;
    }
    DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("update T_SG_IMP_NOTICE_SEQ_CONFIG set ");
	buf.append("SEQ_LIST_ID=?");
	buf.append(",IMP_NOTICE_ID=?");
	buf.append(",IMP_NOTICE_LETTER_ID=?");
	buf.append(",SEQUENCE_VALUE=?");
	buf.append(",INSERTION_EFF_DATE=?");
	buf.append(",INSERTION_EXP_DATE=?");
	//buf.append(",INSERT_TIME=?");
	buf.append(",UPDATE_TIME=?");
	//buf.append(",INSERTED_BY=?");
	buf.append(",UPDATED_BY=?");
	buf.append(" where 1 = 1");
	buf.append("   and SEQ_LIST_ID = ?");
	Log.debug(TSgImpNoticeSeqConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getSeqListId() != null) ps.setLong(pos++, entity.getSeqListId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setLong(pos++, entity.getImpNoticeId());
	  ps.setLong(pos++, entity.getImpNoticeLetterId());
	  if(entity.getSequenceValue() != null) ps.setInt(pos++, entity.getSequenceValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setTimestamp(pos++, entity.getInsertionEffDate() != null ? new java.sql.Timestamp(entity.getInsertionEffDate().getTime()) : null);
	  ps.setTimestamp(pos++, entity.getInsertionExpDate() != null ? new java.sql.Timestamp(entity.getInsertionExpDate().getTime()) : null);
	  //ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  //if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	 // if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  if(entity.getSeqListId() != null) ps.setLong(pos++, entity.getSeqListId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public void remove( java.lang.Long seqListId ) throws GenericException{
	
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       TSgImpNoticeSeqConfig entity = null;
       try {
          Session session = HibernateUtil.currentSession();
          entity = this.load( seqListId );
	  if(entity==null) {
      	     return;
          }
          session.delete(entity);
	  session.flush();
       }
       catch(HibernateException e) {
         throw ExceptionFactory.parse(e);
       }
       finally {
          try {
	    HibernateUtil.closeSession();
	  }
	  catch(HibernateException e) {
	    throw ExceptionFactory.parse(e);
	  } 
      }
       return;
    }
    DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("delete from T_SG_IMP_NOTICE_SEQ_CONFIG");
	buf.append(" where 1 = 1");
	buf.append("   and SEQ_LIST_ID = ?");
	Log.debug(TSgImpNoticeSeqConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
	
      int pos = 1;
	  if(seqListId != null) ps.setLong(pos++, seqListId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public TSgImpNoticeSeqConfig load( java.lang.Long seqListId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
          if(seqListId==null) {
	    return null;
	  }
          Serializable sId = seqListId;
	  o = session.load(TSgImpNoticeSeqConfig.class,sId);
       } 
       catch(org.hibernate.ObjectNotFoundException e) {
    	  //throw new com.ebao.pub.framework.ObjectNotFoundException(e.getMessage());
       }
       catch(HibernateException e) {
         throw ExceptionFactory.parse(e);
       }
       finally {
          try {
	    HibernateUtil.closeSession();
	  }
	  catch(HibernateException e) {
	    throw ExceptionFactory.parse(e);
	  } 
      }
       if(o==null) {
         return null;
       }
       return (TSgImpNoticeSeqConfig)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from T_SG_IMP_NOTICE_SEQ_CONFIG ");
	buf.append(" where 1=1 ");
	buf.append("   and SEQ_LIST_ID = ? ");
	Log.debug(TSgImpNoticeSeqConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());	 
      int pos = 1;
	  if(seqListId != null) ps.setLong(pos++, seqListId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
      TSgImpNoticeSeqConfig entity = null;
	  if(rs.next()) {
	    entity = fillEntity(rs);
	  }
      return entity;
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(rs, ps, db);
	}
  }
  
  
  public int getImpSequenceId() throws SQLException,ClassNotFoundException 
	{
		DBean db = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    int impSerialId = 0;
		try{ 
			StringBuffer selectQuery = new StringBuffer();
			selectQuery.append("SELECT max(SEQ_LIST_ID) AS SERIAL_ID FROM T_SG_IMP_NOTICE_SEQ_CONFIG");
		db = new DBean(false);
		db.connect();
		Connection con = db.getConnection();
		ps = con.prepareStatement(selectQuery.toString());
		rs = ps.executeQuery();
		while (rs.next()) {
			impSerialId = rs.getInt("SERIAL_ID");		
		}
	}
	catch (ClassNotFoundException ex) {
    throw ex;
  } 
	catch (SQLException sql) {
	      throw sql;
	    } 
		finally {
	      DBean.closeAll(rs, ps, db);
	    }
		return impSerialId+1;
	}
  
  public  Collection getImpSeqList(Long impNoticeId) throws Exception{//AigImpNoticeListDataTableVO
	
	  DBean db = null;
	  PreparedStatement ps = null;
	  ResultSet rs = null;
	  List impList=new ArrayList();
	  try{ 
	  	StringBuffer selectQuery = new StringBuffer();
	  	selectQuery.append("select SEQ_LIST_ID,IMP_NOTICE_LETTER_ID,SEQUENCE_VALUE,"
	  	+ "INSERTION_EFF_DATE,INSERTION_EXP_DATE from T_SG_IMP_NOTICE_SEQ_CONFIG where 1=1");
	  	selectQuery.append(" and IMP_NOTICE_ID= ? ");
	  	selectQuery.append(" order by SEQ_LIST_ID ");
	  	db = new DBean(false);
	  	db.connect();
	  	Connection con = db.getConnection();
	  	ps = con.prepareStatement(selectQuery.toString());
	  	ps.setLong(1, impNoticeId);
	  	rs = ps.executeQuery();
	  	while (rs.next()) {
	  		TSgImpNoticeSeqConfig info = new TSgImpNoticeSeqConfig();
	  		info.setSeqListId(rs.getLong("SEQ_LIST_ID"));
	 		info.setImpNoticeLetterId(rs.getLong("IMP_NOTICE_LETTER_ID"));
	  		info.setSequenceValue(rs.getInt("SEQUENCE_VALUE"));
	  		info.setInsertionEffDate(rs.getDate("INSERTION_EFF_DATE"));
	  		info.setInsertionExpDate(rs.getDate("INSERTION_EXP_DATE"));
	  		impList.add(info);
	  	}
	  }
	  catch (ClassNotFoundException ex) {
	  	throw ex;
	  } 
	  catch (SQLException sql) {
	  	throw sql;
	  } 
	  finally {
	  	DBean.closeAll(rs, ps, db);
	  }
	  return  impList;
  }
}