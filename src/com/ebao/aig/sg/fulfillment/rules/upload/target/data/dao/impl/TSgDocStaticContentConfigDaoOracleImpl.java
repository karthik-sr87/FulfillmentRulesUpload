

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

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgDocStaticContentConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgDocStaticContentConfig;
import com.ebao.foundation.common.config.Env;
import com.ebao.gs.pub.util.HibernateUtil;
import com.ebao.pub.framework.ExceptionFactory;
import com.ebao.pub.framework.GenericException;
import com.ebao.pub.framework.data.internal.OracleSequencePKGenerator;
import com.ebao.pub.util.DBean;
import com.ebao.pub.util.Log;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public class TSgDocStaticContentConfigDaoOracleImpl implements TSgDocStaticContentConfigDao{
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
      table = "T_SG_DOC_STATIC_CONTENT_CONFIG";
      columns.put("staticContentId", "STATIC_CONTENT_ID");
      columnTypes.put("staticContentId", "java.lang.Long");
      columns.put("templateId", "TEMPLATE_ID");
      columnTypes.put("templateId", "java.lang.Long");
      columns.put("templateAttributeId", "TEMPLATE_ATTRIBUTE_ID");
      columnTypes.put("templateAttributeId", "java.lang.Long");
      columns.put("effectiveDate", "EFFECTIVE_DATE");
      columnTypes.put("effectiveDate", "java.util.Date");
      columns.put("expiryDate", "EXPIRY_DATE");
      columnTypes.put("expiryDate", "java.util.Date");
      columns.put("originalContent", "ORIGINAL_CONTENT");
      columnTypes.put("originalContent", "java.lang.String");
      columns.put("replacementContent", "REPLACEMENT_CONTENT");
      columnTypes.put("replacementContent", "java.lang.String");
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
  
  public TSgDocStaticContentConfig fillEntity(ResultSet rs) throws SQLException {
      TSgDocStaticContentConfig entity = new TSgDocStaticContentConfig();
      entity.setStaticContentId(new Long(rs.getLong("STATIC_CONTENT_ID")));
      if (rs.wasNull()) {
          entity.setStaticContentId(null);
      }
      entity.setTemplateId(new Long(rs.getLong("TEMPLATE_ID")));
      if (rs.wasNull()) {
          entity.setTemplateId(null);
      }
      entity.setTemplateAttributeId(new Long(rs.getLong("TEMPLATE_ATTRIBUTE_ID")));
      if (rs.wasNull()) {
          entity.setTemplateAttributeId(null);
      }
      entity.setEffectiveDate(rs.getTimestamp("EFFECTIVE_DATE"));
      entity.setExpiryDate(rs.getTimestamp("EXPIRY_DATE"));
      entity.setOriginalContent(rs.getString("ORIGINAL_CONTENT"));
      entity.setReplacementContent(rs.getString("REPLACEMENT_CONTENT"));
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
  
  public java.lang.Long create(TSgDocStaticContentConfig entity) throws GenericException{
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
if ( entity.getStaticContentId() == null || entity.getStaticContentId().longValue()<=0 ) {
      entity.setStaticContentId(OracleSequencePKGenerator.getInstance().getNextPKValue("S_SG_DOC_STATIC_CONTENT_CONFIG"));
}
      DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into T_SG_DOC_STATIC_CONTENT_CONFIG(");
	buf.append("STATIC_CONTENT_ID");
	buf.append(",TEMPLATE_ID");
	buf.append(",TEMPLATE_ATTRIBUTE_ID");
	buf.append(",EFFECTIVE_DATE");
	buf.append(",EXPIRY_DATE");
	buf.append(",ORIGINAL_CONTENT");
	buf.append(",REPLACEMENT_CONTENT");
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
	Log.debug(TSgDocStaticContentConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getStaticContentId() != null) ps.setLong(pos++, entity.getStaticContentId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgDocStaticContentConfigDao.class, "staticContentId:" + entity.getStaticContentId());
	  if(entity.getTemplateId() != null) ps.setLong(pos++, entity.getTemplateId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgDocStaticContentConfigDao.class, "templateId:" + entity.getTemplateId());
	  if(entity.getTemplateAttributeId() != null) ps.setLong(pos++, entity.getTemplateAttributeId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgDocStaticContentConfigDao.class, "templateAttributeId:" + entity.getTemplateAttributeId());
	  ps.setTimestamp(pos++, entity.getEffectiveDate() != null ? new java.sql.Timestamp(entity.getEffectiveDate().getTime()) : null);
	  Log.debug(TSgDocStaticContentConfigDao.class, "effectiveDate:" + entity.getEffectiveDate());
	  ps.setTimestamp(pos++, entity.getExpiryDate() != null ? new java.sql.Timestamp(entity.getExpiryDate().getTime()) : null);
	  Log.debug(TSgDocStaticContentConfigDao.class, "expiryDate:" + entity.getExpiryDate());
	  ps.setString(pos++, entity.getOriginalContent());
	  Log.debug(TSgDocStaticContentConfigDao.class, "originalContent:" + entity.getOriginalContent());
	  ps.setString(pos++, entity.getReplacementContent());
	  Log.debug(TSgDocStaticContentConfigDao.class, "replacementContent:" + entity.getReplacementContent());
	  ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  Log.debug(TSgDocStaticContentConfigDao.class, "insertTime:" + entity.getInsertTime());
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  Log.debug(TSgDocStaticContentConfigDao.class, "updateTime:" + entity.getUpdateTime());
	  if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgDocStaticContentConfigDao.class, "insertedBy:" + entity.getInsertedBy());
	  if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgDocStaticContentConfigDao.class, "updatedBy:" + entity.getUpdatedBy());
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}
    return entity.getStaticContentId();
  }
  
  public void update(TSgDocStaticContentConfig entity) throws GenericException{
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
	buf.append("update T_SG_DOC_STATIC_CONTENT_CONFIG set ");
	buf.append("STATIC_CONTENT_ID=?");
	buf.append(",TEMPLATE_ID=?");
	buf.append(",TEMPLATE_ATTRIBUTE_ID=?");
	buf.append(",EFFECTIVE_DATE=?");
	buf.append(",EXPIRY_DATE=?");
	buf.append(",ORIGINAL_CONTENT=?");
	buf.append(",REPLACEMENT_CONTENT=?");
	buf.append(",INSERT_TIME=?");
	buf.append(",UPDATE_TIME=?");
	buf.append(",INSERTED_BY=?");
	buf.append(",UPDATED_BY=?");
	buf.append(" where 1 = 1");
	buf.append("   and STATIC_CONTENT_ID = ?");
	Log.debug(TSgDocStaticContentConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getStaticContentId() != null) ps.setLong(pos++, entity.getStaticContentId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getTemplateId() != null) ps.setLong(pos++, entity.getTemplateId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getTemplateAttributeId() != null) ps.setLong(pos++, entity.getTemplateAttributeId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setTimestamp(pos++, entity.getEffectiveDate() != null ? new java.sql.Timestamp(entity.getEffectiveDate().getTime()) : null);
	  ps.setTimestamp(pos++, entity.getExpiryDate() != null ? new java.sql.Timestamp(entity.getExpiryDate().getTime()) : null);
	  ps.setString(pos++, entity.getOriginalContent());
	  ps.setString(pos++, entity.getReplacementContent());
	  ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getStaticContentId() != null) ps.setLong(pos++, entity.getStaticContentId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public void remove( java.lang.Long staticContentId ) throws GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       TSgDocStaticContentConfig entity = null;
       try {
          Session session = HibernateUtil.currentSession();
          entity = this.load( staticContentId );
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
	buf.append("delete from T_SG_DOC_STATIC_CONTENT_CONFIG");
	buf.append(" where 1 = 1");
	buf.append("   and STATIC_CONTENT_ID = ?");
	Log.debug(TSgDocStaticContentConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(staticContentId != null) ps.setLong(pos++, staticContentId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public TSgDocStaticContentConfig load( java.lang.Long staticContentId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
          if(staticContentId==null) {
	    return null;
	  }
          Serializable sId = staticContentId;
	  o = session.load(TSgDocStaticContentConfig.class,sId);
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
       return (TSgDocStaticContentConfig)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from T_SG_DOC_STATIC_CONTENT_CONFIG ");
	buf.append(" where 1=1 ");
	buf.append("   and STATIC_CONTENT_ID = ?");
	Log.debug(TSgDocStaticContentConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(staticContentId != null) ps.setLong(pos++, staticContentId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
      TSgDocStaticContentConfig entity = null;
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
			selectQuery.append("SELECT max(STATIC_CONTENT_ID) AS SERIAL_ID FROM T_SG_DOC_STATIC_CONTENT_CONFIG");
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


  
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}
