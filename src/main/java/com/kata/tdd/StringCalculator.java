package com.kata.tdd;

import org.springframework.util.StringUtils;

public class StringCalculator {

    // "//[delimiter]\n[numbers...]"
    public int add(String numbers) throws Exception {
        if (!StringUtils.hasText(numbers))
            return 0;

        String[] split = numbers.split("\n");
        Character delimiter = split[0].charAt(split[0].length()-1);
        String[] nums = split[1].split(delimiter.toString());

        return sum(nums);
    }

    public int addBasic(String numbers) throws Exception {
        if (!StringUtils.hasText(numbers))
            return 0;

        String[] nums = numbers.split(",|\n");
        return sum(nums);
    }

    int sum(String[] nums) throws Exception {
        int sum = 0;
        for (String n : nums) {
            int i = Integer.parseInt(n);
            if(i<0){
                throw new Exception("negatives not allowed");
            }
            sum += i;
        }
        return sum;
    }

}
