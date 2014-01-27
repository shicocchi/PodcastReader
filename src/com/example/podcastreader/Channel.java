package com.example.podcastreader;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;

public class Channel {
	@Element(name="copyright", required=false)
	private String copyright;

	@Element(name="description")
	private String description;

	@Namespace(prefix="itunes")
	@Element(name="subtitle", required=false)
	private String itunesSubtitle;

	@Namespace(prefix="itunes")
	@Element(name="author", required=false)
	private String itunesAuthor;

	@Namespace(prefix="itunes")
	@Element(name="image", required=false)
	private ItunesImage itunesImage;

	@Element(name="language", required=false)
	private String language;

	@Element(name="link")
	private String link;

	@Element(name="lastBuildDate", required=false)
	private String lastBuildDate;

	@Element(name="title")
	private String title;

	@Namespace(prefix="itunes")
	@Element(name="category", required=false)
	private ItunesCategory itunesCategory;
	
	@Element(name="item", required=false)
	private PodcastItem item;

	public String getCopyright() {
		return copyright;
	}

	public String getDescription() {
		return description;
	}

	public String getItunesSubtitle() {
		return itunesSubtitle;
	}

	public String getItunesAuthor() {
		return itunesAuthor;
	}

	public ItunesImage getItunesImage() {
		return itunesImage;
	}

	public String getLanguage() {
		return language;
	}

	public String getLink() {
		return link;
	}

	public String getLastBuildDate() {
		return lastBuildDate;
	}

	public String getTitle() {
		return title;
	}

	public ItunesCategory getItunesCategory() {
		return itunesCategory;
	}

	public PodcastItem getItem() {
		return item;
	}
}