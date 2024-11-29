package org.db.students;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentStorage {
    private final Map<Long, Student> studentStorageMap = new HashMap<>();
    private Long currentId = 0L;

    /**
     * Создание данных о студенте
     * @param student данные о студенте
     * @return сгенерированный уникальный идентификатор студента
     */
    public Long createStudent(Student student) {
        Long nextId = getNextId();
        studentStorageMap.put(nextId, student);
        return nextId;
    }

    /**
     * Обновление данных о студенте
     * @param id идентификатор студента
     * @param student данные студента
     * @return true, если данные были обновлены, false, если студент не был найден
     */
    public boolean updateStudent(Long id, Student student) {
        if (!studentStorageMap.containsKey(id)) {
            return false;
        }
        studentStorageMap.put(id, student);
        return true;
    }

    /**
     * Удаляет данные о студенте
     * @param id уникальный идентификатор
     * @return true, если студент был найден,
     * false, если студент не был найден по идентификатору
     */
    public boolean deleteStudent(Long id) {
        Student removed = studentStorageMap.remove(id);
        return removed != null;
    }

    public Long getNextId() {
        return ++currentId;
    }

    public void printAll() {
        System.out.println(studentStorageMap);
    }

    public void printMap(Map<String, Long> data) {
        data.forEach((key, value) -> System.out.println(key + " - " + value));
    }

    public Map<String, Long> getCountByCourse() {
        return studentStorageMap.values().stream()
                .collect(Collectors.toMap(
                        Student::getCourse,
                        v -> 1L,
                        Long::sum
                ));
    }
}

