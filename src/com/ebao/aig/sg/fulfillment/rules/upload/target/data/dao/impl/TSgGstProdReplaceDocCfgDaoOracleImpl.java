

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

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgGstProdReplaceDocCfgDao;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgGstProdReplaceDocCfg;
import com.ebao.foundation.common.config.Env;
import com.ebao.gs.pub.util.HibernateUtil;
import com.ebao.pub.framework.ExceptionFactory;
import com.ebao.pub.framework.GenericException;
import com.ebao.pub.framework.data.internal.OracleSequencePKGenerator;
import com.ebao.pub.util.DBean;
import com.ebao.pub.util.Log;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public class TSgGstProdReplaceDocCfgDaoOracleImpl implements TSgGstProdReplaceDocCfgDao{
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
      table = "T_SG_GST_PROD_REPLACE_DOC_CFG";
      columns.put("gstReplaceRuleId", "GST_REPLACE_RULE_ID");
      columnTypes.put("gstReplaceRuleId", "java.lang.Long");
      columns.put("originalDocId", "ORIGINAL_DOC_ID");
      columnTypes.put("originalDocId", "java.lang.Long");
      columns.put("replacementDocId", "REPLACEMENT_DOC_ID");
      columnTypes.put("replacementDocId", "java.lang.Long");
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
  
  public TSgGstProdReplaceDocCfg fillEntity(ResultSet rs) throws SQLException {
      TSgGstProdReplaceDocCfg entity = new TSgGstProdReplaceDocCfg();
      entity.setGstReplaceRuleId(new Long(rs.getLong("GST_REPLACE_RULE_ID")));
      if (rs.wasNull()) {
          entity.setGstReplaceRuleId(null);
      }
      entity.setOriginalDocId(new Long(rs.getLong("ORIGINAL_DOC_ID")));
      if (rs.wasNull()) {
          entity.setOriginalDocId(null);
      }
      entity.setReplacementDocId(new Long(rs.getLong("REPLACEMENT_DOC_ID")));
      if (rs.wasNull()) {
          entity.setReplacementDocId(null);
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
 	  
	  public int getSequenceID() throws SQLException,ClassNotFoundException 
		{
			DBean db = null;
		    PreparedStatement ps = null;
		    ResultSet rs = null;
		    int serialId = 0;
			try{ 
				StringBuffer selectQuery = new StringBuffer();
				selectQuery.append("SELECT max(GST_REPLACE_RULE_ID) AS SERIAL_ID FROM T_SG_GST_PROD_REPLACE_DOC_CFG");
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

  public java.lang.Long create(TSgGstProdReplaceDocCfg entity) throws GenericException{
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
if ( entity.getGstReplaceRuleId() == null || entity.getGstReplaceRuleId().longValue()<=0 ) {
      entity.setGstReplaceRuleId(OracleSequencePKGenerator.getInstance().getNextPKValue("S_SG_GST_PROD_REPLACE_DOC_CFG_"));
}
      DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into T_SG_GST_PROD_REPLACE_DOC_CFG(");
	buf.append("GST_REPLACE_RULE_ID");
	buf.append(",ORIGINAL_DOC_ID");
	buf.append(",REPLACEMENT_DOC_ID");
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
	Log.debug(TSgGstProdReplaceDocCfgDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getGstReplaceRuleId() != null) ps.setLong(pos++, entity.getGstReplaceRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgGstProdReplaceDocCfgDao.class, "gstReplaceRuleId:" + entity.getGstReplaceRuleId());
	  if(entity.getOriginalDocId() != null) ps.setLong(pos++, entity.getOriginalDocId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgGstProdReplaceDocCfgDao.class, "originalDocId:" + entity.getOriginalDocId());
	  if(entity.getReplacementDocId() != null) ps.setLong(pos++, entity.getReplacementDocId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgGstProdReplaceDocCfgDao.class, "replacementDocId:" + entity.getReplacementDocId());
	  ps.setTimestamp(pos++, entity.getReplacementEffDate() != null ? new java.sql.Timestamp(entity.getReplacementEffDate().getTime()) : null);
	  Log.debug(TSgGstProdReplaceDocCfgDao.class, "replacementEffDate:" + entity.getReplacementEffDate());
	  ps.setTimestamp(pos++, entity.getReplacementExpDate() != null ? new java.sql.Timestamp(entity.getReplacementExpDate().getTime()) : null);
	  Log.debug(TSgGstProdReplaceDocCfgDao.class, "replacementExpDate:" + entity.getReplacementExpDate());
	  ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  Log.debug(TSgGstProdReplaceDocCfgDao.class, "insertTime:" + entity.getInsertTime());
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  Log.debug(TSgGstProdReplaceDocCfgDao.class, "updateTime:" + entity.getUpdateTime());
	  if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgGstProdReplaceDocCfgDao.class, "insertedBy:" + entity.getInsertedBy());
	  if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgGstProdReplaceDocCfgDao.class, "updatedBy:" + entity.getUpdatedBy());
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}
    return entity.getGstReplaceRuleId();
  }
  
  public void update(TSgGstProdReplaceDocCfg entity) throws GenericException{
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
	buf.append("update T_SG_GST_PROD_REPLACE_DOC_CFG set ");
	buf.append("GST_REPLACE_RULE_ID=?");
	buf.append(",ORIGINAL_DOC_ID=?");
	buf.append(",REPLACEMENT_DOC_ID=?");
	buf.append(",REPLACEMENT_EFF_DATE=?");
	buf.append(",REPLACEMENT_EXP_DATE=?");
	buf.append(",INSERT_TIME=?");
	buf.append(",UPDATE_TIME=?");
	buf.append(",INSERTED_BY=?");
	buf.append(",UPDATED_BY=?");
	buf.append(" where 1 = 1");
	buf.append("   and GST_REPLACE_RULE_ID = ?");
	Log.debug(TSgGstProdReplaceDocCfgDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getGstReplaceRuleId() != null) ps.setLong(pos++, entity.getGstReplaceRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getOriginalDocId() != null) ps.setLong(pos++, entity.getOriginalDocId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getReplacementDocId() != null) ps.setLong(pos++, entity.getReplacementDocId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setTimestamp(pos++, entity.getReplacementEffDate() != null ? new java.sql.Timestamp(entity.getReplacementEffDate().getTime()) : null);
	  ps.setTimestamp(pos++, entity.getReplacementExpDate() != null ? new java.sql.Timestamp(entity.getReplacementExpDate().getTime()) : null);
	  ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getGstReplaceRuleId() != null) ps.setLong(pos++, entity.getGstReplaceRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public void remove( java.lang.Long gstReplaceRuleId ) throws GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       TSgGstProdReplaceDocCfg entity = null;
       try {
          Session session = HibernateUtil.currentSession();
          entity = this.load( gstReplaceRuleId );
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
	buf.append("delete from T_SG_GST_PROD_REPLACE_DOC_CFG");
	buf.append(" where 1 = 1");
	buf.append("   and GST_REPLACE_RULE_ID = ?");
	Log.debug(TSgGstProdReplaceDocCfgDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(gstReplaceRuleId != null) ps.setLong(pos++, gstReplaceRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public TSgGstProdReplaceDocCfg load( java.lang.Long gstReplaceRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
          if(gstReplaceRuleId==null) {
	    return null;
	  }
          Serializable sId = gstReplaceRuleId;
	  o = session.load(TSgGstProdReplaceDocCfg.class,sId);
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
       return (TSgGstProdReplaceDocCfg)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from T_SG_GST_PROD_REPLACE_DOC_CFG ");
	buf.append(" where 1=1 ");
	buf.append("   and GST_REPLACE_RULE_ID = ?");
	Log.debug(TSgGstProdReplaceDocCfgDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(gstReplaceRuleId != null) ps.setLong(pos++, gstReplaceRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
      TSgGstProdReplaceDocCfg entity = null;
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
