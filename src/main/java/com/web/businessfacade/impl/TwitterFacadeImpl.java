package com.web.businessfacade.impl;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.businessfacade.services.TwitterFacade;
import com.web.services.TwitterService;
import com.web.utilities.ServiceLocator;

@Controller
@RequestMapping("twitter")
public class TwitterFacadeImpl implements TwitterFacade {

	@RequestMapping(method = RequestMethod.POST)
	public  void post(@RequestBody String tweetMsg)
	{
		TwitterService twitterService = ServiceLocator.getService("twitterService", TwitterService.class);
		twitterService.tweet(tweetMsg);
		//return "success";
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<String> getMyTweets() {
		TwitterService twitterService = ServiceLocator.getService("twitterService", TwitterService.class);
		List<String> tweets = twitterService.getMyTweets(); 
		return tweets;
	}

	

}
