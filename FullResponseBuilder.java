package com.github.nes370.javant;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.List;

public class FullResponseBuilder {
	public static String getFullResponse(HttpURLConnection c) throws IOException {
		StringBuilder fullResponseBuilder = new StringBuilder();
		
		fullResponseBuilder.append(c.getResponseCode())
			.append(" ")
			.append(c.getResponseMessage())
			.append("\n");
		
		c.getHeaderFields().entrySet().stream()
			.filter(entry -> entry.getKey() != null)
			.forEach(entry -> {
				fullResponseBuilder.append(entry.getKey()).append(": ");
				List<String> headerValues = entry.getValue();
				Iterator<String> it = headerValues.iterator();
				if(it.hasNext()) {
					fullResponseBuilder.append(it.next());
					while(it.hasNext()) {
						fullResponseBuilder.append(", ").append(it.next());
					}
				}
				fullResponseBuilder.append(", ").append(it.next());
			});
		
		return fullResponseBuilder.toString();
	}

}
