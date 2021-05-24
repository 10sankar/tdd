package com.kata.tdd;

import org.springframework.util.StringUtils;

public class StringCalculator {

    public int add(String numbers) {
        if (!StringUtils.hasText(numbers))
            return 0;

        String[] nums = numbers.split(",|\n");
        int sum = 0;
        for (String n : nums) {
            sum += Integer.valueOf(n);
        }
        return sum;
    }
}
