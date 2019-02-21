package com.github.nes370.javant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Achievements {
	
	private List<Achievement> achievements;
	private List<AchievementGroup> groups;
	private Map<String, TextProperties> text; //TODO choose a better format to display this as

	Achievements(JSONObject data) {
		achievements = new ArrayList<Achievement>();
		JSONArray array = (JSONArray) data.get("achievements");
		for(int i = 0; i < array.size(); i++)
			achievements.add(new Achievement((JSONObject) array.get(i)));
		
		groups = new ArrayList<AchievementGroup>();
		array = (JSONArray) data.get("groups");
		for(int i = 0; i < array.size(); i++)
			groups.add(new AchievementGroup((JSONObject) array.get(i)));
		
		text = new HashMap<>();
		JSONObject object = (JSONObject) data.get("text");
		@SuppressWarnings("unchecked")
		Iterator<String> i = object.keySet().iterator();
		while(i.hasNext()) {
			String key = i.next();
			text.put(key, new TextProperties((JSONObject) object.get(key)));
		}
		
	}
	
	public List<Achievement> getList() {
		return achievements;
	}

	public List<AchievementGroup> getGroups() {
		return groups;
	}
	
	public Map<String, TextProperties> getText() {
		return text;
	}
	
	public Achievement getAchievementByID(int achievementID) throws NoSuchElementException {
		return achievements.stream().filter(achievement -> achievement.getAchievementID() == achievementID).findAny().get();
	}
	
	public AchievementGroup getGroupByID(int groupID) throws NoSuchElementException {
		return groups.stream().filter(group -> group.getId() == groupID).findAny().get();
	}
	
	public TextProperties getTextProperties(String textKey) {
		return this.text.get(textKey);
	}
}
