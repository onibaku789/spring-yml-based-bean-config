package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class StringManipulationService {
    @Autowired
    private UppercaseBean uppercaseBean;
    @Autowired
    private SuffixBean suffixBean;
    @Autowired
    private SplitterBean splitterBean;

    public String processString(String input) {
        String process = uppercaseBean.process(input);
        return Arrays.toString(splitterBean.split(suffixBean.append(input)));
    }
}
