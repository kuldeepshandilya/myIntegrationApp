<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Twit Here</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script>
function postTweetMsg()
{
debugger;
    var div = document.getElementById("myDiv");
    div.innerHTML = "Posting tweet ....";
	div.style.display="";
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
  if (xmlhttp.readyState==4)
    {
	div.appendChild(document.createTextNode("Tweet posted successfully."));
    }
    else
    {
    div.innerHTML=xmlhttp.responseText;
    }
  }
xmlhttp.open("POST","servicefacades/twitter",true);
var tweetMsg = document.getElementById("tweetMsg");
xmlhttp.send(tweetMsg.value);
}
</script>
  </head>
  
  <body>
    <form action="">
    <label>Write tweet Message : </label>
    <input type="text" id="tweetMsg"/>
    <input type="submit" onclick="postTweetMsg()"/>
    </form> <br>
    <div id="myDiv"><h2>Posting tweet ...</h2></div>
  </body>
</html>
