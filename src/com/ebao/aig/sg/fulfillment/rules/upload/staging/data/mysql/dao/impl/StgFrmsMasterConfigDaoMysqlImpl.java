

package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.mysql.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.StgFrmsMasterConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgFrmsMasterConfig;
import com.ebao.foundation.common.config.Env;
import com.ebao.gs.pub.util.HibernateUtil;
import com.ebao.pub.framework.ExceptionFactory;
import com.ebao.pub.framework.GenericException;
import com.ebao.pub.framework.data.internal.OracleSequencePKGenerator;
import com.ebao.pub.util.DBean;
import com.ebao.pub.util.Log;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public class StgFrmsMasterConfigDaoMysqlImpl implements StgFrmsMasterConfigDao{
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
      table = "STG_FRMS_MASTER_CONFIG";
      columns.put("ruleId", "RULE_ID");
      columnTypes.put("ruleId", "java.lang.Long");
      columns.put("transactionType", "TRANSACTION_TYPE");
      columnTypes.put("transactionType", "java.lang.String");
      columns.put("documentType", "DOCUMENT_TYPE");
      columnTypes.put("documentType", "java.lang.String");
      columns.put("lobId", "LOB_ID");
      columnTypes.put("lobId", "java.lang.String");
      columns.put("productCode", "PRODUCT_CODE");
      columnTypes.put("productCode", "java.lang.String");
      columns.put("planGroupId", "PLAN_GROUP_ID");
      columnTypes.put("planGroupId", "java.lang.String");
      columns.put("planName", "PLAN_NAME");
      columnTypes.put("planName", "java.lang.String");
      columns.put("effectiveDate", "EFFECTIVE_DATE");
      columnTypes.put("effectiveDate", "java.util.Date");
      columns.put("expiryDate", "EXPIRY_DATE");
      columnTypes.put("expiryDate", "java.util.Date");
      columns.put("statusId", "STATUS_ID");
      columnTypes.put("statusId", "java.lang.String");
      columns.put("priority", "PRIORITY");
      columnTypes.put("priority", "java.lang.String");
      columns.put("cvrTypeRuleAplcbl", "CVR_TYPE_RULE_APLCBL");
      columnTypes.put("cvrTypeRuleAplcbl", "java.lang.String");
      columns.put("platformSpcRuleChk", "PLATFORM_SPC_RULE_CHK");
      columnTypes.put("platformSpcRuleChk", "java.lang.String");
      columns.put("producerRuleChk", "PRODUCER_RULE_CHK");
      columnTypes.put("producerRuleChk", "java.lang.String");
      columns.put("autoSpcRuleChk", "AUTO_SPC_RULE_CHK");
      columnTypes.put("autoSpcRuleChk", "java.lang.String");
      columns.put("voucherAplcbl", "VOUCHER_APLCBL");
      columnTypes.put("voucherAplcbl", "java.lang.String");
      columns.put("checkCampaign", "CHECK_CAMPAIGN");
      columnTypes.put("checkCampaign", "java.lang.String");
      columns.put("producerExpChk", "PRODUCER_EXP_CHK");
      columnTypes.put("producerExpChk", "java.lang.String");
      columns.put("gstProducerChk", "GST_PRODUCER_CHK");
      columnTypes.put("gstProducerChk", "java.lang.String");
      columns.put("dnmChk", "DNM_CHK");
      columnTypes.put("dnmChk", "java.lang.String");
      columns.put("ruleDescription", "RULE_DESCRIPTION");
      columnTypes.put("ruleDescription", "java.lang.String");
  }

  protected Object fillObject(ResultSet rs) throws SQLException {
    return fillEntity(rs);
  }
  
  public StgFrmsMasterConfig fillEntity(ResultSet rs) throws SQLException {
      StgFrmsMasterConfig entity = new StgFrmsMasterConfig();
      entity.setRuleId(new Long(rs.getLong("RULE_ID")));
      if (rs.wasNull()) {
          entity.setRuleId(null);
      }
      entity.setTransactionType(rs.getString("TRANSACTION_TYPE"));
      entity.setDocumentType(rs.getString("DOCUMENT_TYPE"));
      entity.setLobId(rs.getString("LOB_ID"));
      entity.setProductCode(rs.getString("PRODUCT_CODE"));
      entity.setPlanGroupId(rs.getString("PLAN_GROUP_ID"));
      entity.setPlanName(rs.getString("PLAN_NAME"));
      entity.setEffectiveDate(rs.getTimestamp("EFFECTIVE_DATE"));
      entity.setExpiryDate(rs.getTimestamp("EXPIRY_DATE"));
      entity.setStatusId(rs.getString("STATUS_ID"));
      entity.setPriority(rs.getString("PRIORITY"));
      entity.setCvrTypeRuleAplcbl(rs.getString("CVR_TYPE_RULE_APLCBL"));
      entity.setPlatformSpcRuleChk(rs.getString("PLATFORM_SPC_RULE_CHK"));
      entity.setProducerRuleChk(rs.getString("PRODUCER_RULE_CHK"));
      entity.setAutoSpcRuleChk(rs.getString("AUTO_SPC_RULE_CHK"));
      entity.setVoucherAplcbl(rs.getString("VOUCHER_APLCBL"));
      entity.setCheckCampaign(rs.getString("CHECK_CAMPAIGN"));
      entity.setProducerExpChk(rs.getString("PRODUCER_EXP_CHK"));
      entity.setGstProducerChk(rs.getString("GST_PRODUCER_CHK"));
      entity.setDnmChk(rs.getString("DNM_CHK"));
      entity.setRuleDescription(rs.getString("RULE_DESCRIPTION"));
      return entity;
  }
  
  public java.lang.Long create(StgFrmsMasterConfig entity) throws GenericException{
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
if ( entity.getRuleId() == null || entity.getRuleId().longValue()<=0 ) {
      entity.setRuleId(OracleSequencePKGenerator.getInstance().getNextPKValue("STG_FRMS_MASTER_CONFIG__RULE_I"));
}*/
      DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into STG_FRMS_MASTER_CONFIG(");
	buf.append("RULE_ID");
	buf.append(",TRANSACTION_TYPE");
	buf.append(",DOCUMENT_TYPE");
	buf.append(",LOB_ID");
	buf.append(",PRODUCT_CODE");
	buf.append(",PLAN_GROUP_ID");
	buf.append(",PLAN_NAME");
	buf.append(",EFFECTIVE_DATE");
	buf.append(",EXPIRY_DATE");
	buf.append(",STATUS_ID");
	buf.append(",PRIORITY");
	buf.append(",CVR_TYPE_RULE_APLCBL");
	buf.append(",PLATFORM_SPC_RULE_CHK");
	buf.append(",PRODUCER_RULE_CHK");
	buf.append(",AUTO_SPC_RULE_CHK");
	buf.append(",VOUCHER_APLCBL");
	buf.append(",CHECK_CAMPAIGN");
	buf.append(",PRODUCER_EXP_CHK");
	buf.append(",GST_PRODUCER_CHK");
	buf.append(",DNM_CHK");
	buf.append(",RULE_DESCRIPTION");
	buf.append(")");
	buf.append(" values(");
    for (int i=0; i<21; i++) {
	  buf.append(i==0 ? "?" : ",?");
	}
	buf.append(")");
	Log.debug(StgFrmsMasterConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgFrmsMasterConfigDao.class, "ruleId:" + entity.getRuleId());
	  ps.setString(pos++, entity.getTransactionType());
	  Log.debug(StgFrmsMasterConfigDao.class, "transactionType:" + entity.getTransactionType());
	  ps.setString(pos++, entity.getDocumentType());
	  Log.debug(StgFrmsMasterConfigDao.class, "documentType:" + entity.getDocumentType());
	  ps.setString(pos++, entity.getLobId());
	  Log.debug(StgFrmsMasterConfigDao.class, "lobId:" + entity.getLobId());
	  ps.setString(pos++, entity.getProductCode());
	  Log.debug(StgFrmsMasterConfigDao.class, "productCode:" + entity.getProductCode());
	  ps.setString(pos++, entity.getPlanGroupId());
	  Log.debug(StgFrmsMasterConfigDao.class, "planGroupId:" + entity.getPlanGroupId());
	  ps.setString(pos++, entity.getPlanName());
	  Log.debug(StgFrmsMasterConfigDao.class, "planName:" + entity.getPlanName());
	  ps.setTimestamp(pos++, entity.getEffectiveDate() != null ? new java.sql.Timestamp(entity.getEffectiveDate().getTime()) : null);
	  Log.debug(StgFrmsMasterConfigDao.class, "effectiveDate:" + entity.getEffectiveDate());
	  ps.setTimestamp(pos++, entity.getExpiryDate() != null ? new java.sql.Timestamp(entity.getExpiryDate().getTime()) : null);
	  Log.debug(StgFrmsMasterConfigDao.class, "expiryDate:" + entity.getExpiryDate());
	  ps.setString(pos++, entity.getStatusId());
	  Log.debug(StgFrmsMasterConfigDao.class, "statusId:" + entity.getStatusId());
	  ps.setString(pos++, entity.getPriority());
	  Log.debug(StgFrmsMasterConfigDao.class, "priority:" + entity.getPriority());
	  ps.setString(pos++, entity.getCvrTypeRuleAplcbl());
	  Log.debug(StgFrmsMasterConfigDao.class, "cvrTypeRuleAplcbl:" + entity.getCvrTypeRuleAplcbl());
	  ps.setString(pos++, entity.getPlatformSpcRuleChk());
	  Log.debug(StgFrmsMasterConfigDao.class, "platformSpcRuleChk:" + entity.getPlatformSpcRuleChk());
	  ps.setString(pos++, entity.getProducerRuleChk());
	  Log.debug(StgFrmsMasterConfigDao.class, "producerRuleChk:" + entity.getProducerRuleChk());
	  ps.setString(pos++, entity.getAutoSpcRuleChk());
	  Log.debug(StgFrmsMasterConfigDao.class, "autoSpcRuleChk:" + entity.getAutoSpcRuleChk());
	  ps.setString(pos++, entity.getVoucherAplcbl());
	  Log.debug(StgFrmsMasterConfigDao.class, "voucherAplcbl:" + entity.getVoucherAplcbl());
	  ps.setString(pos++, entity.getCheckCampaign());
	  Log.debug(StgFrmsMasterConfigDao.class, "checkCampaign:" + entity.getCheckCampaign());
	  ps.setString(pos++, entity.getProducerExpChk());
	  Log.debug(StgFrmsMasterConfigDao.class, "producerExpChk:" + entity.getProducerExpChk());
	  ps.setString(pos++, entity.getGstProducerChk());
	  Log.debug(StgFrmsMasterConfigDao.class, "gstProducerChk:" + entity.getGstProducerChk());
	  ps.setString(pos++, entity.getDnmChk());
	  Log.debug(StgFrmsMasterConfigDao.class, "dnmChk:" + entity.getDnmChk());
	  ps.setString(pos++, entity.getRuleDescription());
	  Log.debug(StgFrmsMasterConfigDao.class, "ruleDescription:" + entity.getRuleDescription());
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}
    return entity.getRuleId();
  }
  
  public void update(StgFrmsMasterConfig entity) throws GenericException{
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
	buf.append("update STG_FRMS_MASTER_CONFIG set ");
	buf.append("RULE_ID=?");
	buf.append(",TRANSACTION_TYPE=?");
	buf.append(",DOCUMENT_TYPE=?");
	buf.append(",LOB_ID=?");
	buf.append(",PRODUCT_CODE=?");
	buf.append(",PLAN_GROUP_ID=?");
	buf.append(",PLAN_NAME=?");
	buf.append(",EFFECTIVE_DATE=?");
	buf.append(",EXPIRY_DATE=?");
	buf.append(",STATUS_ID=?");
	buf.append(",PRIORITY=?");
	buf.append(",CVR_TYPE_RULE_APLCBL=?");
	buf.append(",PLATFORM_SPC_RULE_CHK=?");
	buf.append(",PRODUCER_RULE_CHK=?");
	buf.append(",AUTO_SPC_RULE_CHK=?");
	buf.append(",VOUCHER_APLCBL=?");
	buf.append(",CHECK_CAMPAIGN=?");
	buf.append(",PRODUCER_EXP_CHK=?");
	buf.append(",GST_PRODUCER_CHK=?");
	buf.append(",DNM_CHK=?");
	buf.append(",RULE_DESCRIPTION=?");
	buf.append(" where 1 = 1");
	buf.append("   and RULE_ID = ?");
	Log.debug(StgFrmsMasterConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setString(pos++, entity.getTransactionType());
	  ps.setString(pos++, entity.getDocumentType());
	  ps.setString(pos++, entity.getLobId());
	  ps.setString(pos++, entity.getProductCode());
	  ps.setString(pos++, entity.getPlanGroupId());
	  ps.setString(pos++, entity.getPlanName());
	  ps.setTimestamp(pos++, entity.getEffectiveDate() != null ? new java.sql.Timestamp(entity.getEffectiveDate().getTime()) : null);
	  ps.setTimestamp(pos++, entity.getExpiryDate() != null ? new java.sql.Timestamp(entity.getExpiryDate().getTime()) : null);
	  ps.setString(pos++, entity.getStatusId());
	  ps.setString(pos++, entity.getPriority());
	  ps.setString(pos++, entity.getCvrTypeRuleAplcbl());
	  ps.setString(pos++, entity.getPlatformSpcRuleChk());
	  ps.setString(pos++, entity.getProducerRuleChk());
	  ps.setString(pos++, entity.getAutoSpcRuleChk());
	  ps.setString(pos++, entity.getVoucherAplcbl());
	  ps.setString(pos++, entity.getCheckCampaign());
	  ps.setString(pos++, entity.getProducerExpChk());
	  ps.setString(pos++, entity.getGstProducerChk());
	  ps.setString(pos++, entity.getDnmChk());
	  ps.setString(pos++, entity.getRuleDescription());
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public void remove( java.lang.Long ruleId ) throws GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       StgFrmsMasterConfig entity = null;
       try {
          Session session = HibernateUtil.currentSession();
          entity = this.load( ruleId );
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
	buf.append("delete from STG_FRMS_MASTER_CONFIG");
	buf.append(" where 1 = 1");
	buf.append("   and RULE_ID = ?");
	Log.debug(StgFrmsMasterConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(ruleId != null) ps.setLong(pos++, ruleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public StgFrmsMasterConfig load( java.lang.Long ruleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
          if(ruleId==null) {
	    return null;
	  }
          Serializable sId = ruleId;
	  o = session.load(StgFrmsMasterConfig.class,sId);
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
       return (StgFrmsMasterConfig)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from STG_FRMS_MASTER_CONFIG ");
	buf.append(" where 1=1 ");
	buf.append("   and RULE_ID = ?");
	Log.debug(StgFrmsMasterConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(ruleId != null) ps.setLong(pos++, ruleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
      StgFrmsMasterConfig entity = null;
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
