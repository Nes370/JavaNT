package com.github.nes370.javant;

import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Achievements {
	
	private List<Achievement> achievements;
	private List<AchievementGroup> groups;
	private List<AchievementText> text; //TODO choose a better format to display this as

	Achievements(JSONObject data) {
		JSONArray array = (JSONArray) data.get("achievements");
		for(int i = 0; i < array.size(); i++)
			achievements.add(new Achievement((JSONObject) array.get(i)));
		array = (JSONArray) data.get("groups");
		for(int i = 0; i < array.size(); i++)
			groups.add(new AchievementGroup((JSONObject) array.get(i)));
		JSONObject object = (JSONObject) data.get("text");
		@SuppressWarnings("unchecked")
		Iterator<String> i = object.keySet().iterator();
		while(i.hasNext()) {
			String key = i.next();
			text.add(new AchievementText(key, (JSONObject) object.get(key)));
		}
	}
	
	public List<Achievement> getList() {
		return achievements;
	}

	public List<AchievementGroup> getGroups() {
		return groups;
	}
	
	public List<AchievementText> getText() {
		return text;
	}
}
