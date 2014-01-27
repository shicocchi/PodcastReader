package com.example.podcastreader;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
 
@Root
public class Rsslist {
	@ElementList(name="list")
	public List<Rsssite> rsssite;
 
}