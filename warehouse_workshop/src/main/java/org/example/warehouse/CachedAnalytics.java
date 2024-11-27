package org.example.warehouse;

import java.util.Map;
import java.util.Set;

public class CachedAnalytics implements Analytics {

    private final Map<CategoryAndPlace, Integer> cache = new LRUCache<>(2);
    private Analytics analytics;

    public CachedAnalytics(Analytics analytics) {
        this.analytics = analytics;
    }

    @Override
    public Set<String> getCategories() {
        return analytics.getCategories();
    }

    @Override
    public Map<CategoryAndPlace, Integer> getAggregationByCategoryAndPlace() {
        return analytics.getAggregationByCategoryAndPlace();
    }

    @Override
    public Integer getAggregationByCategoryAndPlace(CategoryAndPlace categoryAndPlace) {
        return cache.computeIfAbsent(categoryAndPlace, analytics::getAggregationByCategoryAndPlace);
    }

    @Override
    public Integer getTotalCount() {
        return analytics.getTotalCount();
    }
}
