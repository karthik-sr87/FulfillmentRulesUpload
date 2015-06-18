

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

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgExtraInsertConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgExtraInsertConfig;
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

public class TSgExtraInsertConfigDaoOracleImpl implements TSgExtraInsertConfigDao{
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
      table = "T_SG_EXTRA_INSERT_CONFIG";
      columns.put("extraInsertId", "EXTRA_INSERT_ID");
      columnTypes.put("extraInsertId", "java.lang.Long");
      columns.put("extraInsertCode", "EXTRA_INSERT_CODE");
      columnTypes.put("extraInsertCode", "java.lang.String");
      columns.put("extraInsertName", "EXTRA_INSERT_NAME");
      columnTypes.put("extraInsertName", "java.lang.String");
      columns.put("effectiveDate", "EFFECTIVE_DATE");
      columnTypes.put("effectiveDate", "java.util.Date");
      columns.put("expiryDate", "EXPIRY_DATE");
      columnTypes.put("expiryDate", "java.util.Date");
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
  
  public TSgExtraInsertConfig fillEntity(ResultSet rs) throws SQLException {
      TSgExtraInsertConfig entity = new TSgExtraInsertConfig();
      entity.setExtraInsertId(new Long(rs.getLong("EXTRA_INSERT_ID")));
      if (rs.wasNull()) {
          entity.setExtraInsertId(null);
      }
      entity.setExtraInsertCode(rs.getString("EXTRA_INSERT_CODE"));
      entity.setExtraInsertName(rs.getString("EXTRA_INSERT_NAME"));
      entity.setEffectiveDate(rs.getTimestamp("EFFECTIVE_DATE"));
      entity.setExpiryDate(rs.getTimestamp("EXPIRY_DATE"));
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
  
  public java.lang.Long create(TSgExtraInsertConfig entity) throws GenericException{
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
if ( entity.getExtraInsertId() == null || entity.getExtraInsertId().longValue()<=0 ) {
      entity.setExtraInsertId(OracleSequencePKGenerator.getInstance().getNextPKValue("S_SG_EXTRA_INSERT_CONFIG__EXTR"));
}
      DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into T_SG_EXTRA_INSERT_CONFIG(");
	buf.append("EXTRA_INSERT_ID");
	buf.append(",EXTRA_INSERT_CODE");
	buf.append(",EXTRA_INSERT_NAME");
	buf.append(",EFFECTIVE_DATE");
	buf.append(",EXPIRY_DATE");
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
	Log.debug(TSgExtraInsertConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getExtraInsertId() != null) ps.setLong(pos++, entity.getExtraInsertId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgExtraInsertConfigDao.class, "extraInsertId:" + entity.getExtraInsertId());
	  ps.setString(pos++, entity.getExtraInsertCode());
	  Log.debug(TSgExtraInsertConfigDao.class, "extraInsertCode:" + entity.getExtraInsertCode());
	  ps.setString(pos++, entity.getExtraInsertName());
	  Log.debug(TSgExtraInsertConfigDao.class, "extraInsertName:" + entity.getExtraInsertName());
	  ps.setTimestamp(pos++, entity.getEffectiveDate() != null ? new java.sql.Timestamp(entity.getEffectiveDate().getTime()) : null);
	  Log.debug(TSgExtraInsertConfigDao.class, "effectiveDate:" + entity.getEffectiveDate());
	  ps.setTimestamp(pos++, entity.getExpiryDate() != null ? new java.sql.Timestamp(entity.getExpiryDate().getTime()) : null);
	  Log.debug(TSgExtraInsertConfigDao.class, "expiryDate:" + entity.getExpiryDate());
	  ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  Log.debug(TSgExtraInsertConfigDao.class, "insertTime:" + entity.getInsertTime());
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  Log.debug(TSgExtraInsertConfigDao.class, "updateTime:" + entity.getUpdateTime());
	  if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  Log.debug(TSgExtraInsertConfigDao.class, "insertedBy:" + entity.getInsertedBy());
	  if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  Log.debug(TSgExtraInsertConfigDao.class, "updatedBy:" + entity.getUpdatedBy());
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}
    return entity.getExtraInsertId();
  }
  
  public void update(TSgExtraInsertConfig entity) throws GenericException{
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
	buf.append("update T_SG_EXTRA_INSERT_CONFIG set ");
	buf.append("EXTRA_INSERT_ID=?");
	buf.append(",EXTRA_INSERT_CODE=?");
	buf.append(",EXTRA_INSERT_NAME=?");
	buf.append(",EFFECTIVE_DATE=?");
	buf.append(",EXPIRY_DATE=?");
	buf.append(",UPDATE_TIME=?");
	buf.append(",UPDATED_BY=?");
	buf.append(" where 1 = 1");
	buf.append("   and EXTRA_INSERT_ID = ?");
	Log.debug(TSgExtraInsertConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getExtraInsertId() != null) ps.setLong(pos++, entity.getExtraInsertId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setString(pos++, entity.getExtraInsertCode());
	  ps.setString(pos++, entity.getExtraInsertName());
	  ps.setTimestamp(pos++, entity.getEffectiveDate() != null ? new java.sql.Timestamp(entity.getEffectiveDate().getTime()) : null);
	  ps.setTimestamp(pos++, entity.getExpiryDate() != null ? new java.sql.Timestamp(entity.getExpiryDate().getTime()) : null);
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  if(entity.getExtraInsertId() != null) ps.setLong(pos++, entity.getExtraInsertId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public void remove( java.lang.Long extraInsertId ) throws GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       TSgExtraInsertConfig entity = null;
       try {
          Session session = HibernateUtil.currentSession();
          entity = this.load( extraInsertId );
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
	buf.append("delete from T_SG_EXTRA_INSERT_CONFIG");
	buf.append(" where 1 = 1");
	buf.append("   and EXTRA_INSERT_ID = ?");
	Log.debug(TSgExtraInsertConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(extraInsertId != null) ps.setLong(pos++, extraInsertId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public TSgExtraInsertConfig load( java.lang.Long extraInsertId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
          if(extraInsertId==null) {
	    return null;
	  }
          Serializable sId = extraInsertId;
	  o = session.load(TSgExtraInsertConfig.class,sId);
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
       return (TSgExtraInsertConfig)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from T_SG_EXTRA_INSERT_CONFIG ");
	buf.append(" where 1=1 ");
	buf.append("   and EXTRA_INSERT_ID = ?");
	Log.debug(TSgExtraInsertConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(extraInsertId != null) ps.setLong(pos++, extraInsertId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
      TSgExtraInsertConfig entity = null;
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
    
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}
