

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

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgDocMappingConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgDocMappingConfig;
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

public class TSgDocMappingConfigDaoOracleImpl implements TSgDocMappingConfigDao{
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
      table = "T_SG_DOC_MAPPING_CONFIG";
      columns.put("docRuleId", "DOC_RULE_ID");
      columnTypes.put("docRuleId", "java.lang.Long");
      columns.put("ruleId", "RULE_ID");
      columnTypes.put("ruleId", "java.lang.Long");
      columns.put("coverTypeRuleId", "COVER_TYPE_RULE_ID");
      columnTypes.put("coverTypeRuleId", "java.lang.Long");
      columns.put("platformRuleId", "PLATFORM_RULE_ID");
      columnTypes.put("platformRuleId", "java.lang.Long");
      columns.put("campaignRuleId", "CAMPAIGN_RULE_ID");
      columnTypes.put("campaignRuleId", "java.lang.Long");
      columns.put("templateId", "TEMPLATE_ID");
      columnTypes.put("templateId", "java.lang.Long");
      columns.put("sequenceNo", "SEQUENCE_NO");
      columnTypes.put("sequenceNo", "java.lang.Integer");
      columns.put("documentClubType", "DOCUMENT_CLUB_TYPE");
      columnTypes.put("documentClubType", "java.lang.Integer");
      columns.put("recipient", "RECIPIENT");
      columnTypes.put("recipient", "java.lang.Integer");
      columns.put("marketingLetter", "MARKETING_LETTER");
      columnTypes.put("marketingLetter", "java.lang.Long");
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
  
