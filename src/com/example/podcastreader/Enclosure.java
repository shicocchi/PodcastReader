package com.example.podcastreader;

import org.simpleframework.xml.Attribute;

public class Enclosure {
	@Attribute(required=false)
	private String url;
	
	@Attribute(required=false)
	private String length;
	
	@Attribute(required=false)
	private String type;

	public String getUrl() {
		return url;
	}

	public String getLength() {
		return length;
	}

	public String getType() {
		return type;
	}
}

