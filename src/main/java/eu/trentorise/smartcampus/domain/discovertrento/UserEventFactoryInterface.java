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

public class  UserEventFactoryInterface extends DomainTypeInterfaceImpl {

    private static DomainTypeInterface intf = null;
    public static DomainTypeInterface getInstance() {
        if (intf==null) intf = new UserEventFactoryInterface();
        return intf;
    }

    @Override
    public boolean isType() {
        return  false; 
    }

    @Override
    public String getPackage() {
        return "eu.trentorise.smartcampus.domain.discovertrento";
    }

    @Override
    public String getName() {
        return "UserEventFactory";
    }

    private static Collection<VarDef> varDefs = new ArrayList<VarDef>();
    static {
        VarDefImpl vd = null;
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
        o.setName("createEvent");
        o.setVisibility(Visibility.PUBLIC);
        a = new ArgumentDefImpl();
        a.setName("creator");
        a.setType(new Type(java.lang.String .class, false));
        o.addArgument(a);
        a = new ArgumentDefImpl();
        a.setName("data");
        a.setType(new Type(eu.trentorise.smartcampus.domain.discovertrento.GenericEvent .class, false));
        o.addArgument(a);
        a = new ArgumentDefImpl();
        a.setName("communityData");
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