  public TSgDocMappingConfig fillEntity(ResultSet rs) throws SQLException {
      TSgDocMappingConfig entity = new TSgDocMappingConfig();
      entity.setDocRuleId(new Long(rs.getLong("DOC_RULE_ID")));
      if (rs.wasNull()) {
          entity.setDocRuleId(null);
      }
      entity.setRuleId(new Long(rs.getLong("RULE_ID")));
      if (rs.wasNull()) {
          entity.setRuleId(null);
      }
      entity.setCoverTypeRuleId(new Long(rs.getLong("COVER_TYPE_RULE_ID")));
      if (rs.wasNull()) {
          entity.setCoverTypeRuleId(null);
      }
      entity.setPlatformRuleId(new Long(rs.getLong("PLATFORM_RULE_ID")));
      if (rs.wasNull()) {
          entity.setPlatformRuleId(null);
      }
      entity.setCampaignRuleId(new Long(rs.getLong("CAMPAIGN_RULE_ID")));
      if (rs.wasNull()) {
          entity.setCampaignRuleId(null);
      }
      entity.setTemplateId(new Long(rs.getLong("TEMPLATE_ID")));
      if (rs.wasNull()) {
          entity.setTemplateId(null);
      }
      entity.setSequenceNo(new Integer(rs.getInt("SEQUENCE_NO")));
      if (rs.wasNull()) {
          entity.setSequenceNo(null);
      }
      entity.setDocumentClubType(new Integer(rs.getInt("DOCUMENT_CLUB_TYPE")));
      if (rs.wasNull()) {
          entity.setDocumentClubType(null);
      }
      entity.setRecipient(new Integer(rs.getInt("RECIPIENT")));
      if (rs.wasNull()) {
          entity.setRecipient(null);
      }
      entity.setMarketingLetter(new Long(rs.getLong("MARKETING_LETTER")));
      if (rs.wasNull()) {
          entity.setMarketingLetter(null);
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
  
  public java.lang.Long create(TSgDocMappingConfig entity) throws GenericException{
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
//if ( entity.getDocRuleId() == null || entity.getDocRuleId().longValue()<=0 ) {
      entity.setDocRuleId(OracleSequencePKGenerator.getInstance().getNextPKValue("S_SG_DOC_MAPPING_CONFIG__DOC_R"));
//}
      DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("insert into T_SG_DOC_MAPPING_CONFIG(");
	buf.append("DOC_RULE_ID");
	buf.append(",RULE_ID");
	buf.append(",COVER_TYPE_RULE_ID");
	buf.append(",PLATFORM_RULE_ID");
	buf.append(",CAMPAIGN_RULE_ID");
	buf.append(",TEMPLATE_ID");
	buf.append(",SEQUENCE_NO");
	buf.append(",DOCUMENT_CLUB_TYPE");
	buf.append(",RECIPIENT");
	buf.append(",MARKETING_LETTER");
	buf.append(",INSERT_TIME");
	buf.append(",UPDATE_TIME");
	buf.append(",INSERTED_BY");
	buf.append(",UPDATED_BY");
	buf.append(")");
	buf.append(" values(");
    for (int i=0; i<14; i++) {
	  buf.append(i==0 ? "?" : ",?");
	}
	buf.append(")");
	Log.debug(TSgDocMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getDocRuleId() != null) ps.setLong(pos++, entity.getDocRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgDocMappingConfigDao.class, "docRuleId:" + entity.getDocRuleId());
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgDocMappingConfigDao.class, "ruleId:" + entity.getRuleId());
	  if(entity.getCoverTypeRuleId() != null) ps.setLong(pos++, entity.getCoverTypeRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgDocMappingConfigDao.class, "coverTypeRuleId:" + entity.getCoverTypeRuleId());
	  if(entity.getPlatformRuleId() != null) ps.setLong(pos++, entity.getPlatformRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgDocMappingConfigDao.class, "platformRuleId:" + entity.getPlatformRuleId());
	  if(entity.getCampaignRuleId() != null) ps.setLong(pos++, entity.getCampaignRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgDocMappingConfigDao.class, "campaignRuleId:" + entity.getCampaignRuleId());
	  if(entity.getTemplateId() != null) ps.setLong(pos++, entity.getTemplateId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgDocMappingConfigDao.class, "templateId:" + entity.getTemplateId());
	  if(entity.getSequenceNo() != null) ps.setInt(pos++, entity.getSequenceNo().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgDocMappingConfigDao.class, "sequenceNo:" + entity.getSequenceNo());
	  if(entity.getDocumentClubType() != null) ps.setInt(pos++, entity.getDocumentClubType().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgDocMappingConfigDao.class, "documentClubType:" + entity.getDocumentClubType());
	  if(entity.getRecipient() != null) ps.setInt(pos++, entity.getRecipient().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgDocMappingConfigDao.class, "recipient:" + entity.getRecipient());
	  if(entity.getMarketingLetter() != null) ps.setLong(pos++, entity.getMarketingLetter().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  Log.debug(TSgDocMappingConfigDao.class, "marketingLetter:" + entity.getMarketingLetter());
	  ps.setTimestamp(pos++, entity.getInsertTime() != null ? new java.sql.Timestamp(entity.getInsertTime().getTime()) : null);
	  Log.debug(TSgDocMappingConfigDao.class, "insertTime:" + entity.getInsertTime());
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  Log.debug(TSgDocMappingConfigDao.class, "updateTime:" + entity.getUpdateTime());
	  if(entity.getInsertedBy() != null) ps.setLong(pos++, entity.getInsertedBy().longValue()); else ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  Log.debug(TSgDocMappingConfigDao.class, "insertedBy:" + entity.getInsertedBy());
	  if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  Log.debug(TSgDocMappingConfigDao.class, "updatedBy:" + entity.getUpdatedBy());
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}
    return entity.getDocRuleId();
  }
  
  public void update(TSgDocMappingConfig entity) throws GenericException{
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
	buf.append("update T_SG_DOC_MAPPING_CONFIG set ");
	buf.append("DOC_RULE_ID=?");
	buf.append(",RULE_ID=?");
	buf.append(",COVER_TYPE_RULE_ID=?");
	buf.append(",PLATFORM_RULE_ID=?");
	buf.append(",CAMPAIGN_RULE_ID=?");
	buf.append(",TEMPLATE_ID=?");
	buf.append(",SEQUENCE_NO=?");
	buf.append(",DOCUMENT_CLUB_TYPE=?");
	buf.append(",RECIPIENT=?");
	buf.append(",MARKETING_LETTER=?");
	buf.append(",UPDATE_TIME=?");
	buf.append(",UPDATED_BY=?");
	buf.append(" where 1 = 1");
	buf.append("   and DOC_RULE_ID = ?");
	Log.debug(TSgDocMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(entity.getDocRuleId() != null) ps.setLong(pos++, entity.getDocRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getRuleId() != null) ps.setLong(pos++, entity.getRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getCoverTypeRuleId() != null) ps.setLong(pos++, entity.getCoverTypeRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getPlatformRuleId() != null) ps.setLong(pos++, entity.getPlatformRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getCampaignRuleId() != null) ps.setLong(pos++, entity.getCampaignRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getTemplateId() != null) ps.setLong(pos++, entity.getTemplateId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getSequenceNo() != null) ps.setInt(pos++, entity.getSequenceNo().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getDocumentClubType() != null) ps.setInt(pos++, entity.getDocumentClubType().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getRecipient() != null) ps.setInt(pos++, entity.getRecipient().intValue()); else ps.setNull(pos++, Types.NUMERIC);
	  if(entity.getMarketingLetter() != null) ps.setLong(pos++, entity.getMarketingLetter().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.setTimestamp(pos++, entity.getUpdateTime() != null ? new java.sql.Timestamp(entity.getUpdateTime().getTime()) : null);
	  if(entity.getUpdatedBy() != null) ps.setLong(pos++, entity.getUpdatedBy().longValue()); else ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
	  if(entity.getDocRuleId() != null) ps.setLong(pos++, entity.getDocRuleId().longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public void remove( java.lang.Long docRuleId ) throws GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       TSgDocMappingConfig entity = null;
       try {
          Session session = HibernateUtil.currentSession();
          entity = this.load( docRuleId );
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
	buf.append("delete from T_SG_DOC_MAPPING_CONFIG");
	buf.append(" where 1 = 1");
	buf.append("   and DOC_RULE_ID = ?");
	Log.debug(TSgDocMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(docRuleId != null) ps.setLong(pos++, docRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  }
  
  public TSgDocMappingConfig load( java.lang.Long docRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException{
    if("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
       Object o = null;
       try {
          Session session = HibernateUtil.currentSession();
          if(docRuleId==null) {
	    return null;
	  }
          Serializable sId = docRuleId;
	  o = session.load(TSgDocMappingConfig.class,sId);
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
       return (TSgDocMappingConfig)o;
    }
  
    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select * from T_SG_DOC_MAPPING_CONFIG ");
	buf.append(" where 1=1 ");
	buf.append("   and DOC_RULE_ID = ?");
	Log.debug(TSgDocMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(docRuleId != null) ps.setLong(pos++, docRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
      TSgDocMappingConfig entity = null;
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
public Collection<TSgDocMappingConfig> getDocuList(Long formruleid) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	DBean db = null;
	Collection<TSgDocMappingConfig> entity = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
   
    List docuList=new ArrayList();
	try{ 
		StringBuffer selectQuery = new StringBuffer();
		selectQuery.append("select DOC_RULE_ID,TEMPLATE_ID,SEQUENCE_NO,DOCUMENT_CLUB_TYPE,RECIPIENT from T_SG_DOC_MAPPING_CONFIG ");
		selectQuery.append(" where 1=1 ");
		selectQuery.append(" and COVER_TYPE_RULE_ID is null and PLATFORM_RULE_ID is null and CAMPAIGN_RULE_ID is null ");
		selectQuery.append("   and RULE_ID = ?");
	db = new DBean(false);
	db.connect();
	Connection con = db.getConnection();
	ps = con.prepareStatement(selectQuery.toString());
	ps.setLong(1,formruleid);
    rs = ps.executeQuery();
	
	
	while (rs.next()) {
	
		TSgDocMappingConfig newObj = new TSgDocMappingConfig();
		newObj.setDocRuleId(rs.getLong("DOC_RULE_ID"));
		newObj.setTemplateId(rs.getLong("TEMPLATE_ID"));
		newObj.setSequenceNo(rs.getInt("SEQUENCE_NO"));
		newObj.setDocumentClubType(rs.getInt("DOCUMENT_CLUB_TYPE"));
		newObj.setRecipient(rs.getInt("RECIPIENT"));
		
		docuList.add(newObj);
	
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
	 return  docuList;
}
@Override
public Collection<TSgDocMappingConfig> getDocuCoverList(Long ruleId,Long cTRuleId)
		throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	DBean db = null;
	Collection<TSgDocMappingConfig> entity = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
   
    List docucoverList=new ArrayList();
	try{ 
		StringBuffer selectQuery = new StringBuffer();
		/*selectQuery.append("select * from T_SG_FULFILL_DATAELEMENT ");*/
		selectQuery.append("select DOC_RULE_ID,TEMPLATE_ID,SEQUENCE_NO,DOCUMENT_CLUB_TYPE,RECIPIENT,MARKETING_LETTER from T_SG_DOC_MAPPING_CONFIG ");
		selectQuery.append(" where 1=1 ");
		selectQuery.append("   and RULE_ID = ?");
		selectQuery.append("   and COVER_TYPE_RULE_ID = ?");
	db = new DBean(false);
	db.connect();
	Connection con = db.getConnection();
	ps = con.prepareStatement(selectQuery.toString());
	
	ps.setLong(1,ruleId);
	
	ps.setLong(2,cTRuleId);

	rs = ps.executeQuery();
	
	
	
	while (rs.next()) {
		
		TSgDocMappingConfig newObj = new TSgDocMappingConfig();
		newObj.setDocRuleId(rs.getLong("DOC_RULE_ID"));
		newObj.setTemplateId(rs.getLong("TEMPLATE_ID"));
		newObj.setSequenceNo(rs.getInt("SEQUENCE_NO"));
		newObj.setDocumentClubType(rs.getInt("DOCUMENT_CLUB_TYPE"));
		newObj.setRecipient(rs.getInt("RECIPIENT"));
		newObj.setMarketingLetter(rs.getLong("MARKETING_LETTER"));
		docucoverList.add(newObj);
		
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
	 return  docucoverList;
	//return null;
}
@Override
public Collection<TSgDocMappingConfig> getPlatformDocuList(Long ruleId,
		Long platformRuleId) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	DBean db = null;
	Collection<TSgDocMappingConfig> entity = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
   
    List PlatformDocuList=new ArrayList();
	try{ 
		StringBuffer selectQuery = new StringBuffer();
		selectQuery.append("select DOC_RULE_ID,TEMPLATE_ID,SEQUENCE_NO,DOCUMENT_CLUB_TYPE,RECIPIENT from T_SG_DOC_MAPPING_CONFIG ");
		selectQuery.append(" where 1=1 ");
		selectQuery.append("   and RULE_ID = ?");
		selectQuery.append("   and PLATFORM_RULE_ID = ?");
	db = new DBean(false);
	db.connect();
	Connection con = db.getConnection();
	ps = con.prepareStatement(selectQuery.toString());
	
	ps.setLong(1,ruleId);
	
	ps.setLong(2,platformRuleId);
	
    rs = ps.executeQuery();
	while (rs.next()) {
		
		TSgDocMappingConfig newObj = new TSgDocMappingConfig();
		newObj.setDocRuleId(rs.getLong("DOC_RULE_ID"));
		newObj.setTemplateId(rs.getLong("TEMPLATE_ID"));
		newObj.setSequenceNo(rs.getInt("SEQUENCE_NO"));
		newObj.setDocumentClubType(rs.getInt("DOCUMENT_CLUB_TYPE"));
		newObj.setRecipient(rs.getInt("RECIPIENT"));
		
		PlatformDocuList.add(newObj);
		
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
	 return  PlatformDocuList;
}
@Override
public TSgDocMappingConfig loadByCampaignRuleId(Long campaignRuleId) {
	// TODO Auto-generated method stub

    DBean db = new DBean();
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer buf = new StringBuffer();
	buf.append("select DOC_RULE_ID, TEMPLATE_ID, SEQUENCE_NO, DOCUMENT_CLUB_TYPE, RECIPIENT from T_SG_DOC_MAPPING_CONFIG ");
	buf.append(" where 1=1 ");
	buf.append("   and CAMPAIGN_RULE_ID = ?");
	Log.debug(TSgDocMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(campaignRuleId != null) ps.setLong(pos++, campaignRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  rs = ps.executeQuery();
      TSgDocMappingConfig entity = new TSgDocMappingConfig();
	  
      if(rs.next()){
    	  entity.setDocRuleId(rs.getLong("DOC_RULE_ID"));
      entity.setTemplateId(rs.getLong("TEMPLATE_ID"));
      entity.setSequenceNo(rs.getInt("SEQUENCE_NO"));
      entity.setDocumentClubType(rs.getInt("DOCUMENT_CLUB_TYPE"));
      entity.setRecipient(rs.getInt("RECIPIENT"));
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
public void removeByCampaignRuleId(Long campaignRuleId) {
	// TODO Auto-generated method stub

    
    DBean db = new DBean();
	PreparedStatement ps = null;
	StringBuffer buf = new StringBuffer();
	buf.append("delete from T_SG_DOC_MAPPING_CONFIG");
	buf.append(" where 1 = 1");
	buf.append("   and CAMPAIGN_RULE_ID = ?");
	Log.debug(TSgDocMappingConfigDao.class, buf.toString());
	try {
	  db.connect();
	  Connection con = db.getConnection();
	  ps = con.prepareStatement(buf.toString());
      int pos = 1;
	  if(campaignRuleId != null) ps.setLong(pos++, campaignRuleId.longValue()); else ps.setNull(pos++, Types.NUMERIC);
	  ps.execute();
	} catch (SQLException e) {
	  throw ExceptionFactory.parse(e);
	} catch (ClassNotFoundException e) {
	  throw ExceptionFactory.parse(e);
	} finally {
	  DBean.closeAll(null, ps, db);
	}  
  
}

  
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}
