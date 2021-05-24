package com.kata.tdd;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    int calledCount = 0;

    public int getCalledCount() {
        return calledCount;
    }

    // "//[delimiter]\n[numbers...]"
    public int add(String numbers) throws NegativeNumberException {
        calledCount++;
        if (!StringUtils.hasText(numbers))
            return 0;

        String[] split = numbers.split("\n");
        String delimiter = extractDelimiter(split[0]);
        String[] nums = split[1].split(delimiter);

        return sum(nums);
    }

    // "//delimiter\n[numbers...]"
    public int addBasicDelimiter(String numbers) throws NegativeNumberException {
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

    String extractDelimiter(String delimiter) {
        Matcher m = Pattern.compile("\\[(.*?)\\]").matcher(delimiter);
        List<String> result = new ArrayList<>();
        while (m.find()) {
            result.add(Pattern.quote( m.group(1) ));
        }
        return String.join("|", result);
    }

    int sum(String[] nums) throws NegativeNumberException {
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();
        for (String n : nums) {
            int i = Integer.parseInt(n);
            if (i < 0) {
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
