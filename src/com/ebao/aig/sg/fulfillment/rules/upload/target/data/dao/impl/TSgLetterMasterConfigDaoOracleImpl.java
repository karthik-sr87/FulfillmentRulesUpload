
package  com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgLetterMasterConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgLetterMasterConfig;
import com.ebao.foundation.common.config.Env;
import com.ebao.gs.pub.util.HibernateUtil;
import com.ebao.pub.framework.AppContext;
import com.ebao.pub.framework.ExceptionFactory;
import com.ebao.pub.framework.GenericException;
import com.ebao.pub.framework.data.internal.OracleSequencePKGenerator;
import com.ebao.pub.util.DBean;
import com.ebao.pub.util.Log;


public class TSgLetterMasterConfigDaoOracleImpl implements TSgLetterMasterConfigDao{
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
      table = "T_SG_LETTER_MASTER_CONFIG";
      columns.put("letterId", "LETTER_ID");
      columnTypes.put("letterId", "java.lang.Long");
      columns.put("letterCode", "LETTER_CODE");
      columnTypes.put("letterCode", "java.lang.String");
      columns.put("letterName", "LETTER_NAME");
      columnTypes.put("letterName", "java.lang.String");
      columns.put("templateId", "TEMPLATE_ID");
      columnTypes.put("templateId", "java.lang.Long");
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
  
  public TSgLetterMasterConfig fillEntity(ResultSet rs) throws SQLException {
      TSgLetterMasterConfig entity = new TSgLetterMasterConfig();
      entity.setLetterId(new Long(rs.getLong("LETTER_ID")));
      if (rs.wasNull()) {
          entity.setLetterId(null);
      }
      entity.setLetterCode(rs.getString("LETTER_CODE"));
      entity.setLetterName(rs.getString("LETTER_NAME"));
      entity.setTemplateId(new Long(rs.getLong("TEMPLATE_ID")));
      if (rs.wasNull()) {
          entity.setTemplateId(null);
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
  
  public java.lang.Long create(TSgLetterMasterConfig entity) throws GenericException{
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
if ( entity.getLetterId() == null || entity.getLetterId().longValue()<=0 ) {
      entity.setLetterId(OracleSequencePKGenerator.getInstance().getNextPKValue("S_SG_LETTER_MASTER_CONFIG__LET"));
}
      DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into T_SG_LETTER_MASTER_CONFIG(");
	buf.append("LETTER_ID");
	buf.append(",LETTER_CODE");
	buf.append(",LETTER_NAME");
	buf.append(",TEMPLATE_ID");
	buf.append(",INSERT_TIME");
	buf.append(",UPDATE_TIME");
	buf.append(",INSERTED_BY");
	buf.append(",UPDATED_BY");
	buf.append(")");
	buf.append(" values(");
    for (int i=0; i<8; i++) {
	  buf.append(i==0 ? "?" : ",?");
	}
	buf.append(")");
	Log.debug(TSgLetterMasterConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getLetterId() != null) ps.setLong(pos++, entity.getLetterId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgLetterMasterConfigDao.class, "letterId:" + entity.getLetterId());
	  ps.setString(pos++, entity.getLetterCode());
	  Log.debug(TSgLetterMasterConfigDao.class, "letterCode:" + entity.getLetterCode());
	  ps.setString(pos++, entity.getLetterName());
	  Log.debug(TSgLetterMasterConfigDao.class, "letterName:" + entity.getLetterName());
	  if(entity.getTemplateId() != null) ps.setLong(pos++, entity.getTemplateId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgLetterMasterConfigDao.class, "templateId:" + entity.getTemplateId());
	  ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  Log.debug(TSgLetterMasterConfigDao.class, "insertTime:" + entity.getInsertTime());
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  Log.debug(TSgLetterMasterConfigDao.class, "updateTime:" + entity.getUpdateTime());
	  //if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if (entity.getInsertedBy() != null)
	         ps.setLong(pos++, entity.getInsertedBy().longValue());
	       else
	         ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  Log.debug(TSgLetterMasterConfigDao.class, "insertedBy:" + entity.getInsertedBy());
	  //if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if (entity.getUpdatedBy() != null)
          ps.setLong(pos++, entity.getUpdatedBy().longValue());
        else
          ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  Log.debug(TSgLetterMasterConfigDao.class, "updatedBy:" + entity.getUpdatedBy());
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}
    return entity.getLetterId();
  }
  
  public void update(TSgLetterMasterConfig entity) throws GenericException{
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
	buf.append("update T_SG_LETTER_MASTER_CONFIG set ");
	buf.append("LETTER_ID=?");
	buf.append(",LETTER_CODE=?");
	buf.append(",LETTER_NAME=?");
	buf.append(",TEMPLATE_ID=?");
	//buf.append(",INSERT_TIME=?");
	buf.append(",UPDATE_TIME=?");
	//buf.append(",INSERTED_BY=?");
	buf.append(",UPDATED_BY=?");
	buf.append(" where 1 = 1");
	buf.append("   and LETTER_ID = ?");
	Log.debug(TSgLetterMasterConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getLetterId() != null) ps.setLong(pos++, entity.getLetterId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setString(pos++, entity.getLetterCode());
	  ps.setString(pos++, entity.getLetterName());
	  if(entity.getTemplateId() != null) ps.setLong(pos++, entity.getTemplateId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  //ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  //if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  //if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  if(entity.getLetterId() != null) ps.setLong(pos++, entity.getLetterId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public void remove( java.lang.Long letterId ) throws GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       TSgLetterMasterConfig entity = null;
       try {
          Session session = HibernateUtil.currentSession();
          entity = this.load( letterId );
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
	buf.append("delete from T_SG_LETTER_MASTER_CONFIG");
	buf.append(" where 1 = 1");
	buf.append("   and LETTER_ID = ?");
	Log.debug(TSgLetterMasterConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(letterId != null) ps.setLong(pos++, letterId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public TSgLetterMasterConfig load( java.lang.Long letterId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
          if(letterId==null) {
	    return null;
	  }
          Serializable sId = letterId;
	  o = session.load(TSgLetterMasterConfig.class,sId);
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
       return (TSgLetterMasterConfig)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from T_SG_LETTER_MASTER_CONFIG ");
	buf.append(" where 1=1 ");
	buf.append("   and LETTER_ID = ?");
	Log.debug(TSgLetterMasterConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(letterId != null) ps.setLong(pos++, letterId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
      TSgLetterMasterConfig entity = null;
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


	public int getSequenceID() throws SQLException, ClassNotFoundException {
		DBean db = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int serialId = 0;
		try {
			StringBuffer selectQuery = new StringBuffer();
			selectQuery
					.append("SELECT max(LETTER_ID) AS SERIAL_ID FROM T_SG_LETTER_MASTER_CONFIG");
			db = new DBean(false);
			db.connect();
			Connection con = db.getConnection();
			ps = con.prepareStatement(selectQuery.toString());
			rs = ps.executeQuery();
			while (rs.next()) {
				serialId = rs.getInt("SERIAL_ID");
				
			}
		} catch (ClassNotFoundException ex) {
			throw ex;
		} catch (SQLException sql) {
			throw sql;
		}

		finally {
			DBean.closeAll(rs, ps, db);
		}
		return serialId + 1;
	}
}
