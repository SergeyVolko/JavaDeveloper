package org.example.students;

import org.example.students.exception.ScoreNotFoundException;
import org.example.students.records.Score;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class TestAverageCache {

    @Test
    public void whenAddInCacheThenGetCellsCount() {
        MockExamination examination = new MockExamination();
        examination.getAverageForSubject("math");
        examination.getAverageForSubject("language");
        examination.getAverageForSubject("language");
        assertEquals(2, examination.calls);
        List<String> expect = List.of("math", "language");
        List<String> actual = examination.cache.keySet().stream().toList();
        assertEquals(expect, actual);

        examination.getAverageForSubject("Physics");
        assertEquals(3, examination.calls);
        expect = List.of("language", "Physics");
        actual = examination.cache.keySet().stream().toList();
        assertEquals(expect, actual);

        examination.getAverageForSubject("math");
        assertEquals(4, examination.calls);
        expect = List.of("Physics", "math");
        actual = examination.cache.keySet().stream().toList();
        assertEquals(expect, actual);

        examination.getAverageForSubject("language");
        assertEquals(5, examination.calls);
        expect = List.of("math", "language");
        actual = examination.cache.keySet().stream().toList();
        assertEquals(expect, actual);
    }

    private static class MockExamination implements Examination {

        private final Map<String, Double> cache = new LRUCache<>(2);
        private int calls = 0;

        @Override
        public void addScore(Score score) {

        }

        @Override
        public Score getScore(String name, String subject) throws ScoreNotFoundException {
            return null;
        }

        @Override
        public double getAverageForSubject(String subject) {
            Double result = cache.get(subject);
            if (result == null) {
                this.calls++;
                cache.put(subject, 0.0);
            }
            return 0.0;
        }

        @Override
        public Set<String> multipleSubmissionsStudentNames() {
            return Set.of();
        }

        @Override
        public Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject() {
            return Set.of();
        }

        @Override
        public Collection<Score> getAllScores() {
            return List.of();
        }

        @Override
        public void putAllScores(List<Score> scores) {

        }
    }
}
