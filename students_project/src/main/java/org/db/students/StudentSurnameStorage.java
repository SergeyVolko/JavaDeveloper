package org.db.students;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StudentSurnameStorage {
    private final TreeMap<String, Set<Long>> surnamesTreeMap = new TreeMap<>();

    public void studentCreate(Long id, String surname) {
        Set<Long> existingIds = surnamesTreeMap.getOrDefault(surname, new HashSet<>());
        existingIds.add(id);
        surnamesTreeMap.put(surname, existingIds);
    }

    public void studentDeleted(Long id, String surname) {
        surnamesTreeMap.get(surname).remove(id);
    }

    public void studentUpdate(Long id, String oldSurname, String newSurname) {
        studentDeleted(id, oldSurname);
        studentCreate(id, newSurname);
    }

    /**
     * Данный метод возвращает уникальные идентификаторы студентов,
     * чьи фамилии меньше или равны переданной
     * @return set
     */
    public Set<Long> getStudentSurnamesLessOrEqualThan(String surname) {
        return surnamesTreeMap.headMap(surname, true).values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }
}
