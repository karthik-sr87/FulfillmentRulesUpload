

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

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.StgCoverTypeSpecConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgCoverTypeSpecConfig;
import com.ebao.foundation.common.config.Env;
import com.ebao.gs.pub.util.HibernateUtil;
import com.ebao.pub.framework.ExceptionFactory;
import com.ebao.pub.framework.GenericException;
import com.ebao.pub.framework.data.internal.OracleSequencePKGenerator;
import com.ebao.pub.util.DBean;
import com.ebao.pub.util.Log;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public class StgCoverTypeSpecConfigDaoOracleImpl implements StgCoverTypeSpecConfigDao{
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
      table = "STG_COVER_TYPE_SPEC_CONFIG";
      columns.put("coverTypeRuleId", "COVER_TYPE_RULE_ID");
      columnTypes.put("coverTypeRuleId", "java.lang.Long");
      columns.put("ruleId", "RULE_ID");
      columnTypes.put("ruleId", "java.lang.Long");
      columns.put("coverTypeCode", "COVER_TYPE_CODE");
      columnTypes.put("coverTypeCode", "java.lang.String");
      columns.put("availableFlag", "AVAILABLE_FLAG");
      columnTypes.put("availableFlag", "java.lang.String");
      columns.put("dnmFlag", "DNM_FLAG");
      columnTypes.put("dnmFlag", "java.lang.String");
      columns.put("description", "DESCRIPTION");
      columnTypes.put("description", "java.lang.String");
  }

  protected Object fillObject(ResultSet rs) throws SQLException {
    return fillEntity(rs);
  }
  
  public StgCoverTypeSpecConfig fillEntity(ResultSet rs) throws SQLException {
      StgCoverTypeSpecConfig entity = new StgCoverTypeSpecConfig();
      entity.setCoverTypeRuleId(new Long(rs.getLong("COVER_TYPE_RULE_ID")));
      if (rs.wasNull()) {
          entity.setCoverTypeRuleId(null);
      }
      entity.setRuleId(new Long(rs.getLong("RULE_ID")));
      if (rs.wasNull()) {
          entity.setRuleId(null);
      }
      entity.setCoverTypeCode(rs.getString("COVER_TYPE_CODE"));
      entity.setAvailableFlag(rs.getString("AVAILABLE_FLAG"));
      entity.setDnmFlag(rs.getString("DNM_FLAG"));
      entity.setDescription(rs.getString("DESCRIPTION"));
      return entity;
  }
  
  public java.lang.Long create(StgCoverTypeSpecConfig entity) throws GenericException{
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
if ( entity.getCoverTypeRuleId() == null || entity.getCoverTypeRuleId().longValue()<=0 ) {
      entity.setCoverTypeRuleId(OracleSequencePKGenerator.getInstance().getNextPKValue("STG_COVER_TYPE_SPEC_CONFIG__ID"));
}
      DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into STG_COVER_TYPE_SPEC_CONFIG(");
	buf.append("COVER_TYPE_RULE_ID");
	buf.append(",RULE_ID");
	buf.append(",COVER_TYPE_CODE");
	buf.append(",AVAILABLE_FLAG");
	buf.append(",DNM_FLAG");
	buf.append(",DESCRIPTION");
	buf.append(")");
	buf.append(" values(");
    for (int i=0; i<6; i++) {
	  buf.append(i==0 ? "?" : ",?");
	}
	buf.append(")");
	Log.debug(StgCoverTypeSpecConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getCoverTypeRuleId() != null) ps.setLong(pos++, entity.getCoverTypeRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgCoverTypeSpecConfigDao.class, "coverTypeRuleId:" + entity.getCoverTypeRuleId());
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgCoverTypeSpecConfigDao.class, "ruleId:" + entity.getRuleId());
	  ps.setString(pos++, entity.getCoverTypeCode());
	  Log.debug(StgCoverTypeSpecConfigDao.class, "coverTypeCode:" + entity.getCoverTypeCode());
	  ps.setString(pos++, entity.getAvailableFlag());
	  Log.debug(StgCoverTypeSpecConfigDao.class, "availableFlag:" + entity.getAvailableFlag());
	  ps.setString(pos++, entity.getDnmFlag());
	  Log.debug(StgCoverTypeSpecConfigDao.class, "dnmFlag:" + entity.getDnmFlag());
	  ps.setString(pos++, entity.getDescription());
	  Log.debug(StgCoverTypeSpecConfigDao.class, "description:" + entity.getDescription());
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}
    return entity.getCoverTypeRuleId();
  }
  
  public void update(StgCoverTypeSpecConfig entity) throws GenericException{
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
	buf.append("update STG_COVER_TYPE_SPEC_CONFIG set ");
	buf.append("COVER_TYPE_RULE_ID=?");
	buf.append(",RULE_ID=?");
	buf.append(",COVER_TYPE_CODE=?");
	buf.append(",AVAILABLE_FLAG=?");
	buf.append(",DNM_FLAG=?");
	buf.append(",DESCRIPTION=?");
	buf.append(" where 1 = 1");
	buf.append("   and COVER_TYPE_RULE_ID = ?");
	Log.debug(StgCoverTypeSpecConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getCoverTypeRuleId() != null) ps.setLong(pos++, entity.getCoverTypeRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setString(pos++, entity.getCoverTypeCode());
	  ps.setString(pos++, entity.getAvailableFlag());
	  ps.setString(pos++, entity.getDnmFlag());
	  ps.setString(pos++, entity.getDescription());
	  if(entity.getCoverTypeRuleId() != null) ps.setLong(pos++, entity.getCoverTypeRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public void remove( java.lang.Long coverTypeRuleId ) throws GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       StgCoverTypeSpecConfig entity = null;
       try {
          Session session = HibernateUtil.currentSession();
          entity = this.load( coverTypeRuleId );
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
	buf.append("delete from STG_COVER_TYPE_SPEC_CONFIG");
	buf.append(" where 1 = 1");
	buf.append("   and COVER_TYPE_RULE_ID = ?");
	Log.debug(StgCoverTypeSpecConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(coverTypeRuleId != null) ps.setLong(pos++, coverTypeRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public StgCoverTypeSpecConfig load( java.lang.Long coverTypeRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
          if(coverTypeRuleId==null) {
	    return null;
	  }
          Serializable sId = coverTypeRuleId;
	  o = session.load(StgCoverTypeSpecConfig.class,sId);
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
       return (StgCoverTypeSpecConfig)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from STG_COVER_TYPE_SPEC_CONFIG ");
	buf.append(" where 1=1 ");
	buf.append("   and COVER_TYPE_RULE_ID = ?");
	Log.debug(StgCoverTypeSpecConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(coverTypeRuleId != null) ps.setLong(pos++, coverTypeRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
      StgCoverTypeSpecConfig entity = null;
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
