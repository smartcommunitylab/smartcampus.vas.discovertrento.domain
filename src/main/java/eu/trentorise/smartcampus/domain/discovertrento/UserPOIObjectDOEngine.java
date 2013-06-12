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

public class UserPOIObjectDOEngine extends AbstractDOEngineImpl {

    public UserPOIObjectDOEngine() {
        super();
    }

    private static String[] actions = new String[]{
            "_process_onRelatedCreate_semanticService",
            "_process_onRelatedDelete_semanticService",
            "_delete",
            "_destroy",
            "_follow",
            "_rate",
            "_unfollow",
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
        extensions.put("it.sayservice.platform.core.domain.actions.InvokeOperation",decodeExtension("rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAAIdwQAAAALc3IAEWphdmEudXRpbC5IYXNoTWFwBQfawcMWYNEDAAJGAApsb2FkRmFjdG9ySQAJdGhyZXNob2xkeHA/QAAAAAAADHcIAAAAEAAAAAN0AAlvcGVyYXRpb250AAlkZWxldGVQT0l0AAphY3Rpb25OYW1ldAAHX2RlbGV0ZXQABHR5cGV0AAVMb2NhbHhzcQB+AAI/QAAAAAAADHcIAAAAEAAAAAV0AAplbmdpbmVUeXBldAAIYWN0aXZpdGlxAH4ABHQAEmRlbGV0ZVNlbWFudGljRGF0YXQACnByb2Nlc3NLZXl0AAxkZWxldGVlbnRpdHl0AA1wcm9jZXNzRGVmVVJJdABQZXUvdHJlbnRvcmlzZS9zbWFydGNhbXB1cy9kb21haW4vZGlzY292ZXJ0cmVudG8vYWN0aXZpdGkvZGVsZXRlZW50aXR5LmJwbW4yMC54bWxxAH4ACHQAB1Byb2Nlc3N4c3EAfgACP0AAAAAAAAx3CAAAABAAAAADcQB+AAR0AAZmb2xsb3dxAH4ABnQAB19mb2xsb3dxAH4ACHEAfgAJeHNxAH4AAj9AAAAAAAAMdwgAAAAQAAAAA3EAfgAEdAAEcmF0ZXEAfgAGdAAFX3JhdGVxAH4ACHEAfgAJeHNxAH4AAj9AAAAAAAAMdwgAAAAQAAAAA3EAfgAEdAAIdW5mb2xsb3dxAH4ABnQACV91bmZvbGxvd3EAfgAIcQB+AAl4c3EAfgACP0AAAAAAAAx3CAAAABAAAAADcQB+AAR0ABN1cGRhdGVDb21tdW5pdHlEYXRhcQB+AAZ0ABRfdXBkYXRlQ29tbXVuaXR5RGF0YXEAfgAIcQB+AAl4c3EAfgACP0AAAAAAAAx3CAAAABAAAAADcQB+AAR0AAl1cGRhdGVQT0lxAH4ABnQAB191cGRhdGVxAH4ACHEAfgAJeHNxAH4AAj9AAAAAAAAMdwgAAAAQAAAABXEAfgALdAAIYWN0aXZpdGlxAH4ABHQAEnVwZGF0ZVNlbWFudGljRGF0YXEAfgAOdAAMdXBkYXRlZW50aXR5cQB+ABB0AFBldS90cmVudG9yaXNlL3NtYXJ0Y2FtcHVzL2RvbWFpbi9kaXNjb3ZlcnRyZW50by9hY3Rpdml0aS91cGRhdGVlbnRpdHkuYnBtbjIwLnhtbHEAfgAIcQB+ABJ4eA=="));
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
        if ("_delete".equals(actionName)) {
            return _delete(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("_destroy".equals(actionName)) {
            return _destroy(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("_follow".equals(actionName)) {
            return _follow(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("_rate".equals(actionName)) {
            return _rate(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("_unfollow".equals(actionName)) {
            return _unfollow(t, obj, outEvents, ops, securityToken, bundleId);
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
    private Object _follow(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
java.lang.String user = (java.lang.String) tuple.get("user");
java.lang.String topic = (java.lang.String) tuple.get("topic");
{
getDomainObjectHandler().setVar("communityData", obj, eu.trentorise.smartcampus.domain.discovertrento.Helper.follow(getDomainObjectHandler().getVar("communityData",obj,eu.trentorise.smartcampus.domain.discovertrento.CommunityData.class,bundleId),user,topic), evts, bundleId);}
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
    private Object _unfollow(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
java.lang.String user = (java.lang.String) tuple.get("user");
{
getDomainObjectHandler().setVar("communityData", obj, eu.trentorise.smartcampus.domain.discovertrento.Helper.unfollow(getDomainObjectHandler().getVar("communityData",obj,eu.trentorise.smartcampus.domain.discovertrento.CommunityData.class,bundleId),user), evts, bundleId);}
return null;
}

    }
    private Object _update(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
eu.trentorise.smartcampus.domain.discovertrento.GenericPOI newData = (eu.trentorise.smartcampus.domain.discovertrento.GenericPOI) tuple.get("newData");
eu.trentorise.smartcampus.domain.discovertrento.CommunityData newCommunityData = (eu.trentorise.smartcampus.domain.discovertrento.CommunityData) tuple.get("newCommunityData");
{
if ((eu.trentorise.smartcampus.domain.discovertrento.Helper.requiresUpdateOnCommunityData(newCommunityData,getDomainObjectHandler().getVar("communityData",obj,eu.trentorise.smartcampus.domain.discovertrento.CommunityData.class,bundleId))) || (eu.trentorise.smartcampus.domain.discovertrento.Helper.requiresUpdateOnGenericPOI(getDomainObjectHandler().getVar("data",obj,eu.trentorise.smartcampus.domain.discovertrento.GenericPOI.class,bundleId),newData))){
{
{
Tuple body = new Tuple();
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
{
if ((getDomainObjectHandler().getVar("entityId",obj,java.lang.Long.class,bundleId) == null) || (getDomainObjectHandler().getVar("entityId",obj,java.lang.Long.class,bundleId)>0)){
{
{
Tuple body = new Tuple();
 body.put("type","location");
 body.put("relations",null);
getDomainObjectHandler().invokeOperation(obj, "updateSemanticData", body, ops, bundleId);}
}
}
}
return null;
}

    }
    private Object initialize(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
{
{
Tuple body = new Tuple();
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
    
    public void handleObjectRelUpdate(String rName, DomainObjectWrapper obj, Set<DomainEvent> evts, String bundleId) throws DomainDataHandlerException {
            if (false
            ) {
                getDomainObjectHandler().setRelation("semanticService", obj, _query_semanticService(obj, obj.getDomainObject().getSecurityToken(), bundleId), evts, bundleId);
            }
    }
    public void handleObjectVarUpdate(String vName, DomainObjectWrapper obj, Set<DomainEvent> evts, String bundleId) throws DomainDataHandlerException {
            if (false
            ) {
                getDomainObjectHandler().setRelation("semanticService", obj, _query_semanticService(obj, obj.getDomainObject().getSecurityToken(), bundleId), evts, bundleId);
            }
    }

    public void handleObjectCreate(DomainObjectWrapper obj, Set<DomainEvent> outEvents, Set<EvaluableDomainOperation> ops, String bundleId) throws DomainDataHandlerException {
            getDomainObjectHandler().setRelation("semanticService", obj, _query_semanticService(obj, obj.getDomainObject().getSecurityToken(), bundleId), outEvents, bundleId);
        __initialize(new Tuple(), obj, outEvents, ops, obj.getDomainObject().getSecurityToken(),bundleId);
    }

    private Object __initialize(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
{
{
Tuple body = new Tuple();
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
        return "eu.trentorise.smartcampus.domain.discovertrento.UserPOIObject";
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
        return eu.trentorise.smartcampus.domain.discovertrento .UserPOIObjectInterface .getInstance();
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


