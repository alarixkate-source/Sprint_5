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
class LionTest {

    @Mock
    private Feline mockFeline;

    private Lion lion;

    @BeforeEach
    void setUp() {
        try {
            lion = new Lion("Самец", mockFeline);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void lionConstructorThrowsExceptionForInvalidSex() {
        assertThrows(
                Exception.class,
                () -> new Lion("Неизвестно", mockFeline),
                "Конструктор должен кидать исключение для некорректного пола"
        );
    }


    @Test
    void getKittensReturnsValueFromFeline() throws Exception { // <-- ДОБАВЛЕНО throws Exception
        when(mockFeline.getKittens()).thenReturn(5);
        int kittensCount = lion.getKittens();
        assertEquals(5, kittensCount);
        verify(mockFeline).getKittens();
    }

    @Test
    void getFoodReturnsValueFromFeline() throws Exception { // <-- ДОБАВЛЕНО throws Exception
        List<String> expectedFood = List.of("Мясо", "Рыба");
        when(mockFeline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
        verify(mockFeline).getFood("Хищник");
    }


    @Test
    void constructorWithMaleSetsHasManeToTrue() throws Exception {
        Lion maleLion = new Lion("Самец", mockFeline);
        assertTrue(maleLion.doesHaveMane());
    }

    @Test
    void constructorWithFemaleSetsHasManeToFalse() throws Exception {
        Lion femaleLion = new Lion("Самка", mockFeline);
        assertFalse(femaleLion.doesHaveMane());
    }
}