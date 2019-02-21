package com.github.nes370.javant;

import org.json.simple.JSONObject;

public class TextProperties {

	private String format;
	private String text;
	private String prefix;
	private String icon;
	
	public TextProperties(JSONObject data) {
		setText((String) data.get("text"));
		if(data.containsKey("prefix"))
			setPrefix((String) data.get("prefix"));
		if(data.containsKey("format"))
			setFormat((String) data.get("format"));
		setIcon((String) data.get("icon"));
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

}
