package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    @Test
    void getFamilyReturnsCorrectString() {
        Animal animal = new Animal();
        String family = animal.getFamily();
        assertNotNull(family);
        assertTrue(family.contains("кошачьи"));
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", family);
    }

    @Test
    void getFoodThrowsExceptionForUnknownKind() {
        Animal animal = new Animal();
        assertThrows(Exception.class, () -> animal.getFood("Рыба"));
    }
}