package com.example.podcastreader;

import org.simpleframework.xml.Attribute;

public class ItunesImage {

	@Attribute(required=false)
	private String href;

	public String getHref() {
		return href;
	}

}
