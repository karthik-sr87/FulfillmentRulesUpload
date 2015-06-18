

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

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.StgInsertMappingConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgInsertMappingConfig;
import com.ebao.foundation.common.config.Env;
import com.ebao.gs.pub.util.HibernateUtil;
import com.ebao.pub.framework.ExceptionFactory;
import com.ebao.pub.framework.GenericException;
import com.ebao.pub.framework.data.internal.OracleSequencePKGenerator;
import com.ebao.pub.util.DBean;
import com.ebao.pub.util.Log;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public class StgInsertMappingConfigDaoOracleImpl implements StgInsertMappingConfigDao{
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
      table = "STG_INSERT_MAPPING_CONFIG";
      columns.put("listId", "LIST_ID");
      columnTypes.put("listId", "java.lang.Long");
      columns.put("ruleId", "RULE_ID");
      columnTypes.put("ruleId", "java.lang.Long");
      columns.put("offlineRuleId", "OFFLINE_RULE_ID");
      columnTypes.put("offlineRuleId", "java.lang.Long");
      columns.put("voucherRuleId", "VOUCHER_RULE_ID");
      columnTypes.put("voucherRuleId", "java.lang.Long");
      columns.put("campaignRuleId", "CAMPAIGN_RULE_ID");
      columnTypes.put("campaignRuleId", "java.lang.Long");
      columns.put("insertName", "INSERT_NAME");
      columnTypes.put("insertName", "java.lang.String");
      columns.put("sequenceNo", "SEQUENCE_NO");
      columnTypes.put("sequenceNo", "java.lang.String");
      columns.put("insertionEffectiveDate", "INSERTION_EFFECTIVE_DATE");
      columnTypes.put("insertionEffectiveDate", "java.util.Date");
      columns.put("insertionExpiryDate", "INSERTION_EXPIRY_DATE");
      columnTypes.put("insertionExpiryDate", "java.util.Date");
      columns.put("excludeReFulfillment", "EXCLUDE_RE_FULFILLMENT");
      columnTypes.put("excludeReFulfillment", "java.lang.String");
  }

  protected Object fillObject(ResultSet rs) throws SQLException {
    return fillEntity(rs);
  }
  
  public StgInsertMappingConfig fillEntity(ResultSet rs) throws SQLException {
      StgInsertMappingConfig entity = new StgInsertMappingConfig();
      entity.setListId(new Long(rs.getLong("LIST_ID")));
      if (rs.wasNull()) {
          entity.setListId(null);
      }
      entity.setRuleId(new Long(rs.getLong("RULE_ID")));
      if (rs.wasNull()) {
          entity.setRuleId(null);
      }
      entity.setOfflineRuleId(new Long(rs.getLong("OFFLINE_RULE_ID")));
      if (rs.wasNull()) {
          entity.setOfflineRuleId(null);
      }
      entity.setVoucherRuleId(new Long(rs.getLong("VOUCHER_RULE_ID")));
      if (rs.wasNull()) {
          entity.setVoucherRuleId(null);
      }
      entity.setCampaignRuleId(new Long(rs.getLong("CAMPAIGN_RULE_ID")));
      if (rs.wasNull()) {
          entity.setCampaignRuleId(null);
      }
      entity.setInsertName(rs.getString("INSERT_NAME"));
      entity.setSequenceNo(rs.getString("SEQUENCE_NO"));
      entity.setInsertionEffectiveDate(rs.getTimestamp("INSERTION_EFFECTIVE_DATE"));
      entity.setInsertionExpiryDate(rs.getTimestamp("INSERTION_EXPIRY_DATE"));
      entity.setExcludeReFulfillment(rs.getString("EXCLUDE_RE_FULFILLMENT"));
      return entity;
  }
  
  public java.lang.Long create(StgInsertMappingConfig entity) throws GenericException{
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
if ( entity.getListId() == null || entity.getListId().longValue()<=0 ) {
      entity.setListId(OracleSequencePKGenerator.getInstance().getNextPKValue("STG_INSERT_MAPPING_CONFIG__ID"));
}
      DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into STG_INSERT_MAPPING_CONFIG(");
	buf.append("LIST_ID");
	buf.append(",RULE_ID");
	buf.append(",OFFLINE_RULE_ID");
	buf.append(",VOUCHER_RULE_ID");
	buf.append(",CAMPAIGN_RULE_ID");
	buf.append(",INSERT_NAME");
	buf.append(",SEQUENCE_NO");
	buf.append(",INSERTION_EFFECTIVE_DATE");
	buf.append(",INSERTION_EXPIRY_DATE");
	buf.append(",EXCLUDE_RE_FULFILLMENT");
	buf.append(")");
	buf.append(" values(");
    for (int i=0; i<10; i++) {
	  buf.append(i==0 ? "?" : ",?");
	}
	buf.append(")");
	Log.debug(StgInsertMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getListId() != null) ps.setLong(pos++, entity.getListId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgInsertMappingConfigDao.class, "listId:" + entity.getListId());
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgInsertMappingConfigDao.class, "ruleId:" + entity.getRuleId());
	  if(entity.getOfflineRuleId() != null) ps.setLong(pos++, entity.getOfflineRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgInsertMappingConfigDao.class, "offlineRuleId:" + entity.getOfflineRuleId());
	  if(entity.getVoucherRuleId() != null) ps.setLong(pos++, entity.getVoucherRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgInsertMappingConfigDao.class, "voucherRuleId:" + entity.getVoucherRuleId());
	  if(entity.getCampaignRuleId() != null) ps.setLong(pos++, entity.getCampaignRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgInsertMappingConfigDao.class, "campaignRuleId:" + entity.getCampaignRuleId());
	  ps.setString(pos++, entity.getInsertName());
	  Log.debug(StgInsertMappingConfigDao.class, "insertName:" + entity.getInsertName());
	  ps.setString(pos++, entity.getSequenceNo());
	  Log.debug(StgInsertMappingConfigDao.class, "sequenceNo:" + entity.getSequenceNo());
	  ps.setTimestamp(pos++, entity.getInsertionEffectiveDate() != null ? new java.sql.Timestamp(entity.getInsertionEffectiveDate().getTime()) : null);
	  Log.debug(StgInsertMappingConfigDao.class, "insertionEffectiveDate:" + entity.getInsertionEffectiveDate());
	  ps.setTimestamp(pos++, entity.getInsertionExpiryDate() != null ? new java.sql.Timestamp(entity.getInsertionExpiryDate().getTime()) : null);
	  Log.debug(StgInsertMappingConfigDao.class, "insertionExpiryDate:" + entity.getInsertionExpiryDate());
	  ps.setString(pos++, entity.getExcludeReFulfillment());
	  Log.debug(StgInsertMappingConfigDao.class, "excludeReFulfillment:" + entity.getExcludeReFulfillment());
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}
    return entity.getListId();
  }
  
  public void update(StgInsertMappingConfig entity) throws GenericException{
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
	buf.append("update STG_INSERT_MAPPING_CONFIG set ");
	buf.append("LIST_ID=?");
	buf.append(",RULE_ID=?");
	buf.append(",OFFLINE_RULE_ID=?");
	buf.append(",VOUCHER_RULE_ID=?");
	buf.append(",CAMPAIGN_RULE_ID=?");
	buf.append(",INSERT_NAME=?");
	buf.append(",SEQUENCE_NO=?");
	buf.append(",INSERTION_EFFECTIVE_DATE=?");
	buf.append(",INSERTION_EXPIRY_DATE=?");
	buf.append(",EXCLUDE_RE_FULFILLMENT=?");
	buf.append(" where 1 = 1");
	buf.append("   and LIST_ID = ?");
	Log.debug(StgInsertMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getListId() != null) ps.setLong(pos++, entity.getListId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getOfflineRuleId() != null) ps.setLong(pos++, entity.getOfflineRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getVoucherRuleId() != null) ps.setLong(pos++, entity.getVoucherRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getCampaignRuleId() != null) ps.setLong(pos++, entity.getCampaignRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setString(pos++, entity.getInsertName());
	  ps.setString(pos++, entity.getSequenceNo());
	  ps.setTimestamp(pos++, entity.getInsertionEffectiveDate() != null ? new java.sql.Timestamp(entity.getInsertionEffectiveDate().getTime()) : null);
	  ps.setTimestamp(pos++, entity.getInsertionExpiryDate() != null ? new java.sql.Timestamp(entity.getInsertionExpiryDate().getTime()) : null);
	  ps.setString(pos++, entity.getExcludeReFulfillment());
	  if(entity.getListId() != null) ps.setLong(pos++, entity.getListId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public void remove( java.lang.Long listId ) throws GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       StgInsertMappingConfig entity = null;
       try {
          Session session = HibernateUtil.currentSession();
          entity = this.load( listId );
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
	buf.append("delete from STG_INSERT_MAPPING_CONFIG");
	buf.append(" where 1 = 1");
	buf.append("   and LIST_ID = ?");
	Log.debug(StgInsertMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(listId != null) ps.setLong(pos++, listId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public StgInsertMappingConfig load( java.lang.Long listId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
          if(listId==null) {
	    return null;
	  }
          Serializable sId = listId;
	  o = session.load(StgInsertMappingConfig.class,sId);
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
       return (StgInsertMappingConfig)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from STG_INSERT_MAPPING_CONFIG ");
	buf.append(" where 1=1 ");
	buf.append("   and LIST_ID = ?");
	Log.debug(StgInsertMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(listId != null) ps.setLong(pos++, listId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
      StgInsertMappingConfig entity = null;
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
