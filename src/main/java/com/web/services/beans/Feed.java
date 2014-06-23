package com.web.services.beans;

public class Feed 
{
private String date;
private String linkTitle;
private String linkURL;
private String author;
public Feed(String date, String linkTitle, String linkURL) {
	super();
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
