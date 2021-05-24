package com.kata.tdd;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    int calledCount = 0;

    public int getCalledCount() {
        return calledCount;
    }

    // "//delimiter\n[numbers...]"
    public int add(String numbers) throws NegativeNumberException {
        calledCount++;
        if (!StringUtils.hasText(numbers))
            return 0;

        String[] split = numbers.split("\n");
        Character delimiter = split[0].charAt(split[0].length() - 1);
        String[] nums = split[1].split(delimiter.toString());

        return sum(nums);
    }

    public int addBasic(String numbers) throws NegativeNumberException {
        calledCount++;
        if (!StringUtils.hasText(numbers))
            return 0;

        String[] nums = numbers.split(",|\n");
        return sum(nums);
    }

    int sum(String[] nums) throws NegativeNumberException {
        int sum = 0;
        List<Integer> negatives = null;
        for (String n : nums) {
            int i = Integer.parseInt(n);
            if (i < 0) {
                if (CollectionUtils.isEmpty(negatives)) negatives = new ArrayList<>();
                negatives.add(i);
            } else if (i > 1000) {
                continue;
            } else {
                sum += i;
            }
        }
        if (!CollectionUtils.isEmpty(negatives)) {
            throw new NegativeNumberException("negatives not allowed" + negatives);
        }
        return sum;
    }

}
