package org.example.warehouse;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BasicAnalytics implements Analytics {

    private final Storage storage;

    public BasicAnalytics(Storage storage) {
        this.storage = storage;
    }

    @Override
    public Set<String> getCategories() {
        return storage.getAllItems().values().stream()
                .map(Wheel::category)
                .collect(Collectors.toSet());
    }

    @Override
    public Map<CategoryAndPlace, Integer> getAggregationByCategoryAndPlace() {
        return storage.getAllItems().values().stream()
                .collect(Collectors.groupingBy((wheel -> new CategoryAndPlace(wheel.category(), wheel.place())),
                        Collectors.summingInt(Wheel::quantity)));
    }

    @Override
    public Integer getAggregationByCategoryAndPlace(CategoryAndPlace categoryAndPlace) {
        return storage.getAllItems().values().stream()
                .filter(wheel -> categoryAndPlace.category().equals(wheel.category())
                        && categoryAndPlace.place().equals(wheel.place()))
                .mapToInt(Wheel::quantity)
                .sum();
    }

    @Override
    public Integer getTotalCount() {
        return storage.getAllItems().values().stream()
                .map(Wheel::quantity)
                .mapToInt(i -> i)
                .sum();
    }
}
