

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

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgExtraInsertDataElementDao;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgExtraInsertDataElement;
import com.ebao.foundation.common.config.Env;
import com.ebao.gs.pub.util.HibernateUtil;
import com.ebao.pub.framework.AppContext;
import com.ebao.pub.framework.ExceptionFactory;
import com.ebao.pub.framework.GenericException;
import com.ebao.pub.framework.data.internal.OracleSequencePKGenerator;
import com.ebao.pub.util.DBean;
import com.ebao.pub.util.Log;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////


public class TSgExtraInsertDataElementDaoOracleImpl implements TSgExtraInsertDataElementDao{
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
      table = "T_SG_EXTRA_INSERT_DATA_ELEMENT";
      columns.put("extraInsertId", "EXTRA_INSERT_ID");
      columnTypes.put("extraInsertId", "java.lang.Long");
      columns.put("listId", "LIST_ID");
      columnTypes.put("listId", "java.lang.Long");
      columns.put("dataElementId", "DATA_ELEMENT_ID");
      columnTypes.put("dataElementId", "java.lang.Long");
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
  
  public TSgExtraInsertDataElement fillEntity(ResultSet rs) throws SQLException {
      TSgExtraInsertDataElement entity = new TSgExtraInsertDataElement();
      entity.setExtraInsertId(new Long(rs.getLong("EXTRA_INSERT_ID")));
      if (rs.wasNull()) {
          entity.setExtraInsertId(null);
      }
      entity.setListId(new Long(rs.getLong("LIST_ID")));
      if (rs.wasNull()) {
          entity.setListId(null);
      }
      entity.setDataElementId(new Long(rs.getLong("DATA_ELEMENT_ID")));
      if (rs.wasNull()) {
          entity.setDataElementId(null);
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
  
  public java.lang.Long create(TSgExtraInsertDataElement entity) throws GenericException{
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
      entity.setListId(OracleSequencePKGenerator.getInstance().getNextPKValue("S_SG_EXTRA_INSERT_DATA_ELEMENT"));
}
      DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into T_SG_EXTRA_INSERT_DATA_ELEMENT(");
	buf.append("EXTRA_INSERT_ID");
	buf.append(",LIST_ID");
	buf.append(",DATA_ELEMENT_ID");
	buf.append(",INSERT_TIME");
	buf.append(",UPDATE_TIME");
	buf.append(",INSERTED_BY");
	buf.append(",UPDATED_BY");
	buf.append(")");
	buf.append(" values(");
    for (int i=0; i<7; i++) {
	  buf.append(i==0 ? "?" : ",?");
	}
	buf.append(")");
	Log.debug(TSgExtraInsertDataElementDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getExtraInsertId() != null) ps.setLong(pos++, entity.getExtraInsertId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgExtraInsertDataElementDao.class, "extraInsertId:" + entity.getExtraInsertId());
	  if(entity.getListId() != null) ps.setLong(pos++, entity.getListId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgExtraInsertDataElementDao.class, "listId:" + entity.getListId());
	  if(entity.getDataElementId() != null) ps.setLong(pos++, entity.getDataElementId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgExtraInsertDataElementDao.class, "dataElementId:" + entity.getDataElementId());
	  ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  Log.debug(TSgExtraInsertDataElementDao.class, "insertTime:" + entity.getInsertTime());
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  Log.debug(TSgExtraInsertDataElementDao.class, "updateTime:" + entity.getUpdateTime());
	  if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  Log.debug(TSgExtraInsertDataElementDao.class, "insertedBy:" + entity.getInsertedBy());
	  if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  Log.debug(TSgExtraInsertDataElementDao.class, "updatedBy:" + entity.getUpdatedBy());
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
  
  public void update(TSgExtraInsertDataElement entity) throws GenericException{
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
	buf.append("update T_SG_EXTRA_INSERT_DATA_ELEMENT set ");
	buf.append("EXTRA_INSERT_ID=?");
	buf.append(",LIST_ID=?");
	buf.append(",DATA_ELEMENT_ID=?");
	buf.append(",UPDATE_TIME=?");
	buf.append(",UPDATED_BY=?");
	buf.append(" where 1 = 1");
	buf.append("   and LIST_ID = ?");
	Log.debug(TSgExtraInsertDataElementDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getExtraInsertId() != null) ps.setLong(pos++, entity.getExtraInsertId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getListId() != null) ps.setLong(pos++, entity.getListId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getDataElementId() != null) ps.setLong(pos++, entity.getDataElementId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  if(entity.getListId() != null) ps.setLong(pos++, entity.getListId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
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
       TSgExtraInsertDataElement entity = null;
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
	buf.append("delete from T_SG_EXTRA_INSERT_DATA_ELEMENT");
	buf.append(" where 1 = 1");
	buf.append("   and LIST_ID = ?");
	Log.debug(TSgExtraInsertDataElementDao.class, buf.toString());
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
  
  public TSgExtraInsertDataElement load( java.lang.Long listId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
          if(listId==null) {
	    return null;
	  }
          Serializable sId = listId;
	  o = session.load(TSgExtraInsertDataElement.class,sId);
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
       return (TSgExtraInsertDataElement)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from T_SG_EXTRA_INSERT_DATA_ELEMENT ");
	buf.append(" where 1=1 ");
	buf.append("   and LIST_ID = ?");
	Log.debug(TSgExtraInsertDataElementDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(listId != null) ps.setLong(pos++, listId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
      TSgExtraInsertDataElement entity = null;
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
  
  @Override
  public Collection<TSgExtraInsertDataElement> getdataelementlist(Long extraInsertId) throws Exception{
  	// TODO Auto-generated method stub
  	DBean db = null;
  	Collection<TSgExtraInsertDataElement> entity = null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      List impList=new ArrayList();
  	try{ 
  		StringBuffer selectQuery = new StringBuffer();
  		selectQuery.append("select LIST_ID,DATA_ELEMENT_ID from T_SG_EXTRA_INSERT_DATA_ELEMENT ");
  		selectQuery.append(" where 1=1 ");
  		selectQuery.append("   and EXTRA_INSERT_ID = ?");
  	db = new DBean(false);
  	db.connect();
  	Connection con = db.getConnection();
  	ps = con.prepareStatement(selectQuery.toString());
  	ps.setLong(1,extraInsertId);

  	rs = ps.executeQuery();
  	
  	
  	while (rs.next()) {
  		TSgExtraInsertDataElement newObj = new TSgExtraInsertDataElement();
        newObj.setListId(rs.getLong("LIST_ID"));
        newObj.setDataElementId(rs.getLong("DATA_ELEMENT_ID"));
  		impList.add(newObj);
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
  	 return  impList;
  }

  
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}
