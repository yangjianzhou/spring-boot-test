package com.iwill.util;

import org.springframework.context.ConfigurableApplicationContext;
import org.unitils.spring.util.ApplicationContextFactory;

import java.util.List;

/**
 * point :
 * 1.need update
 * "SpringModule.applicationContextFactory.implClassName" -> "org.unitils.org.unitils.spring.util.ClassPathXmlApplicationContextFactory"
 *
 * AnnotationConfigWebApplicationContext
 */
public class SpringBootApplicationContextFactory implements ApplicationContextFactory {

    private static ConfigurableApplicationContext configurableApplicationContext ;

    public ConfigurableApplicationContext createApplicationContext(List<String> locations) {
        return configurableApplicationContext;
    }

    public static void setConfigurableApplicationContext(ConfigurableApplicationContext configurableApplicationContext) {
        SpringBootApplicationContextFactory.configurableApplicationContext = configurableApplicationContext;
    }
}
