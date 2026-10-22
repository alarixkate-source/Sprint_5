package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalGetFoodParameterizedTest {

    private static Stream<Arguments> provideFoodData() {
        return Stream.of(
                Arguments.of("Травоядное", List.of("Трава", "Различные растения")),
                Arguments.of("Хищник", List.of("Животные", "Птицы", "Рыба"))
        );
    }

    @ParameterizedTest
    @MethodSource("provideFoodData")
    void getFoodReturnsCorrectListForValidKind(String animalKind, List<String> expectedFood) throws Exception {
        Animal animal = new Animal();
        List<String> actualFood = animal.getFood(animalKind);
        assertEquals(expectedFood, actualFood);
    }
}