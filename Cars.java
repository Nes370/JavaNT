package com.github.nes370.javant;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Cars {

	private List<Car> cars;
	
	public Cars(JSONArray data) {
		cars = new ArrayList<Car>();
		for(int i = 0; i < data.size(); i++)
			cars.add(new Car((JSONObject) data.get(i)));
	}
	
	public Car getCarByID(int carID) throws NoSuchElementException {
		return cars.stream().filter(car -> car.getCarID() == carID).findAny().get();
	}
	
	public Car getCarByName(String name) throws NoSuchElementException {
		return cars.stream().filter(car -> car.getName().equals(name)).findAny().get();
	}
	
	public List<Car> getList() {
		return cars;
	}
	
	public void setList(List<Car> cars) {
		this.cars = cars;
	}

}
