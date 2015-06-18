package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgDocMappingConfig;
import com.ebao.pub.framework.GenericException;

///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface TSgDocMappingConfigDao {
  public java.lang.Long create(TSgDocMappingConfig entity) throws GenericException;
  
  public void update(TSgDocMappingConfig entity) throws GenericException;
  
  public void remove( java.lang.Long docRuleId ) throws GenericException;
  
  public TSgDocMappingConfig load( java.lang.Long docRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public TSgDocMappingConfig fillEntity(ResultSet rs) throws SQLException;

/*Collection findByActionId(String condition, List sqlParams) throws Exception;*/

public Collection<TSgDocMappingConfig> getDocuList(Long formruleid) throws ClassNotFoundException, SQLException;

public Collection<TSgDocMappingConfig> getDocuCoverList(Long ruleId,Long cTRuleId) throws ClassNotFoundException, SQLException;

public Collection<TSgDocMappingConfig> getPlatformDocuList(Long ruleId,
		Long platformRuleId) throws ClassNotFoundException, SQLException;

public TSgDocMappingConfig loadByCampaignRuleId(Long campaignRuleId);

public void removeByCampaignRuleId(Long campaignRuleId);


///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}