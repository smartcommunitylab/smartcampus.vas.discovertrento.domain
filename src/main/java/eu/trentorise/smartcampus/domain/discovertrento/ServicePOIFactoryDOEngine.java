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

public class ServicePOIFactoryDOEngine extends AbstractDOEngineImpl {

    public ServicePOIFactoryDOEngine() {
        super();
    }

    private static String[] actions = new String[]{
            "transformLocations",
    };

    protected String[] getSortedActions() {
        return actions;
    }

    private static Map<String,Collection<java.io.Serializable>> extensions = new HashMap<String,Collection<java.io.Serializable>>();
    static {
    }

     public  Collection<java.io.Serializable> getExtensionValues(String property) {
        return extensions.get(property);
     }  
    
    protected Object executeAction(String actionName, DomainObjectWrapper obj, Tuple t, Set<DomainEvent> outEvents, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        if ("transformLocations".equals(actionName)) {
            return transformLocations(t, obj, outEvents, ops, securityToken, bundleId);
        }
        return null;
    }

    private Object transformLocations(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
eu.trentorise.smartcampus.domain.discovertrento.GenericPOI[] list = (eu.trentorise.smartcampus.domain.discovertrento.GenericPOI[]) tuple.get("list");
{
for (eu.trentorise.smartcampus.domain.discovertrento.GenericPOI l:list){
{
java.lang.Boolean found = false;
if (getDomainObjectHandler().getVar("locations",obj,java.lang.String[].class,bundleId) != null){
{
for (java.lang.String old:getDomainObjectHandler().getVar("locations",obj,java.lang.String[].class,bundleId)){
{
if (old.equals(l.getId())){
{
found = true;
{
Tuple body = new Tuple();
 body.put("id",l.getId());
 body.put("poi",l);
getDomainObjectHandler().publishCustomEvent("updatePOI", body, obj, evts, bundleId);}
break;}
}
}
}
}
}
if (!(found)){
{
{
Tuple body = new Tuple();
 body.put("data",l);
 body.put("id",l.getId());
getDomainObjectHandler().create(null, "eu.trentorise.smartcampus.domain.discovertrento.ServicePOIObject", body, evts, ops, securityToken, bundleId);}
getDomainObjectHandler().setVar("locations", obj, eu.trentorise.smartcampus.domain.discovertrento.Helper.merge(getDomainObjectHandler().getVar("locations",obj,java.lang.String[].class,bundleId),l.getId()), evts, bundleId);}
}
}
}
}
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
            eu.trentorise.smartcampus.domain.discovertrento.GenericPOI[] data = (eu.trentorise.smartcampus.domain.discovertrento.GenericPOI[]) payload.get("data");
            String name = (String) payload.get("name");
            if (true){
                Tuple tuple = new Tuple();
                tuple.put("list",data);
                return new ActionInvoke("transformLocations", tuple);
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
        return "eu.trentorise.smartcampus.domain.discovertrento.ServicePOIFactory";
    }

    @Override
    public boolean isStatic() {
        return !false;
    }

    private static Collection<String> dependencies = new java.util.HashSet<String>();
    static {
        dependencies.add("eu.trentorise.smartcampus.domain.discovertrento.POIService");
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
            rule.setSourceType("eu.trentorise.smartcampus.domain.discovertrento.POIService");
            rule.setTargetId(obj.getId());
            rule.setTargetType(obj.getType());
            rule.setEngineName("declared_subscription_sub_0");
            rule.setEventType(DOMAIN_OBJECT_EVENT_TYPE.CUSTOM .toString());
            rule.setEventSubtype("update");
            rules.add(rule);
        }
        return rules;
    }

    
    public it.sayservice.platform.domain.model.interfaces.DomainTypeInterface getInterface() throws it.sayservice.platform.core.domain.common.exception.DomainDataHandlerException {
        return eu.trentorise.smartcampus.domain.discovertrento .ServicePOIFactoryInterface .getInstance();
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


