package com.web.services;

import java.util.List;

import com.web.services.beans.Feed;


/**
 * 
 * @author kutiwari
 *
 */
public interface FeedService 
{
	/**
	 * Return feeds for asked source.
	 * @param source
	 * @return
	 */
List<Feed> getFeeds(String source);
}
