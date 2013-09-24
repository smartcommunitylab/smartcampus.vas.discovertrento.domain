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

public class ServicePOIObjectDOEngine extends AbstractDOEngineImpl {

    public ServicePOIObjectDOEngine() {
        super();
    }

    private static String[] actions = new String[]{
            "_delete",
            "_follow",
            "_rate",
            "_unfollow",
            "_updateCommunityData",
            "_updateCustomData",
            "update",
    };

    protected String[] getSortedActions() {
        return actions;
    }

    private static Map<String,Collection<java.io.Serializable>> extensions = new HashMap<String,Collection<java.io.Serializable>>();
    static {
        extensions.put("it.sayservice.platform.core.domain.actions.InvokeOperation",decodeExtension("rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAAFdwQAAAAHc3IAEWphdmEudXRpbC5IYXNoTWFwBQfawcMWYNEDAAJGAApsb2FkRmFjdG9ySQAJdGhyZXNob2xkeHA/QAAAAAAADHcIAAAAEAAAAAN0AAlvcGVyYXRpb250AAZmb2xsb3d0AAphY3Rpb25OYW1ldAAHX2ZvbGxvd3QABHR5cGV0AAVMb2NhbHhzcQB+AAI/QAAAAAAADHcIAAAAEAAAAANxAH4ABHQABHJhdGVxAH4ABnQABV9yYXRlcQB+AAhxAH4ACXhzcQB+AAI/QAAAAAAADHcIAAAAEAAAAANxAH4ABHQACHVuZm9sbG93cQB+AAZ0AAlfdW5mb2xsb3dxAH4ACHEAfgAJeHNxAH4AAj9AAAAAAAAMdwgAAAAQAAAAA3EAfgAEdAATdXBkYXRlQ29tbXVuaXR5RGF0YXEAfgAGdAAUX3VwZGF0ZUNvbW11bml0eURhdGFxAH4ACHEAfgAJeHNxAH4AAj9AAAAAAAAMdwgAAAAQAAAAA3EAfgAEdAAQdXBkYXRlQ3VzdG9tRGF0YXEAfgAGdAARX3VwZGF0ZUN1c3RvbURhdGFxAH4ACHEAfgAJeHg="));
    }

     public  Collection<java.io.Serializable> getExtensionValues(String property) {
        return extensions.get(property);
     }  
    
