package org.example;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;
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
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        System.out.println("beanDefinitionNames = " + Arrays.toString(beanDefinitionNames));
    }

    private void registerBean(Bean config) {
        try {
            Class<?> beanClass = Class.forName(config.getClassName());
            BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(beanClass);

            config.getConstructorArgs().values().forEach(builder::addConstructorArgValue);
            if (config.getDependsOn() != null && !config.getDependsOn().isEmpty()) {
                config.getDependsOn().forEach(builder::addDependsOn);
            }
            applicationContext.registerBeanDefinition(config.getBeanName(), builder.getBeanDefinition());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Class not found for bean: " + config.getBeanName(), e);
        }
    }
}
