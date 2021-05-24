package com.kata.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    void addEmptyString() throws NegativeNumberException {
        String empty = "";
        int result = calculator.addBasic(empty);
        assertThat(result).isZero();
    }

    @Test
    void addOneNumber() throws NegativeNumberException {
        String oneInput = "1";
        int result = calculator.addBasic(oneInput);
        assertThat(result).isOne();
    }

    @Test
    void addCommaSeparatedNumbers() throws NegativeNumberException {
        String commaSeparatedNumbers = "1,2";
        int result = calculator.addBasic(commaSeparatedNumbers);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void addCommaSeparatedNumbersIgnoreLargeNumbers() throws NegativeNumberException {
        String commaSeparatedNumbers = "1,1001";
        int result = calculator.addBasic(commaSeparatedNumbers);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void addCommaSeparated_N_Numbers() throws NegativeNumberException {
        String commaSeparatedNumbers = "1,2,3";
        int result = calculator.addBasic(commaSeparatedNumbers);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void addCommaSeparatedOrLine_N_Numbers() throws NegativeNumberException {
        String commaSeparatedNumbers = "1\n2,3";
        int result = calculator.addBasic(commaSeparatedNumbers);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void addCustomDelimiter() throws NegativeNumberException {
        String input = "//;\n1;2";
        int result = calculator.add(input);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void addNegativeNumbers() {
        String input = "//;\n1;-2";
        assertThatExceptionOfType(NegativeNumberException.class)
                .isThrownBy(() -> {
                    calculator.add(input);
                }).withMessageContaining("negatives not allowed");
    }

    @Test
    void addNegativeNumbersInExceptionMessage() {
        String input = "//;\n-1;-2";
        assertThatExceptionOfType(NegativeNumberException.class)
                .isThrownBy(() -> {
                    calculator.add(input);
                }).withMessage("negatives not allowed[-1, -2]");
    }

    @Test
    void getCalledCount() throws NegativeNumberException {
        int expected = 3;
        StringCalculator countCheck = new StringCalculator();
        for (int i=0;i<expected;i++)
            countCheck.add("");

        assertThat(countCheck.getCalledCount()).isEqualTo(expected);
    }
}
