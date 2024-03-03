package org.example;

public class UppercaseBean {
    private final String suffix;

    public UppercaseBean(String suffix) {
        this.suffix = suffix;
    }

    public String process(String input) {
        return (input.toUpperCase() + suffix);
    }
}
