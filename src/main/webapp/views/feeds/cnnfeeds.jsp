<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
  <script>
function loadFeeds()
{
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
    var div = document.getElementById("myDiv");
	div.innerHTML="";
    var ul = document.createElement("ul");
    var feeds = eval(xmlhttp.response);
    for(var i = 0;i < feeds.length; i++)
    {
     var feed = feeds[i];
	 var li = document.createElement("li");
     var date= feed.date, linkTitle= feed.linkTitle, url = feed.linkURL;
     var row = document.createTextNode(date + " - "+ linkTitle);
     var anchor = document.createElement("a");
     anchor.setAttribute("href",url);
     anchor.appendChild(row);
	 li.appendChild(anchor);
     ul.appendChild(li);
    }
   div.appendChild(ul);
    }
  }
xmlhttp.open("GET","servicefacades/feeds/CNN",true);
xmlhttp.send();
}
</script>
   
    
    <title>CNN Feeds</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <h2>CNN Feeds</h2>
  <body onload="loadFeeds()">
    <div id="myDiv" > Fetching feeds ......</div>
  </body>
</html>
