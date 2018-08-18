package com.ecmdeveloper.graphqlserver.utils;

import java.util.Date;
import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.filenet.api.admin.*;
import com.filenet.api.events.*;
import com.filenet.api.core.*;
import com.filenet.api.collection.*;
import com.filenet.api.collection.ChoiceList;
import com.filenet.api.sweep.*;
import com.filenet.api.publishing.*;
import com.filenet.api.meta.*;
import com.filenet.api.replication.*;
import com.filenet.api.security.*;
import com.filenet.api.util.*;
import com.filenet.api.query.*;

/**
 * This class wraps the collection classes in the <tt>com.filenet.api.collection</tt> package into streams which 
 * can be processed with Java lambda's.
 * 
 * It is inspired by <a href="https://stackoverflow.com/questions/24511052/how-to-convert-an-iterator-to-a-stream">this thread</a> on stackoverflow.
 * 
 * Use it by doing a static import like this:
 * 
 * <pre>
 * import static com.ecmdeveloper.jace.streams.CEAPIStreams.asStream;
 * </pre>
 * 
 * And use it in your code like this:
 * 
 * <pre>
 * 	Folder folder = Factory.Folder.fetchInstance(os, path, filter);
 * 	asStream(folder.get_ContainedDocuments())
 *	  .map( document -> document.get_Name() )
 *	  .forEach( name -> System.out.println() );
 * </pre>
 * 
 * @author Ricardo Belfor
 *
 */
@SuppressWarnings({"unchecked", "deprecation"})
public class CEAPIStreams {

    public static <T> Stream<T> asStream(Iterator<T> sourceIterator) {
        Iterable<T> iterable = () -> sourceIterator;
        return StreamSupport.stream(iterable.spliterator(), false);
    }
    
