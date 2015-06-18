package com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgInsertMappingConfig;
import com.ebao.pub.framework.GenericException;


public interface TSgInsertMappingConfigDao {
  public java.lang.Long create(TSgInsertMappingConfig entity) throws GenericException;
  
  public void update(TSgInsertMappingConfig entity) throws GenericException;
  
  public void remove( java.lang.Long listId ) throws GenericException;
  
  public TSgInsertMappingConfig load( java.lang.Long listId ) throws com.ebao.pub.framework.ObjectNotFoundException,GenericException;
  
  public TSgInsertMappingConfig fillEntity(ResultSet rs) throws SQLException;

public Collection<TSgInsertMappingConfig> getInsertNameList(Long offlineRuleId)throws Exception;

public Collection<TSgInsertMappingConfig> getvoucherResultList(Long voucherruleId) throws Exception;

public void removeByVoucherRuleId(Long voucherRuleId) throws Exception;

public TSgInsertMappingConfig loadByCampaignRuleId(Long campaignRuleId);

public void removeByCampaignRuleId(Long campaignRuleId);
  
}