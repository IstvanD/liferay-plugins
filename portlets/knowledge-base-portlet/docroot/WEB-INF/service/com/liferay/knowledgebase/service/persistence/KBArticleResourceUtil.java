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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the k b article resource service. This utility wraps {@link com.liferay.knowledgebase.service.persistence.impl.KBArticleResourcePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KBArticleResourcePersistence
 * @see com.liferay.knowledgebase.service.persistence.impl.KBArticleResourcePersistenceImpl
 * @generated
 */
@ProviderType
public class KBArticleResourceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(KBArticleResource kbArticleResource) {
		getPersistence().clearCache(kbArticleResource);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<KBArticleResource> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<KBArticleResource> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<KBArticleResource> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<KBArticleResource> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static KBArticleResource update(KBArticleResource kbArticleResource) {
		return getPersistence().update(kbArticleResource);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static KBArticleResource update(
		KBArticleResource kbArticleResource, ServiceContext serviceContext) {
		return getPersistence().update(kbArticleResource, serviceContext);
	}

	/**
	* Returns all the k b article resources where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching k b article resources
	*/
	public static List<KBArticleResource> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<KBArticleResource> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<KBArticleResource> findByUuid(java.lang.String uuid,
		int start, int end,
		OrderByComparator<KBArticleResource> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first k b article resource in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching k b article resource
	* @throws NoSuchArticleResourceException if a matching k b article resource could not be found
	*/
	public static KBArticleResource findByUuid_First(java.lang.String uuid,
		OrderByComparator<KBArticleResource> orderByComparator)
		throws com.liferay.knowledgebase.NoSuchArticleResourceException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first k b article resource in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching k b article resource, or <code>null</code> if a matching k b article resource could not be found
	*/
	public static KBArticleResource fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<KBArticleResource> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last k b article resource in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching k b article resource
	* @throws NoSuchArticleResourceException if a matching k b article resource could not be found
	*/
	public static KBArticleResource findByUuid_Last(java.lang.String uuid,
		OrderByComparator<KBArticleResource> orderByComparator)
		throws com.liferay.knowledgebase.NoSuchArticleResourceException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last k b article resource in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching k b article resource, or <code>null</code> if a matching k b article resource could not be found
	*/
	public static KBArticleResource fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<KBArticleResource> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the k b article resources before and after the current k b article resource in the ordered set where uuid = &#63;.
	*
	* @param resourcePrimKey the primary key of the current k b article resource
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next k b article resource
	* @throws NoSuchArticleResourceException if a k b article resource with the primary key could not be found
	*/
	public static KBArticleResource[] findByUuid_PrevAndNext(
		long resourcePrimKey, java.lang.String uuid,
		OrderByComparator<KBArticleResource> orderByComparator)
		throws com.liferay.knowledgebase.NoSuchArticleResourceException {
		return getPersistence()
				   .findByUuid_PrevAndNext(resourcePrimKey, uuid,
			orderByComparator);
	}

	/**
	* Removes all the k b article resources where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of k b article resources where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching k b article resources
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the k b article resource where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchArticleResourceException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching k b article resource
	* @throws NoSuchArticleResourceException if a matching k b article resource could not be found
	*/
	public static KBArticleResource findByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.liferay.knowledgebase.NoSuchArticleResourceException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the k b article resource where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching k b article resource, or <code>null</code> if a matching k b article resource could not be found
	*/
	public static KBArticleResource fetchByUUID_G(java.lang.String uuid,
		long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the k b article resource where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching k b article resource, or <code>null</code> if a matching k b article resource could not be found
	*/
	public static KBArticleResource fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the k b article resource where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the k b article resource that was removed
	*/
	public static KBArticleResource removeByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.liferay.knowledgebase.NoSuchArticleResourceException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of k b article resources where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching k b article resources
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the k b article resources where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching k b article resources
	*/
	public static List<KBArticleResource> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static List<KBArticleResource> findByGroupId(long groupId,
		int start, int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static List<KBArticleResource> findByGroupId(long groupId,
		int start, int end,
		OrderByComparator<KBArticleResource> orderByComparator) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first k b article resource in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching k b article resource
	* @throws NoSuchArticleResourceException if a matching k b article resource could not be found
	*/
	public static KBArticleResource findByGroupId_First(long groupId,
		OrderByComparator<KBArticleResource> orderByComparator)
		throws com.liferay.knowledgebase.NoSuchArticleResourceException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first k b article resource in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching k b article resource, or <code>null</code> if a matching k b article resource could not be found
	*/
	public static KBArticleResource fetchByGroupId_First(long groupId,
		OrderByComparator<KBArticleResource> orderByComparator) {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last k b article resource in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching k b article resource
	* @throws NoSuchArticleResourceException if a matching k b article resource could not be found
	*/
	public static KBArticleResource findByGroupId_Last(long groupId,
		OrderByComparator<KBArticleResource> orderByComparator)
		throws com.liferay.knowledgebase.NoSuchArticleResourceException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last k b article resource in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching k b article resource, or <code>null</code> if a matching k b article resource could not be found
	*/
	public static KBArticleResource fetchByGroupId_Last(long groupId,
		OrderByComparator<KBArticleResource> orderByComparator) {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the k b article resources before and after the current k b article resource in the ordered set where groupId = &#63;.
	*
	* @param resourcePrimKey the primary key of the current k b article resource
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next k b article resource
	* @throws NoSuchArticleResourceException if a k b article resource with the primary key could not be found
	*/
	public static KBArticleResource[] findByGroupId_PrevAndNext(
		long resourcePrimKey, long groupId,
		OrderByComparator<KBArticleResource> orderByComparator)
		throws com.liferay.knowledgebase.NoSuchArticleResourceException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(resourcePrimKey, groupId,
			orderByComparator);
	}

	/**
	* Removes all the k b article resources where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of k b article resources where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching k b article resources
	*/
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the k b article resource where groupId = &#63; and kbArticleId = &#63; or throws a {@link NoSuchArticleResourceException} if it could not be found.
	*
	* @param groupId the group ID
	* @param kbArticleId the kb article ID
	* @return the matching k b article resource
	* @throws NoSuchArticleResourceException if a matching k b article resource could not be found
	*/
	public static KBArticleResource findByG_KBAI(long groupId,
		java.lang.String kbArticleId)
		throws com.liferay.knowledgebase.NoSuchArticleResourceException {
		return getPersistence().findByG_KBAI(groupId, kbArticleId);
	}

	/**
	* Returns the k b article resource where groupId = &#63; and kbArticleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param kbArticleId the kb article ID
	* @return the matching k b article resource, or <code>null</code> if a matching k b article resource could not be found
	*/
	public static KBArticleResource fetchByG_KBAI(long groupId,
		java.lang.String kbArticleId) {
		return getPersistence().fetchByG_KBAI(groupId, kbArticleId);
	}

	/**
	* Returns the k b article resource where groupId = &#63; and kbArticleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param kbArticleId the kb article ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching k b article resource, or <code>null</code> if a matching k b article resource could not be found
	*/
	public static KBArticleResource fetchByG_KBAI(long groupId,
		java.lang.String kbArticleId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByG_KBAI(groupId, kbArticleId, retrieveFromCache);
	}

	/**
	* Removes the k b article resource where groupId = &#63; and kbArticleId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param kbArticleId the kb article ID
	* @return the k b article resource that was removed
	*/
	public static KBArticleResource removeByG_KBAI(long groupId,
		java.lang.String kbArticleId)
		throws com.liferay.knowledgebase.NoSuchArticleResourceException {
		return getPersistence().removeByG_KBAI(groupId, kbArticleId);
	}

	/**
	* Returns the number of k b article resources where groupId = &#63; and kbArticleId = &#63;.
	*
	* @param groupId the group ID
	* @param kbArticleId the kb article ID
	* @return the number of matching k b article resources
	*/
	public static int countByG_KBAI(long groupId, java.lang.String kbArticleId) {
		return getPersistence().countByG_KBAI(groupId, kbArticleId);
	}

	/**
	* Caches the k b article resource in the entity cache if it is enabled.
	*
	* @param kbArticleResource the k b article resource
	*/
	public static void cacheResult(KBArticleResource kbArticleResource) {
		getPersistence().cacheResult(kbArticleResource);
	}

	/**
	* Caches the k b article resources in the entity cache if it is enabled.
	*
	* @param kbArticleResources the k b article resources
	*/
	public static void cacheResult(List<KBArticleResource> kbArticleResources) {
		getPersistence().cacheResult(kbArticleResources);
	}

	/**
	* Creates a new k b article resource with the primary key. Does not add the k b article resource to the database.
	*
	* @param resourcePrimKey the primary key for the new k b article resource
	* @return the new k b article resource
	*/
	public static KBArticleResource create(long resourcePrimKey) {
		return getPersistence().create(resourcePrimKey);
	}

	/**
	* Removes the k b article resource with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param resourcePrimKey the primary key of the k b article resource
	* @return the k b article resource that was removed
	* @throws NoSuchArticleResourceException if a k b article resource with the primary key could not be found
	*/
	public static KBArticleResource remove(long resourcePrimKey)
		throws com.liferay.knowledgebase.NoSuchArticleResourceException {
		return getPersistence().remove(resourcePrimKey);
	}

	public static KBArticleResource updateImpl(
		KBArticleResource kbArticleResource) {
		return getPersistence().updateImpl(kbArticleResource);
	}

	/**
	* Returns the k b article resource with the primary key or throws a {@link NoSuchArticleResourceException} if it could not be found.
	*
	* @param resourcePrimKey the primary key of the k b article resource
	* @return the k b article resource
	* @throws NoSuchArticleResourceException if a k b article resource with the primary key could not be found
	*/
	public static KBArticleResource findByPrimaryKey(long resourcePrimKey)
		throws com.liferay.knowledgebase.NoSuchArticleResourceException {
		return getPersistence().findByPrimaryKey(resourcePrimKey);
	}

	/**
	* Returns the k b article resource with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param resourcePrimKey the primary key of the k b article resource
	* @return the k b article resource, or <code>null</code> if a k b article resource with the primary key could not be found
	*/
	public static KBArticleResource fetchByPrimaryKey(long resourcePrimKey) {
		return getPersistence().fetchByPrimaryKey(resourcePrimKey);
	}

	public static java.util.Map<java.io.Serializable, KBArticleResource> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the k b article resources.
	*
	* @return the k b article resources
	*/
	public static List<KBArticleResource> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<KBArticleResource> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<KBArticleResource> findAll(int start, int end,
		OrderByComparator<KBArticleResource> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the k b article resources from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of k b article resources.
	*
	* @return the number of k b article resources
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static KBArticleResourcePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (KBArticleResourcePersistence)PortletBeanLocatorUtil.locate(com.liferay.knowledgebase.service.ClpSerializer.getServletContextName(),
					KBArticleResourcePersistence.class.getName());

			ReferenceRegistry.registerReference(KBArticleResourceUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	@Deprecated
	public void setPersistence(KBArticleResourcePersistence persistence) {
	}

	private static KBArticleResourcePersistence _persistence;
}