    /* Start of generated code */
    public static Stream<XMLPropertyMappingScript> asStream(XMLPropertyMappingScriptSet xmlPropertyMappingScriptSet) {
    	return asStream(xmlPropertyMappingScriptSet.iterator());
    }
    public static Stream<WorkflowEventAction> asStream(WorkflowEventActionSet workflowEventActionSet) {
    	return asStream(workflowEventActionSet.iterator());
    }
    public static Stream<WorkflowDefinition> asStream(WorkflowDefinitionSet workflowDefinitionSet) {
    	return asStream(workflowDefinitionSet.iterator());
    }
    public static Stream<VirtualServer> asStream(VirtualServerSet virtualServerSet) {
    	return asStream(virtualServerSet.iterator());
    }
    public static Stream<VersioningSecurityTemplate> asStream(VersioningSecurityTemplateList versioningSecurityTemplateList) {
    	return asStream(versioningSecurityTemplateList.iterator());
    }
    public static Stream<Versionable> asStream(VersionableSet versionableSet) {
    	return asStream(versionableSet.iterator());
    }
    public static Stream<VersionableClassDefinition> asStream(VersionableClassDefinitionSet versionableClassDefinitionSet) {
    	return asStream(versionableClassDefinitionSet.iterator());
    }
    public static Stream<VersionSeries> asStream(VersionSeriesSet versionSeriesSet) {
    	return asStream(versionSeriesSet.iterator());
    }
    public static Stream<VerityServerConfiguration> asStream(VerityServerConfigurationList verityServerConfigurationList) {
    	return asStream(verityServerConfigurationList.iterator());
    }
    public static Stream<VerityIndexArea> asStream(VerityIndexAreaSet verityIndexAreaSet) {
    	return asStream(verityIndexAreaSet.iterator());
    }
    public static Stream<VerityDomainConfiguration> asStream(VerityDomainConfigurationSet verityDomainConfigurationSet) {
    	return asStream(verityDomainConfigurationSet.iterator());
    }
    public static Stream<VerityCollection> asStream(VerityCollectionList verityCollectionList) {
    	return asStream(verityCollectionList.iterator());
    }
    public static Stream<User> asStream(UserSet userSet) {
    	return asStream(userSet.iterator());
    }
    public static Stream<UpgradeAddOn> asStream(UpgradeAddOnSet upgradeAddOnSet) {
    	return asStream(upgradeAddOnSet.iterator());
    }
    public static Stream<UpdateSecurityEvent> asStream(UpdateSecurityEventSet updateSecurityEventSet) {
    	return asStream(updateSecurityEventSet.iterator());
    }
    public static Stream<UpdateEvent> asStream(UpdateEventSet updateEventSet) {
    	return asStream(updateEventSet.iterator());
    }
    public static Stream<UnlockEvent> asStream(UnlockEventSet unlockEventSet) {
    	return asStream(unlockEventSet.iterator());
    }
    public static Stream<UnfileEvent> asStream(UnfileEventSet unfileEventSet) {
    	return asStream(unfileEventSet.iterator());
    }
    public static Stream<TraceLoggingConfiguration> asStream(TraceLoggingConfigurationList traceLoggingConfigurationList) {
    	return asStream(traceLoggingConfigurationList.iterator());
    }
    public static Stream<TivoliFixedContentDevice> asStream(TivoliFixedContentDeviceSet tivoliFixedContentDeviceSet) {
    	return asStream(tivoliFixedContentDeviceSet.iterator());
    }
    public static Stream<TakeFederatedOwnershipEvent> asStream(TakeFederatedOwnershipEventSet takeFederatedOwnershipEventSet) {
    	return asStream(takeFederatedOwnershipEventSet.iterator());
    }
    public static Stream<TableDefinition> asStream(TableDefinitionSet tableDefinitionSet) {
    	return asStream(tableDefinitionSet.iterator());
    }
    public static Stream<SubsystemConfiguration> asStream(SubsystemConfigurationList subsystemConfigurationList) {
    	return asStream(subsystemConfigurationList.iterator());
    }
    public static Stream<Subscription> asStream(SubscriptionSet subscriptionSet) {
    	return asStream(subscriptionSet.iterator());
    }
    public static Stream<SubscribedEvent> asStream(SubscribedEventList subscribedEventList) {
    	return asStream(subscribedEventList.iterator());
    }
    public static Stream<Subscribable> asStream(SubscribableSet subscribableSet) {
    	return asStream(subscribableSet.iterator());
    }
    public static Stream<SubscribableClassDefinition> asStream(SubscribableClassDefinitionSet subscribableClassDefinitionSet) {
    	return asStream(subscribableClassDefinitionSet.iterator());
    }
    public static Stream<String> asStream(StringList stringList) {
    	return asStream(stringList.iterator());
    }
    public static Stream<StoredSearch> asStream(StoredSearchSet storedSearchSet) {
    	return asStream(storedSearchSet.iterator());
    }
    public static Stream<StoragePolicy> asStream(StoragePolicySet storagePolicySet) {
    	return asStream(storagePolicySet.iterator());
    }
    public static Stream<StorageArea> asStream(StorageAreaSet storageAreaSet) {
    	return asStream(storageAreaSet.iterator());
    }
    public static Stream<SnapLockFixedContentDevice> asStream(SnapLockFixedContentDeviceSet snapLockFixedContentDeviceSet) {
    	return asStream(snapLockFixedContentDeviceSet.iterator());
    }
    public static Stream<SiteSettings> asStream(SiteSettingsList siteSettingsList) {
    	return asStream(siteSettingsList.iterator());
    }
    public static Stream<Site> asStream(SiteSet siteSet) {
    	return asStream(siteSet.iterator());
    }
    public static Stream<ServerInstance> asStream(ServerInstanceSet serverInstanceSet) {
    	return asStream(serverInstanceSet.iterator());
    }
    public static Stream<ServerCacheConfiguration> asStream(ServerCacheConfigurationList serverCacheConfigurationList) {
    	return asStream(serverCacheConfigurationList.iterator());
    }
    public static Stream<SecurityTemplate> asStream(SecurityTemplateList securityTemplateList) {
    	return asStream(securityTemplateList.iterator());
    }
    public static Stream<SecurityPropagationQueueItem> asStream(SecurityPropagationQueueItemSet securityPropagationQueueItemSet) {
    	return asStream(securityPropagationQueueItemSet.iterator());
    }
    public static Stream<SecurityPrincipal> asStream(SecurityPrincipalSet securityPrincipalSet) {
    	return asStream(securityPrincipalSet.iterator());
    }
    public static Stream<SecurityPolicy> asStream(SecurityPolicySet securityPolicySet) {
    	return asStream(securityPolicySet.iterator());
    }
    public static Stream<RetrievalEvent> asStream(RetrievalEventSet retrievalEventSet) {
    	return asStream(retrievalEventSet.iterator());
    }
    public static Stream<Repository> asStream(RepositorySet repositorySet) {
    	return asStream(repositorySet.iterator());
    }
    public static Stream<RepositoryRow> asStream(RepositoryRowSet repositoryRowSet) {
    	return asStream(repositoryRowSet.iterator());
    }
    public static Stream<ReplicationParticipant> asStream(ReplicationParticipantList replicationParticipantList) {
    	return asStream(replicationParticipantList.iterator());
    }
    public static Stream<ReplicationJournalEntry> asStream(ReplicationJournalEntrySet replicationJournalEntrySet) {
    	return asStream(replicationJournalEntrySet.iterator());
    }
    public static Stream<ReplicationGroup> asStream(ReplicationGroupSet replicationGroupSet) {
    	return asStream(replicationGroupSet.iterator());
    }
    public static Stream<ReplicationConfiguration> asStream(ReplicationConfigurationList replicationConfigurationList) {
    	return asStream(replicationConfigurationList.iterator());
    }
    public static Stream<Replicable> asStream(ReplicableSet replicableSet) {
    	return asStream(replicableSet.iterator());
    }
    public static Stream<ReplicableClassDefinition> asStream(ReplicableClassDefinitionSet replicableClassDefinitionSet) {
    	return asStream(replicableClassDefinitionSet.iterator());
    }
    public static Stream<RenditionEngineConnection> asStream(RenditionEngineConnectionSet renditionEngineConnectionSet) {
    	return asStream(renditionEngineConnectionSet.iterator());
    }
    public static Stream<Relationship> asStream(RelationshipSet relationshipSet) {
    	return asStream(relationshipSet.iterator());
    }
    public static Stream<ReferentialContainmentRelationship> asStream(ReferentialContainmentRelationshipSet referentialContainmentRelationshipSet) {
    	return asStream(referentialContainmentRelationshipSet.iterator());
    }
    public static Stream<Realm> asStream(RealmSet realmSet) {
    	return asStream(realmSet.iterator());
    }
    public static Stream<QueueItem> asStream(QueueItemSet queueItemSet) {
    	return asStream(queueItemSet.iterator());
    }
    public static Stream<QueryEvent> asStream(QueryEventSet queryEventSet) {
    	return asStream(queryEventSet.iterator());
    }
    public static Stream<PublishingConfiguration> asStream(PublishingConfigurationList publishingConfigurationList) {
    	return asStream(publishingConfigurationList.iterator());
    }
    public static Stream<PublishTemplate> asStream(PublishTemplateSet publishTemplateSet) {
    	return asStream(publishTemplateSet.iterator());
    }
    public static Stream<PublishStyleTemplate> asStream(PublishStyleTemplateSet publishStyleTemplateSet) {
    	return asStream(publishStyleTemplateSet.iterator());
    }
    public static Stream<PublishRequest> asStream(PublishRequestSet publishRequestSet) {
    	return asStream(publishRequestSet.iterator());
    }
    public static Stream<PublishRequestEvent> asStream(PublishRequestEventSet publishRequestEventSet) {
    	return asStream(publishRequestEventSet.iterator());
    }
    public static Stream<PublishCompleteEvent> asStream(PublishCompleteEventSet publishCompleteEventSet) {
    	return asStream(publishCompleteEventSet.iterator());
    }
    public static Stream<PropertyTemplateString> asStream(PropertyTemplateStringSet propertyTemplateStringSet) {
    	return asStream(propertyTemplateStringSet.iterator());
    }
    public static Stream<PropertyTemplate> asStream(PropertyTemplateSet propertyTemplateSet) {
    	return asStream(propertyTemplateSet.iterator());
    }
    public static Stream<PropertyTemplateObject> asStream(PropertyTemplateObjectSet propertyTemplateObjectSet) {
    	return asStream(propertyTemplateObjectSet.iterator());
    }
    public static Stream<PropertyTemplateInteger32> asStream(PropertyTemplateInteger32Set propertyTemplateInteger32Set) {
    	return asStream(propertyTemplateInteger32Set.iterator());
    }
    public static Stream<PropertyTemplateId> asStream(PropertyTemplateIdSet propertyTemplateIdSet) {
    	return asStream(propertyTemplateIdSet.iterator());
    }
    public static Stream<PropertyTemplateFloat64> asStream(PropertyTemplateFloat64Set propertyTemplateFloat64Set) {
    	return asStream(propertyTemplateFloat64Set.iterator());
    }
    public static Stream<PropertyTemplateDateTime> asStream(PropertyTemplateDateTimeSet propertyTemplateDateTimeSet) {
    	return asStream(propertyTemplateDateTimeSet.iterator());
    }
    public static Stream<PropertyTemplateBoolean> asStream(PropertyTemplateBooleanSet propertyTemplateBooleanSet) {
    	return asStream(propertyTemplateBooleanSet.iterator());
    }
    public static Stream<PropertyTemplateBinary> asStream(PropertyTemplateBinarySet propertyTemplateBinarySet) {
    	return asStream(propertyTemplateBinarySet.iterator());
    }
    public static Stream<PropertyDescriptionString> asStream(PropertyDescriptionStringList propertyDescriptionStringList) {
    	return asStream(propertyDescriptionStringList.iterator());
    }
    public static Stream<PropertyDescriptionObject> asStream(PropertyDescriptionObjectList propertyDescriptionObjectList) {
    	return asStream(propertyDescriptionObjectList.iterator());
    }
    public static Stream<PropertyDescription> asStream(PropertyDescriptionList propertyDescriptionList) {
    	return asStream(propertyDescriptionList.iterator());
    }
    public static Stream<PropertyDescriptionInteger32> asStream(PropertyDescriptionInteger32List propertyDescriptionInteger32List) {
    	return asStream(propertyDescriptionInteger32List.iterator());
    }
    public static Stream<PropertyDescriptionId> asStream(PropertyDescriptionIdList propertyDescriptionIdList) {
    	return asStream(propertyDescriptionIdList.iterator());
    }
    public static Stream<PropertyDescriptionFloat64> asStream(PropertyDescriptionFloat64List propertyDescriptionFloat64List) {
    	return asStream(propertyDescriptionFloat64List.iterator());
    }
    public static Stream<PropertyDescriptionDateTime> asStream(PropertyDescriptionDateTimeList propertyDescriptionDateTimeList) {
    	return asStream(propertyDescriptionDateTimeList.iterator());
    }
    public static Stream<PropertyDescriptionBoolean> asStream(PropertyDescriptionBooleanList propertyDescriptionBooleanList) {
    	return asStream(propertyDescriptionBooleanList.iterator());
    }
    public static Stream<PropertyDescriptionBinary> asStream(PropertyDescriptionBinaryList propertyDescriptionBinaryList) {
    	return asStream(propertyDescriptionBinaryList.iterator());
    }
    public static Stream<PropertyDefinitionString> asStream(PropertyDefinitionStringList propertyDefinitionStringList) {
    	return asStream(propertyDefinitionStringList.iterator());
    }
    public static Stream<PropertyDefinitionObject> asStream(PropertyDefinitionObjectList propertyDefinitionObjectList) {
    	return asStream(propertyDefinitionObjectList.iterator());
    }
    public static Stream<PropertyDefinition> asStream(PropertyDefinitionList propertyDefinitionList) {
    	return asStream(propertyDefinitionList.iterator());
    }
    public static Stream<PropertyDefinitionInteger32> asStream(PropertyDefinitionInteger32List propertyDefinitionInteger32List) {
    	return asStream(propertyDefinitionInteger32List.iterator());
    }
    public static Stream<PropertyDefinitionId> asStream(PropertyDefinitionIdList propertyDefinitionIdList) {
    	return asStream(propertyDefinitionIdList.iterator());
    }
    public static Stream<PropertyDefinitionFloat64> asStream(PropertyDefinitionFloat64List propertyDefinitionFloat64List) {
    	return asStream(propertyDefinitionFloat64List.iterator());
    }
    public static Stream<PropertyDefinitionDateTime> asStream(PropertyDefinitionDateTimeList propertyDefinitionDateTimeList) {
    	return asStream(propertyDefinitionDateTimeList.iterator());
    }
    public static Stream<PropertyDefinitionBoolean> asStream(PropertyDefinitionBooleanList propertyDefinitionBooleanList) {
    	return asStream(propertyDefinitionBooleanList.iterator());
    }
    public static Stream<PropertyDefinitionBinary> asStream(PropertyDefinitionBinaryList propertyDefinitionBinaryList) {
    	return asStream(propertyDefinitionBinaryList.iterator());
    }
    public static Stream<PromoteVersionEvent> asStream(PromoteVersionEventSet promoteVersionEventSet) {
    	return asStream(promoteVersionEventSet.iterator());
    }
    public static Stream<Permission> asStream(PermissionList permissionList) {
    	return asStream(permissionList.iterator());
    }
    public static Stream<PermissionDescription> asStream(PermissionDescriptionList permissionDescriptionList) {
    	return asStream(permissionDescriptionList.iterator());
    }
    public static Stream<PEConnectionPoint> asStream(PEConnectionPointSet pEConnectionPointSet) {
    	return asStream(pEConnectionPointSet.iterator());
    }
    public static Stream<ObjectStore> asStream(ObjectStoreSet objectStoreSet) {
    	return asStream(objectStoreSet.iterator());
    }
    public static Stream<ObjectStoreParticipant> asStream(ObjectStoreParticipantList objectStoreParticipantList) {
    	return asStream(objectStoreParticipantList.iterator());
    }
    public static Stream<ObjectChangeEvent> asStream(ObjectChangeEventSet objectChangeEventSet) {
    	return asStream(objectChangeEventSet.iterator());
    }
    public static Stream<MarkingSet> asStream(MarkingSetSet markingSetSet) {
    	return asStream(markingSetSet.iterator());
    }
    public static Stream<Marking> asStream(MarkingList markingList) {
    	return asStream(markingList.iterator());
    }
    public static Stream<LockEvent> asStream(LockEventSet lockEventSet) {
    	return asStream(lockEventSet.iterator());
    }
    public static Stream<LocalizedString> asStream(LocalizedStringList localizedStringList) {
    	return asStream(localizedStringList.iterator());
    }
    public static Stream<Link> asStream(LinkSet linkSet) {
    	return asStream(linkSet.iterator());
    }
    public static Stream<IsolatedRegion> asStream(IsolatedRegionSet isolatedRegionSet) {
    	return asStream(isolatedRegionSet.iterator());
    }
    public static Stream<Integer> asStream(Integer32List integer32List) {
    	return asStream(integer32List.iterator());
    }
    public static Stream<InstanceWorkflowSubscription> asStream(InstanceWorkflowSubscriptionSet instanceWorkflowSubscriptionSet) {
    	return asStream(instanceWorkflowSubscriptionSet.iterator());
    }
    public static Stream<InstanceSubscription> asStream(InstanceSubscriptionSet instanceSubscriptionSet) {
    	return asStream(instanceSubscriptionSet.iterator());
    }
    public static Stream<IndexJobSingleItem> asStream(IndexJobSingleItemList indexJobSingleItemList) {
    	return asStream(indexJobSingleItemList.iterator());
    }
    public static Stream<IndexJob> asStream(IndexJobSet indexJobSet) {
    	return asStream(indexJobSet.iterator());
    }
    public static Stream<IndexJobItem> asStream(IndexJobItemList indexJobItemList) {
    	return asStream(indexJobItemList.iterator());
    }
    public static Stream<IndexJobCollectionItem> asStream(IndexJobCollectionItemList indexJobCollectionItemList) {
    	return asStream(indexJobCollectionItemList.iterator());
    }
    public static Stream<IndexJobClassItem> asStream(IndexJobClassItemList indexJobClassItemList) {
    	return asStream(indexJobClassItemList.iterator());
    }
    public static Stream<IndexArea> asStream(IndexAreaSet indexAreaSet) {
    	return asStream(indexAreaSet.iterator());
    }
    public static Stream<IndependentObject> asStream(IndependentObjectSet independentObjectSet) {
    	return asStream(independentObjectSet.iterator());
    }
    public static Stream<ImageServicesSiteSettings> asStream(ImageServicesSiteSettingsList imageServicesSiteSettingsList) {
    	return asStream(imageServicesSiteSettingsList.iterator());
    }
    public static Stream<ImageServicesRepository> asStream(ImageServicesRepositorySet imageServicesRepositorySet) {
    	return asStream(imageServicesRepositorySet.iterator());
    }
    public static Stream<ImageServicesPropertyDescription> asStream(ImageServicesPropertyDescriptionList imageServicesPropertyDescriptionList) {
    	return asStream(imageServicesPropertyDescriptionList.iterator());
    }
    public static Stream<ImageServicesImportAgentConfiguration> asStream(ImageServicesImportAgentConfigurationList imageServicesImportAgentConfigurationList) {
    	return asStream(imageServicesImportAgentConfigurationList.iterator());
    }
    public static Stream<ImageServicesClassDescription> asStream(ImageServicesClassDescriptionList imageServicesClassDescriptionList) {
    	return asStream(imageServicesClassDescriptionList.iterator());
    }
    public static Stream<Id> asStream(IdList idList) {
    	return asStream(idList.iterator());
    }
    public static Stream<IMFixedContentDevice> asStream(IMFixedContentDeviceSet iMFixedContentDeviceSet) {
    	return asStream(iMFixedContentDeviceSet.iterator());
    }
    public static Stream<IICEFixedContentDevice> asStream(IICEFixedContentDeviceSet iICEFixedContentDeviceSet) {
    	return asStream(iICEFixedContentDeviceSet.iterator());
    }
    public static Stream<Group> asStream(GroupSet groupSet) {
    	return asStream(groupSet.iterator());
    }
    public static Stream<GetObjectEvent> asStream(GetObjectEventSet getObjectEventSet) {
    	return asStream(getObjectEventSet.iterator());
    }
    public static Stream<GetContentEvent> asStream(GetContentEventSet getContentEventSet) {
    	return asStream(getContentEventSet.iterator());
    }
    public static Stream<GenericFixedContentDevice> asStream(GenericFixedContentDeviceSet genericFixedContentDeviceSet) {
    	return asStream(genericFixedContentDeviceSet.iterator());
    }
    public static Stream<FreezeEvent> asStream(FreezeEventSet freezeEventSet) {
    	return asStream(freezeEventSet.iterator());
    }
    public static Stream<Folder> asStream(FolderSet folderSet) {
    	return asStream(folderSet.iterator());
    }
    public static Stream<Double> asStream(Float64List float64List) {
    	return asStream(float64List.iterator());
    }
    public static Stream<FixedStorageArea> asStream(FixedStorageAreaSet fixedStorageAreaSet) {
    	return asStream(fixedStorageAreaSet.iterator());
    }
    public static Stream<FixedContentDevice> asStream(FixedContentDeviceSet fixedContentDeviceSet) {
    	return asStream(fixedContentDeviceSet.iterator());
    }
    public static Stream<FileStorageArea> asStream(FileStorageAreaSet fileStorageAreaSet) {
    	return asStream(fileStorageAreaSet.iterator());
    }
    public static Stream<FileEvent> asStream(FileEventSet fileEventSet) {
    	return asStream(fileEventSet.iterator());
    }
    public static Stream<ExternalRepository> asStream(ExternalRepositorySet externalRepositorySet) {
    	return asStream(externalRepositorySet.iterator());
    }
    public static Stream<ExternalPropertyDescription> asStream(ExternalPropertyDescriptionList externalPropertyDescriptionList) {
    	return asStream(externalPropertyDescriptionList.iterator());
    }
    public static Stream<ExternalPropertyAlias> asStream(ExternalPropertyAliasList externalPropertyAliasList) {
    	return asStream(externalPropertyAliasList.iterator());
    }
    public static Stream<ExternalParticipant> asStream(ExternalParticipantList externalParticipantList) {
    	return asStream(externalParticipantList.iterator());
    }
    public static Stream<ExternalIdentity> asStream(ExternalIdentityList externalIdentityList) {
    	return asStream(externalIdentityList.iterator());
    }
    public static Stream<ExternalClassDescription> asStream(ExternalClassDescriptionSet externalClassDescriptionSet) {
    	return asStream(externalClassDescriptionSet.iterator());
    }
    public static Stream<ExternalClassAlias> asStream(ExternalClassAliasList externalClassAliasList) {
    	return asStream(externalClassAliasList.iterator());
    }
    public static Stream<ExternalAlias> asStream(ExternalAliasList externalAliasList) {
    	return asStream(externalAliasList.iterator());
    }
    public static Stream<Event> asStream(EventSet eventSet) {
    	return asStream(eventSet.iterator());
    }
    public static Stream<EventQueueItem> asStream(EventQueueItemSet eventQueueItemSet) {
    	return asStream(eventQueueItemSet.iterator());
    }
    public static Stream<EventClassDefinition> asStream(EventClassDefinitionSet eventClassDefinitionSet) {
    	return asStream(eventClassDefinitionSet.iterator());
    }
    public static Stream<EventAction> asStream(EventActionSet eventActionSet) {
    	return asStream(eventActionSet.iterator());
    }
    public static Stream<EngineCollection> asStream(EngineCollection engineCollection) {
    	return asStream(engineCollection.iterator());
    }
    public static Stream<DynamicReferentialContainmentRelationship> asStream(DynamicReferentialContainmentRelationshipSet dynamicReferentialContainmentRelationshipSet) {
    	return asStream(dynamicReferentialContainmentRelationshipSet.iterator());
    }
    public static Stream<Domain> asStream(DomainSet domainSet) {
    	return asStream(domainSet.iterator());
    }
    public static Stream<DocumentState> asStream(DocumentStateList documentStateList) {
    	return asStream(documentStateList.iterator());
    }
    public static Stream<Document> asStream(DocumentSet documentSet) {
    	return asStream(documentSet.iterator());
    }
    public static Stream<DocumentLifecyclePolicy> asStream(DocumentLifecyclePolicySet documentLifecyclePolicySet) {
    	return asStream(documentLifecyclePolicySet.iterator());
    }
    public static Stream<DocumentLifecycleAction> asStream(DocumentLifecycleActionSet documentLifecycleActionSet) {
    	return asStream(documentLifecycleActionSet.iterator());
    }
    public static Stream<DocumentClassificationQueueItem> asStream(DocumentClassificationQueueItemSet documentClassificationQueueItemSet) {
    	return asStream(documentClassificationQueueItemSet.iterator());
    }
    public static Stream<DocumentClassificationAction> asStream(DocumentClassificationActionSet documentClassificationActionSet) {
    	return asStream(documentClassificationActionSet.iterator());
    }
    public static Stream<DocumentClassDefinition> asStream(DocumentClassDefinitionSet documentClassDefinitionSet) {
    	return asStream(documentClassDefinitionSet.iterator());
    }
    public static Stream<DiscretionaryPermission> asStream(DiscretionaryPermissionList discretionaryPermissionList) {
    	return asStream(discretionaryPermissionList.iterator());
    }
    public static Stream<DirectoryConfigurationSunOne> asStream(DirectoryConfigurationSunOneList directoryConfigurationSunOneList) {
    	return asStream(directoryConfigurationSunOneList.iterator());
    }
    public static Stream<DirectoryConfigurationNovell> asStream(DirectoryConfigurationNovellList directoryConfigurationNovellList) {
    	return asStream(directoryConfigurationNovellList.iterator());
    }
    public static Stream<DirectoryConfiguration> asStream(DirectoryConfigurationList directoryConfigurationList) {
    	return asStream(directoryConfigurationList.iterator());
    }
    public static Stream<DirectoryConfigurationIBM> asStream(DirectoryConfigurationIBMList directoryConfigurationIBMList) {
    	return asStream(directoryConfigurationIBMList.iterator());
    }
    public static Stream<DirectoryConfigurationCA> asStream(DirectoryConfigurationCAList directoryConfigurationCAList) {
    	return asStream(directoryConfigurationCAList.iterator());
    }
    public static Stream<DirectoryConfigurationAdam> asStream(DirectoryConfigurationAdamList directoryConfigurationAdamList) {
    	return asStream(directoryConfigurationAdamList.iterator());
    }
    public static Stream<DirectoryConfigurationAD> asStream(DirectoryConfigurationADList directoryConfigurationADList) {
    	return asStream(directoryConfigurationADList.iterator());
    }
    public static Stream<DependentObject> asStream(DependentObjectList dependentObjectList) {
    	return asStream(dependentObjectList.iterator());
    }
    public static Stream<DemoteVersionEvent> asStream(DemoteVersionEventSet demoteVersionEventSet) {
    	return asStream(demoteVersionEventSet.iterator());
    }
    public static Stream<DeletionEvent> asStream(DeletionEventSet deletionEventSet) {
    	return asStream(deletionEventSet.iterator());
    }
    public static Stream<Date> asStream(DateTimeList dateTimeList) {
    	return asStream(dateTimeList.iterator());
    }
    public static Stream<DatabaseStorageArea> asStream(DatabaseStorageAreaSet databaseStorageAreaSet) {
    	return asStream(databaseStorageAreaSet.iterator());
    }
    public static Stream<DITARenditionEngineConnection> asStream(DITARenditionEngineConnectionSet dITARenditionEngineConnectionSet) {
    	return asStream(dITARenditionEngineConnectionSet.iterator());
    }
    public static Stream<CustomObject> asStream(CustomObjectSet customObjectSet) {
    	return asStream(customObjectSet.iterator());
    }
    public static Stream<CustomEvent> asStream(CustomEventSet customEventSet) {
    	return asStream(customEventSet.iterator());
    }
    public static Stream<CreationEvent> asStream(CreationEventSet creationEventSet) {
    	return asStream(creationEventSet.iterator());
    }
    public static Stream<ContentTransfer> asStream(ContentTransferList contentTransferList) {
    	return asStream(contentTransferList.iterator());
    }
    public static Stream<ContentReference> asStream(ContentReferenceList contentReferenceList) {
    	return asStream(contentReferenceList.iterator());
    }
    public static Stream<ContentFederatingRepository> asStream(ContentFederatingRepositorySet contentFederatingRepositorySet) {
    	return asStream(contentFederatingRepositorySet.iterator());
    }
    public static Stream<ContentElement> asStream(ContentElementList contentElementList) {
    	return asStream(contentElementList.iterator());
    }
    public static Stream<ContentConfiguration> asStream(ContentConfigurationList contentConfigurationList) {
    	return asStream(contentConfigurationList.iterator());
    }
    public static Stream<ContentCacheConfiguration> asStream(ContentCacheConfigurationList contentCacheConfigurationList) {
    	return asStream(contentCacheConfigurationList.iterator());
    }
    public static Stream<ContentCacheArea> asStream(ContentCacheAreaSet contentCacheAreaSet) {
    	return asStream(contentCacheAreaSet.iterator());
    }
    public static Stream<ContainmentRelationship> asStream(ContainmentRelationshipSet containmentRelationshipSet) {
    	return asStream(containmentRelationshipSet.iterator());
    }
    public static Stream<Containable> asStream(ContainableSet containableSet) {
    	return asStream(containableSet.iterator());
    }
    public static Stream<ComponentRelationship> asStream(ComponentRelationshipSet componentRelationshipSet) {
    	return asStream(componentRelationshipSet.iterator());
    }
    public static Stream<ColumnDefinition> asStream(ColumnDefinitionList columnDefinitionList) {
    	return asStream(columnDefinitionList.iterator());
    }
    public static Stream<CodeModule> asStream(CodeModuleSet codeModuleSet) {
    	return asStream(codeModuleSet.iterator());
    }
    public static Stream<CmTivoliManagementClass> asStream(CmTivoliManagementClassSet cmTivoliManagementClassSet) {
    	return asStream(cmTivoliManagementClassSet.iterator());
    }
    public static Stream<CmTimeslot> asStream(CmTimeslotList cmTimeslotList) {
    	return asStream(cmTimeslotList.iterator());
    }
    public static Stream<CmThumbnail> asStream(CmThumbnailSet cmThumbnailSet) {
    	return asStream(cmThumbnailSet.iterator());
    }
    public static Stream<CmTextSearchServer> asStream(CmTextSearchServerSet cmTextSearchServerSet) {
    	return asStream(cmTextSearchServerSet.iterator());
    }
    public static Stream<CmTextSearchPartitionProperty> asStream(CmTextSearchPartitionPropertyList cmTextSearchPartitionPropertyList) {
    	return asStream(cmTextSearchPartitionPropertyList.iterator());
    }
    public static Stream<CmTextSearchIndex> asStream(CmTextSearchIndexList cmTextSearchIndexList) {
    	return asStream(cmTextSearchIndexList.iterator());
    }
    public static Stream<CmTextSearchAffinityGroup> asStream(CmTextSearchAffinityGroupSet cmTextSearchAffinityGroupSet) {
    	return asStream(cmTextSearchAffinityGroupSet.iterator());
    }
    public static Stream<CmTextIndexingPreprocessorDefinition> asStream(CmTextIndexingPreprocessorDefinitionList cmTextIndexingPreprocessorDefinitionList) {
    	return asStream(cmTextIndexingPreprocessorDefinitionList.iterator());
    }
    public static Stream<CmTask> asStream(CmTaskSet cmTaskSet) {
    	return asStream(cmTaskSet.iterator());
    }
    public static Stream<CmTaskRelationship> asStream(CmTaskRelationshipSet cmTaskRelationshipSet) {
    	return asStream(cmTaskRelationshipSet.iterator());
    }
    public static Stream<CmSweep> asStream(CmSweepSet cmSweepSet) {
    	return asStream(cmSweepSet.iterator());
    }
    public static Stream<CmSweepResult> asStream(CmSweepResultSet cmSweepResultSet) {
    	return asStream(cmSweepResultSet.iterator());
    }
    public static Stream<CmSweepRelationship> asStream(CmSweepRelationshipSet cmSweepRelationshipSet) {
    	return asStream(cmSweepRelationshipSet.iterator());
    }
    public static Stream<CmSweepPolicy> asStream(CmSweepPolicySet cmSweepPolicySet) {
    	return asStream(cmSweepPolicySet.iterator());
    }
    public static Stream<CmSweepPolicyRelationship> asStream(CmSweepPolicyRelationshipSet cmSweepPolicyRelationshipSet) {
    	return asStream(cmSweepPolicyRelationshipSet.iterator());
    }
    public static Stream<CmSweepJob> asStream(CmSweepJobSet cmSweepJobSet) {
    	return asStream(cmSweepJobSet.iterator());
    }
    public static Stream<CmStorageDeviceConnection> asStream(CmStorageDeviceConnectionList cmStorageDeviceConnectionList) {
    	return asStream(cmStorageDeviceConnectionList.iterator());
    }
    public static Stream<CmReplicaSynchronizationSiteSettings> asStream(CmReplicaSynchronizationSiteSettingsList cmReplicaSynchronizationSiteSettingsList) {
    	return asStream(cmReplicaSynchronizationSiteSettingsList.iterator());
    }
    public static Stream<CmRecoveryItem> asStream(CmRecoveryItemSet cmRecoveryItemSet) {
    	return asStream(cmRecoveryItemSet.iterator());
    }
    public static Stream<CmQueueSweep> asStream(CmQueueSweepSet cmQueueSweepSet) {
    	return asStream(cmQueueSweepSet.iterator());
    }
    public static Stream<CmPolicySweepResult> asStream(CmPolicySweepResultSet cmPolicySweepResultSet) {
    	return asStream(cmPolicySweepResultSet.iterator());
    }
    public static Stream<CmPolicyControlledSweep> asStream(CmPolicyControlledSweepSet cmPolicyControlledSweepSet) {
    	return asStream(cmPolicyControlledSweepSet.iterator());
    }
    public static Stream<CmJobSweepResult> asStream(CmJobSweepResultSet cmJobSweepResultSet) {
    	return asStream(cmJobSweepResultSet.iterator());
    }
    public static Stream<CmIndexedColumn> asStream(CmIndexedColumnList cmIndexedColumnList) {
    	return asStream(cmIndexedColumnList.iterator());
    }
    public static Stream<CmIndexRequest> asStream(CmIndexRequestSet cmIndexRequestSet) {
    	return asStream(cmIndexRequestSet.iterator());
    }
    public static Stream<CmIndexPartitionConstraint> asStream(CmIndexPartitionConstraintList cmIndexPartitionConstraintList) {
    	return asStream(cmIndexPartitionConstraintList.iterator());
    }
    public static Stream<CmIndexDefinition> asStream(CmIndexDefinitionList cmIndexDefinitionList) {
    	return asStream(cmIndexDefinitionList.iterator());
    }
    public static Stream<CmHoldable> asStream(CmHoldableSet cmHoldableSet) {
    	return asStream(cmHoldableSet.iterator());
    }
    public static Stream<CmHoldRelationship> asStream(CmHoldRelationshipSet cmHoldRelationshipSet) {
    	return asStream(cmHoldRelationshipSet.iterator());
    }
    public static Stream<CmEventExportStore> asStream(CmEventExportStoreSet cmEventExportStoreSet) {
    	return asStream(cmEventExportStoreSet.iterator());
    }
    public static Stream<CmDirectoryConfigurationOID> asStream(CmDirectoryConfigurationOIDList cmDirectoryConfigurationOIDList) {
    	return asStream(cmDirectoryConfigurationOIDList.iterator());
    }
    public static Stream<CmDatabaseConnection> asStream(CmDatabaseConnectionSet cmDatabaseConnectionSet) {
    	return asStream(cmDatabaseConnectionSet.iterator());
    }
    public static Stream<CmConversionSettingsClassDefinition> asStream(CmConversionSettingsClassDefinitionSet cmConversionSettingsClassDefinitionSet) {
    	return asStream(cmConversionSettingsClassDefinitionSet.iterator());
    }
    public static Stream<CmChangePreprocessorDefinition> asStream(CmChangePreprocessorDefinitionList cmChangePreprocessorDefinitionList) {
    	return asStream(cmChangePreprocessorDefinitionList.iterator());
    }
    public static Stream<CmChangePreprocessorAction> asStream(CmChangePreprocessorActionSet cmChangePreprocessorActionSet) {
    	return asStream(cmChangePreprocessorActionSet.iterator());
    }
    public static Stream<CmBackgroundSearch> asStream(CmBackgroundSearchSet cmBackgroundSearchSet) {
    	return asStream(cmBackgroundSearchSet.iterator());
    }
    public static Stream<CmAuditProcessingBookmark> asStream(CmAuditProcessingBookmarkSet cmAuditProcessingBookmarkSet) {
    	return asStream(cmAuditProcessingBookmarkSet.iterator());
    }
    public static Stream<CmAuditDispositionPolicy> asStream(CmAuditDispositionPolicySet cmAuditDispositionPolicySet) {
    	return asStream(cmAuditDispositionPolicySet.iterator());
    }
    public static Stream<CmAdvancedStorageArea> asStream(CmAdvancedStorageAreaSet cmAdvancedStorageAreaSet) {
    	return asStream(cmAdvancedStorageAreaSet.iterator());
    }
    public static Stream<CmAbstractSearchResult> asStream(CmAbstractSearchResultSet cmAbstractSearchResultSet) {
    	return asStream(cmAbstractSearchResultSet.iterator());
    }
    public static Stream<ClassifyCompleteEvent> asStream(ClassifyCompleteEventSet classifyCompleteEventSet) {
    	return asStream(classifyCompleteEventSet.iterator());
    }
    public static Stream<ClassWorkflowSubscription> asStream(ClassWorkflowSubscriptionSet classWorkflowSubscriptionSet) {
    	return asStream(classWorkflowSubscriptionSet.iterator());
    }
    public static Stream<ClassSubscription> asStream(ClassSubscriptionSet classSubscriptionSet) {
    	return asStream(classSubscriptionSet.iterator());
    }
    public static Stream<ClassDescription> asStream(ClassDescriptionSet classDescriptionSet) {
    	return asStream(classDescriptionSet.iterator());
    }
    public static Stream<ClassDefinition> asStream(ClassDefinitionSet classDefinitionSet) {
    	return asStream(classDefinitionSet.iterator());
    }
    public static Stream<Choice> asStream(ChoiceListSet choiceListSet) {
    	return asStream(choiceListSet.iterator());
    }
    public static Stream<Choice> asStream(ChoiceList choiceList) {
    	return asStream(choiceList.iterator());
    }
    public static Stream<CheckoutEvent> asStream(CheckoutEventSet checkoutEventSet) {
    	return asStream(checkoutEventSet.iterator());
    }
    public static Stream<CheckinEvent> asStream(CheckinEventSet checkinEventSet) {
    	return asStream(checkinEventSet.iterator());
    }
    public static Stream<ChangeStateEvent> asStream(ChangeStateEventSet changeStateEventSet) {
    	return asStream(changeStateEventSet.iterator());
    }
    public static Stream<ChangeClassEvent> asStream(ChangeClassEventSet changeClassEventSet) {
    	return asStream(changeClassEventSet.iterator());
    }
    public static Stream<CenteraSiteSettings> asStream(CenteraSiteSettingsList centeraSiteSettingsList) {
    	return asStream(centeraSiteSettingsList.iterator());
    }
    public static Stream<CenteraFixedContentDevice> asStream(CenteraFixedContentDeviceSet centeraFixedContentDeviceSet) {
    	return asStream(centeraFixedContentDeviceSet.iterator());
    }
    public static Stream<CancelCheckoutEvent> asStream(CancelCheckoutEventSet cancelCheckoutEventSet) {
    	return asStream(cancelCheckoutEventSet.iterator());
    }
    public static Stream<CMODRepository> asStream(CMODRepositorySet cMODRepositorySet) {
    	return asStream(cMODRepositorySet.iterator());
    }
    public static Stream<CMODFixedContentDevice> asStream(CMODFixedContentDeviceSet cMODFixedContentDeviceSet) {
    	return asStream(cMODFixedContentDeviceSet.iterator());
    }
    public static Stream<CMODApplicationGroup> asStream(CMODApplicationGroupSet cMODApplicationGroupSet) {
    	return asStream(cMODApplicationGroupSet.iterator());
    }
    public static Stream<CFSSiteSettings> asStream(CFSSiteSettingsList cFSSiteSettingsList) {
    	return asStream(cFSSiteSettingsList.iterator());
    }
    public static Stream<CFSImportAgentConfiguration> asStream(CFSImportAgentConfigurationList cFSImportAgentConfigurationList) {
    	return asStream(cFSImportAgentConfigurationList.iterator());
    }
    public static Stream<Boolean> asStream(BooleanList booleanList) {
    	return asStream(booleanList.iterator());
    }
    public static Stream<byte[]> asStream(BinaryList binaryList) {
    	return asStream(binaryList.iterator());
    }
    public static Stream<AuditDefinition> asStream(AuditDefinitionList auditDefinitionList) {
    	return asStream(auditDefinitionList.iterator());
    }
    public static Stream<AuditConfigurationEvent> asStream(AuditConfigurationEventSet auditConfigurationEventSet) {
    	return asStream(auditConfigurationEventSet.iterator());
    }
    public static Stream<AsyncUpgradeQueueItem> asStream(AsyncUpgradeQueueItemSet asyncUpgradeQueueItemSet) {
    	return asStream(asyncUpgradeQueueItemSet.iterator());
    }
    public static Stream<AsyncProcessingConfiguration> asStream(AsyncProcessingConfigurationList asyncProcessingConfigurationList) {
    	return asStream(asyncProcessingConfigurationList.iterator());
    }
    public static Stream<ApplicationSecurityTemplate> asStream(ApplicationSecurityTemplateList applicationSecurityTemplateList) {
    	return asStream(applicationSecurityTemplateList.iterator());
    }
    public static Stream<Annotation> asStream(AnnotationSet annotationSet) {
    	return asStream(annotationSet.iterator());
    }
    public static Stream<AddOn> asStream(AddOnSet addOnSet) {
    	return asStream(addOnSet.iterator());
    }
    public static Stream<AddOnInstallationRecord> asStream(AddOnInstallationRecordList addOnInstallationRecordList) {
    	return asStream(addOnInstallationRecordList.iterator());
    }
    public static Stream<ActiveMarking> asStream(ActiveMarkingList activeMarkingList) {
    	return asStream(activeMarkingList.iterator());
    }
    public static Stream<Action> asStream(ActionSet actionSet) {
    	return asStream(actionSet.iterator());
    }
    public static Stream<ActionConsumer> asStream(ActionConsumerSet actionConsumerSet) {
    	return asStream(actionConsumerSet.iterator());
    }
    public static Stream<AccessPermission> asStream(AccessPermissionList accessPermissionList) {
    	return asStream(accessPermissionList.iterator());
    }
    public static Stream<AccessPermissionDescription> asStream(AccessPermissionDescriptionList accessPermissionDescriptionList) {
    	return asStream(accessPermissionDescriptionList.iterator());
    }
    /* End of generated code */
}