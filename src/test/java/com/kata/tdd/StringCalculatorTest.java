package com.kata.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class StringCalculatorTest {

    private StringCalculator calculator = new StringCalculator();

    @Test
    void addEmptyString() {
        String empty = "";
        int result = calculator.add(empty);
        assertThat(result).isZero();
    }

    @Test
    void addOneNumber() {
        String oneInput = "1";
        int result = calculator.add(oneInput);
        assertThat(result).isOne();
    }

    @Test
    void addCommaSeparatedNumbers() {
        String commaSeparatedNumbers = "1,2";
        int result = calculator.add(commaSeparatedNumbers);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void addCommaSeparated_N_Numbers() {
        String commaSeparatedNumbers = "1,2,3";
        int result = calculator.add(commaSeparatedNumbers);
        assertThat(result).isEqualTo(6);
    }
}
