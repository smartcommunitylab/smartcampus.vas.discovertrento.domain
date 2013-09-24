package eu.trentorise.smartcampus.domain.discovertrento;

import it.sayservice.platform.domain.expressions.Type;
import it.sayservice.platform.domain.model.interfaces.Constants.Visibility;
import it.sayservice.platform.domain.model.interfaces.DomainTypeInterface;
import it.sayservice.platform.domain.model.interfaces.Operation;
import it.sayservice.platform.domain.model.interfaces.Port;
import it.sayservice.platform.domain.model.interfaces.RelDef;
import it.sayservice.platform.domain.model.interfaces.VarDef;
import it.sayservice.platform.domain.model.interfaces.impl.DomainTypeInterfaceImpl;
import it.sayservice.platform.domain.model.interfaces.impl.VarDefImpl;
import it.sayservice.platform.domain.model.interfaces.impl.RelDefImpl;
import it.sayservice.platform.domain.model.interfaces.impl.OperationImpl;
import it.sayservice.platform.domain.model.interfaces.impl.ArgumentDefImpl;
import it.sayservice.platform.domain.model.interfaces.impl.PortImpl;

import java.util.ArrayList;
import java.util.Collection;

public class  ServicePOIObjectInterface extends DomainTypeInterfaceImpl {

    private static DomainTypeInterface intf = null;
    public static DomainTypeInterface getInstance() {
        if (intf==null) intf = new ServicePOIObjectInterface();
        return intf;
    }

    @Override
    public boolean isType() {
        return  true; 
    }

    @Override
    public String getPackage() {
        return "eu.trentorise.smartcampus.domain.discovertrento";
    }

    @Override
    public String getName() {
        return "ServicePOIObject";
    }

    private static Collection<VarDef> varDefs = new ArrayList<VarDef>();
    static {
        VarDefImpl vd = null;
        vd = new VarDefImpl();
        vd.setVisibility(Visibility.PUBLIC);
        vd.setName("communityData");
        vd.setType(new Type(eu.trentorise.smartcampus.domain.discovertrento.CommunityData .class, false));
        varDefs.add(vd);
        vd = new VarDefImpl();
        vd.setVisibility(Visibility.PUBLIC);
        vd.setName("customData");
        vd.setType(new Type(eu.trentorise.smartcampus.domain.discovertrento.POICustomData .class, false));
        varDefs.add(vd);
        vd = new VarDefImpl();
        vd.setVisibility(Visibility.PUBLIC);
        vd.setName("data");
        vd.setType(new Type(eu.trentorise.smartcampus.domain.discovertrento.GenericPOI .class, false));
        varDefs.add(vd);
        vd = new VarDefImpl();
        vd.setVisibility(Visibility.PUBLIC);
        vd.setName("entityId");
        vd.setType(new Type(java.lang.Long .class, false));
        varDefs.add(vd);
        vd = new VarDefImpl();
        vd.setVisibility(Visibility.PUBLIC);
        vd.setName("id");
        vd.setType(new Type(java.lang.String .class, false));
        varDefs.add(vd);
    }
    
    @Override
    public Collection<VarDef> getVarDefinitions() {
        return varDefs;
    }

    private static Collection<RelDef> relDefs = new ArrayList<RelDef>();
    static {
        RelDefImpl rd = null;
    }    

    @Override
    public Collection<RelDef> getRelDefinitions() {
        return relDefs;
    }

    private static Collection<DomainTypeInterface> extended = new ArrayList<DomainTypeInterface>();
    static {
        DomainTypeInterface e = null;
        e = eu.trentorise.smartcampus.domain.discovertrento.POIObjectInterface .getInstance();
        extended.add(e);
    }    

    @Override
    public Collection<DomainTypeInterface> getDirectExtendedTypes() {
        return extended;
    }

    private static Collection<Operation> operations = new ArrayList<Operation>();
    static {
        OperationImpl o = null;
        ArgumentDefImpl a = null;

        o = new OperationImpl();
        o.setName("follow");
        o.setVisibility(Visibility.PUBLIC);
        a = new ArgumentDefImpl();
        a.setName("user");
        a.setType(new Type(java.lang.String .class, false));
        o.addArgument(a);
        a = new ArgumentDefImpl();
        a.setName("topic");
        a.setType(new Type(java.lang.String .class, false));
        o.addArgument(a);
        operations.add(o);

        o = new OperationImpl();
        o.setName("rate");
        o.setReturn(new Type(java.lang.Integer .class, false));
        o.setVisibility(Visibility.PUBLIC);
        a = new ArgumentDefImpl();
        a.setName("user");
        a.setType(new Type(java.lang.String .class, false));
        o.addArgument(a);
        a = new ArgumentDefImpl();
        a.setName("rating");
        a.setType(new Type(java.lang.Integer .class, false));
        o.addArgument(a);
        operations.add(o);

        o = new OperationImpl();
        o.setName("unfollow");
        o.setVisibility(Visibility.PUBLIC);
        a = new ArgumentDefImpl();
        a.setName("user");
        a.setType(new Type(java.lang.String .class, false));
        o.addArgument(a);
        operations.add(o);

        o = new OperationImpl();
        o.setName("updateCommunityData");
        o.setVisibility(Visibility.PUBLIC);
        a = new ArgumentDefImpl();
        a.setName("newCommunityData");
        a.setType(new Type(eu.trentorise.smartcampus.domain.discovertrento.CommunityData .class, false));
        o.addArgument(a);
        operations.add(o);

        o = new OperationImpl();
        o.setName("updateCustomData");
        o.setVisibility(Visibility.PUBLIC);
        a = new ArgumentDefImpl();
        a.setName("newCustomData");
        a.setType(new Type(eu.trentorise.smartcampus.domain.discovertrento.POICustomData .class, false));
        o.addArgument(a);
        a = new ArgumentDefImpl();
        a.setName("newCommunityData");
        a.setType(new Type(eu.trentorise.smartcampus.domain.discovertrento.CommunityData .class, false));
        o.addArgument(a);
        operations.add(o);
    }    
    @Override
    public Collection<Operation> getOperations() {
        return operations;
    }

    private static Collection<Port> ports = new ArrayList<Port>();
    static {
        PortImpl p = null;
        ArgumentDefImpl a = null;
    }
    
    @Override
    public Collection<Port> getPorts() {
        return ports;
    }

}


