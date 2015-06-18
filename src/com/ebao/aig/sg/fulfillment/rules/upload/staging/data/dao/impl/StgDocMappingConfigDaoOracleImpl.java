

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

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.StgDocMappingConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgDocMappingConfig;
import com.ebao.foundation.common.config.Env;
import com.ebao.gs.pub.util.HibernateUtil;
import com.ebao.pub.framework.ExceptionFactory;
import com.ebao.pub.framework.GenericException;
import com.ebao.pub.framework.data.internal.OracleSequencePKGenerator;
import com.ebao.pub.util.DBean;
import com.ebao.pub.util.Log;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public class StgDocMappingConfigDaoOracleImpl implements StgDocMappingConfigDao{
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
      table = "STG_DOC_MAPPING_CONFIG";
      columns.put("docRuleId", "DOC_RULE_ID");
      columnTypes.put("docRuleId", "java.lang.Long");
      columns.put("ruleId", "RULE_ID");
      columnTypes.put("ruleId", "java.lang.Long");
      columns.put("coverTypeRuleId", "COVER_TYPE_RULE_ID");
      columnTypes.put("coverTypeRuleId", "java.lang.Long");
      columns.put("platformRuleId", "PLATFORM_RULE_ID");
      columnTypes.put("platformRuleId", "java.lang.Long");
      columns.put("campaignRuleId", "CAMPAIGN_RULE_ID");
      columnTypes.put("campaignRuleId", "java.lang.Long");
      columns.put("autoProducerCtMapId", "AUTO_PRODUCER_CT_MAP_ID");
      columnTypes.put("autoProducerCtMapId", "java.lang.Long");
      columns.put("templateId", "TEMPLATE_ID");
      columnTypes.put("templateId", "java.lang.String");
      columns.put("sequenceNo", "SEQUENCE_NO");
      columnTypes.put("sequenceNo", "java.lang.String");
      columns.put("documentClubType", "DOCUMENT_CLUB_TYPE");
      columnTypes.put("documentClubType", "java.lang.String");
      columns.put("recipient", "RECIPIENT");
      columnTypes.put("recipient", "java.lang.String");
      columns.put("marketingLetter", "MARKETING_LETTER");
      columnTypes.put("marketingLetter", "java.lang.String");
  }

  protected Object fillObject(ResultSet rs) throws SQLException {
    return fillEntity(rs);
  }
  
  public StgDocMappingConfig fillEntity(ResultSet rs) throws SQLException {
      StgDocMappingConfig entity = new StgDocMappingConfig();
      entity.setDocRuleId(new Long(rs.getLong("DOC_RULE_ID")));
      if (rs.wasNull()) {
          entity.setDocRuleId(null);
      }
      entity.setRuleId(new Long(rs.getLong("RULE_ID")));
      if (rs.wasNull()) {
          entity.setRuleId(null);
      }
      entity.setCoverTypeRuleId(new Long(rs.getLong("COVER_TYPE_RULE_ID")));
      if (rs.wasNull()) {
          entity.setCoverTypeRuleId(null);
      }
      entity.setPlatformRuleId(new Long(rs.getLong("PLATFORM_RULE_ID")));
      if (rs.wasNull()) {
          entity.setPlatformRuleId(null);
      }
      entity.setCampaignRuleId(new Long(rs.getLong("CAMPAIGN_RULE_ID")));
      if (rs.wasNull()) {
          entity.setCampaignRuleId(null);
      }
      entity.setAutoProducerCtMapId(new Long(rs.getLong("AUTO_PRODUCER_CT_MAP_ID")));
      if (rs.wasNull()) {
          entity.setAutoProducerCtMapId(null);
      }
      entity.setTemplateId(rs.getString("TEMPLATE_ID"));
      entity.setSequenceNo(rs.getString("SEQUENCE_NO"));
      entity.setDocumentClubType(rs.getString("DOCUMENT_CLUB_TYPE"));
      entity.setRecipient(rs.getString("RECIPIENT"));
      entity.setMarketingLetter(rs.getString("MARKETING_LETTER"));
      return entity;
  }
  
  public java.lang.Long create(StgDocMappingConfig entity) throws GenericException{
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
if ( entity.getDocRuleId() == null || entity.getDocRuleId().longValue()<=0 ) {
      entity.setDocRuleId(OracleSequencePKGenerator.getInstance().getNextPKValue("STG_DOC_MAPPING_CONFIG__DOC_ID"));
}
      DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into STG_DOC_MAPPING_CONFIG(");
	buf.append("DOC_RULE_ID");
	buf.append(",RULE_ID");
	buf.append(",COVER_TYPE_RULE_ID");
	buf.append(",PLATFORM_RULE_ID");
	buf.append(",CAMPAIGN_RULE_ID");
	buf.append(",AUTO_PRODUCER_CT_MAP_ID");
	buf.append(",TEMPLATE_ID");
	buf.append(",SEQUENCE_NO");
	buf.append(",DOCUMENT_CLUB_TYPE");
	buf.append(",RECIPIENT");
	buf.append(",MARKETING_LETTER");
	buf.append(")");
	buf.append(" values(");
    for (int i=0; i<11; i++) {
	  buf.append(i==0 ? "?" : ",?");
	}
	buf.append(")");
	Log.debug(StgDocMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getDocRuleId() != null) ps.setLong(pos++, entity.getDocRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgDocMappingConfigDao.class, "docRuleId:" + entity.getDocRuleId());
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgDocMappingConfigDao.class, "ruleId:" + entity.getRuleId());
	  if(entity.getCoverTypeRuleId() != null) ps.setLong(pos++, entity.getCoverTypeRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgDocMappingConfigDao.class, "coverTypeRuleId:" + entity.getCoverTypeRuleId());
	  if(entity.getPlatformRuleId() != null) ps.setLong(pos++, entity.getPlatformRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgDocMappingConfigDao.class, "platformRuleId:" + entity.getPlatformRuleId());
	  if(entity.getCampaignRuleId() != null) ps.setLong(pos++, entity.getCampaignRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgDocMappingConfigDao.class, "campaignRuleId:" + entity.getCampaignRuleId());
	  if(entity.getAutoProducerCtMapId() != null) ps.setLong(pos++, entity.getAutoProducerCtMapId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgDocMappingConfigDao.class, "autoProducerCtMapId:" + entity.getAutoProducerCtMapId());
	  ps.setString(pos++, entity.getTemplateId());
	  Log.debug(StgDocMappingConfigDao.class, "templateId:" + entity.getTemplateId());
	  ps.setString(pos++, entity.getSequenceNo());
	  Log.debug(StgDocMappingConfigDao.class, "sequenceNo:" + entity.getSequenceNo());
	  ps.setString(pos++, entity.getDocumentClubType());
	  Log.debug(StgDocMappingConfigDao.class, "documentClubType:" + entity.getDocumentClubType());
	  ps.setString(pos++, entity.getRecipient());
	  Log.debug(StgDocMappingConfigDao.class, "recipient:" + entity.getRecipient());
	  ps.setString(pos++, entity.getMarketingLetter());
	  Log.debug(StgDocMappingConfigDao.class, "marketingLetter:" + entity.getMarketingLetter());
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}
    return entity.getDocRuleId();
  }
  
  public void update(StgDocMappingConfig entity) throws GenericException{
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
	buf.append("update STG_DOC_MAPPING_CONFIG set ");
	buf.append("DOC_RULE_ID=?");
	buf.append(",RULE_ID=?");
	buf.append(",COVER_TYPE_RULE_ID=?");
	buf.append(",PLATFORM_RULE_ID=?");
	buf.append(",CAMPAIGN_RULE_ID=?");
	buf.append(",AUTO_PRODUCER_CT_MAP_ID=?");
	buf.append(",TEMPLATE_ID=?");
	buf.append(",SEQUENCE_NO=?");
	buf.append(",DOCUMENT_CLUB_TYPE=?");
	buf.append(",RECIPIENT=?");
	buf.append(",MARKETING_LETTER=?");
	buf.append(" where 1 = 1");
	buf.append("   and DOC_RULE_ID = ?");
	Log.debug(StgDocMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getDocRuleId() != null) ps.setLong(pos++, entity.getDocRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getCoverTypeRuleId() != null) ps.setLong(pos++, entity.getCoverTypeRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getPlatformRuleId() != null) ps.setLong(pos++, entity.getPlatformRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getCampaignRuleId() != null) ps.setLong(pos++, entity.getCampaignRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getAutoProducerCtMapId() != null) ps.setLong(pos++, entity.getAutoProducerCtMapId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setString(pos++, entity.getTemplateId());
	  ps.setString(pos++, entity.getSequenceNo());
	  ps.setString(pos++, entity.getDocumentClubType());
	  ps.setString(pos++, entity.getRecipient());
	  ps.setString(pos++, entity.getMarketingLetter());
	  if(entity.getDocRuleId() != null) ps.setLong(pos++, entity.getDocRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public void remove( java.lang.Long docRuleId ) throws GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       StgDocMappingConfig entity = null;
       try {
          Session session = HibernateUtil.currentSession();
          entity = this.load( docRuleId );
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
	buf.append("delete from STG_DOC_MAPPING_CONFIG");
	buf.append(" where 1 = 1");
	buf.append("   and DOC_RULE_ID = ?");
	Log.debug(StgDocMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(docRuleId != null) ps.setLong(pos++, docRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public StgDocMappingConfig load( java.lang.Long docRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
          if(docRuleId==null) {
	    return null;
	  }
          Serializable sId = docRuleId;
	  o = session.load(StgDocMappingConfig.class,sId);
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
       return (StgDocMappingConfig)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from STG_DOC_MAPPING_CONFIG ");
	buf.append(" where 1=1 ");
	buf.append("   and DOC_RULE_ID = ?");
	Log.debug(StgDocMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(docRuleId != null) ps.setLong(pos++, docRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
      StgDocMappingConfig entity = null;
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
