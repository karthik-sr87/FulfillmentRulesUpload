

package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.mysql.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.StgAutoProdCtDocMapCfgDao;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgAutoProdCtDocMapCfg;
import com.ebao.foundation.common.config.Env;
import com.ebao.gs.pub.util.HibernateUtil;
import com.ebao.pub.framework.ExceptionFactory;
import com.ebao.pub.framework.GenericException;
import com.ebao.pub.util.DBean;
import com.ebao.pub.util.Log;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public class StgAutoProdCtDocMapCfgDaoMysqlImpl implements StgAutoProdCtDocMapCfgDao{
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
      table = "STG_AUTO_PROD_CT_DOC_MAP_CFG";
      columns.put("autoProducerCtMapId", "AUTO_PRODUCER_CT_MAP_ID");
      columnTypes.put("autoProducerCtMapId", "java.lang.Long");
      columns.put("ruleId", "RULE_ID");
      columnTypes.put("ruleId", "java.lang.Long");
      columns.put("coverTypeRuleId", "COVER_TYPE_RULE_ID");
      columnTypes.put("coverTypeRuleId", "java.lang.Long");
      columns.put("autoRuleId", "AUTO_RULE_ID");
      columnTypes.put("autoRuleId", "java.lang.Long");
      columns.put("producerRuleId", "PRODUCER_RULE_ID");
      columnTypes.put("producerRuleId", "java.lang.Long");
  }

  protected Object fillObject(ResultSet rs) throws SQLException {
    return fillEntity(rs);
  }
  
  public StgAutoProdCtDocMapCfg fillEntity(ResultSet rs) throws SQLException {
      StgAutoProdCtDocMapCfg entity = new StgAutoProdCtDocMapCfg();
      entity.setAutoProducerCtMapId(new Long(rs.getLong("AUTO_PRODUCER_CT_MAP_ID")));
      if (rs.wasNull()) {
          entity.setAutoProducerCtMapId(null);
      }
      entity.setRuleId(new Long(rs.getLong("RULE_ID")));
      if (rs.wasNull()) {
          entity.setRuleId(null);
      }
      entity.setCoverTypeRuleId(new Long(rs.getLong("COVER_TYPE_RULE_ID")));
      if (rs.wasNull()) {
          entity.setCoverTypeRuleId(null);
      }
      entity.setAutoRuleId(new Long(rs.getLong("AUTO_RULE_ID")));
      if (rs.wasNull()) {
          entity.setAutoRuleId(null);
      }
      entity.setProducerRuleId(new Long(rs.getLong("PRODUCER_RULE_ID")));
      if (rs.wasNull()) {
          entity.setProducerRuleId(null);
      }
      return entity;
  }
  
  public java.lang.Long create(StgAutoProdCtDocMapCfg entity) throws GenericException{
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
/*      //set sequence primary key
if ( entity.getAutoProducerCtMapId() == null || entity.getAutoProducerCtMapId().longValue()<=0 ) {
      entity.setAutoProducerCtMapId(OracleSequencePKGenerator.getInstance().getNextPKValue("STG_AUTO_PROD_CT_CFG__MAP_ID"));
}*/
      DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into STG_AUTO_PROD_CT_DOC_MAP_CFG(");
	buf.append("AUTO_PRODUCER_CT_MAP_ID");
	buf.append(",RULE_ID");
	buf.append(",COVER_TYPE_RULE_ID");
	buf.append(",AUTO_RULE_ID");
	buf.append(",PRODUCER_RULE_ID");
	buf.append(")");
	buf.append(" values(");
    for (int i=0; i<5; i++) {
	  buf.append(i==0 ? "?" : ",?");
	}
	buf.append(")");
	Log.debug(StgAutoProdCtDocMapCfgDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getAutoProducerCtMapId() != null) ps.setLong(pos++, entity.getAutoProducerCtMapId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgAutoProdCtDocMapCfgDao.class, "autoProducerCtMapId:" + entity.getAutoProducerCtMapId());
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgAutoProdCtDocMapCfgDao.class, "ruleId:" + entity.getRuleId());
	  if(entity.getCoverTypeRuleId() != null) ps.setLong(pos++, entity.getCoverTypeRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgAutoProdCtDocMapCfgDao.class, "coverTypeRuleId:" + entity.getCoverTypeRuleId());
	  if(entity.getAutoRuleId() != null) ps.setLong(pos++, entity.getAutoRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgAutoProdCtDocMapCfgDao.class, "autoRuleId:" + entity.getAutoRuleId());
	  if(entity.getProducerRuleId() != null) ps.setLong(pos++, entity.getProducerRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgAutoProdCtDocMapCfgDao.class, "producerRuleId:" + entity.getProducerRuleId());
	  ps.execute();
	  rs = ps.getGeneratedKeys();
	  if(rs.next())
		  entity.setAutoProducerCtMapId(rs.getLong(1));
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(rs, ps, db);
	}
    return entity.getAutoProducerCtMapId();
  }
  
  public void update(StgAutoProdCtDocMapCfg entity) throws GenericException{
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
	buf.append("update STG_AUTO_PROD_CT_DOC_MAP_CFG set ");
	buf.append("AUTO_PRODUCER_CT_MAP_ID=?");
	buf.append(",RULE_ID=?");
	buf.append(",COVER_TYPE_RULE_ID=?");
	buf.append(",AUTO_RULE_ID=?");
	buf.append(",PRODUCER_RULE_ID=?");
	buf.append(" where 1 = 1");
	buf.append("   and AUTO_PRODUCER_CT_MAP_ID = ?");
	Log.debug(StgAutoProdCtDocMapCfgDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getAutoProducerCtMapId() != null) ps.setLong(pos++, entity.getAutoProducerCtMapId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getCoverTypeRuleId() != null) ps.setLong(pos++, entity.getCoverTypeRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getAutoRuleId() != null) ps.setLong(pos++, entity.getAutoRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getProducerRuleId() != null) ps.setLong(pos++, entity.getProducerRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getAutoProducerCtMapId() != null) ps.setLong(pos++, entity.getAutoProducerCtMapId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public void remove( java.lang.Long autoProducerCtMapId ) throws GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       StgAutoProdCtDocMapCfg entity = null;
       try {
          Session session = HibernateUtil.currentSession();
          entity = this.load( autoProducerCtMapId );
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
	buf.append("delete from STG_AUTO_PROD_CT_DOC_MAP_CFG");
	buf.append(" where 1 = 1");
	buf.append("   and AUTO_PRODUCER_CT_MAP_ID = ?");
	Log.debug(StgAutoProdCtDocMapCfgDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(autoProducerCtMapId != null) ps.setLong(pos++, autoProducerCtMapId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public StgAutoProdCtDocMapCfg load( java.lang.Long autoProducerCtMapId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
          if(autoProducerCtMapId==null) {
	    return null;
	  }
          Serializable sId = autoProducerCtMapId;
	  o = session.load(StgAutoProdCtDocMapCfg.class,sId);
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
       return (StgAutoProdCtDocMapCfg)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from STG_AUTO_PROD_CT_DOC_MAP_CFG ");
	buf.append(" where 1=1 ");
	buf.append("   and AUTO_PRODUCER_CT_MAP_ID = ?");
	Log.debug(StgAutoProdCtDocMapCfgDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(autoProducerCtMapId != null) ps.setLong(pos++, autoProducerCtMapId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
      StgAutoProdCtDocMapCfg entity = null;
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
