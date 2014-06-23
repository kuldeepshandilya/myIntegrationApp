package com.web.businessfacade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.businessfacade.beans.FeedBean;
import com.web.businessfacade.services.FeedFacade;
import com.web.services.FeedService;
import com.web.services.beans.Feed;
import com.web.utilities.ServiceLocator;

/**
 * Facade Layer. It can 
 *  - aggregate services from service layer, 
 *  - do transaction management, 
 *  - perform authentication,analytics,logging,
 *  - expose a synchronous API for asynchronous service layer calls(with an agreed upon timeout with client) or vice-versa
 *  - show appropriate messages/exceptions on client
 *  - If client does not support an HTTP method say DELETE, client can pass-in HTTP verb as url param an facade API can generate proper REST request
 * @author kutiwari
 *
 */

@Controller
@RequestMapping("feeds")
public class FeedFacadeImpl implements FeedFacade
{

	@RequestMapping(value="{source}", method = RequestMethod.GET)
	public @ResponseBody List<FeedBean> getFeeds(@PathVariable String source) {
		
		FeedService feedService = ServiceLocator.getService("feedService", FeedService.class);
		List<Feed> feeds =  feedService.getFeeds(source);
		
		if(feeds == null || feeds.isEmpty())
			return null;
		List<FeedBean> beans = new ArrayList<FeedBean>();
		for(Feed f : feeds)
		{
			FeedBean fb = convert(f);
			beans.add(fb);
		}
		return beans;
	}

	private static FeedBean convert(Feed feed)
	{
		return new FeedBean(feed.getDate(),feed.getLinkTitle(), feed.getLinkURL());
	}
}
