package org.example;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BeanRegistrationComponent implements ApplicationContextAware {

    @Autowired
    private BeanConfig beans;

    private AnnotationConfigApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (applicationContext instanceof AnnotationConfigApplicationContext ann) {
            this.applicationContext = ann;
        }
    }

    @PostConstruct
    public void postProcessBeanFactory() throws BeansException {
        beans.getBeans().forEach(this::registerBean);
    }

    private void registerBean(Bean config) {
        try {
            Class<?> beanClass = Class.forName(config.getClassName());
            BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(beanClass);

            for (Map.Entry<String, String> entry : config.getProperties().entrySet()) {
                String value = entry.getValue();
                builder.addConstructorArgValue(value);
            }
            applicationContext.registerBeanDefinition(config.getBeanName(), builder.getBeanDefinition());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Class not found for bean: " + config.getBeanName(), e);
        }
    }
}
