package eu.trentorise.smartcampus.domain.discovertrento;

import it.sayservice.platform.core.domain.common.exception.DomainDataHandlerException;
import it.sayservice.platform.core.domain.DomainConst.DOMAIN_OBJECT_EVENT_TYPE;
import it.sayservice.platform.core.domain.DomainRelationTarget;
import it.sayservice.platform.core.domain.bundle.DomainEvent;
import it.sayservice.platform.core.domain.ext.AbstractDOEngineImpl;
import it.sayservice.platform.core.domain.ext.ActionInvoke;
import it.sayservice.platform.core.domain.ext.DomainObjectWrapper;
import it.sayservice.platform.core.domain.ext.LanguageHelper;
import it.sayservice.platform.core.domain.ext.Tuple;
import it.sayservice.platform.core.domain.rules.DomainSubscriptionRule;
import it.sayservice.platform.core.domain.rules.EvaluableDomainSubscriptionRule;
import it.sayservice.platform.core.domain.rules.EvaluableDomainOperation;
import it.sayservice.platform.core.domain.rules.DomainEventDescriptor;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.util.ArrayList;
import java.util.HashMap;

import com.mongodb.DBObject;
import com.mongodb.QueryBuilder;

public class StoryObjectDOEngine extends AbstractDOEngineImpl {

    public StoryObjectDOEngine() {
        super();
    }

    private static String[] actions = new String[]{
            "_process_onRelatedCreate_semanticService",
            "_process_onRelatedDelete_semanticService",
            "_attend",
            "_delete",
            "_destroy",
            "_notAttend",
            "_rate",
            "_update",
            "_updateCommunityData",
            "_updateEntity",
            "callEntityUpdate",
            "initialize",
    };

    protected String[] getSortedActions() {
        return actions;
    }

    private static Map<String,Collection<java.io.Serializable>> extensions = new HashMap<String,Collection<java.io.Serializable>>();
    static {
        extensions.put("it.sayservice.platform.core.domain.actions.InvokeOperation",decodeExtension("rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAAIdwQAAAAKc3IAEWphdmEudXRpbC5IYXNoTWFwBQfawcMWYNEDAAJGAApsb2FkRmFjdG9ySQAJdGhyZXNob2xkeHA/QAAAAAAADHcIAAAAEAAAAAN0AAlvcGVyYXRpb250AAZhdHRlbmR0AAphY3Rpb25OYW1ldAAHX2F0dGVuZHQABHR5cGV0AAVMb2NhbHhzcQB+AAI/QAAAAAAADHcIAAAAEAAAAAV0AAplbmdpbmVUeXBldAAIYWN0aXZpdGlxAH4ABHQAEmRlbGV0ZVNlbWFudGljRGF0YXQACnByb2Nlc3NLZXl0AAxkZWxldGVlbnRpdHl0AA1wcm9jZXNzRGVmVVJJdABQZXUvdHJlbnRvcmlzZS9zbWFydGNhbXB1cy9kb21haW4vZGlzY292ZXJ0cmVudG8vYWN0aXZpdGkvZGVsZXRlZW50aXR5LmJwbW4yMC54bWxxAH4ACHQAB1Byb2Nlc3N4c3EAfgACP0AAAAAAAAx3CAAAABAAAAADcQB+AAR0AAtkZWxldGVTdG9yeXEAfgAGdAAHX2RlbGV0ZXEAfgAIcQB+AAl4c3EAfgACP0AAAAAAAAx3CAAAABAAAAADcQB+AAR0AAlub3RBdHRlbmRxAH4ABnQACl9ub3RBdHRlbmRxAH4ACHEAfgAJeHNxAH4AAj9AAAAAAAAMdwgAAAAQAAAAA3EAfgAEdAAEcmF0ZXEAfgAGdAAFX3JhdGVxAH4ACHEAfgAJeHNxAH4AAj9AAAAAAAAMdwgAAAAQAAAAA3EAfgAEdAATdXBkYXRlQ29tbXVuaXR5RGF0YXEAfgAGdAAUX3VwZGF0ZUNvbW11bml0eURhdGFxAH4ACHEAfgAJeHNxAH4AAj9AAAAAAAAMdwgAAAAQAAAABXEAfgALdAAIYWN0aXZpdGlxAH4ABHQAEnVwZGF0ZVNlbWFudGljRGF0YXEAfgAOdAAMdXBkYXRlZW50aXR5cQB+ABB0AFBldS90cmVudG9yaXNlL3NtYXJ0Y2FtcHVzL2RvbWFpbi9kaXNjb3ZlcnRyZW50by9hY3Rpdml0aS91cGRhdGVlbnRpdHkuYnBtbjIwLnhtbHEAfgAIcQB+ABJ4c3EAfgACP0AAAAAAAAx3CAAAABAAAAADcQB+AAR0AAt1cGRhdGVTdG9yeXEAfgAGdAAHX3VwZGF0ZXEAfgAIcQB+AAl4eA=="));
    }

