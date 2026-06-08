package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AlexTest {

    @Mock
    private Feline mockFeline;

    @Test
    void alexHasMane() throws Exception {
        Alex alex = new Alex(mockFeline);
        assertTrue(alex.doesHaveMane());
    }

    @Test
    void getFriendsReturnsCorrectList() throws Exception {
        Alex alex = new Alex(mockFeline);
        List<String> friends = alex.getFriends();
        assertEquals(List.of("Марти", "Глория", "Мелман"), friends);
    }

    @Test
    void getPlaceOfLivingReturnsNYZoo() throws Exception {
        Alex alex = new Alex(mockFeline);
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    void getKittensReturnsZero() throws Exception {
        Alex alex = new Alex(mockFeline);
        assertEquals(0, alex.getKittens());
    }
}