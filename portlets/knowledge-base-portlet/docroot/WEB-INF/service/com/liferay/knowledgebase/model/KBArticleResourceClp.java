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

package com.liferay.knowledgebase.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.knowledgebase.service.ClpSerializer;
import com.liferay.knowledgebase.service.KBArticleResourceLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class KBArticleResourceClp extends BaseModelImpl<KBArticleResource>
	implements KBArticleResource {
	public KBArticleResourceClp() {
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

		_entityCacheEnabled = GetterUtil.getBoolean("entityCacheEnabled");
		_finderCacheEnabled = GetterUtil.getBoolean("finderCacheEnabled");
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_kbArticleResourceRemoteModel != null) {
			try {
				Class<?> clazz = _kbArticleResourceRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_kbArticleResourceRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getResourcePrimKey() {
		return _resourcePrimKey;
	}

	@Override
	public void setResourcePrimKey(long resourcePrimKey) {
		_resourcePrimKey = resourcePrimKey;

		if (_kbArticleResourceRemoteModel != null) {
			try {
				Class<?> clazz = _kbArticleResourceRemoteModel.getClass();

				Method method = clazz.getMethod("setResourcePrimKey", long.class);

				method.invoke(_kbArticleResourceRemoteModel, resourcePrimKey);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_kbArticleResourceRemoteModel != null) {
			try {
				Class<?> clazz = _kbArticleResourceRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_kbArticleResourceRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getKbArticleId() {
		return _kbArticleId;
	}

	@Override
	public void setKbArticleId(String kbArticleId) {
		_kbArticleId = kbArticleId;

		if (_kbArticleResourceRemoteModel != null) {
			try {
				Class<?> clazz = _kbArticleResourceRemoteModel.getClass();

				Method method = clazz.getMethod("setKbArticleId", String.class);

				method.invoke(_kbArticleResourceRemoteModel, kbArticleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getKBArticleResourceRemoteModel() {
		return _kbArticleResourceRemoteModel;
	}

	public void setKBArticleResourceRemoteModel(
		BaseModel<?> kbArticleResourceRemoteModel) {
		_kbArticleResourceRemoteModel = kbArticleResourceRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _kbArticleResourceRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_kbArticleResourceRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			KBArticleResourceLocalServiceUtil.addKBArticleResource(this);
		}
		else {
			KBArticleResourceLocalServiceUtil.updateKBArticleResource(this);
		}
	}

	@Override
	public KBArticleResource toEscapedModel() {
		return (KBArticleResource)ProxyUtil.newProxyInstance(KBArticleResource.class.getClassLoader(),
			new Class[] { KBArticleResource.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		KBArticleResourceClp clone = new KBArticleResourceClp();

		clone.setUuid(getUuid());
		clone.setResourcePrimKey(getResourcePrimKey());
		clone.setGroupId(getGroupId());
		clone.setKbArticleId(getKbArticleId());

		return clone;
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

		if (!(obj instanceof KBArticleResourceClp)) {
			return false;
		}

		KBArticleResourceClp kbArticleResource = (KBArticleResourceClp)obj;

		long primaryKey = kbArticleResource.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
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

	private String _uuid;
	private long _resourcePrimKey;
	private long _groupId;
	private String _kbArticleId;
	private BaseModel<?> _kbArticleResourceRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.knowledgebase.service.ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}