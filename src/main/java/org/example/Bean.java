package org.example;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Bean {
    private String beanName;
    private String className;
    private Map<String, String> constructorArgs; // No change here
    private List<String> dependsOn; // Changed from String[] to List<String>

}
