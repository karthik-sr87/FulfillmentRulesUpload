

package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao.StgProducerSpecificConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgProducerSpecificConfig;
import com.ebao.foundation.common.config.Env;
import com.ebao.gs.pub.util.HibernateUtil;
import com.ebao.pub.framework.ExceptionFactory;
import com.ebao.pub.framework.GenericException;
import com.ebao.pub.framework.data.internal.OracleSequencePKGenerator;
import com.ebao.pub.util.DBean;
import com.ebao.pub.util.Log;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public class StgProducerSpecificConfigDaoOracleImpl implements StgProducerSpecificConfigDao{
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
      table = "STG_PRODUCER_SPECIFIC_CONFIG";
      columns.put("ruleId", "RULE_ID");
      columnTypes.put("ruleId", "java.lang.Long");
      columns.put("producerRuleId", "PRODUCER_RULE_ID");
      columnTypes.put("producerRuleId", "java.lang.Long");
      columns.put("producerType", "PRODUCER_TYPE");
      columnTypes.put("producerType", "java.lang.String");
      columns.put("producerCodeFrom", "PRODUCER_CODE_FROM");
      columnTypes.put("producerCodeFrom", "java.lang.String");
      columns.put("producerCodeTo", "PRODUCER_CODE_TO");
      columnTypes.put("producerCodeTo", "java.lang.String");
      columns.put("producersExcluded", "PRODUCERS_EXCLUDED");
      columnTypes.put("producersExcluded", "java.lang.String");
      columns.put("letterId", "LETTER_ID");
      columnTypes.put("letterId", "java.lang.String");
      columns.put("description", "DESCRIPTION");
      columnTypes.put("description", "java.lang.String");
  }

  protected Object fillObject(ResultSet rs) throws SQLException {
    return fillEntity(rs);
  }
  
  public StgProducerSpecificConfig fillEntity(ResultSet rs) throws SQLException {
      StgProducerSpecificConfig entity = new StgProducerSpecificConfig();
      entity.setRuleId(new Long(rs.getLong("RULE_ID")));
      if (rs.wasNull()) {
          entity.setRuleId(null);
      }
      entity.setProducerRuleId(new Long(rs.getLong("PRODUCER_RULE_ID")));
      if (rs.wasNull()) {
          entity.setProducerRuleId(null);
      }
      entity.setProducerType(rs.getString("PRODUCER_TYPE"));
      entity.setProducerCodeFrom(rs.getString("PRODUCER_CODE_FROM"));
      entity.setProducerCodeTo(rs.getString("PRODUCER_CODE_TO"));
      entity.setProducersExcluded(rs.getString("PRODUCERS_EXCLUDED"));
      entity.setLetterId(rs.getString("LETTER_ID"));
      entity.setDescription(rs.getString("DESCRIPTION"));
      return entity;
  }
  
  public java.lang.Long create(StgProducerSpecificConfig entity) throws GenericException{
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
if ( entity.getProducerRuleId() == null || entity.getProducerRuleId().longValue()<=0 ) {
      entity.setProducerRuleId(OracleSequencePKGenerator.getInstance().getNextPKValue("STG_PRODUCER_SPECIFIC_CONF__ID"));
}
      DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into STG_PRODUCER_SPECIFIC_CONFIG(");
	buf.append("RULE_ID");
	buf.append(",PRODUCER_RULE_ID");
	buf.append(",PRODUCER_TYPE");
	buf.append(",PRODUCER_CODE_FROM");
	buf.append(",PRODUCER_CODE_TO");
	buf.append(",PRODUCERS_EXCLUDED");
	buf.append(",LETTER_ID");
	buf.append(",DESCRIPTION");
	buf.append(")");
	buf.append(" values(");
    for (int i=0; i<8; i++) {
	  buf.append(i==0 ? "?" : ",?");
	}
	buf.append(")");
	Log.debug(StgProducerSpecificConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgProducerSpecificConfigDao.class, "ruleId:" + entity.getRuleId());
	  if(entity.getProducerRuleId() != null) ps.setLong(pos++, entity.getProducerRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(StgProducerSpecificConfigDao.class, "producerRuleId:" + entity.getProducerRuleId());
	  ps.setString(pos++, entity.getProducerType());
	  Log.debug(StgProducerSpecificConfigDao.class, "producerType:" + entity.getProducerType());
	  ps.setString(pos++, entity.getProducerCodeFrom());
	  Log.debug(StgProducerSpecificConfigDao.class, "producerCodeFrom:" + entity.getProducerCodeFrom());
	  ps.setString(pos++, entity.getProducerCodeTo());
	  Log.debug(StgProducerSpecificConfigDao.class, "producerCodeTo:" + entity.getProducerCodeTo());
	  ps.setString(pos++, entity.getProducersExcluded());
	  Log.debug(StgProducerSpecificConfigDao.class, "producersExcluded:" + entity.getProducersExcluded());
	  ps.setString(pos++, entity.getLetterId());
	  Log.debug(StgProducerSpecificConfigDao.class, "letterId:" + entity.getLetterId());
	  ps.setString(pos++, entity.getDescription());
	  Log.debug(StgProducerSpecificConfigDao.class, "description:" + entity.getDescription());
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}
    return entity.getProducerRuleId();
  }
  
  public void update(StgProducerSpecificConfig entity) throws GenericException{
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
	buf.append("update STG_PRODUCER_SPECIFIC_CONFIG set ");
	buf.append("RULE_ID=?");
	buf.append(",PRODUCER_RULE_ID=?");
	buf.append(",PRODUCER_TYPE=?");
	buf.append(",PRODUCER_CODE_FROM=?");
	buf.append(",PRODUCER_CODE_TO=?");
	buf.append(",PRODUCERS_EXCLUDED=?");
	buf.append(",LETTER_ID=?");
	buf.append(",DESCRIPTION=?");
	buf.append(" where 1 = 1");
	buf.append("   and PRODUCER_RULE_ID = ?");
	Log.debug(StgProducerSpecificConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getProducerRuleId() != null) ps.setLong(pos++, entity.getProducerRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setString(pos++, entity.getProducerType());
	  ps.setString(pos++, entity.getProducerCodeFrom());
	  ps.setString(pos++, entity.getProducerCodeTo());
	  ps.setString(pos++, entity.getProducersExcluded());
	  ps.setString(pos++, entity.getLetterId());
	  ps.setString(pos++, entity.getDescription());
	  if(entity.getProducerRuleId() != null) ps.setLong(pos++, entity.getProducerRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public void remove( java.lang.Long producerRuleId ) throws GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       StgProducerSpecificConfig entity = null;
       try {
          Session session = HibernateUtil.currentSession();
          entity = this.load( producerRuleId );
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
	buf.append("delete from STG_PRODUCER_SPECIFIC_CONFIG");
	buf.append(" where 1 = 1");
	buf.append("   and PRODUCER_RULE_ID = ?");
	Log.debug(StgProducerSpecificConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(producerRuleId != null) ps.setLong(pos++, producerRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public StgProducerSpecificConfig load( java.lang.Long producerRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
          if(producerRuleId==null) {
	    return null;
	  }
          Serializable sId = producerRuleId;
	  o = session.load(StgProducerSpecificConfig.class,sId);
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
       return (StgProducerSpecificConfig)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from STG_PRODUCER_SPECIFIC_CONFIG ");
	buf.append(" where 1=1 ");
	buf.append("   and PRODUCER_RULE_ID = ?");
	Log.debug(StgProducerSpecificConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(producerRuleId != null) ps.setLong(pos++, producerRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
      StgProducerSpecificConfig entity = null;
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
