package com.github.nes370.javant;

import org.json.simple.JSONObject;

public class Car {

	private int carID;
	private String enterSound;
	private int id;
	private String name;
	private long price;
	private boolean purchasable;
	private int unlockLevel;
	
	public Car(JSONObject data) {
		this.carID = (int) data.get("carID");
		this.enterSound = (String) data.get("enterSound");
		this.id = (int) data.get("id");
		this.name = (String) data.get("name");
		this.price = (long) data.get("price");
		this.purchasable = (boolean) data.get("purchasable");
		this.unlockLevel = (int) data.get("unlockLevel");
	}

	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}

	public String getEnterSound() {
		return enterSound;
	}

	public void setEnterSound(String enterSound) {
		this.enterSound = enterSound;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public boolean isPurchasable() {
		return purchasable;
	}

	public void setPurchasable(boolean purchasable) {
		this.purchasable = purchasable;
	}

	public int getUnlockLevel() {
		return unlockLevel;
	}

	public void setUnlockLevel(int unlockLevel) {
		this.unlockLevel = unlockLevel;
	}

}
