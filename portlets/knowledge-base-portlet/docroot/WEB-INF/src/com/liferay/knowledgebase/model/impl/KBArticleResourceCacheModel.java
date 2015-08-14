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

import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing KBArticleResource in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see KBArticleResource
 * @generated
 */
@ProviderType
public class KBArticleResourceCacheModel implements CacheModel<KBArticleResource>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KBArticleResourceCacheModel)) {
			return false;
		}

		KBArticleResourceCacheModel kbArticleResourceCacheModel = (KBArticleResourceCacheModel)obj;

		if (resourcePrimKey == kbArticleResourceCacheModel.resourcePrimKey) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, resourcePrimKey);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", resourcePrimKey=");
		sb.append(resourcePrimKey);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", kbArticleId=");
		sb.append(kbArticleId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public KBArticleResource toEntityModel() {
		KBArticleResourceImpl kbArticleResourceImpl = new KBArticleResourceImpl();

		if (uuid == null) {
			kbArticleResourceImpl.setUuid(StringPool.BLANK);
		}
		else {
			kbArticleResourceImpl.setUuid(uuid);
		}

		kbArticleResourceImpl.setResourcePrimKey(resourcePrimKey);
		kbArticleResourceImpl.setGroupId(groupId);

		if (kbArticleId == null) {
			kbArticleResourceImpl.setKbArticleId(StringPool.BLANK);
		}
		else {
			kbArticleResourceImpl.setKbArticleId(kbArticleId);
		}

		kbArticleResourceImpl.resetOriginalValues();

		return kbArticleResourceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		resourcePrimKey = objectInput.readLong();
		groupId = objectInput.readLong();
		kbArticleId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(resourcePrimKey);
		objectOutput.writeLong(groupId);

		if (kbArticleId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(kbArticleId);
		}
	}

	public String uuid;
	public long resourcePrimKey;
	public long groupId;
	public String kbArticleId;
}