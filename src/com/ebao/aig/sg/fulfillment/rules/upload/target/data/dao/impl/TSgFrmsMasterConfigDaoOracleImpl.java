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

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgFrmsMasterConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgFrmsMasterConfig;
import com.ebao.foundation.common.config.Env;
import com.ebao.gs.pub.util.HibernateUtil;
import com.ebao.pub.framework.AppContext;
import com.ebao.pub.framework.ExceptionFactory;
import com.ebao.pub.framework.GenericException;
import com.ebao.pub.framework.ObjectNotFoundException;
import com.ebao.pub.framework.data.internal.OracleSequencePKGenerator;
import com.ebao.pub.util.DBean;
import com.ebao.pub.util.Log;

public class TSgFrmsMasterConfigDaoOracleImpl implements TSgFrmsMasterConfigDao {
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
	      table = "T_SG_FRMS_MASTER_CONFIG";
	      columns.put("ruleId", "RULE_ID");
	      columnTypes.put("ruleId", "java.lang.Long");
	      columns.put("transactionType", "TRANSACTION_TYPE");
	      columnTypes.put("transactionType", "java.lang.Integer");
	      columns.put("documentType", "DOCUMENT_TYPE");
	      columnTypes.put("documentType", "java.lang.Integer");
	      columns.put("lobId", "LOB_ID");
	      columnTypes.put("lobId", "java.lang.String");
	      columns.put("productCode", "PRODUCT_CODE");
	      columnTypes.put("productCode", "java.lang.String");
	      columns.put("planGroupId", "PLAN_GROUP_ID");
	      columnTypes.put("planGroupId", "java.lang.Long");
	      columns.put("planName", "PLAN_NAME");
	      columnTypes.put("planName", "java.lang.Long");
	      columns.put("effectiveDate", "EFFECTIVE_DATE");
	      columnTypes.put("effectiveDate", "java.util.Date");
	      columns.put("expiryDate", "EXPIRY_DATE");
	      columnTypes.put("expiryDate", "java.util.Date");
	      columns.put("statusId", "STATUS_ID");
	      columnTypes.put("statusId", "java.lang.Integer");
	      columns.put("priority", "PRIORITY");
	      columnTypes.put("priority", "java.lang.Integer");
	      columns.put("cvrTypeRuleAplcbl", "CVR_TYPE_RULE_APLCBL");
	      columnTypes.put("cvrTypeRuleAplcbl", "java.lang.Integer");
	      columns.put("platformSpcRuleChk", "PLATFORM_SPC_RULE_CHK");
	      columnTypes.put("platformSpcRuleChk", "java.lang.Integer");
	      columns.put("producerRuleChk", "PRODUCER_RULE_CHK");
	      columnTypes.put("producerRuleChk", "java.lang.Integer");
	      columns.put("autoSpcRuleChk", "AUTO_SPC_RULE_CHK");
	      columnTypes.put("autoSpcRuleChk", "java.lang.Integer");
	      columns.put("voucherAplcbl", "VOUCHER_APLCBL");
	      columnTypes.put("voucherAplcbl", "java.lang.Integer");
	      columns.put("checkCampaign", "CHECK_CAMPAIGN");
	      columnTypes.put("checkCampaign", "java.lang.Integer");
	      columns.put("producerExpChk", "PRODUCER_EXP_CHK");
	      columnTypes.put("producerExpChk", "java.lang.Integer");
	      columns.put("gstProducerChk", "GST_PRODUCER_CHK");
	      columnTypes.put("gstProducerChk", "java.lang.Integer");
	      columns.put("dnmChk", "DNM_CHK");
	      columnTypes.put("dnmChk", "java.lang.Integer");
	      columns.put("ruleDescription", "RULE_DESCRIPTION");
	      columnTypes.put("ruleDescription", "java.lang.String");
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
	  
