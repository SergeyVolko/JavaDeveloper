package org.example.students;

import static org.junit.jupiter.api.Assertions.*;

import org.example.students.exception.ScoreNotFoundException;
import org.example.students.records.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

public class ExaminationTest {

    private Examination examination;

    @BeforeEach
    public void init() {
        this.examination = new ScoreStorage();
    }

    @Test
    public void whenAddThreeStoreThenTwoSizeAndLastValuesAdding() {
        Score math = new Score("Petr", "math", 3);
        Score math2 = new Score("Petr", "math", 4);
        examination.addScore(math);
        examination.addScore(math2);
        List<Score> expected = List.of(math2);
        assertIterableEquals(expected, examination.getAllScores());
    }

    @Test
    public void whenMultipleSubmissionStudentsThenNames() {
        Score math = new Score("Petr", "math", 3);
        Score math2 = new Score("Petr", "math", 4);
        Score math3 = new Score("Ivan", "math", 3);

        List<Score> scores = List.of(math, math2, math3);
        examination.putAllScores(scores);
        Set<String> expectsNames = Set.of(math2.name());
        assertEquals(expectsNames, examination.multipleSubmissionsStudentNames());
    }

    @Test
    public void whenGetAverageForSubjectFiveStudent() {
        Score math = new Score("Petr", "math", 3);
        Score math2 = new Score("Petr", "math", 4);
        Score math3 = new Score("Ivan", "math", 5);
        Score math4 = new Score("Igor", "math", 2);
        Score math5 = new Score("John", "math", 1);
        List<Score> scores = List.of(math, math2, math3, math4, math5);
        examination.putAllScores(scores);
        double epsilon = 0.00001;
        double expect = 3.0;
        assertEquals(expect, examination.getAverageForSubject("math"), epsilon);
    }

    @Test
    public void whenAddingTwoScoreThenGetScoreWithValueIs4() throws ScoreNotFoundException {
        Score math = new Score("Petr", "math", 3);
        Score math2 = new Score("Petr", "math", 4);
        List<Score> scores = List.of(math, math2);
        examination.putAllScores(scores);
        assertEquals(math2, examination.getScore("Petr", "math"));
    }

    @Test
    public void lastFiveStudentsWithExcellentMarkOnAnySubjectGetTwoStudent1() {
        Score math = new Score("Petr", "math", 3);
        Score math2 = new Score("Petr", "math", 4);
        Score math3 = new Score("Ivan", "math", 5);
        Score math4 = new Score("Igor", "math", 2);
        Score math5 = new Score("John", "math", 1);
        Score language = new Score("Petr", "language", 3);
        Score language2 = new Score("Petr", "language", 5);
        Score language3 = new Score("Ivan", "language", 5);
        Score language4 = new Score("Igor", "language", 2);
        Score language5 = new Score("John", "language", 1);
        List<Score> scores = List.of(math, math2, math3, math4, math5,
                language, language2, language3, language4, language5);
        examination.putAllScores(scores);
        List<String> expectsNames = List.of("Petr", "Ivan");
        assertTrue(compareLinkedHashSetWithOrder(expectsNames,
                examination.lastFiveStudentsWithExcellentMarkOnAnySubject()));
    }

    @Test
    public void lastFiveStudentsWithExcellentMarkOnAnySubjectGetFiveStudent() {
        Score math = new Score("Ivan", "math", 5);
        Score math2 = new Score("Andrew", "math", 5);
        Score math3 = new Score("Denis", "math", 5);
        Score math4 = new Score("Igor", "math", 5);
        Score math5 = new Score("John", "math", 5);
        Score language = new Score("Petr", "language", 3);
        Score language2 = new Score("Petr", "language", 5);
        Score language3 = new Score("Ivan", "language", 5);
        Score language4 = new Score("Igor", "language", 2);
        Score language5 = new Score("John", "language", 1);
        List<Score> scores = List.of(math, math2, math3, math4, math5,
                language, language2, language3, language4, language5);
        examination.putAllScores(scores);
        List<String> expectsNames = List.of("Denis", "Igor", "John", "Petr", "Ivan");
        assertTrue(compareLinkedHashSetWithOrder(expectsNames,
                examination.lastFiveStudentsWithExcellentMarkOnAnySubject()));
    }

    @Test
    public void lastFiveStudentsWithExcellentMarkOnAnySubjectGetTwoStudent() {
        Score math = new Score("Ivan", "math", 5);
        Score language = new Score("Petr", "language", 3);
        Score language2 = new Score("Petr", "language", 5);
        Score language3 = new Score("Ivan", "language", 5);
        List<Score> scores = List.of(math, language, language2, language3);
        examination.putAllScores(scores);
        List<String> expectsNames = List.of("Petr", "Ivan");
        assertTrue(compareLinkedHashSetWithOrder(expectsNames,
                examination.lastFiveStudentsWithExcellentMarkOnAnySubject()));
    }

    @Test
    public void lastFiveStudentsWithExcellentMarkOnAnySubjectGetOneStudent() {
        Score math = new Score("Ivan", "math", 5);
        Score language = new Score("Petr", "language", 3);
        Score language2 = new Score("Petr", "language", 5);
        Score language3 = new Score("Ivan", "language", 5);
        List<Score> scores = List.of(math, language, language2, language3);
        examination.putAllScores(scores);
        List<String> expectsNames = List.of("Petr", "Ivan");
        assertTrue(compareLinkedHashSetWithOrder(expectsNames,
                examination.lastFiveStudentsWithExcellentMarkOnAnySubject()));
    }

    @Test
    public void whenAddingTwoScoreThenGetException() throws ScoreNotFoundException {
        Score math = new Score("Petr", "math", 3);
        Score math2 = new Score("Petr", "math", 4);
        List<Score> scores = List.of(math, math2);
        examination.putAllScores(scores);
        assertThrows(ScoreNotFoundException.class, () -> examination.getScore("Ivan", "math"));
    }

    private boolean compareLinkedHashSetWithOrder(List<String> list1, Set<String> set2) {
        List<String> list2 = set2.stream().toList();
        return list1.equals(list2);
    }
}
