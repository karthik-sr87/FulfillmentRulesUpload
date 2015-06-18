package com.ebao.aig.sg.fulfillment.rules.upload.staging.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebao.aig.sg.fulfillment.rules.upload.staging.data.vo.StgCampaignMappingConfig;
import com.ebao.pub.framework.GenericException;
///////////////ManualImportBegin///////////////
///////////////ManualImportEnd///////////////

public interface StgCampaignMappingConfigDao {
  public java.lang.Long create(StgCampaignMappingConfig entity) throws GenericException;
  
  public void update(StgCampaignMappingConfig entity) throws GenericException;
  
  public void remove( java.lang.Long campaignRuleId ) throws GenericException;
  
  public StgCampaignMappingConfig load( java.lang.Long campaignRuleId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public StgCampaignMappingConfig fillEntity(ResultSet rs) throws SQLException;
  
///////////////ManualMethodBegin///////////////
///////////////ManualMethodEnd///////////////
}