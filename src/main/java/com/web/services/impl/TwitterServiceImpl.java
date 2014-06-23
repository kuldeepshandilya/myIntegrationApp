package com.web.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.MessagingException;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageHandler;
import org.springframework.integration.core.PollableChannel;
import org.springframework.integration.message.GenericMessage;

import com.sun.syndication.feed.synd.SyndEntry;
import com.web.services.TwitterService;
import com.web.services.beans.Feed;

public class TwitterServiceImpl implements TwitterService {
	
	
	public boolean tweet(String tweet) {
		@SuppressWarnings("resource")
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("TwitterSendUpdates-context.xml");
		MessageChannel twitterOutChannel = context.getBean("twitterOut", MessageChannel.class);
		Message<String> twitterUpdate = new GenericMessage<String>(tweet);
		return twitterOutChannel.send(twitterUpdate);
	}

	public List<String> getMyTweets() {
		@SuppressWarnings("resource")
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("TwitterSearch-context.xml");
		final List<String> myTweets = new ArrayList<String>();
		DirectChannel twitterInputChannel = context.getBean("twitterOut", DirectChannel.class);
		twitterInputChannel.subscribe(new MessageHandler() {
				
				@Override
				public void handleMessage(Message<?> message) throws MessagingException {
					myTweets.add(message.getPayload().toString());
				}
			});
		
		//Waiting for tweets in publish-subscribe mode
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myTweets;
	}	
}
