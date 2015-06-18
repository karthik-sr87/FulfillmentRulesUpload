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

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgAutomaticDelivermodeCfgDao;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgAutomaticDelivermodeCfg;
import com.ebao.foundation.common.config.Env;
import com.ebao.gs.pub.util.HibernateUtil;
import com.ebao.pub.framework.AppContext;
import com.ebao.pub.framework.ExceptionFactory;
import com.ebao.pub.framework.GenericException;
import com.ebao.pub.framework.data.internal.OracleSequencePKGenerator;
import com.ebao.pub.util.DBean;
import com.ebao.pub.util.Log;


public class TSgAutomaticDelivermodeCfgDaoOracleImpl implements TSgAutomaticDelivermodeCfgDao{
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
      table = "T_SG_AUTOMATIC_DELIVERMODE_CFG";
      columns.put("ruleId", "RULE_ID");
      columnTypes.put("ruleId", "java.lang.Long");
      columns.put("automaticRuleId", "AUTOMATIC_RULE_ID");
      columnTypes.put("automaticRuleId", "java.lang.Long");
      columns.put("userGroup", "USER_GROUP");
      columnTypes.put("userGroup", "java.lang.Long");
      columns.put("docClubType", "DOC_CLUB_TYPE");
      columnTypes.put("docClubType", "java.lang.Integer");
      columns.put("autoDeliver", "AUTO_DELIVER");
      columnTypes.put("autoDeliver", "java.lang.Integer");
      columns.put("autoDeliverMode", "AUTO_DELIVER_MODE");
      columnTypes.put("autoDeliverMode", "java.lang.Integer");
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
  
