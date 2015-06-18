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

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgAutoSpecConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgAutoSpecConfig;
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

public class TSgAutoSpecConfigDaoOracleImpl implements TSgAutoSpecConfigDao {
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
		table = "T_SG_AUTO_SPEC_CONFIG";
		columns.put("ruleId", "RULE_ID");
		columnTypes.put("ruleId", "java.lang.Long");
		columns.put("autoRuleId", "AUTO_RULE_ID");
		columnTypes.put("autoRuleId", "java.lang.Long");
		columns.put("vehicleAgeFrom", "VEHICLE_AGE_FROM");
		columnTypes.put("vehicleAgeFrom", "java.lang.Integer");
		columns.put("vehicleAgeTo", "VEHICLE_AGE_TO");
		columnTypes.put("vehicleAgeTo", "java.lang.Integer");
		columns.put("ncdFrom", "NCD_FROM");
		columnTypes.put("ncdFrom", "java.lang.Integer");
		columns.put("ncdTo", "NCD_TO");
		columnTypes.put("ncdTo", "java.lang.Integer");
		columns.put("premiumFrom", "PREMIUM_FROM");
		columnTypes.put("premiumFrom", "java.math.BigDecimal");
		columns.put("premiumTo", "PREMIUM_TO");
		columnTypes.put("premiumTo", "java.math.BigDecimal");
		columns.put("vehicleType", "VEHICLE_TYPE");
		columnTypes.put("vehicleType", "java.lang.Integer");
		columns.put("bubbleBoxLetter", "BUBBLE_BOX_LETTER");
		columnTypes.put("bubbleBoxLetter", "java.lang.Long");
		columns.put("imprtNoticeFlag", "IMPRT_NOTICE_FLAG");
		columnTypes.put("imprtNoticeFlag", "java.lang.Integer");
		columns.put("insertTime", "INSERT_TIME");
		columnTypes.put("insertTime", "java.util.Date");
		columns.put("updateTime", "UPDATE_TIME");
		columnTypes.put("updateTime", "java.util.Date");
		columns.put("insertedBy", "INSERTED_BY");
		columnTypes.put("insertedBy", "java.lang.Long");
		columns.put("updatedBy", "UPDATED_BY");
		columnTypes.put("updatedBy", "java.lang.Long");
		columns.put("autoRuleDescription", "AUTO_RULE_DESCRIPTION");
		columnTypes.put("autoRuleDescription", "java.lang.String");
	}

	protected Object fillObject(ResultSet rs) throws SQLException {
		return fillEntity(rs);
	}

	public TSgAutoSpecConfig fillEntity(ResultSet rs) throws SQLException {
		TSgAutoSpecConfig entity = new TSgAutoSpecConfig();
		entity.setRuleId(new Long(rs.getLong("RULE_ID")));
		if (rs.wasNull()) {
			entity.setRuleId(null);
		}
		entity.setAutoRuleId(new Long(rs.getLong("AUTO_RULE_ID")));
		if (rs.wasNull()) {
			entity.setAutoRuleId(null);
		}
		entity.setVehicleAgeFrom(new Integer(rs.getInt("VEHICLE_AGE_FROM")));
		if (rs.wasNull()) {
			entity.setVehicleAgeFrom(null);
		}
		entity.setVehicleAgeTo(new Integer(rs.getInt("VEHICLE_AGE_TO")));
		if (rs.wasNull()) {
			entity.setVehicleAgeTo(null);
		}
		entity.setNcdFrom(new Integer(rs.getInt("NCD_FROM")));
		if (rs.wasNull()) {
			entity.setNcdFrom(null);
		}
		entity.setNcdTo(new Integer(rs.getInt("NCD_TO")));
		if (rs.wasNull()) {
			entity.setNcdTo(null);
		}
		entity.setPremiumFrom(rs.getBigDecimal("PREMIUM_FROM"));
		entity.setPremiumTo(rs.getBigDecimal("PREMIUM_TO"));
		entity.setVehicleType(new Integer(rs.getInt("VEHICLE_TYPE")));
		if (rs.wasNull()) {
			entity.setVehicleType(null);
		}
		entity.setBubbleBoxLetter(new Long(rs.getLong("BUBBLE_BOX_LETTER")));
		if (rs.wasNull()) {
			entity.setBubbleBoxLetter(null);
		}
		entity.setImprtNoticeFlag(new Integer(rs.getInt("IMPRT_NOTICE_FLAG")));
		if (rs.wasNull()) {
			entity.setImprtNoticeFlag(null);
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
		entity.setAutoRuleDescription(rs.getString("AUTO_RULE_DESCRIPTION"));
		return entity;
	}

	public java.lang.Long create(TSgAutoSpecConfig entity)
			throws GenericException {
		if ("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
			java.lang.Long id;
			try {
				Session session = HibernateUtil.currentSession();
				Serializable key = session.save(entity);
				session.flush();
				id = new java.lang.Long(key.toString());
			} catch (HibernateException e) {
				throw ExceptionFactory.parse(e);
			} finally {
				try {
					HibernateUtil.closeSession();
				} catch (HibernateException e) {
					throw ExceptionFactory.parse(e);
				}
			}
			return id;
		}
		// set sequence primary key
		if (entity.getAutoRuleId() == null
				|| entity.getAutoRuleId().longValue() <= 0) {
			entity.setAutoRuleId(OracleSequencePKGenerator.getInstance()
					.getNextPKValue("S_SG_AUTO_SPEC_CONFIG__AUTO_RU"));
		}
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer buf = new StringBuffer();
		buf.append("insert into T_SG_AUTO_SPEC_CONFIG(");
		buf.append("RULE_ID");
		buf.append(",AUTO_RULE_ID");
		buf.append(",VEHICLE_AGE_FROM");
		buf.append(",VEHICLE_AGE_TO");
		buf.append(",NCD_FROM");
		buf.append(",NCD_TO");
		buf.append(",PREMIUM_FROM");
		buf.append(",PREMIUM_TO");
		buf.append(",VEHICLE_TYPE");
		buf.append(",BUBBLE_BOX_LETTER");
		buf.append(",IMPRT_NOTICE_FLAG");
		buf.append(",INSERT_TIME");
		buf.append(",UPDATE_TIME");
		buf.append(",INSERTED_BY");
		buf.append(",UPDATED_BY");
		buf.append(",AUTO_RULE_DESCRIPTION");
		buf.append(")");
		buf.append(" values(");
		for (int i = 0; i < 16; i++) {
			buf.append(i == 0 ? "?" : ",?");
		}
		buf.append(")");
		Log.debug(TSgAutoSpecConfigDao.class, buf.toString());
		try {
			db.connect();
			Connection con = db.getConnection();
			ps = con.prepareStatement(buf.toString());
			int pos = 1;
			if (entity.getRuleId() != null)
				ps.setLong(pos++, entity.getRuleId().longValue());
			else
				ps.setNull(pos++, Types.NUMERIC);
			Log.debug(TSgAutoSpecConfigDao.class,
					"ruleId:" + entity.getRuleId());
			if (entity.getAutoRuleId() != null)
				ps.setLong(pos++, entity.getAutoRuleId().longValue());
			else
				ps.setNull(pos++, Types.NUMERIC);
			Log.debug(TSgAutoSpecConfigDao.class,
					"autoRuleId:" + entity.getAutoRuleId());
			if (entity.getVehicleAgeFrom() != null)
				ps.setInt(pos++, entity.getVehicleAgeFrom().intValue());
			else
				ps.setNull(pos++, Types.NUMERIC);
			Log.debug(TSgAutoSpecConfigDao.class,
					"vehicleAgeFrom:" + entity.getVehicleAgeFrom());
			if (entity.getVehicleAgeTo() != null)
				ps.setInt(pos++, entity.getVehicleAgeTo().intValue());
			else
				ps.setNull(pos++, Types.NUMERIC);
			Log.debug(TSgAutoSpecConfigDao.class,
					"vehicleAgeTo:" + entity.getVehicleAgeTo());
			if (entity.getNcdFrom() != null)
				ps.setInt(pos++, entity.getNcdFrom().intValue());
			else
				ps.setNull(pos++, Types.NUMERIC);
			Log.debug(TSgAutoSpecConfigDao.class,
					"ncdFrom:" + entity.getNcdFrom());
			if (entity.getNcdTo() != null)
				ps.setInt(pos++, entity.getNcdTo().intValue());
			else
				ps.setNull(pos++, Types.NUMERIC);
			Log.debug(TSgAutoSpecConfigDao.class, "ncdTo:" + entity.getNcdTo());
			ps.setBigDecimal(pos++, entity.getPremiumFrom());
			Log.debug(TSgAutoSpecConfigDao.class,
					"premiumFrom:" + entity.getPremiumFrom());
			ps.setBigDecimal(pos++, entity.getPremiumTo());
			Log.debug(TSgAutoSpecConfigDao.class,
					"premiumTo:" + entity.getPremiumTo());
			if (entity.getVehicleType() != null)
				ps.setInt(pos++, entity.getVehicleType().intValue());
			else
				ps.setNull(pos++, Types.NUMERIC);
			Log.debug(TSgAutoSpecConfigDao.class,
					"vehicleType:" + entity.getVehicleType());
			if (entity.getBubbleBoxLetter() != null)
				ps.setLong(pos++, entity.getBubbleBoxLetter().longValue());
			else
				ps.setNull(pos++, Types.NUMERIC);
			Log.debug(TSgAutoSpecConfigDao.class,
					"bubbleBoxLetter:" + entity.getBubbleBoxLetter());
			if (entity.getImprtNoticeFlag() != null)
				ps.setInt(pos++, entity.getImprtNoticeFlag().intValue());
			else
				ps.setNull(pos++, Types.NUMERIC);
			Log.debug(TSgAutoSpecConfigDao.class,
					"imprtNoticeFlag:" + entity.getImprtNoticeFlag());
			ps.setTimestamp(pos++,
					entity.getInsertTime() != null ? new java.sql.Timestamp(
							entity.getInsertTime().getTime()) : null);
			Log.debug(TSgAutoSpecConfigDao.class,
					"insertTime:" + entity.getInsertTime());
			ps.setTimestamp(pos++,
					entity.getUpdateTime() != null ? new java.sql.Timestamp(
							entity.getUpdateTime().getTime()) : null);
			Log.debug(TSgAutoSpecConfigDao.class,
					"updateTime:" + entity.getUpdateTime());
			if (entity.getInsertedBy() != null)
				ps.setLong(pos++, entity.getInsertedBy().longValue());
			else
				ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
			Log.debug(TSgAutoSpecConfigDao.class,
					"insertedBy:" + entity.getInsertedBy());
			if (entity.getUpdatedBy() != null)
				ps.setLong(pos++, entity.getUpdatedBy().longValue());
			else
				ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
			Log.debug(TSgAutoSpecConfigDao.class,
					"updatedBy:" + entity.getUpdatedBy());
			ps.setString(pos++, entity.getAutoRuleDescription());
			Log.debug(TSgAutoSpecConfigDao.class, "autoRuleDescription:"
					+ entity.getAutoRuleDescription());
			ps.execute();
		} catch (SQLException e) {
			throw ExceptionFactory.parse(e);
		} catch (ClassNotFoundException e) {
			throw ExceptionFactory.parse(e);
		} finally {
			DBean.closeAll(null, ps, db);
		}
		return entity.getAutoRuleId();
	}

	public void update(TSgAutoSpecConfig entity) throws GenericException {
		if ("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
			try {
				Session session = HibernateUtil.currentSession();
				session.merge(entity);
				session.flush();
			} catch (HibernateException e) {
				throw ExceptionFactory.parse(e);
			} finally {
				try {
					HibernateUtil.closeSession();
				} catch (HibernateException e) {
					throw ExceptionFactory.parse(e);
				}
			}
			return;
		}
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer buf = new StringBuffer();
		buf.append("update T_SG_AUTO_SPEC_CONFIG set ");
		buf.append("RULE_ID=?");
		buf.append(",AUTO_RULE_ID=?");
		buf.append(",VEHICLE_AGE_FROM=?");
		buf.append(",VEHICLE_AGE_TO=?");
		buf.append(",NCD_FROM=?");
		buf.append(",NCD_TO=?");
		buf.append(",PREMIUM_FROM=?");
		buf.append(",PREMIUM_TO=?");
		buf.append(",VEHICLE_TYPE=?");
		buf.append(",BUBBLE_BOX_LETTER=?");
		buf.append(",IMPRT_NOTICE_FLAG=?");
		buf.append(",UPDATE_TIME=?");
		buf.append(",UPDATED_BY=?");
		buf.append(",AUTO_RULE_DESCRIPTION=?");
		buf.append(" where 1 = 1");
		buf.append("   and AUTO_RULE_ID = ?");
		Log.debug(TSgAutoSpecConfigDao.class, buf.toString());
		try {
			db.connect();
			Connection con = db.getConnection();
			ps = con.prepareStatement(buf.toString());
			int pos = 1;
			if (entity.getRuleId() != null)
				ps.setLong(pos++, entity.getRuleId().longValue());
			else
				ps.setNull(pos++, Types.NUMERIC);
			if (entity.getAutoRuleId() != null)
				ps.setLong(pos++, entity.getAutoRuleId().longValue());
			else
				ps.setNull(pos++, Types.NUMERIC);
			if (entity.getVehicleAgeFrom() != null)
				ps.setInt(pos++, entity.getVehicleAgeFrom().intValue());
			else
				ps.setNull(pos++, Types.NUMERIC);
			if (entity.getVehicleAgeTo() != null)
				ps.setInt(pos++, entity.getVehicleAgeTo().intValue());
			else
				ps.setNull(pos++, Types.NUMERIC);
			if (entity.getNcdFrom() != null)
				ps.setInt(pos++, entity.getNcdFrom().intValue());
			else
				ps.setNull(pos++, Types.NUMERIC);
			if (entity.getNcdTo() != null)
				ps.setInt(pos++, entity.getNcdTo().intValue());
			else
				ps.setNull(pos++, Types.NUMERIC);
			ps.setBigDecimal(pos++, entity.getPremiumFrom());
			ps.setBigDecimal(pos++, entity.getPremiumTo());
			if (entity.getVehicleType() != null)
				ps.setInt(pos++, entity.getVehicleType().intValue());
			else
				ps.setNull(pos++, Types.NUMERIC);
			if (entity.getBubbleBoxLetter() != null)
				ps.setLong(pos++, entity.getBubbleBoxLetter().longValue());
			else
				ps.setNull(pos++, Types.NUMERIC);
			if (entity.getImprtNoticeFlag() != null)
				ps.setInt(pos++, entity.getImprtNoticeFlag().intValue());
			else
				ps.setNull(pos++, Types.NUMERIC);
			
			ps.setTimestamp(pos++,
					entity.getUpdateTime() != null ? new java.sql.Timestamp(
							entity.getUpdateTime().getTime()) : null);
			
			if (entity.getUpdatedBy() != null)
				ps.setLong(pos++, entity.getUpdatedBy().longValue());
			else
				ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
			ps.setString(pos++, entity.getAutoRuleDescription());
			if (entity.getAutoRuleId() != null)
				ps.setLong(pos++, entity.getAutoRuleId().longValue());
			else
				ps.setNull(pos++, Types.NUMERIC);
			ps.execute();
		} catch (SQLException e) {
			throw ExceptionFactory.parse(e);
		} catch (ClassNotFoundException e) {
			throw ExceptionFactory.parse(e);
		} finally {
			DBean.closeAll(null, ps, db);
		}
	}

	public void remove(java.lang.Long autoRuleId) throws GenericException {
		if ("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
			TSgAutoSpecConfig entity = null;
			try {
				Session session = HibernateUtil.currentSession();
				entity = this.load(autoRuleId);
				if (entity == null) {
					return;
				}
				session.delete(entity);
				session.flush();
			} catch (HibernateException e) {
				throw ExceptionFactory.parse(e);
			} finally {
				try {
					HibernateUtil.closeSession();
				} catch (HibernateException e) {
					throw ExceptionFactory.parse(e);
				}
			}
			return;
		}
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer buf = new StringBuffer();
		buf.append("delete from T_SG_AUTO_SPEC_CONFIG");
		buf.append(" where 1 = 1");
		buf.append("   and AUTO_RULE_ID = ?");
		Log.debug(TSgAutoSpecConfigDao.class, buf.toString());
		try {
			db.connect();
			Connection con = db.getConnection();
			ps = con.prepareStatement(buf.toString());
			int pos = 1;
			if (autoRuleId != null)
				ps.setLong(pos++, autoRuleId.longValue());
			else
				ps.setNull(pos++, Types.NUMERIC);
			ps.execute();
		} catch (SQLException e) {
			throw ExceptionFactory.parse(e);
		} catch (ClassNotFoundException e) {
			throw ExceptionFactory.parse(e);
		} finally {
			DBean.closeAll(null, ps, db);
		}
	}

	public TSgAutoSpecConfig load(java.lang.Long autoRuleId)
			throws com.ebao.pub.framework.ObjectNotFoundException,
			GenericException {
		if ("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
			Object o = null;
			try {
				Session session = HibernateUtil.currentSession();
				if (autoRuleId == null) {
					return null;
				}
				Serializable sId = autoRuleId;
				o = session.load(TSgAutoSpecConfig.class, sId);
			} catch (org.hibernate.ObjectNotFoundException e) {
				// throw new
				// com.ebao.pub.framework.ObjectNotFoundException(e.getMessage());
			} catch (HibernateException e) {
				throw ExceptionFactory.parse(e);
			} finally {
				try {
					HibernateUtil.closeSession();
				} catch (HibernateException e) {
					throw ExceptionFactory.parse(e);
				}
			}
			if (o == null) {
				return null;
			}
			return (TSgAutoSpecConfig) o;
		}

		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer buf = new StringBuffer();
		buf.append("select * from T_SG_AUTO_SPEC_CONFIG ");
		buf.append(" where 1=1 ");
		buf.append("   and AUTO_RULE_ID = ?");
		Log.debug(TSgAutoSpecConfigDao.class, buf.toString());
		try {
			db.connect();
			Connection con = db.getConnection();
			ps = con.prepareStatement(buf.toString());
			int pos = 1;
			if (autoRuleId != null)
				ps.setLong(pos++, autoRuleId.longValue());
			else
				ps.setNull(pos++, Types.NUMERIC);
			rs = ps.executeQuery();
			TSgAutoSpecConfig entity = null;
			if (rs.next()) {
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


	
	public Long getSequenceID(Long masterRule) throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub

		DBean db = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Long serialId = null;
		try {
			StringBuffer selectQuery = new StringBuffer();
			selectQuery
					.append(" select max(AUTO_RULE_ID) as SERIAL_ID from T_SG_AUTO_SPEC_CONFIG where RULE_ID = ? ");
			db = new DBean(false);
			db.connect();
			Connection con = db.getConnection();

			ps = con.prepareStatement(selectQuery.toString());

			if (masterRule != null)
				ps.setLong(1, masterRule.longValue());
			else
				ps.setNull(1, Types.NUMERIC);
			rs = ps.executeQuery();

			while (rs.next()) {
				serialId = rs.getLong("SERIAL_ID");
			}
		} catch (ClassNotFoundException ex) {
			throw ex;
		} catch (SQLException sql) {
			throw sql;
		} finally {
			DBean.closeAll(rs, ps, db);
		}

		if (serialId == 0) {

			serialId = (long) 100000;
			return serialId;
		} else
			return serialId + 1;

	}
	// /////////////ManualMethodBegin///////////////
	// /////////////ManualMethodEnd///////////////
}
