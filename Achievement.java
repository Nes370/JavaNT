package com.github.nes370.javant;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Achievement {

	private int achievementID;
	private boolean active;
	private String desc;
	private int gid;
	private boolean hidden;
	private String name;
	private String newCarThumbs;
	private int points;
	private JSONObject reward;
	private String rewardDesc;
	private String ruleGroup;
	private JSONArray rules;
	
	public Achievement(JSONObject data) {
		setAchievementID((int) data.get("achievementID"));
		setActive((int) data.get("active") == 1);
		setDescription((String) data.get("desc"));
		setGid((int) data.get("gid"));
		setHidden((int) data.get("hidden") == 1);
		setName((String) data.get("name"));
		setNewCarThumbs((String) data.get("newCarThumbs"));
		setPoints((int) data.get("points"));
		setReward((JSONObject) data.get("reward"));
		setRewardDescription((String) data.get("rewardDesc"));
		setRuleGroup((String) data.get("ruleGroup"));
		setRules((JSONArray) data.get("rules"));
	}

	public int getAchievementID() {
		return achievementID;
	}

	public void setAchievementID(int achievementID) {
		this.achievementID = achievementID;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return desc;
	}

	public void setDescription(String desc) {
		this.desc = desc;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getNewCarThumbs() {
		return newCarThumbs;
	}

	public void setNewCarThumbs(String newCarThumbs) {
		this.newCarThumbs = newCarThumbs;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public JSONObject getReward() {
		return reward;
	}

	public void setReward(JSONObject reward) {
		this.reward = reward;
	}

	public String getRewardDescription() {
		return rewardDesc;
	}

	public void setRewardDescription(String rewardDesc) {
		this.rewardDesc = rewardDesc;
	}

	public String getRuleGroup() {
		return ruleGroup;
	}

	public void setRuleGroup(String ruleGroup) {
		this.ruleGroup = ruleGroup;
	}

	public JSONArray getRules() {
		return rules;
	}

	public void setRules(JSONArray rules) {
		this.rules = rules;
	}
	
}
