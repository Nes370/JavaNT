package com.github.nes370.javant;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Friends {

		private String[] fields;
		private JSONArray[] values;
		private List<Friend> friends; 
	
	public Friends(JSONObject data) {
		JSONArray fieldsData = (JSONArray) data.get("fields");
		fields = new String[fieldsData.size()];
		for(int i = 0; i < fieldsData.size(); i++)
			fields[i] = (String) fieldsData.get(i);
		
		JSONArray valuesData = (JSONArray) data.get("values");
		values = new JSONArray[valuesData.size()];
		friends = new ArrayList<Friend>();
		for(int i = 0; i < valuesData.size(); i++) {
			values[i] = (JSONArray) fieldsData.get(i);
			friends.add(new Friend(fields, (JSONArray) fieldsData.get(i)));
		}
	}
	
	public String[] getFields() {
		return fields;
	}
	
	public void setFields(String[] fields) {
		this.fields = fields;
	}

	public JSONArray[] getValues() {
		return values;
	}
	
	public void setValues(JSONArray[] values) {
		this.values = values;
	}
	
	public List<Friend> getFriends() {
		return friends;
	}

	public void setFriends(List<Friend> friends) {
		this.friends = friends;
	}

}
