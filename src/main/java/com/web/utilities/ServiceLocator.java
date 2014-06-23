package com.web.utilities;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class ServiceLocator {

private static final String SERVICE_DEFINITION = "services-context.xml";
	
	private static BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(SERVICE_DEFINITION));
	
	public static <T> T getService(final String beanName, final Class<T> klass)
	{

		return (T) beanFactory.getBean(beanName, klass);
	}

}
