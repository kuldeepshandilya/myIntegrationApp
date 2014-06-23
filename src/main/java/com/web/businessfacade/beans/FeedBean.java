package com.web.businessfacade.beans;

public class FeedBean 
{
private String date;
private String linkTitle;
private String linkURL;
private String author;
public FeedBean(String date, String linkTitle, String linkURL) 
{
	this.date = date;
	this.linkTitle = linkTitle;
	this.linkURL = linkURL;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getDate() {
	return date;
}
public String getLinkTitle() {
	return linkTitle;
}
public String getLinkURL() {
	return linkURL;
}




}
