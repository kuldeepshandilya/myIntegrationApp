package com.web.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.core.PollableChannel;

import com.sun.syndication.feed.synd.SyndEntry;
import com.web.services.FeedService;
import com.web.services.beans.Feed;


public class FeedServiceImpl implements FeedService {

	public List<Feed> getFeeds(String source) 
	{
		//call integration layer 
		if ( "CNN".equalsIgnoreCase(source))
		return getFeeds();
		else
		return null;
	}

	private static List<Feed> getFeeds()
	{
		List<Feed> feeds = new ArrayList<Feed>();
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext("FeedInboundChannelAdapterSample-context.xml");
		PollableChannel feedChannel = ac.getBean("feedChannel", PollableChannel.class);
		for (int i = 0; i < 10; i++) {
			Message<SyndEntry> message = (Message<SyndEntry>) feedChannel.receive();
			if (message != null){
				SyndEntry entry = message.getPayload();
				Feed feed = new Feed((entry.getPublishedDate() != null) ? entry.getPublishedDate().toString(): null,entry.getTitle(),entry.getLink());
				feeds.add(feed);
				//System.out.println(entry.getPublishedDate() + " - <a href="+entry.getLink()+">" + entry.getTitle()+"</a>");
			}
			else {
				break;
			}
		}
	return feeds;
	}
}