     public  Collection<java.io.Serializable> getExtensionValues(String property) {
        return extensions.get(property);
     }  
    
    protected Object executeAction(String actionName, DomainObjectWrapper obj, Tuple t, Set<DomainEvent> outEvents, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        if ("_process_onRelatedCreate_semanticService".equals(actionName)) {
            return _process_onRelatedCreate_semanticService(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("_process_onRelatedDelete_semanticService".equals(actionName)) {
            return _process_onRelatedDelete_semanticService(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("_attend".equals(actionName)) {
            return _attend(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("_delete".equals(actionName)) {
            return _delete(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("_destroy".equals(actionName)) {
            return _destroy(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("_notAttend".equals(actionName)) {
            return _notAttend(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("_rate".equals(actionName)) {
            return _rate(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("_update".equals(actionName)) {
            return _update(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("_updateCommunityData".equals(actionName)) {
            return _updateCommunityData(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("_updateEntity".equals(actionName)) {
            return _updateEntity(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("callEntityUpdate".equals(actionName)) {
            return callEntityUpdate(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("initialize".equals(actionName)) {
            return initialize(t, obj, outEvents, ops, securityToken, bundleId);
        }
        return null;
    }

    private Object _attend(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
java.lang.String user = (java.lang.String) tuple.get("user");
{
getDomainObjectHandler().setVar("attending", obj, eu.trentorise.smartcampus.domain.discovertrento.Helper.addUser(getDomainObjectHandler().getVar("attending",obj,java.lang.String[].class,bundleId),user), evts, bundleId);}
return null;
}

    }
    private Object _delete(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
{
if ((getDomainObjectHandler().getVar("entityId",obj,java.lang.Long.class,bundleId) != null) && (getDomainObjectHandler().getVar("entityId",obj,java.lang.Long.class,bundleId)>0)){
{
{
Tuple body = new Tuple();
getDomainObjectHandler().invokeOperation(obj, "deleteSemanticData", body, ops, bundleId);}
}
}
else {
{
{
Tuple body = new Tuple();
_destroy(body, obj, evts, ops, securityToken, bundleId);}
}
}}
return null;
}

    }
    private Object _destroy(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
{
getDomainObjectHandler().terminate(obj,evts,bundleId);}
return null;
}

    }
    private Object _notAttend(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
java.lang.String user = (java.lang.String) tuple.get("user");
{
getDomainObjectHandler().setVar("attending", obj, eu.trentorise.smartcampus.domain.discovertrento.Helper.removeUser(getDomainObjectHandler().getVar("attending",obj,java.lang.String[].class,bundleId),user), evts, bundleId);}
return null;
}

    }
    private Object _rate(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
java.lang.String user = (java.lang.String) tuple.get("user");
java.lang.Integer rating = (java.lang.Integer) tuple.get("rating");
{
getDomainObjectHandler().setVar("communityData", obj, eu.trentorise.smartcampus.domain.discovertrento.Helper.addRating(getDomainObjectHandler().getVar("communityData",obj,eu.trentorise.smartcampus.domain.discovertrento.CommunityData.class,bundleId),user,rating), evts, bundleId);return getDomainObjectHandler().getVar("communityData",obj,eu.trentorise.smartcampus.domain.discovertrento.CommunityData.class,bundleId).getAverageRating();
}
}

    }
    private Object _update(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
eu.trentorise.smartcampus.domain.discovertrento.GenericStory newData = (eu.trentorise.smartcampus.domain.discovertrento.GenericStory) tuple.get("newData");
eu.trentorise.smartcampus.domain.discovertrento.CommunityData newCommunityData = (eu.trentorise.smartcampus.domain.discovertrento.CommunityData) tuple.get("newCommunityData");
{
if ((eu.trentorise.smartcampus.domain.discovertrento.Helper.requiresUpdateOnGenericStory(newData,getDomainObjectHandler().getVar("data",obj,eu.trentorise.smartcampus.domain.discovertrento.GenericStory.class,bundleId))) || (eu.trentorise.smartcampus.domain.discovertrento.Helper.requiresUpdateOnCommunityData(newCommunityData,getDomainObjectHandler().getVar("communityData",obj,eu.trentorise.smartcampus.domain.discovertrento.CommunityData.class,bundleId)))){
{
java.lang.Long[] pois = null;
if ((getDomainObjectHandler().getVar("data",obj,eu.trentorise.smartcampus.domain.discovertrento.GenericStory.class,bundleId) != null) && (getDomainObjectHandler().getVar("data",obj,eu.trentorise.smartcampus.domain.discovertrento.GenericStory.class,bundleId).getSteps() != null)){
{
for (eu.trentorise.smartcampus.domain.discovertrento.GenericStoryStep step:getDomainObjectHandler().getVar("data",obj,eu.trentorise.smartcampus.domain.discovertrento.GenericStory.class,bundleId).getSteps()){
{
List<DomainObjectWrapper> poi = _query___query_4(obj, securityToken, bundleId, step);
if ((LanguageHelper.count(poi)>0) && (getDomainObjectHandler().getVar("entityId",poi.get(0),java.lang.Long.class,bundleId) != null)){
pois = eu.trentorise.smartcampus.domain.discovertrento.Helper.mergeLong(pois,getDomainObjectHandler().getVar("entityId",poi.get(0),java.lang.Long.class,bundleId));
}
}
}
}
}
{
Tuple body = new Tuple();
 body.put("pois",pois);
callEntityUpdate(body, obj, evts, ops, securityToken, bundleId);}
}
}
getDomainObjectHandler().setVar("data", obj, newData, evts, bundleId);getDomainObjectHandler().setVar("communityData", obj, eu.trentorise.smartcampus.domain.discovertrento.Helper.mergeCommunityData(getDomainObjectHandler().getVar("communityData",obj,eu.trentorise.smartcampus.domain.discovertrento.CommunityData.class,bundleId),newCommunityData), evts, bundleId);}
return null;
}

    }
    private Object _updateCommunityData(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
eu.trentorise.smartcampus.domain.discovertrento.CommunityData newCommunityData = (eu.trentorise.smartcampus.domain.discovertrento.CommunityData) tuple.get("newCommunityData");
{
if (eu.trentorise.smartcampus.domain.discovertrento.Helper.requiresUpdateOnCommunityData(newCommunityData,getDomainObjectHandler().getVar("communityData",obj,eu.trentorise.smartcampus.domain.discovertrento.CommunityData.class,bundleId))){
{
{
Tuple body = new Tuple();
 body.put("pois",null);
callEntityUpdate(body, obj, evts, ops, securityToken, bundleId);}
}
}
getDomainObjectHandler().setVar("communityData", obj, eu.trentorise.smartcampus.domain.discovertrento.Helper.mergeCommunityData(getDomainObjectHandler().getVar("communityData",obj,eu.trentorise.smartcampus.domain.discovertrento.CommunityData.class,bundleId),newCommunityData), evts, bundleId);}
return null;
}

    }
    private Object _updateEntity(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
java.lang.Long newId = (java.lang.Long) tuple.get("newId");
{
getDomainObjectHandler().setVar("entityId", obj, newId, evts, bundleId);}
return null;
}

    }
    private Object callEntityUpdate(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
java.lang.Long[] pois = (java.lang.Long[]) tuple.get("pois");
{
if ((getDomainObjectHandler().getVar("entityId",obj,java.lang.Long.class,bundleId) == null) || (getDomainObjectHandler().getVar("entityId",obj,java.lang.Long.class,bundleId)>0)){
{
if (pois != null){
{
{
Tuple body = new Tuple();
 body.put("type","narrative");
 body.put("relations",pois);
getDomainObjectHandler().invokeOperation(obj, "updateSemanticData", body, ops, bundleId);}
}
}
else {
{
{
Tuple body = new Tuple();
 body.put("type","narrative");
 body.put("relations",null);
getDomainObjectHandler().invokeOperation(obj, "updateSemanticData", body, ops, bundleId);}
}
}}
}
}
return null;
}

    }
    private Object initialize(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
{
java.lang.Long[] pois = null;
if ((getDomainObjectHandler().getVar("data",obj,eu.trentorise.smartcampus.domain.discovertrento.GenericStory.class,bundleId) != null) && (getDomainObjectHandler().getVar("data",obj,eu.trentorise.smartcampus.domain.discovertrento.GenericStory.class,bundleId).getSteps() != null)){
{
for (eu.trentorise.smartcampus.domain.discovertrento.GenericStoryStep step:getDomainObjectHandler().getVar("data",obj,eu.trentorise.smartcampus.domain.discovertrento.GenericStory.class,bundleId).getSteps()){
{
List<DomainObjectWrapper> poi = _query___query_5(obj, securityToken, bundleId, step);
if ((LanguageHelper.count(poi)>0) && (getDomainObjectHandler().getVar("entityId",poi.get(0),java.lang.Long.class,bundleId) != null)){
pois = eu.trentorise.smartcampus.domain.discovertrento.Helper.mergeLong(pois,getDomainObjectHandler().getVar("entityId",poi.get(0),java.lang.Long.class,bundleId));
}
}
}
}
}
{
Tuple body = new Tuple();
 body.put("pois",pois);
callEntityUpdate(body, obj, evts, ops, securityToken, bundleId);}
}
return null;
}

    }
    
    private Object _process_onRelatedCreate_semanticService(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
               DomainObjectWrapper created = (DomainObjectWrapper) tuple.get("created");
       getDomainObjectHandler().addRelatedObject("semanticService", obj, created, evts, bundleId);
       return null;

    }
    private Object _process_onRelatedDelete_semanticService(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
               DomainObjectWrapper deleted = (DomainObjectWrapper) tuple.get("deleted");
       getDomainObjectHandler().removeRelatedObject("semanticService", obj, deleted, evts, bundleId);
       return null;

    }
    
    private java.lang.Integer _eval_attendees(DomainObjectWrapper obj, String bundleId) throws DomainDataHandlerException {
        return LanguageHelper.count(getDomainObjectHandler().getVar("attending",obj,java.lang.String[].class,bundleId));
    }
    
    private List<DomainObjectWrapper> _query_semanticService(DomainObjectWrapper obj, String securityToken, String bundleId) throws DomainDataHandlerException {
        List<DomainObjectWrapper> result = new ArrayList<DomainObjectWrapper>();
List<DomainObjectWrapper> _final = new ArrayList<DomainObjectWrapper>();
List<DBObject> queryList = new ArrayList<DBObject>();
    if (true) {
        return getDomainObjectHandler().query("eu.trentorise.smartcampus.domain.semantic.SemanticService", null, securityToken, bundleId);
    }
    return java.util.Collections.emptyList();

    }
    private boolean _matches_semanticService(DomainObjectWrapper target, DomainObjectWrapper obj, String bundleId) throws DomainDataHandlerException {
        return true;
    }
    private List<DomainObjectWrapper> _query___query_4(DomainObjectWrapper obj, String securityToken, String bundleId, eu.trentorise.smartcampus.domain.discovertrento.GenericStoryStep step) throws DomainDataHandlerException {
        List<DomainObjectWrapper> result = new ArrayList<DomainObjectWrapper>();
List<DomainObjectWrapper> _final = new ArrayList<DomainObjectWrapper>();
List<DBObject> queryList = new ArrayList<DBObject>();
    if (true) {
        queryList.add(QueryBuilder.start().and("content.id").is(step.getPoiId()).get());
    }
	try{
    	result = getDomainObjectHandler().query("eu.trentorise.smartcampus.domain.discovertrento.POIObject",QueryBuilder.start().or(queryList.toArray(new DBObject[]{})).get(), securityToken, bundleId);
	} catch(Exception e) {
    	result = getDomainObjectHandler().query("eu.trentorise.smartcampus.domain.discovertrento.POIObject", (DBObject)null, securityToken, bundleId);
    }
    for(DomainObjectWrapper w : result) {
        if (_matches___query_4(w, obj, bundleId, step)) {
            _final.add(w);
        }
    }
    return _final;
    }
    private boolean _matches___query_4(DomainObjectWrapper target, DomainObjectWrapper obj, String bundleId, eu.trentorise.smartcampus.domain.discovertrento.GenericStoryStep step) throws DomainDataHandlerException {
        return getDomainObjectHandler().getVar("id",target,java.lang.String.class,bundleId).equals(step.getPoiId());
    }
    private List<DomainObjectWrapper> _query___query_5(DomainObjectWrapper obj, String securityToken, String bundleId, eu.trentorise.smartcampus.domain.discovertrento.GenericStoryStep step) throws DomainDataHandlerException {
        List<DomainObjectWrapper> result = new ArrayList<DomainObjectWrapper>();
List<DomainObjectWrapper> _final = new ArrayList<DomainObjectWrapper>();
List<DBObject> queryList = new ArrayList<DBObject>();
    if (true) {
        queryList.add(QueryBuilder.start().and("content.id").is(step.getPoiId()).get());
    }
	try{
    	result = getDomainObjectHandler().query("eu.trentorise.smartcampus.domain.discovertrento.POIObject",QueryBuilder.start().or(queryList.toArray(new DBObject[]{})).get(), securityToken, bundleId);
	} catch(Exception e) {
    	result = getDomainObjectHandler().query("eu.trentorise.smartcampus.domain.discovertrento.POIObject", (DBObject)null, securityToken, bundleId);
    }
    for(DomainObjectWrapper w : result) {
        if (_matches___query_5(w, obj, bundleId, step)) {
            _final.add(w);
        }
    }
    return _final;
    }
    private boolean _matches___query_5(DomainObjectWrapper target, DomainObjectWrapper obj, String bundleId, eu.trentorise.smartcampus.domain.discovertrento.GenericStoryStep step) throws DomainDataHandlerException {
        return getDomainObjectHandler().getVar("id",target,java.lang.String.class,bundleId).equals(step.getPoiId());
    }
    
    public void handleObjectRelUpdate(String rName, DomainObjectWrapper obj, Set<DomainEvent> evts, String bundleId) throws DomainDataHandlerException {
            if (false
            ) {
                getDomainObjectHandler().setRelation("semanticService", obj, _query_semanticService(obj, obj.getDomainObject().getSecurityToken(), bundleId), evts, bundleId);
            }
            if (false
              || "attending".equals(rName)
            ) {
                getDomainObjectHandler().setVar("attendees", obj, _eval_attendees(obj, bundleId), evts, bundleId);
            }
    }
    public void handleObjectVarUpdate(String vName, DomainObjectWrapper obj, Set<DomainEvent> evts, String bundleId) throws DomainDataHandlerException {
            if (false
            ) {
                getDomainObjectHandler().setRelation("semanticService", obj, _query_semanticService(obj, obj.getDomainObject().getSecurityToken(), bundleId), evts, bundleId);
            }
            if (false
              || "attending".equals(vName)
            ) {
                getDomainObjectHandler().setVar("attendees", obj, _eval_attendees(obj, bundleId), evts, bundleId);
            }
    }

    public void handleObjectCreate(DomainObjectWrapper obj, Set<DomainEvent> outEvents, Set<EvaluableDomainOperation> ops, String bundleId) throws DomainDataHandlerException {
            getDomainObjectHandler().setRelation("semanticService", obj, _query_semanticService(obj, obj.getDomainObject().getSecurityToken(), bundleId), outEvents, bundleId);
            getDomainObjectHandler().setVar("attendees", obj, _eval_attendees(obj, bundleId), outEvents, bundleId);
        __initialize(new Tuple(), obj, outEvents, ops, obj.getDomainObject().getSecurityToken(),bundleId);
    }

    private Object __initialize(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
{
java.lang.Long[] pois = null;
if ((getDomainObjectHandler().getVar("data",obj,eu.trentorise.smartcampus.domain.discovertrento.GenericStory.class,bundleId) != null) && (getDomainObjectHandler().getVar("data",obj,eu.trentorise.smartcampus.domain.discovertrento.GenericStory.class,bundleId).getSteps() != null)){
{
for (eu.trentorise.smartcampus.domain.discovertrento.GenericStoryStep step:getDomainObjectHandler().getVar("data",obj,eu.trentorise.smartcampus.domain.discovertrento.GenericStory.class,bundleId).getSteps()){
{
List<DomainObjectWrapper> poi = _query___query_5(obj, securityToken, bundleId, step);
if ((LanguageHelper.count(poi)>0) && (getDomainObjectHandler().getVar("entityId",poi.get(0),java.lang.Long.class,bundleId) != null)){
pois = eu.trentorise.smartcampus.domain.discovertrento.Helper.mergeLong(pois,getDomainObjectHandler().getVar("entityId",poi.get(0),java.lang.Long.class,bundleId));
}
}
}
}
}
{
Tuple body = new Tuple();
 body.put("pois",pois);
callEntityUpdate(body, obj, evts, ops, securityToken, bundleId);}
}
return null;
}

    }

    protected ActionInvoke ruleApplies(EvaluableDomainSubscriptionRule rule, DomainObjectWrapper obj, String bundleId) throws DomainDataHandlerException {
        if ("subscribe_relation_onCreated_semanticService".equals(rule.getRule().getEngineName())) {
            DomainObjectWrapper payload = (DomainObjectWrapper) rule.getEvent().getPayload();
            if (_matches_semanticService(payload, obj, bundleId)){
                Tuple tuple = new Tuple();
                tuple.put("created",payload);
                return new ActionInvoke("_process_onRelatedCreate_semanticService", tuple);
            }
        }
        if ("subscribe_relation_onDeleted_semanticService".equals(rule.getRule().getEngineName())) {
            DomainObjectWrapper payload = (DomainObjectWrapper) rule.getEvent().getPayload();
            if (true){
                Tuple tuple = new Tuple();
                tuple.put("deleted",payload);
                return new ActionInvoke("_process_onRelatedDelete_semanticService", tuple);
            }
        }
        return null;
    }


    @Override
    public boolean isRelation(String key) {
        return false
              || "semanticService".equals(key)
        ;    
    }

    @Override
    public String getType() {
        return "eu.trentorise.smartcampus.domain.discovertrento.StoryObject";
    }

    @Override
    public boolean isStatic() {
        return !true;
    }

    private static Collection<String> dependencies = new java.util.HashSet<String>();
    static {
        dependencies.add("eu.trentorise.smartcampus.domain.semantic.SemanticService");
        dependencies.add("eu.trentorise.smartcampus.domain.semantic.SemanticService");
        dependencies.add("eu.trentorise.smartcampus.domain.semantic.SemanticService");
    }

    public Collection<String> getDependencies() {
        return dependencies;
    }

    public Collection<DomainSubscriptionRule> getSubscriptions(DomainObjectWrapper obj, String bundleId) throws DomainDataHandlerException {
        List<DomainSubscriptionRule> rules = new ArrayList<DomainSubscriptionRule>();
        
        {
            DomainSubscriptionRule 
            rule = new DomainSubscriptionRule();
            rule.setName("subscribe_relation_onCreated_semanticService");
            rule.setSourceId(null);
            rule.setSourceType("eu.trentorise.smartcampus.domain.semantic.SemanticService");
            rule.setTargetId(obj.getId());
            rule.setTargetType(obj.getType());
            rule.setEngineName("subscribe_relation_onCreated_semanticService");
            rule.setEventType(DOMAIN_OBJECT_EVENT_TYPE.CREATED .toString());
            rules.add(rule);
        }
        {
            DomainObjectWrapper ref = obj;
            if (getDomainObjectHandler().getRelationLinks("semanticService", ref, bundleId)!=null) {
                for (DomainRelationTarget target : getDomainObjectHandler().getRelationLinks("semanticService", ref, bundleId)) {
                    DomainSubscriptionRule rule1 = new DomainSubscriptionRule();
                    rule1.setName("subscribe_relation_onDeleted_semanticService " + target.getTargetId());
                    rule1.setSourceId(target.getTargetId());
                    rule1.setSourceType("eu.trentorise.smartcampus.domain.semantic.SemanticService");
                    rule1.setTargetId(obj.getId());
                    rule1.setTargetType(obj.getType());
                    rule1.setEngineName("subscribe_relation_onDeleted_semanticService");
                    rule1.setEventType(DOMAIN_OBJECT_EVENT_TYPE.DELETED .toString());
                    rules.add(rule1);
                }
            }
        }
        return rules;
    }

    
    public it.sayservice.platform.domain.model.interfaces.DomainTypeInterface getInterface() throws it.sayservice.platform.core.domain.common.exception.DomainDataHandlerException {
        return eu.trentorise.smartcampus.domain.discovertrento .StoryObjectInterface .getInstance();
    }
    

    public List<DomainSubscriptionRule> findSubscriptionRules(DomainEvent event, String securityToken, String bundleId) throws DomainDataHandlerException {
        List<DomainSubscriptionRule> result = new ArrayList<DomainSubscriptionRule>();
        List<DomainSubscriptionRule> tmp = null;
        return result;
    }
    
    public Collection<DomainEventDescriptor> getEventsToQuery() {
        List<DomainEventDescriptor> result = new ArrayList<DomainEventDescriptor>();
        return result;
    }
    
}


