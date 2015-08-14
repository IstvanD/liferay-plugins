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

package com.liferay.knowledgebase.service.impl;

import com.liferay.knowledgebase.model.KBArticleResource;
import com.liferay.knowledgebase.service.base.KBArticleResourceLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class KBArticleResourceLocalServiceImpl
	extends KBArticleResourceLocalServiceBaseImpl {

	@Override
	public void deleteArticleResource(long groupId, String kbArticleId)
		throws PortalException {

		KBArticleResourcePersistence.removeByG_KBAI(groupId, kbArticleId);
	}

	@Override
	public KBArticleResource fetchArticleResource(
		long groupId, String kbArticleId) {

		return KBArticleResourcePersistence.fetchByG_KBAI(groupId, kbArticleId);
	}

	@Override
	public KBArticleResource fetchArticleResource(
		String uuid, long groupId) {

		return KBArticleResourcePersistence.fetchByUUID_G(uuid, groupId);
	}

	@Override
	public KBArticleResource getArticleResource(
			long articleResourcePrimKey)
		throws PortalException {

		return KBArticleResourcePersistence.findByPrimaryKey(
			articleResourcePrimKey);
	}

	@Override
	public long getArticleResourcePrimKey(long groupId, String kbArticleId) {
		return getArticleResourcePrimKey(null, groupId, kbArticleId);
	}

	@Override
	public long getArticleResourcePrimKey(
		String uuid, long groupId, String kbArticleId) {

		KBArticleResource articleResource = null;

		if (Validator.isNotNull(uuid)) {
			articleResource = KBArticleResourcePersistence.fetchByUUID_G(
				uuid, groupId);
		}

		if (articleResource == null) {
			articleResource = KBArticleResourcePersistence.fetchByG_KBAI(
				groupId, kbArticleId);
		}

		if (articleResource == null) {
			long articleResourcePrimKey = counterLocalService.increment();

			articleResource = KBArticleResourcePersistence.create(
				articleResourcePrimKey);

			if (Validator.isNotNull(uuid)) {
				articleResource.setUuid(uuid);
			}

			articleResource.setGroupId(groupId);
			articleResource.setKbArticleId(kbArticleId);

			KBArticleResourcePersistence.update(articleResource);
		}

		return articleResource.getResourcePrimKey();
	}

	@Override
	public List<KBArticleResource> getArticleResources(long groupId) {
		return KBArticleResourcePersistence.findByGroupId(groupId);
	}
}