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

package com.liferay.knowledgebase.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.knowledgebase.model.KBFolder;
import com.liferay.knowledgebase.service.KBFolderLocalService;
import com.liferay.knowledgebase.service.persistence.KBArticleFinder;
import com.liferay.knowledgebase.service.persistence.KBArticlePersistence;
import com.liferay.knowledgebase.service.persistence.KBArticleResourcePersistence;
import com.liferay.knowledgebase.service.persistence.KBCommentPersistence;
import com.liferay.knowledgebase.service.persistence.KBFolderPersistence;
import com.liferay.knowledgebase.service.persistence.KBTemplatePersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.ClassNamePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.exportimport.lar.ExportImportHelperUtil;
import com.liferay.portlet.exportimport.lar.ManifestSummary;
import com.liferay.portlet.exportimport.lar.PortletDataContext;
import com.liferay.portlet.exportimport.lar.StagedModelDataHandlerUtil;
import com.liferay.portlet.exportimport.lar.StagedModelType;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the k b folder local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.knowledgebase.service.impl.KBFolderLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.knowledgebase.service.impl.KBFolderLocalServiceImpl
 * @see com.liferay.knowledgebase.service.KBFolderLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class KBFolderLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements KBFolderLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.knowledgebase.service.KBFolderLocalServiceUtil} to access the k b folder local service.
	 */

	/**
	 * Adds the k b folder to the database. Also notifies the appropriate model listeners.
	 *
	 * @param kbFolder the k b folder
	 * @return the k b folder that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public KBFolder addKBFolder(KBFolder kbFolder) {
		kbFolder.setNew(true);

		return kbFolderPersistence.update(kbFolder);
	}

	/**
	 * Creates a new k b folder with the primary key. Does not add the k b folder to the database.
	 *
	 * @param kbFolderId the primary key for the new k b folder
	 * @return the new k b folder
	 */
	@Override
	public KBFolder createKBFolder(long kbFolderId) {
		return kbFolderPersistence.create(kbFolderId);
	}

	/**
	 * Deletes the k b folder with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param kbFolderId the primary key of the k b folder
	 * @return the k b folder that was removed
	 * @throws PortalException if a k b folder with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public KBFolder deleteKBFolder(long kbFolderId) throws PortalException {
		return kbFolderPersistence.remove(kbFolderId);
	}

	/**
	 * Deletes the k b folder from the database. Also notifies the appropriate model listeners.
	 *
	 * @param kbFolder the k b folder
	 * @return the k b folder that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public KBFolder deleteKBFolder(KBFolder kbFolder) {
		return kbFolderPersistence.remove(kbFolder);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(KBFolder.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return kbFolderPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.knowledgebase.model.impl.KBFolderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return kbFolderPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.knowledgebase.model.impl.KBFolderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return kbFolderPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return kbFolderPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return kbFolderPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public KBFolder fetchKBFolder(long kbFolderId) {
		return kbFolderPersistence.fetchByPrimaryKey(kbFolderId);
	}

	/**
	 * Returns the k b folder matching the UUID and group.
	 *
	 * @param uuid the k b folder's UUID
	 * @param groupId the primary key of the group
	 * @return the matching k b folder, or <code>null</code> if a matching k b folder could not be found
	 */
	@Override
	public KBFolder fetchKBFolderByUuidAndGroupId(String uuid, long groupId) {
		return kbFolderPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the k b folder with the primary key.
	 *
	 * @param kbFolderId the primary key of the k b folder
	 * @return the k b folder
	 * @throws PortalException if a k b folder with the primary key could not be found
	 */
	@Override
	public KBFolder getKBFolder(long kbFolderId) throws PortalException {
		return kbFolderPersistence.findByPrimaryKey(kbFolderId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(com.liferay.knowledgebase.service.KBFolderLocalServiceUtil.getService());
		actionableDynamicQuery.setClass(KBFolder.class);
		actionableDynamicQuery.setClassLoader(getClassLoader());

		actionableDynamicQuery.setPrimaryKeyPropertyName("kbFolderId");

		return actionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(com.liferay.knowledgebase.service.KBFolderLocalServiceUtil.getService());
		actionableDynamicQuery.setClass(KBFolder.class);
		actionableDynamicQuery.setClassLoader(getClassLoader());

		actionableDynamicQuery.setPrimaryKeyPropertyName("kbFolderId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {
		final ExportActionableDynamicQuery exportActionableDynamicQuery = new ExportActionableDynamicQuery() {
				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary = portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(stagedModelType.toString(),
						modelAdditionCount);

					long modelDeletionCount = ExportImportHelperUtil.getModelDeletionCount(portletDataContext,
							stagedModelType);

					manifestSummary.addModelDeletionCount(stagedModelType.toString(),
						modelDeletionCount);

					return modelAdditionCount;
				}
			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(new ActionableDynamicQuery.AddCriteriaMethod() {
				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(dynamicQuery,
						"modifiedDate");
				}
			});

		exportActionableDynamicQuery.setCompanyId(portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setGroupId(portletDataContext.getScopeGroupId());

		exportActionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod() {
				@Override
				public void performAction(Object object)
					throws PortalException {
					KBFolder stagedModel = (KBFolder)object;

					StagedModelDataHandlerUtil.exportStagedModel(portletDataContext,
						stagedModel);
				}
			});
		exportActionableDynamicQuery.setStagedModelType(new StagedModelType(
				PortalUtil.getClassNameId(KBFolder.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return kbFolderLocalService.deleteKBFolder((KBFolder)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return kbFolderPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the k b folders matching the UUID and company.
	 *
	 * @param uuid the UUID of the k b folders
	 * @param companyId the primary key of the company
	 * @return the matching k b folders, or an empty list if no matches were found
	 */
	@Override
	public List<KBFolder> getKBFoldersByUuidAndCompanyId(String uuid,
		long companyId) {
		return kbFolderPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of k b folders matching the UUID and company.
	 *
	 * @param uuid the UUID of the k b folders
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of k b folders
	 * @param end the upper bound of the range of k b folders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching k b folders, or an empty list if no matches were found
	 */
	@Override
	public List<KBFolder> getKBFoldersByUuidAndCompanyId(String uuid,
		long companyId, int start, int end,
		OrderByComparator<KBFolder> orderByComparator) {
		return kbFolderPersistence.findByUuid_C(uuid, companyId, start, end,
			orderByComparator);
	}

	/**
	 * Returns the k b folder matching the UUID and group.
	 *
	 * @param uuid the k b folder's UUID
	 * @param groupId the primary key of the group
	 * @return the matching k b folder
	 * @throws PortalException if a matching k b folder could not be found
	 */
	@Override
	public KBFolder getKBFolderByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {
		return kbFolderPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the k b folders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.knowledgebase.model.impl.KBFolderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of k b folders
	 * @param end the upper bound of the range of k b folders (not inclusive)
	 * @return the range of k b folders
	 */
	@Override
	public List<KBFolder> getKBFolders(int start, int end) {
		return kbFolderPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of k b folders.
	 *
	 * @return the number of k b folders
	 */
	@Override
	public int getKBFoldersCount() {
		return kbFolderPersistence.countAll();
	}

	/**
	 * Updates the k b folder in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param kbFolder the k b folder
	 * @return the k b folder that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public KBFolder updateKBFolder(KBFolder kbFolder) {
		return kbFolderPersistence.update(kbFolder);
	}

	/**
	 * Returns the k b article local service.
	 *
	 * @return the k b article local service
	 */
	public com.liferay.knowledgebase.service.KBArticleLocalService getKBArticleLocalService() {
		return kbArticleLocalService;
	}

	/**
	 * Sets the k b article local service.
	 *
	 * @param kbArticleLocalService the k b article local service
	 */
	public void setKBArticleLocalService(
		com.liferay.knowledgebase.service.KBArticleLocalService kbArticleLocalService) {
		this.kbArticleLocalService = kbArticleLocalService;
	}

	/**
	 * Returns the k b article remote service.
	 *
	 * @return the k b article remote service
	 */
	public com.liferay.knowledgebase.service.KBArticleService getKBArticleService() {
		return kbArticleService;
	}

	/**
	 * Sets the k b article remote service.
	 *
	 * @param kbArticleService the k b article remote service
	 */
	public void setKBArticleService(
		com.liferay.knowledgebase.service.KBArticleService kbArticleService) {
		this.kbArticleService = kbArticleService;
	}

	/**
	 * Returns the k b article persistence.
	 *
	 * @return the k b article persistence
	 */
	public KBArticlePersistence getKBArticlePersistence() {
		return kbArticlePersistence;
	}

	/**
	 * Sets the k b article persistence.
	 *
	 * @param kbArticlePersistence the k b article persistence
	 */
	public void setKBArticlePersistence(
		KBArticlePersistence kbArticlePersistence) {
		this.kbArticlePersistence = kbArticlePersistence;
	}

	/**
	 * Returns the k b article finder.
	 *
	 * @return the k b article finder
	 */
	public KBArticleFinder getKBArticleFinder() {
		return kbArticleFinder;
	}

	/**
	 * Sets the k b article finder.
	 *
	 * @param kbArticleFinder the k b article finder
	 */
	public void setKBArticleFinder(KBArticleFinder kbArticleFinder) {
		this.kbArticleFinder = kbArticleFinder;
	}

	/**
	 * Returns the k b article resource local service.
	 *
	 * @return the k b article resource local service
	 */
	public com.liferay.knowledgebase.service.KBArticleResourceLocalService getKBArticleResourceLocalService() {
		return kbArticleResourceLocalService;
	}

	/**
	 * Sets the k b article resource local service.
	 *
	 * @param kbArticleResourceLocalService the k b article resource local service
	 */
	public void setKBArticleResourceLocalService(
		com.liferay.knowledgebase.service.KBArticleResourceLocalService kbArticleResourceLocalService) {
		this.kbArticleResourceLocalService = kbArticleResourceLocalService;
	}

	/**
	 * Returns the k b article resource persistence.
	 *
	 * @return the k b article resource persistence
	 */
	public KBArticleResourcePersistence getKBArticleResourcePersistence() {
		return kbArticleResourcePersistence;
	}

	/**
	 * Sets the k b article resource persistence.
	 *
	 * @param kbArticleResourcePersistence the k b article resource persistence
	 */
	public void setKBArticleResourcePersistence(
		KBArticleResourcePersistence kbArticleResourcePersistence) {
		this.kbArticleResourcePersistence = kbArticleResourcePersistence;
	}

	/**
	 * Returns the k b comment local service.
	 *
	 * @return the k b comment local service
	 */
	public com.liferay.knowledgebase.service.KBCommentLocalService getKBCommentLocalService() {
		return kbCommentLocalService;
	}

	/**
	 * Sets the k b comment local service.
	 *
	 * @param kbCommentLocalService the k b comment local service
	 */
	public void setKBCommentLocalService(
		com.liferay.knowledgebase.service.KBCommentLocalService kbCommentLocalService) {
		this.kbCommentLocalService = kbCommentLocalService;
	}

	/**
	 * Returns the k b comment remote service.
	 *
	 * @return the k b comment remote service
	 */
	public com.liferay.knowledgebase.service.KBCommentService getKBCommentService() {
		return kbCommentService;
	}

	/**
	 * Sets the k b comment remote service.
	 *
	 * @param kbCommentService the k b comment remote service
	 */
	public void setKBCommentService(
		com.liferay.knowledgebase.service.KBCommentService kbCommentService) {
		this.kbCommentService = kbCommentService;
	}

	/**
	 * Returns the k b comment persistence.
	 *
	 * @return the k b comment persistence
	 */
	public KBCommentPersistence getKBCommentPersistence() {
		return kbCommentPersistence;
	}

	/**
	 * Sets the k b comment persistence.
	 *
	 * @param kbCommentPersistence the k b comment persistence
	 */
	public void setKBCommentPersistence(
		KBCommentPersistence kbCommentPersistence) {
		this.kbCommentPersistence = kbCommentPersistence;
	}

	/**
	 * Returns the k b folder local service.
	 *
	 * @return the k b folder local service
	 */
	public KBFolderLocalService getKBFolderLocalService() {
		return kbFolderLocalService;
	}

	/**
	 * Sets the k b folder local service.
	 *
	 * @param kbFolderLocalService the k b folder local service
	 */
	public void setKBFolderLocalService(
		KBFolderLocalService kbFolderLocalService) {
		this.kbFolderLocalService = kbFolderLocalService;
	}

	/**
	 * Returns the k b folder remote service.
	 *
	 * @return the k b folder remote service
	 */
	public com.liferay.knowledgebase.service.KBFolderService getKBFolderService() {
		return kbFolderService;
	}

	/**
	 * Sets the k b folder remote service.
	 *
	 * @param kbFolderService the k b folder remote service
	 */
	public void setKBFolderService(
		com.liferay.knowledgebase.service.KBFolderService kbFolderService) {
		this.kbFolderService = kbFolderService;
	}

	/**
	 * Returns the k b folder persistence.
	 *
	 * @return the k b folder persistence
	 */
	public KBFolderPersistence getKBFolderPersistence() {
		return kbFolderPersistence;
	}

	/**
	 * Sets the k b folder persistence.
	 *
	 * @param kbFolderPersistence the k b folder persistence
	 */
	public void setKBFolderPersistence(KBFolderPersistence kbFolderPersistence) {
		this.kbFolderPersistence = kbFolderPersistence;
	}

	/**
	 * Returns the k b template local service.
	 *
	 * @return the k b template local service
	 */
	public com.liferay.knowledgebase.service.KBTemplateLocalService getKBTemplateLocalService() {
		return kbTemplateLocalService;
	}

	/**
	 * Sets the k b template local service.
	 *
	 * @param kbTemplateLocalService the k b template local service
	 */
	public void setKBTemplateLocalService(
		com.liferay.knowledgebase.service.KBTemplateLocalService kbTemplateLocalService) {
		this.kbTemplateLocalService = kbTemplateLocalService;
	}

	/**
	 * Returns the k b template remote service.
	 *
	 * @return the k b template remote service
	 */
	public com.liferay.knowledgebase.service.KBTemplateService getKBTemplateService() {
		return kbTemplateService;
	}

	/**
	 * Sets the k b template remote service.
	 *
	 * @param kbTemplateService the k b template remote service
	 */
	public void setKBTemplateService(
		com.liferay.knowledgebase.service.KBTemplateService kbTemplateService) {
		this.kbTemplateService = kbTemplateService;
	}

	/**
	 * Returns the k b template persistence.
	 *
	 * @return the k b template persistence
	 */
	public KBTemplatePersistence getKBTemplatePersistence() {
		return kbTemplatePersistence;
	}

	/**
	 * Sets the k b template persistence.
	 *
	 * @param kbTemplatePersistence the k b template persistence
	 */
	public void setKBTemplatePersistence(
		KBTemplatePersistence kbTemplatePersistence) {
		this.kbTemplatePersistence = kbTemplatePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.service.ClassNameService getClassNameService() {
		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.service.ClassNameService classNameService) {
		this.classNameService = classNameService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.liferay.knowledgebase.model.KBFolder",
			kbFolderLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.liferay.knowledgebase.model.KBFolder");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return KBFolder.class;
	}

	protected String getModelClassName() {
		return KBFolder.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = kbFolderPersistence.getDataSource();

			DB db = DBFactoryUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.knowledgebase.service.KBArticleLocalService.class)
	protected com.liferay.knowledgebase.service.KBArticleLocalService kbArticleLocalService;
	@BeanReference(type = com.liferay.knowledgebase.service.KBArticleService.class)
	protected com.liferay.knowledgebase.service.KBArticleService kbArticleService;
	@BeanReference(type = KBArticlePersistence.class)
	protected KBArticlePersistence kbArticlePersistence;
	@BeanReference(type = KBArticleFinder.class)
	protected KBArticleFinder kbArticleFinder;
	@BeanReference(type = com.liferay.knowledgebase.service.KBArticleResourceLocalService.class)
	protected com.liferay.knowledgebase.service.KBArticleResourceLocalService kbArticleResourceLocalService;
	@BeanReference(type = KBArticleResourcePersistence.class)
	protected KBArticleResourcePersistence kbArticleResourcePersistence;
	@BeanReference(type = com.liferay.knowledgebase.service.KBCommentLocalService.class)
	protected com.liferay.knowledgebase.service.KBCommentLocalService kbCommentLocalService;
	@BeanReference(type = com.liferay.knowledgebase.service.KBCommentService.class)
	protected com.liferay.knowledgebase.service.KBCommentService kbCommentService;
	@BeanReference(type = KBCommentPersistence.class)
	protected KBCommentPersistence kbCommentPersistence;
	@BeanReference(type = com.liferay.knowledgebase.service.KBFolderLocalService.class)
	protected KBFolderLocalService kbFolderLocalService;
	@BeanReference(type = com.liferay.knowledgebase.service.KBFolderService.class)
	protected com.liferay.knowledgebase.service.KBFolderService kbFolderService;
	@BeanReference(type = KBFolderPersistence.class)
	protected KBFolderPersistence kbFolderPersistence;
	@BeanReference(type = com.liferay.knowledgebase.service.KBTemplateLocalService.class)
	protected com.liferay.knowledgebase.service.KBTemplateLocalService kbTemplateLocalService;
	@BeanReference(type = com.liferay.knowledgebase.service.KBTemplateService.class)
	protected com.liferay.knowledgebase.service.KBTemplateService kbTemplateService;
	@BeanReference(type = KBTemplatePersistence.class)
	protected KBTemplatePersistence kbTemplatePersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ClassNameLocalService.class)
	protected com.liferay.portal.service.ClassNameLocalService classNameLocalService;
	@BeanReference(type = com.liferay.portal.service.ClassNameService.class)
	protected com.liferay.portal.service.ClassNameService classNameService;
	@BeanReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private KBFolderLocalServiceClpInvoker _clpInvoker = new KBFolderLocalServiceClpInvoker();
}