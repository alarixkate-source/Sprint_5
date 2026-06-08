package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class LionConstructorParameterizedTest {

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    void lionConstructorSetsHasManeCorrectly(String sex, boolean expectedMane) throws Exception {
        Feline mockFeline = mock(Feline.class);
        Lion lion = new Lion(sex, mockFeline);

        assertNotNull(lion);


        assertEquals(expectedMane, lion.doesHaveMane());
    }


    @ParameterizedTest
    @CsvSource({
            "Неизвестно, Неизвестный пол",
            "Другой, Недопустимый пол"
    })
    void constructorThrowsExceptionForInvalidSex(String invalidSex, String message) {
        Feline mockFeline = mock(Feline.class);
        assertThrows(Exception.class, () -> new Lion(invalidSex, mockFeline), message);
    }
}