

package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.mysql.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.StgAutomaticDelivermodeCfgDao;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgAutomaticDelivermodeCfg;
import com.ebao.foundation.common.config.Env;
import com.ebao.gs.pub.util.HibernateUtil;
import com.ebao.pub.framework.ExceptionFactory;
import com.ebao.pub.framework.GenericException;
import com.ebao.pub.framework.data.internal.OracleSequencePKGenerator;
import com.ebao.pub.util.DBean;
import com.ebao.pub.util.Log;

///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public class StgAutomaticDelivermodeCfgDaoMysqlImpl implements StgAutomaticDelivermodeCfgDao{
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
      table = "STG_AUTOMATIC_DELIVERMODE_CFG";
      columns.put("ruleId", "RULE_ID");
      columnTypes.put("ruleId", "java.lang.Long");
      columns.put("automaticRuleId", "AUTOMATIC_RULE_ID");
      columnTypes.put("automaticRuleId", "java.lang.Long");
      columns.put("userGroup", "USER_GROUP");
      columnTypes.put("userGroup", "java.lang.String");
      columns.put("docClubType", "DOC_CLUB_TYPE");
      columnTypes.put("docClubType", "java.lang.String");
      columns.put("autoDeliver", "AUTO_DELIVER");
      columnTypes.put("autoDeliver", "java.lang.String");
      columns.put("autoDeliverMode", "AUTO_DELIVER_MODE");
      columnTypes.put("autoDeliverMode", "java.lang.String");
  }

  protected Object fillObject(ResultSet rs) throws SQLException {
    return fillEntity(rs);
  }
  
  public StgAutomaticDelivermodeCfg fillEntity(ResultSet rs) throws SQLException {
      StgAutomaticDelivermodeCfg entity = new StgAutomaticDelivermodeCfg();
      entity.setRuleId(new Long(rs.getLong("RULE_ID")));
      if (rs.wasNull()) {
          entity.setRuleId(null);
      }
      entity.setAutomaticRuleId(new Long(rs.getLong("AUTOMATIC_RULE_ID")));
      if (rs.wasNull()) {
          entity.setAutomaticRuleId(null);
      }
      entity.setUserGroup(rs.getString("USER_GROUP"));
      entity.setDocClubType(rs.getString("DOC_CLUB_TYPE"));
      entity.setAutoDeliver(rs.getString("AUTO_DELIVER"));
      entity.setAutoDeliverMode(rs.getString("AUTO_DELIVER_MODE"));
      return entity;
  }
  
  public Long create(StgAutomaticDelivermodeCfg entity) throws GenericException{
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
/*    //set sequence primary key
if ( entity.getAutomaticRuleId() == null || entity.getAutomaticRuleId().longValue()<=0 ) {
    entity.setAutomaticRuleId(OracleSequencePKGenerator.getInstance().getNextPKValue("STG_AUTO_DELIVERMODE_CFG__ID"));
}*/
      DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into STG_AUTOMATIC_DELIVERMODE_CFG(");
	buf.append("RULE_ID");
	buf.append(",AUTOMATIC_RULE_ID");
	buf.append(",USER_GROUP");
	buf.append(",DOC_CLUB_TYPE");
	buf.append(",AUTO_DELIVER");
	buf.append(",AUTO_DELIVER_MODE");
	buf.append(")");
	buf.append(" values(");
    for (int i=0; i<6; i++) {
	  buf.append(i==0 ? "?" : ",?");
	}
	buf.append(")");
	Log.debug(StgAutomaticDelivermodeCfgDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgAutomaticDelivermodeCfgDao.class, "ruleId:" + entity.getRuleId());
	  if(entity.getAutomaticRuleId() != null) ps.setLong(pos++, entity.getAutomaticRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgAutomaticDelivermodeCfgDao.class, "automaticRuleId:" + entity.getAutomaticRuleId());
	  ps.setString(pos++, entity.getUserGroup());
	  Log.debug(StgAutomaticDelivermodeCfgDao.class, "userGroup:" + entity.getUserGroup());
	  ps.setString(pos++, entity.getDocClubType());
	  Log.debug(StgAutomaticDelivermodeCfgDao.class, "docClubType:" + entity.getDocClubType());
	  ps.setString(pos++, entity.getAutoDeliver());
	  Log.debug(StgAutomaticDelivermodeCfgDao.class, "autoDeliver:" + entity.getAutoDeliver());
	  ps.setString(pos++, entity.getAutoDeliverMode());
	  Log.debug(StgAutomaticDelivermodeCfgDao.class, "autoDeliverMode:" + entity.getAutoDeliverMode());
	  ps.execute();
	  rs = ps.getGeneratedKeys();
	  if(rs.next())
		  entity.setAutomaticRuleId(rs.getLong(1));
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(rs, ps, db);
	}
	return entity.getAutomaticRuleId();
  }
  
  public void update(StgAutomaticDelivermodeCfg entity) throws GenericException{
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
	buf.append("update STG_AUTOMATIC_DELIVERMODE_CFG set ");
	buf.append("RULE_ID=?");
	buf.append(",AUTOMATIC_RULE_ID=?");
	buf.append(",USER_GROUP=?");
	buf.append(",DOC_CLUB_TYPE=?");
	buf.append(",AUTO_DELIVER=?");
	buf.append(",AUTO_DELIVER_MODE=?");
	buf.append(" where 1 = 1");
	Log.debug(StgAutomaticDelivermodeCfgDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getAutomaticRuleId() != null) ps.setLong(pos++, entity.getAutomaticRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setString(pos++, entity.getUserGroup());
	  ps.setString(pos++, entity.getDocClubType());
	  ps.setString(pos++, entity.getAutoDeliver());
	  ps.setString(pos++, entity.getAutoDeliverMode());
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public void remove() throws GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       StgAutomaticDelivermodeCfg entity = null;
       try {
          Session session = HibernateUtil.currentSession();
          entity = this.load();
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
	buf.append("delete from STG_AUTOMATIC_DELIVERMODE_CFG");
	buf.append(" where 1 = 1");
	Log.debug(StgAutomaticDelivermodeCfgDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public StgAutomaticDelivermodeCfg load() throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
	  String sql = "from  com.ebao.gcs.tmp.data.dao.StgAutomaticDelivermodeCfg t where 1=1 ";
          Query query = session.createQuery(sql);
          List list = query.list();
          if(list==null||list.size()==0) {
           return null;
          }
          o = (StgAutomaticDelivermodeCfg)list.get(0);
/*
          StgAutomaticDelivermodeCfg entity = new StgAutomaticDelivermodeCfg();
          o = session.load(StgAutomaticDelivermodeCfg.class,entity);
*/
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
       return (StgAutomaticDelivermodeCfg)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from STG_AUTOMATIC_DELIVERMODE_CFG ");
	buf.append(" where 1=1 ");
	Log.debug(StgAutomaticDelivermodeCfgDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  rs = ps.executeQuery();
      StgAutomaticDelivermodeCfg entity = null;
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
