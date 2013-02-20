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

import it.sayservice.platform.core.domain.actions.DataConverter;
import it.sayservice.platform.core.domain.ext.Tuple;

import java.io.Serializable;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.codehaus.jackson.map.ObjectMapper;

import com.google.protobuf.ByteString;

import eu.trentorise.smartcampus.services.ou.data.message.Ou.Location;

public class OUDataConverter implements DataConverter {

	@Override
	public Serializable toMessage(Map<String, Object> parameters) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object fromMessage(Serializable object) {
		List<ByteString> data = (List<ByteString>)object;
		Tuple res = new Tuple();
		List<GenericPOI> list = new ArrayList<GenericPOI>();
		for (ByteString bs : data) {
			try {
				Location e = Location.parseFrom(bs);
				list.add(extractGenericPOI(e));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		res.put("data", list.toArray(new GenericPOI[list.size()]));
		return res;
	}

	private GenericPOI extractGenericPOI(Location l) throws ParseException {
		GenericPOI ge = new GenericPOI();
		ge.setTitle(l.getName());
		ge.setDescription(l.getDescription());
		ge.setSource("OperaUniversitaria");
//		ge.setType("university");
		ge.setPoiData(createPOIData(l));
		if (ge.getPoiData().getPoiId() == null) {
			ge.setId(encode(l.getId()));
		} else {
			ge.setId(ge.getPoiData().getPoiId());
		}
		
		Map<String,Object> map = new TreeMap<String, Object>();
		if (l.hasDetailUrl()) map.put("detailUrl", l.getDetailUrl());
		if (l.hasImgUrl()) map.put("imgUrl", l.getImgUrl());

		try {
			ge.setCustomData(new ObjectMapper().writeValueAsString(map));
		} catch (Exception e) {
		}
		
		return ge;
	}

	private POIData createPOIData(Location l) {
		if (l.hasPoi()) {
			return new POIData(l.getPoi());
		}
		POIData poiData = new POIData();
		poiData.setStreet(l.getAddress());
		poiData.setCity("Trento");
		poiData.setRegion("TN");
		poiData.setCountry("ITA");
		poiData.setState("Italy");
		return poiData;
	}
	
	private static String encode(String s) {
		return new BigInteger(s.getBytes()).toString(s.length());
	}

}
