package pro.sky.course2.examinerservice.service;
import org.springframework.stereotype.Service;
import pro.sky.course2.examinerservice.domain.Question;
import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public boolean remove(Question question) {
        return questions.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return new ArrayList<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            return null;
        }
        int index = new Random().nextInt(questions.size());
        return (Question) questions.toArray()[index];
    }
}
