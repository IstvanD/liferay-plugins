/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.knowledgebase.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.knowledgebase.model.KBArticleResource;
import com.liferay.knowledgebase.model.KBArticleResourceModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the KBArticleResource service. Represents a row in the &quot;KBArticleResource&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link KBArticleResourceModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link KBArticleResourceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KBArticleResourceImpl
 * @see KBArticleResource
 * @see KBArticleResourceModel
 * @generated
 */
@ProviderType
public class KBArticleResourceModelImpl extends BaseModelImpl<KBArticleResource>
	implements KBArticleResourceModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a k b article resource model instance should use the {@link KBArticleResource} interface instead.
	 */
	public static final String TABLE_NAME = "KBArticleResource";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "resourcePrimKey", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "kbArticleId", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("resourcePrimKey", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("kbArticleId", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table KBArticleResource (uuid_ VARCHAR(75) null,resourcePrimKey LONG not null primary key,groupId LONG,kbArticleId VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table KBArticleResource";
	public static final String ORDER_BY_JPQL = " ORDER BY kbArticleResource.resourcePrimKey ASC";
	public static final String ORDER_BY_SQL = " ORDER BY KBArticleResource.resourcePrimKey ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.knowledgebase.model.KBArticleResource"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.knowledgebase.model.KBArticleResource"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.knowledgebase.model.KBArticleResource"),
			true);
	public static final long GROUPID_COLUMN_BITMASK = 1L;
	public static final long KBARTICLEID_COLUMN_BITMASK = 2L;
	public static final long UUID_COLUMN_BITMASK = 4L;
	public static final long RESOURCEPRIMKEY_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.knowledgebase.model.KBArticleResource"));

	public KBArticleResourceModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _resourcePrimKey;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setResourcePrimKey(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _resourcePrimKey;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return KBArticleResource.class;
	}

	@Override
	public String getModelClassName() {
		return KBArticleResource.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("resourcePrimKey", getResourcePrimKey());
		attributes.put("groupId", getGroupId());
		attributes.put("kbArticleId", getKbArticleId());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long resourcePrimKey = (Long)attributes.get("resourcePrimKey");

		if (resourcePrimKey != null) {
			setResourcePrimKey(resourcePrimKey);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String kbArticleId = (String)attributes.get("kbArticleId");

		if (kbArticleId != null) {
			setKbArticleId(kbArticleId);
		}
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getResourcePrimKey() {
		return _resourcePrimKey;
	}

	@Override
	public void setResourcePrimKey(long resourcePrimKey) {
		_resourcePrimKey = resourcePrimKey;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public String getKbArticleId() {
		if (_kbArticleId == null) {
			return StringPool.BLANK;
		}
		else {
			return _kbArticleId;
		}
	}

	@Override
	public void setKbArticleId(String kbArticleId) {
		_columnBitmask |= KBARTICLEID_COLUMN_BITMASK;

		if (_originalKbArticleId == null) {
			_originalKbArticleId = _kbArticleId;
		}

		_kbArticleId = kbArticleId;
	}

	public String getOriginalKbArticleId() {
		return GetterUtil.getString(_originalKbArticleId);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			KBArticleResource.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public KBArticleResource toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (KBArticleResource)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		KBArticleResourceImpl kbArticleResourceImpl = new KBArticleResourceImpl();

		kbArticleResourceImpl.setUuid(getUuid());
		kbArticleResourceImpl.setResourcePrimKey(getResourcePrimKey());
		kbArticleResourceImpl.setGroupId(getGroupId());
		kbArticleResourceImpl.setKbArticleId(getKbArticleId());

		kbArticleResourceImpl.resetOriginalValues();

		return kbArticleResourceImpl;
	}

	@Override
	public int compareTo(KBArticleResource kbArticleResource) {
		long primaryKey = kbArticleResource.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KBArticleResource)) {
			return false;
		}

		KBArticleResource kbArticleResource = (KBArticleResource)obj;

		long primaryKey = kbArticleResource.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		KBArticleResourceModelImpl kbArticleResourceModelImpl = this;

		kbArticleResourceModelImpl._originalUuid = kbArticleResourceModelImpl._uuid;

		kbArticleResourceModelImpl._originalGroupId = kbArticleResourceModelImpl._groupId;

		kbArticleResourceModelImpl._setOriginalGroupId = false;

		kbArticleResourceModelImpl._originalKbArticleId = kbArticleResourceModelImpl._kbArticleId;

		kbArticleResourceModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<KBArticleResource> toCacheModel() {
		KBArticleResourceCacheModel kbArticleResourceCacheModel = new KBArticleResourceCacheModel();

		kbArticleResourceCacheModel.uuid = getUuid();

		String uuid = kbArticleResourceCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			kbArticleResourceCacheModel.uuid = null;
		}

		kbArticleResourceCacheModel.resourcePrimKey = getResourcePrimKey();

		kbArticleResourceCacheModel.groupId = getGroupId();

		kbArticleResourceCacheModel.kbArticleId = getKbArticleId();

		String kbArticleId = kbArticleResourceCacheModel.kbArticleId;

		if ((kbArticleId != null) && (kbArticleId.length() == 0)) {
			kbArticleResourceCacheModel.kbArticleId = null;
		}

		return kbArticleResourceCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", resourcePrimKey=");
		sb.append(getResourcePrimKey());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", kbArticleId=");
		sb.append(getKbArticleId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.liferay.knowledgebase.model.KBArticleResource");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resourcePrimKey</column-name><column-value><![CDATA[");
		sb.append(getResourcePrimKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kbArticleId</column-name><column-value><![CDATA[");
		sb.append(getKbArticleId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = KBArticleResource.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			KBArticleResource.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _resourcePrimKey;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private String _kbArticleId;
	private String _originalKbArticleId;
	private long _columnBitmask;
	private KBArticleResource _escapedModel;
}