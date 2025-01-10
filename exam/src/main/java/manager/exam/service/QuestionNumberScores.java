package manager.exam.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class QuestionNumberScores {
    @Value("#{'${group}'.split(',')}")
    private List<String> groupScores;
    private Map<Integer, Integer> scoresNumbers;

    private void init() {
        scoresNumbers = new HashMap<>();
        for (String group : groupScores) {
            String[] token = group.split(":");
            String[] tokenQuestion  = token[0].split("-");
            int first = Integer.parseInt(tokenQuestion[0]);
            int last = Integer.parseInt(tokenQuestion[1]);
            for (int i = first; i <= last; i++) {
                scoresNumbers.put(i, Integer.parseInt(token[1]));
            }
        }
    }

    public int getScore(int numberQuestion) {
        return  scoresNumbers.getOrDefault(numberQuestion, 0);
    }


    @PostConstruct
    void printGroup() {
       init();
    }

}
