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
import it.sayservice.platform.core.domain.operation.OperationProcessConst;
import it.sayservice.platform.core.domain.operation.impl.activiti.ActivitiDomainObjectProcessNode;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;

public class UpdateObjectNode implements JavaDelegate {

	private Expression processNode;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		ActivitiDomainObjectProcessNode node = (ActivitiDomainObjectProcessNode)processNode.getValue(execution);
		Long entityId = (Long)execution.getVariable("id");

		byte b[] = (byte[]) execution.getVariable(OperationProcessConst.DOMAIN_OBJECT);
		if (b == null) return;
		DomainObject object = (DomainObject)ServiceUtil.deserializeObject(b);
		if (object == null) return;

		if (entityId != null) {
			Map<String,Object> parameters = new HashMap<String, Object>();
			parameters.put("newId", entityId);
			node.invokeDomainObjectAction(null, object.getId(), object.getType(), "_updateEntity", parameters);
		} else {
			Object idObj = object.getContentValue("entityId");
			Long oldId = idObj == null ? null : idObj instanceof Long ? (Long)idObj : Long.parseLong(idObj.toString());

			if (oldId != null && oldId > 0) return;
			node.invokeDomainObjectAction(null, object.getId(), object.getType(), "_delete", new HashMap<String, Object>());
		}
	}

}
