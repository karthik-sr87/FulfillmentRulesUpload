

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

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.StgPlatformSpecificConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgPlatformSpecificConfig;
import com.ebao.foundation.common.config.Env;
import com.ebao.gs.pub.util.HibernateUtil;
import com.ebao.pub.framework.ExceptionFactory;
import com.ebao.pub.framework.GenericException;
import com.ebao.pub.framework.data.internal.OracleSequencePKGenerator;
import com.ebao.pub.util.DBean;
import com.ebao.pub.util.Log;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public class StgPlatformSpecificConfigDaoOracleImpl implements StgPlatformSpecificConfigDao{
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
      table = "STG_PLATFORM_SPECIFIC_CONFIG";
      columns.put("ruleId", "RULE_ID");
      columnTypes.put("ruleId", "java.lang.Long");
      columns.put("platformRuleId", "PLATFORM_RULE_ID");
      columnTypes.put("platformRuleId", "java.lang.Long");
      columns.put("platform", "PLATFORM");
      columnTypes.put("platform", "java.lang.String");
  }

  protected Object fillObject(ResultSet rs) throws SQLException {
    return fillEntity(rs);
  }
  
  public StgPlatformSpecificConfig fillEntity(ResultSet rs) throws SQLException {
      StgPlatformSpecificConfig entity = new StgPlatformSpecificConfig();
      entity.setRuleId(new Long(rs.getLong("RULE_ID")));
      if (rs.wasNull()) {
          entity.setRuleId(null);
      }
      entity.setPlatformRuleId(new Long(rs.getLong("PLATFORM_RULE_ID")));
      if (rs.wasNull()) {
          entity.setPlatformRuleId(null);
      }
      entity.setPlatform(rs.getString("PLATFORM"));
      return entity;
  }
  
  public java.lang.Long create(StgPlatformSpecificConfig entity) throws GenericException{
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
if ( entity.getPlatformRuleId() == null || entity.getPlatformRuleId().longValue()<=0 ) {
      entity.setPlatformRuleId(OracleSequencePKGenerator.getInstance().getNextPKValue("STG_PLATFORM_SPECIFIC_CONF__ID"));
}
      DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into STG_PLATFORM_SPECIFIC_CONFIG(");
	buf.append("RULE_ID");
	buf.append(",PLATFORM_RULE_ID");
	buf.append(",PLATFORM");
	buf.append(")");
	buf.append(" values(");
    for (int i=0; i<3; i++) {
	  buf.append(i==0 ? "?" : ",?");
	}
	buf.append(")");
	Log.debug(StgPlatformSpecificConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgPlatformSpecificConfigDao.class, "ruleId:" + entity.getRuleId());
	  if(entity.getPlatformRuleId() != null) ps.setLong(pos++, entity.getPlatformRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgPlatformSpecificConfigDao.class, "platformRuleId:" + entity.getPlatformRuleId());
	  ps.setString(pos++, entity.getPlatform());
	  Log.debug(StgPlatformSpecificConfigDao.class, "platform:" + entity.getPlatform());
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}
    return entity.getPlatformRuleId();
  }
  
  public void update(StgPlatformSpecificConfig entity) throws GenericException{
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
	buf.append("update STG_PLATFORM_SPECIFIC_CONFIG set ");
	buf.append("RULE_ID=?");
	buf.append(",PLATFORM_RULE_ID=?");
	buf.append(",PLATFORM=?");
	buf.append(" where 1 = 1");
	buf.append("   and PLATFORM_RULE_ID = ?");
	Log.debug(StgPlatformSpecificConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getPlatformRuleId() != null) ps.setLong(pos++, entity.getPlatformRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setString(pos++, entity.getPlatform());
	  if(entity.getPlatformRuleId() != null) ps.setLong(pos++, entity.getPlatformRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public void remove( java.lang.Long platformRuleId ) throws GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       StgPlatformSpecificConfig entity = null;
       try {
          Session session = HibernateUtil.currentSession();
          entity = this.load( platformRuleId );
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
	buf.append("delete from STG_PLATFORM_SPECIFIC_CONFIG");
	buf.append(" where 1 = 1");
	buf.append("   and PLATFORM_RULE_ID = ?");
	Log.debug(StgPlatformSpecificConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(platformRuleId != null) ps.setLong(pos++, platformRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public StgPlatformSpecificConfig load( java.lang.Long platformRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
          if(platformRuleId==null) {
	    return null;
	  }
          Serializable sId = platformRuleId;
	  o = session.load(StgPlatformSpecificConfig.class,sId);
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
       return (StgPlatformSpecificConfig)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from STG_PLATFORM_SPECIFIC_CONFIG ");
	buf.append(" where 1=1 ");
	buf.append("   and PLATFORM_RULE_ID = ?");
	Log.debug(StgPlatformSpecificConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(platformRuleId != null) ps.setLong(pos++, platformRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
      StgPlatformSpecificConfig entity = null;
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
