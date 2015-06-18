

package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgEmailContentConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgEmailContentConfig;
import com.ebao.foundation.common.config.Env;
import com.ebao.gs.pub.util.HibernateUtil;
import com.ebao.pub.framework.AppContext;
import com.ebao.pub.framework.ExceptionFactory;
import com.ebao.pub.framework.GenericException;
import com.ebao.pub.framework.data.internal.OracleSequencePKGenerator;
import com.ebao.pub.util.DBean;
import com.ebao.pub.util.Log;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public class TSgEmailContentConfigDaoOracleImpl implements TSgEmailContentConfigDao{
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
      table = "T_SG_EMAIL_CONTENT_CONFIG";
      columns.put("emailId", "EMAIL_ID");
      columnTypes.put("emailId", "java.lang.Long");
      columns.put("emailCode", "EMAIL_CODE");
      columnTypes.put("emailCode", "java.lang.String");
      columns.put("emailName", "EMAIL_NAME");
      columnTypes.put("emailName", "java.lang.String");
      columns.put("recipient", "RECIPIENT");
      columnTypes.put("recipient", "java.lang.Integer");
      columns.put("emailContent", "EMAIL_CONTENT");
      columnTypes.put("emailContent", "java.lang.String");
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
  
  public TSgEmailContentConfig fillEntity(ResultSet rs) throws SQLException {
      TSgEmailContentConfig entity = new TSgEmailContentConfig();
      entity.setEmailId(new Long(rs.getLong("EMAIL_ID")));
      if (rs.wasNull()) {
          entity.setEmailId(null);
      }
      entity.setEmailCode(rs.getString("EMAIL_CODE"));
      entity.setEmailName(rs.getString("EMAIL_NAME"));
      entity.setRecipient(new Integer(rs.getInt("RECIPIENT")));
      if (rs.wasNull()) {
          entity.setRecipient(null);
      }
      entity.setEmailContent(rs.getString("EMAIL_CONTENT"));
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
  
  public java.lang.Long create(TSgEmailContentConfig entity) throws GenericException{
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
if ( entity.getEmailId() == null || entity.getEmailId().longValue()<=0 ) {
      entity.setEmailId(OracleSequencePKGenerator.getInstance().getNextPKValue("S_SG_EMAIL_CONTENT_CONFIG__EMA"));
}
      DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into T_SG_EMAIL_CONTENT_CONFIG(");
	buf.append("EMAIL_ID");
	buf.append(",EMAIL_CODE");
	buf.append(",EMAIL_NAME");
	buf.append(",RECIPIENT");
	buf.append(",EMAIL_CONTENT");
	buf.append(",INSERT_TIME");
	buf.append(",UPDATE_TIME");
	buf.append(",INSERTED_BY");
	buf.append(",UPDATED_BY");
	buf.append(")");
	buf.append(" values(");
    for (int i=0; i<9; i++) {
	  buf.append(i==0 ? "?" : ",?");
	}
	buf.append(")");
	Log.debug(TSgEmailContentConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getEmailId() != null) ps.setLong(pos++, entity.getEmailId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgEmailContentConfigDao.class, "emailId:" + entity.getEmailId());
	  ps.setString(pos++, entity.getEmailCode());
	  Log.debug(TSgEmailContentConfigDao.class, "emailCode:" + entity.getEmailCode());
	  ps.setString(pos++, entity.getEmailName());
	  Log.debug(TSgEmailContentConfigDao.class, "emailName:" + entity.getEmailName());
	  if(entity.getRecipient() != null) ps.setInt(pos++, entity.getRecipient().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgEmailContentConfigDao.class, "recipient:" + entity.getRecipient());
	  ps.setString(pos++, entity.getEmailContent());
	  Log.debug(TSgEmailContentConfigDao.class, "emailContent:" + entity.getEmailContent());
	  ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  Log.debug(TSgEmailContentConfigDao.class, "insertTime:" + entity.getInsertTime());
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  Log.debug(TSgEmailContentConfigDao.class, "updateTime:" + entity.getUpdateTime());
	  //if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if (entity.getInsertedBy() != null)
	         ps.setLong(pos++, entity.getInsertedBy().longValue());
	       else
	         ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  Log.debug(TSgEmailContentConfigDao.class, "insertedBy:" + entity.getInsertedBy());
	  //if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if (entity.getUpdatedBy() != null)
	         ps.setLong(pos++, entity.getUpdatedBy().longValue());
	       else
	         ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  Log.debug(TSgEmailContentConfigDao.class, "updatedBy:" + entity.getUpdatedBy());
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}
    return entity.getEmailId();
  }
  
  public void update(TSgEmailContentConfig entity) throws GenericException{
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
	buf.append("update T_SG_EMAIL_CONTENT_CONFIG set ");
	buf.append("EMAIL_ID=?");
	buf.append(",EMAIL_CODE=?");
	buf.append(",EMAIL_NAME=?");
	buf.append(",RECIPIENT=?");
	buf.append(",EMAIL_CONTENT=?");
	//buf.append(",INSERT_TIME=?");
	buf.append(",UPDATE_TIME=?");
	//buf.append(",INSERTED_BY=?");
	buf.append(",UPDATED_BY=?");
	buf.append(" where 1 = 1");
	buf.append("   and EMAIL_ID = ?");
	Log.debug(TSgEmailContentConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getEmailId() != null) ps.setLong(pos++, entity.getEmailId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setString(pos++, entity.getEmailCode());
	  ps.setString(pos++, entity.getEmailName());
	  if(entity.getRecipient() != null) ps.setInt(pos++, entity.getRecipient().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setString(pos++, entity.getEmailContent());
	  //ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  //if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  //if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  if(entity.getEmailId() != null) ps.setLong(pos++, entity.getEmailId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public void remove( java.lang.Long emailId ) throws GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       TSgEmailContentConfig entity = null;
       try {
          Session session = HibernateUtil.currentSession();
          entity = this.load( emailId );
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
	buf.append("delete from T_SG_EMAIL_CONTENT_CONFIG");
	buf.append(" where 1 = 1");
	buf.append("   and EMAIL_ID = ?");
	Log.debug(TSgEmailContentConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(emailId != null) ps.setLong(pos++, emailId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public TSgEmailContentConfig load( java.lang.Long emailId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
          if(emailId==null) {
	    return null;
	  }
          Serializable sId = emailId;
	  o = session.load(TSgEmailContentConfig.class,sId);
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
       return (TSgEmailContentConfig)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from T_SG_EMAIL_CONTENT_CONFIG ");
	buf.append(" where 1=1 ");
	buf.append("   and EMAIL_ID = ?");
	Log.debug(TSgEmailContentConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(emailId != null) ps.setLong(pos++, emailId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
      TSgEmailContentConfig entity = null;
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
}
