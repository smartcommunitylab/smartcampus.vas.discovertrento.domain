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
package eu.trentorise.smartcampus.domain.discovertrento;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CurrentEvents implements Serializable {

	private static final long serialVersionUID = -3514020764241454239L;
	
	private Map<String, List<String>> sourcesIds;

	private CurrentEvents() {
		sourcesIds = new TreeMap<String, List<String>>();
	}

	public static CurrentEvents getInstance() {
		return new CurrentEvents();
	}

	public Map<String, List<String>> getSourcesIds() {
		return sourcesIds;
	}


	public static boolean containsEvent(CurrentEvents events, GenericEvent ev) {
		List<String> ids = events.getSourcesIds().get(ev.getSource());
		if (ids == null) {
			return false;
		}
		return ids.contains(ev.getId());
	}

	public static CurrentEvents addEvent(CurrentEvents events, GenericEvent ev) {
		List<String> ids;
		String source = ev.getSource();
		if (events.getSourcesIds().containsKey(source)) {
			ids = events.getSourcesIds().get(source);
		} else {
			ids = new ArrayList<String>();
		}
		ids.add(ev.getId());
		events.getSourcesIds().put(source, ids);
		return events;
	}

	public static String[] findEventsToDelete(CurrentEvents events, GenericEvent evs[]) {
		List<String> toRemove = new ArrayList<String>();

		if (evs != null && evs.length > 0) {

			Map<String, List<String>> newIdsMap = new TreeMap<String, List<String>>();
			for (GenericEvent ev : evs) {
				List<String> ids;
				String source = ev.getSource();
				if (newIdsMap.containsKey(source)) {
					ids = newIdsMap.get(source);
				} else {
					ids = new ArrayList<String>();
				}
				ids.add(ev.getId());
				newIdsMap.put(source, ids);
			}

			for (String key : newIdsMap.keySet()) {
				if (!events.getSourcesIds().containsKey(key)) {
					continue;
				}
				List<String> oldIds = events.getSourcesIds().get(key);
				List<String> newIds = newIdsMap.get(key);
				for (String id : oldIds) {
					if (!newIds.contains(id)) {
						toRemove.add(id);
					}
				}

			}
		}

		return toRemove.toArray(new String[toRemove.size()]);
	}
	
	public static CurrentEvents deleteEvent(CurrentEvents events, String source, String id) {
		if (events.getSourcesIds() !=null && events.getSourcesIds().containsKey(source)) events.getSourcesIds().get(source).remove(id);
		return events;
		
	}

}
