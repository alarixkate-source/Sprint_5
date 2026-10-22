package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CatTest {

    @Mock
    private Feline mockFeline;

    private Cat cat;

    @BeforeEach
    void setUp() {
        cat = new Cat(mockFeline);
    }

    @Test
    void getSoundReturnsMeow() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void getFoodReturnsWhatPredatorEatMeatReturns() throws Exception {
        List<String> expectedFood = List.of("Мясо", "Рыба");
        when(mockFeline.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();

        assertEquals(expectedFood, actualFood);
        verify(mockFeline).eatMeat(); // times(1) можно опустить
    }

    @Test
    void getFoodThrowsExceptionWhenEatMeatThrows() throws Exception {
        when(mockFeline.eatMeat()).thenThrow(new Exception("Ошибка"));

        assertThrows(
                Exception.class,
                () -> cat.getFood(),
                "Метод getFood должен пробрасывать исключение от Predator"
        );
    }
}