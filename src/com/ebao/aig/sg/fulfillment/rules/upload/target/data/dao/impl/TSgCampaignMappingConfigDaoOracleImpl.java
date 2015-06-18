

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

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgCampaignMappingConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgCampaignMappingConfig;
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

public class TSgCampaignMappingConfigDaoOracleImpl implements TSgCampaignMappingConfigDao{
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
      table = "T_SG_CAMPAIGN_MAPPING_CONFIG";
      columns.put("ruleId", "RULE_ID");
      columnTypes.put("ruleId", "java.lang.Long");
      columns.put("campaignRuleId", "CAMPAIGN_RULE_ID");
      columnTypes.put("campaignRuleId", "java.lang.Long");
      columns.put("campaignCode", "CAMPAIGN_CODE");
      columnTypes.put("campaignCode", "java.lang.String");
      columns.put("attachmentType", "ATTACHMENT_TYPE");
      columnTypes.put("attachmentType", "java.lang.Integer");
      columns.put("insertionEffectiveDate", "INSERTION_EFFECTIVE_DATE");
      columnTypes.put("insertionEffectiveDate", "java.util.Date");
      columns.put("insertionExpiryDate", "INSERTION_EXPIRY_DATE");
      columnTypes.put("insertionExpiryDate", "java.util.Date");
      columns.put("excludeReFulfillment", "EXCLUDE_RE_FULFILLMENT");
      columnTypes.put("excludeReFulfillment", "java.lang.Integer");
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
  
