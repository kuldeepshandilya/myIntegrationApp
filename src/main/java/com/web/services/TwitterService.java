package com.web.services;

import java.util.List;

public interface TwitterService {
	boolean tweet(String tweet);
	List<String> getMyTweets();
}
