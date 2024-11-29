package org.db.students;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudentStorage {
    private final Map<Long, Student> studentStorageMap = new HashMap<>();
    private final StudentSurnameStorage studentSurnameStorage = new StudentSurnameStorage();
    private Long currentId = 0L;

    /**
     * Создание данных о студенте
     * @param student данные о студенте
     * @return сгенерированный уникальный идентификатор студента
     */
    public Long createStudent(Student student) {
        Long nextId = getNextId();
        studentStorageMap.put(nextId, student);
        studentSurnameStorage.studentCreate(nextId, student.getSurname());
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
        String newSurname = student.getSurname();
        String oldSurname = studentStorageMap.get(id).getSurname();
        studentSurnameStorage.studentUpdate(id, oldSurname, newSurname);
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
        if (removed != null) {
            String surname = removed.getSurname();
            studentSurnameStorage.studentDeleted(id, surname);
        }
        return removed != null;
    }

    public void search(String surname) {
        studentSurnameStorage.getStudentSurnamesLessOrEqualThan(surname)
                .forEach(id -> System.out.println(studentStorageMap.get(id)));
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
        return getCountByFunctionParameter(Student::getCourse);
    }

    public Map<String, Long> getCountByCity() {
        return getCountByFunctionParameter(Student::getCity);
    }

    private Map<String, Long> getCountByFunctionParameter(Function<Student, String> function) {
        return studentStorageMap.values().stream()
                .collect(Collectors.toMap(
                        function,
                        v -> 1L,
                        Long::sum
                ));
    }
}

