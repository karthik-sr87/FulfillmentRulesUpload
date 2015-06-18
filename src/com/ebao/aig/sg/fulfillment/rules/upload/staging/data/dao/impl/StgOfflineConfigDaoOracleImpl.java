

package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.StgOfflineConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgOfflineConfig;
import com.ebao.foundation.common.config.Env;
import com.ebao.gs.pub.util.HibernateUtil;
import com.ebao.pub.framework.ExceptionFactory;
import com.ebao.pub.framework.GenericException;
import com.ebao.pub.framework.data.internal.OracleSequencePKGenerator;
import com.ebao.pub.util.DBean;
import com.ebao.pub.util.Log;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public class StgOfflineConfigDaoOracleImpl implements StgOfflineConfigDao{
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
      table = "STG_OFFLINE_CONFIG";
      columns.put("ruleId", "RULE_ID");
      columnTypes.put("ruleId", "java.lang.Long");
      columns.put("offlineRuleId", "OFFLINE_RULE_ID");
      columnTypes.put("offlineRuleId", "java.lang.Long");
      columns.put("documentClubType", "DOCUMENT_CLUB_TYPE");
      columnTypes.put("documentClubType", "java.lang.String");
      columns.put("envelope", "ENVELOPE");
      columnTypes.put("envelope", "java.lang.String");
      columns.put("colour", "COLOUR");
      columnTypes.put("colour", "java.lang.String");
  }

  protected Object fillObject(ResultSet rs) throws SQLException {
    return fillEntity(rs);
  }
  
  public StgOfflineConfig fillEntity(ResultSet rs) throws SQLException {
      StgOfflineConfig entity = new StgOfflineConfig();
      entity.setRuleId(new Long(rs.getLong("RULE_ID")));
      if (rs.wasNull()) {
          entity.setRuleId(null);
      }
      entity.setOfflineRuleId(new Long(rs.getLong("OFFLINE_RULE_ID")));
      if (rs.wasNull()) {
          entity.setOfflineRuleId(null);
      }
      entity.setDocumentClubType(rs.getString("DOCUMENT_CLUB_TYPE"));
      entity.setEnvelope(rs.getString("ENVELOPE"));
      entity.setColour(rs.getString("COLOUR"));
      return entity;
  }
  
  public java.lang.Long create(StgOfflineConfig entity) throws GenericException{
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
      entity.setOfflineRuleId(OracleSequencePKGenerator.getInstance().getNextPKValue("STG_OFFLINE_CONFIG__ID"));
}
      DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into STG_OFFLINE_CONFIG(");
	buf.append("RULE_ID");
	buf.append(",OFFLINE_RULE_ID");
	buf.append(",DOCUMENT_CLUB_TYPE");
	buf.append(",ENVELOPE");
	buf.append(",COLOUR");
	buf.append(")");
	buf.append(" values(");
    for (int i=0; i<5; i++) {
	  buf.append(i==0 ? "?" : ",?");
	}
	buf.append(")");
	Log.debug(StgOfflineConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgOfflineConfigDao.class, "ruleId:" + entity.getRuleId());
	  if(entity.getOfflineRuleId() != null) ps.setLong(pos++, entity.getOfflineRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgOfflineConfigDao.class, "offlineRuleId:" + entity.getOfflineRuleId());
	  ps.setString(pos++, entity.getDocumentClubType());
	  Log.debug(StgOfflineConfigDao.class, "documentClubType:" + entity.getDocumentClubType());
	  ps.setString(pos++, entity.getEnvelope());
	  Log.debug(StgOfflineConfigDao.class, "envelope:" + entity.getEnvelope());
	  ps.setString(pos++, entity.getColour());
	  Log.debug(StgOfflineConfigDao.class, "colour:" + entity.getColour());
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
  
  public void update(StgOfflineConfig entity) throws GenericException{
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
	buf.append("update STG_OFFLINE_CONFIG set ");
	buf.append("RULE_ID=?");
	buf.append(",OFFLINE_RULE_ID=?");
	buf.append(",DOCUMENT_CLUB_TYPE=?");
	buf.append(",ENVELOPE=?");
	buf.append(",COLOUR=?");
	buf.append(" where 1 = 1");
	buf.append("   and OFFLINE_RULE_ID = ?");
	Log.debug(StgOfflineConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getOfflineRuleId() != null) ps.setLong(pos++, entity.getOfflineRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setString(pos++, entity.getDocumentClubType());
	  ps.setString(pos++, entity.getEnvelope());
	  ps.setString(pos++, entity.getColour());
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
       StgOfflineConfig entity = null;
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
	StringBuffer buf = new StringBuffer();
	buf.append("delete from STG_OFFLINE_CONFIG");
	buf.append(" where 1 = 1");
	buf.append("   and OFFLINE_RULE_ID = ?");
	Log.debug(StgOfflineConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(offlineRuleId != null) ps.setLong(pos++, offlineRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public StgOfflineConfig load( java.lang.Long offlineRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
          if(offlineRuleId==null) {
	    return null;
	  }
          Serializable sId = offlineRuleId;
	  o = session.load(StgOfflineConfig.class,sId);
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
       return (StgOfflineConfig)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from STG_OFFLINE_CONFIG ");
	buf.append(" where 1=1 ");
	buf.append("   and OFFLINE_RULE_ID = ?");
	Log.debug(StgOfflineConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(offlineRuleId != null) ps.setLong(pos++, offlineRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
      StgOfflineConfig entity = null;
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
