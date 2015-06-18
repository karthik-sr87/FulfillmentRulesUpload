

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

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgProducerSubTypeConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgProducerSubTypeConfig;
import com.ebao.foundation.common.config.Env;
import com.ebao.gs.pub.util.HibernateUtil;
import com.ebao.pub.framework.AppContext;
import com.ebao.pub.framework.ExceptionFactory;
import com.ebao.pub.framework.GenericException;
import com.ebao.pub.framework.data.internal.OracleSequencePKGenerator;
import com.ebao.pub.util.DBean;
import com.ebao.pub.util.Log;



public class TSgProducerSubTypeConfigDaoOracleImpl implements TSgProducerSubTypeConfigDao{
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
	      table = "T_SG_PRODUCER_SUB_TYPE_CONFIG";
	      columns.put("producerListId", "PRODUCER_LIST_ID");
	      columnTypes.put("producerListId", "java.lang.Long");
	      columns.put("producerSubType", "PRODUCER_SUB_TYPE");
	      columnTypes.put("producerSubType", "java.lang.Integer");
	      columns.put("producerCodeFrom", "PRODUCER_CODE_FROM");
	      columnTypes.put("producerCodeFrom", "java.lang.String");
	      columns.put("producerCodeTo", "PRODUCER_CODE_TO");
	      columnTypes.put("producerCodeTo", "java.lang.String");
	      columns.put("producersExcluded", "PRODUCERS_EXCLUDED");
	      columnTypes.put("producersExcluded", "java.lang.String");
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
	  
