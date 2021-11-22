package day01;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class HumanTest {
    Human human = new Human("Kis Béla", 1993);

    @Test
    void setUp1() {
        Human human1 = new Human("Alma Málna", 2020);
    }

    @Test
    void setUp2() {
        Human human2 = new Human("Kandúr Bandi", 1900);
    }

    @Test
    void isYearValidTest() {
        boolean result = human.isYearOfBirthValid(1993);
        assertTrue(result);
    }

    @Test
    void isYearInValidTest() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> human.isYearOfBirthValid(1900));
        assertEquals("Invalid year!", iae.getMessage());
    }

    @Test
    void isNameValidTest() {
        boolean result = human.isNameValid("Kis Béla");
        assertTrue(result);
    }

    @Test
    void isNameValidNullTest() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> human.isNameValid(null));
        assertEquals("Invalid name!", iae.getMessage());
    }
}
