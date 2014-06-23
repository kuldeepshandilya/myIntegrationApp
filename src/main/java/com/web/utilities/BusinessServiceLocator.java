package com.web.utilities;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BusinessServiceLocator 
{
private static final String SERVICE_DEFINITION = "business-services-context.xml";
	
	
	
	public static <T> T getService(final String beanName, final Class<T> klass)
	{
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(SERVICE_DEFINITION));
		return (T) beanFactory.getBean(beanName, klass);
	}
}
