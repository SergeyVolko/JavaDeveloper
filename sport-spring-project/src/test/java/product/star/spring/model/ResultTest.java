package product.star.spring.model;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    void hasGenderIsTrue() {
        Person person = new Person("Petr", Gender.MALE);
        String timeString = "PT30M30S";
        Result result = new Result(person, Distance.FIVE_KM, Duration.parse(timeString));
        assertTrue(result.hasGender(Gender.MALE));
    }

    @Test
    void hasGenderIsFalse() {
        Person person = new Person("Petr", Gender.MALE);
        String timeString = "PT30M30S";
        Result result = new Result(person, Distance.FIVE_KM, Duration.parse(timeString));
        assertFalse(result.hasGender(Gender.FEMALE));
    }

    @Test
    void hasDistanceTrue() {
        Person person = new Person("Petr", Gender.MALE);
        String timeString = "PT30M30S";
        Result result = new Result(person, Distance.FIVE_KM, Duration.parse(timeString));
        assertTrue(result.hasDistance(Distance.FIVE_KM));
    }

    @Test
    void hasDistanceFalse() {
        Person person = new Person("Petr", Gender.MALE);
        String timeString = "PT30M30S";
        Result result = new Result(person, Distance.FIVE_KM, Duration.parse(timeString));
        assertFalse(result.hasDistance(Distance.TEN_KM));
    }
}