package org.unitils.boot.autoconfigure;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.unitils.boot.SpringBootModule;
import org.unitils.boot.util.BootUnitilsBlockJUnit4ClassRunner;

/**
 * @Author: yangjianzhou
 * @Description:
 * @Date:Created in 2018-07-08
 */
@Configuration
@ConditionalOnClass(BootUnitilsBlockJUnit4ClassRunner.class)
public class ConfigurableApplicationContextAware implements InitializingBean {

    @Autowired
    private ConfigurableApplicationContext configurableApplicationContext;

    @Override
    public void afterPropertiesSet() throws Exception {
        SpringBootModule.setApplicationContext(configurableApplicationContext);
    }
}
