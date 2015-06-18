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

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgImpNoticeConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgImpNoticeConfig;
import com.ebao.foundation.common.config.Env;
import com.ebao.gs.pub.util.HibernateUtil;
import com.ebao.pub.framework.AppContext;
import com.ebao.pub.framework.ExceptionFactory;
import com.ebao.pub.framework.GenericException;
import com.ebao.pub.framework.data.internal.OracleSequencePKGenerator;
import com.ebao.pub.util.DBean;
import com.ebao.pub.util.Log;


public class TSgImpNoticeConfigDaoOracleImpl implements TSgImpNoticeConfigDao{
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
      table = "T_SG_IMP_NOTICE_CONFIG";
      columns.put("impNoticeId", "IMP_NOTICE_ID");
      columnTypes.put("impNoticeId", "java.lang.Long");
      columns.put("producerSubType", "PRODUCER_SUB_TYPE");
      columnTypes.put("producerSubType", "java.lang.Integer");
      columns.put("vehicleType", "VEHICLE_TYPE");
      columnTypes.put("vehicleType", "java.lang.Integer");
      columns.put("templateId", "TEMPLATE_ID");
      columnTypes.put("templateId", "java.lang.Long");
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
  
  public TSgImpNoticeConfig fillEntity(ResultSet rs) throws SQLException {
      TSgImpNoticeConfig entity = new TSgImpNoticeConfig();
      entity.setImpNoticeId(new Long(rs.getLong("IMP_NOTICE_ID")));
      if (rs.wasNull()) {
          entity.setImpNoticeId(null);
      }
      entity.setProducerSubType(rs.getInt("PRODUCER_SUB_TYPE"));
      entity.setVehicleType(rs.getInt("VEHICLE_TYPE"));
      entity.setTemplateId(new Long(rs.getLong("TEMPLATE_ID")));
      if (rs.wasNull()) {
          entity.setTemplateId(null);
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
  
  public java.lang.Long create(TSgImpNoticeConfig entity) throws GenericException{
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
if ( entity.getImpNoticeId() == null || entity.getImpNoticeId().longValue()<=0 ) {
      entity.setImpNoticeId(OracleSequencePKGenerator.getInstance().getNextPKValue("S_SG_IMP_NOTICE_CONFIG__IMP_NO"));
}
      DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into T_SG_IMP_NOTICE_CONFIG(");
	buf.append("IMP_NOTICE_ID");
	buf.append(",PRODUCER_SUB_TYPE");
	buf.append(",VEHICLE_TYPE");
	buf.append(",TEMPLATE_ID");
	buf.append(",EFFECTIVE_DATE");
	buf.append(",EXPIRY_DATE");
	buf.append(",INSERT_TIME");
	buf.append(",UPDATE_TIME");
	buf.append(",INSERTED_BY");
	buf.append(",UPDATED_BY");
	buf.append(")");
	buf.append(" values(");
    for (int i=0; i<10; i++) {
	  buf.append(i==0 ? "?" : ",?");
	}
	buf.append(")");
	Log.debug(TSgImpNoticeConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getImpNoticeId() != null) ps.setLong(pos++, entity.getImpNoticeId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgImpNoticeConfigDao.class, "impNoticeId:" + entity.getImpNoticeId());
	  ps.setInt(pos++, entity.getProducerSubType());
	  Log.debug(TSgImpNoticeConfigDao.class, "producerSubType:" + entity.getProducerSubType());
	  ps.setInt(pos++, entity.getVehicleType());
	  Log.debug(TSgImpNoticeConfigDao.class, "vehicleType:" + entity.getVehicleType());
	  if(entity.getTemplateId() != null) ps.setLong(pos++, entity.getTemplateId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgImpNoticeConfigDao.class, "templateId:" + entity.getTemplateId());
	  ps.setTimestamp(pos++, entity.getEffectiveDate() != null ? new java.sql.Timestamp(entity.getEffectiveDate().getTime()) : null);
	  Log.debug(TSgImpNoticeConfigDao.class, "effectiveDate:" + entity.getEffectiveDate());
	  ps.setTimestamp(pos++, entity.getExpiryDate() != null ? new java.sql.Timestamp(entity.getExpiryDate().getTime()) : null);
	  Log.debug(TSgImpNoticeConfigDao.class, "expiryDate:" + entity.getExpiryDate());
	  ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  Log.debug(TSgImpNoticeConfigDao.class, "insertTime:" + entity.getInsertTime());
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  Log.debug(TSgImpNoticeConfigDao.class, "updateTime:" + entity.getUpdateTime());
	  //if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if (entity.getInsertedBy() != null)
	         ps.setLong(pos++, entity.getInsertedBy().longValue());
	       else
	         ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  Log.debug(TSgImpNoticeConfigDao.class, "insertedBy:" + entity.getInsertedBy());
	  //if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if (entity.getUpdatedBy() != null)
	         ps.setLong(pos++, entity.getUpdatedBy().longValue());
	       else
	         ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  Log.debug(TSgImpNoticeConfigDao.class, "updatedBy:" + entity.getUpdatedBy());
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}
    return entity.getImpNoticeId();
  }
  
  public void update(TSgImpNoticeConfig entity) throws GenericException{
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
	buf.append("update T_SG_IMP_NOTICE_CONFIG set ");
	buf.append("IMP_NOTICE_ID=?");
	buf.append(",PRODUCER_SUB_TYPE=?");
	buf.append(",VEHICLE_TYPE=?");
	buf.append(",TEMPLATE_ID=?");
	buf.append(",EFFECTIVE_DATE=?");
	buf.append(",EXPIRY_DATE=?");
	//buf.append(",INSERT_TIME=?");
	buf.append(",UPDATE_TIME=?");
	//buf.append(",INSERTED_BY=?");
	buf.append(",UPDATED_BY=?");
	buf.append(" where 1 = 1");
	buf.append("   and IMP_NOTICE_ID = ?");
	Log.debug(TSgImpNoticeConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getImpNoticeId() != null) ps.setLong(pos++, entity.getImpNoticeId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setInt(pos++, entity.getProducerSubType());
	  ps.setInt(pos++, entity.getVehicleType());
	  if(entity.getTemplateId() != null) ps.setLong(pos++, entity.getTemplateId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setTimestamp(pos++, entity.getEffectiveDate() != null ? new java.sql.Timestamp(entity.getEffectiveDate().getTime()) : null);
	  ps.setTimestamp(pos++, entity.getExpiryDate() != null ? new java.sql.Timestamp(entity.getExpiryDate().getTime()) : null);
	  //ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  //if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  //if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  if(entity.getImpNoticeId() != null) ps.setLong(pos++, entity.getImpNoticeId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public void remove( java.lang.Long impNoticeId ) throws GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       TSgImpNoticeConfig entity = null;
       try {
          Session session = HibernateUtil.currentSession();
          entity = this.load( impNoticeId );
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
	PreparedStatement ps1 = null;
	StringBuffer buf1 = new StringBuffer();
	buf1.append("delete from T_SG_IMP_NOTICE_SEQ_CONFIG");
	buf1.append(" where 1 = 1");
	buf1.append("   and IMP_NOTICE_ID = ?");
	StringBuffer buf = new StringBuffer();
	buf.append("delete from T_SG_IMP_NOTICE_CONFIG");
	buf.append(" where 1 = 1");
	buf.append("   and IMP_NOTICE_ID = ?");	
	Log.debug(TSgImpNoticeConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf1.toString());
	  ps1 = con.prepareStatement(buf.toString());
      //int pos = 1;
	  ps.setLong(1, impNoticeId.longValue());
      ps1.setLong(1, impNoticeId.longValue());
	 // if(impNoticeId != null) ps.setLong(pos++, impNoticeId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
      ps.executeUpdate();
	  ps1.executeUpdate();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	  DBean.closeAll(null, ps1, db);
	}  
  }
  
  public TSgImpNoticeConfig load( java.lang.Long impNoticeId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
          if(impNoticeId==null) {
	    return null;
	  }
          Serializable sId = impNoticeId;
	  o = session.load(TSgImpNoticeConfig.class,sId);
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
       return (TSgImpNoticeConfig)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from T_SG_IMP_NOTICE_CONFIG ");
	buf.append(" where 1=1 ");
	buf.append("   and IMP_NOTICE_ID = ?");
	Log.debug(TSgImpNoticeConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(impNoticeId != null) ps.setLong(pos++, impNoticeId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
      TSgImpNoticeConfig entity = null;
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
  
public int getImpSequenceId() throws SQLException,ClassNotFoundException 
	{
		DBean db = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    int impSerialId = 0;
		try{ 
			StringBuffer selectQuery = new StringBuffer();
			selectQuery.append("SELECT max(IMP_NOTICE_ID) AS SERIAL_ID FROM T_SG_IMP_NOTICE_CONFIG");
		db = new DBean(false);
		db.connect();
		Connection con = db.getConnection();
		ps = con.prepareStatement(selectQuery.toString());
		rs = ps.executeQuery();
		while (rs.next()) {
			impSerialId = rs.getInt("SERIAL_ID");
			
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
		return impSerialId+1;
	}  
}