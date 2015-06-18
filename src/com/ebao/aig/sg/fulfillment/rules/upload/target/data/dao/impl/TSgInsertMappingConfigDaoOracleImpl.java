package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgInsertMappingConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgInsertMappingConfig;
import com.ebao.foundation.common.config.Env;
import com.ebao.gs.pub.util.HibernateUtil;
import com.ebao.pub.framework.AppContext;
import com.ebao.pub.framework.ExceptionFactory;
import com.ebao.pub.framework.GenericException;
import com.ebao.pub.framework.data.internal.OracleSequencePKGenerator;
import com.ebao.pub.util.DBean;
import com.ebao.pub.util.Log;


public class TSgInsertMappingConfigDaoOracleImpl implements TSgInsertMappingConfigDao{
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
      table = "T_SG_INSERT_MAPPING_CONFIG";
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
      columnTypes.put("insertName", "java.lang.Long");
      columns.put("sequenceNo", "SEQUENCE_NO");
      columnTypes.put("sequenceNo", "java.lang.Integer");
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
  
  public TSgInsertMappingConfig fillEntity(ResultSet rs) throws SQLException {
      TSgInsertMappingConfig entity = new TSgInsertMappingConfig();
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
      entity.setInsertName(new Long(rs.getLong("INSERT_NAME")));
      if (rs.wasNull()) {
          entity.setInsertName(null);
      }
      entity.setSequenceNo(new Integer(rs.getInt("SEQUENCE_NO")));
      if (rs.wasNull()) {
          entity.setSequenceNo(null);
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
  
  public java.lang.Long create(TSgInsertMappingConfig entity) throws GenericException{
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
      entity.setListId(OracleSequencePKGenerator.getInstance().getNextPKValue("S_SG_INSERT_MAPPING_CONFIG__LI"));
}
      DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into T_SG_INSERT_MAPPING_CONFIG(");
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
	buf.append(",INSERT_TIME");
	buf.append(",UPDATE_TIME");
	buf.append(",INSERTED_BY");
	buf.append(",UPDATED_BY");
	buf.append(")");
	buf.append(" values(");
    for (int i=0; i<14; i++) {
	  buf.append(i==0 ? "?" : ",?");
	}
	buf.append(")");
	Log.debug(TSgInsertMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getListId() != null) ps.setLong(pos++, entity.getListId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgInsertMappingConfigDao.class, "listId:" + entity.getListId());
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgInsertMappingConfigDao.class, "ruleId:" + entity.getRuleId());
	  if(entity.getOfflineRuleId() != null) ps.setLong(pos++, entity.getOfflineRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgInsertMappingConfigDao.class, "offlineRuleId:" + entity.getOfflineRuleId());
	  if(entity.getVoucherRuleId() != null) ps.setLong(pos++, entity.getVoucherRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgInsertMappingConfigDao.class, "voucherRuleId:" + entity.getVoucherRuleId());
	  if(entity.getCampaignRuleId() != null) ps.setLong(pos++, entity.getCampaignRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgInsertMappingConfigDao.class, "campaignRuleId:" + entity.getCampaignRuleId());
	  if(entity.getInsertName() != null) ps.setLong(pos++, entity.getInsertName().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgInsertMappingConfigDao.class, "insertName:" + entity.getInsertName());
	  if(entity.getSequenceNo() != null) ps.setInt(pos++, entity.getSequenceNo().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgInsertMappingConfigDao.class, "sequenceNo:" + entity.getSequenceNo());
	  ps.setTimestamp(pos++, entity.getInsertionEffectiveDate() != null ? new java.sql.Timestamp(entity.getInsertionEffectiveDate().getTime()) : null);
	  Log.debug(TSgInsertMappingConfigDao.class, "insertionEffectiveDate:" + entity.getInsertionEffectiveDate());
	  ps.setTimestamp(pos++, entity.getInsertionExpiryDate() != null ? new java.sql.Timestamp(entity.getInsertionExpiryDate().getTime()) : null);
	  Log.debug(TSgInsertMappingConfigDao.class, "insertionExpiryDate:" + entity.getInsertionExpiryDate());
	  if(entity.getExcludeReFulfillment() != null) ps.setInt(pos++, entity.getExcludeReFulfillment().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgInsertMappingConfigDao.class, "excludeReFulfillment:" + entity.getExcludeReFulfillment());
	  ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  Log.debug(TSgInsertMappingConfigDao.class, "insertTime:" + entity.getInsertTime());
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  Log.debug(TSgInsertMappingConfigDao.class, "updateTime:" + entity.getUpdateTime());
	  if (entity.getInsertedBy() != null)
	         ps.setLong(pos++, entity.getInsertedBy().longValue());
	       else
	         ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  Log.debug(TSgInsertMappingConfigDao.class, "insertedBy:" + entity.getInsertedBy());
	  if (entity.getUpdatedBy() != null)
	         ps.setLong(pos++, entity.getUpdatedBy().longValue());
	       else
	         ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  Log.debug(TSgInsertMappingConfigDao.class, "updatedBy:" + entity.getUpdatedBy());
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
  
  public void update(TSgInsertMappingConfig entity) throws GenericException{
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
	buf.append("update T_SG_INSERT_MAPPING_CONFIG set ");
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
    buf.append(",UPDATE_TIME=?");
	buf.append(",UPDATED_BY=?");
	buf.append(" where 1 = 1");
	buf.append("   and LIST_ID = ?");
	Log.debug(TSgInsertMappingConfigDao.class, buf.toString());
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
	  if(entity.getInsertName() != null) ps.setLong(pos++, entity.getInsertName().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getSequenceNo() != null) ps.setInt(pos++, entity.getSequenceNo().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setTimestamp(pos++, entity.getInsertionEffectiveDate() != null ? new java.sql.Timestamp(entity.getInsertionEffectiveDate().getTime()) : null);
	  ps.setTimestamp(pos++, entity.getInsertionExpiryDate() != null ? new java.sql.Timestamp(entity.getInsertionExpiryDate().getTime()) : null);
	  if(entity.getExcludeReFulfillment() != null) ps.setInt(pos++, entity.getExcludeReFulfillment().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  if(entity.getListId() != null) ps.setLong(pos++, entity.getListId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.executeUpdate();
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
       TSgInsertMappingConfig entity = null;
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
	buf.append("delete from T_SG_INSERT_MAPPING_CONFIG");
	buf.append(" where 1 = 1");
	buf.append("   and LIST_ID = ?");
	Log.debug(TSgInsertMappingConfigDao.class, buf.toString());
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
  
  public TSgInsertMappingConfig load( java.lang.Long listId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
          if(listId==null) {
	    return null;
	  }
          Serializable sId = listId;
	  o = session.load(TSgInsertMappingConfig.class,sId);
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
       return (TSgInsertMappingConfig)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from T_SG_INSERT_MAPPING_CONFIG ");
	buf.append(" where 1=1 ");
	buf.append("   and LIST_ID = ?");
	Log.debug(TSgInsertMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(listId != null) ps.setLong(pos++, listId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
      TSgInsertMappingConfig entity = null;
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
  public  Collection getInsertNameList(Long offlineRuleId) throws Exception{
	  DBean db = null;
	  PreparedStatement ps = null;
	  ResultSet rs = null;
	  List insertList=new ArrayList();
	  try{ 
	  	StringBuffer selectQuery = new StringBuffer();
	  	selectQuery.append("select LIST_ID,OFFLINE_RULE_ID,INSERT_NAME,SEQUENCE_NO,"
	  	+ "INSERTION_EFFECTIVE_DATE,INSERTION_EXPIRY_DATE,EXCLUDE_RE_FULFILLMENT from T_SG_INSERT_MAPPING_CONFIG where 1=1");
	  	selectQuery.append(" and OFFLINE_RULE_ID= ? ");
	  	db = new DBean(false);
	  	db.connect();
	  	Connection con = db.getConnection();
	  	ps = con.prepareStatement(selectQuery.toString());
	  	ps.setLong(1, offlineRuleId);
	  	rs = ps.executeQuery();
	  	while (rs.next()) {
	  		TSgInsertMappingConfig info = new TSgInsertMappingConfig();
	  		info.setListId(rs.getLong("LIST_ID"));
	  		info.setOfflineRuleId(rs.getLong("OFFLINE_RULE_ID"));
	  		info.setInsertName(rs.getLong("INSERT_NAME"));
	  		info.setSequenceNo(rs.getInt("SEQUENCE_NO"));
            info.setInsertionEffectiveDate(rs.getDate("INSERTION_EFFECTIVE_DATE"));
	 		info.setInsertionExpiryDate(rs.getDate("INSERTION_EXPIRY_DATE"));
            info.setExcludeReFulfillment(rs.getInt("EXCLUDE_RE_FULFILLMENT"));	  		
	  		insertList.add(info);
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
	  return  insertList;
  }
@Override
public Collection<TSgInsertMappingConfig> getvoucherResultList(
		Long voucherruleId) throws Exception {
	// TODO Auto-generated method stub

	  DBean db = null;
	  PreparedStatement ps = null;
	  ResultSet rs = null;
	  List insertList=new ArrayList();
	  try{ 
	  	StringBuffer selectQuery = new StringBuffer();
	  	selectQuery.append("select LIST_ID,VOUCHER_RULE_ID,INSERT_NAME,SEQUENCE_NO,"
	  	+ "INSERTION_EFFECTIVE_DATE,INSERTION_EXPIRY_DATE,EXCLUDE_RE_FULFILLMENT from T_SG_INSERT_MAPPING_CONFIG where 1=1");
	  	selectQuery.append(" and OFFLINE_RULE_ID is null and CAMPAIGN_RULE_ID is null ");
	  	selectQuery.append(" and VOUCHER_RULE_ID= ? ");
	  	db = new DBean(false);
	  	db.connect();
	  	Connection con = db.getConnection();
	  	ps = con.prepareStatement(selectQuery.toString());
	  	ps.setLong(1, voucherruleId);
	  	rs = ps.executeQuery();
	  	while (rs.next()) {
	  		TSgInsertMappingConfig info = new TSgInsertMappingConfig();
	  		info.setListId(rs.getLong("LIST_ID"));
	  		info.setVoucherRuleId((rs.getLong("VOUCHER_RULE_ID")));
	  		info.setInsertName(rs.getLong("INSERT_NAME"));
	  		info.setSequenceNo(rs.getInt("SEQUENCE_NO"));
          info.setInsertionEffectiveDate(rs.getDate("INSERTION_EFFECTIVE_DATE"));
	 		info.setInsertionExpiryDate(rs.getDate("INSERTION_EXPIRY_DATE"));
          info.setExcludeReFulfillment(rs.getInt("EXCLUDE_RE_FULFILLMENT"));	  		
	  		insertList.add(info);
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
	  return  insertList;

	//return null;
}

public void removeByVoucherRuleId( java.lang.Long voucherRuleId ) throws GenericException{
    
    DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("delete from T_SG_INSERT_MAPPING_CONFIG");
	buf.append(" where 1 = 1");
	buf.append("   and VOUCHER_RULE_ID = ?");
	Log.debug(TSgInsertMappingConfigDao.class, buf.toString());
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
@Override
public TSgInsertMappingConfig loadByCampaignRuleId(Long campaignRuleId) {
	// TODO Auto-generated method stub

    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append(" select INSERT_NAME, SEQUENCE_NO, EXCLUDE_RE_FULFILLMENT, LIST_ID, RULE_ID from T_SG_INSERT_MAPPING_CONFIG ");
	buf.append(" where 1=1 ");
	buf.append(" and OFFLINE_RULE_ID is null and VOUCHER_RULE_ID is null ");
	buf.append("   and CAMPAIGN_RULE_ID = ? ");
	Log.debug(TSgInsertMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
	  int pos = 1;
	  if(campaignRuleId != null) ps.setLong(pos++, campaignRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
	  
      TSgInsertMappingConfig entity = new TSgInsertMappingConfig();
	  
      while(rs.next()){
    	  entity.setListId(rs.getLong("LIST_ID"));
    	  entity.setRuleId(rs.getLong("RULE_ID"));
      entity.setInsertName(rs.getLong("INSERT_NAME"));
      entity.setSequenceNo(rs.getInt("SEQUENCE_NO"));
      entity.setExcludeReFulfillment(rs.getInt("EXCLUDE_RE_FULFILLMENT"));
      }
	  
      return entity;
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(rs, ps, db);
	}
  
	//return null;
}
@Override
public void removeByCampaignRuleId(Long campaignRuleId) {
	// TODO Auto-generated method stub

    
    DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("delete from T_SG_INSERT_MAPPING_CONFIG");
	buf.append(" where 1 = 1");
	buf.append("   and CAMPAIGN_RULE_ID = ?");
	Log.debug(TSgInsertMappingConfigDao.class, buf.toString());
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
}
