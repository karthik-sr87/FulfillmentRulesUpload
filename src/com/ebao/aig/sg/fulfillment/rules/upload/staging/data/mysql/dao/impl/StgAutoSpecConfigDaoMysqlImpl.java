

package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.mysql.dao.impl;

import java.sql.*;
import java.util.*;
import java.math.BigDecimal;

import com.ebao.pub.util.DBean;
import com.ebao.pub.util.Log;
import com.ebao.pub.framework.*;
import com.ebao.pub.framework.data.internal.*;
import com.ebao.gs.pub.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.HibernateException;

import java.io.Serializable;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.StgAutoSpecConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgAutoSpecConfig;
import com.ebao.foundation.common.config.Env;

///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public class StgAutoSpecConfigDaoMysqlImpl implements StgAutoSpecConfigDao{
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
      table = "STG_AUTO_SPEC_CONFIG";
      columns.put("ruleId", "RULE_ID");
      columnTypes.put("ruleId", "java.lang.Long");
      columns.put("autoRuleId", "AUTO_RULE_ID");
      columnTypes.put("autoRuleId", "java.lang.Long");
      columns.put("vehicleAgeFrom", "VEHICLE_AGE_FROM");
      columnTypes.put("vehicleAgeFrom", "java.lang.String");
      columns.put("vehicleAgeTo", "VEHICLE_AGE_TO");
      columnTypes.put("vehicleAgeTo", "java.lang.String");
      columns.put("ncdFrom", "NCD_FROM");
      columnTypes.put("ncdFrom", "java.lang.String");
      columns.put("ncdTo", "NCD_TO");
      columnTypes.put("ncdTo", "java.lang.String");
      columns.put("premiumFrom", "PREMIUM_FROM");
      columnTypes.put("premiumFrom", "java.math.BigDecimal");
      columns.put("premiumTo", "PREMIUM_TO");
      columnTypes.put("premiumTo", "java.math.BigDecimal");
      columns.put("vehicleType", "VEHICLE_TYPE");
      columnTypes.put("vehicleType", "java.lang.String");
      columns.put("bubbleBoxLetter", "BUBBLE_BOX_LETTER");
      columnTypes.put("bubbleBoxLetter", "java.lang.String");
      columns.put("imprtNoticeFlag", "IMPRT_NOTICE_FLAG");
      columnTypes.put("imprtNoticeFlag", "java.lang.String");
      columns.put("autoRuleDescription", "AUTO_RULE_DESCRIPTION");
      columnTypes.put("autoRuleDescription", "java.lang.String");
  }

  protected Object fillObject(ResultSet rs) throws SQLException {
    return fillEntity(rs);
  }
  
  public StgAutoSpecConfig fillEntity(ResultSet rs) throws SQLException {
      StgAutoSpecConfig entity = new StgAutoSpecConfig();
      entity.setRuleId(new Long(rs.getLong("RULE_ID")));
      if (rs.wasNull()) {
          entity.setRuleId(null);
      }
      entity.setAutoRuleId(new Long(rs.getLong("AUTO_RULE_ID")));
      if (rs.wasNull()) {
          entity.setAutoRuleId(null);
      }
      entity.setVehicleAgeFrom(rs.getString("VEHICLE_AGE_FROM"));
      entity.setVehicleAgeTo(rs.getString("VEHICLE_AGE_TO"));
      entity.setNcdFrom(rs.getString("NCD_FROM"));
      entity.setNcdTo(rs.getString("NCD_TO"));
      entity.setPremiumFrom(rs.getBigDecimal("PREMIUM_FROM"));
      entity.setPremiumTo(rs.getBigDecimal("PREMIUM_TO"));
      entity.setVehicleType(rs.getString("VEHICLE_TYPE"));
      entity.setBubbleBoxLetter(rs.getString("BUBBLE_BOX_LETTER"));
      entity.setImprtNoticeFlag(rs.getString("IMPRT_NOTICE_FLAG"));
      entity.setAutoRuleDescription(rs.getString("AUTO_RULE_DESCRIPTION"));
      return entity;
  }
  
  public java.lang.Long create(StgAutoSpecConfig entity) throws GenericException{
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
/*      //set sequence primary key
if ( entity.getAutoRuleId() == null || entity.getAutoRuleId().longValue()<=0 ) {
      entity.setAutoRuleId(OracleSequencePKGenerator.getInstance().getNextPKValue("STG_AUTO_SPEC_CONFIG__AUTO_RUL"));
}*/
      DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into STG_AUTO_SPEC_CONFIG(");
	buf.append("RULE_ID");
	buf.append(",AUTO_RULE_ID");
	buf.append(",VEHICLE_AGE_FROM");
	buf.append(",VEHICLE_AGE_TO");
	buf.append(",NCD_FROM");
	buf.append(",NCD_TO");
	buf.append(",PREMIUM_FROM");
	buf.append(",PREMIUM_TO");
	buf.append(",VEHICLE_TYPE");
	buf.append(",BUBBLE_BOX_LETTER");
	buf.append(",IMPRT_NOTICE_FLAG");
	buf.append(",AUTO_RULE_DESCRIPTION");
	buf.append(")");
	buf.append(" values(");
    for (int i=0; i<12; i++) {
	  buf.append(i==0 ? "?" : ",?");
	}
	buf.append(")");
	Log.debug(StgAutoSpecConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgAutoSpecConfigDao.class, "ruleId:" + entity.getRuleId());
	  if(entity.getAutoRuleId() != null) ps.setLong(pos++, entity.getAutoRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgAutoSpecConfigDao.class, "autoRuleId:" + entity.getAutoRuleId());
	  ps.setString(pos++, entity.getVehicleAgeFrom());
	  Log.debug(StgAutoSpecConfigDao.class, "vehicleAgeFrom:" + entity.getVehicleAgeFrom());
	  ps.setString(pos++, entity.getVehicleAgeTo());
	  Log.debug(StgAutoSpecConfigDao.class, "vehicleAgeTo:" + entity.getVehicleAgeTo());
	  ps.setString(pos++, entity.getNcdFrom());
	  Log.debug(StgAutoSpecConfigDao.class, "ncdFrom:" + entity.getNcdFrom());
	  ps.setString(pos++, entity.getNcdTo());
	  Log.debug(StgAutoSpecConfigDao.class, "ncdTo:" + entity.getNcdTo());
	  ps.setBigDecimal(pos++, entity.getPremiumFrom());
	  Log.debug(StgAutoSpecConfigDao.class, "premiumFrom:" + entity.getPremiumFrom());
	  ps.setBigDecimal(pos++, entity.getPremiumTo());
	  Log.debug(StgAutoSpecConfigDao.class, "premiumTo:" + entity.getPremiumTo());
	  ps.setString(pos++, entity.getVehicleType());
	  Log.debug(StgAutoSpecConfigDao.class, "vehicleType:" + entity.getVehicleType());
	  ps.setString(pos++, entity.getBubbleBoxLetter());
	  Log.debug(StgAutoSpecConfigDao.class, "bubbleBoxLetter:" + entity.getBubbleBoxLetter());
	  ps.setString(pos++, entity.getImprtNoticeFlag());
	  Log.debug(StgAutoSpecConfigDao.class, "imprtNoticeFlag:" + entity.getImprtNoticeFlag());
	  ps.setString(pos++, entity.getAutoRuleDescription());
	  Log.debug(StgAutoSpecConfigDao.class, "autoRuleDescription:" + entity.getAutoRuleDescription());
	  ps.execute();
	  rs = ps.getGeneratedKeys();
	  if(rs.next())
		  entity.setAutoRuleId(rs.getLong(1));
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(rs, ps, db);
	}
    return entity.getAutoRuleId();
  }
  
  public void update(StgAutoSpecConfig entity) throws GenericException{
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
	buf.append("update STG_AUTO_SPEC_CONFIG set ");
	buf.append("RULE_ID=?");
	buf.append(",AUTO_RULE_ID=?");
	buf.append(",VEHICLE_AGE_FROM=?");
	buf.append(",VEHICLE_AGE_TO=?");
	buf.append(",NCD_FROM=?");
	buf.append(",NCD_TO=?");
	buf.append(",PREMIUM_FROM=?");
	buf.append(",PREMIUM_TO=?");
	buf.append(",VEHICLE_TYPE=?");
	buf.append(",BUBBLE_BOX_LETTER=?");
	buf.append(",IMPRT_NOTICE_FLAG=?");
	buf.append(",AUTO_RULE_DESCRIPTION=?");
	buf.append(" where 1 = 1");
	buf.append("   and AUTO_RULE_ID = ?");
	Log.debug(StgAutoSpecConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getAutoRuleId() != null) ps.setLong(pos++, entity.getAutoRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setString(pos++, entity.getVehicleAgeFrom());
	  ps.setString(pos++, entity.getVehicleAgeTo());
	  ps.setString(pos++, entity.getNcdFrom());
	  ps.setString(pos++, entity.getNcdTo());
	  ps.setBigDecimal(pos++, entity.getPremiumFrom());
	  ps.setBigDecimal(pos++, entity.getPremiumTo());
	  ps.setString(pos++, entity.getVehicleType());
	  ps.setString(pos++, entity.getBubbleBoxLetter());
	  ps.setString(pos++, entity.getImprtNoticeFlag());
	  ps.setString(pos++, entity.getAutoRuleDescription());
	  if(entity.getAutoRuleId() != null) ps.setLong(pos++, entity.getAutoRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public void remove( java.lang.Long autoRuleId ) throws GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       StgAutoSpecConfig entity = null;
       try {
          Session session = HibernateUtil.currentSession();
          entity = this.load( autoRuleId );
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
	buf.append("delete from STG_AUTO_SPEC_CONFIG");
	buf.append(" where 1 = 1");
	buf.append("   and AUTO_RULE_ID = ?");
	Log.debug(StgAutoSpecConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(autoRuleId != null) ps.setLong(pos++, autoRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public StgAutoSpecConfig load( java.lang.Long autoRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
          if(autoRuleId==null) {
	    return null;
	  }
          Serializable sId = autoRuleId;
	  o = session.load(StgAutoSpecConfig.class,sId);
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
       return (StgAutoSpecConfig)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from STG_AUTO_SPEC_CONFIG ");
	buf.append(" where 1=1 ");
	buf.append("   and AUTO_RULE_ID = ?");
	Log.debug(StgAutoSpecConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(autoRuleId != null) ps.setLong(pos++, autoRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
      StgAutoSpecConfig entity = null;
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
