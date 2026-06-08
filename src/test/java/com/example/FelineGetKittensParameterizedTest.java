package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FelineGetKittensParameterizedTest {

    private final Feline feline = new Feline();

    @ParameterizedTest
    @ValueSource(ints = {-5, -1, 0, 1, 5, 10, 100})
    void testGetKittensReturnsInputValue(int inputCount) {
        int result = feline.getKittens(inputCount);
        assertEquals(inputCount, result);
    }
}