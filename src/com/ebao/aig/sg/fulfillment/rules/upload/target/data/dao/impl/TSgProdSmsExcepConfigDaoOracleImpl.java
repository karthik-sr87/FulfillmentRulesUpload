

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

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgProdSmsExcepConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgProdSmsExcepConfig;
import com.ebao.foundation.common.config.Env;
import com.ebao.gs.pub.util.HibernateUtil;
import com.ebao.pub.framework.ExceptionFactory;
import com.ebao.pub.framework.GenericException;
import com.ebao.pub.framework.data.internal.OracleSequencePKGenerator;
import com.ebao.pub.util.DBean;
import com.ebao.pub.util.Log;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public class TSgProdSmsExcepConfigDaoOracleImpl implements TSgProdSmsExcepConfigDao{
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
      table = "T_SG_PROD_SMS_EXCEP_CONFIG";
      columns.put("prodSmsExpId", "PROD_SMS_EXP_ID");
      columnTypes.put("prodSmsExpId", "java.lang.Long");
      columns.put("lobCode", "LOB_CODE");
      columnTypes.put("lobCode", "java.lang.Long");
      columns.put("productCode", "PRODUCT_CODE");
      columnTypes.put("productCode", "java.lang.String");
      columns.put("planGroupId", "PLAN_GROUP_ID");
      columnTypes.put("planGroupId", "java.lang.Long");
      columns.put("plans", "PLANS");
      columnTypes.put("plans", "java.lang.Long");
      columns.put("producerType", "PRODUCER_TYPE");
      columnTypes.put("producerType", "java.lang.Long");
      columns.put("producerCodeFrom", "PRODUCER_CODE_FROM");
      columnTypes.put("producerCodeFrom", "java.lang.String");
      columns.put("producerCodeTo", "PRODUCER_CODE_TO");
      columnTypes.put("producerCodeTo", "java.lang.String");
      columns.put("producersExcluded", "PRODUCERS_EXCLUDED");
      columnTypes.put("producersExcluded", "java.lang.String");
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
  
  public TSgProdSmsExcepConfig fillEntity(ResultSet rs) throws SQLException {
      TSgProdSmsExcepConfig entity = new TSgProdSmsExcepConfig();
      entity.setProdSmsExpId(new Long(rs.getLong("PROD_SMS_EXP_ID")));
      if (rs.wasNull()) {
          entity.setProdSmsExpId(null);
      }
      entity.setLobCode(new Long(rs.getLong("LOB_CODE")));
      if (rs.wasNull()) {
          entity.setLobCode(null);
      }
      entity.setProductCode(rs.getString("PRODUCT_CODE"));
      entity.setPlanGroupId(new Long(rs.getLong("PLAN_GROUP_ID")));
      if (rs.wasNull()) {
          entity.setPlanGroupId(null);
      }
      entity.setPlans(new Long(rs.getLong("PLANS")));
      if (rs.wasNull()) {
          entity.setPlans(null);
      }
      entity.setProducerType(new Long(rs.getLong("PRODUCER_TYPE")));
      if (rs.wasNull()) {
          entity.setProducerType(null);
      }
      entity.setProducerCodeFrom(rs.getString("PRODUCER_CODE_FROM"));
      entity.setProducerCodeTo(rs.getString("PRODUCER_CODE_TO"));
      entity.setProducersExcluded(rs.getString("PRODUCERS_EXCLUDED"));
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
  
  public java.lang.Long create(TSgProdSmsExcepConfig entity) throws GenericException{
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
if ( entity.getProdSmsExpId() == null || entity.getProdSmsExpId().longValue()<=0 ) {
      entity.setProdSmsExpId(OracleSequencePKGenerator.getInstance().getNextPKValue("S_SG_PROD_SMS_EXCEP_CONFIG__PR"));
}
      DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into T_SG_PROD_SMS_EXCEP_CONFIG(");
	buf.append("PROD_SMS_EXP_ID");
	buf.append(",LOB_CODE");
	buf.append(",PRODUCT_CODE");
	buf.append(",PLAN_GROUP_ID");
	buf.append(",PLANS");
	buf.append(",PRODUCER_TYPE");
	buf.append(",PRODUCER_CODE_FROM");
	buf.append(",PRODUCER_CODE_TO");
	buf.append(",PRODUCERS_EXCLUDED");
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
	Log.debug(TSgProdSmsExcepConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getProdSmsExpId() != null) ps.setLong(pos++, entity.getProdSmsExpId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgProdSmsExcepConfigDao.class, "prodSmsExpId:" + entity.getProdSmsExpId());
	  if(entity.getLobCode() != null) ps.setLong(pos++, entity.getLobCode().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgProdSmsExcepConfigDao.class, "lobCode:" + entity.getLobCode());
	  ps.setString(pos++, entity.getProductCode());
	  Log.debug(TSgProdSmsExcepConfigDao.class, "productCode:" + entity.getProductCode());
	  if(entity.getPlanGroupId() != null) ps.setLong(pos++, entity.getPlanGroupId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgProdSmsExcepConfigDao.class, "planGroupId:" + entity.getPlanGroupId());
	  if(entity.getPlans() != null) ps.setLong(pos++, entity.getPlans().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgProdSmsExcepConfigDao.class, "plans:" + entity.getPlans());
	  if(entity.getProducerType() != null) ps.setLong(pos++, entity.getProducerType().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgProdSmsExcepConfigDao.class, "producerType:" + entity.getProducerType());
	  ps.setString(pos++, entity.getProducerCodeFrom());
	  Log.debug(TSgProdSmsExcepConfigDao.class, "producerCodeFrom:" + entity.getProducerCodeFrom());
	  ps.setString(pos++, entity.getProducerCodeTo());
	  Log.debug(TSgProdSmsExcepConfigDao.class, "producerCodeTo:" + entity.getProducerCodeTo());
	  ps.setString(pos++, entity.getProducersExcluded());
	  Log.debug(TSgProdSmsExcepConfigDao.class, "producersExcluded:" + entity.getProducersExcluded());
	  ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  Log.debug(TSgProdSmsExcepConfigDao.class, "insertTime:" + entity.getInsertTime());
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  Log.debug(TSgProdSmsExcepConfigDao.class, "updateTime:" + entity.getUpdateTime());
	  if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgProdSmsExcepConfigDao.class, "insertedBy:" + entity.getInsertedBy());
	  if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgProdSmsExcepConfigDao.class, "updatedBy:" + entity.getUpdatedBy());
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}
    return entity.getProdSmsExpId();
  }
  
  public void update(TSgProdSmsExcepConfig entity) throws GenericException{
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
	buf.append("update T_SG_PROD_SMS_EXCEP_CONFIG set ");
	buf.append("PROD_SMS_EXP_ID=?");
	buf.append(",LOB_CODE=?");
	buf.append(",PRODUCT_CODE=?");
	buf.append(",PLAN_GROUP_ID=?");
	buf.append(",PLANS=?");
	buf.append(",PRODUCER_TYPE=?");
	buf.append(",PRODUCER_CODE_FROM=?");
	buf.append(",PRODUCER_CODE_TO=?");
	buf.append(",PRODUCERS_EXCLUDED=?");
	buf.append(",INSERT_TIME=?");
	buf.append(",UPDATE_TIME=?");
	buf.append(",INSERTED_BY=?");
	buf.append(",UPDATED_BY=?");
	buf.append(" where 1 = 1");
	buf.append("   and PROD_SMS_EXP_ID = ?");
	Log.debug(TSgProdSmsExcepConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getProdSmsExpId() != null) ps.setLong(pos++, entity.getProdSmsExpId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getLobCode() != null) ps.setLong(pos++, entity.getLobCode().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setString(pos++, entity.getProductCode());
	  if(entity.getPlanGroupId() != null) ps.setLong(pos++, entity.getPlanGroupId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getPlans() != null) ps.setLong(pos++, entity.getPlans().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getProducerType() != null) ps.setLong(pos++, entity.getProducerType().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setString(pos++, entity.getProducerCodeFrom());
	  ps.setString(pos++, entity.getProducerCodeTo());
	  ps.setString(pos++, entity.getProducersExcluded());
	  ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getProdSmsExpId() != null) ps.setLong(pos++, entity.getProdSmsExpId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public void remove( java.lang.Long prodSmsExpId ) throws GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       TSgProdSmsExcepConfig entity = null;
       try {
          Session session = HibernateUtil.currentSession();
          entity = this.load( prodSmsExpId );
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
	buf.append("delete from T_SG_PROD_SMS_EXCEP_CONFIG");
	buf.append(" where 1 = 1");
	buf.append("   and PROD_SMS_EXP_ID = ?");
	Log.debug(TSgProdSmsExcepConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(prodSmsExpId != null) ps.setLong(pos++, prodSmsExpId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
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
			selectQuery.append("SELECT max(PROD_SMS_EXP_ID) AS SERIAL_ID FROM T_SG_PROD_SMS_EXCEP_CONFIG");
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
 
  
  public TSgProdSmsExcepConfig load( java.lang.Long prodSmsExpId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
          if(prodSmsExpId==null) {
	    return null;
	  }
          Serializable sId = prodSmsExpId;
	  o = session.load(TSgProdSmsExcepConfig.class,sId);
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
       return (TSgProdSmsExcepConfig)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from T_SG_PROD_SMS_EXCEP_CONFIG ");
	buf.append(" where 1=1 ");
	buf.append("   and PROD_SMS_EXP_ID = ?");
	Log.debug(TSgProdSmsExcepConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(prodSmsExpId != null) ps.setLong(pos++, prodSmsExpId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
      TSgProdSmsExcepConfig entity = null;
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
