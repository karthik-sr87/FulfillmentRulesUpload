

package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.StgSmsEmailMappingConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgSmsEmailMappingConfig;
import com.ebao.foundation.common.config.Env;
import com.ebao.gs.pub.util.HibernateUtil;
import com.ebao.pub.framework.ExceptionFactory;
import com.ebao.pub.framework.GenericException;
import com.ebao.pub.util.DBean;
import com.ebao.pub.util.Log;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public class StgSmsEmailMappingConfigDaoOracleImpl implements StgSmsEmailMappingConfigDao{
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
      table = "STG_SMS_EMAIL_MAPPING_CONFIG";
      columns.put("ruleId", "RULE_ID");
      columnTypes.put("ruleId", "java.lang.Long");
      columns.put("customerSmsFlag", "CUSTOMER_SMS_FLAG");
      columnTypes.put("customerSmsFlag", "java.lang.String");
      columns.put("customerSmsTemplateId", "CUSTOMER_SMS_TEMPLATE_ID");
      columnTypes.put("customerSmsTemplateId", "java.lang.String");
      columns.put("customerEmailFlag", "CUSTOMER_EMAIL_FLAG");
      columnTypes.put("customerEmailFlag", "java.lang.String");
      columns.put("customerEmailTemplateId", "CUSTOMER_EMAIL_TEMPLATE_ID");
      columnTypes.put("customerEmailTemplateId", "java.lang.String");
      columns.put("producerSmsFlag", "PRODUCER_SMS_FLAG");
      columnTypes.put("producerSmsFlag", "java.lang.String");
      columns.put("producerSmsTemplateId", "PRODUCER_SMS_TEMPLATE_ID");
      columnTypes.put("producerSmsTemplateId", "java.lang.String");
      columns.put("producerEmailFlag", "PRODUCER_EMAIL_FLAG");
      columnTypes.put("producerEmailFlag", "java.lang.String");
      columns.put("producerEmailTemplateId", "PRODUCER_EMAIL_TEMPLATE_ID");
      columnTypes.put("producerEmailTemplateId", "java.lang.String");
  }

  protected Object fillObject(ResultSet rs) throws SQLException {
    return fillEntity(rs);
  }
  
  public StgSmsEmailMappingConfig fillEntity(ResultSet rs) throws SQLException {
      StgSmsEmailMappingConfig entity = new StgSmsEmailMappingConfig();
      entity.setRuleId(new Long(rs.getLong("RULE_ID")));
      if (rs.wasNull()) {
          entity.setRuleId(null);
      }
      entity.setCustomerSmsFlag(rs.getString("CUSTOMER_SMS_FLAG"));
      entity.setCustomerSmsTemplateId(rs.getString("CUSTOMER_SMS_TEMPLATE_ID"));
      entity.setCustomerEmailFlag(rs.getString("CUSTOMER_EMAIL_FLAG"));
      entity.setCustomerEmailTemplateId(rs.getString("CUSTOMER_EMAIL_TEMPLATE_ID"));
      entity.setProducerSmsFlag(rs.getString("PRODUCER_SMS_FLAG"));
      entity.setProducerSmsTemplateId(rs.getString("PRODUCER_SMS_TEMPLATE_ID"));
      entity.setProducerEmailFlag(rs.getString("PRODUCER_EMAIL_FLAG"));
      entity.setProducerEmailTemplateId(rs.getString("PRODUCER_EMAIL_TEMPLATE_ID"));
      return entity;
  }
  
  public void create(StgSmsEmailMappingConfig entity) throws GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       try {
         Session session = HibernateUtil.currentSession();
         Serializable key = session.save(entity);
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
       return ;
     }
      DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into STG_SMS_EMAIL_MAPPING_CONFIG(");
	buf.append("RULE_ID");
	buf.append(",CUSTOMER_SMS_FLAG");
	buf.append(",CUSTOMER_SMS_TEMPLATE_ID");
	buf.append(",CUSTOMER_EMAIL_FLAG");
	buf.append(",CUSTOMER_EMAIL_TEMPLATE_ID");
	buf.append(",PRODUCER_SMS_FLAG");
	buf.append(",PRODUCER_SMS_TEMPLATE_ID");
	buf.append(",PRODUCER_EMAIL_FLAG");
	buf.append(",PRODUCER_EMAIL_TEMPLATE_ID");
	buf.append(")");
	buf.append(" values(");
    for (int i=0; i<9; i++) {
	  buf.append(i==0 ? "?" : ",?");
	}
	buf.append(")");
	Log.debug(StgSmsEmailMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgSmsEmailMappingConfigDao.class, "ruleId:" + entity.getRuleId());
	  ps.setString(pos++, entity.getCustomerSmsFlag());
	  Log.debug(StgSmsEmailMappingConfigDao.class, "customerSmsFlag:" + entity.getCustomerSmsFlag());
	  ps.setString(pos++, entity.getCustomerSmsTemplateId());
	  Log.debug(StgSmsEmailMappingConfigDao.class, "customerSmsTemplateId:" + entity.getCustomerSmsTemplateId());
	  ps.setString(pos++, entity.getCustomerEmailFlag());
	  Log.debug(StgSmsEmailMappingConfigDao.class, "customerEmailFlag:" + entity.getCustomerEmailFlag());
	  ps.setString(pos++, entity.getCustomerEmailTemplateId());
	  Log.debug(StgSmsEmailMappingConfigDao.class, "customerEmailTemplateId:" + entity.getCustomerEmailTemplateId());
	  ps.setString(pos++, entity.getProducerSmsFlag());
	  Log.debug(StgSmsEmailMappingConfigDao.class, "producerSmsFlag:" + entity.getProducerSmsFlag());
	  ps.setString(pos++, entity.getProducerSmsTemplateId());
	  Log.debug(StgSmsEmailMappingConfigDao.class, "producerSmsTemplateId:" + entity.getProducerSmsTemplateId());
	  ps.setString(pos++, entity.getProducerEmailFlag());
	  Log.debug(StgSmsEmailMappingConfigDao.class, "producerEmailFlag:" + entity.getProducerEmailFlag());
	  ps.setString(pos++, entity.getProducerEmailTemplateId());
	  Log.debug(StgSmsEmailMappingConfigDao.class, "producerEmailTemplateId:" + entity.getProducerEmailTemplateId());
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}
  }
  
  public void update(StgSmsEmailMappingConfig entity) throws GenericException{
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
	buf.append("update STG_SMS_EMAIL_MAPPING_CONFIG set ");
	buf.append("RULE_ID=?");
	buf.append(",CUSTOMER_SMS_FLAG=?");
	buf.append(",CUSTOMER_SMS_TEMPLATE_ID=?");
	buf.append(",CUSTOMER_EMAIL_FLAG=?");
	buf.append(",CUSTOMER_EMAIL_TEMPLATE_ID=?");
	buf.append(",PRODUCER_SMS_FLAG=?");
	buf.append(",PRODUCER_SMS_TEMPLATE_ID=?");
	buf.append(",PRODUCER_EMAIL_FLAG=?");
	buf.append(",PRODUCER_EMAIL_TEMPLATE_ID=?");
	buf.append(" where 1 = 1");
	Log.debug(StgSmsEmailMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setString(pos++, entity.getCustomerSmsFlag());
	  ps.setString(pos++, entity.getCustomerSmsTemplateId());
	  ps.setString(pos++, entity.getCustomerEmailFlag());
	  ps.setString(pos++, entity.getCustomerEmailTemplateId());
	  ps.setString(pos++, entity.getProducerSmsFlag());
	  ps.setString(pos++, entity.getProducerSmsTemplateId());
	  ps.setString(pos++, entity.getProducerEmailFlag());
	  ps.setString(pos++, entity.getProducerEmailTemplateId());
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public void remove() throws GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       StgSmsEmailMappingConfig entity = null;
       try {
          Session session = HibernateUtil.currentSession();
          entity = this.load();
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
	buf.append("delete from STG_SMS_EMAIL_MAPPING_CONFIG");
	buf.append(" where 1 = 1");
	Log.debug(StgSmsEmailMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public StgSmsEmailMappingConfig load() throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
	  String sql = "from  com.ebao.gcs.tmp.data.dao.StgSmsEmailMappingConfig t where 1=1 ";
          Query query = session.createQuery(sql);
          List list = query.list();
          if(list==null||list.size()==0) {
           return null;
          }
          o = (StgSmsEmailMappingConfig)list.get(0);
/*
          StgSmsEmailMappingConfig entity = new StgSmsEmailMappingConfig();
          o = session.load(StgSmsEmailMappingConfig.class,entity);
*/
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
       return (StgSmsEmailMappingConfig)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from STG_SMS_EMAIL_MAPPING_CONFIG ");
	buf.append(" where 1=1 ");
	Log.debug(StgSmsEmailMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  rs = ps.executeQuery();
      StgSmsEmailMappingConfig entity = null;
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
