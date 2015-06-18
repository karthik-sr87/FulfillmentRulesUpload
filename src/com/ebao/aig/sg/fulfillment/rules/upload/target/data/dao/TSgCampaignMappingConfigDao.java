package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgCampaignMappingConfig;
import com.ebao.pub.framework.GenericException;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface TSgCampaignMappingConfigDao {
  public java.lang.Long create(TSgCampaignMappingConfig entity) throws GenericException;
  
  public void update(TSgCampaignMappingConfig entity) throws GenericException;
  
  public void remove( java.lang.Long campaignRuleId ) throws GenericException;
  
  public TSgCampaignMappingConfig load( java.lang.Long campaignRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public TSgCampaignMappingConfig fillEntity(ResultSet rs) throws SQLException;


///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}