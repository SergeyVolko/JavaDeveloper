package org.example.warehouse;

import org.example.warehouse.exception.ItemNotFoundException;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * # Постановка задачи
 *
 * Реализовать in-memory хранилище для управления остатками товаров на складе.
 *
 * Пользователь один и это "кладовщик"
 *
 * ## Требования
 * - Добавление товара на склад (идентификатор, название, количество, категория, место хранения)
 *     - Добавление списком
 * - Удаление товара со склада
 * - Поиск товара по идентификатору
 *   - Поиск по одному
 *   - Поиск всех названия по списку отсортированный в алфавитном порядке
 * - Вывод всех товаров на складе
 * - Создание отчета по остаткам товаров на складе
 *     - Вывод всех категорий товаров
 *     - Вывод количества товаров по категории и месту хранения
 *     - Вывод общего количества товаров на складе
 */

public interface Storage {
    void putItem(Wheel wheel);

    Wheel getItem(String id) throws ItemNotFoundException;

    boolean containsItem(String id);

    Wheel removeItem(String id) throws ItemNotFoundException;

    void putAllItems(List<Wheel> items);

    Map<String, Wheel> getAllItems();

    List<Wheel> getAllItemsSorted(Predicate<Wheel> predicate);
}
