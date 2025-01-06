package product.star.spring.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenderTest {

    @Test
    void ofM() {
        Gender expect = Gender.MALE;
        Gender actual = Gender.of("M");
        assertEquals(expect, actual);
    }

    @Test
    void wrongParameter() {
        String code = "B";
        String message = "Unknown gender: " + code;
        IllegalArgumentException exceptionGender = assertThrows(IllegalArgumentException.class,  () -> Gender.of(code));
        assertEquals(message, exceptionGender.getMessage());
    }
}