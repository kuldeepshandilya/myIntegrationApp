<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My Tweets</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script>
  function showMyTweets()
  {
  var div = document.getElementById("mytweets");
  div.innerHTML="Getting tweets ...";
  var xmlhttp;
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
		div.innerHTML="";
		var tweets = eval(xmlhttp.response);
		if (tweets && tweets.length > 0 )
		{
		    div.appendChild(document.createTextNode("Below are some tweets based on tweet search criteria:-"));
		     div.appendChild(document.createTextNode("*****************************************************"));
		    div.appendChild(document.createElement("br"));
		    div.appendChild(document.createElement("br"));
		    
			for (var i = 0;i < tweets.length; i++)
			{
			var tweetNode = document.createTextNode(tweets[i]);
			div.appendChild(tweetNode);
			div.appendChild(document.createElement("br"));
			}
		}
    }
    else
    {
    div.innerHTML="Getting tweets ...";
    }
  }
xmlhttp.open("GET","servicefacades/twitter",true);
xmlhttp.send();
  
  }
  </script>
  <body onLoad="showMyTweets()">
    <div id="mytweets">Getting tweets ...</div>
  </body>
</html>
