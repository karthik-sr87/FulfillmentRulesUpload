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

import com.ebao.aig.sg.fulfillment.rules.upload.target.data.dao.TSgProducerSpecificConfigDao;
import com.ebao.aig.sg.fulfillment.rules.upload.target.data.vo.TSgProducerSpecificConfig;
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

public class TSgProducerSpecificConfigDaoOracleImpl implements
		TSgProducerSpecificConfigDao {
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
		table = "T_SG_PRODUCER_SPECIFIC_CONFIG";
		columns.put("ruleId", "RULE_ID");
		columnTypes.put("ruleId", "java.lang.Long");
		columns.put("producerRuleId", "PRODUCER_RULE_ID");
		columnTypes.put("producerRuleId", "java.lang.Long");
		columns.put("producerType", "PRODUCER_TYPE");
		columnTypes.put("producerType", "java.lang.Long");
		columns.put("producerCodeFrom", "PRODUCER_CODE_FROM");
		columnTypes.put("producerCodeFrom", "java.lang.String");
		columns.put("producerCodeTo", "PRODUCER_CODE_TO");
		columnTypes.put("producerCodeTo", "java.lang.String");
		columns.put("producersExcluded", "PRODUCERS_EXCLUDED");
		columnTypes.put("producersExcluded", "java.lang.String");
		columns.put("letterId", "LETTER_ID");
		columnTypes.put("letterId", "java.lang.Long");
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

	public TSgProducerSpecificConfig fillEntity(ResultSet rs)
			throws SQLException {
		TSgProducerSpecificConfig entity = new TSgProducerSpecificConfig();
		entity.setRuleId(new Long(rs.getLong("RULE_ID")));
		if (rs.wasNull()) {
			entity.setRuleId(null);
		}
		entity.setProducerRuleId(new Long(rs.getLong("PRODUCER_RULE_ID")));
		if (rs.wasNull()) {
			entity.setProducerRuleId(null);
		}
		entity.setProducerType(new Long(rs.getLong("PRODUCER_TYPE")));
		if (rs.wasNull()) {
			entity.setProducerType(null);
		}
		entity.setProducerCodeFrom(rs.getString("PRODUCER_CODE_FROM"));
		entity.setProducerCodeTo(rs.getString("PRODUCER_CODE_TO"));
		entity.setProducersExcluded(rs.getString("PRODUCERS_EXCLUDED"));
		entity.setLetterId(new Long(rs.getLong("LETTER_ID")));
		if (rs.wasNull()) {
			entity.setLetterId(null);
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

	public java.lang.Long create(TSgProducerSpecificConfig entity)
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
		if (entity.getProducerRuleId() == null
				|| entity.getProducerRuleId().longValue() <= 0) {
			entity.setProducerRuleId(OracleSequencePKGenerator.getInstance()
					.getNextPKValue("S_SG_PRODUCER_SPECIFIC_CONFIG_"));
		}
		DBean db = new DBean();
		PreparedStatement ps = null;
		StringBuffer buf = new StringBuffer();
		buf.append("insert into T_SG_PRODUCER_SPECIFIC_CONFIG(");
		buf.append("RULE_ID");
		buf.append(",PRODUCER_RULE_ID");
		buf.append(",PRODUCER_TYPE");
		buf.append(",PRODUCER_CODE_FROM");
		buf.append(",PRODUCER_CODE_TO");
		buf.append(",PRODUCERS_EXCLUDED");
		buf.append(",LETTER_ID");
		buf.append(",INSERT_TIME");
		buf.append(",UPDATE_TIME");
		buf.append(",INSERTED_BY");
		buf.append(",UPDATED_BY");
		buf.append(")");
		buf.append(" values(");
		for (int i = 0; i < 11; i++) {
			buf.append(i == 0 ? "?" : ",?");
		}
		buf.append(")");
		Log.debug(TSgProducerSpecificConfigDao.class, buf.toString());
		try {
			db.connect();
			Connection con = db.getConnection();
			ps = con.prepareStatement(buf.toString());
			int pos = 1;
			if (entity.getRuleId() != null)
				ps.setLong(pos++, entity.getRuleId().longValue());
			else
				ps.setNull(pos++, Types.NUMERIC);
			Log.debug(TSgProducerSpecificConfigDao.class,
					"ruleId:" + entity.getRuleId());
			if (entity.getProducerRuleId() != null)
				ps.setLong(pos++, entity.getProducerRuleId().longValue());
			else
				ps.setNull(pos++, Types.NUMERIC);
			Log.debug(TSgProducerSpecificConfigDao.class, "producerRuleId:"
					+ entity.getProducerRuleId());
			if (entity.getProducerType() != null)
				ps.setLong(pos++, entity.getProducerType().longValue());
			else
				ps.setNull(pos++, Types.NUMERIC);
			Log.debug(TSgProducerSpecificConfigDao.class, "producerType:"
					+ entity.getProducerType());
			ps.setString(pos++, entity.getProducerCodeFrom());
			Log.debug(TSgProducerSpecificConfigDao.class, "producerCodeFrom:"
					+ entity.getProducerCodeFrom());
			ps.setString(pos++, entity.getProducerCodeTo());
			Log.debug(TSgProducerSpecificConfigDao.class, "producerCodeTo:"
					+ entity.getProducerCodeTo());
			ps.setString(pos++, entity.getProducersExcluded());
			Log.debug(TSgProducerSpecificConfigDao.class, "producersExcluded:"
					+ entity.getProducersExcluded());
			if (entity.getLetterId() != null)
				ps.setLong(pos++, entity.getLetterId().longValue());
			else
				ps.setNull(pos++, Types.NUMERIC);
			Log.debug(TSgProducerSpecificConfigDao.class,
					"letterId:" + entity.getLetterId());
			ps.setTimestamp(pos++,
					entity.getInsertTime() != null ? new java.sql.Timestamp(
							entity.getInsertTime().getTime()) : null);
			Log.debug(TSgProducerSpecificConfigDao.class, "insertTime:"
					+ entity.getInsertTime());
			ps.setTimestamp(pos++,
					entity.getUpdateTime() != null ? new java.sql.Timestamp(
							entity.getUpdateTime().getTime()) : null);
			Log.debug(TSgProducerSpecificConfigDao.class, "updateTime:"
					+ entity.getUpdateTime());
			if (entity.getInsertedBy() != null)
				ps.setLong(pos++, entity.getInsertedBy().longValue());
			else
				ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
			Log.debug(TSgProducerSpecificConfigDao.class, "insertedBy:"
					+ entity.getInsertedBy());
			if (entity.getUpdatedBy() != null)
				ps.setLong(pos++, entity.getUpdatedBy().longValue());
			else
				ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
			Log.debug(TSgProducerSpecificConfigDao.class,
					"updatedBy:" + entity.getUpdatedBy());
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

	public void update(TSgProducerSpecificConfig entity)
			throws GenericException {
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
		buf.append("update T_SG_PRODUCER_SPECIFIC_CONFIG set ");
		buf.append("RULE_ID=?");
		buf.append(",PRODUCER_RULE_ID=?");
		buf.append(",PRODUCER_TYPE=?");
		buf.append(",PRODUCER_CODE_FROM=?");
		buf.append(",PRODUCER_CODE_TO=?");
		buf.append(",PRODUCERS_EXCLUDED=?");
		buf.append(",LETTER_ID=?");
		buf.append(",UPDATE_TIME=?");
		buf.append(",UPDATED_BY=?");
		buf.append(" where 1 = 1");
		buf.append("   and PRODUCER_RULE_ID = ?");
		Log.debug(TSgProducerSpecificConfigDao.class, buf.toString());
		try {
			db.connect();
			Connection con = db.getConnection();
			ps = con.prepareStatement(buf.toString());
			int pos = 1;
			if (entity.getRuleId() != null)
				ps.setLong(pos++, entity.getRuleId().longValue());
			else
				ps.setNull(pos++, Types.NUMERIC);
			if (entity.getProducerRuleId() != null)
				ps.setLong(pos++, entity.getProducerRuleId().longValue());
			else
				ps.setNull(pos++, Types.NUMERIC);
			if (entity.getProducerType() != null)
				ps.setLong(pos++, entity.getProducerType().longValue());
			else
				ps.setNull(pos++, Types.NUMERIC);
			ps.setString(pos++, entity.getProducerCodeFrom());
			ps.setString(pos++, entity.getProducerCodeTo());
			ps.setString(pos++, entity.getProducersExcluded());
			if (entity.getLetterId() != null)
				ps.setLong(pos++, entity.getLetterId().longValue());
			else
				ps.setNull(pos++, Types.NUMERIC);
			ps.setTimestamp(pos++,
					entity.getUpdateTime() != null ? new java.sql.Timestamp(
							entity.getUpdateTime().getTime()) : null);
			if (entity.getUpdatedBy() != null)
				ps.setLong(pos++, entity.getUpdatedBy().longValue());
			else
				ps.setLong(pos++, AppContext.getCurrentUser().getUserId());
			if (entity.getProducerRuleId() != null)
				ps.setLong(pos++, entity.getProducerRuleId().longValue());
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

	public void remove(java.lang.Long producerRuleId) throws GenericException {
		if ("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
			TSgProducerSpecificConfig entity = null;
			try {
				Session session = HibernateUtil.currentSession();
				entity = this.load(producerRuleId);
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
		buf.append("delete from T_SG_PRODUCER_SPECIFIC_CONFIG");
		buf.append(" where 1 = 1");
		buf.append("   and PRODUCER_RULE_ID = ?");
		Log.debug(TSgProducerSpecificConfigDao.class, buf.toString());
		try {
			db.connect();
			Connection con = db.getConnection();
			ps = con.prepareStatement(buf.toString());
			int pos = 1;
			if (producerRuleId != null)
				ps.setLong(pos++, producerRuleId.longValue());
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

	public TSgProducerSpecificConfig load(java.lang.Long producerRuleId)
			throws com.ebao.pub.framework.ObjectNotFoundException,
			GenericException {
		if ("hibernate".equals(Env.getValue("PERSISTENCE_TYPE"))) {
			Object o = null;
			try {
				Session session = HibernateUtil.currentSession();
				if (producerRuleId == null) {
					return null;
				}
				Serializable sId = producerRuleId;
				o = session.load(TSgProducerSpecificConfig.class, sId);
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
			return (TSgProducerSpecificConfig) o;
		}

		DBean db = new DBean();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer buf = new StringBuffer();
		buf.append("select * from T_SG_PRODUCER_SPECIFIC_CONFIG ");
		buf.append(" where 1=1 ");
		buf.append("   and PRODUCER_RULE_ID = ?");
		Log.debug(TSgProducerSpecificConfigDao.class, buf.toString());
		try {
			db.connect();
			Connection con = db.getConnection();
			ps = con.prepareStatement(buf.toString());
			int pos = 1;
			if (producerRuleId != null)
				ps.setLong(pos++, producerRuleId.longValue());
			else
				ps.setNull(pos++, Types.NUMERIC);
			rs = ps.executeQuery();
			TSgProducerSpecificConfig entity = null;
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


	public Long getProducerSequenceID(Long masterRuleId) throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		DBean db = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Long producerserialId = null;
		try {
			StringBuffer selectQuery = new StringBuffer();
			selectQuery.append("SELECT max(PRODUCER_RULE_ID) AS SERIAL_ID FROM T_SG_PRODUCER_SPECIFIC_CONFIG where RULE_ID = ? ");
			db = new DBean(false);
			db.connect();
			Connection con = db.getConnection();
			//
			ps = con.prepareStatement(selectQuery.toString());
			int pos = 1;
			if (masterRuleId != null)
				ps.setLong(1, (Long) masterRuleId);
			else
				ps.setNull(1, Types.NUMERIC);
			rs = ps.executeQuery();
			while (rs.next()) {
				producerserialId = rs.getLong("SERIAL_ID");
			}
		} catch (ClassNotFoundException ex) {
			throw ex;
		} catch (SQLException sql) {
			throw sql;
		} finally {
			DBean.closeAll(rs, ps, db);
		}
		if (producerserialId == 0)
			return producerserialId = (long) 100;
		else
			return producerserialId + 1;
	}

	// /////////////ManualMethodBegin///////////////
	// /////////////ManualMethodEnd///////////////
}
