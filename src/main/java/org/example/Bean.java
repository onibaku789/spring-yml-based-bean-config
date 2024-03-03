package org.example;

import java.util.List;
import java.util.Map;

public class Bean {
    private String beanName;
    private String className;
    private Map<String, String> properties; // Updated to include properties

    // Getters and Setters
    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public Map<String, String> getProperties() {
        return properties;
    }
}
