package org.example;


public class SplitterBean {
    private String divider;


    public String[] split(String input) {
        return input.split(divider);
    }
}
