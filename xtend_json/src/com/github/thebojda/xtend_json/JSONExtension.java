package com.github.thebojda.xtend_json;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONExtension {

	public static class JSONArrayIterator implements Iterator<JSONElement> {

		private JSONArray ja;
		private int counter;

		public JSONArrayIterator(JSONArray ja) {
			this.ja = ja;
			this.counter = 0;
		}

		@Override
		public boolean hasNext() {
			return counter < ja.length();
		}

		@Override
		public JSONElement next() {
			return new JSONElement(ja.opt(counter++));
		}

		@Override
		public void remove() {
			// not implemented
		}
		
	}
	
	public static class JSONElement implements Iterable<JSONElement> {

		private Object content;
		
		public JSONElement(Object o) {
			this.content = o;
		}

		@Override
		public Iterator<JSONElement> iterator() {
			if(isJSONArray())
				return new JSONArrayIterator(asJSONArray());
			return null;
		}
		
		public void add(Object value) {
			if(!isJSONArray())
				return;
			asJSONArray().put(value);
		}

		public void add(Map value) {
			if(!isJSONArray())
				return;
			asJSONArray().put(value);
		}

		public void set(int index, Object value) throws JSONException {
			if(!isJSONArray())
				return;
			asJSONArray().put(index, value);
		}

		public void remove(int index) {
			if(!isJSONArray())
				return;
			asJSONArray().remove(index);
		}
		
		public boolean isJSONObject() {
			return (content instanceof JSONObject);
		}
		
		public boolean isJSONArray() {
			return (content instanceof JSONArray);
		}

		public JSONObject asJSONObject() {
			return (JSONObject)content;
		}
		
		public JSONArray asJSONArray() {
			return (JSONArray)content;
		}

		@Override
		public String toString() {
			return content.toString();
		}

	}
	
	@Pure
	public static JSONElement operator_doubleGreaterThan(JSONObject jo, String key) {
		return new JSONElement(jo.opt(key));
	}

	@Pure
	public static JSONElement operator_doubleGreaterThan(JSONElement je, String key) {
		if(!je.isJSONObject())
			return null;
		return new JSONElement(je.asJSONObject().opt(key));
	}

	@Pure
	public static JSONElement operator_doubleGreaterThan(JSONArray ja, int index) {
		return new JSONElement(ja.opt(index));
	}
	
	@Pure
	public static JSONElement operator_doubleGreaterThan(JSONElement je, int index) {
		if(!je.isJSONArray())
			return null;
		return new JSONElement(je.asJSONArray().opt(index));
	}

	public static JSONElement operator_tripleLessThan(JSONElement je, Object value) {
		if(je.isJSONArray())
			je.add(value);
		return je;
	}

	public static JSONElement operator_tripleLessThan(JSONElement je, Pair value) throws JSONException {
		if(je.isJSONObject())
			je.asJSONObject().put((String)value.getKey(), value.getValue());
		return je;
	}
	
	public static JSONElement operator_tripleLessThan(JSONElement je, Map value) throws JSONException {
		if(je.isJSONArray())
			je.add(value);
		if(je.isJSONObject()) {
			Iterator i = value.entrySet().iterator();
            while (i.hasNext()) {
                Map.Entry e = (Map.Entry)i.next();
                je.asJSONObject().put((String)e.getKey(), e.getValue());
            }	
		}
		return je;
	}

	public static Object operator_tripleGreaterThan(JSONElement je, String key) {
		if(!je.isJSONObject())
			return null;
		return je.asJSONObject().opt(key);
	}

	public static Object operator_tripleGreaterThan(JSONElement je, int index) {
		if(!je.isJSONArray())
			return null;
		return je.asJSONArray().opt(index);
	}

}
