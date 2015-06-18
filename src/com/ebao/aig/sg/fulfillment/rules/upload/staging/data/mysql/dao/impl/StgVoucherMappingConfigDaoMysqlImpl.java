

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

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.StgVoucherMappingConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgVoucherMappingConfig;
import com.ebao.foundation.common.config.Env;
import com.ebao.gs.pub.util.HibernateUtil;
import com.ebao.pub.framework.ExceptionFactory;
import com.ebao.pub.framework.GenericException;
import com.ebao.pub.framework.data.internal.OracleSequencePKGenerator;
import com.ebao.pub.util.DBean;
import com.ebao.pub.util.Log;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public class StgVoucherMappingConfigDaoMysqlImpl implements StgVoucherMappingConfigDao{
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
      table = "STG_VOUCHER_MAPPING_CONFIG";
      columns.put("voucherRuleId", "VOUCHER_RULE_ID");
      columnTypes.put("voucherRuleId", "java.lang.Long");
      columns.put("ruleId", "RULE_ID");
      columnTypes.put("ruleId", "java.lang.Long");
      columns.put("producerType", "PRODUCER_TYPE");
      columnTypes.put("producerType", "java.lang.String");
      columns.put("producerCodeFrom", "PRODUCER_CODE_FROM");
      columnTypes.put("producerCodeFrom", "java.lang.String");
      columns.put("producerCodeTo", "PRODUCER_CODE_TO");
      columnTypes.put("producerCodeTo", "java.lang.String");
      columns.put("producerExcluded", "PRODUCER_EXCLUDED");
      columnTypes.put("producerExcluded", "java.lang.String");
      columns.put("ruleEffectiveDate", "RULE_EFFECTIVE_DATE");
      columnTypes.put("ruleEffectiveDate", "java.util.Date");
      columns.put("ruleExpiryDate", "RULE_EXPIRY_DATE");
      columnTypes.put("ruleExpiryDate", "java.util.Date");
  }

  protected Object fillObject(ResultSet rs) throws SQLException {
    return fillEntity(rs);
  }
  
  public StgVoucherMappingConfig fillEntity(ResultSet rs) throws SQLException {
      StgVoucherMappingConfig entity = new StgVoucherMappingConfig();
      entity.setVoucherRuleId(new Long(rs.getLong("VOUCHER_RULE_ID")));
      if (rs.wasNull()) {
          entity.setVoucherRuleId(null);
      }
      entity.setRuleId(new Long(rs.getLong("RULE_ID")));
      if (rs.wasNull()) {
          entity.setRuleId(null);
      }
      entity.setProducerType(rs.getString("PRODUCER_TYPE"));
      entity.setProducerCodeFrom(rs.getString("PRODUCER_CODE_FROM"));
      entity.setProducerCodeTo(rs.getString("PRODUCER_CODE_TO"));
      entity.setProducerExcluded(rs.getString("PRODUCER_EXCLUDED"));
      entity.setRuleEffectiveDate(rs.getTimestamp("RULE_EFFECTIVE_DATE"));
      entity.setRuleExpiryDate(rs.getTimestamp("RULE_EXPIRY_DATE"));
      return entity;
  }
  
  public java.lang.Long create(StgVoucherMappingConfig entity) throws GenericException{
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
if ( entity.getVoucherRuleId() == null || entity.getVoucherRuleId().longValue()<=0 ) {
      entity.setVoucherRuleId(OracleSequencePKGenerator.getInstance().getNextPKValue("STG_VOUCHER_MAPPING_CONF__ID"));
}*/
      DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into STG_VOUCHER_MAPPING_CONFIG(");
	buf.append("VOUCHER_RULE_ID");
	buf.append(",RULE_ID");
	buf.append(",PRODUCER_TYPE");
	buf.append(",PRODUCER_CODE_FROM");
	buf.append(",PRODUCER_CODE_TO");
	buf.append(",PRODUCER_EXCLUDED");
	buf.append(",RULE_EFFECTIVE_DATE");
	buf.append(",RULE_EXPIRY_DATE");
	buf.append(")");
	buf.append(" values(");
    for (int i=0; i<8; i++) {
	  buf.append(i==0 ? "?" : ",?");
	}
	buf.append(")");
	Log.debug(StgVoucherMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getVoucherRuleId() != null) ps.setLong(pos++, entity.getVoucherRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgVoucherMappingConfigDao.class, "voucherRuleId:" + entity.getVoucherRuleId());
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgVoucherMappingConfigDao.class, "ruleId:" + entity.getRuleId());
	  ps.setString(pos++, entity.getProducerType());
	  Log.debug(StgVoucherMappingConfigDao.class, "producerType:" + entity.getProducerType());
	  ps.setString(pos++, entity.getProducerCodeFrom());
	  Log.debug(StgVoucherMappingConfigDao.class, "producerCodeFrom:" + entity.getProducerCodeFrom());
	  ps.setString(pos++, entity.getProducerCodeTo());
	  Log.debug(StgVoucherMappingConfigDao.class, "producerCodeTo:" + entity.getProducerCodeTo());
	  ps.setString(pos++, entity.getProducerExcluded());
	  Log.debug(StgVoucherMappingConfigDao.class, "producerExcluded:" + entity.getProducerExcluded());
	  ps.setTimestamp(pos++, entity.getRuleEffectiveDate() != null ? new java.sql.Timestamp(entity.getRuleEffectiveDate().getTime()) : null);
	  Log.debug(StgVoucherMappingConfigDao.class, "ruleEffectiveDate:" + entity.getRuleEffectiveDate());
	  ps.setTimestamp(pos++, entity.getRuleExpiryDate() != null ? new java.sql.Timestamp(entity.getRuleExpiryDate().getTime()) : null);
	  Log.debug(StgVoucherMappingConfigDao.class, "ruleExpiryDate:" + entity.getRuleExpiryDate());
	  ps.execute();
	  rs = ps.getGeneratedKeys();
	  if(rs.next())
		  entity.setVoucherRuleId(rs.getLong(1));
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(rs, ps, db);
	}
    return entity.getVoucherRuleId();
  }
  
  public void update(StgVoucherMappingConfig entity) throws GenericException{
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
	buf.append("update STG_VOUCHER_MAPPING_CONFIG set ");
	buf.append("VOUCHER_RULE_ID=?");
	buf.append(",RULE_ID=?");
	buf.append(",PRODUCER_TYPE=?");
	buf.append(",PRODUCER_CODE_FROM=?");
	buf.append(",PRODUCER_CODE_TO=?");
	buf.append(",PRODUCER_EXCLUDED=?");
	buf.append(",RULE_EFFECTIVE_DATE=?");
	buf.append(",RULE_EXPIRY_DATE=?");
	buf.append(" where 1 = 1");
	buf.append("   and VOUCHER_RULE_ID = ?");
	Log.debug(StgVoucherMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getVoucherRuleId() != null) ps.setLong(pos++, entity.getVoucherRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setString(pos++, entity.getProducerType());
	  ps.setString(pos++, entity.getProducerCodeFrom());
	  ps.setString(pos++, entity.getProducerCodeTo());
	  ps.setString(pos++, entity.getProducerExcluded());
	  ps.setTimestamp(pos++, entity.getRuleEffectiveDate() != null ? new java.sql.Timestamp(entity.getRuleEffectiveDate().getTime()) : null);
	  ps.setTimestamp(pos++, entity.getRuleExpiryDate() != null ? new java.sql.Timestamp(entity.getRuleExpiryDate().getTime()) : null);
	  if(entity.getVoucherRuleId() != null) ps.setLong(pos++, entity.getVoucherRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public void remove( java.lang.Long voucherRuleId ) throws GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       StgVoucherMappingConfig entity = null;
       try {
          Session session = HibernateUtil.currentSession();
          entity = this.load( voucherRuleId );
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
	buf.append("delete from STG_VOUCHER_MAPPING_CONFIG");
	buf.append(" where 1 = 1");
	buf.append("   and VOUCHER_RULE_ID = ?");
	Log.debug(StgVoucherMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(voucherRuleId != null) ps.setLong(pos++, voucherRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public StgVoucherMappingConfig load( java.lang.Long voucherRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
          if(voucherRuleId==null) {
	    return null;
	  }
          Serializable sId = voucherRuleId;
	  o = session.load(StgVoucherMappingConfig.class,sId);
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
       return (StgVoucherMappingConfig)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from STG_VOUCHER_MAPPING_CONFIG ");
	buf.append(" where 1=1 ");
	buf.append("   and VOUCHER_RULE_ID = ?");
	Log.debug(StgVoucherMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(voucherRuleId != null) ps.setLong(pos++, voucherRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
      StgVoucherMappingConfig entity = null;
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
