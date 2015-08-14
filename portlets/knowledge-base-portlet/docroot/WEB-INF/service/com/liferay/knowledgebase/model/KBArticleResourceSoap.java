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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class KBArticleResourceSoap implements Serializable {
	public static KBArticleResourceSoap toSoapModel(KBArticleResource model) {
		KBArticleResourceSoap soapModel = new KBArticleResourceSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setResourcePrimKey(model.getResourcePrimKey());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setKbArticleId(model.getKbArticleId());

		return soapModel;
	}

	public static KBArticleResourceSoap[] toSoapModels(
		KBArticleResource[] models) {
		KBArticleResourceSoap[] soapModels = new KBArticleResourceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static KBArticleResourceSoap[][] toSoapModels(
		KBArticleResource[][] models) {
		KBArticleResourceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new KBArticleResourceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new KBArticleResourceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static KBArticleResourceSoap[] toSoapModels(
		List<KBArticleResource> models) {
		List<KBArticleResourceSoap> soapModels = new ArrayList<KBArticleResourceSoap>(models.size());

		for (KBArticleResource model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new KBArticleResourceSoap[soapModels.size()]);
	}

	public KBArticleResourceSoap() {
	}

	public long getPrimaryKey() {
		return _resourcePrimKey;
	}

	public void setPrimaryKey(long pk) {
		setResourcePrimKey(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getResourcePrimKey() {
		return _resourcePrimKey;
	}

	public void setResourcePrimKey(long resourcePrimKey) {
		_resourcePrimKey = resourcePrimKey;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getKbArticleId() {
		return _kbArticleId;
	}

	public void setKbArticleId(String kbArticleId) {
		_kbArticleId = kbArticleId;
	}

	private String _uuid;
	private long _resourcePrimKey;
	private long _groupId;
	private String _kbArticleId;
}