/*******************************************************************************
 * Copyright 2012-2013 Trento RISE
 * 
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 * 
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 ******************************************************************************/
package smartcampus.domain.seminars.test;

import it.sayservice.platform.client.ServiceBusAdminClient;
import it.sayservice.platform.client.ServiceBusClient;
import it.sayservice.platform.client.jms.JMSServiceBusAdminClient;
import it.sayservice.platform.client.jms.JMSServiceBusClient;
import it.sayservice.platform.core.domain.DomainObject;
import it.sayservice.platform.core.message.Core.DODataRequest;
import it.sayservice.platform.core.message.Core.DomainEvent;
import it.sayservice.platform.domain.test.DomainListener;
import it.sayservice.platform.domain.test.DomainTestHelper;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hornetq.api.core.TransportConfiguration;
import org.hornetq.jms.client.HornetQJMSConnectionFactory;

import eu.trentorise.smartcampus.domain.discovertrento.CommunityData;
import eu.trentorise.smartcampus.domain.discovertrento.EventObjectDOEngine;
import eu.trentorise.smartcampus.domain.discovertrento.EventServiceDOEngine;
import eu.trentorise.smartcampus.domain.discovertrento.GenericEvent;
import eu.trentorise.smartcampus.domain.discovertrento.GenericPOI;
import eu.trentorise.smartcampus.domain.discovertrento.GenericStory;
import eu.trentorise.smartcampus.domain.discovertrento.GenericStoryStep;
import eu.trentorise.smartcampus.domain.discovertrento.OperaUniServiceDOEngine;
import eu.trentorise.smartcampus.domain.discovertrento.PAPServiceDOEngine;
import eu.trentorise.smartcampus.domain.discovertrento.POIObjectDOEngine;
import eu.trentorise.smartcampus.domain.discovertrento.POIServiceDOEngine;
import eu.trentorise.smartcampus.domain.discovertrento.ServiceEventFactoryDOEngine;
import eu.trentorise.smartcampus.domain.discovertrento.ServiceEventObjectDOEngine;
import eu.trentorise.smartcampus.domain.discovertrento.ServicePOIFactoryDOEngine;
import eu.trentorise.smartcampus.domain.discovertrento.ServicePOIObjectDOEngine;
import eu.trentorise.smartcampus.domain.discovertrento.StoryFactoryDOEngine;
import eu.trentorise.smartcampus.domain.discovertrento.StoryObjectDOEngine;
import eu.trentorise.smartcampus.domain.discovertrento.UserEventFactoryDOEngine;
import eu.trentorise.smartcampus.domain.discovertrento.UserEventObjectDOEngine;
import eu.trentorise.smartcampus.domain.discovertrento.UserPOIFactoryDOEngine;
import eu.trentorise.smartcampus.domain.discovertrento.UserPOIObjectDOEngine;
import eu.trentorise.smartcampus.domain.discovertrento.UserPersonalEventDOEngine;
import eu.trentorise.smartcampus.domain.discovertrento.UserPersonalEventFactoryDOEngine;
import eu.trentorise.smartcampus.domain.semantic.SemanticServiceDOEngine;
import eu.trentorise.smartcampus.domain.semantic.Tag;


public class TestDomain {

	public static void main(String[] args) throws Exception {
		HornetQJMSConnectionFactory cf = 
			     new HornetQJMSConnectionFactory(false,
			                  new TransportConfiguration(
			                    "org.hornetq.core.remoting.impl.netty.NettyConnectorFactory"));
			  ServiceBusClient client = new JMSServiceBusClient(cf);

			  DomainTestHelper helper = new DomainTestHelper(client,new DomainListener() {
			    public void onDomainEvents(List<DomainEvent> events) {
			    	System.err.println(events);
			      // DO someth...
			    }

			    public void onDataRequest(DODataRequest req) {
			      // DO someth...
			    }
			  });

			  
//			  eventsCreation(cf, helper);
//			  eventTagging(helper);
			  createUserObjects(helper);
			  System.err.println();
			  
			  
//			  DomainObject obj = list.get(0);
//			  Map<String,Object> params = new HashMap<String, Object>();
//			  params.put("userId", "raman");
//			  helper.invokeDOOperation(obj.getType(), obj.getId(), "personalize", params);

			  
//			  System.err.println(helper.getDOByType("smartcampus.domain.seminars.PersonalSeminarObject"));
	}

