

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

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgPlatformSpecificConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgPlatformSpecificConfig;
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

public class TSgPlatformSpecificConfigDaoOracleImpl implements TSgPlatformSpecificConfigDao{
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
      table = "T_SG_PLATFORM_SPECIFIC_CONFIG";
      columns.put("ruleId", "RULE_ID");
      columnTypes.put("ruleId", "java.lang.Long");
      columns.put("platformRuleId", "PLATFORM_RULE_ID");
      columnTypes.put("platformRuleId", "java.lang.Long");
      columns.put("platform", "PLATFORM");
      columnTypes.put("platform", "java.lang.Integer");
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
  
  public TSgPlatformSpecificConfig fillEntity(ResultSet rs) throws SQLException {
      TSgPlatformSpecificConfig entity = new TSgPlatformSpecificConfig();
      entity.setRuleId(new Long(rs.getLong("RULE_ID")));
      if (rs.wasNull()) {
          entity.setRuleId(null);
      }
      entity.setPlatformRuleId(new Long(rs.getLong("PLATFORM_RULE_ID")));
      if (rs.wasNull()) {
          entity.setPlatformRuleId(null);
      }
      entity.setPlatform(new Integer(rs.getInt("PLATFORM")));
      if (rs.wasNull()) {
          entity.setPlatform(null);
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
  
  public java.lang.Long create(TSgPlatformSpecificConfig entity) throws GenericException{
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
      entity.setPlatformRuleId(OracleSequencePKGenerator.getInstance().getNextPKValue("S_SG_PLATFORM_SPECIFIC_CONFIG_"));
}
      DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into T_SG_PLATFORM_SPECIFIC_CONFIG(");
	buf.append("RULE_ID");
	buf.append(",PLATFORM_RULE_ID");
	buf.append(",PLATFORM");
	buf.append(",INSERT_TIME");
	buf.append(",UPDATE_TIME");
	buf.append(",INSERTED_BY");
	buf.append(",UPDATED_BY");
	buf.append(")");
	buf.append(" values(");
    for (int i=0; i<7; i++) {
	  buf.append(i==0 ? "?" : ",?");
	}
	buf.append(")");
	Log.debug(TSgPlatformSpecificConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgPlatformSpecificConfigDao.class, "ruleId:" + entity.getRuleId());
	  if(entity.getPlatformRuleId() != null) ps.setLong(pos++, entity.getPlatformRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgPlatformSpecificConfigDao.class, "platformRuleId:" + entity.getPlatformRuleId());
	  if(entity.getPlatform() != null) ps.setInt(pos++, entity.getPlatform().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgPlatformSpecificConfigDao.class, "platform:" + entity.getPlatform());
	  ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  Log.debug(TSgPlatformSpecificConfigDao.class, "insertTime:" + entity.getInsertTime());
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  Log.debug(TSgPlatformSpecificConfigDao.class, "updateTime:" + entity.getUpdateTime());
	  
	  if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  Log.debug(TSgPlatformSpecificConfigDao.class, "insertedBy:" + entity.getInsertedBy());
	  
	  if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  Log.debug(TSgPlatformSpecificConfigDao.class, "updatedBy:" + entity.getUpdatedBy());
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
  
  public void update(TSgPlatformSpecificConfig entity) throws GenericException{
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
	buf.append("update T_SG_PLATFORM_SPECIFIC_CONFIG set ");
	buf.append("RULE_ID=?");
	buf.append(",PLATFORM_RULE_ID=?");
	buf.append(",PLATFORM=?");
	
	buf.append(",UPDATE_TIME=?");
	
	buf.append(",UPDATED_BY=?");
	buf.append(" where 1 = 1");
	buf.append("   and PLATFORM_RULE_ID = ?");
	Log.debug(TSgPlatformSpecificConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getPlatformRuleId() != null) ps.setLong(pos++, entity.getPlatformRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getPlatform() != null) ps.setInt(pos++, entity.getPlatform().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  
	  if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
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
       TSgPlatformSpecificConfig entity = null;
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
	buf.append("delete from T_SG_PLATFORM_SPECIFIC_CONFIG");
	buf.append(" where 1 = 1");
	buf.append("   and PLATFORM_RULE_ID = ?");
	Log.debug(TSgPlatformSpecificConfigDao.class, buf.toString());
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
  
  public TSgPlatformSpecificConfig load( java.lang.Long platformRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
          if(platformRuleId==null) {
	    return null;
	  }
          Serializable sId = platformRuleId;
	  o = session.load(TSgPlatformSpecificConfig.class,sId);
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
       return (TSgPlatformSpecificConfig)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from T_SG_PLATFORM_SPECIFIC_CONFIG ");
	buf.append(" where 1=1 ");
	buf.append("   and PLATFORM_RULE_ID = ?");
	Log.debug(TSgPlatformSpecificConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(platformRuleId != null) ps.setLong(pos++, platformRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
      TSgPlatformSpecificConfig entity = null;
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
public Long getPlatformSequenceID(Long MasterRuleId) throws SQLException, ClassNotFoundException {
	// TODO Auto-generated method stub
	DBean db = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Long platformserialId = null;
                try{ 
                                StringBuffer selectQuery = new StringBuffer();
                                selectQuery.append("SELECT max(PLATFORM_RULE_ID) AS SERIAL_ID FROM T_SG_PLATFORM_SPECIFIC_CONFIG where RULE_ID = ? ");
                db = new DBean(false);
                db.connect();
                Connection con = db.getConnection();
                //
                ps = con.prepareStatement(selectQuery.toString());
               
          	  if(MasterRuleId != null) 
          		  ps.setLong(1, MasterRuleId.longValue()); 
          	  else ps.setNull(1, Types.NUMERIC);
          	rs = ps.executeQuery();

                while (rs.next()) {
                	platformserialId = rs.getLong("SERIAL_ID");
                                
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
                if(platformserialId==0)
                	return platformserialId=(long)100;
                else
                return platformserialId+1;
}

///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}
