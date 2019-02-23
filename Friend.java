package com.github.nes370.javant;

import org.json.simple.JSONArray;

public class Friend {

	private int userID;
	private int carID;
	private int carHueAngle;
	private String username;
	private String displayName;
	private String country;
	private String gender;
	private String title;
	private int level;
	private int avgSpeed;
	private int racesPlayed;
	private String status;
	private long lastLogin;
	private String membership;
	private int teamID;
	private String tag;
	private String tagColor;
	private String friendType;
	private String action;
	private long lastActivity;
	
	public Friend(String[] fields, JSONArray data) {
		for(int i = 0; i < fields.length; i++) {
			switch(fields[i]) {
				case "userID": userID = (int) data.get(i);
					break;
				case "carID": carID = (int) data.get(i);
					break;
				case "carHueAngle": carHueAngle = (int) data.get(i);
					break;
				case "username": username = (String) data.get(i);
					break;
				case "displayName": displayName = (String) data.get(i);
					break;
				case "country": country = (String) data.get(i);
					break;
				case "gender": gender = (String) data.get(i);
					break;
				case "title": title = (String) data.get(i);
					break;
				case "level": level = (int) data.get(i);
					break;
				case "avgSpeed": avgSpeed = (int) data.get(i);
					break;
				case "racesPlayed": racesPlayed = (int) data.get(i);
					break;
				case "status": status = (String) data.get(i);
					break;
				case "lastLogin": lastLogin = (long) data.get(i);
					break;
				case "membership": membership = (String) data.get(i);
					break;
				case "teamID": teamID = (int) data.get(i);
					break;
				case "tag": tag = (String) data.get(i);
					break;
				case "tagColor": tagColor = (String) data.get(i);
					break;
				case "friendType": friendType = (String) data.get(i);
					break;
				case "action": action = (String) data.get(i);
					break;
				case "lastActivity": lastActivity = (long) data.get(i);
					break;
			}
		}
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}

	public int getCarHueAngle() {
		return carHueAngle;
	}

	public void setCarHueAngle(int carHueAngle) {
		this.carHueAngle = carHueAngle;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getAvgSpeed() {
		return avgSpeed;
	}

	public void setAvgSpeed(int avgSpeed) {
		this.avgSpeed = avgSpeed;
	}

	public int getRacesPlayed() {
		return racesPlayed;
	}

	public void setRacesPlayed(int racesPlayed) {
		this.racesPlayed = racesPlayed;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(long lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getMembership() {
		return membership;
	}

	public void setMembership(String membership) {
		this.membership = membership;
	}

	public int getTeamID() {
		return teamID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTagColor() {
		return tagColor;
	}

	public void setTagColor(String tagColor) {
		this.tagColor = tagColor;
	}

	public String getFriendType() {
		return friendType;
	}

	public void setFriendType(String friendType) {
		this.friendType = friendType;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public long getLastActivity() {
		return lastActivity;
	}

	public void setLastActivity(long lastActivity) {
		this.lastActivity = lastActivity;
	}

}