	  public TSgFrmsMasterConfig fillEntity(ResultSet rs) throws SQLException {
	      TSgFrmsMasterConfig entity = new TSgFrmsMasterConfig();
	      entity.setRuleId(new Long(rs.getLong("RULE_ID")));
	      if (rs.wasNull()) {
	          entity.setRuleId(null);
	      }
	      entity.setTransactionType(new Integer(rs.getInt("TRANSACTION_TYPE")));
	      if (rs.wasNull()) {
	          entity.setTransactionType(null);
	      }
	      entity.setDocumentType(new Integer(rs.getInt("DOCUMENT_TYPE")));
	      if (rs.wasNull()) {
	          entity.setDocumentType(null);
	      }
	      entity.setLobId(rs.getString("LOB_ID"));
	      entity.setProductCode(rs.getString("PRODUCT_CODE"));
	      entity.setPlanGroupId(new Long(rs.getLong("PLAN_GROUP_ID")));
	      if (rs.wasNull()) {
	          entity.setPlanGroupId(null);
	      }
	      entity.setPlanName(new Long(rs.getLong("PLAN_NAME")));
	      if (rs.wasNull()) {
	          entity.setPlanName(null);
	      }
	      entity.setEffectiveDate(rs.getTimestamp("EFFECTIVE_DATE"));
	      entity.setExpiryDate(rs.getTimestamp("EXPIRY_DATE"));
	      entity.setStatusId(new Integer(rs.getInt("STATUS_ID")));
	      if (rs.wasNull()) {
	          entity.setStatusId(null);
	      }
	      entity.setPriority(new Integer(rs.getInt("PRIORITY")));
	      if (rs.wasNull()) {
	          entity.setPriority(null);
	      }
	      entity.setCvrTypeRuleAplcbl(new Integer(rs.getInt("CVR_TYPE_RULE_APLCBL")));
	      if (rs.wasNull()) {
	          entity.setCvrTypeRuleAplcbl(null);
	      }
	      entity.setPlatformSpcRuleChk(new Integer(rs.getInt("PLATFORM_SPC_RULE_CHK")));
	      if (rs.wasNull()) {
	          entity.setPlatformSpcRuleChk(null);
	      }
	      entity.setProducerRuleChk(new Integer(rs.getInt("PRODUCER_RULE_CHK")));
	      if (rs.wasNull()) {
	          entity.setProducerRuleChk(null);
	      }
	      entity.setAutoSpcRuleChk(new Integer(rs.getInt("AUTO_SPC_RULE_CHK")));
	      if (rs.wasNull()) {
	          entity.setAutoSpcRuleChk(null);
	      }
	      entity.setVoucherAplcbl(new Integer(rs.getInt("VOUCHER_APLCBL")));
	      if (rs.wasNull()) {
	          entity.setVoucherAplcbl(null);
	      }
	      entity.setCheckCampaign(new Integer(rs.getInt("CHECK_CAMPAIGN")));
	      if (rs.wasNull()) {
	          entity.setCheckCampaign(null);
	      }
	      entity.setProducerExpChk(new Integer(rs.getInt("PRODUCER_EXP_CHK")));
	      if (rs.wasNull()) {
	          entity.setProducerExpChk(null);
	      }
	      entity.setGstProducerChk(new Integer(rs.getInt("GST_PRODUCER_CHK")));
	      if (rs.wasNull()) {
	          entity.setGstProducerChk(null);
	      }
	      entity.setDnmChk(new Integer(rs.getInt("DNM_CHK")));
	      if (rs.wasNull()) {
	          entity.setDnmChk(null);
	      }
	      entity.setRuleDescription(rs.getString("RULE_DESCRIPTION"));
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
	  
	  public java.lang.Long create(TSgFrmsMasterConfig entity) throws GenericException{
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
	if ( entity.getRuleId() == null || entity.getRuleId().longValue()<=0 ) {
	      entity.setRuleId(OracleSequencePKGenerator.getInstance().getNextPKValue("S_SG_FRMS_MASTER_CONFIG__RULE_"));
	}
	      DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer buf = new StringBuffer();
		buf.append("insert into T_SG_FRMS_MASTER_CONFIG(");
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
		buf.append(",INSERT_TIME");
		buf.append(",UPDATE_TIME");
		buf.append(",INSERTED_BY");
		buf.append(",UPDATED_BY");
		buf.append(")");
		buf.append(" values(");
	    for (int i=0; i<25; i++) {
		  buf.append(i==0 ? "?" : ",?");
		}
		buf.append(")");
		Log.debug(TSgFrmsMasterConfigDao.class, buf.toString());
		try {
		  db.connect();
		  Connection con = db.getConnection();
		  ps = con.prepareStatement(buf.toString());
	      int pos = 1;
		  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
		  Log.debug(TSgFrmsMasterConfigDao.class, "ruleId:" + entity.getRuleId());
		  if(entity.getTransactionType() != null) ps.setInt(pos++, entity.getTransactionType().intValue()); else ps.setNull(pos++, Types.NUMERIC);
		  Log.debug(TSgFrmsMasterConfigDao.class, "transactionType:" + entity.getTransactionType());
		  if(entity.getDocumentType() != null) ps.setInt(pos++, entity.getDocumentType().intValue()); else ps.setNull(pos++, Types.NUMERIC);
		  Log.debug(TSgFrmsMasterConfigDao.class, "documentType:" + entity.getDocumentType());
		  ps.setString(pos++, entity.getLobId());
		  Log.debug(TSgFrmsMasterConfigDao.class, "lobId:" + entity.getLobId());
		  ps.setString(pos++, entity.getProductCode());
		  Log.debug(TSgFrmsMasterConfigDao.class, "productCode:" + entity.getProductCode());
		  if(entity.getPlanGroupId() != null) ps.setLong(pos++, entity.getPlanGroupId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
		  Log.debug(TSgFrmsMasterConfigDao.class, "planGroupId:" + entity.getPlanGroupId());
		  if(entity.getPlanName() != null) ps.setLong(pos++, entity.getPlanName().longValue()); else ps.setNull(pos++, Types.NUMERIC);
		  Log.debug(TSgFrmsMasterConfigDao.class, "planName:" + entity.getPlanName());
		  ps.setTimestamp(pos++, entity.getEffectiveDate() != null ? new java.sql.Timestamp(entity.getEffectiveDate().getTime()) : null);
		  Log.debug(TSgFrmsMasterConfigDao.class, "effectiveDate:" + entity.getEffectiveDate());
		  ps.setTimestamp(pos++, entity.getExpiryDate() != null ? new java.sql.Timestamp(entity.getExpiryDate().getTime()) : null);
		  Log.debug(TSgFrmsMasterConfigDao.class, "expiryDate:" + entity.getExpiryDate());
		  if(entity.getStatusId() != null) ps.setInt(pos++, entity.getStatusId().intValue()); else ps.setNull(pos++, Types.NUMERIC);
		  Log.debug(TSgFrmsMasterConfigDao.class, "statusId:" + entity.getStatusId());
		  if(entity.getPriority() != null) ps.setInt(pos++, entity.getPriority().intValue()); else ps.setNull(pos++, Types.NUMERIC);
		  Log.debug(TSgFrmsMasterConfigDao.class, "priority:" + entity.getPriority());
		  if(entity.getCvrTypeRuleAplcbl() != null) ps.setInt(pos++, entity.getCvrTypeRuleAplcbl().intValue()); else ps.setNull(pos++, Types.NUMERIC);
		  Log.debug(TSgFrmsMasterConfigDao.class, "cvrTypeRuleAplcbl:" + entity.getCvrTypeRuleAplcbl());
		  if(entity.getPlatformSpcRuleChk() != null) ps.setInt(pos++, entity.getPlatformSpcRuleChk().intValue()); else ps.setNull(pos++, Types.NUMERIC);
		  Log.debug(TSgFrmsMasterConfigDao.class, "platformSpcRuleChk:" + entity.getPlatformSpcRuleChk());
		  if(entity.getProducerRuleChk() != null) ps.setInt(pos++, entity.getProducerRuleChk().intValue()); else ps.setNull(pos++, Types.NUMERIC);
		  Log.debug(TSgFrmsMasterConfigDao.class, "producerRuleChk:" + entity.getProducerRuleChk());
		  if(entity.getAutoSpcRuleChk() != null) ps.setInt(pos++, entity.getAutoSpcRuleChk().intValue()); else ps.setNull(pos++, Types.NUMERIC);
		  Log.debug(TSgFrmsMasterConfigDao.class, "autoSpcRuleChk:" + entity.getAutoSpcRuleChk());
		  if(entity.getVoucherAplcbl() != null) ps.setInt(pos++, entity.getVoucherAplcbl().intValue()); else ps.setNull(pos++, Types.NUMERIC);
		  Log.debug(TSgFrmsMasterConfigDao.class, "voucherAplcbl:" + entity.getVoucherAplcbl());
		  if(entity.getCheckCampaign() != null) ps.setInt(pos++, entity.getCheckCampaign().intValue()); else ps.setNull(pos++, Types.NUMERIC);
		  Log.debug(TSgFrmsMasterConfigDao.class, "checkCampaign:" + entity.getCheckCampaign());
		  if(entity.getProducerExpChk() != null) ps.setInt(pos++, entity.getProducerExpChk().intValue()); else ps.setNull(pos++, Types.NUMERIC);
		  Log.debug(TSgFrmsMasterConfigDao.class, "producerExpChk:" + entity.getProducerExpChk());
		  if(entity.getGstProducerChk() != null) ps.setInt(pos++, entity.getGstProducerChk().intValue()); else ps.setNull(pos++, Types.NUMERIC);
		  Log.debug(TSgFrmsMasterConfigDao.class, "gstProducerChk:" + entity.getGstProducerChk());
		  if(entity.getDnmChk() != null) ps.setInt(pos++, entity.getDnmChk().intValue()); else ps.setNull(pos++, Types.NUMERIC);
		  Log.debug(TSgFrmsMasterConfigDao.class, "dnmChk:" + entity.getDnmChk());
		  ps.setString(pos++, entity.getRuleDescription());
		  Log.debug(TSgFrmsMasterConfigDao.class, "ruleDescription:" + entity.getRuleDescription());
		  ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
		  Log.debug(TSgFrmsMasterConfigDao.class, "insertTime:" + entity.getInsertTime());
		  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
		  Log.debug(TSgFrmsMasterConfigDao.class, "updateTime:" + entity.getUpdateTime());
		  /*if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);*/
		  if (entity.getInsertedBy() != null)
	          ps.setLong(pos++, entity.getInsertedBy().longValue());
	        else
	          ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
		  Log.debug(TSgFrmsMasterConfigDao.class, "insertedBy:" + entity.getInsertedBy());
		  /*if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);*/
		  if (entity.getUpdatedBy() != null)
	          ps.setLong(pos++, entity.getUpdatedBy().longValue());
	        else
	          ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
		  Log.debug(TSgFrmsMasterConfigDao.class, "updatedBy:" + entity.getUpdatedBy());
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
	  
	  public void update(TSgFrmsMasterConfig entity) throws GenericException{
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
		buf.append("update T_SG_FRMS_MASTER_CONFIG set ");
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
		//buf.append(",INSERT_TIME=?");
		buf.append(",UPDATE_TIME=?");
		//buf.append(",INSERTED_BY=?");
		buf.append(",UPDATED_BY=?");
		buf.append(" where 1 = 1");
		buf.append("   and RULE_ID = ?");
		Log.debug(TSgFrmsMasterConfigDao.class, buf.toString());
		try {
		  db.connect();
		  Connection con = db.getConnection();
		  ps = con.prepareStatement(buf.toString());
	      int pos = 1;
		  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
		  if(entity.getTransactionType() != null) ps.setInt(pos++, entity.getTransactionType().intValue()); else ps.setNull(pos++, Types.NUMERIC);
		  if(entity.getDocumentType() != null) ps.setInt(pos++, entity.getDocumentType().intValue()); else ps.setNull(pos++, Types.NUMERIC);
		  ps.setString(pos++, entity.getLobId());
		  ps.setString(pos++, entity.getProductCode());
		  if(entity.getPlanGroupId() != null) ps.setLong(pos++, entity.getPlanGroupId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
		  if(entity.getPlanName() != null) ps.setLong(pos++, entity.getPlanName().longValue()); else ps.setNull(pos++, Types.NUMERIC);
		  ps.setTimestamp(pos++, entity.getEffectiveDate() != null ? new java.sql.Timestamp(entity.getEffectiveDate().getTime()) : null);
		  ps.setTimestamp(pos++, entity.getExpiryDate() != null ? new java.sql.Timestamp(entity.getExpiryDate().getTime()) : null);
		  if(entity.getStatusId() != null) ps.setInt(pos++, entity.getStatusId().intValue()); else ps.setNull(pos++, Types.NUMERIC);
		  if(entity.getPriority() != null) ps.setInt(pos++, entity.getPriority().intValue()); else ps.setNull(pos++, Types.NUMERIC);
		  if(entity.getCvrTypeRuleAplcbl() != null) ps.setInt(pos++, entity.getCvrTypeRuleAplcbl().intValue()); else ps.setNull(pos++, Types.NUMERIC);
		  if(entity.getPlatformSpcRuleChk() != null) ps.setInt(pos++, entity.getPlatformSpcRuleChk().intValue()); else ps.setNull(pos++, Types.NUMERIC);
		  if(entity.getProducerRuleChk() != null) ps.setInt(pos++, entity.getProducerRuleChk().intValue()); else ps.setNull(pos++, Types.NUMERIC);
		  if(entity.getAutoSpcRuleChk() != null) ps.setInt(pos++, entity.getAutoSpcRuleChk().intValue()); else ps.setNull(pos++, Types.NUMERIC);
		  if(entity.getVoucherAplcbl() != null) ps.setInt(pos++, entity.getVoucherAplcbl().intValue()); else ps.setNull(pos++, Types.NUMERIC);
		  if(entity.getCheckCampaign() != null) ps.setInt(pos++, entity.getCheckCampaign().intValue()); else ps.setNull(pos++, Types.NUMERIC);
		  if(entity.getProducerExpChk() != null) ps.setInt(pos++, entity.getProducerExpChk().intValue()); else ps.setNull(pos++, Types.NUMERIC);
		  if(entity.getGstProducerChk() != null) ps.setInt(pos++, entity.getGstProducerChk().intValue()); else ps.setNull(pos++, Types.NUMERIC);
		  if(entity.getDnmChk() != null) ps.setInt(pos++, entity.getDnmChk().intValue()); else ps.setNull(pos++, Types.NUMERIC);
		  ps.setString(pos++, entity.getRuleDescription());
		  //ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
		  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
		 // if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
		  //if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
		  ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
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
	       TSgFrmsMasterConfig entity = null;
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
		buf.append("delete from T_SG_FRMS_MASTER_CONFIG");
		buf.append(" where 1 = 1");
		buf.append("   and RULE_ID = ?");
		Log.debug(TSgFrmsMasterConfigDao.class, buf.toString());
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
	  
	  public TSgFrmsMasterConfig load( java.lang.Long ruleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
	    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
	       Object o = null;
	       try {
	          Session session = HibernateUtil.currentSession();
	          if(ruleId==null) {
		    return null;
		  }
	          Serializable sId = ruleId;
		  o = session.load(TSgFrmsMasterConfig.class,sId);
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
	       return (TSgFrmsMasterConfig)o;
	    }
	  
	    DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer buf = new StringBuffer();
		buf.append("select * from T_SG_FRMS_MASTER_CONFIG ");
		buf.append(" where 1=1 ");
		buf.append("   and RULE_ID = ?");
		Log.debug(TSgFrmsMasterConfigDao.class, buf.toString());
		try {
		  db.connect();
		  Connection con = db.getConnection();
		  ps = con.prepareStatement(buf.toString());
	      int pos = 1;
		  if(ruleId != null) ps.setLong(pos++, ruleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
		  rs = ps.executeQuery();
	      TSgFrmsMasterConfig entity = null;
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
	  public Long getSequenceID() throws SQLException,ClassNotFoundException 
{
	DBean db = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Long serialId = (long) 1000000000;
	try{ 
		StringBuffer selectQuery = new StringBuffer();
		selectQuery.append("SELECT max(RULE_ID) AS SERIAL_ID FROM T_SG_FRMS_MASTER_CONFIG");
	db = new DBean(false);
	db.connect();
	Connection con = db.getConnection();
	ps = con.prepareStatement(selectQuery.toString());
	rs = ps.executeQuery();
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
	return serialId+1;
}
	@Override
	public void updateOnFinalSubmit(TSgFrmsMasterConfig entity)
			throws ObjectNotFoundException, GenericException {
		// TODO Auto-generated method stub

	    DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer buf = new StringBuffer();
		buf.append("update T_SG_FRMS_MASTER_CONFIG set ");
		buf.append(" STATUS_ID=?");
		buf.append(",UPDATE_TIME=?");
		buf.append(",UPDATED_BY=?");
		buf.append(" where 1 = 1");
		buf.append("   and RULE_ID = ?");
		Log.debug(TSgFrmsMasterConfigDao.class, buf.toString());
		try {
		  db.connect();
		  Connection con = db.getConnection();
		  ps = con.prepareStatement(buf.toString());
	      int pos = 1;
		 
		  if(entity.getStatusId() != null) ps.setInt(pos++, entity.getStatusId().intValue()); else ps.setNull(pos++, Types.NUMERIC);
		  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
		  ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
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


}

