package com.kata.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


class StringCalculatorTest {

    private StringCalculator calculator = new StringCalculator();

    @Test
    void addEmptyString() throws Exception {
        String empty = "";
        int result = calculator.addBasic(empty);
        assertThat(result).isZero();
    }

    @Test
    void addOneNumber() throws Exception {
        String oneInput = "1";
        int result = calculator.addBasic(oneInput);
        assertThat(result).isOne();
    }

    @Test
    void addCommaSeparatedNumbers() throws Exception {
        String commaSeparatedNumbers = "1,2";
        int result = calculator.addBasic(commaSeparatedNumbers);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void addCommaSeparated_N_Numbers() throws Exception {
        String commaSeparatedNumbers = "1,2,3";
        int result = calculator.addBasic(commaSeparatedNumbers);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void addCommaSeparatedOrLine_N_Numbers() throws Exception {
        String commaSeparatedNumbers = "1\n2,3";
        int result = calculator.addBasic(commaSeparatedNumbers);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void addCustomDelimiter() throws Exception {
        String input = "//;\n1;2";
        int result = calculator.add(input);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void addNegativeNumbers() throws Exception {
        String input = "//;\n1;-2";
        assertThatExceptionOfType(Exception.class)
                .isThrownBy(() -> {
                    calculator.add(input);
                }).withMessage("negatives not allowed");
    }
}
