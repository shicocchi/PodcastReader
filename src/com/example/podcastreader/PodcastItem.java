package com.example.podcastreader;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;

public class PodcastItem {
	@Element(name="enclosure", required=false)
	private Enclosure enclosure;

	@Element(name="title")
	private String title;

	@Namespace(prefix="itunes")
	@Element(name="author", required=false)
	private String itunesAuthor;

	@Namespace(prefix="itunes")
	@Element(name="duration")
	private String itunesDuration;

	@Namespace(prefix="itunes")
	@Element(name="category", required=false)
	private ItunesCategory itunesCategory;

	@Element(name="pubDate", required=false)
	private String pubDate;
	
	public Enclosure getEnclosure() {
		return enclosure;
	}

	public String getTitle() {
		return title;
	}

	public String getItunesAuthor() {
		return itunesAuthor;
	}

	public String getItunesDuration() {
		return itunesDuration;
	}

	public ItunesCategory getItunesCategory() {
		return itunesCategory;
	}

	public String getPubDate() {
		return pubDate;
	}
}

