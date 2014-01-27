package com.example.podcastreader;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Rss {
	@Element(name="channel")
	private Channel channel;

	@Attribute
	private String version;

	public Channel getChannel() {
		return channel;
	}
	
	public String getVersion() {
		return version;
	}
}
