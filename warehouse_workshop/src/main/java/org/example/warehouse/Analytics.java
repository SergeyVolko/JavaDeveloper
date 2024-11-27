package org.example.warehouse;

import java.util.Map;
import java.util.Set;

/**
 * - [ ] Создание отчета по остаткам товаров на складе
 *     - [ ] Вывод всех категорий товаров
 *     - [ ] Вывод количества товаров по категории и месту хранения
 *     - [ ] Вывод общего количества товаров на складе
 */
public interface Analytics {
    Set<String> getCategories();

    Map<CategoryAndPlace, Integer> getAggregationByCategoryAndPlace();

    Integer getAggregationByCategoryAndPlace(CategoryAndPlace categoryAndPlace);

    Integer getTotalCount();
}
