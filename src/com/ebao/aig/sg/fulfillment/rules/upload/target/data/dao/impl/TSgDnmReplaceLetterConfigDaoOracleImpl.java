

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

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgDnmReplaceLetterConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgDnmReplaceLetterConfig;
import com.ebao.foundation.common.config.Env;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////
import com.ebao.gs.pub.util.HibernateUtil;
import com.ebao.pub.framework.ExceptionFactory;
import com.ebao.pub.framework.GenericException;
import com.ebao.pub.framework.data.internal.OracleSequencePKGenerator;
import com.ebao.pub.util.DBean;
import com.ebao.pub.util.Log;

public class TSgDnmReplaceLetterConfigDaoOracleImpl implements TSgDnmReplaceLetterConfigDao{
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
      table = "T_SG_DNM_REPLACE_LETTER_CONFIG";
      columns.put("dnmReplId", "DNM_REPL_ID");
      columnTypes.put("dnmReplId", "java.lang.Long");
      columns.put("originalLetter", "ORIGINAL_LETTER");
      columnTypes.put("originalLetter", "java.lang.Long");
      columns.put("replacementLetter", "REPLACEMENT_LETTER");
      columnTypes.put("replacementLetter", "java.lang.Long");
      columns.put("replacementEffDate", "REPLACEMENT_EFF_DATE");
      columnTypes.put("replacementEffDate", "java.util.Date");
      columns.put("replacementExpDate", "REPLACEMENT_EXP_DATE");
      columnTypes.put("replacementExpDate", "java.util.Date");
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
  
