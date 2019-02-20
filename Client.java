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
		setUsername(username);
		setPassword(password);
		setAdb(0);
		setTimeZone(TimeZone.getDefault());
		clearCookies();
	}

	Client(String username, String password, TimeZone tz) {
		setUsername(username);
		setPassword(password);
		setAdb(0);
		setTimeZone(tz);
		clearCookies();
	}
	
	Client(String username, String password, String tz) {
		setUsername(username);
		setPassword(password);
		setAdb(0);
		setTimeZone(TimeZone.getTimeZone(tz));
		clearCookies();
	}
	
	Client(String username, String password, TimeZone tz, int adb) {
		setUsername(username);
		setPassword(password);
		setAdb(adb);
		setTimeZone(tz);
		clearCookies();
	}
	
	Client(String username, String password, String tz, int adb) {
		setUsername(username);
		setPassword(password);
		setAdb(adb);
		setTimeZone(TimeZone.getTimeZone(tz));
		clearCookies();
	}
	
	public void login() throws IOException {		
		URL url = new URL("https://www.nitrotype.com/api/login");
		HttpURLConnection c = (HttpURLConnection) url.openConnection();
		c.setRequestMethod("POST");
		
		Map<String, String> parameters = new HashMap<>();
		parameters.put("username", username);
		parameters.put("password", password);
		parameters.put("adb", "" + adb);
		parameters.put("tz", tz.getID());
		
		c.setDoOutput(true);
		DataOutputStream out = new DataOutputStream(c.getOutputStream());
		out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
		out.flush();
		out.close();
		
		//accept
		//accept-encoding
		//accept-language
		//content-length
		//content-type
		//cookie
		//dnt
		//origin
		//referer
		c.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.109 Safari/537.36");
		//x-requested-with
		
		String cookiesHeader = c.getHeaderField("Set-Cookie");
		List<HttpCookie> cookies = HttpCookie.parse(cookiesHeader);
		cookies.forEach(cookie -> cookieManager.getCookieStore().add(null, cookie));
		
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
		
		log(content.toString());
		log(FullResponseBuilder.getFullResponse(c));
		
		c.disconnect();
	}
	
	public void logout() throws IOException {
		URL url = new URL("https://www.nitrotype.com/api/login");
		HttpURLConnection c = (HttpURLConnection) url.openConnection();
		c.setRequestMethod("POST");
		
		Map<String, String> parameters = new HashMap<>();
		parameters.put("uhash", cookieManager.getCookieStore().getCookies().stream().findAny().filter(cookie -> cookie.getName().equals("ntuserrem")).get().getValue());
		
		c.setDoOutput(true);
		DataOutputStream out = new DataOutputStream(c.getOutputStream());
		out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
		out.flush();
		out.close();
		
		//accept
		//accept-encoding
		//accept-language
		//content-length
		//content-type
		c.setRequestProperty("cookie", StringUtils.join(cookieManager.getCookieStore().getCookies(), ";"));//cookie
		//dnt
		//origin
		//referer
		c.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.109 Safari/537.36");
		//x-requested-with
		
		String cookiesHeader = c.getHeaderField("Set-Cookie");
		List<HttpCookie> cookies = HttpCookie.parse(cookiesHeader);
		cookies.forEach(cookie -> cookieManager.getCookieStore().add(null, cookie));
		
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
		
		log(content.toString());
		log(FullResponseBuilder.getFullResponse(c));
		
		c.disconnect();
	}
	
	private void log(String message) {
		System.out.println(message);
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

	public Achievements getAchievments() throws IOException, ParseException {
		URL url = new URL("https://www.nitrotype.com/api/login");
		HttpURLConnection c = (HttpURLConnection) url.openConnection();
		c.setRequestMethod("GET");
		c.setRequestProperty("cookie", StringUtils.join(cookieManager.getCookieStore().getCookies(), ";"));
		c.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.109 Safari/537.36");
		
		String cookiesHeader = c.getHeaderField("Set-Cookie");
		List<HttpCookie> cookies = HttpCookie.parse(cookiesHeader);
		cookies.forEach(cookie -> cookieManager.getCookieStore().add(null, cookie));
		
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
		
		log(content.toString());
		log(FullResponseBuilder.getFullResponse(c));
		
		c.disconnect();
		
		return new Achievements((JSONObject) new JSONParser().parse(content.toString()));
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
