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

public class ServiceEventObjectDOEngine extends AbstractDOEngineImpl {

    public ServiceEventObjectDOEngine() {
        super();
    }

    private static String[] actions = new String[]{
            "_attend",
            "_delete",
            "_follow",
            "_notAttend",
            "_rate",
            "_unfollow",
            "_updateCommunityData",
            "_updateCustomData",
            "changePOI",
            "initialize",
            "update",
    };

    protected String[] getSortedActions() {
        return actions;
    }

    private static Map<String,Collection<java.io.Serializable>> extensions = new HashMap<String,Collection<java.io.Serializable>>();
    static {
        extensions.put("it.sayservice.platform.core.domain.actions.InvokeOperation",decodeExtension("rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAAHdwQAAAAKc3IAEWphdmEudXRpbC5IYXNoTWFwBQfawcMWYNEDAAJGAApsb2FkRmFjdG9ySQAJdGhyZXNob2xkeHA/QAAAAAAADHcIAAAAEAAAAAN0AAlvcGVyYXRpb250AAZhdHRlbmR0AAphY3Rpb25OYW1ldAAHX2F0dGVuZHQABHR5cGV0AAVMb2NhbHhzcQB+AAI/QAAAAAAADHcIAAAAEAAAAANxAH4ABHQABmZvbGxvd3EAfgAGdAAHX2ZvbGxvd3EAfgAIcQB+AAl4c3EAfgACP0AAAAAAAAx3CAAAABAAAAADcQB+AAR0AAlub3RBdHRlbmRxAH4ABnQACl9ub3RBdHRlbmRxAH4ACHEAfgAJeHNxAH4AAj9AAAAAAAAMdwgAAAAQAAAAA3EAfgAEdAAEcmF0ZXEAfgAGdAAFX3JhdGVxAH4ACHEAfgAJeHNxAH4AAj9AAAAAAAAMdwgAAAAQAAAAA3EAfgAEdAAIdW5mb2xsb3dxAH4ABnQACV91bmZvbGxvd3EAfgAIcQB+AAl4c3EAfgACP0AAAAAAAAx3CAAAABAAAAADcQB+AAR0ABN1cGRhdGVDb21tdW5pdHlEYXRhcQB+AAZ0ABRfdXBkYXRlQ29tbXVuaXR5RGF0YXEAfgAIcQB+AAl4c3EAfgACP0AAAAAAAAx3CAAAABAAAAADcQB+AAR0ABB1cGRhdGVDdXN0b21EYXRhcQB+AAZ0ABFfdXBkYXRlQ3VzdG9tRGF0YXEAfgAIcQB+AAl4eA=="));
    }

     public  Collection<java.io.Serializable> getExtensionValues(String property) {
        return extensions.get(property);
     }  
    
