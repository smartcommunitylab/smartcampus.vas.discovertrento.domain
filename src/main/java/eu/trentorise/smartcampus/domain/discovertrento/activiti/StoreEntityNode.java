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
package eu.trentorise.smartcampus.domain.discovertrento.activiti;

import it.sayservice.platform.core.common.util.ServiceUtil;
import it.sayservice.platform.core.domain.DomainObject;
import it.sayservice.platform.core.domain.DomainRelationTarget;
import it.sayservice.platform.core.domain.operation.OperationProcessConst;
import it.sayservice.platform.core.domain.operation.impl.activiti.ActivitiDomainObjectProcessNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;

import eu.trentorise.smartcampus.domain.semantic.Tag;

public class StoreEntityNode implements JavaDelegate {

	private Log logger = LogFactory.getLog(getClass());
	private Expression processNode;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		ActivitiDomainObjectProcessNode node = (ActivitiDomainObjectProcessNode)processNode.getValue(execution);
		
		byte b[] = (byte[]) execution.getVariable(OperationProcessConst.DOMAIN_OBJECT);
		if (b == null) {
			logger.error("DomainObject is null");
			return;
		}
		
		String type = (String)execution.getVariable("type");
		if (type == null) {
			logger.error("type is not defined");
			return;
		}
		
		DomainObject object = (DomainObject)ServiceUtil.deserializeObject(b);
		if (object == null) {
			logger.error("Serialized DomainObject is null");
			return;
		}
		
		List<DomainRelationTarget> list = object.getRelations().get("semanticService").getTargets();
		if (list == null || list.isEmpty()) {
			logger.error("No semantic service domain object found.");
			return;
		}
		DomainRelationTarget target = list.get(0);
		
		Map<String,Object> parameters = new HashMap<String, Object>();
		
		parameters.put("name", object.getContentValue("data.title"));
		parameters.put("description", object.getContentValue("data.description"));
		@SuppressWarnings("unchecked")
		Map<String,Object> communityData = (Map<String,Object>)object.getContentValue("communityData");
		if (communityData != null && parameters.get("description") == null) {
			parameters.put("description", communityData.get("notes"));
		}
		Object tags = null;
		if (communityData != null && communityData.containsKey("tags")) {
			tags = communityData.get("tags");
		}
		if (tags != null) {
			parameters.put("tags", new ObjectMapper().convertValue(tags, Tag[].class));
		}
		Object rels = execution.getVariable("relations");
		if (rels != null) {
			parameters.put("relations", new ObjectMapper().convertValue(rels, Long[].class));
		}
		
		Object idObj = object.getContentValue("entityId");
		Long id = idObj == null ? null : idObj instanceof Long ? (Long)idObj : Long.parseLong(idObj.toString());
		if (id != null && id > 0) {
			parameters.put("id", id);
			byte[] result = null;
			try {
				result = (byte[]) node.invokeDomainObjectOperationSynch(null, "updateEntity", target.getTargetId(), target.getTargetType(), parameters);
				if (!(Boolean)ServiceUtil.deserializeObject(result)) {
					logger.error("Entity has not been updated");
					return;
				}
			} catch (Exception e) {
				logger.error("Error updating entity: "+e.getMessage());
				return;
			}
		} else {
			parameters.put("type", type);
			try {
				byte[] result = (byte[])node.invokeDomainObjectOperationSynch(null, "createSCEntity", target.getTargetId(), target.getTargetType(), parameters);
				id = (Long)ServiceUtil.deserializeObject(result);
				if (id <= 0) {
					logger.error("Entity has not been created");
					id = -1L;
				}
			} catch (Exception e) {
				logger.error("Error creating entity: "+e.getMessage());
			}
		}
		execution.setVariable("id", id);
	}


}
