package com.web.businessfacade.services;

import java.util.List;

import com.web.businessfacade.beans.FeedBean;

public interface FeedFacade 
{
 public List<FeedBean> getFeeds(String source);
}
