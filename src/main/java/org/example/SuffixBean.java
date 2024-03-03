package org.example;

public class SuffixBean {
    private final String suffix;

    public SuffixBean(String suffix) {
        this.suffix = suffix;
    }

    public String append(String input) {
        return input + suffix;
    }
}
