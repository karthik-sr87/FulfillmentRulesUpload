

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

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgSmsEmailMappingConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgSmsEmailMappingConfig;
import com.ebao.foundation.common.config.Env;
import com.ebao.gs.pub.util.HibernateUtil;
import com.ebao.pub.framework.ExceptionFactory;
import com.ebao.pub.framework.GenericException;
import com.ebao.pub.framework.data.internal.OracleSequencePKGenerator;
import com.ebao.pub.util.DBean;
import com.ebao.pub.util.Log;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public class TSgSmsEmailMappingConfigDaoOracleImpl implements TSgSmsEmailMappingConfigDao{
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
      table = "T_SG_SMS_EMAIL_MAPPING_CONFIG";
      columns.put("ruleId", "RULE_ID");
      columnTypes.put("ruleId", "java.lang.Long");
      columns.put("customerSmsFlag", "CUSTOMER_SMS_FLAG");
      columnTypes.put("customerSmsFlag", "java.lang.Integer");
      columns.put("customerSmsTemplateId", "CUSTOMER_SMS_TEMPLATE_ID");
      columnTypes.put("customerSmsTemplateId", "java.lang.Long");
      columns.put("customerEmailFlag", "CUSTOMER_EMAIL_FLAG");
      columnTypes.put("customerEmailFlag", "java.lang.Integer");
      columns.put("customerEmailTemplateId", "CUSTOMER_EMAIL_TEMPLATE_ID");
      columnTypes.put("customerEmailTemplateId", "java.lang.Long");
      columns.put("producerSmsFlag", "PRODUCER_SMS_FLAG");
      columnTypes.put("producerSmsFlag", "java.lang.Integer");
      columns.put("producerSmsTemplateId", "PRODUCER_SMS_TEMPLATE_ID");
      columnTypes.put("producerSmsTemplateId", "java.lang.Long");
      columns.put("producerEmailFlag", "PRODUCER_EMAIL_FLAG");
      columnTypes.put("producerEmailFlag", "java.lang.Integer");
      columns.put("producerEmailTemplateId", "PRODUCER_EMAIL_TEMPLATE_ID");
      columnTypes.put("producerEmailTemplateId", "java.lang.Long");
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
  
  public TSgSmsEmailMappingConfig fillEntity(ResultSet rs) throws SQLException {
      TSgSmsEmailMappingConfig entity = new TSgSmsEmailMappingConfig();
      entity.setRuleId(new Long(rs.getLong("RULE_ID")));
      if (rs.wasNull()) {
          entity.setRuleId(null);
      }
      entity.setCustomerSmsFlag(new Integer(rs.getInt("CUSTOMER_SMS_FLAG")));
      if (rs.wasNull()) {
          entity.setCustomerSmsFlag(null);
      }
      entity.setCustomerSmsTemplateId(new Long(rs.getLong("CUSTOMER_SMS_TEMPLATE_ID")));
      if (rs.wasNull()) {
          entity.setCustomerSmsTemplateId(null);
      }
      entity.setCustomerEmailFlag(new Integer(rs.getInt("CUSTOMER_EMAIL_FLAG")));
      if (rs.wasNull()) {
          entity.setCustomerEmailFlag(null);
      }
      entity.setCustomerEmailTemplateId(new Long(rs.getLong("CUSTOMER_EMAIL_TEMPLATE_ID")));
      if (rs.wasNull()) {
          entity.setCustomerEmailTemplateId(null);
      }
      entity.setProducerSmsFlag(new Integer(rs.getInt("PRODUCER_SMS_FLAG")));
      if (rs.wasNull()) {
          entity.setProducerSmsFlag(null);
      }
      entity.setProducerSmsTemplateId(new Long(rs.getLong("PRODUCER_SMS_TEMPLATE_ID")));
      if (rs.wasNull()) {
          entity.setProducerSmsTemplateId(null);
      }
      entity.setProducerEmailFlag(new Integer(rs.getInt("PRODUCER_EMAIL_FLAG")));
      if (rs.wasNull()) {
          entity.setProducerEmailFlag(null);
      }
      entity.setProducerEmailTemplateId(new Long(rs.getLong("PRODUCER_EMAIL_TEMPLATE_ID")));
      if (rs.wasNull()) {
          entity.setProducerEmailTemplateId(null);
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
  
  public java.lang.Long create(TSgSmsEmailMappingConfig entity) throws GenericException{
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
      entity.setRuleId(OracleSequencePKGenerator.getInstance().getNextPKValue("NULL"));
}
      DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into T_SG_SMS_EMAIL_MAPPING_CONFIG(");
	buf.append("RULE_ID");
	buf.append(",CUSTOMER_SMS_FLAG");
	buf.append(",CUSTOMER_SMS_TEMPLATE_ID");
	buf.append(",CUSTOMER_EMAIL_FLAG");
	buf.append(",CUSTOMER_EMAIL_TEMPLATE_ID");
	buf.append(",PRODUCER_SMS_FLAG");
	buf.append(",PRODUCER_SMS_TEMPLATE_ID");
	buf.append(",PRODUCER_EMAIL_FLAG");
	buf.append(",PRODUCER_EMAIL_TEMPLATE_ID");
	buf.append(",INSERT_TIME");
	buf.append(",UPDATE_TIME");
	buf.append(",INSERTED_BY");
	buf.append(",UPDATED_BY");
	buf.append(")");
	buf.append(" values(");
    for (int i=0; i<13; i++) {
	  buf.append(i==0 ? "?" : ",?");
	}
	buf.append(")");
	Log.debug(TSgSmsEmailMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgSmsEmailMappingConfigDao.class, "ruleId:" + entity.getRuleId());
	  if(entity.getCustomerSmsFlag() != null) ps.setInt(pos++, entity.getCustomerSmsFlag().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgSmsEmailMappingConfigDao.class, "customerSmsFlag:" + entity.getCustomerSmsFlag());
	  if(entity.getCustomerSmsTemplateId() != null) ps.setLong(pos++, entity.getCustomerSmsTemplateId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgSmsEmailMappingConfigDao.class, "customerSmsTemplateId:" + entity.getCustomerSmsTemplateId());
	  if(entity.getCustomerEmailFlag() != null) ps.setInt(pos++, entity.getCustomerEmailFlag().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgSmsEmailMappingConfigDao.class, "customerEmailFlag:" + entity.getCustomerEmailFlag());
	  if(entity.getCustomerEmailTemplateId() != null) ps.setLong(pos++, entity.getCustomerEmailTemplateId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgSmsEmailMappingConfigDao.class, "customerEmailTemplateId:" + entity.getCustomerEmailTemplateId());
	  if(entity.getProducerSmsFlag() != null) ps.setInt(pos++, entity.getProducerSmsFlag().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgSmsEmailMappingConfigDao.class, "producerSmsFlag:" + entity.getProducerSmsFlag());
	  if(entity.getProducerSmsTemplateId() != null) ps.setLong(pos++, entity.getProducerSmsTemplateId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgSmsEmailMappingConfigDao.class, "producerSmsTemplateId:" + entity.getProducerSmsTemplateId());
	  if(entity.getProducerEmailFlag() != null) ps.setInt(pos++, entity.getProducerEmailFlag().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgSmsEmailMappingConfigDao.class, "producerEmailFlag:" + entity.getProducerEmailFlag());
	  if(entity.getProducerEmailTemplateId() != null) ps.setLong(pos++, entity.getProducerEmailTemplateId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgSmsEmailMappingConfigDao.class, "producerEmailTemplateId:" + entity.getProducerEmailTemplateId());
	  ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  Log.debug(TSgSmsEmailMappingConfigDao.class, "insertTime:" + entity.getInsertTime());
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  Log.debug(TSgSmsEmailMappingConfigDao.class, "updateTime:" + entity.getUpdateTime());
	  if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgSmsEmailMappingConfigDao.class, "insertedBy:" + entity.getInsertedBy());
	  if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgSmsEmailMappingConfigDao.class, "updatedBy:" + entity.getUpdatedBy());
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
    
    
  public void update(TSgSmsEmailMappingConfig entity) throws GenericException{
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
	buf.append("update T_SG_SMS_EMAIL_MAPPING_CONFIG set ");
	buf.append("RULE_ID=?");
	buf.append(",CUSTOMER_SMS_FLAG=?");
	buf.append(",CUSTOMER_SMS_TEMPLATE_ID=?");
	buf.append(",CUSTOMER_EMAIL_FLAG=?");
	buf.append(",CUSTOMER_EMAIL_TEMPLATE_ID=?");
	buf.append(",PRODUCER_SMS_FLAG=?");
	buf.append(",PRODUCER_SMS_TEMPLATE_ID=?");
	buf.append(",PRODUCER_EMAIL_FLAG=?");
	buf.append(",PRODUCER_EMAIL_TEMPLATE_ID=?");
	buf.append(",INSERT_TIME=?");
	buf.append(",UPDATE_TIME=?");
	buf.append(",INSERTED_BY=?");
	buf.append(",UPDATED_BY=?");
	buf.append(" where 1 = 1");
	buf.append("   and RULE_ID = ?");
	Log.debug(TSgSmsEmailMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getCustomerSmsFlag() != null) ps.setInt(pos++, entity.getCustomerSmsFlag().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getCustomerSmsTemplateId() != null) ps.setLong(pos++, entity.getCustomerSmsTemplateId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getCustomerEmailFlag() != null) ps.setInt(pos++, entity.getCustomerEmailFlag().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getCustomerEmailTemplateId() != null) ps.setLong(pos++, entity.getCustomerEmailTemplateId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getProducerSmsFlag() != null) ps.setInt(pos++, entity.getProducerSmsFlag().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getProducerSmsTemplateId() != null) ps.setLong(pos++, entity.getProducerSmsTemplateId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getProducerEmailFlag() != null) ps.setInt(pos++, entity.getProducerEmailFlag().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getProducerEmailTemplateId() != null) ps.setLong(pos++, entity.getProducerEmailTemplateId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
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
       TSgSmsEmailMappingConfig entity = null;
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
	buf.append("delete from T_SG_SMS_EMAIL_MAPPING_CONFIG");
	buf.append(" where 1 = 1");
	buf.append("   and RULE_ID = ?");
	Log.debug(TSgSmsEmailMappingConfigDao.class, buf.toString());
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
  
  public TSgSmsEmailMappingConfig load( java.lang.Long ruleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
          if(ruleId==null) {
	    return null;
	  }
          Serializable sId = ruleId;
	  o = session.load(TSgSmsEmailMappingConfig.class,sId);
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
       return (TSgSmsEmailMappingConfig)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from T_SG_SMS_EMAIL_MAPPING_CONFIG ");
	buf.append(" where 1=1 ");
	buf.append("   and RULE_ID = ? ");
	Log.debug(TSgSmsEmailMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(ruleId != null) ps.setLong(pos++, ruleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
      TSgSmsEmailMappingConfig entity = null;
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

