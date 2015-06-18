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

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgProducerExceptionConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgProducerExceptionConfig;
import com.ebao.foundation.common.config.Env;
import com.ebao.gs.pub.util.HibernateUtil;
import com.ebao.pub.framework.AppContext;
import com.ebao.pub.framework.ExceptionFactory;
import com.ebao.pub.framework.GenericException;
import com.ebao.pub.framework.data.internal.OracleSequencePKGenerator;
import com.ebao.pub.util.DBean;
import com.ebao.pub.util.Log;


public class TSgProducerExceptionConfigDaoOracleImpl implements TSgProducerExceptionConfigDao{
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
      table = "T_SG_PRODUCER_EXCEPTION_CONFIG";
      columns.put("pdcrExcpRuleId", "PDCR_EXCP_RULE_ID");
      columnTypes.put("pdcrExcpRuleId", "java.lang.Long");
      columns.put("lobId", "LOB_ID");
      columnTypes.put("lobId", "java.lang.Long");
      columns.put("pdcrCodeFrom", "PDCR_CODE_FROM");
      columnTypes.put("pdcrCodeFrom", "java.lang.String");
      columns.put("pdcrCodeTo", "PDCR_CODE_TO");
      columnTypes.put("pdcrCodeTo", "java.lang.String");
      columns.put("excludePdcrCode", "EXCLUDE_PDCR_CODE");
      columnTypes.put("excludePdcrCode", "java.lang.String");
      columns.put("sprsCustEmail", "SPRS_CUST_EMAIL");
      columnTypes.put("sprsCustEmail", "java.lang.Integer");
      columns.put("sprsCustOffline", "SPRS_CUST_OFFLINE");
      columnTypes.put("sprsCustOffline", "java.lang.Integer");
      columns.put("sprsPdcrOffline", "SPRS_PDCR_OFFLINE");
      columnTypes.put("sprsPdcrOffline", "java.lang.Integer");
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
  
