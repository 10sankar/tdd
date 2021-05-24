package com.kata.tdd;

import org.springframework.util.StringUtils;

public class StringCalculator {

    public int add(String numbers){
        if(!StringUtils.hasText(numbers))
            return 0;

        return 0;
    }
}
