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
}
