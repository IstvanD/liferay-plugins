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

package com.liferay.knowledgebase.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for KBArticleResource. This utility wraps
 * {@link com.liferay.knowledgebase.service.impl.KBArticleResourceLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see KBArticleResourceLocalService
 * @see com.liferay.knowledgebase.service.base.KBArticleResourceLocalServiceBaseImpl
 * @see com.liferay.knowledgebase.service.impl.KBArticleResourceLocalServiceImpl
 * @generated
 */
@ProviderType
public class KBArticleResourceLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.knowledgebase.service.impl.KBArticleResourceLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the k b article resource to the database. Also notifies the appropriate model listeners.
	*
	* @param kbArticleResource the k b article resource
	* @return the k b article resource that was added
	*/
	public static com.liferay.knowledgebase.model.KBArticleResource addKBArticleResource(
		com.liferay.knowledgebase.model.KBArticleResource kbArticleResource) {
		return getService().addKBArticleResource(kbArticleResource);
	}

	/**
	* Creates a new k b article resource with the primary key. Does not add the k b article resource to the database.
	*
	* @param resourcePrimKey the primary key for the new k b article resource
	* @return the new k b article resource
	*/
	public static com.liferay.knowledgebase.model.KBArticleResource createKBArticleResource(
		long resourcePrimKey) {
		return getService().createKBArticleResource(resourcePrimKey);
	}

	public static void deleteArticleResource(long groupId,
		java.lang.String kbArticleId)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService().deleteArticleResource(groupId, kbArticleId);
	}

	/**
	* Deletes the k b article resource from the database. Also notifies the appropriate model listeners.
	*
	* @param kbArticleResource the k b article resource
	* @return the k b article resource that was removed
	*/
	public static com.liferay.knowledgebase.model.KBArticleResource deleteKBArticleResource(
		com.liferay.knowledgebase.model.KBArticleResource kbArticleResource) {
		return getService().deleteKBArticleResource(kbArticleResource);
	}

	/**
	* Deletes the k b article resource with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param resourcePrimKey the primary key of the k b article resource
	* @return the k b article resource that was removed
	* @throws PortalException if a k b article resource with the primary key could not be found
	*/
	public static com.liferay.knowledgebase.model.KBArticleResource deleteKBArticleResource(
		long resourcePrimKey)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteKBArticleResource(resourcePrimKey);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.model.PersistedModel deletePersistedModel(
		com.liferay.portal.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.knowledgebase.model.impl.KBArticleResourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.knowledgebase.model.impl.KBArticleResourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.knowledgebase.model.KBArticleResource fetchArticleResource(
		long groupId, java.lang.String kbArticleId) {
		return getService().fetchArticleResource(groupId, kbArticleId);
	}

	public static com.liferay.knowledgebase.model.KBArticleResource fetchArticleResource(
		java.lang.String uuid, long groupId) {
		return getService().fetchArticleResource(uuid, groupId);
	}

	public static com.liferay.knowledgebase.model.KBArticleResource fetchKBArticleResource(
		long resourcePrimKey) {
		return getService().fetchKBArticleResource(resourcePrimKey);
	}

	/**
	* Returns the k b article resource matching the UUID and group.
	*
	* @param uuid the k b article resource's UUID
	* @param groupId the primary key of the group
	* @return the matching k b article resource, or <code>null</code> if a matching k b article resource could not be found
	*/
	public static com.liferay.knowledgebase.model.KBArticleResource fetchKBArticleResourceByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchKBArticleResourceByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.knowledgebase.model.KBArticleResource getArticleResource(
		long articleResourcePrimKey)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getArticleResource(articleResourcePrimKey);
	}

	public static long getArticleResourcePrimKey(long groupId,
		java.lang.String kbArticleId) {
		return getService().getArticleResourcePrimKey(groupId, kbArticleId);
	}

	public static long getArticleResourcePrimKey(java.lang.String uuid,
		long groupId, java.lang.String kbArticleId) {
		return getService().getArticleResourcePrimKey(uuid, groupId, kbArticleId);
	}

	public static java.util.List<com.liferay.knowledgebase.model.KBArticleResource> getArticleResources(
		long groupId) {
		return getService().getArticleResources(groupId);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Returns the k b article resource with the primary key.
	*
	* @param resourcePrimKey the primary key of the k b article resource
	* @return the k b article resource
	* @throws PortalException if a k b article resource with the primary key could not be found
	*/
	public static com.liferay.knowledgebase.model.KBArticleResource getKBArticleResource(
		long resourcePrimKey)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getKBArticleResource(resourcePrimKey);
	}

	/**
	* Returns the k b article resource matching the UUID and group.
	*
	* @param uuid the k b article resource's UUID
	* @param groupId the primary key of the group
	* @return the matching k b article resource
	* @throws PortalException if a matching k b article resource could not be found
	*/
	public static com.liferay.knowledgebase.model.KBArticleResource getKBArticleResourceByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getKBArticleResourceByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the k b article resources.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.knowledgebase.model.impl.KBArticleResourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of k b article resources
	* @param end the upper bound of the range of k b article resources (not inclusive)
	* @return the range of k b article resources
	*/
	public static java.util.List<com.liferay.knowledgebase.model.KBArticleResource> getKBArticleResources(
		int start, int end) {
		return getService().getKBArticleResources(start, end);
	}

	/**
	* Returns the number of k b article resources.
	*
	* @return the number of k b article resources
	*/
	public static int getKBArticleResourcesCount() {
		return getService().getKBArticleResourcesCount();
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	/**
	* Updates the k b article resource in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param kbArticleResource the k b article resource
	* @return the k b article resource that was updated
	*/
	public static com.liferay.knowledgebase.model.KBArticleResource updateKBArticleResource(
		com.liferay.knowledgebase.model.KBArticleResource kbArticleResource) {
		return getService().updateKBArticleResource(kbArticleResource);
	}

	public static void clearService() {
		_service = null;
	}

	public static KBArticleResourceLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					KBArticleResourceLocalService.class.getName());

			if (invokableLocalService instanceof KBArticleResourceLocalService) {
				_service = (KBArticleResourceLocalService)invokableLocalService;
			}
			else {
				_service = new KBArticleResourceLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(KBArticleResourceLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	@Deprecated
	public void setService(KBArticleResourceLocalService service) {
	}

	private static KBArticleResourceLocalService _service;
}