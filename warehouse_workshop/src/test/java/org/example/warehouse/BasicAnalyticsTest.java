package org.example.warehouse;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BasicAnalyticsTest {

    private Analytics analytics;
    private Storage storage;

    @BeforeEach
    void setUp() {
        storage = new InMemoryStorage();
        analytics = new BasicAnalytics(storage);
    }

    @Test
    void getCategories() {
        Wheel wheel = new Wheel("1", "hakkapelita", "summer", "A", 5);
        Wheel winter = new Wheel("2", "hakkapelita", "winter", "A", 5);
        Wheel winter2 = new Wheel("21", "nordman", "winter", "B", 5);
        Wheel winter3 = new Wheel("22", "noname", "winter", "A", 5);
        Wheel allSeason = new Wheel("3", "hakkapelita", "allSeason", "A", 5);

        storage.putAllItems(List.of(wheel, winter, winter2, winter3, allSeason));

        Set<String> categories = analytics.getCategories();
        assertEquals(3, categories.size());
        assertTrue(categories.contains("summer"));
        assertTrue(categories.contains("winter"));
        assertTrue(categories.contains("allSeason"));
    }

    @Test
    void getAggregationByCategoryAndPlace() {
        Wheel wheel = new Wheel("1", "hakkapelita", "summer", "A", 5);
        Wheel winter = new Wheel("2", "hakkapelita", "winter", "A", 5);
        Wheel winter2 = new Wheel("21", "nordman", "winter", "B", 5);
        Wheel winter3 = new Wheel("22", "noname", "winter", "A", 5);
        Wheel allSeason = new Wheel("3", "hakkapelita", "allSeason", "A", 5);
        storage.putAllItems(List.of(wheel, winter, winter2, winter3, allSeason));

        Map<CategoryAndPlace, Integer> aggregationByCategoryAndPlace = analytics.getAggregationByCategoryAndPlace();
        assertEquals(10, aggregationByCategoryAndPlace.get(new CategoryAndPlace("winter", "A")));
    }

    @Test
    void getTotalCount() {
        Wheel wheel = new Wheel("1", "hakkapelita", "summer", "A", 5);
        Wheel winter = new Wheel("2", "hakkapelita", "winter", "A", 5);
        Wheel winter2 = new Wheel("21", "nordman", "winter", "B", 5);
        Wheel winter3 = new Wheel("22", "noname", "winter", "A", 5);
        Wheel allSeason = new Wheel("3", "hakkapelita", "allSeason", "A", 5);
        storage.putAllItems(List.of(wheel, winter, winter2, winter3, allSeason));

        Integer totalCount = analytics.getTotalCount();
        assertEquals(25, totalCount);
    }

    @Test
    void getAggregationByCategoryAndPlaceSingleRequest() {
        Wheel wheel = new Wheel("1", "hakkapelita", "summer", "A", 5);
        Wheel winter = new Wheel("2", "hakkapelita", "winter", "A", 5);
        Wheel winter2 = new Wheel("21", "nordman", "winter", "B", 5);
        Wheel winter3 = new Wheel("22", "noname", "winter", "A", 5);
        Wheel allSeason = new Wheel("3", "hakkapelita", "allSeason", "A", 5);
        storage.putAllItems(List.of(wheel, winter, winter2, winter3, allSeason));

        Integer quantity = analytics.getAggregationByCategoryAndPlace(new CategoryAndPlace("winter", "A"));
        assertEquals(10, quantity);
    }
}