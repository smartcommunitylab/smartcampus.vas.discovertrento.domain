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
import it.sayservice.platform.core.message.Core.Address;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import org.codehaus.jackson.map.ObjectMapper;

import com.google.protobuf.ByteString;

import eu.trentorise.smartcampus.services.primiallaprima.data.message.Primiallaprima.Event;

public class PAPDataConverter implements DataConverter {

	@Override
	public Serializable toMessage(Map<String, Object> parameters) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object fromMessage(Serializable object) {
		List<ByteString> data = (List<ByteString>)object;
		Tuple res = new Tuple();
		List<GenericEvent> list = new ArrayList<GenericEvent>();
		for (ByteString bs : data) {
			try {
				Event e = Event.parseFrom(bs);
				list.add(extractGenericEvent(e));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		res.put("data", list.toArray(new GenericEvent[list.size()]));
		return res;
	}

	private GenericEvent extractGenericEvent(Event e) throws ParseException {
		GenericEvent ge = new GenericEvent();
		String desc = "";
		if (e.hasDetail())  {
			desc = e.getDetail().getDescription() +"\n";
		}
		if (e.hasPoi() && e.getPoi().hasAddress()) {
			desc += extractAddress(e.getPoi().getAddress());
		} else if (e.hasCity() && e.hasLuogo())  {
			desc += e.getCity()+" "+e.getLuogo();
		}
		ge.setDescription(desc);
		ge.setSource("PrimiAllaPrima");
//		ge.setFromTimeString(e.getEventDate());
		ge.setFromTime(parseDate(e.getEventDate()).getTime());
		String s = e.getTitle()+"; "+e.getLuogo()+"; "+e.getEventDate();
		ge.setId(encode(s));
		if (e.hasPoi()) {
			ge.setPoiId(e.getPoi().getPoiId());
		}
		ge.setTitle(e.getTitle());
//		ge.setType("culture");

		Map<String,Object> map = new TreeMap<String, Object>();
		if (e.hasInfoUrl()) map.put("infoUrl", e.getInfoUrl());
		if (e.hasDetail()) {
			if (e.getDetail().hasContact()) map.put("contact", e.getDetail().getContact());
			if (e.getDetail().hasContactUrl()) map.put("contactUrl", e.getDetail().getContactUrl());
			if (e.getDetail().hasType()) map.put("detailType", e.getDetail().getType());
		}

		try {
			ge.setCustomData(new ObjectMapper().writeValueAsString(map));
		} catch (Exception ex) {
		}

		
		return ge;
	}

	private String extractAddress(Address address) {
		return address.getStreet()+", " + address.getCity()+ " " +address.getRegion();
	}

	private static Date parseDate(String eventDate) throws ParseException {
		String format = "EEEE dd/MM/yyyy 'ore' HH:mm";
		SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.ITALIAN);
		return sdf.parse(eventDate);
	}
	
	private static String encode(String s) {
		return new BigInteger(s.getBytes()).toString(s.length());
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "MURATORI; Teatro Comunale di Tesero; lunedi 26/11/2012 ore 21:00";
		System.err.println(new Date(1349953548964L));
		System.err.println(new BigInteger(s.getBytes()).toString(s.length()));;
	}
}
