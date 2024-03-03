package org.example;


import java.util.Arrays;

public class SplitterBean {
    private final String divider;
    private final UppercaseBean uppercaseBean;

    public SplitterBean(String divider, UppercaseBean uppercaseBean) {
        this.divider = divider;
        this.uppercaseBean = uppercaseBean;
    }


    public String[] split(String input) {
        return Arrays.stream(input.split(divider))
                .map(uppercaseBean::process)
                .toArray(String[]::new);

    }
}
