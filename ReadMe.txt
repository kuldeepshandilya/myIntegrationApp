#########################################################################################################################################
The readme covers following aspects of the web app
1) What the app does
2) How to run the app
3) App internal architecture

Details
--------

1) What the App does -
---------------------------

App display/posts data from/to third party service providers(CNN,twitter) using 'spring integration' as the enterprise integration framework.
   It has mainly three screens - 
   a) For getting CNN feeds - Based on search criteria(some regex in feed comments) defined in file 'FeedInboundChannelAdapterSample-context.xml', screen displays mathcing feeds from CNN.
   b) For showing twitter feeds - For a pre-configured Twitter test user 'SkilledTester', it shows some tweets from his profile based on some regex criteria
                                  as specifie in file 'TwitterSearch-context.xml'
   c) For posting tweet - On the behalf of a pre-configured Twitter test user 'SkilledTester', it allows to post tweets on his profile.Config file is 'TwitterSendUpdates-context'.

2)How to run the app - 
----------------------------

Deploy war in your application server/web server deployment directory. Since the application needs to connect to services on internet,
make sure code is able to use any proxy if applicable in your environment. If application is running inside Oracle proxy, you need to mention proxy detail
in start up script of your server. For example,when using tomcat, mention below in catalina.bat
set JAVA_OPTS = %JAVA_OPTS%; -Dhttp.proxyHost=<proxy-server-url> -Dhttp.proxyPort=<proxy-server-port>



3) Application architecture - 
----------------------------- 

                 AJAX                                    Spring Bean lookup                                 Spring Integration
 Views(JSP)  <---------> Facade(Spring MVC COntroller) <-----------------> ServiceLayerAPIs(Spring Beans) <---------------------->Third party(Twitter,CNN)
                 JSON                                      ServiceBeans
 
 It is an MVC application.
View  is JSP. It uses AJAX to hit REST end-points exposed as Spring MVC controllers in package com.web.businessfacade. These end-points return JSON response.
These Spring controllers work as facade layer between view and service layer. Actual services are in package com.web.services. These services talk to third party
service providers using spring integration jars.

The web.xml has entry for Spring MVC front controller(called dispatcher servlet)with url mapping /servicefacades/*. Config file mvc-dispatcher-servlet.xml
declares packages to scan for controllers(classes  having annotation @controller).
For example, one controller 'FeedFacadeImpl.java' declares its sub-url as 'feeds'. So, http:.../servicefacades/feeds will invoke this class.

Spring integration reference - http://projects.spring.io/spring-integration/  

Use URL http://<server>:<port>/myIntegrationApp   to launch application
e.g. http://localhost:8080/myIntegrationApp

To verify whether post has been tweeted, use the link (https://twitter.com/SkilledTester).