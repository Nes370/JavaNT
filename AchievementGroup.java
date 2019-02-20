package com.github.nes370.javant;

import org.json.simple.JSONObject;

public class AchievementGroup {

	private int id;
	private String img;
	private String name;
	private int order;
	
	public AchievementGroup(JSONObject data) {
		setId((int) data.get("id"));
		setImg((String) data.get("img"));
		setName((String) data.get("name"));
		setOrder((int) data.get("order"));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

}
