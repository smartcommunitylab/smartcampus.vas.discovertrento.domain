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
            "_delete",
            "_follow",
            "_rate",
            "_unfollow",
            "_update",
            "_updateCommunityData",
    };

    protected String[] getSortedActions() {
        return actions;
    }

    private static Map<String,Collection<java.io.Serializable>> extensions = new HashMap<String,Collection<java.io.Serializable>>();
    static {
        extensions.put("it.sayservice.platform.core.domain.actions.InvokeOperation",decodeExtension("rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAAGdwQAAAAIc3IAEWphdmEudXRpbC5IYXNoTWFwBQfawcMWYNEDAAJGAApsb2FkRmFjdG9ySQAJdGhyZXNob2xkeHA/QAAAAAAADHcIAAAAEAAAAAN0AAlvcGVyYXRpb250AAlkZWxldGVQT0l0AAphY3Rpb25OYW1ldAAHX2RlbGV0ZXQABHR5cGV0AAVMb2NhbHhzcQB+AAI/QAAAAAAADHcIAAAAEAAAAANxAH4ABHQABmZvbGxvd3EAfgAGdAAHX2ZvbGxvd3EAfgAIcQB+AAl4c3EAfgACP0AAAAAAAAx3CAAAABAAAAADcQB+AAR0AARyYXRlcQB+AAZ0AAVfcmF0ZXEAfgAIcQB+AAl4c3EAfgACP0AAAAAAAAx3CAAAABAAAAADcQB+AAR0AAh1bmZvbGxvd3EAfgAGdAAJX3VuZm9sbG93cQB+AAhxAH4ACXhzcQB+AAI/QAAAAAAADHcIAAAAEAAAAANxAH4ABHQAE3VwZGF0ZUNvbW11bml0eURhdGFxAH4ABnQAFF91cGRhdGVDb21tdW5pdHlEYXRhcQB+AAhxAH4ACXhzcQB+AAI/QAAAAAAADHcIAAAAEAAAAANxAH4ABHQACXVwZGF0ZVBPSXEAfgAGdAAHX3VwZGF0ZXEAfgAIcQB+AAl4eA=="));
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
        if ("_update".equals(actionName)) {
            return _update(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("_updateCommunityData".equals(actionName)) {
            return _updateCommunityData(t, obj, outEvents, ops, securityToken, bundleId);
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
    private Object _update(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
eu.trentorise.smartcampus.domain.discovertrento.GenericPOI newData = (eu.trentorise.smartcampus.domain.discovertrento.GenericPOI) tuple.get("newData");
eu.trentorise.smartcampus.domain.discovertrento.CommunityData newCommunityData = (eu.trentorise.smartcampus.domain.discovertrento.CommunityData) tuple.get("newCommunityData");
{
if ((eu.trentorise.smartcampus.domain.discovertrento.Helper.requiresUpdateOnCommunityData(newCommunityData,getDomainObjectHandler().getVar("communityData",obj,eu.trentorise.smartcampus.domain.discovertrento.CommunityData.class,bundleId))) || (eu.trentorise.smartcampus.domain.discovertrento.Helper.requiresUpdateOnGenericPOI(getDomainObjectHandler().getVar("data",obj,eu.trentorise.smartcampus.domain.discovertrento.GenericPOI.class,bundleId),newData))){
{
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
getDomainObjectHandler().setVar("communityData", obj, eu.trentorise.smartcampus.domain.discovertrento.Helper.mergeCommunityData(getDomainObjectHandler().getVar("communityData",obj,eu.trentorise.smartcampus.domain.discovertrento.CommunityData.class,bundleId),newCommunityData), evts, bundleId);}
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
        return null;
    }


    @Override
    public boolean isRelation(String key) {
        return false
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
    }

    public Collection<String> getDependencies() {
        return dependencies;
    }

    public Collection<DomainSubscriptionRule> getSubscriptions(DomainObjectWrapper obj, String bundleId) throws DomainDataHandlerException {
        List<DomainSubscriptionRule> rules = new ArrayList<DomainSubscriptionRule>();
        
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


