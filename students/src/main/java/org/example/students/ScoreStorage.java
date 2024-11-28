package org.example.students;

import org.example.students.exception.ScoreNotFoundException;
import org.example.students.records.Score;
import org.example.students.records.ScoreAndPasseCount;
import org.example.students.records.StudentAndSubject;
import java.util.*;
import java.util.stream.Collectors;

public class ScoreStorage implements Examination {

    private final Map<StudentAndSubject, ScoreAndPasseCount> scores;
    private final Map<String, Double> cache;

    public ScoreStorage() {
        this.scores = new LinkedHashMap<>();
        this.cache = new LRUCache<>(2);
    }

    @Override
    public void addScore(Score score) {
        StudentAndSubject studentAndSubject = new StudentAndSubject(score.name(), score.subject());
        ScoreAndPasseCount scoreAndPasseCount = scores.remove(studentAndSubject);
        if (scoreAndPasseCount == null) {
            scores.put(studentAndSubject, new ScoreAndPasseCount(score.score(), 1));
        } else {
            scores.put(studentAndSubject,
                    new ScoreAndPasseCount(score.score(), scoreAndPasseCount.passeCount() + 1));
        }
    }

    @Override
    public Score getScore(String name, String subject) throws ScoreNotFoundException {
        StudentAndSubject studentAndSubject = new StudentAndSubject(name, subject);
        ScoreAndPasseCount scoreAndPasseCount = scores.get(studentAndSubject);
        if (scoreAndPasseCount == null) {
            throw new ScoreNotFoundException(studentAndSubject.toString());
        }
        return new Score(name, subject, scoreAndPasseCount.score());
    }

    @Override
    public double getAverageForSubject(String subject) {
        return cache.computeIfAbsent(subject, this::calculateAverageForSubject);
    }

    @Override
    public Set<String> multipleSubmissionsStudentNames() {
        return scores.entrySet().stream()
                .filter(e -> e.getValue().passeCount() > 1)
                .map(e -> e.getKey().name())
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject() {
        int maxScore = 5;
        int maxStudents = 5;
        List<String> students = scores.entrySet().stream()
                .filter(e -> e.getValue().score() == maxScore)
                .map(e -> e.getKey().name())
                .toList();
        if (students.isEmpty()) {
            return Set.of();
        }
        Set<String> result = new LinkedHashSet<>();
        students.stream()
                .skip(Math.max(0,  students.size() - maxStudents))
                .forEach(e -> {
                    result.remove(e);
                    result.add(e);
                });
        return result;
    }

    @Override
    public Collection<Score> getAllScores() {
        return scores.entrySet().stream()
                .map(e -> new Score(e.getKey().name(), e.getKey().subject(), e.getValue().score()))
                .collect(Collectors.toList());
    }

    @Override
    public void putAllScores(List<Score> scores) {
        scores.forEach(this::addScore);
    }

    private double calculateAverageForSubject(String subject) {
        return scores.entrySet().stream()
                .filter(e -> subject.equals(e.getKey().subject()))
                .mapToDouble(e -> e.getValue().score())
                .average()
                .orElse(0.0);
    }
}
