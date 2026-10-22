package com.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FelineTest {

    private final Feline feline = new Feline();

    @Test
    void eatMeatReturnsMeatList() throws Exception {
        List<String> food = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    void getFamilyReturnsFeline() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void getKittensNoArgsReturnsOne() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    void getKittensWithArgReturnsGivenNumber() {
        assertEquals(0, feline.getKittens(0));
        assertEquals(3, feline.getKittens(3));
        assertEquals(5, feline.getKittens(5));
    }
}