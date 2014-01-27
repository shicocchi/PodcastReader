package com.example.podcastreader;

import org.simpleframework.xml.Attribute;

public class ItunesCategory {
	@Attribute(required=false)
	private String text;

	public String getText() {
		return text;
	}
}
