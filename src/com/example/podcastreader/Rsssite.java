package com.example.podcastreader;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
 
@Root
public class Rsssite {
 
	@Attribute
	public String key;
	
	@Element(name="url")
	public String url;
 
}
