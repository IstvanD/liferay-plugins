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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link KBArticleResource}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KBArticleResource
 * @generated
 */
@ProviderType
public class KBArticleResourceWrapper implements KBArticleResource,
	ModelWrapper<KBArticleResource> {
	public KBArticleResourceWrapper(KBArticleResource kbArticleResource) {
		_kbArticleResource = kbArticleResource;
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
	public java.lang.Object clone() {
		return new KBArticleResourceWrapper((KBArticleResource)_kbArticleResource.clone());
	}

	@Override
	public int compareTo(
		com.liferay.knowledgebase.model.KBArticleResource kbArticleResource) {
		return _kbArticleResource.compareTo(kbArticleResource);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _kbArticleResource.getExpandoBridge();
	}

	/**
	* Returns the group ID of this k b article resource.
	*
	* @return the group ID of this k b article resource
	*/
	@Override
	public long getGroupId() {
		return _kbArticleResource.getGroupId();
	}

	/**
	* Returns the kb article ID of this k b article resource.
	*
	* @return the kb article ID of this k b article resource
	*/
	@Override
	public java.lang.String getKbArticleId() {
		return _kbArticleResource.getKbArticleId();
	}

	/**
	* Returns the primary key of this k b article resource.
	*
	* @return the primary key of this k b article resource
	*/
	@Override
	public long getPrimaryKey() {
		return _kbArticleResource.getPrimaryKey();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _kbArticleResource.getPrimaryKeyObj();
	}

	/**
	* Returns the resource prim key of this k b article resource.
	*
	* @return the resource prim key of this k b article resource
	*/
	@Override
	public long getResourcePrimKey() {
		return _kbArticleResource.getResourcePrimKey();
	}

	/**
	* Returns the uuid of this k b article resource.
	*
	* @return the uuid of this k b article resource
	*/
	@Override
	public java.lang.String getUuid() {
		return _kbArticleResource.getUuid();
	}

	@Override
	public int hashCode() {
		return _kbArticleResource.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _kbArticleResource.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _kbArticleResource.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _kbArticleResource.isNew();
	}

	@Override
	public void persist() {
		_kbArticleResource.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_kbArticleResource.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_kbArticleResource.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_kbArticleResource.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_kbArticleResource.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this k b article resource.
	*
	* @param groupId the group ID of this k b article resource
	*/
	@Override
	public void setGroupId(long groupId) {
		_kbArticleResource.setGroupId(groupId);
	}

	/**
	* Sets the kb article ID of this k b article resource.
	*
	* @param kbArticleId the kb article ID of this k b article resource
	*/
	@Override
	public void setKbArticleId(java.lang.String kbArticleId) {
		_kbArticleResource.setKbArticleId(kbArticleId);
	}

	@Override
	public void setNew(boolean n) {
		_kbArticleResource.setNew(n);
	}

	/**
	* Sets the primary key of this k b article resource.
	*
	* @param primaryKey the primary key of this k b article resource
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_kbArticleResource.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_kbArticleResource.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the resource prim key of this k b article resource.
	*
	* @param resourcePrimKey the resource prim key of this k b article resource
	*/
	@Override
	public void setResourcePrimKey(long resourcePrimKey) {
		_kbArticleResource.setResourcePrimKey(resourcePrimKey);
	}

	/**
	* Sets the uuid of this k b article resource.
	*
	* @param uuid the uuid of this k b article resource
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_kbArticleResource.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.knowledgebase.model.KBArticleResource> toCacheModel() {
		return _kbArticleResource.toCacheModel();
	}

	@Override
	public com.liferay.knowledgebase.model.KBArticleResource toEscapedModel() {
		return new KBArticleResourceWrapper(_kbArticleResource.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _kbArticleResource.toString();
	}

	@Override
	public com.liferay.knowledgebase.model.KBArticleResource toUnescapedModel() {
		return new KBArticleResourceWrapper(_kbArticleResource.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _kbArticleResource.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KBArticleResourceWrapper)) {
			return false;
		}

		KBArticleResourceWrapper kbArticleResourceWrapper = (KBArticleResourceWrapper)obj;

		if (Validator.equals(_kbArticleResource,
					kbArticleResourceWrapper._kbArticleResource)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	@Deprecated
	public KBArticleResource getWrappedKBArticleResource() {
		return _kbArticleResource;
	}

	@Override
	public KBArticleResource getWrappedModel() {
		return _kbArticleResource;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _kbArticleResource.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _kbArticleResource.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_kbArticleResource.resetOriginalValues();
	}

	private final KBArticleResource _kbArticleResource;
}