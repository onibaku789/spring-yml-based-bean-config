package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StringManipulationService {
    @Autowired
    private UppercaseBean uppercaseBean;
    @Autowired
    private SuffixBean suffixBean;

    public String processString(String input) {
        return suffixBean.append(uppercaseBean.process(input));
    }
}