    protected Object executeAction(String actionName, DomainObjectWrapper obj, Tuple t, Set<DomainEvent> outEvents, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        if ("_attend".equals(actionName)) {
            return _attend(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("_delete".equals(actionName)) {
            return _delete(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("_follow".equals(actionName)) {
            return _follow(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("_notAttend".equals(actionName)) {
            return _notAttend(t, obj, outEvents, ops, securityToken, bundleId);
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
        if ("changePOI".equals(actionName)) {
            return changePOI(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("initialize".equals(actionName)) {
            return initialize(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("update".equals(actionName)) {
            return update(t, obj, outEvents, ops, securityToken, bundleId);
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
eu.trentorise.smartcampus.domain.discovertrento.EventCustomData newCustomData = (eu.trentorise.smartcampus.domain.discovertrento.EventCustomData) tuple.get("newCustomData");
eu.trentorise.smartcampus.domain.discovertrento.CommunityData newCommunityData = (eu.trentorise.smartcampus.domain.discovertrento.CommunityData) tuple.get("newCommunityData");
{
if ((newCustomData != null) && (newCustomData.getPoiId() != null)){
{
getDomainObjectHandler().setRelation("poi", obj, _query___query_1(obj, securityToken, bundleId, newCustomData), evts, bundleId);}
}
getDomainObjectHandler().setVar("customData", obj, newCustomData, evts, bundleId);getDomainObjectHandler().setVar("communityData", obj, newCommunityData, evts, bundleId);}
return null;
}

    }
    private Object changePOI(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
java.lang.String newId = (java.lang.String) tuple.get("newId");
{
getDomainObjectHandler().setRelation("poi", obj, _query___query_2(obj, securityToken, bundleId, newId), evts, bundleId);}
return null;
}

    }
    private Object initialize(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
{
getDomainObjectHandler().setRelation("poi", obj, _query___query_3(obj, securityToken, bundleId), evts, bundleId);}
return null;
}

    }
    private Object update(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
eu.trentorise.smartcampus.domain.discovertrento.GenericEvent evt = (eu.trentorise.smartcampus.domain.discovertrento.GenericEvent) tuple.get("evt");
{
List<DomainObjectWrapper> newPois = _query___query_4(obj, securityToken, bundleId, evt);
if ((newPois != null) && (LanguageHelper.count(newPois)>0)){
{
getDomainObjectHandler().setRelation("poi", obj, newPois.get(0), evts, bundleId);}
}
getDomainObjectHandler().setVar("data", obj, evt, evts, bundleId);}
return null;
}

    }
    
    
    private java.lang.Integer _eval_attendees(DomainObjectWrapper obj, String bundleId) throws DomainDataHandlerException {
        return LanguageHelper.count(getDomainObjectHandler().getVar("attending",obj,java.lang.String[].class,bundleId));
    }
    
    private List<DomainObjectWrapper> _query___query_1(DomainObjectWrapper obj, String securityToken, String bundleId, eu.trentorise.smartcampus.domain.discovertrento.EventCustomData newCustomData) throws DomainDataHandlerException {
        List<DomainObjectWrapper> result = new ArrayList<DomainObjectWrapper>();
List<DomainObjectWrapper> _final = new ArrayList<DomainObjectWrapper>();
List<DBObject> queryList = new ArrayList<DBObject>();
    if (true) {
        queryList.add(QueryBuilder.start().and("content.id").is(newCustomData.getPoiId()).get());
    }
	try{
    	result = getDomainObjectHandler().query("eu.trentorise.smartcampus.domain.discovertrento.POIObject",QueryBuilder.start().or(queryList.toArray(new DBObject[]{})).get(), securityToken, bundleId);
	} catch(Exception e) {
    	result = getDomainObjectHandler().query("eu.trentorise.smartcampus.domain.discovertrento.POIObject", (DBObject)null, securityToken, bundleId);
    }
    for(DomainObjectWrapper w : result) {
        if (_matches___query_1(w, obj, bundleId, newCustomData)) {
            _final.add(w);
        }
    }
    return _final;
    }
    private boolean _matches___query_1(DomainObjectWrapper target, DomainObjectWrapper obj, String bundleId, eu.trentorise.smartcampus.domain.discovertrento.EventCustomData newCustomData) throws DomainDataHandlerException {
        return getDomainObjectHandler().getVar("id",target,java.lang.String.class,bundleId).equals(newCustomData.getPoiId());
    }
    private List<DomainObjectWrapper> _query___query_2(DomainObjectWrapper obj, String securityToken, String bundleId, java.lang.String newId) throws DomainDataHandlerException {
        List<DomainObjectWrapper> result = new ArrayList<DomainObjectWrapper>();
List<DomainObjectWrapper> _final = new ArrayList<DomainObjectWrapper>();
List<DBObject> queryList = new ArrayList<DBObject>();
    if (true) {
        queryList.add(QueryBuilder.start().and("content.id").is(newId).get());
    }
	try{
    	result = getDomainObjectHandler().query("eu.trentorise.smartcampus.domain.discovertrento.POIObject",QueryBuilder.start().or(queryList.toArray(new DBObject[]{})).get(), securityToken, bundleId);
	} catch(Exception e) {
    	result = getDomainObjectHandler().query("eu.trentorise.smartcampus.domain.discovertrento.POIObject", (DBObject)null, securityToken, bundleId);
    }
    for(DomainObjectWrapper w : result) {
        if (_matches___query_2(w, obj, bundleId, newId)) {
            _final.add(w);
        }
    }
    return _final;
    }
    private boolean _matches___query_2(DomainObjectWrapper target, DomainObjectWrapper obj, String bundleId, java.lang.String newId) throws DomainDataHandlerException {
        return getDomainObjectHandler().getVar("id",target,java.lang.String.class,bundleId).equals(newId);
    }
    private List<DomainObjectWrapper> _query___query_3(DomainObjectWrapper obj, String securityToken, String bundleId) throws DomainDataHandlerException {
        List<DomainObjectWrapper> result = new ArrayList<DomainObjectWrapper>();
List<DomainObjectWrapper> _final = new ArrayList<DomainObjectWrapper>();
List<DBObject> queryList = new ArrayList<DBObject>();
    if (true) {
        queryList.add(QueryBuilder.start().and("content.id").is(getDomainObjectHandler().getVar("data",obj,eu.trentorise.smartcampus.domain.discovertrento.GenericEvent.class,bundleId).getPoiId()).get());
    }
	try{
    	result = getDomainObjectHandler().query("eu.trentorise.smartcampus.domain.discovertrento.POIObject",QueryBuilder.start().or(queryList.toArray(new DBObject[]{})).get(), securityToken, bundleId);
	} catch(Exception e) {
    	result = getDomainObjectHandler().query("eu.trentorise.smartcampus.domain.discovertrento.POIObject", (DBObject)null, securityToken, bundleId);
    }
    for(DomainObjectWrapper w : result) {
        if (_matches___query_3(w, obj, bundleId)) {
            _final.add(w);
        }
    }
    return _final;
    }
    private boolean _matches___query_3(DomainObjectWrapper target, DomainObjectWrapper obj, String bundleId) throws DomainDataHandlerException {
        return getDomainObjectHandler().getVar("id",target,java.lang.String.class,bundleId).equals(getDomainObjectHandler().getVar("data",obj,eu.trentorise.smartcampus.domain.discovertrento.GenericEvent.class,bundleId).getPoiId());
    }
    private List<DomainObjectWrapper> _query___query_4(DomainObjectWrapper obj, String securityToken, String bundleId, eu.trentorise.smartcampus.domain.discovertrento.GenericEvent evt) throws DomainDataHandlerException {
        List<DomainObjectWrapper> result = new ArrayList<DomainObjectWrapper>();
List<DomainObjectWrapper> _final = new ArrayList<DomainObjectWrapper>();
List<DBObject> queryList = new ArrayList<DBObject>();
    if (true) {
        queryList.add(QueryBuilder.start().and("content.id").is(evt.getPoiId()).get());
    }
	try{
    	result = getDomainObjectHandler().query("eu.trentorise.smartcampus.domain.discovertrento.POIObject",QueryBuilder.start().or(queryList.toArray(new DBObject[]{})).get(), securityToken, bundleId);
	} catch(Exception e) {
    	result = getDomainObjectHandler().query("eu.trentorise.smartcampus.domain.discovertrento.POIObject", (DBObject)null, securityToken, bundleId);
    }
    for(DomainObjectWrapper w : result) {
        if (_matches___query_4(w, obj, bundleId, evt)) {
            _final.add(w);
        }
    }
    return _final;
    }
    private boolean _matches___query_4(DomainObjectWrapper target, DomainObjectWrapper obj, String bundleId, eu.trentorise.smartcampus.domain.discovertrento.GenericEvent evt) throws DomainDataHandlerException {
        return getDomainObjectHandler().getVar("id",target,java.lang.String.class,bundleId).equals(evt.getPoiId());
    }
    
    public void handleObjectRelUpdate(String rName, DomainObjectWrapper obj, Set<DomainEvent> evts, String bundleId) throws DomainDataHandlerException {
            if (false
              || "attending".equals(rName)
            ) {
                getDomainObjectHandler().setVar("attendees", obj, _eval_attendees(obj, bundleId), evts, bundleId);
            }
    }
    public void handleObjectVarUpdate(String vName, DomainObjectWrapper obj, Set<DomainEvent> evts, String bundleId) throws DomainDataHandlerException {
            if (false
              || "attending".equals(vName)
            ) {
                getDomainObjectHandler().setVar("attendees", obj, _eval_attendees(obj, bundleId), evts, bundleId);
            }
    }

    public void handleObjectCreate(DomainObjectWrapper obj, Set<DomainEvent> outEvents, Set<EvaluableDomainOperation> ops, String bundleId) throws DomainDataHandlerException {
            getDomainObjectHandler().setVar("attendees", obj, _eval_attendees(obj, bundleId), outEvents, bundleId);
        __initialize(new Tuple(), obj, outEvents, ops, obj.getDomainObject().getSecurityToken(),bundleId);
    }

    private Object __initialize(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
{
getDomainObjectHandler().setRelation("poi", obj, _query___query_3(obj, securityToken, bundleId), evts, bundleId);}
return null;
}

    }

    protected ActionInvoke ruleApplies(EvaluableDomainSubscriptionRule rule, DomainObjectWrapper obj, String bundleId) throws DomainDataHandlerException {
        if ("declared_subscription_sub_0".equals(rule.getRule().getEngineName())) {
            Tuple payload = (Tuple) rule.getEvent().getPayload();
            java.lang.String id = (java.lang.String) payload.get("id");
            eu.trentorise.smartcampus.domain.discovertrento.GenericEvent event = (eu.trentorise.smartcampus.domain.discovertrento.GenericEvent) payload.get("event");
            String name = (String) payload.get("name");
            if (((true) && (id.equals(getDomainObjectHandler().getVar("id",obj,java.lang.String.class,bundleId)))) && (name.equals("updateEvent"))){
                Tuple tuple = new Tuple();
                tuple.put("evt",event);
                return new ActionInvoke("update", tuple);
            }
        }
        if ("declared_subscription_sub_1".equals(rule.getRule().getEngineName())) {
            Tuple payload = (Tuple) rule.getEvent().getPayload();
            java.lang.String id = (java.lang.String) payload.get("id");
            String name = (String) payload.get("name");
            if (((true) && (id.equals(getDomainObjectHandler().getVar("id",obj,java.lang.String.class,bundleId)))) && (name.equals("deleteEvent"))){
                Tuple tuple = new Tuple();
                return new ActionInvoke("_delete", tuple);
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
        return "eu.trentorise.smartcampus.domain.discovertrento.ServiceEventObject";
    }

    @Override
    public boolean isStatic() {
        return !true;
    }

    private static Collection<String> dependencies = new java.util.HashSet<String>();
    static {
        dependencies.add("eu.trentorise.smartcampus.domain.discovertrento.ServiceEventFactory");
        dependencies.add("eu.trentorise.smartcampus.domain.discovertrento.ServiceEventFactory");
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
            rule.setSourceType("eu.trentorise.smartcampus.domain.discovertrento.ServiceEventFactory");
            rule.setTargetId(obj.getId());
            rule.setTargetType(obj.getType());
            rule.setEngineName("declared_subscription_sub_0");
            rule.setEventType(DOMAIN_OBJECT_EVENT_TYPE.CUSTOM .toString());
            rule.setEventSubtype("updateEvent");
            Map<String,Object> queryParams = _subscriptionFunction_declared_subscription_sub_0 (obj,bundleId); 
            if (queryParams != null) {
                if (!queryParams.isEmpty()) {
                    rule.setQueryParameters(queryParams);
                }
                rules.add(rule);
            }
        }
        {
            DomainSubscriptionRule 
            rule = new DomainSubscriptionRule();
            rule.setName("declared_subscription_sub_1");
            rule.setSourceId(null);
            rule.setSourceType("eu.trentorise.smartcampus.domain.discovertrento.ServiceEventFactory");
            rule.setTargetId(obj.getId());
            rule.setTargetType(obj.getType());
            rule.setEngineName("declared_subscription_sub_1");
            rule.setEventType(DOMAIN_OBJECT_EVENT_TYPE.CUSTOM .toString());
            rule.setEventSubtype("deleteEvent");
            Map<String,Object> queryParams = _subscriptionFunction_declared_subscription_sub_1 (obj,bundleId); 
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
        return eu.trentorise.smartcampus.domain.discovertrento .ServiceEventObjectInterface .getInstance();
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
        eu.trentorise.smartcampus.domain.discovertrento.GenericEvent event = (eu.trentorise.smartcampus.domain.discovertrento.GenericEvent) payload.get("event");
        String name = (String) payload.get("name");
            List<DBObject> queryList = new ArrayList<DBObject>();
    if (name.equals("updateEvent")) {
        queryList.add(QueryBuilder.start().and("queryParameters.p_871570928").is(id).get());
    }
    if (queryList.isEmpty()) return Collections.emptyList();
    return getDomainObjectHandler().querySubs(evt, "eu.trentorise.smartcampus.domain.discovertrento.ServiceEventObject", "declared_subscription_sub_0", QueryBuilder.start().or(queryList.toArray(new DBObject[]{})).get(), securityToken, bundleId);

    }
    private java.util.Map<String,Object> _subscriptionFunction_declared_subscription_sub_1(DomainObjectWrapper obj, String bundleId) throws DomainDataHandlerException {
            boolean pre = false;
    Map<String,Object> result = new HashMap<String,Object>();
    if (true) {
        pre = true;
    }
    result.putAll(QueryBuilder.start().and("p_871570928").is(getDomainObjectHandler().getVar("id",obj,java.lang.String.class,bundleId)).get().toMap());
    if (!pre) return null;
    return result;

    }

    private java.util.List<DomainSubscriptionRule> _subscriptionQuery_declared_subscription_sub_1(DomainEvent evt, String securityToken, String bundleId) throws DomainDataHandlerException {
        Tuple payload = (Tuple) evt.getPayload();
        java.lang.String id = (java.lang.String) payload.get("id");
        String name = (String) payload.get("name");
            List<DBObject> queryList = new ArrayList<DBObject>();
    if (name.equals("deleteEvent")) {
        queryList.add(QueryBuilder.start().and("queryParameters.p_871570928").is(id).get());
    }
    if (queryList.isEmpty()) return Collections.emptyList();
    return getDomainObjectHandler().querySubs(evt, "eu.trentorise.smartcampus.domain.discovertrento.ServiceEventObject", "declared_subscription_sub_1", QueryBuilder.start().or(queryList.toArray(new DBObject[]{})).get(), securityToken, bundleId);

    }

    public List<DomainSubscriptionRule> findSubscriptionRules(DomainEvent event, String securityToken, String bundleId) throws DomainDataHandlerException {
        List<DomainSubscriptionRule> result = new ArrayList<DomainSubscriptionRule>();
        List<DomainSubscriptionRule> tmp = null;
        if (event.getAllTypes().contains("eu.trentorise.smartcampus.domain.discovertrento.ServiceEventFactory")
            && DOMAIN_OBJECT_EVENT_TYPE.CUSTOM .equals(event.getEventType())
            && "updateEvent".equals(event.getEventSubtype())
            ) {
            tmp = _subscriptionQuery_declared_subscription_sub_0 (event, securityToken, bundleId);
            if (tmp != null && !tmp.isEmpty()) {
                result.addAll(tmp);
            }
        }   
        if (event.getAllTypes().contains("eu.trentorise.smartcampus.domain.discovertrento.ServiceEventFactory")
            && DOMAIN_OBJECT_EVENT_TYPE.CUSTOM .equals(event.getEventType())
            && "deleteEvent".equals(event.getEventSubtype())
            ) {
            tmp = _subscriptionQuery_declared_subscription_sub_1 (event, securityToken, bundleId);
            if (tmp != null && !tmp.isEmpty()) {
                result.addAll(tmp);
            }
        }   
        return result;
    }
    
    public Collection<DomainEventDescriptor> getEventsToQuery() {
        List<DomainEventDescriptor> result = new ArrayList<DomainEventDescriptor>();
        result.add(new DomainEventDescriptor(
            "eu.trentorise.smartcampus.domain.discovertrento.ServiceEventFactory",
            DOMAIN_OBJECT_EVENT_TYPE.CUSTOM, 
            "updateEvent",
            null
            ));        
        result.add(new DomainEventDescriptor(
            "eu.trentorise.smartcampus.domain.discovertrento.ServiceEventFactory",
            DOMAIN_OBJECT_EVENT_TYPE.CUSTOM, 
            "deleteEvent",
            null
            ));        
        return result;
    }
    
}