  public TSgProducerExceptionConfig fillEntity(ResultSet rs) throws SQLException {
      TSgProducerExceptionConfig entity = new TSgProducerExceptionConfig();
      entity.setPdcrExcpRuleId(new Long(rs.getLong("PDCR_EXCP_RULE_ID")));
      if (rs.wasNull()) {
          entity.setPdcrExcpRuleId(null);
      }
      entity.setLobId(new Long(rs.getLong("LOB_ID")));
      if (rs.wasNull()) {
          entity.setLobId(null);
      }
      entity.setPdcrCodeFrom(rs.getString("PDCR_CODE_FROM"));
      entity.setPdcrCodeTo(rs.getString("PDCR_CODE_TO"));
      entity.setExcludePdcrCode(rs.getString("EXCLUDE_PDCR_CODE"));
      entity.setSprsCustEmail(new Integer(rs.getInt("SPRS_CUST_EMAIL")));
      if (rs.wasNull()) {
          entity.setSprsCustEmail(null);
      }
      entity.setSprsCustOffline(new Integer(rs.getInt("SPRS_CUST_OFFLINE")));
      if (rs.wasNull()) {
          entity.setSprsCustOffline(null);
      }
      entity.setSprsPdcrOffline(new Integer(rs.getInt("SPRS_PDCR_OFFLINE")));
      if (rs.wasNull()) {
          entity.setSprsPdcrOffline(null);
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
  
  public java.lang.Long create(TSgProducerExceptionConfig entity) throws GenericException{
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
if ( entity.getPdcrExcpRuleId() == null || entity.getPdcrExcpRuleId().longValue()<=0 ) {
      entity.setPdcrExcpRuleId(OracleSequencePKGenerator.getInstance().getNextPKValue("S_SG_PRODUCER_EXCEPTION_CONFIG"));
}
      DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into T_SG_PRODUCER_EXCEPTION_CONFIG(");
	buf.append("PDCR_EXCP_RULE_ID");
	buf.append(",LOB_ID");
	buf.append(",PDCR_CODE_FROM");
	buf.append(",PDCR_CODE_TO");
	buf.append(",EXCLUDE_PDCR_CODE");
	buf.append(",SPRS_CUST_EMAIL");
	buf.append(",SPRS_CUST_OFFLINE");
	buf.append(",SPRS_PDCR_OFFLINE");
	buf.append(",EFFECTIVE_DATE");
	buf.append(",EXPIRY_DATE");
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
	Log.debug(TSgProducerExceptionConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getPdcrExcpRuleId() != null) ps.setLong(pos++, entity.getPdcrExcpRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgProducerExceptionConfigDao.class, "pdcrExcpRuleId:" + entity.getPdcrExcpRuleId());
	  if(entity.getLobId() != null) ps.setLong(pos++, entity.getLobId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgProducerExceptionConfigDao.class, "lobId:" + entity.getLobId());
	  ps.setString(pos++, entity.getPdcrCodeFrom());
	  Log.debug(TSgProducerExceptionConfigDao.class, "pdcrCodeFrom:" + entity.getPdcrCodeFrom());
	  ps.setString(pos++, entity.getPdcrCodeTo());
	  Log.debug(TSgProducerExceptionConfigDao.class, "pdcrCodeTo:" + entity.getPdcrCodeTo());
	  ps.setString(pos++, entity.getExcludePdcrCode());
	  Log.debug(TSgProducerExceptionConfigDao.class, "excludePdcrCode:" + entity.getExcludePdcrCode());
	  if(entity.getSprsCustEmail() != null) ps.setInt(pos++, entity.getSprsCustEmail().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgProducerExceptionConfigDao.class, "sprsCustEmail:" + entity.getSprsCustEmail());
	  if(entity.getSprsCustOffline() != null) ps.setInt(pos++, entity.getSprsCustOffline().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgProducerExceptionConfigDao.class, "sprsCustOffline:" + entity.getSprsCustOffline());
	  if(entity.getSprsPdcrOffline() != null) ps.setInt(pos++, entity.getSprsPdcrOffline().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgProducerExceptionConfigDao.class, "sprsPdcrOffline:" + entity.getSprsPdcrOffline());
	  ps.setTimestamp(pos++, entity.getEffectiveDate() != null ? new java.sql.Timestamp(entity.getEffectiveDate().getTime()) : null);
	  Log.debug(TSgProducerExceptionConfigDao.class, "effectiveDate:" + entity.getEffectiveDate());
	  ps.setTimestamp(pos++, entity.getExpiryDate() != null ? new java.sql.Timestamp(entity.getExpiryDate().getTime()) : null);
	  Log.debug(TSgProducerExceptionConfigDao.class, "expiryDate:" + entity.getExpiryDate());
	  ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  Log.debug(TSgProducerExceptionConfigDao.class, "insertTime:" + entity.getInsertTime());
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  Log.debug(TSgProducerExceptionConfigDao.class, "updateTime:" + entity.getUpdateTime());
	  //if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if (entity.getInsertedBy() != null)
	         ps.setLong(pos++, entity.getInsertedBy().longValue());
	       else
	         ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  Log.debug(TSgProducerExceptionConfigDao.class, "insertedBy:" + entity.getInsertedBy());
	 //if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if (entity.getUpdatedBy() != null)
	         ps.setLong(pos++, entity.getUpdatedBy().longValue());
	       else
	         ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  Log.debug(TSgProducerExceptionConfigDao.class, "updatedBy:" + entity.getUpdatedBy());
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}
    return entity.getPdcrExcpRuleId();
  }
  
  public void update(TSgProducerExceptionConfig entity) throws GenericException{
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
	buf.append("update T_SG_PRODUCER_EXCEPTION_CONFIG set ");
	buf.append("PDCR_EXCP_RULE_ID=?");
	buf.append(",LOB_ID=?");
	buf.append(",PDCR_CODE_FROM=?");
	buf.append(",PDCR_CODE_TO=?");
	buf.append(",EXCLUDE_PDCR_CODE=?");
	buf.append(",SPRS_CUST_EMAIL=?");
	buf.append(",SPRS_CUST_OFFLINE=?");
	buf.append(",SPRS_PDCR_OFFLINE=?");
	buf.append(",EFFECTIVE_DATE=?");
	buf.append(",EXPIRY_DATE=?");
	//buf.append(",INSERT_TIME=?");
	buf.append(",UPDATE_TIME=?");
	//buf.append(",INSERTED_BY=?");
	buf.append(",UPDATED_BY=?");
	buf.append(" where 1 = 1");
	buf.append("   and PDCR_EXCP_RULE_ID = ?");
	Log.debug(TSgProducerExceptionConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getPdcrExcpRuleId() != null) ps.setLong(pos++, entity.getPdcrExcpRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getLobId() != null) ps.setLong(pos++, entity.getLobId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setString(pos++, entity.getPdcrCodeFrom());
	  ps.setString(pos++, entity.getPdcrCodeTo());
	  ps.setString(pos++, entity.getExcludePdcrCode());
	  if(entity.getSprsCustEmail() != null) ps.setInt(pos++, entity.getSprsCustEmail().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getSprsCustOffline() != null) ps.setInt(pos++, entity.getSprsCustOffline().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getSprsPdcrOffline() != null) ps.setInt(pos++, entity.getSprsPdcrOffline().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setTimestamp(pos++, entity.getEffectiveDate() != null ? new java.sql.Timestamp(entity.getEffectiveDate().getTime()) : null);
	  ps.setTimestamp(pos++, entity.getExpiryDate() != null ? new java.sql.Timestamp(entity.getExpiryDate().getTime()) : null);
	  //ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  //if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  //if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  if(entity.getPdcrExcpRuleId() != null) ps.setLong(pos++, entity.getPdcrExcpRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public void remove( java.lang.Long pdcrExcpRuleId ) throws GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       TSgProducerExceptionConfig entity = null;
       try {
          Session session = HibernateUtil.currentSession();
          entity = this.load( pdcrExcpRuleId );
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
	buf.append("delete from T_SG_PRODUCER_EXCEPTION_CONFIG");
	buf.append(" where 1 = 1");
	buf.append("   and PDCR_EXCP_RULE_ID = ?");
	Log.debug(TSgProducerExceptionConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(pdcrExcpRuleId != null) ps.setLong(pos++, pdcrExcpRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public TSgProducerExceptionConfig load( java.lang.Long pdcrExcpRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
          if(pdcrExcpRuleId==null) {
	    return null;
	  }
          Serializable sId = pdcrExcpRuleId;
	  o = session.load(TSgProducerExceptionConfig.class,sId);
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
       return (TSgProducerExceptionConfig)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from T_SG_PRODUCER_EXCEPTION_CONFIG ");
	buf.append(" where 1=1 ");
	buf.append("   and PDCR_EXCP_RULE_ID = ?");
	Log.debug(TSgProducerExceptionConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(pdcrExcpRuleId != null) ps.setLong(pos++, pdcrExcpRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
      TSgProducerExceptionConfig entity = null;
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
  
 
	public int getSequenceID() throws SQLException, ClassNotFoundException {
		DBean db = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int serialId = 0;
		try {
			StringBuffer selectQuery = new StringBuffer();
			selectQuery.append("SELECT max(PDCR_EXCP_RULE_ID) AS SERIAL_ID FROM T_SG_PRODUCER_EXCEPTION_CONFIG");
			db = new DBean(false);
			db.connect();
			Connection con = db.getConnection();
			ps = con.prepareStatement(selectQuery.toString());
			rs = ps.executeQuery();
			while (rs.next()) {
				serialId = rs.getInt("SERIAL_ID");				
			}
		} catch (ClassNotFoundException ex) {
			throw ex;
		} catch (SQLException sql) {
			throw sql;
		} finally {
			DBean.closeAll(rs, ps, db);
		}
		return serialId + 1;
	}
}
