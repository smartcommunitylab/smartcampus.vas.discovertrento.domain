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
            "_attend",
            "_delete",
            "_follow",
            "_notAttend",
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
        extensions.put("it.sayservice.platform.core.domain.actions.InvokeOperation",decodeExtension("rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAAIdwQAAAALc3IAEWphdmEudXRpbC5IYXNoTWFwBQfawcMWYNEDAAJGAApsb2FkRmFjdG9ySQAJdGhyZXNob2xkeHA/QAAAAAAADHcIAAAAEAAAAAN0AAlvcGVyYXRpb250AAZhdHRlbmR0AAphY3Rpb25OYW1ldAAHX2F0dGVuZHQABHR5cGV0AAVMb2NhbHhzcQB+AAI/QAAAAAAADHcIAAAAEAAAAANxAH4ABHQAC2RlbGV0ZVN0b3J5cQB+AAZ0AAdfZGVsZXRlcQB+AAhxAH4ACXhzcQB+AAI/QAAAAAAADHcIAAAAEAAAAANxAH4ABHQABmZvbGxvd3EAfgAGdAAHX2ZvbGxvd3EAfgAIcQB+AAl4c3EAfgACP0AAAAAAAAx3CAAAABAAAAADcQB+AAR0AAlub3RBdHRlbmRxAH4ABnQACl9ub3RBdHRlbmRxAH4ACHEAfgAJeHNxAH4AAj9AAAAAAAAMdwgAAAAQAAAAA3EAfgAEdAAEcmF0ZXEAfgAGdAAFX3JhdGVxAH4ACHEAfgAJeHNxAH4AAj9AAAAAAAAMdwgAAAAQAAAAA3EAfgAEdAAIdW5mb2xsb3dxAH4ABnQACV91bmZvbGxvd3EAfgAIcQB+AAl4c3EAfgACP0AAAAAAAAx3CAAAABAAAAADcQB+AAR0ABN1cGRhdGVDb21tdW5pdHlEYXRhcQB+AAZ0ABRfdXBkYXRlQ29tbXVuaXR5RGF0YXEAfgAIcQB+AAl4c3EAfgACP0AAAAAAAAx3CAAAABAAAAADcQB+AAR0AAt1cGRhdGVTdG9yeXEAfgAGdAAHX3VwZGF0ZXEAfgAIcQB+AAl4eA=="));
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
        if ("_update".equals(actionName)) {
            return _update(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("_updateCommunityData".equals(actionName)) {
            return _updateCommunityData(t, obj, outEvents, ops, securityToken, bundleId);
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
    private Object _update(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
eu.trentorise.smartcampus.domain.discovertrento.GenericStory newData = (eu.trentorise.smartcampus.domain.discovertrento.GenericStory) tuple.get("newData");
eu.trentorise.smartcampus.domain.discovertrento.CommunityData newCommunityData = (eu.trentorise.smartcampus.domain.discovertrento.CommunityData) tuple.get("newCommunityData");
{
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
    
    
    private java.lang.Integer _eval_attendees(DomainObjectWrapper obj, String bundleId) throws DomainDataHandlerException {
        return LanguageHelper.count(getDomainObjectHandler().getVar("attending",obj,java.lang.String[].class,bundleId));
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
        return "eu.trentorise.smartcampus.domain.discovertrento.StoryObject";
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