	  public TSgProducerSubTypeConfig fillEntity(ResultSet rs) throws SQLException {
	      TSgProducerSubTypeConfig entity = new TSgProducerSubTypeConfig();
	      entity.setProducerListId(new Long(rs.getLong("PRODUCER_LIST_ID")));
	      if (rs.wasNull()) {
	          entity.setProducerListId(null);
	      }
	      entity.setProducerSubType(rs.getInt("PRODUCER_SUB_TYPE"));
	      entity.setProducerCodeFrom(rs.getString("PRODUCER_CODE_FROM"));
	      entity.setProducerCodeTo(rs.getString("PRODUCER_CODE_TO"));
	      entity.setProducersExcluded(rs.getString("PRODUCERS_EXCLUDED"));
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
	  
	  public java.lang.Long create(TSgProducerSubTypeConfig entity) throws GenericException{
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
	if ( entity.getProducerListId() == null || entity.getProducerListId().longValue()<=0 ) {
	      entity.setProducerListId(OracleSequencePKGenerator.getInstance().getNextPKValue("S_SG_PRODUCER_SUB_TYPE_CONFIG_"));
	}
	      DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer buf = new StringBuffer();
		buf.append("insert into T_SG_PRODUCER_SUB_TYPE_CONFIG(");
		buf.append("PRODUCER_LIST_ID");
		buf.append(",PRODUCER_SUB_TYPE");
		buf.append(",PRODUCER_CODE_FROM");
		buf.append(",PRODUCER_CODE_TO");
		buf.append(",PRODUCERS_EXCLUDED");
		buf.append(",EFFECTIVE_DATE");
		buf.append(",EXPIRY_DATE");
		buf.append(",INSERT_TIME");
		buf.append(",UPDATE_TIME");
		buf.append(",INSERTED_BY");
		buf.append(",UPDATED_BY");
		buf.append(")");
		buf.append(" values(");
	    for (int i=0; i<11; i++) {
		  buf.append(i==0 ? "?" : ",?");
		}
		buf.append(")");
		Log.debug(TSgProducerSubTypeConfigDao.class, buf.toString());
		try {
		  db.connect();
		  Connection con = db.getConnection();
		  ps = con.prepareStatement(buf.toString());
	      int pos = 1;
		  if(entity.getProducerListId() != null) ps.setLong(pos++, entity.getProducerListId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
		  Log.debug(TSgProducerSubTypeConfigDao.class, "producerListId:" + entity.getProducerListId());
		  ps.setInt(pos++, entity.getProducerSubType());
		  Log.debug(TSgProducerSubTypeConfigDao.class, "producerSubType:" + entity.getProducerSubType());
		  ps.setString(pos++, entity.getProducerCodeFrom());
		  Log.debug(TSgProducerSubTypeConfigDao.class, "producerCodeFrom:" + entity.getProducerCodeFrom());
		  ps.setString(pos++, entity.getProducerCodeTo());
		  Log.debug(TSgProducerSubTypeConfigDao.class, "producerCodeTo:" + entity.getProducerCodeTo());
		  ps.setString(pos++, entity.getProducersExcluded());
		  Log.debug(TSgProducerSubTypeConfigDao.class, "producersExcluded:" + entity.getProducersExcluded());
		  ps.setTimestamp(pos++, entity.getEffectiveDate() != null ? new java.sql.Timestamp(entity.getEffectiveDate().getTime()) : null);
		  Log.debug(TSgProducerSubTypeConfigDao.class, "effectiveDate:" + entity.getEffectiveDate());
		  ps.setTimestamp(pos++, entity.getExpiryDate() != null ? new java.sql.Timestamp(entity.getExpiryDate().getTime()) : null);
		  Log.debug(TSgProducerSubTypeConfigDao.class, "expiryDate:" + entity.getExpiryDate());
		  ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
		  Log.debug(TSgProducerSubTypeConfigDao.class, "insertTime:" + entity.getInsertTime());
		  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
		  Log.debug(TSgProducerSubTypeConfigDao.class, "updateTime:" + entity.getUpdateTime());
		  //if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
		  if (entity.getInsertedBy() != null)
	          ps.setLong(pos++, entity.getInsertedBy().longValue());
	        else
	          ps.setLong(pos++, AppContext.getCurrentUser().getUserId());

		  Log.debug(TSgProducerSubTypeConfigDao.class, "insertedBy:" + entity.getInsertedBy());
		  //if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
		  if (entity.getUpdatedBy() != null)
	          ps.setLong(pos++, entity.getUpdatedBy().longValue());
	        else
	          ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
		  Log.debug(TSgProducerSubTypeConfigDao.class, "updatedBy:" + entity.getUpdatedBy());
		  ps.execute();
		} catch (SQLException e) {
		  throw ExceptionFactory.parse(e);
		} catch (ClassNotFoundException e) {
		  throw ExceptionFactory.parse(e);
		} finally {
		  DBean.closeAll(null, ps, db);
		}
	    return entity.getProducerListId();
	  }
	  
	  public void update(TSgProducerSubTypeConfig entity) throws GenericException{
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
		buf.append("update T_SG_PRODUCER_SUB_TYPE_CONFIG set ");
		buf.append("PRODUCER_LIST_ID=?");
		buf.append(",PRODUCER_SUB_TYPE=?");
		buf.append(",PRODUCER_CODE_FROM=?");
		buf.append(",PRODUCER_CODE_TO=?");
		buf.append(",PRODUCERS_EXCLUDED=?");
		buf.append(",EFFECTIVE_DATE=?");
		buf.append(",EXPIRY_DATE=?");
		buf.append(",UPDATE_TIME=?");
		buf.append(",UPDATED_BY=?");
		buf.append(" where 1 = 1");
		buf.append("   and PRODUCER_LIST_ID = ?");
		Log.debug(TSgProducerSubTypeConfigDao.class, buf.toString());
		try {
		  db.connect();
		  Connection con = db.getConnection();
		  ps = con.prepareStatement(buf.toString());
	      int pos = 1;
		  if(entity.getProducerListId() != null) ps.setLong(pos++, entity.getProducerListId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
		  ps.setInt(pos++, entity.getProducerSubType());
		  ps.setString(pos++, entity.getProducerCodeFrom());
		  ps.setString(pos++, entity.getProducerCodeTo());
		  ps.setString(pos++, entity.getProducersExcluded());
		  ps.setTimestamp(pos++, entity.getEffectiveDate() != null ? new java.sql.Timestamp(entity.getEffectiveDate().getTime()) : null);
		  ps.setTimestamp(pos++, entity.getExpiryDate() != null ? new java.sql.Timestamp(entity.getExpiryDate().getTime()) : null);
		  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
		  ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
		  if(entity.getProducerListId() != null) ps.setLong(pos++, entity.getProducerListId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
		  ps.execute();
		} catch (SQLException e) {
		  throw ExceptionFactory.parse(e);
		} catch (ClassNotFoundException e) {
		  throw ExceptionFactory.parse(e);
		} finally {
		  DBean.closeAll(null, ps, db);
		}  
	  }
	  
	  public void remove( java.lang.Long producerListId ) throws GenericException{
	    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
	       TSgProducerSubTypeConfig entity = null;
	       try {
	          Session session = HibernateUtil.currentSession();
	          entity = this.load( producerListId );
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
		buf.append("delete from T_SG_PRODUCER_SUB_TYPE_CONFIG");
		buf.append(" where 1 = 1");
		buf.append("   and PRODUCER_LIST_ID = ?");
		Log.debug(TSgProducerSubTypeConfigDao.class, buf.toString());
		try {
		  db.connect();
		  Connection con = db.getConnection();
		  ps = con.prepareStatement(buf.toString());
	      int pos = 1;
		  if(producerListId != null) ps.setLong(pos++, producerListId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
		  ps.execute();
		} catch (SQLException e) {
		  throw ExceptionFactory.parse(e);
		} catch (ClassNotFoundException e) {
		  throw ExceptionFactory.parse(e);
		} finally {
		  DBean.closeAll(null, ps, db);
		}  
	  }
	  
	  public TSgProducerSubTypeConfig load( java.lang.Long producerListId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
	    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
	       Object o = null;
	       try {
	          Session session = HibernateUtil.currentSession();
	          if(producerListId==null) {
		    return null;
		  }
	          Serializable sId = producerListId;
		  o = session.load(TSgProducerSubTypeConfig.class,sId);
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
	       return (TSgProducerSubTypeConfig)o;
	    }
	  
	    DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer buf = new StringBuffer();
		buf.append("select * from T_SG_PRODUCER_SUB_TYPE_CONFIG ");
		buf.append(" where 1=1 ");
		buf.append("   and PRODUCER_LIST_ID = ?");
		Log.debug(TSgProducerSubTypeConfigDao.class, buf.toString());
		try {
		  db.connect();
		  Connection con = db.getConnection();
		  ps = con.prepareStatement(buf.toString());
	      int pos = 1;
		  if(producerListId != null) ps.setLong(pos++, producerListId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
		  rs = ps.executeQuery();
	      TSgProducerSubTypeConfig entity = null;
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
		
	public int getSequenceID() throws SQLException,ClassNotFoundException 
	{
		DBean db = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    int serialId = 0;
		try{ 
			StringBuffer selectQuery = new StringBuffer();
			selectQuery.append("SELECT max(PRODUCER_LIST_ID) AS SERIAL_ID FROM T_SG_PRODUCER_SUB_TYPE_CONFIG");
		db = new DBean(false);
		db.connect();
		Connection con = db.getConnection();
		ps = con.prepareStatement(selectQuery.toString());
		rs = ps.executeQuery();
		while (rs.next()) {
			serialId = rs.getInt("SERIAL_ID");
		
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
	
	  
  

}
