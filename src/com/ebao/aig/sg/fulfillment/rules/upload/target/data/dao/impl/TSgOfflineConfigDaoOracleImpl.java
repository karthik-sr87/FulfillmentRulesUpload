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

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgOfflineConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgOfflineConfig;
import com.ebao.foundation.common.config.Env;
import com.ebao.gs.pub.util.HibernateUtil;
import com.ebao.pub.framework.AppContext;
import com.ebao.pub.framework.ExceptionFactory;
import com.ebao.pub.framework.GenericException;
import com.ebao.pub.framework.data.internal.OracleSequencePKGenerator;
import com.ebao.pub.util.DBean;
import com.ebao.pub.util.Log;

public class TSgOfflineConfigDaoOracleImpl implements TSgOfflineConfigDao{
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
      table = "T_SG_OFFLINE_CONFIG";
      columns.put("ruleId", "RULE_ID");
      columnTypes.put("ruleId", "java.lang.Long");
      columns.put("offlineRuleId", "OFFLINE_RULE_ID");
      columnTypes.put("offlineRuleId", "java.lang.Long");
      columns.put("documentClubType", "DOCUMENT_CLUB_TYPE");
      columnTypes.put("documentClubType", "java.lang.Integer");
      columns.put("envelope", "ENVELOPE");
      columnTypes.put("envelope", "java.lang.Integer");
      columns.put("colour", "COLOUR");
      columnTypes.put("colour", "java.lang.Integer");
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
  
  public TSgOfflineConfig fillEntity(ResultSet rs) throws SQLException {
      TSgOfflineConfig entity = new TSgOfflineConfig();
      entity.setRuleId(new Long(rs.getLong("RULE_ID")));
      if (rs.wasNull()) {
          entity.setRuleId(null);
      }
      entity.setOfflineRuleId(new Long(rs.getLong("OFFLINE_RULE_ID")));
      if (rs.wasNull()) {
          entity.setOfflineRuleId(null);
      }
      entity.setDocumentClubType(new Integer(rs.getInt("DOCUMENT_CLUB_TYPE")));
      if (rs.wasNull()) {
          entity.setDocumentClubType(null);
      }
      entity.setEnvelope(new Integer(rs.getInt("ENVELOPE")));
      if (rs.wasNull()) {
          entity.setEnvelope(null);
      }
      entity.setColour(new Integer(rs.getInt("COLOUR")));
      if (rs.wasNull()) {
          entity.setColour(null);
      }
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
  
  public java.lang.Long create(TSgOfflineConfig entity) throws GenericException{
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
if ( entity.getOfflineRuleId() == null || entity.getOfflineRuleId().longValue()<=0 ) {
      entity.setOfflineRuleId(OracleSequencePKGenerator.getInstance().getNextPKValue("S_SG_OFFLINE_CONFIG__OFFLINE_R"));
}
      DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into T_SG_OFFLINE_CONFIG(");
	buf.append("RULE_ID");
	buf.append(",OFFLINE_RULE_ID");
	buf.append(",DOCUMENT_CLUB_TYPE");
	buf.append(",ENVELOPE");
	buf.append(",COLOUR");
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
	Log.debug(TSgOfflineConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgOfflineConfigDao.class, "ruleId:" + entity.getRuleId());
	  if(entity.getOfflineRuleId() != null) ps.setLong(pos++, entity.getOfflineRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgOfflineConfigDao.class, "offlineRuleId:" + entity.getOfflineRuleId());
	  if(entity.getDocumentClubType() != null) ps.setInt(pos++, entity.getDocumentClubType().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgOfflineConfigDao.class, "documentClubType:" + entity.getDocumentClubType());
	  if(entity.getEnvelope() != null) ps.setInt(pos++, entity.getEnvelope().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgOfflineConfigDao.class, "envelope:" + entity.getEnvelope());
	  if(entity.getColour() != null) ps.setInt(pos++, entity.getColour().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgOfflineConfigDao.class, "colour:" + entity.getColour());
	  ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  Log.debug(TSgOfflineConfigDao.class, "insertTime:" + entity.getInsertTime());
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  Log.debug(TSgOfflineConfigDao.class, "updateTime:" + entity.getUpdateTime());
	  //if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if (entity.getInsertedBy() != null)
	         ps.setLong(pos++, entity.getInsertedBy().longValue());
	       else
	         ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  Log.debug(TSgOfflineConfigDao.class, "insertedBy:" + entity.getInsertedBy());
	  //if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if (entity.getUpdatedBy() != null)
	         ps.setLong(pos++, entity.getUpdatedBy().longValue());
	       else
	         ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  Log.debug(TSgOfflineConfigDao.class, "updatedBy:" + entity.getUpdatedBy());
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}
    return entity.getOfflineRuleId();
  }
  
  public void update(TSgOfflineConfig entity) throws GenericException{
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
	buf.append("update T_SG_OFFLINE_CONFIG set ");
	buf.append("RULE_ID=?");
	buf.append(",OFFLINE_RULE_ID=?");
	buf.append(",DOCUMENT_CLUB_TYPE=?");
	buf.append(",ENVELOPE=?");
	buf.append(",COLOUR=?");
	//buf.append(",INSERT_TIME=?");
	buf.append(",UPDATE_TIME=?");
	//buf.append(",INSERTED_BY=?");
	buf.append(",UPDATED_BY=?");
	buf.append(" where 1 = 1");
	buf.append("   and OFFLINE_RULE_ID = ?");
	Log.debug(TSgOfflineConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getOfflineRuleId() != null) ps.setLong(pos++, entity.getOfflineRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getDocumentClubType() != null) ps.setInt(pos++, entity.getDocumentClubType().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getEnvelope() != null) ps.setInt(pos++, entity.getEnvelope().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getColour() != null) ps.setInt(pos++, entity.getColour().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	 // ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	 // if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  //if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  if(entity.getOfflineRuleId() != null) ps.setLong(pos++, entity.getOfflineRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public void remove( java.lang.Long offlineRuleId ) throws GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       TSgOfflineConfig entity = null;
       try {
          Session session = HibernateUtil.currentSession();
          entity = this.load( offlineRuleId );
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
	PreparedStatement ps1 = null;
	StringBuffer buf = new StringBuffer();
	buf.append("delete from T_SG_INSERT_MAPPING_CONFIG");
	buf.append(" where 1 = 1");
	buf.append("   and OFFLINE_RULE_ID = ?");
	StringBuffer buf1 = new StringBuffer();
	buf1.append("delete from T_SG_OFFLINE_CONFIG");
	buf1.append(" where 1 = 1");
	buf1.append("   and OFFLINE_RULE_ID = ?");
	Log.debug(TSgOfflineConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
	  ps1 = con.prepareStatement(buf1.toString());
	  ps.setLong(1, offlineRuleId.longValue());
      ps1.setLong(1, offlineRuleId.longValue());
      ps.executeUpdate();
	  ps1.executeUpdate();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	  DBean.closeAll(null, ps1, db);
	}  
  }
  
  public TSgOfflineConfig load( java.lang.Long offlineRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
          if(offlineRuleId==null) {
	    return null;
	  }
          Serializable sId = offlineRuleId;
	  o = session.load(TSgOfflineConfig.class,sId);
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
       return (TSgOfflineConfig)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from T_SG_OFFLINE_CONFIG ");
	buf.append(" where 1=1 ");
	buf.append("   and OFFLINE_RULE_ID = ?");
	Log.debug(TSgOfflineConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(offlineRuleId != null) ps.setLong(pos++, offlineRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
      TSgOfflineConfig entity = null;
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