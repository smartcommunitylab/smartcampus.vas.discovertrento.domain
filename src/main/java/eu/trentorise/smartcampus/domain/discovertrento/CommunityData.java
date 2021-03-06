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
import java.util.HashMap;
import java.util.Map;

import eu.trentorise.smartcampus.domain.semantic.Tag;

public class CommunityData implements Serializable{ 
	private static final long serialVersionUID = 5926048335916274968L;

	private Tag[] tags;
	private String notes;
	private int averageRating;
	private RatingData[] ratings;
	private Map<String,String> following;
	
	public CommunityData() {
		super();
	}

	public Tag[] getTags() {
		return tags;
	}
	public void setTags(Tag[] tags) {
		this.tags = tags;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(int averageRating) {
		this.averageRating = averageRating;
	}

	public RatingData[] getRatings() {
		return ratings;
	}

	public void setRatings(RatingData[] ratings) {
		this.ratings = ratings;
	}

	public Map<String, String> getFollowing() {
		if (following == null) following = new HashMap<String, String>();
		return following;
	}

	public void setFollowing(Map<String, String> following) {
		this.following = following;
	}


	
}
