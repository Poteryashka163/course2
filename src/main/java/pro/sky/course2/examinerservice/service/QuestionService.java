package pro.sky.course2.examinerservice.service;
import pro.sky.course2.examinerservice.domain.Question;
import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);
    Question add(Question question);
    boolean remove(Question question);
    Collection<Question> getAll();
    Question getRandomQuestion();
}

