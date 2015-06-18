

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

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgCoverTypeSpecConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgCoverTypeSpecConfig;
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


public class TSgCoverTypeSpecConfigDaoOracleImpl implements TSgCoverTypeSpecConfigDao{
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
      table = "T_SG_COVER_TYPE_SPEC_CONFIG";
      columns.put("coverTypeRuleId", "COVER_TYPE_RULE_ID");
      columnTypes.put("coverTypeRuleId", "java.lang.Long");
      columns.put("ruleId", "RULE_ID");
      columnTypes.put("ruleId", "java.lang.Long");
      columns.put("coverTypeCode", "COVER_TYPE_CODE");
      columnTypes.put("coverTypeCode", "java.lang.String");
      columns.put("availableFlag", "AVAILABLE_FLAG");
      columnTypes.put("availableFlag", "java.lang.Integer");
      columns.put("dnmFlag", "DNM_FLAG");
      columnTypes.put("dnmFlag", "java.lang.Integer");
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
  
  public TSgCoverTypeSpecConfig fillEntity(ResultSet rs) throws SQLException {
      TSgCoverTypeSpecConfig entity = new TSgCoverTypeSpecConfig();
      entity.setCoverTypeRuleId(new Long(rs.getLong("COVER_TYPE_RULE_ID")));
      if (rs.wasNull()) {
          entity.setCoverTypeRuleId(null);
      }
      entity.setRuleId(new Long(rs.getLong("RULE_ID")));
      if (rs.wasNull()) {
          entity.setRuleId(null);
      }
      entity.setCoverTypeCode(rs.getString("COVER_TYPE_CODE"));
      entity.setAvailableFlag(new Integer(rs.getInt("AVAILABLE_FLAG")));
      if (rs.wasNull()) {
          entity.setAvailableFlag(null);
      }
      entity.setDnmFlag(new Integer(rs.getInt("DNM_FLAG")));
      if (rs.wasNull()) {
          entity.setDnmFlag(null);
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
  
  public java.lang.Long create(TSgCoverTypeSpecConfig entity) throws GenericException{
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
if ( entity.getCoverTypeRuleId() == null || entity.getCoverTypeRuleId().longValue()<=0 ) {
      entity.setCoverTypeRuleId(OracleSequencePKGenerator.getInstance().getNextPKValue("S_SG_COVER_TYPE_SPEC_CONFIG__C"));
}
      DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into T_SG_COVER_TYPE_SPEC_CONFIG(");
	buf.append("COVER_TYPE_RULE_ID");
	buf.append(",RULE_ID");
	buf.append(",COVER_TYPE_CODE");
	buf.append(",AVAILABLE_FLAG");
	buf.append(",DNM_FLAG");
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
	Log.debug(TSgCoverTypeSpecConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getCoverTypeRuleId() != null) ps.setLong(pos++, entity.getCoverTypeRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgCoverTypeSpecConfigDao.class, "coverTypeRuleId:" + entity.getCoverTypeRuleId());
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgCoverTypeSpecConfigDao.class, "ruleId:" + entity.getRuleId());
	  ps.setString(pos++, entity.getCoverTypeCode());
	  Log.debug(TSgCoverTypeSpecConfigDao.class, "coverTypeCode:" + entity.getCoverTypeCode());
	  if(entity.getAvailableFlag() != null) ps.setInt(pos++, entity.getAvailableFlag().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgCoverTypeSpecConfigDao.class, "availableFlag:" + entity.getAvailableFlag());
	  if(entity.getDnmFlag() != null) ps.setInt(pos++, entity.getDnmFlag().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgCoverTypeSpecConfigDao.class, "dnmFlag:" + entity.getDnmFlag());
	  ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  Log.debug(TSgCoverTypeSpecConfigDao.class, "insertTime:" + entity.getInsertTime());
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  Log.debug(TSgCoverTypeSpecConfigDao.class, "updateTime:" + entity.getUpdateTime());
	 /* if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);*/
	  if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  Log.debug(TSgCoverTypeSpecConfigDao.class, "insertedBy:" + entity.getInsertedBy());
	  /*if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);*/
	  if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  Log.debug(TSgCoverTypeSpecConfigDao.class, "updatedBy:" + entity.getUpdatedBy());
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}
    return entity.getCoverTypeRuleId();
  }
  
  public void update(TSgCoverTypeSpecConfig entity) throws GenericException{
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
	buf.append("update T_SG_COVER_TYPE_SPEC_CONFIG set ");
	buf.append("COVER_TYPE_RULE_ID=?");
	buf.append(",RULE_ID=?");
	buf.append(",COVER_TYPE_CODE=?");
	buf.append(",AVAILABLE_FLAG=?");
	buf.append(",DNM_FLAG=?");
	/*buf.append(",INSERT_TIME=?");*/
	buf.append(",UPDATE_TIME=?");
	/*buf.append(",INSERTED_BY=?");*/
	buf.append(",UPDATED_BY=?");
	buf.append(" where 1 = 1");
	buf.append("   and COVER_TYPE_RULE_ID = ?");
	Log.debug(TSgCoverTypeSpecConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getCoverTypeRuleId() != null) ps.setLong(pos++, entity.getCoverTypeRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setString(pos++, entity.getCoverTypeCode());
	  if(entity.getAvailableFlag() != null) ps.setInt(pos++, entity.getAvailableFlag().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getDnmFlag() != null) ps.setInt(pos++, entity.getDnmFlag().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  /*ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);*/
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  /*if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);*/
	  /*if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setLong(pos++, AppContext.getCurrentUser().getUserId());*/
	  /*if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);*/
	  if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  if(entity.getCoverTypeRuleId() != null) ps.setLong(pos++, entity.getCoverTypeRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public void remove( java.lang.Long coverTypeRuleId ) throws GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       TSgCoverTypeSpecConfig entity = null;
       try {
          Session session = HibernateUtil.currentSession();
          entity = this.load( coverTypeRuleId );
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
	buf.append("delete from T_SG_COVER_TYPE_SPEC_CONFIG");
	buf.append(" where 1 = 1");
	buf.append("   and COVER_TYPE_RULE_ID = ?");
	Log.debug(TSgCoverTypeSpecConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(coverTypeRuleId != null) ps.setLong(pos++, coverTypeRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public TSgCoverTypeSpecConfig load( java.lang.Long coverTypeRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
          if(coverTypeRuleId==null) {
	    return null;
	  }
          Serializable sId = coverTypeRuleId;
	  o = session.load(TSgCoverTypeSpecConfig.class,sId);
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
       return (TSgCoverTypeSpecConfig)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from T_SG_COVER_TYPE_SPEC_CONFIG ");
	buf.append(" where 1=1 ");
	buf.append("   and COVER_TYPE_RULE_ID = ?");
	Log.debug(TSgCoverTypeSpecConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(coverTypeRuleId != null) ps.setLong(pos++, coverTypeRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
      TSgCoverTypeSpecConfig entity = null;
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
public Long getSequenceID(Long masterRule) throws SQLException, ClassNotFoundException {
	// TODO Auto-generated method stub
	DBean db = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Long serialId = null;
                try{ 
                                StringBuffer selectQuery = new StringBuffer();
                                selectQuery.append("SELECT max(COVER_TYPE_RULE_ID) AS SERIAL_ID FROM T_SG_COVER_TYPE_SPEC_CONFIG where RULE_ID = ? ");
                db = new DBean(false);
                db.connect();
                Connection con = db.getConnection();
                //
                ps = con.prepareStatement(selectQuery.toString());
               
          	  if(masterRule != null) 
          		  ps.setLong(1, masterRule.longValue()); 
          	  else ps.setNull(1, Types.NUMERIC);
          	rs = ps.executeQuery();
                while (rs.next()) {
                                serialId = rs.getLong("SERIAL_ID");
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
                
				if(serialId==0){
                	
					serialId=(long) 100000;
                	return serialId;
				}
                else
                return serialId+1;

}
@Override
public Collection<TSgCoverTypeSpecConfig> getCoverDocuList(long masterruleId) throws ClassNotFoundException, SQLException{
	// TODO Auto-generated method stub
	DBean db = null;
	Collection<TSgCoverTypeSpecConfig> entity = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
   // int impSerialId = 0;
    //int pos=null;
    List CoverdocuList=new ArrayList();
	try{ 
		StringBuffer selectQuery = new StringBuffer();
		/*selectQuery.append("select * from T_SG_FULFILL_DATAELEMENT ");*/
		selectQuery.append("select RULE_ID,COVER_TYPE_RULE_ID,COVER_TYPE_CODE,AVAILABLE_FLAG,DNM_FLAG from T_SG_COVER_TYPE_SPEC_CONFIG ");
		selectQuery.append(" where 1=1 ");
		selectQuery.append(" and COVER_TYPE_RULE_ID is not null");
		
		selectQuery.append("   and RULE_ID = ?");
	db = new DBean(false);
	db.connect();
	Connection con = db.getConnection();
	ps = con.prepareStatement(selectQuery.toString());
	ps.setLong(1,masterruleId);
//	if(extraInsertId != null) ps.setLong(1, extraInsertId.longValue()); else ps.setNull(1, Types.NUMERIC);
	rs = ps.executeQuery();
	
	
	while (rs.next()) {
		//impSerialId = rs.getInt("SERIAL_ID");
		TSgCoverTypeSpecConfig newObj = new TSgCoverTypeSpecConfig();
		newObj.setRuleId(rs.getLong("RULE_ID"));
  	  newObj.setCoverTypeRuleId(rs.getLong("COVER_TYPE_RULE_ID"));
  	  newObj.setCoverTypeCode(rs.getString("COVER_TYPE_CODE"));
  	  newObj.setAvailableFlag(rs.getInt("AVAILABLE_FLAG"));
  	  newObj.setDnmFlag(rs.getInt("DNM_FLAG"));
		CoverdocuList.add(newObj);
		
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
	 return  CoverdocuList;

	
}
  
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}
