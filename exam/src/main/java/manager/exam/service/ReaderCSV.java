package manager.exam.service;
import manager.exam.model.Question;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ReaderCSV {

    private final QuestionParser questionParser;

    public ReaderCSV(QuestionParser questionParser) {
        this.questionParser = questionParser;
    }

    public Set<Question> readFromFile(Path filePath) {
        try {
            return Files.lines(filePath)
                    .map(questionParser::textToParseQuestion)
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