  public TSgDnmReplaceLetterConfig fillEntity(ResultSet rs) throws SQLException {
      TSgDnmReplaceLetterConfig entity = new TSgDnmReplaceLetterConfig();
      entity.setDnmReplId(new Long(rs.getLong("DNM_REPL_ID")));
      if (rs.wasNull()) {
          entity.setDnmReplId(null);
      }
      entity.setOriginalLetter(new Long(rs.getLong("ORIGINAL_LETTER")));
      if (rs.wasNull()) {
          entity.setOriginalLetter(null);
      }
      entity.setReplacementLetter(new Long(rs.getLong("REPLACEMENT_LETTER")));
      if (rs.wasNull()) {
          entity.setReplacementLetter(null);
      }
      entity.setReplacementEffDate(rs.getTimestamp("REPLACEMENT_EFF_DATE"));
      entity.setReplacementExpDate(rs.getTimestamp("REPLACEMENT_EXP_DATE"));
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
  
  public java.lang.Long create(TSgDnmReplaceLetterConfig entity) throws GenericException{
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
if ( entity.getDnmReplId() == null || entity.getDnmReplId().longValue()<=0 ) {
      entity.setDnmReplId(OracleSequencePKGenerator.getInstance().getNextPKValue("S_SG_DNM_REPLACE_LETTER_CONFIG"));
}
      DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into T_SG_DNM_REPLACE_LETTER_CONFIG(");
	buf.append("DNM_REPL_ID");
	buf.append(",ORIGINAL_LETTER");
	buf.append(",REPLACEMENT_LETTER");
	buf.append(",REPLACEMENT_EFF_DATE");
	buf.append(",REPLACEMENT_EXP_DATE");
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
	Log.debug(TSgDnmReplaceLetterConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getDnmReplId() != null) ps.setLong(pos++, entity.getDnmReplId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgDnmReplaceLetterConfigDao.class, "dnmReplId:" + entity.getDnmReplId());
	  if(entity.getOriginalLetter() != null) ps.setLong(pos++, entity.getOriginalLetter().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgDnmReplaceLetterConfigDao.class, "originalLetter:" + entity.getOriginalLetter());
	  if(entity.getReplacementLetter() != null) ps.setLong(pos++, entity.getReplacementLetter().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgDnmReplaceLetterConfigDao.class, "replacementLetter:" + entity.getReplacementLetter());
	  ps.setTimestamp(pos++, entity.getReplacementEffDate() != null ? new java.sql.Timestamp(entity.getReplacementEffDate().getTime()) : null);
	  Log.debug(TSgDnmReplaceLetterConfigDao.class, "replacementEffDate:" + entity.getReplacementEffDate());
	  ps.setTimestamp(pos++, entity.getReplacementExpDate() != null ? new java.sql.Timestamp(entity.getReplacementExpDate().getTime()) : null);
	  Log.debug(TSgDnmReplaceLetterConfigDao.class, "replacementExpDate:" + entity.getReplacementExpDate());
	  ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  Log.debug(TSgDnmReplaceLetterConfigDao.class, "insertTime:" + entity.getInsertTime());
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  Log.debug(TSgDnmReplaceLetterConfigDao.class, "updateTime:" + entity.getUpdateTime());
	  if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgDnmReplaceLetterConfigDao.class, "insertedBy:" + entity.getInsertedBy());
	  if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgDnmReplaceLetterConfigDao.class, "updatedBy:" + entity.getUpdatedBy());
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}
    return entity.getDnmReplId();
  }
  
  public void update(TSgDnmReplaceLetterConfig entity) throws GenericException{
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
	buf.append("update T_SG_DNM_REPLACE_LETTER_CONFIG set ");
	buf.append("DNM_REPL_ID=?");
	buf.append(",ORIGINAL_LETTER=?");
	buf.append(",REPLACEMENT_LETTER=?");
	buf.append(",REPLACEMENT_EFF_DATE=?");
	buf.append(",REPLACEMENT_EXP_DATE=?");
	buf.append(",INSERT_TIME=?");
	buf.append(",UPDATE_TIME=?");
	buf.append(",INSERTED_BY=?");
	buf.append(",UPDATED_BY=?");
	buf.append(" where 1 = 1");
	buf.append("   and DNM_REPL_ID = ?");
	Log.debug(TSgDnmReplaceLetterConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getDnmReplId() != null) ps.setLong(pos++, entity.getDnmReplId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getOriginalLetter() != null) ps.setLong(pos++, entity.getOriginalLetter().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getReplacementLetter() != null) ps.setLong(pos++, entity.getReplacementLetter().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setTimestamp(pos++, entity.getReplacementEffDate() != null ? new java.sql.Timestamp(entity.getReplacementEffDate().getTime()) : null);
	  ps.setTimestamp(pos++, entity.getReplacementExpDate() != null ? new java.sql.Timestamp(entity.getReplacementExpDate().getTime()) : null);
	  ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getDnmReplId() != null) ps.setLong(pos++, entity.getDnmReplId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public void remove( java.lang.Long dnmReplId ) throws GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       TSgDnmReplaceLetterConfig entity = null;
       try {
          Session session = HibernateUtil.currentSession();
          entity = this.load( dnmReplId );
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
	buf.append("delete from T_SG_DNM_REPLACE_LETTER_CONFIG");
	buf.append(" where 1 = 1");
	buf.append("   and DNM_REPL_ID = ?");
	Log.debug(TSgDnmReplaceLetterConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(dnmReplId != null) ps.setLong(pos++, dnmReplId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public TSgDnmReplaceLetterConfig load( java.lang.Long dnmReplId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
          if(dnmReplId==null) {
	    return null;
	  }
          Serializable sId = dnmReplId;
	  o = session.load(TSgDnmReplaceLetterConfig.class,sId);
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
       return (TSgDnmReplaceLetterConfig)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from T_SG_DNM_REPLACE_LETTER_CONFIG ");
	buf.append(" where 1=1 ");
	buf.append("   and DNM_REPL_ID = ?");
	Log.debug(TSgDnmReplaceLetterConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(dnmReplId != null) ps.setLong(pos++, dnmReplId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
      TSgDnmReplaceLetterConfig entity = null;
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
			selectQuery.append("SELECT max(DNM_REPL_ID) AS SERIAL_ID FROM T_SG_DNM_REPLACE_LETTER_CONFIG");
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
  
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////