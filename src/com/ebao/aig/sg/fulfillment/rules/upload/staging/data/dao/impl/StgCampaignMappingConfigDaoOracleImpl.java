

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

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.StgCampaignMappingConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgCampaignMappingConfig;
import com.ebao.foundation.common.config.Env;
import com.ebao.gs.pub.util.HibernateUtil;
import com.ebao.pub.framework.ExceptionFactory;
import com.ebao.pub.framework.GenericException;
import com.ebao.pub.framework.data.internal.OracleSequencePKGenerator;
import com.ebao.pub.util.DBean;
import com.ebao.pub.util.Log;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public class StgCampaignMappingConfigDaoOracleImpl implements StgCampaignMappingConfigDao{
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
      table = "STG_CAMPAIGN_MAPPING_CONFIG";
      columns.put("ruleId", "RULE_ID");
      columnTypes.put("ruleId", "java.lang.Long");
      columns.put("campaignRuleId", "CAMPAIGN_RULE_ID");
      columnTypes.put("campaignRuleId", "java.lang.Long");
      columns.put("campaignCode", "CAMPAIGN_CODE");
      columnTypes.put("campaignCode", "java.lang.String");
      columns.put("attachmentType", "ATTACHMENT_TYPE");
      columnTypes.put("attachmentType", "java.lang.String");
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
  
  public StgCampaignMappingConfig fillEntity(ResultSet rs) throws SQLException {
      StgCampaignMappingConfig entity = new StgCampaignMappingConfig();
      entity.setRuleId(new Long(rs.getLong("RULE_ID")));
      if (rs.wasNull()) {
          entity.setRuleId(null);
      }
      entity.setCampaignRuleId(new Long(rs.getLong("CAMPAIGN_RULE_ID")));
      if (rs.wasNull()) {
          entity.setCampaignRuleId(null);
      }
      entity.setCampaignCode(rs.getString("CAMPAIGN_CODE"));
      entity.setAttachmentType(rs.getString("ATTACHMENT_TYPE"));
      entity.setInsertionEffectiveDate(rs.getTimestamp("INSERTION_EFFECTIVE_DATE"));
      entity.setInsertionExpiryDate(rs.getTimestamp("INSERTION_EXPIRY_DATE"));
      entity.setExcludeReFulfillment(rs.getString("EXCLUDE_RE_FULFILLMENT"));
      return entity;
  }
  
  public java.lang.Long create(StgCampaignMappingConfig entity) throws GenericException{
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
if ( entity.getCampaignRuleId() == null || entity.getCampaignRuleId().longValue()<=0 ) {
      entity.setCampaignRuleId(OracleSequencePKGenerator.getInstance().getNextPKValue("STG_CAMPAIGN_MAPPING_CONF__ID"));
}
      DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into STG_CAMPAIGN_MAPPING_CONFIG(");
	buf.append("RULE_ID");
	buf.append(",CAMPAIGN_RULE_ID");
	buf.append(",CAMPAIGN_CODE");
	buf.append(",ATTACHMENT_TYPE");
	buf.append(",INSERTION_EFFECTIVE_DATE");
	buf.append(",INSERTION_EXPIRY_DATE");
	buf.append(",EXCLUDE_RE_FULFILLMENT");
	buf.append(")");
	buf.append(" values(");
    for (int i=0; i<7; i++) {
	  buf.append(i==0 ? "?" : ",?");
	}
	buf.append(")");
	Log.debug(StgCampaignMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgCampaignMappingConfigDao.class, "ruleId:" + entity.getRuleId());
	  if(entity.getCampaignRuleId() != null) ps.setLong(pos++, entity.getCampaignRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgCampaignMappingConfigDao.class, "campaignRuleId:" + entity.getCampaignRuleId());
	  ps.setString(pos++, entity.getCampaignCode());
	  Log.debug(StgCampaignMappingConfigDao.class, "campaignCode:" + entity.getCampaignCode());
	  ps.setString(pos++, entity.getAttachmentType());
	  Log.debug(StgCampaignMappingConfigDao.class, "attachmentType:" + entity.getAttachmentType());
	  ps.setTimestamp(pos++, entity.getInsertionEffectiveDate() != null ? new java.sql.Timestamp(entity.getInsertionEffectiveDate().getTime()) : null);
	  Log.debug(StgCampaignMappingConfigDao.class, "insertionEffectiveDate:" + entity.getInsertionEffectiveDate());
	  ps.setTimestamp(pos++, entity.getInsertionExpiryDate() != null ? new java.sql.Timestamp(entity.getInsertionExpiryDate().getTime()) : null);
	  Log.debug(StgCampaignMappingConfigDao.class, "insertionExpiryDate:" + entity.getInsertionExpiryDate());
	  ps.setString(pos++, entity.getExcludeReFulfillment());
	  Log.debug(StgCampaignMappingConfigDao.class, "excludeReFulfillment:" + entity.getExcludeReFulfillment());
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}
    return entity.getCampaignRuleId();
  }
  
  public void update(StgCampaignMappingConfig entity) throws GenericException{
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
	buf.append("update STG_CAMPAIGN_MAPPING_CONFIG set ");
	buf.append("RULE_ID=?");
	buf.append(",CAMPAIGN_RULE_ID=?");
	buf.append(",CAMPAIGN_CODE=?");
	buf.append(",ATTACHMENT_TYPE=?");
	buf.append(",INSERTION_EFFECTIVE_DATE=?");
	buf.append(",INSERTION_EXPIRY_DATE=?");
	buf.append(",EXCLUDE_RE_FULFILLMENT=?");
	buf.append(" where 1 = 1");
	buf.append("   and CAMPAIGN_RULE_ID = ?");
	Log.debug(StgCampaignMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getCampaignRuleId() != null) ps.setLong(pos++, entity.getCampaignRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setString(pos++, entity.getCampaignCode());
	  ps.setString(pos++, entity.getAttachmentType());
	  ps.setTimestamp(pos++, entity.getInsertionEffectiveDate() != null ? new java.sql.Timestamp(entity.getInsertionEffectiveDate().getTime()) : null);
	  ps.setTimestamp(pos++, entity.getInsertionExpiryDate() != null ? new java.sql.Timestamp(entity.getInsertionExpiryDate().getTime()) : null);
	  ps.setString(pos++, entity.getExcludeReFulfillment());
	  if(entity.getCampaignRuleId() != null) ps.setLong(pos++, entity.getCampaignRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public void remove( java.lang.Long campaignRuleId ) throws GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       StgCampaignMappingConfig entity = null;
       try {
          Session session = HibernateUtil.currentSession();
          entity = this.load( campaignRuleId );
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
	buf.append("delete from STG_CAMPAIGN_MAPPING_CONFIG");
	buf.append(" where 1 = 1");
	buf.append("   and CAMPAIGN_RULE_ID = ?");
	Log.debug(StgCampaignMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(campaignRuleId != null) ps.setLong(pos++, campaignRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public StgCampaignMappingConfig load( java.lang.Long campaignRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
          if(campaignRuleId==null) {
	    return null;
	  }
          Serializable sId = campaignRuleId;
	  o = session.load(StgCampaignMappingConfig.class,sId);
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
       return (StgCampaignMappingConfig)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from STG_CAMPAIGN_MAPPING_CONFIG ");
	buf.append(" where 1=1 ");
	buf.append("   and CAMPAIGN_RULE_ID = ?");
	Log.debug(StgCampaignMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(campaignRuleId != null) ps.setLong(pos++, campaignRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
      StgCampaignMappingConfig entity = null;
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