    protected Object executeAction(String actionName, DomainObjectWrapper obj, Tuple t, Set<DomainEvent> outEvents, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        if ("_delete".equals(actionName)) {
            return _delete(t, obj, outEvents, ops, securityToken, bundleId);
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
        if ("_updateCommunityData".equals(actionName)) {
            return _updateCommunityData(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("_updateCustomData".equals(actionName)) {
            return _updateCustomData(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("update".equals(actionName)) {
            return update(t, obj, outEvents, ops, securityToken, bundleId);
        }
        return null;
    }

    private Object _delete(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
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
    private Object _updateCommunityData(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
eu.trentorise.smartcampus.domain.discovertrento.CommunityData newCommunityData = (eu.trentorise.smartcampus.domain.discovertrento.CommunityData) tuple.get("newCommunityData");
{
getDomainObjectHandler().setVar("communityData", obj, eu.trentorise.smartcampus.domain.discovertrento.Helper.mergeCommunityData(getDomainObjectHandler().getVar("communityData",obj,eu.trentorise.smartcampus.domain.discovertrento.CommunityData.class,bundleId),newCommunityData), evts, bundleId);}
return null;
}

    }
    private Object _updateCustomData(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
eu.trentorise.smartcampus.domain.discovertrento.POICustomData newCustomData = (eu.trentorise.smartcampus.domain.discovertrento.POICustomData) tuple.get("newCustomData");
eu.trentorise.smartcampus.domain.discovertrento.CommunityData newCommunityData = (eu.trentorise.smartcampus.domain.discovertrento.CommunityData) tuple.get("newCommunityData");
{
getDomainObjectHandler().setVar("customData", obj, newCustomData, evts, bundleId);getDomainObjectHandler().setVar("communityData", obj, newCommunityData, evts, bundleId);}
return null;
}

    }
    private Object update(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
eu.trentorise.smartcampus.domain.discovertrento.GenericPOI p = (eu.trentorise.smartcampus.domain.discovertrento.GenericPOI) tuple.get("p");
{
getDomainObjectHandler().setVar("data", obj, p, evts, bundleId);}
return null;
}

    }
    
    
    
    
    public void handleObjectRelUpdate(String rName, DomainObjectWrapper obj, Set<DomainEvent> evts, String bundleId) throws DomainDataHandlerException {
    }
    public void handleObjectVarUpdate(String vName, DomainObjectWrapper obj, Set<DomainEvent> evts, String bundleId) throws DomainDataHandlerException {
    }

    public void handleObjectCreate(DomainObjectWrapper obj, Set<DomainEvent> outEvents, Set<EvaluableDomainOperation> ops, String bundleId) throws DomainDataHandlerException {
        __initialize(new Tuple(), obj, outEvents, ops, obj.getDomainObject().getSecurityToken(),bundleId);
    }

    private Object __initialize(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        return null;
    }

    protected ActionInvoke ruleApplies(EvaluableDomainSubscriptionRule rule, DomainObjectWrapper obj, String bundleId) throws DomainDataHandlerException {
        if ("declared_subscription_sub_0".equals(rule.getRule().getEngineName())) {
            Tuple payload = (Tuple) rule.getEvent().getPayload();
            java.lang.String id = (java.lang.String) payload.get("id");
            eu.trentorise.smartcampus.domain.discovertrento.GenericPOI poi = (eu.trentorise.smartcampus.domain.discovertrento.GenericPOI) payload.get("poi");
            String name = (String) payload.get("name");
            if (((true) && (id.equals(getDomainObjectHandler().getVar("id",obj,java.lang.String.class,bundleId)))) && (name.equals("updatePOI"))){
                Tuple tuple = new Tuple();
                tuple.put("p",poi);
                return new ActionInvoke("update", tuple);
            }
        }
        return null;
    }


    @Override
    public boolean isRelation(String key) {
        return false
        ;    
    }

    @Override
    public String getType() {
        return "eu.trentorise.smartcampus.domain.discovertrento.ServicePOIObject";
    }

    @Override
    public boolean isStatic() {
        return !true;
    }

    private static Collection<String> dependencies = new java.util.HashSet<String>();
    static {
        dependencies.add("eu.trentorise.smartcampus.domain.discovertrento.ServicePOIFactory");
    }

    public Collection<String> getDependencies() {
        return dependencies;
    }

    public Collection<DomainSubscriptionRule> getSubscriptions(DomainObjectWrapper obj, String bundleId) throws DomainDataHandlerException {
        List<DomainSubscriptionRule> rules = new ArrayList<DomainSubscriptionRule>();
        
        {
            DomainSubscriptionRule 
            rule = new DomainSubscriptionRule();
            rule.setName("declared_subscription_sub_0");
            rule.setSourceId(null);
            rule.setSourceType("eu.trentorise.smartcampus.domain.discovertrento.ServicePOIFactory");
            rule.setTargetId(obj.getId());
            rule.setTargetType(obj.getType());
            rule.setEngineName("declared_subscription_sub_0");
            rule.setEventType(DOMAIN_OBJECT_EVENT_TYPE.CUSTOM .toString());
            rule.setEventSubtype("updatePOI");
            Map<String,Object> queryParams = _subscriptionFunction_declared_subscription_sub_0 (obj,bundleId); 
            if (queryParams != null) {
                if (!queryParams.isEmpty()) {
                    rule.setQueryParameters(queryParams);
                }
                rules.add(rule);
            }
        }
        return rules;
    }

    
    public it.sayservice.platform.domain.model.interfaces.DomainTypeInterface getInterface() throws it.sayservice.platform.core.domain.common.exception.DomainDataHandlerException {
        return eu.trentorise.smartcampus.domain.discovertrento .ServicePOIObjectInterface .getInstance();
    }
    
    private java.util.Map<String,Object> _subscriptionFunction_declared_subscription_sub_0(DomainObjectWrapper obj, String bundleId) throws DomainDataHandlerException {
            boolean pre = false;
    Map<String,Object> result = new HashMap<String,Object>();
    if (true) {
        pre = true;
    }
    result.putAll(QueryBuilder.start().and("p_871570928").is(getDomainObjectHandler().getVar("id",obj,java.lang.String.class,bundleId)).get().toMap());
    if (!pre) return null;
    return result;

    }

    private java.util.List<DomainSubscriptionRule> _subscriptionQuery_declared_subscription_sub_0(DomainEvent evt, String securityToken, String bundleId) throws DomainDataHandlerException {
        Tuple payload = (Tuple) evt.getPayload();
        java.lang.String id = (java.lang.String) payload.get("id");
        eu.trentorise.smartcampus.domain.discovertrento.GenericPOI poi = (eu.trentorise.smartcampus.domain.discovertrento.GenericPOI) payload.get("poi");
        String name = (String) payload.get("name");
            List<DBObject> queryList = new ArrayList<DBObject>();
    if (name.equals("updatePOI")) {
        queryList.add(QueryBuilder.start().and("queryParameters.p_871570928").is(id).get());
    }
    if (queryList.isEmpty()) return Collections.emptyList();
    return getDomainObjectHandler().querySubs(evt, "eu.trentorise.smartcampus.domain.discovertrento.ServicePOIObject", "declared_subscription_sub_0", QueryBuilder.start().or(queryList.toArray(new DBObject[]{})).get(), securityToken, bundleId);

    }

    public List<DomainSubscriptionRule> findSubscriptionRules(DomainEvent event, String securityToken, String bundleId) throws DomainDataHandlerException {
        List<DomainSubscriptionRule> result = new ArrayList<DomainSubscriptionRule>();
        List<DomainSubscriptionRule> tmp = null;
        if (event.getAllTypes().contains("eu.trentorise.smartcampus.domain.discovertrento.ServicePOIFactory")
            && DOMAIN_OBJECT_EVENT_TYPE.CUSTOM .equals(event.getEventType())
            && "updatePOI".equals(event.getEventSubtype())
            ) {
            tmp = _subscriptionQuery_declared_subscription_sub_0 (event, securityToken, bundleId);
            if (tmp != null && !tmp.isEmpty()) {
                result.addAll(tmp);
            }
        }   
        return result;
    }
    
    public Collection<DomainEventDescriptor> getEventsToQuery() {
        List<DomainEventDescriptor> result = new ArrayList<DomainEventDescriptor>();
        result.add(new DomainEventDescriptor(
            "eu.trentorise.smartcampus.domain.discovertrento.ServicePOIFactory",
            DOMAIN_OBJECT_EVENT_TYPE.CUSTOM, 
            "updatePOI",
            null
            ));        
        return result;
    }
    
}


