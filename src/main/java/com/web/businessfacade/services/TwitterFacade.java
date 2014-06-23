package com.web.businessfacade.services;

import java.util.List;

public interface TwitterFacade 
{
void post(String tweet);

List<String> getMyTweets();
}
