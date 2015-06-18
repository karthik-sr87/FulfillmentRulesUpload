

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

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgGstProducerConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgGstProducerConfig;
import com.ebao.foundation.common.config.Env;
import com.ebao.gs.pub.util.HibernateUtil;
import com.ebao.pub.framework.ExceptionFactory;
import com.ebao.pub.framework.GenericException;
import com.ebao.pub.framework.data.internal.OracleSequencePKGenerator;
import com.ebao.pub.util.DBean;
import com.ebao.pub.util.Log;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public class TSgGstProducerConfigDaoOracleImpl implements TSgGstProducerConfigDao{
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
      table = "T_SG_GST_PRODUCER_CONFIG";
      columns.put("gstProducerRuleId", "GST_PRODUCER_RULE_ID");
      columnTypes.put("gstProducerRuleId", "java.lang.Long");
      columns.put("gstProducerCode", "GST_PRODUCER_CODE");
      columnTypes.put("gstProducerCode", "java.lang.String");
      columns.put("bigProducerFlag", "BIG_PRODUCER_FLAG");
      columnTypes.put("bigProducerFlag", "java.lang.Integer");
      columns.put("effectiveDate", "EFFECTIVE_DATE");
      columnTypes.put("effectiveDate", "java.util.Date");
      columns.put("expiryDate", "EXPIRY_DATE");
      columnTypes.put("expiryDate", "java.util.Date");
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
  
  public TSgGstProducerConfig fillEntity(ResultSet rs) throws SQLException {
      TSgGstProducerConfig entity = new TSgGstProducerConfig();
      entity.setGstProducerRuleId(new Long(rs.getLong("GST_PRODUCER_RULE_ID")));
      if (rs.wasNull()) {
          entity.setGstProducerRuleId(null);
      }
      entity.setGstProducerCode(rs.getString("GST_PRODUCER_CODE"));
      entity.setBigProducerFlag(new Integer(rs.getInt("BIG_PRODUCER_FLAG")));
      if (rs.wasNull()) {
          entity.setBigProducerFlag(null);
      }
      entity.setEffectiveDate(rs.getTimestamp("EFFECTIVE_DATE"));
      entity.setExpiryDate(rs.getTimestamp("EXPIRY_DATE"));
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
    
  public int getSequenceID() throws SQLException,ClassNotFoundException 
	{
		DBean db = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    int serialId = 0;
		try{ 
			StringBuffer selectQuery = new StringBuffer();
			selectQuery.append("SELECT max(GST_PRODUCER_RULE_ID) AS SERIAL_ID FROM T_SG_GST_PRODUCER_CONFIG");
		db = new DBean(false);
		db.connect();
		Connection con = db.getConnection();
		ps = con.prepareStatement(selectQuery.toString());
		rs = ps.executeQuery();
		while (rs.next()) {
			serialId = rs.getInt("SERIAL_ID");
			System.out.println("searialID :: "+ serialId);
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

  
  public java.lang.Long create(TSgGstProducerConfig entity) throws GenericException{
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
if ( entity.getGstProducerRuleId() == null || entity.getGstProducerRuleId().longValue()<=0 ) {
      entity.setGstProducerRuleId(OracleSequencePKGenerator.getInstance().getNextPKValue("S_SG_GST_PRODUCER_CONFIG__GST_"));
}
      DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into T_SG_GST_PRODUCER_CONFIG(");
	buf.append("GST_PRODUCER_RULE_ID");
	buf.append(",GST_PRODUCER_CODE");
	buf.append(",BIG_PRODUCER_FLAG");
	buf.append(",EFFECTIVE_DATE");
	buf.append(",EXPIRY_DATE");
	buf.append(",INSERT_TIME");
	buf.append(",UPDATE_TIME");
	buf.append(",INSERTED_BY");
	buf.append(",UPDATED_BY");
	buf.append(")");
	buf.append(" values(");
    for (int i=0; i<9; i++) {
	  buf.append(i==0 ? "?" : ",?");
	}
	buf.append(")");
	Log.debug(TSgGstProducerConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getGstProducerRuleId() != null) ps.setLong(pos++, entity.getGstProducerRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgGstProducerConfigDao.class, "gstProducerRuleId:" + entity.getGstProducerRuleId());
	  ps.setString(pos++, entity.getGstProducerCode());
	  Log.debug(TSgGstProducerConfigDao.class, "gstProducerCode:" + entity.getGstProducerCode());
	  if(entity.getBigProducerFlag() != null) ps.setInt(pos++, entity.getBigProducerFlag().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgGstProducerConfigDao.class, "bigProducerFlag:" + entity.getBigProducerFlag());
	  ps.setTimestamp(pos++, entity.getEffectiveDate() != null ? new java.sql.Timestamp(entity.getEffectiveDate().getTime()) : null);
	  Log.debug(TSgGstProducerConfigDao.class, "effectiveDate:" + entity.getEffectiveDate());
	  ps.setTimestamp(pos++, entity.getExpiryDate() != null ? new java.sql.Timestamp(entity.getExpiryDate().getTime()) : null);
	  Log.debug(TSgGstProducerConfigDao.class, "expiryDate:" + entity.getExpiryDate());
	  ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  Log.debug(TSgGstProducerConfigDao.class, "insertTime:" + entity.getInsertTime());
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  Log.debug(TSgGstProducerConfigDao.class, "updateTime:" + entity.getUpdateTime());
	  if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgGstProducerConfigDao.class, "insertedBy:" + entity.getInsertedBy());
	  if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgGstProducerConfigDao.class, "updatedBy:" + entity.getUpdatedBy());
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}
    return entity.getGstProducerRuleId();
  }
  
  public void update(TSgGstProducerConfig entity) throws GenericException{
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
	buf.append("update T_SG_GST_PRODUCER_CONFIG set ");
	buf.append("GST_PRODUCER_RULE_ID=?");
	buf.append(",GST_PRODUCER_CODE=?");
	buf.append(",BIG_PRODUCER_FLAG=?");
	buf.append(",EFFECTIVE_DATE=?");
	buf.append(",EXPIRY_DATE=?");
	buf.append(",INSERT_TIME=?");
	buf.append(",UPDATE_TIME=?");
	buf.append(",INSERTED_BY=?");
	buf.append(",UPDATED_BY=?");
	buf.append(" where 1 = 1");
	buf.append("   and GST_PRODUCER_RULE_ID = ?");
	Log.debug(TSgGstProducerConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getGstProducerRuleId() != null) ps.setLong(pos++, entity.getGstProducerRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setString(pos++, entity.getGstProducerCode());
	  if(entity.getBigProducerFlag() != null) ps.setInt(pos++, entity.getBigProducerFlag().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setTimestamp(pos++, entity.getEffectiveDate() != null ? new java.sql.Timestamp(entity.getEffectiveDate().getTime()) : null);
	  ps.setTimestamp(pos++, entity.getExpiryDate() != null ? new java.sql.Timestamp(entity.getExpiryDate().getTime()) : null);
	  ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getGstProducerRuleId() != null) ps.setLong(pos++, entity.getGstProducerRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public void remove( java.lang.Long gstProducerRuleId ) throws GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       TSgGstProducerConfig entity = null;
       try {
          Session session = HibernateUtil.currentSession();
          entity = this.load( gstProducerRuleId );
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
	buf.append("delete from T_SG_GST_PRODUCER_CONFIG");
	buf.append(" where 1 = 1");
	buf.append("   and GST_PRODUCER_RULE_ID = ?");
	Log.debug(TSgGstProducerConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(gstProducerRuleId != null) ps.setLong(pos++, gstProducerRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public TSgGstProducerConfig load( java.lang.Long gstProducerRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
          if(gstProducerRuleId==null) {
	    return null;
	  }
          Serializable sId = gstProducerRuleId;
	  o = session.load(TSgGstProducerConfig.class,sId);
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
       return (TSgGstProducerConfig)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from T_SG_GST_PRODUCER_CONFIG ");
	buf.append(" where 1=1 ");
	buf.append("   and GST_PRODUCER_RULE_ID = ?");
	Log.debug(TSgGstProducerConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(gstProducerRuleId != null) ps.setLong(pos++, gstProducerRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
      TSgGstProducerConfig entity = null;
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
