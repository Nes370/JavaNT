package com.github.nes370.javant;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Client {
	
	private String username;
	private String password;
	private int adb;
	private TimeZone tz;
	private CookieManager cookieManager;
	
	Client() {}
	
	Client(String username, String password) {
		this.username = username;
		this.password = password;
		adb = 0;
		tz = TimeZone.getDefault();
		cookieManager = new CookieManager();
	}

	Client(String username, String password, TimeZone tz) {
		this.username = username;
		this.password = password;
		adb = 0;
		this.tz = tz;
		cookieManager = new CookieManager();
	}
	
	Client(String username, String password, String tz) {
		this.username = username;
		this.password = password;
		adb = 0;
		this.tz = TimeZone.getTimeZone(tz);
		cookieManager = new CookieManager();
	}
	
	Client(String username, String password, TimeZone tz, int adb) {
		this.username = username;
		this.password = password;
		this.adb = adb;
		this.tz = tz;
		cookieManager = new CookieManager();
	}
	
	Client(String username, String password, String tz, int adb) {
		this.username = username;
		this.password = password;
		this.adb = adb;
		this.tz = TimeZone.getTimeZone(tz);
		cookieManager = new CookieManager();
	}
	
	//Log in-out
	public void login() throws IOException {
		URL url = new URL("https://www.nitrotype.com/api/login");
		String method = "POST";
		Map<String, String> parameters = new HashMap<>();
		parameters.put("username", username);
		parameters.put("password", password);
		parameters.put("adb", "" + adb);
		parameters.put("tz", tz.getID());
		request(url, method, parameters);
	}
	
	public void cleverLogin() {
		//TODO
	}
	
	public void googleLogin() {
		//TODO
	}
	
	public void facebookLogin() {
		//TODO
	}
	
	public void logout() throws IOException {
		URL url = new URL("https://www.nitrotype.com/api/logout");
		String method = "POST";
		Map<String, String> parameters = new HashMap<>();
		parameters.put("uhash", cookieManager.getCookieStore().getCookies().stream().findAny().filter(cookie -> cookie.getName().equals("ntuserrem")).get().getValue());
		request(url, method, parameters);
	}

	//Achievements
	public Achievements getAchievments() throws IOException, ParseException, RuntimeException {
		URL url = new URL("https://www.nitrotype.com/api/achievements");
		String method = "GET";
		JSONObject response = (JSONObject) new JSONParser().parse(request(url, method, null));
		if(!(boolean) response.get("success"))
			throw new RuntimeException((String) ((JSONObject) response.get("data")).get("message"));
		return new Achievements((JSONObject) response.get("data"));
	}
	
	public void claimAchievement(int achievementID) throws IOException, ParseException {
		URL url = new URL("https://www.nitrotype.com/api/achievements/claim/id/" + achievementID);
		String method = "GET";
		Map<String, String> parameters = new HashMap<>();
		parameters.put("uhash", cookieManager.getCookieStore().getCookies().stream().findAny().filter(cookie -> cookie.getName().equals("ntuserrem")).get().getValue());
		JSONObject response = (JSONObject) new JSONParser().parse(request(url, method, parameters));
		if(!(boolean) response.get("success"))
			throw new RuntimeException((String) ((JSONObject) response.get("data")).get("message"));
	}
	
	//Cars
	public Cars getCars() throws IOException, ParseException, RuntimeException {
		URL url = new URL("https://www.nitrotype.com/api/cars");
		String method = "GET";
		JSONObject response = (JSONObject) new JSONParser().parse(request(url, method, null));
		if(!(boolean) response.get("success"))
			throw new RuntimeException((String) ((JSONObject) response.get("data")).get("message"));
		return new Cars((JSONArray) response.get("data"));
	}
	
	public void buyCar(int carID) throws IOException, ParseException {
		URL url = new URL("https://www.nitrotype.com/api/cars/" + carID + "/buy");
		String method = "POST";
		Map<String, String> parameters = new HashMap<>();
		parameters.put("password", password);
		parameters.put("carID", "" + carID);
		parameters.put("uhash", cookieManager.getCookieStore().getCookies().stream().findAny().filter(cookie -> cookie.getName().equals("ntuserrem")).get().getValue());
		JSONObject response = (JSONObject) new JSONParser().parse(request(url, method, parameters));
		if(!(boolean) response.get("success"))
			throw new RuntimeException((String) ((JSONObject) response.get("data")).get("message"));
	}
	
	public void sellCar(int carID) throws IOException, ParseException {
		URL url = new URL("https://www.nitrotype.com/api/cars/" + carID + "/sell");
		String method = "POST";
		Map<String, String> parameters = new HashMap<>();
		parameters.put("password", password);
		parameters.put("carID", "" + carID);
		parameters.put("uhash", cookieManager.getCookieStore().getCookies().stream().findAny().filter(cookie -> cookie.getName().equals("ntuserrem")).get().getValue());
		JSONObject response = (JSONObject) new JSONParser().parse(request(url, method, parameters));
		if(!(boolean) response.get("success"))
			throw new RuntimeException((String) ((JSONObject) response.get("data")).get("message"));
	}
	
	public void paintCar(int carID, int angle) throws IOException, ParseException {
		URL url = new URL("https://www.nitrotype.com/api/cars/" + carID + "/paint");
		String method = "POST";
		Map<String, String> parameters = new HashMap<>();
		parameters.put("angle", "" + angle);
		parameters.put("password", password);
		parameters.put("carID", "" + carID);
		parameters.put("uhash", cookieManager.getCookieStore().getCookies().stream().findAny().filter(cookie -> cookie.getName().equals("ntuserrem")).get().getValue());
		JSONObject response = (JSONObject) new JSONParser().parse(request(url, method, parameters));
		if(!(boolean) response.get("success"))
			throw new RuntimeException((String) ((JSONObject) response.get("data")).get("message"));
	}
	
	public void useCar(int carID) throws IOException, ParseException {
		URL url = new URL("https://www.nitrotype.com/api/cars/" + carID + "/use");
		String method = "POST";
		Map<String, String> parameters = new HashMap<>();
		parameters.put("uhash", cookieManager.getCookieStore().getCookies().stream().findAny().filter(cookie -> cookie.getName().equals("ntuserrem")).get().getValue());
		JSONObject response = (JSONObject) new JSONParser().parse(request(url, method, parameters));
		if(!(boolean) response.get("success"))
			throw new RuntimeException((String) ((JSONObject) response.get("data")).get("message"));
	}
	
	public void arrangeCars(int[] garage) throws IOException, ParseException {
		URL url = new URL("https://www.nitrotype.com/api/cars-arrange");
		String method = "POST";
		Map<String, String> parameters = new HashMap<>();
		for(int i = 0; i < garage.length / 30 * 30; i++)
			parameters.put("garage[]", "" + garage[i]);
		parameters.put("uhash", cookieManager.getCookieStore().getCookies().stream().findAny().filter(cookie -> cookie.getName().equals("ntuserrem")).get().getValue());
		JSONObject response = (JSONObject) new JSONParser().parse(request(url, method, parameters));
		if(!(boolean) response.get("success"))
			throw new RuntimeException((String) ((JSONObject) response.get("data")).get("message"));
	}
	
	//Friends
	public Friends getFriends() throws IOException, ParseException {
		URL url = new URL("https://www.nitrotype.com/api/friends");
		String method = "GET";
		Map<String, String> parameters = new HashMap<>();
		parameters.put("uhash", cookieManager.getCookieStore().getCookies().stream().findAny().filter(cookie -> cookie.getName().equals("ntuserrem")).get().getValue());
		JSONObject response = (JSONObject) new JSONParser().parse(request(url, method, parameters));
		if(!(boolean) response.get("success"))
			throw new RuntimeException((String) ((JSONObject) response.get("data")).get("message"));
		return new Friends((JSONObject) response.get("data"));
	}
	
	public Friends getFriends(boolean online) throws IOException, ParseException {
		URL url = new URL("https://www.nitrotype.com/api/friends");
		String method = "GET";
		Map<String, String> parameters = new HashMap<>();
		if(online)
			parameters.put("online", "" + 1);
		else parameters.put("online", "" + 0);
		parameters.put("uhash", cookieManager.getCookieStore().getCookies().stream().findAny().filter(cookie -> cookie.getName().equals("ntuserrem")).get().getValue());
		JSONObject response = (JSONObject) new JSONParser().parse(request(url, method, parameters));
		if(!(boolean) response.get("success"))
			throw new RuntimeException((String) ((JSONObject) response.get("data")).get("message"));
		return new Friends((JSONObject) response.get("data"));
	}
	
	public void deleteFriend(int userID) throws IOException, ParseException {
		URL url = new URL("https://www.nitrotype.com/api/friends/" + userID + "/delete");
		String method = "POST";
		Map<String, String> parameters = new HashMap<>();
		parameters.put("uhash", cookieManager.getCookieStore().getCookies().stream().findAny().filter(cookie -> cookie.getName().equals("ntuserrem")).get().getValue());
		JSONObject response = (JSONObject) new JSONParser().parse(request(url, method, parameters));
		if(!(boolean) response.get("success"))
			throw new RuntimeException((String) ((JSONObject) response.get("data")).get("message"));
	}
	
	public void requestFriend(int userID) throws IOException, ParseException {
		//TODO
	}
	
	public void sendCash(int userID, long amount, long playersCash, double feePercent) throws IOException, ParseException {
		//TODO
	}
	
	//Nitros
	public void buyNitros(int quantity) throws IOException, ParseException {
		URL url = new URL("https://www.nitrotype.com/api/buy-nitros");
		String method = "POST";
		Map<String, String> parameters = new HashMap<>();
		parameters.put("password", password);
		parameters.put("quantity", "" + quantity);
		parameters.put("uhash", cookieManager.getCookieStore().getCookies().stream().findAny().filter(cookie -> cookie.getName().equals("ntuserrem")).get().getValue());
		JSONObject response = (JSONObject) new JSONParser().parse(request(url, method, parameters));
		if(!(boolean) response.get("success"))
			throw new RuntimeException((String) ((JSONObject) response.get("data")).get("message"));
	}
	
	public void sellNitros(int quantity) throws IOException, ParseException {
		URL url = new URL("https://www.nitrotype.com/api/sell-nitros");
		String method = "POST";
		Map<String, String> parameters = new HashMap<>();
		parameters.put("password", password);
		parameters.put("quantity", "" + quantity);
		parameters.put("uhash", cookieManager.getCookieStore().getCookies().stream().findAny().filter(cookie -> cookie.getName().equals("ntuserrem")).get().getValue());
		JSONObject response = (JSONObject) new JSONParser().parse(request(url, method, parameters));
		if(!(boolean) response.get("success"))
			throw new RuntimeException((String) ((JSONObject) response.get("data")).get("message"));
	}
	
	private String request(URL url, String method, Map<String, String> parameters) throws IOException {
		//Create request
		//URL url = new URL("https://www.nitrotype.com/api/login");
		HttpURLConnection c = (HttpURLConnection) url.openConnection();
		c.setRequestMethod(method);
		
		//Add request parameters
		//Map<String, String> parameters = new HashMap<>();
		//parameters.put("username", username);
		//parameters.put("password", password);
		//parameters.put("adb", "" + adb);
		//parameters.put("tz", tz.getID());
		if(parameters != null) {
			c.setDoOutput(true);
			DataOutputStream out = new DataOutputStream(c.getOutputStream());
			out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
			out.flush();
			out.close();
		}
		
		//Set request headers
		//accept
		//accept-encoding
		//accept-language
		//content-length
		//content-type
		c.setRequestProperty("cookie", StringUtils.join(cookieManager.getCookieStore().getCookies(), ";"));
		//dnt
		//origin
		//referer
		c.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.109 Safari/537.36");
		//x-requested-with
		
		//Configure timeouts
		//c.setConnectTimeOut(5000);
		//c.setReadTimeout(5000);
		
		//Handle Cookies
		String cookiesHeader = c.getHeaderField("Set-Cookie");
		List<HttpCookie> cookies = HttpCookie.parse(cookiesHeader);
		cookies.forEach(cookie -> cookieManager.getCookieStore().add(null, cookie));
		
		//Read response
		int status = c.getResponseCode();
		Reader streamReader = null;
		if(status > 299) {
			streamReader = new InputStreamReader(c.getErrorStream());
		} else {
			streamReader = new InputStreamReader(c.getInputStream());
		}
		BufferedReader in = new BufferedReader(streamReader);
		String inputLine;
		StringBuffer content = new StringBuffer();
		while((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		in.close();
		//log(content.toString());
		log(FullResponseBuilder.getFullResponse(c));
		c.disconnect();
		
		return content.toString();
	}
	
	private void log(String message) {
		System.out.println(message);
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getAdb() {
		return adb;
	}

	public void setAdb(int adb) {
		this.adb = adb;
	}

	public TimeZone getTimeZone() {
		return tz;
	}

	public void setTimeZone(TimeZone tz) {
		this.tz = tz;
	}
	
	public void clearCookies() {
		cookieManager = new CookieManager();
	}
	
}