  public TSgAutomaticDelivermodeCfg fillEntity(ResultSet rs) throws SQLException {
      TSgAutomaticDelivermodeCfg entity = new TSgAutomaticDelivermodeCfg();
      entity.setRuleId(new Long(rs.getLong("RULE_ID")));
      if (rs.wasNull()) {
          entity.setRuleId(null);
      }
      entity.setAutomaticRuleId(new Long(rs.getLong("AUTOMATIC_RULE_ID")));
      if (rs.wasNull()) {
          entity.setAutomaticRuleId(null);
      }
      entity.setUserGroup(new Long(rs.getLong("USER_GROUP")));
      if (rs.wasNull()) {
          entity.setUserGroup(null);
      }
      entity.setDocClubType(new Integer(rs.getInt("DOC_CLUB_TYPE")));
      if (rs.wasNull()) {
          entity.setDocClubType(null);
      }
      entity.setAutoDeliver(new Integer(rs.getInt("AUTO_DELIVER")));
      if (rs.wasNull()) {
          entity.setAutoDeliver(null);
      }
      entity.setAutoDeliverMode(new Integer(rs.getInt("AUTO_DELIVER_MODE")));
      if (rs.wasNull()) {
          entity.setAutoDeliverMode(null);
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
  
  public java.lang.Long create(TSgAutomaticDelivermodeCfg entity) throws GenericException{
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
if ( entity.getAutomaticRuleId() == null || entity.getAutomaticRuleId().longValue()<=0 ) {
      entity.setAutomaticRuleId(OracleSequencePKGenerator.getInstance().getNextPKValue("S_SG_AUTOMATIC_DELIVERMODE_CFG"));
}
      DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into T_SG_AUTOMATIC_DELIVERMODE_CFG(");
	buf.append("RULE_ID");
	buf.append(",AUTOMATIC_RULE_ID");
	buf.append(",USER_GROUP");
	buf.append(",DOC_CLUB_TYPE");
	buf.append(",AUTO_DELIVER");
	buf.append(",AUTO_DELIVER_MODE");
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
	Log.debug(TSgAutomaticDelivermodeCfgDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgAutomaticDelivermodeCfgDao.class, "ruleId:" + entity.getRuleId());
	  if(entity.getAutomaticRuleId() != null) ps.setLong(pos++, entity.getAutomaticRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgAutomaticDelivermodeCfgDao.class, "automaticRuleId:" + entity.getAutomaticRuleId());
	  if(entity.getUserGroup() != null) ps.setLong(pos++, entity.getUserGroup().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgAutomaticDelivermodeCfgDao.class, "userGroup:" + entity.getUserGroup());
	  if(entity.getDocClubType() != null) ps.setInt(pos++, entity.getDocClubType().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgAutomaticDelivermodeCfgDao.class, "docClubType:" + entity.getDocClubType());
	  if(entity.getAutoDeliver() != null) ps.setInt(pos++, entity.getAutoDeliver().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgAutomaticDelivermodeCfgDao.class, "autoDeliver:" + entity.getAutoDeliver());
	  if(entity.getAutoDeliverMode() != null) ps.setInt(pos++, entity.getAutoDeliverMode().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgAutomaticDelivermodeCfgDao.class, "autoDeliverMode:" + entity.getAutoDeliverMode());
	  ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  Log.debug(TSgAutomaticDelivermodeCfgDao.class, "insertTime:" + entity.getInsertTime());
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  Log.debug(TSgAutomaticDelivermodeCfgDao.class, "updateTime:" + entity.getUpdateTime());
	  //if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if (entity.getInsertedBy() != null)
	         ps.setLong(pos++, entity.getInsertedBy().longValue());
	       else
	         ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  Log.debug(TSgAutomaticDelivermodeCfgDao.class, "insertedBy:" + entity.getInsertedBy());
	  //if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if (entity.getUpdatedBy() != null)
	         ps.setLong(pos++, entity.getUpdatedBy().longValue());
	       else
	         ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  Log.debug(TSgAutomaticDelivermodeCfgDao.class, "updatedBy:" + entity.getUpdatedBy());
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}
    return entity.getAutomaticRuleId();
  }
  
  public void update(TSgAutomaticDelivermodeCfg entity) throws GenericException{
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
	buf.append("update T_SG_AUTOMATIC_DELIVERMODE_CFG set ");
	buf.append("RULE_ID=?");
	buf.append(",AUTOMATIC_RULE_ID=?");
	buf.append(",USER_GROUP=?");
	buf.append(",DOC_CLUB_TYPE=?");
	buf.append(",AUTO_DELIVER=?");
	buf.append(",AUTO_DELIVER_MODE=?");
	//buf.append(",INSERT_TIME=?");
	buf.append(",UPDATE_TIME=?");
	//buf.append(",INSERTED_BY=?");
	buf.append(",UPDATED_BY=?");
	buf.append(" where 1 = 1");
	buf.append("   and AUTOMATIC_RULE_ID = ?");
	Log.debug(TSgAutomaticDelivermodeCfgDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getAutomaticRuleId() != null) ps.setLong(pos++, entity.getAutomaticRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getUserGroup() != null) ps.setLong(pos++, entity.getUserGroup().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getDocClubType() != null) ps.setInt(pos++, entity.getDocClubType().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getAutoDeliver() != null) ps.setInt(pos++, entity.getAutoDeliver().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getAutoDeliverMode() != null) ps.setInt(pos++, entity.getAutoDeliverMode().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	 // ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  //if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  //if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  if(entity.getAutomaticRuleId() != null) ps.setLong(pos++, entity.getAutomaticRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public void remove( java.lang.Long automaticRuleId ) throws GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       TSgAutomaticDelivermodeCfg entity = null;
       try {
          Session session = HibernateUtil.currentSession();
          entity = this.load( automaticRuleId );
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
	buf.append("delete from T_SG_AUTOMATIC_DELIVERMODE_CFG");
	buf.append(" where 1 = 1");
	buf.append("   and AUTOMATIC_RULE_ID = ?");
	Log.debug(TSgAutomaticDelivermodeCfgDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(automaticRuleId != null) ps.setLong(pos++, automaticRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public TSgAutomaticDelivermodeCfg load( java.lang.Long automaticRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
          if(automaticRuleId==null) {
	    return null;
	  }
          Serializable sId = automaticRuleId;
	  o = session.load(TSgAutomaticDelivermodeCfg.class,sId);
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
       return (TSgAutomaticDelivermodeCfg)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from T_SG_AUTOMATIC_DELIVERMODE_CFG ");
	buf.append(" where 1=1 ");
	buf.append("   and AUTOMATIC_RULE_ID = ?");
	Log.debug(TSgAutomaticDelivermodeCfgDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(automaticRuleId != null) ps.setLong(pos++, automaticRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
      TSgAutomaticDelivermodeCfg entity = null;
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
  
  public int getSequenceID() throws SQLException,ClassNotFoundException 
	{
		DBean db = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    int serialId = 0;
		try{ 
			StringBuffer selectQuery = new StringBuffer();
			selectQuery.append("SELECT max(AUTOMATIC_RULE_ID) AS SERIAL_ID FROM T_SG_AUTOMATIC_DELIVERMODE_CFG");
		db = new DBean(false);
		db.connect();
		Connection con = db.getConnection();
		ps = con.prepareStatement(selectQuery.toString());
		rs = ps.executeQuery();
		while (rs.next()) {
			serialId = rs.getInt("SERIAL_ID");			
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
		return serialId+1;
	}

}
