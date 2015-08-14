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

package com.liferay.knowledgebase.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.knowledgebase.model.KBArticleResource;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the k b article resource service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.knowledgebase.service.persistence.impl.KBArticleResourcePersistenceImpl
 * @see KBArticleResourceUtil
 * @generated
 */
@ProviderType
public interface KBArticleResourcePersistence extends BasePersistence<KBArticleResource> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link KBArticleResourceUtil} to access the k b article resource persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the k b article resources where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching k b article resources
	*/
	public java.util.List<KBArticleResource> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the k b article resources where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KBArticleResourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of k b article resources
	* @param end the upper bound of the range of k b article resources (not inclusive)
	* @return the range of matching k b article resources
	*/
	public java.util.List<KBArticleResource> findByUuid(java.lang.String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the k b article resources where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KBArticleResourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of k b article resources
	* @param end the upper bound of the range of k b article resources (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching k b article resources
	*/
	public java.util.List<KBArticleResource> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KBArticleResource> orderByComparator);

	/**
	* Returns the first k b article resource in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching k b article resource
	* @throws NoSuchArticleResourceException if a matching k b article resource could not be found
	*/
	public KBArticleResource findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<KBArticleResource> orderByComparator)
		throws com.liferay.knowledgebase.NoSuchArticleResourceException;

	/**
	* Returns the first k b article resource in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching k b article resource, or <code>null</code> if a matching k b article resource could not be found
	*/
	public KBArticleResource fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<KBArticleResource> orderByComparator);

	/**
	* Returns the last k b article resource in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching k b article resource
	* @throws NoSuchArticleResourceException if a matching k b article resource could not be found
	*/
	public KBArticleResource findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<KBArticleResource> orderByComparator)
		throws com.liferay.knowledgebase.NoSuchArticleResourceException;

	/**
	* Returns the last k b article resource in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching k b article resource, or <code>null</code> if a matching k b article resource could not be found
	*/
	public KBArticleResource fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<KBArticleResource> orderByComparator);

	/**
	* Returns the k b article resources before and after the current k b article resource in the ordered set where uuid = &#63;.
	*
	* @param resourcePrimKey the primary key of the current k b article resource
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next k b article resource
	* @throws NoSuchArticleResourceException if a k b article resource with the primary key could not be found
	*/
	public KBArticleResource[] findByUuid_PrevAndNext(long resourcePrimKey,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<KBArticleResource> orderByComparator)
		throws com.liferay.knowledgebase.NoSuchArticleResourceException;

	/**
	* Removes all the k b article resources where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of k b article resources where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching k b article resources
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the k b article resource where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchArticleResourceException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching k b article resource
	* @throws NoSuchArticleResourceException if a matching k b article resource could not be found
	*/
	public KBArticleResource findByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.knowledgebase.NoSuchArticleResourceException;

	/**
	* Returns the k b article resource where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching k b article resource, or <code>null</code> if a matching k b article resource could not be found
	*/
	public KBArticleResource fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the k b article resource where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching k b article resource, or <code>null</code> if a matching k b article resource could not be found
	*/
	public KBArticleResource fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the k b article resource where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the k b article resource that was removed
	*/
	public KBArticleResource removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.knowledgebase.NoSuchArticleResourceException;

	/**
	* Returns the number of k b article resources where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching k b article resources
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the k b article resources where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching k b article resources
	*/
	public java.util.List<KBArticleResource> findByGroupId(long groupId);

	/**
	* Returns a range of all the k b article resources where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KBArticleResourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of k b article resources
	* @param end the upper bound of the range of k b article resources (not inclusive)
	* @return the range of matching k b article resources
	*/
	public java.util.List<KBArticleResource> findByGroupId(long groupId,
		int start, int end);

	/**
	* Returns an ordered range of all the k b article resources where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KBArticleResourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of k b article resources
	* @param end the upper bound of the range of k b article resources (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching k b article resources
	*/
	public java.util.List<KBArticleResource> findByGroupId(long groupId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KBArticleResource> orderByComparator);

	/**
	* Returns the first k b article resource in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching k b article resource
	* @throws NoSuchArticleResourceException if a matching k b article resource could not be found
	*/
	public KBArticleResource findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<KBArticleResource> orderByComparator)
		throws com.liferay.knowledgebase.NoSuchArticleResourceException;

	/**
	* Returns the first k b article resource in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching k b article resource, or <code>null</code> if a matching k b article resource could not be found
	*/
	public KBArticleResource fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<KBArticleResource> orderByComparator);

	/**
	* Returns the last k b article resource in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching k b article resource
	* @throws NoSuchArticleResourceException if a matching k b article resource could not be found
	*/
	public KBArticleResource findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<KBArticleResource> orderByComparator)
		throws com.liferay.knowledgebase.NoSuchArticleResourceException;

	/**
	* Returns the last k b article resource in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching k b article resource, or <code>null</code> if a matching k b article resource could not be found
	*/
	public KBArticleResource fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<KBArticleResource> orderByComparator);

	/**
	* Returns the k b article resources before and after the current k b article resource in the ordered set where groupId = &#63;.
	*
	* @param resourcePrimKey the primary key of the current k b article resource
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next k b article resource
	* @throws NoSuchArticleResourceException if a k b article resource with the primary key could not be found
	*/
	public KBArticleResource[] findByGroupId_PrevAndNext(long resourcePrimKey,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<KBArticleResource> orderByComparator)
		throws com.liferay.knowledgebase.NoSuchArticleResourceException;

	/**
	* Removes all the k b article resources where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of k b article resources where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching k b article resources
	*/
	public int countByGroupId(long groupId);

	/**
	* Returns the k b article resource where groupId = &#63; and kbArticleId = &#63; or throws a {@link NoSuchArticleResourceException} if it could not be found.
	*
	* @param groupId the group ID
	* @param kbArticleId the kb article ID
	* @return the matching k b article resource
	* @throws NoSuchArticleResourceException if a matching k b article resource could not be found
	*/
	public KBArticleResource findByG_KBAI(long groupId,
		java.lang.String kbArticleId)
		throws com.liferay.knowledgebase.NoSuchArticleResourceException;

	/**
	* Returns the k b article resource where groupId = &#63; and kbArticleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param kbArticleId the kb article ID
	* @return the matching k b article resource, or <code>null</code> if a matching k b article resource could not be found
	*/
	public KBArticleResource fetchByG_KBAI(long groupId,
		java.lang.String kbArticleId);

	/**
	* Returns the k b article resource where groupId = &#63; and kbArticleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param kbArticleId the kb article ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching k b article resource, or <code>null</code> if a matching k b article resource could not be found
	*/
	public KBArticleResource fetchByG_KBAI(long groupId,
		java.lang.String kbArticleId, boolean retrieveFromCache);

	/**
	* Removes the k b article resource where groupId = &#63; and kbArticleId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param kbArticleId the kb article ID
	* @return the k b article resource that was removed
	*/
	public KBArticleResource removeByG_KBAI(long groupId,
		java.lang.String kbArticleId)
		throws com.liferay.knowledgebase.NoSuchArticleResourceException;

	/**
	* Returns the number of k b article resources where groupId = &#63; and kbArticleId = &#63;.
	*
	* @param groupId the group ID
	* @param kbArticleId the kb article ID
	* @return the number of matching k b article resources
	*/
	public int countByG_KBAI(long groupId, java.lang.String kbArticleId);

	/**
	* Caches the k b article resource in the entity cache if it is enabled.
	*
	* @param kbArticleResource the k b article resource
	*/
	public void cacheResult(KBArticleResource kbArticleResource);

	/**
	* Caches the k b article resources in the entity cache if it is enabled.
	*
	* @param kbArticleResources the k b article resources
	*/
	public void cacheResult(
		java.util.List<KBArticleResource> kbArticleResources);

	/**
	* Creates a new k b article resource with the primary key. Does not add the k b article resource to the database.
	*
	* @param resourcePrimKey the primary key for the new k b article resource
	* @return the new k b article resource
	*/
	public KBArticleResource create(long resourcePrimKey);

	/**
	* Removes the k b article resource with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param resourcePrimKey the primary key of the k b article resource
	* @return the k b article resource that was removed
	* @throws NoSuchArticleResourceException if a k b article resource with the primary key could not be found
	*/
	public KBArticleResource remove(long resourcePrimKey)
		throws com.liferay.knowledgebase.NoSuchArticleResourceException;

	public KBArticleResource updateImpl(KBArticleResource kbArticleResource);

	/**
	* Returns the k b article resource with the primary key or throws a {@link NoSuchArticleResourceException} if it could not be found.
	*
	* @param resourcePrimKey the primary key of the k b article resource
	* @return the k b article resource
	* @throws NoSuchArticleResourceException if a k b article resource with the primary key could not be found
	*/
	public KBArticleResource findByPrimaryKey(long resourcePrimKey)
		throws com.liferay.knowledgebase.NoSuchArticleResourceException;

	/**
	* Returns the k b article resource with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param resourcePrimKey the primary key of the k b article resource
	* @return the k b article resource, or <code>null</code> if a k b article resource with the primary key could not be found
	*/
	public KBArticleResource fetchByPrimaryKey(long resourcePrimKey);

	@Override
	public java.util.Map<java.io.Serializable, KBArticleResource> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the k b article resources.
	*
	* @return the k b article resources
	*/
	public java.util.List<KBArticleResource> findAll();

	/**
	* Returns a range of all the k b article resources.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KBArticleResourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of k b article resources
	* @param end the upper bound of the range of k b article resources (not inclusive)
	* @return the range of k b article resources
	*/
	public java.util.List<KBArticleResource> findAll(int start, int end);

	/**
	* Returns an ordered range of all the k b article resources.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KBArticleResourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of k b article resources
	* @param end the upper bound of the range of k b article resources (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of k b article resources
	*/
	public java.util.List<KBArticleResource> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KBArticleResource> orderByComparator);

	/**
	* Removes all the k b article resources from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of k b article resources.
	*
	* @return the number of k b article resources
	*/
	public int countAll();
}