	protected static void createUserObjects(DomainTestHelper helper)
			throws Exception {
		  helper.cleanDomainData();
		  initDomain(helper);

		DomainObject userPOIFactory = helper.getDOById("eu.trentorise.smartcampus.domain.discovertrento.UserPOIFactory", "eu.trentorise.smartcampus.domain.discovertrento.UserPOIFactory.0");
		  Map<String,Object> params = new HashMap<String, Object>();
		  params.put("creator", "testuser");
		  params.put("data", createGenericPOI());
		  params.put("communityData", createCommunityDataRaw());
		  helper.invokeDOOperation(userPOIFactory.getType(), userPOIFactory.getId(), "createPOI", params);
		  
		  DomainObject userEventFactory = helper.getDOById("eu.trentorise.smartcampus.domain.discovertrento.UserEventFactory", "eu.trentorise.smartcampus.domain.discovertrento.UserEventFactory.0");
		  params.clear();
		  params.put("creator", "testuser");
		  params.put("data", createGenericEvent());
		  params.put("communityData", createCommunityDataRaw());
		  helper.invokeDOOperation(userEventFactory.getType(), userEventFactory.getId(), "createEvent", params);

		  DomainObject userStoryFactory = helper.getDOById("eu.trentorise.smartcampus.domain.discovertrento.StoryFactory", "eu.trentorise.smartcampus.domain.discovertrento.StoryFactory.0");
		  params.clear();
		  params.put("creator", "testuser");
		  params.put("data", createGenericStory());
		  params.put("communityData", createCommunityDataRaw());
		  helper.invokeDOOperation(userStoryFactory.getType(), userStoryFactory.getId(), "createStory", params);

		  
		  List<DomainObject> list = helper.getDOByType("eu.trentorise.smartcampus.domain.discovertrento.UserPOIObject");
		  for (DomainObject o : list) {
			  helper.invokeDOOperation(o.getType(), o.getId(), "deletePOI", new HashMap<String, Object>());
		  }
		  list = helper.getDOByType("eu.trentorise.smartcampus.domain.discovertrento.UserEventObject");
		  for (DomainObject o : list) {
			  helper.invokeDOOperation(o.getType(), o.getId(), "deleteEvent", new HashMap<String, Object>());
		  }
		  list = helper.getDOByType("eu.trentorise.smartcampus.domain.discovertrento.StoryObject");
		  for (DomainObject o : list) {
			  helper.invokeDOOperation(o.getType(), o.getId(), "deleteStory", new HashMap<String, Object>());
		  }
	}

	private static void initDomain(DomainTestHelper helper) {
		helper.start(
				  new EventObjectDOEngine(),
				  new EventServiceDOEngine(),
				  new PAPServiceDOEngine(),
				  new ServiceEventFactoryDOEngine(),
				  new ServiceEventObjectDOEngine(),
				  new UserEventFactoryDOEngine(),
				  new UserEventObjectDOEngine(),

				  new POIObjectDOEngine(),
				  new POIServiceDOEngine(),
				  new OperaUniServiceDOEngine(),
				  new ServicePOIFactoryDOEngine(),
				  new ServicePOIObjectDOEngine(),
				  new UserPOIFactoryDOEngine(),
				  new UserPOIObjectDOEngine(),
				  
				  new UserPersonalEventFactoryDOEngine(),
				  new UserPersonalEventDOEngine(),
				  
				  new StoryObjectDOEngine(),
				  new StoryFactoryDOEngine(),
				  
				  new SemanticServiceDOEngine() 
				  );
	}

	private static GenericEvent createGenericEvent() {
		GenericEvent event = new GenericEvent();
		event.setTitle("test event");
		event.setDescription("event summary");
		event.setId("eventid");
		event.setPoiId("poiid");
		event.setFromTime(System.currentTimeMillis());
		event.setToTime(event.getFromTime()+60*60*1000);
		return event;
	}

	private static GenericStory createGenericStory() {
		GenericStory story = new GenericStory();
		story.setTitle("test event");
		story.setDescription("event summary");
		story.setId("eventid");
		story.setSteps(new GenericStoryStep[1]);
		story.getSteps()[0] = new GenericStoryStep();
		story.getSteps()[0].setNote("test note");
		story.getSteps()[0].setPoiId("poiid");
		return story;
	}

	private static GenericPOI createGenericPOI() {
		GenericPOI poi = new GenericPOI();
		poi.setTitle("user poi");
		poi.setDescription("some description");
		poi.setId("poiid");
		return poi;
	}

	private static void eventTagging(DomainTestHelper helper) throws Exception, JsonGenerationException, JsonMappingException, IOException {
		initDomain(helper);
		DomainObject obj = helper.getDOByType("eu.trentorise.smartcampus.domain.discovertrento.EventObject").get(0);
		  Map<String,Object> params = new HashMap<String, Object>();
		  params.put("newCommunityData", createCommunityData());
		  helper.invokeDOOperation(obj.getType(), obj.getId(), "updateCommunityData", params);
		  System.err.println(helper.getDOById(obj.getType(), obj.getId()));
	}

	private static Object createCommunityData() throws JsonGenerationException, JsonMappingException, IOException {
		CommunityData data = createCommunityDataRaw();
		return new ObjectMapper().writeValueAsString(data);
	}

	protected static CommunityData createCommunityDataRaw() {
		Tag tag = new Tag();
		tag.setName("test");
		Tag semTag = new Tag();
		semTag.setName("java");
		semTag.setId(42475L);
		CommunityData data = new CommunityData();
		data.setTags(new Tag[]{tag, semTag});
		return data;
	}

	private static void eventsCreation(HornetQJMSConnectionFactory cf,
			DomainTestHelper helper) throws Exception {
//		  helper.cleanDomainData();
		  initDomain(helper);
		ServiceBusAdminClient admin = new JMSServiceBusAdminClient(cf);
		  admin.restartService("eu.trentorise.smartcampus.services.primiallaprima.PrimiallaprimaService", "GetEvents");
		  List<DomainObject> list = helper.getDOByType("eu.trentorise.smartcampus.domain.discovertrento.EventObject");
		  System.err.println(list);
	}
}
