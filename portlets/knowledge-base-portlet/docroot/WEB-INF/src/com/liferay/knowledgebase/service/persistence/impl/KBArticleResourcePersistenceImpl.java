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

package com.liferay.knowledgebase.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.knowledgebase.NoSuchArticleResourceException;
import com.liferay.knowledgebase.model.KBArticleResource;
import com.liferay.knowledgebase.model.impl.KBArticleResourceImpl;
import com.liferay.knowledgebase.model.impl.KBArticleResourceModelImpl;
import com.liferay.knowledgebase.service.persistence.KBArticleResourcePersistence;

import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the k b article resource service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KBArticleResourcePersistence
 * @see com.liferay.knowledgebase.service.persistence.KBArticleResourceUtil
 * @generated
 */
@ProviderType
public class KBArticleResourcePersistenceImpl extends BasePersistenceImpl<KBArticleResource>
	implements KBArticleResourcePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link KBArticleResourceUtil} to access the k b article resource persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = KBArticleResourceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(KBArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
			KBArticleResourceModelImpl.FINDER_CACHE_ENABLED,
			KBArticleResourceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(KBArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
			KBArticleResourceModelImpl.FINDER_CACHE_ENABLED,
			KBArticleResourceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(KBArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
			KBArticleResourceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(KBArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
			KBArticleResourceModelImpl.FINDER_CACHE_ENABLED,
			KBArticleResourceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(KBArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
			KBArticleResourceModelImpl.FINDER_CACHE_ENABLED,
			KBArticleResourceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			KBArticleResourceModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(KBArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
			KBArticleResourceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the k b article resources where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching k b article resources
	 */
	@Override
	public List<KBArticleResource> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<KBArticleResource> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<KBArticleResource> findByUuid(String uuid, int start, int end,
		OrderByComparator<KBArticleResource> orderByComparator) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<KBArticleResource> list = (List<KBArticleResource>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (KBArticleResource kbArticleResource : list) {
				if (!Validator.equals(uuid, kbArticleResource.getUuid())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_KBARTICLERESOURCE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(KBArticleResourceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<KBArticleResource>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<KBArticleResource>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first k b article resource in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching k b article resource
	 * @throws NoSuchArticleResourceException if a matching k b article resource could not be found
	 */
	@Override
	public KBArticleResource findByUuid_First(String uuid,
		OrderByComparator<KBArticleResource> orderByComparator)
		throws NoSuchArticleResourceException {
		KBArticleResource kbArticleResource = fetchByUuid_First(uuid,
				orderByComparator);

		if (kbArticleResource != null) {
			return kbArticleResource;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticleResourceException(msg.toString());
	}

	/**
	 * Returns the first k b article resource in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching k b article resource, or <code>null</code> if a matching k b article resource could not be found
	 */
	@Override
	public KBArticleResource fetchByUuid_First(String uuid,
		OrderByComparator<KBArticleResource> orderByComparator) {
		List<KBArticleResource> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last k b article resource in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching k b article resource
	 * @throws NoSuchArticleResourceException if a matching k b article resource could not be found
	 */
	@Override
	public KBArticleResource findByUuid_Last(String uuid,
		OrderByComparator<KBArticleResource> orderByComparator)
		throws NoSuchArticleResourceException {
		KBArticleResource kbArticleResource = fetchByUuid_Last(uuid,
				orderByComparator);

		if (kbArticleResource != null) {
			return kbArticleResource;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticleResourceException(msg.toString());
	}

	/**
	 * Returns the last k b article resource in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching k b article resource, or <code>null</code> if a matching k b article resource could not be found
	 */
	@Override
	public KBArticleResource fetchByUuid_Last(String uuid,
		OrderByComparator<KBArticleResource> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<KBArticleResource> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public KBArticleResource[] findByUuid_PrevAndNext(long resourcePrimKey,
		String uuid, OrderByComparator<KBArticleResource> orderByComparator)
		throws NoSuchArticleResourceException {
		KBArticleResource kbArticleResource = findByPrimaryKey(resourcePrimKey);

		Session session = null;

		try {
			session = openSession();

			KBArticleResource[] array = new KBArticleResourceImpl[3];

			array[0] = getByUuid_PrevAndNext(session, kbArticleResource, uuid,
					orderByComparator, true);

			array[1] = kbArticleResource;

			array[2] = getByUuid_PrevAndNext(session, kbArticleResource, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected KBArticleResource getByUuid_PrevAndNext(Session session,
		KBArticleResource kbArticleResource, String uuid,
		OrderByComparator<KBArticleResource> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_KBARTICLERESOURCE_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(KBArticleResourceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(kbArticleResource);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<KBArticleResource> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the k b article resources where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (KBArticleResource kbArticleResource : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(kbArticleResource);
		}
	}

	/**
	 * Returns the number of k b article resources where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching k b article resources
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_KBARTICLERESOURCE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "kbArticleResource.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "kbArticleResource.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(kbArticleResource.uuid IS NULL OR kbArticleResource.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(KBArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
			KBArticleResourceModelImpl.FINDER_CACHE_ENABLED,
			KBArticleResourceImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			KBArticleResourceModelImpl.UUID_COLUMN_BITMASK |
			KBArticleResourceModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(KBArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
			KBArticleResourceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the k b article resource where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchArticleResourceException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching k b article resource
	 * @throws NoSuchArticleResourceException if a matching k b article resource could not be found
	 */
	@Override
	public KBArticleResource findByUUID_G(String uuid, long groupId)
		throws NoSuchArticleResourceException {
		KBArticleResource kbArticleResource = fetchByUUID_G(uuid, groupId);

		if (kbArticleResource == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchArticleResourceException(msg.toString());
		}

		return kbArticleResource;
	}

	/**
	 * Returns the k b article resource where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching k b article resource, or <code>null</code> if a matching k b article resource could not be found
	 */
	@Override
	public KBArticleResource fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the k b article resource where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching k b article resource, or <code>null</code> if a matching k b article resource could not be found
	 */
	@Override
	public KBArticleResource fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof KBArticleResource) {
			KBArticleResource kbArticleResource = (KBArticleResource)result;

			if (!Validator.equals(uuid, kbArticleResource.getUuid()) ||
					(groupId != kbArticleResource.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_KBARTICLERESOURCE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<KBArticleResource> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					KBArticleResource kbArticleResource = list.get(0);

					result = kbArticleResource;

					cacheResult(kbArticleResource);

					if ((kbArticleResource.getUuid() == null) ||
							!kbArticleResource.getUuid().equals(uuid) ||
							(kbArticleResource.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, kbArticleResource);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (KBArticleResource)result;
		}
	}

	/**
	 * Removes the k b article resource where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the k b article resource that was removed
	 */
	@Override
	public KBArticleResource removeByUUID_G(String uuid, long groupId)
		throws NoSuchArticleResourceException {
		KBArticleResource kbArticleResource = findByUUID_G(uuid, groupId);

		return remove(kbArticleResource);
	}

	/**
	 * Returns the number of k b article resources where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching k b article resources
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_KBARTICLERESOURCE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "kbArticleResource.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "kbArticleResource.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(kbArticleResource.uuid IS NULL OR kbArticleResource.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "kbArticleResource.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(KBArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
			KBArticleResourceModelImpl.FINDER_CACHE_ENABLED,
			KBArticleResourceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(KBArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
			KBArticleResourceModelImpl.FINDER_CACHE_ENABLED,
			KBArticleResourceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			KBArticleResourceModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(KBArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
			KBArticleResourceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the k b article resources where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching k b article resources
	 */
	@Override
	public List<KBArticleResource> findByGroupId(long groupId) {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<KBArticleResource> findByGroupId(long groupId, int start,
		int end) {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<KBArticleResource> findByGroupId(long groupId, int start,
		int end, OrderByComparator<KBArticleResource> orderByComparator) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<KBArticleResource> list = (List<KBArticleResource>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (KBArticleResource kbArticleResource : list) {
				if ((groupId != kbArticleResource.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_KBARTICLERESOURCE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(KBArticleResourceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<KBArticleResource>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<KBArticleResource>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first k b article resource in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching k b article resource
	 * @throws NoSuchArticleResourceException if a matching k b article resource could not be found
	 */
	@Override
	public KBArticleResource findByGroupId_First(long groupId,
		OrderByComparator<KBArticleResource> orderByComparator)
		throws NoSuchArticleResourceException {
		KBArticleResource kbArticleResource = fetchByGroupId_First(groupId,
				orderByComparator);

		if (kbArticleResource != null) {
			return kbArticleResource;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticleResourceException(msg.toString());
	}

	/**
	 * Returns the first k b article resource in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching k b article resource, or <code>null</code> if a matching k b article resource could not be found
	 */
	@Override
	public KBArticleResource fetchByGroupId_First(long groupId,
		OrderByComparator<KBArticleResource> orderByComparator) {
		List<KBArticleResource> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last k b article resource in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching k b article resource
	 * @throws NoSuchArticleResourceException if a matching k b article resource could not be found
	 */
	@Override
	public KBArticleResource findByGroupId_Last(long groupId,
		OrderByComparator<KBArticleResource> orderByComparator)
		throws NoSuchArticleResourceException {
		KBArticleResource kbArticleResource = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (kbArticleResource != null) {
			return kbArticleResource;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticleResourceException(msg.toString());
	}

	/**
	 * Returns the last k b article resource in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching k b article resource, or <code>null</code> if a matching k b article resource could not be found
	 */
	@Override
	public KBArticleResource fetchByGroupId_Last(long groupId,
		OrderByComparator<KBArticleResource> orderByComparator) {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<KBArticleResource> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public KBArticleResource[] findByGroupId_PrevAndNext(long resourcePrimKey,
		long groupId, OrderByComparator<KBArticleResource> orderByComparator)
		throws NoSuchArticleResourceException {
		KBArticleResource kbArticleResource = findByPrimaryKey(resourcePrimKey);

		Session session = null;

		try {
			session = openSession();

			KBArticleResource[] array = new KBArticleResourceImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, kbArticleResource,
					groupId, orderByComparator, true);

			array[1] = kbArticleResource;

			array[2] = getByGroupId_PrevAndNext(session, kbArticleResource,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected KBArticleResource getByGroupId_PrevAndNext(Session session,
		KBArticleResource kbArticleResource, long groupId,
		OrderByComparator<KBArticleResource> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_KBARTICLERESOURCE_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(KBArticleResourceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(kbArticleResource);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<KBArticleResource> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the k b article resources where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (KBArticleResource kbArticleResource : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(kbArticleResource);
		}
	}

	/**
	 * Returns the number of k b article resources where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching k b article resources
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_KBARTICLERESOURCE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "kbArticleResource.groupId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_G_KBAI = new FinderPath(KBArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
			KBArticleResourceModelImpl.FINDER_CACHE_ENABLED,
			KBArticleResourceImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByG_KBAI",
			new String[] { Long.class.getName(), String.class.getName() },
			KBArticleResourceModelImpl.GROUPID_COLUMN_BITMASK |
			KBArticleResourceModelImpl.KBARTICLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_KBAI = new FinderPath(KBArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
			KBArticleResourceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_KBAI",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the k b article resource where groupId = &#63; and kbArticleId = &#63; or throws a {@link NoSuchArticleResourceException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param kbArticleId the kb article ID
	 * @return the matching k b article resource
	 * @throws NoSuchArticleResourceException if a matching k b article resource could not be found
	 */
	@Override
	public KBArticleResource findByG_KBAI(long groupId, String kbArticleId)
		throws NoSuchArticleResourceException {
		KBArticleResource kbArticleResource = fetchByG_KBAI(groupId, kbArticleId);

		if (kbArticleResource == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", kbArticleId=");
			msg.append(kbArticleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchArticleResourceException(msg.toString());
		}

		return kbArticleResource;
	}

	/**
	 * Returns the k b article resource where groupId = &#63; and kbArticleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param kbArticleId the kb article ID
	 * @return the matching k b article resource, or <code>null</code> if a matching k b article resource could not be found
	 */
	@Override
	public KBArticleResource fetchByG_KBAI(long groupId, String kbArticleId) {
		return fetchByG_KBAI(groupId, kbArticleId, true);
	}

	/**
	 * Returns the k b article resource where groupId = &#63; and kbArticleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param kbArticleId the kb article ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching k b article resource, or <code>null</code> if a matching k b article resource could not be found
	 */
	@Override
	public KBArticleResource fetchByG_KBAI(long groupId, String kbArticleId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { groupId, kbArticleId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_G_KBAI,
					finderArgs, this);
		}

		if (result instanceof KBArticleResource) {
			KBArticleResource kbArticleResource = (KBArticleResource)result;

			if ((groupId != kbArticleResource.getGroupId()) ||
					!Validator.equals(kbArticleId,
						kbArticleResource.getKbArticleId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_KBARTICLERESOURCE_WHERE);

			query.append(_FINDER_COLUMN_G_KBAI_GROUPID_2);

			boolean bindKbArticleId = false;

			if (kbArticleId == null) {
				query.append(_FINDER_COLUMN_G_KBAI_KBARTICLEID_1);
			}
			else if (kbArticleId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_KBAI_KBARTICLEID_3);
			}
			else {
				bindKbArticleId = true;

				query.append(_FINDER_COLUMN_G_KBAI_KBARTICLEID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindKbArticleId) {
					qPos.add(kbArticleId);
				}

				List<KBArticleResource> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_KBAI,
						finderArgs, list);
				}
				else {
					KBArticleResource kbArticleResource = list.get(0);

					result = kbArticleResource;

					cacheResult(kbArticleResource);

					if ((kbArticleResource.getGroupId() != groupId) ||
							(kbArticleResource.getKbArticleId() == null) ||
							!kbArticleResource.getKbArticleId()
												  .equals(kbArticleId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_KBAI,
							finderArgs, kbArticleResource);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_KBAI,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (KBArticleResource)result;
		}
	}

	/**
	 * Removes the k b article resource where groupId = &#63; and kbArticleId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param kbArticleId the kb article ID
	 * @return the k b article resource that was removed
	 */
	@Override
	public KBArticleResource removeByG_KBAI(long groupId, String kbArticleId)
		throws NoSuchArticleResourceException {
		KBArticleResource kbArticleResource = findByG_KBAI(groupId, kbArticleId);

		return remove(kbArticleResource);
	}

	/**
	 * Returns the number of k b article resources where groupId = &#63; and kbArticleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param kbArticleId the kb article ID
	 * @return the number of matching k b article resources
	 */
	@Override
	public int countByG_KBAI(long groupId, String kbArticleId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_KBAI;

		Object[] finderArgs = new Object[] { groupId, kbArticleId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_KBARTICLERESOURCE_WHERE);

			query.append(_FINDER_COLUMN_G_KBAI_GROUPID_2);

			boolean bindKbArticleId = false;

			if (kbArticleId == null) {
				query.append(_FINDER_COLUMN_G_KBAI_KBARTICLEID_1);
			}
			else if (kbArticleId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_KBAI_KBARTICLEID_3);
			}
			else {
				bindKbArticleId = true;

				query.append(_FINDER_COLUMN_G_KBAI_KBARTICLEID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindKbArticleId) {
					qPos.add(kbArticleId);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_KBAI_GROUPID_2 = "kbArticleResource.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_KBAI_KBARTICLEID_1 = "kbArticleResource.kbArticleId IS NULL";
	private static final String _FINDER_COLUMN_G_KBAI_KBARTICLEID_2 = "kbArticleResource.kbArticleId = ?";
	private static final String _FINDER_COLUMN_G_KBAI_KBARTICLEID_3 = "(kbArticleResource.kbArticleId IS NULL OR kbArticleResource.kbArticleId = '')";

	public KBArticleResourcePersistenceImpl() {
		setModelClass(KBArticleResource.class);
	}

	/**
	 * Caches the k b article resource in the entity cache if it is enabled.
	 *
	 * @param kbArticleResource the k b article resource
	 */
	@Override
	public void cacheResult(KBArticleResource kbArticleResource) {
		EntityCacheUtil.putResult(KBArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
			KBArticleResourceImpl.class, kbArticleResource.getPrimaryKey(),
			kbArticleResource);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				kbArticleResource.getUuid(), kbArticleResource.getGroupId()
			}, kbArticleResource);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_KBAI,
			new Object[] {
				kbArticleResource.getGroupId(),
				kbArticleResource.getKbArticleId()
			}, kbArticleResource);

		kbArticleResource.resetOriginalValues();
	}

	/**
	 * Caches the k b article resources in the entity cache if it is enabled.
	 *
	 * @param kbArticleResources the k b article resources
	 */
	@Override
	public void cacheResult(List<KBArticleResource> kbArticleResources) {
		for (KBArticleResource kbArticleResource : kbArticleResources) {
			if (EntityCacheUtil.getResult(
						KBArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
						KBArticleResourceImpl.class,
						kbArticleResource.getPrimaryKey()) == null) {
				cacheResult(kbArticleResource);
			}
			else {
				kbArticleResource.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all k b article resources.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		EntityCacheUtil.clearCache(KBArticleResourceImpl.class);

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the k b article resource.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(KBArticleResource kbArticleResource) {
		EntityCacheUtil.removeResult(KBArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
			KBArticleResourceImpl.class, kbArticleResource.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(kbArticleResource);
	}

	@Override
	public void clearCache(List<KBArticleResource> kbArticleResources) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (KBArticleResource kbArticleResource : kbArticleResources) {
			EntityCacheUtil.removeResult(KBArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
				KBArticleResourceImpl.class, kbArticleResource.getPrimaryKey());

			clearUniqueFindersCache(kbArticleResource);
		}
	}

	protected void cacheUniqueFindersCache(
		KBArticleResource kbArticleResource, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					kbArticleResource.getUuid(), kbArticleResource.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				kbArticleResource);

			args = new Object[] {
					kbArticleResource.getGroupId(),
					kbArticleResource.getKbArticleId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_KBAI, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_KBAI, args,
				kbArticleResource);
		}
		else {
			KBArticleResourceModelImpl kbArticleResourceModelImpl = (KBArticleResourceModelImpl)kbArticleResource;

			if ((kbArticleResourceModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						kbArticleResource.getUuid(),
						kbArticleResource.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					kbArticleResource);
			}

			if ((kbArticleResourceModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_G_KBAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						kbArticleResource.getGroupId(),
						kbArticleResource.getKbArticleId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_KBAI, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_KBAI, args,
					kbArticleResource);
			}
		}
	}

	protected void clearUniqueFindersCache(KBArticleResource kbArticleResource) {
		KBArticleResourceModelImpl kbArticleResourceModelImpl = (KBArticleResourceModelImpl)kbArticleResource;

		Object[] args = new Object[] {
				kbArticleResource.getUuid(), kbArticleResource.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((kbArticleResourceModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					kbArticleResourceModelImpl.getOriginalUuid(),
					kbArticleResourceModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				kbArticleResource.getGroupId(),
				kbArticleResource.getKbArticleId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_KBAI, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_KBAI, args);

		if ((kbArticleResourceModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_G_KBAI.getColumnBitmask()) != 0) {
			args = new Object[] {
					kbArticleResourceModelImpl.getOriginalGroupId(),
					kbArticleResourceModelImpl.getOriginalKbArticleId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_KBAI, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_KBAI, args);
		}
	}

	/**
	 * Creates a new k b article resource with the primary key. Does not add the k b article resource to the database.
	 *
	 * @param resourcePrimKey the primary key for the new k b article resource
	 * @return the new k b article resource
	 */
	@Override
	public KBArticleResource create(long resourcePrimKey) {
		KBArticleResource kbArticleResource = new KBArticleResourceImpl();

		kbArticleResource.setNew(true);
		kbArticleResource.setPrimaryKey(resourcePrimKey);

		String uuid = PortalUUIDUtil.generate();

		kbArticleResource.setUuid(uuid);

		return kbArticleResource;
	}

	/**
	 * Removes the k b article resource with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param resourcePrimKey the primary key of the k b article resource
	 * @return the k b article resource that was removed
	 * @throws NoSuchArticleResourceException if a k b article resource with the primary key could not be found
	 */
	@Override
	public KBArticleResource remove(long resourcePrimKey)
		throws NoSuchArticleResourceException {
		return remove((Serializable)resourcePrimKey);
	}

	/**
	 * Removes the k b article resource with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the k b article resource
	 * @return the k b article resource that was removed
	 * @throws NoSuchArticleResourceException if a k b article resource with the primary key could not be found
	 */
	@Override
	public KBArticleResource remove(Serializable primaryKey)
		throws NoSuchArticleResourceException {
		Session session = null;

		try {
			session = openSession();

			KBArticleResource kbArticleResource = (KBArticleResource)session.get(KBArticleResourceImpl.class,
					primaryKey);

			if (kbArticleResource == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchArticleResourceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(kbArticleResource);
		}
		catch (NoSuchArticleResourceException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected KBArticleResource removeImpl(KBArticleResource kbArticleResource) {
		kbArticleResource = toUnwrappedModel(kbArticleResource);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(kbArticleResource)) {
				kbArticleResource = (KBArticleResource)session.get(KBArticleResourceImpl.class,
						kbArticleResource.getPrimaryKeyObj());
			}

			if (kbArticleResource != null) {
				session.delete(kbArticleResource);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (kbArticleResource != null) {
			clearCache(kbArticleResource);
		}

		return kbArticleResource;
	}

	@Override
	public KBArticleResource updateImpl(KBArticleResource kbArticleResource) {
		kbArticleResource = toUnwrappedModel(kbArticleResource);

		boolean isNew = kbArticleResource.isNew();

		KBArticleResourceModelImpl kbArticleResourceModelImpl = (KBArticleResourceModelImpl)kbArticleResource;

		if (Validator.isNull(kbArticleResource.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			kbArticleResource.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (kbArticleResource.isNew()) {
				session.save(kbArticleResource);

				kbArticleResource.setNew(false);
			}
			else {
				session.merge(kbArticleResource);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !KBArticleResourceModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((kbArticleResourceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						kbArticleResourceModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { kbArticleResourceModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((kbArticleResourceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						kbArticleResourceModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { kbArticleResourceModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(KBArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
			KBArticleResourceImpl.class, kbArticleResource.getPrimaryKey(),
			kbArticleResource, false);

		clearUniqueFindersCache(kbArticleResource);
		cacheUniqueFindersCache(kbArticleResource, isNew);

		kbArticleResource.resetOriginalValues();

		return kbArticleResource;
	}

	protected KBArticleResource toUnwrappedModel(
		KBArticleResource kbArticleResource) {
		if (kbArticleResource instanceof KBArticleResourceImpl) {
			return kbArticleResource;
		}

		KBArticleResourceImpl kbArticleResourceImpl = new KBArticleResourceImpl();

		kbArticleResourceImpl.setNew(kbArticleResource.isNew());
		kbArticleResourceImpl.setPrimaryKey(kbArticleResource.getPrimaryKey());

		kbArticleResourceImpl.setUuid(kbArticleResource.getUuid());
		kbArticleResourceImpl.setResourcePrimKey(kbArticleResource.getResourcePrimKey());
		kbArticleResourceImpl.setGroupId(kbArticleResource.getGroupId());
		kbArticleResourceImpl.setKbArticleId(kbArticleResource.getKbArticleId());

		return kbArticleResourceImpl;
	}

	/**
	 * Returns the k b article resource with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the k b article resource
	 * @return the k b article resource
	 * @throws NoSuchArticleResourceException if a k b article resource with the primary key could not be found
	 */
	@Override
	public KBArticleResource findByPrimaryKey(Serializable primaryKey)
		throws NoSuchArticleResourceException {
		KBArticleResource kbArticleResource = fetchByPrimaryKey(primaryKey);

		if (kbArticleResource == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchArticleResourceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return kbArticleResource;
	}

	/**
	 * Returns the k b article resource with the primary key or throws a {@link NoSuchArticleResourceException} if it could not be found.
	 *
	 * @param resourcePrimKey the primary key of the k b article resource
	 * @return the k b article resource
	 * @throws NoSuchArticleResourceException if a k b article resource with the primary key could not be found
	 */
	@Override
	public KBArticleResource findByPrimaryKey(long resourcePrimKey)
		throws NoSuchArticleResourceException {
		return findByPrimaryKey((Serializable)resourcePrimKey);
	}

	/**
	 * Returns the k b article resource with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the k b article resource
	 * @return the k b article resource, or <code>null</code> if a k b article resource with the primary key could not be found
	 */
	@Override
	public KBArticleResource fetchByPrimaryKey(Serializable primaryKey) {
		KBArticleResource kbArticleResource = (KBArticleResource)EntityCacheUtil.getResult(KBArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
				KBArticleResourceImpl.class, primaryKey);

		if (kbArticleResource == _nullKBArticleResource) {
			return null;
		}

		if (kbArticleResource == null) {
			Session session = null;

			try {
				session = openSession();

				kbArticleResource = (KBArticleResource)session.get(KBArticleResourceImpl.class,
						primaryKey);

				if (kbArticleResource != null) {
					cacheResult(kbArticleResource);
				}
				else {
					EntityCacheUtil.putResult(KBArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
						KBArticleResourceImpl.class, primaryKey,
						_nullKBArticleResource);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(KBArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
					KBArticleResourceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return kbArticleResource;
	}

	/**
	 * Returns the k b article resource with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param resourcePrimKey the primary key of the k b article resource
	 * @return the k b article resource, or <code>null</code> if a k b article resource with the primary key could not be found
	 */
	@Override
	public KBArticleResource fetchByPrimaryKey(long resourcePrimKey) {
		return fetchByPrimaryKey((Serializable)resourcePrimKey);
	}

	@Override
	public Map<Serializable, KBArticleResource> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, KBArticleResource> map = new HashMap<Serializable, KBArticleResource>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			KBArticleResource kbArticleResource = fetchByPrimaryKey(primaryKey);

			if (kbArticleResource != null) {
				map.put(primaryKey, kbArticleResource);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			KBArticleResource kbArticleResource = (KBArticleResource)EntityCacheUtil.getResult(KBArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
					KBArticleResourceImpl.class, primaryKey);

			if (kbArticleResource == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, kbArticleResource);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_KBARTICLERESOURCE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (KBArticleResource kbArticleResource : (List<KBArticleResource>)q.list()) {
				map.put(kbArticleResource.getPrimaryKeyObj(), kbArticleResource);

				cacheResult(kbArticleResource);

				uncachedPrimaryKeys.remove(kbArticleResource.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				EntityCacheUtil.putResult(KBArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
					KBArticleResourceImpl.class, primaryKey,
					_nullKBArticleResource);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the k b article resources.
	 *
	 * @return the k b article resources
	 */
	@Override
	public List<KBArticleResource> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<KBArticleResource> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<KBArticleResource> findAll(int start, int end,
		OrderByComparator<KBArticleResource> orderByComparator) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<KBArticleResource> list = (List<KBArticleResource>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_KBARTICLERESOURCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_KBARTICLERESOURCE;

				if (pagination) {
					sql = sql.concat(KBArticleResourceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<KBArticleResource>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<KBArticleResource>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the k b article resources from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (KBArticleResource kbArticleResource : findAll()) {
			remove(kbArticleResource);
		}
	}

	/**
	 * Returns the number of k b article resources.
	 *
	 * @return the number of k b article resources
	 */
	@Override
	public int countAll() {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_KBARTICLERESOURCE);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return KBArticleResourceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the k b article resource persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		EntityCacheUtil.removeCache(KBArticleResourceImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_KBARTICLERESOURCE = "SELECT kbArticleResource FROM KBArticleResource kbArticleResource";
	private static final String _SQL_SELECT_KBARTICLERESOURCE_WHERE_PKS_IN = "SELECT kbArticleResource FROM KBArticleResource kbArticleResource WHERE resourcePrimKey IN (";
	private static final String _SQL_SELECT_KBARTICLERESOURCE_WHERE = "SELECT kbArticleResource FROM KBArticleResource kbArticleResource WHERE ";
	private static final String _SQL_COUNT_KBARTICLERESOURCE = "SELECT COUNT(kbArticleResource) FROM KBArticleResource kbArticleResource";
	private static final String _SQL_COUNT_KBARTICLERESOURCE_WHERE = "SELECT COUNT(kbArticleResource) FROM KBArticleResource kbArticleResource WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "kbArticleResource.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No KBArticleResource exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No KBArticleResource exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(KBArticleResourcePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static final KBArticleResource _nullKBArticleResource = new KBArticleResourceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<KBArticleResource> toCacheModel() {
				return _nullKBArticleResourceCacheModel;
			}
		};

	private static final CacheModel<KBArticleResource> _nullKBArticleResourceCacheModel =
		new CacheModel<KBArticleResource>() {
			@Override
			public KBArticleResource toEntityModel() {
				return _nullKBArticleResource;
			}
		};
}