  public TSgCampaignMappingConfig fillEntity(ResultSet rs) throws SQLException {
      TSgCampaignMappingConfig entity = new TSgCampaignMappingConfig();
      entity.setRuleId(new Long(rs.getLong("RULE_ID")));
      if (rs.wasNull()) {
          entity.setRuleId(null);
      }
      entity.setCampaignRuleId(new Long(rs.getLong("CAMPAIGN_RULE_ID")));
      if (rs.wasNull()) {
          entity.setCampaignRuleId(null);
      }
      entity.setCampaignCode(rs.getString("CAMPAIGN_CODE"));
      entity.setAttachmentType(new Integer(rs.getInt("ATTACHMENT_TYPE")));
      if (rs.wasNull()) {
          entity.setAttachmentType(null);
      }
      entity.setInsertionEffectiveDate(rs.getTimestamp("INSERTION_EFFECTIVE_DATE"));
      entity.setInsertionExpiryDate(rs.getTimestamp("INSERTION_EXPIRY_DATE"));
      entity.setExcludeReFulfillment(new Integer(rs.getInt("EXCLUDE_RE_FULFILLMENT")));
      if (rs.wasNull()) {
          entity.setExcludeReFulfillment(null);
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
  
  public java.lang.Long create(TSgCampaignMappingConfig entity) throws GenericException{
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
      entity.setCampaignRuleId(OracleSequencePKGenerator.getInstance().getNextPKValue("S_SG_CAMPAIGN_MAPPING_CONFIG__"));
}
      DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into T_SG_CAMPAIGN_MAPPING_CONFIG(");
	buf.append("RULE_ID");
	buf.append(",CAMPAIGN_RULE_ID");
	buf.append(",CAMPAIGN_CODE");
	buf.append(",ATTACHMENT_TYPE");
	buf.append(",INSERTION_EFFECTIVE_DATE");
	buf.append(",INSERTION_EXPIRY_DATE");
	buf.append(",EXCLUDE_RE_FULFILLMENT");
	buf.append(",INSERT_TIME");
	buf.append(",UPDATE_TIME");
	buf.append(",INSERTED_BY");
	buf.append(",UPDATED_BY");
	buf.append(")");
	buf.append(" values(");
    for (int i=0; i<11; i++) {
	  buf.append(i==0 ? "?" : ",?");
	}
	buf.append(")");
	Log.debug(TSgCampaignMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgCampaignMappingConfigDao.class, "ruleId:" + entity.getRuleId());
	  if(entity.getCampaignRuleId() != null) ps.setLong(pos++, entity.getCampaignRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgCampaignMappingConfigDao.class, "campaignRuleId:" + entity.getCampaignRuleId());
	  ps.setString(pos++, entity.getCampaignCode());
	  Log.debug(TSgCampaignMappingConfigDao.class, "campaignCode:" + entity.getCampaignCode());
	  if(entity.getAttachmentType() != null) ps.setInt(pos++, entity.getAttachmentType().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgCampaignMappingConfigDao.class, "attachmentType:" + entity.getAttachmentType());
	  ps.setTimestamp(pos++, entity.getInsertionEffectiveDate() != null ? new java.sql.Timestamp(entity.getInsertionEffectiveDate().getTime()) : null);
	  Log.debug(TSgCampaignMappingConfigDao.class, "insertionEffectiveDate:" + entity.getInsertionEffectiveDate());
	  ps.setTimestamp(pos++, entity.getInsertionExpiryDate() != null ? new java.sql.Timestamp(entity.getInsertionExpiryDate().getTime()) : null);
	  Log.debug(TSgCampaignMappingConfigDao.class, "insertionExpiryDate:" + entity.getInsertionExpiryDate());
	  if(entity.getExcludeReFulfillment() != null) ps.setInt(pos++, entity.getExcludeReFulfillment().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgCampaignMappingConfigDao.class, "excludeReFulfillment:" + entity.getExcludeReFulfillment());
	  ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  Log.debug(TSgCampaignMappingConfigDao.class, "insertTime:" + entity.getInsertTime());
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  Log.debug(TSgCampaignMappingConfigDao.class, "updateTime:" + entity.getUpdateTime());
	  if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  Log.debug(TSgCampaignMappingConfigDao.class, "insertedBy:" + entity.getInsertedBy());
	  if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  Log.debug(TSgCampaignMappingConfigDao.class, "updatedBy:" + entity.getUpdatedBy());
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
  
  public void update(TSgCampaignMappingConfig entity) throws GenericException{
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
	buf.append("update T_SG_CAMPAIGN_MAPPING_CONFIG set ");
	buf.append("RULE_ID=?");
	buf.append(",CAMPAIGN_RULE_ID=?");
	buf.append(",CAMPAIGN_CODE=?");
	buf.append(",ATTACHMENT_TYPE=?");
	buf.append(",INSERTION_EFFECTIVE_DATE=?");
	buf.append(",INSERTION_EXPIRY_DATE=?");
	buf.append(",EXCLUDE_RE_FULFILLMENT=?");
	buf.append(",UPDATE_TIME=?");
	buf.append(",UPDATED_BY=?");
	buf.append(" where 1 = 1");
	buf.append("   and CAMPAIGN_RULE_ID = ?");
	Log.debug(TSgCampaignMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getCampaignRuleId() != null) ps.setLong(pos++, entity.getCampaignRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setString(pos++, entity.getCampaignCode());
	  if(entity.getAttachmentType() != null) ps.setInt(pos++, entity.getAttachmentType().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setTimestamp(pos++, entity.getInsertionEffectiveDate() != null ? new java.sql.Timestamp(entity.getInsertionEffectiveDate().getTime()) : null);
	  ps.setTimestamp(pos++, entity.getInsertionExpiryDate() != null ? new java.sql.Timestamp(entity.getInsertionExpiryDate().getTime()) : null);
	  if(entity.getExcludeReFulfillment() != null) ps.setInt(pos++, entity.getExcludeReFulfillment().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
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
       TSgCampaignMappingConfig entity = null;
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
	buf.append("delete from T_SG_CAMPAIGN_MAPPING_CONFIG");
	buf.append(" where 1 = 1");
	buf.append("   and CAMPAIGN_RULE_ID = ?");
	Log.debug(TSgCampaignMappingConfigDao.class, buf.toString());
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
  
  public TSgCampaignMappingConfig load( java.lang.Long campaignRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
          if(campaignRuleId==null) {
	    return null;
	  }
          Serializable sId = campaignRuleId;
	  o = session.load(TSgCampaignMappingConfig.class,sId);
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
       return (TSgCampaignMappingConfig)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from T_SG_CAMPAIGN_MAPPING_CONFIG ");
	buf.append(" where 1=1 ");
	buf.append("   and CAMPAIGN_RULE_ID = ?");
	Log.debug(TSgCampaignMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(campaignRuleId != null) ps.setLong(pos++, campaignRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
      TSgCampaignMappingConfig entity = null;
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

public Long getSequenceID(Long masterRule) throws SQLException,
		ClassNotFoundException {
	// TODO Auto-generated method stub
	DBean db = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Long serialId = null;
                try{ 
                                StringBuffer selectQuery = new StringBuffer();
                                selectQuery.append("SELECT max(CAMPAIGN_RULE_ID) AS SERIAL_ID FROM T_SG_CAMPAIGN_MAPPING_CONFIG where RULE_ID = ? ");
                db = new DBean(false);
                db.connect();
                Connection con = db.getConnection();
                //
                ps = con.prepareStatement(selectQuery.toString());
               
          	  if(masterRule != null) 
          		  ps.setLong(1, masterRule.longValue()); 
          	  else ps.setNull(1, Types.NUMERIC);
          	rs = ps.executeQuery();
                //
                //ps = con.prepareStatement(selectQuery.toString());
                //rs = ps.executeQuery();
                while (rs.next()) {
                                serialId = rs.getLong("SERIAL_ID");
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
                
				if(serialId==0){
                	
					serialId=(long) 100;
                	return serialId;
				}
                else
                return serialId+1;
	//return null;
}
  
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}
