package pro.sky.course2.examinerservice.service;
import org.springframework.stereotype.Service;
import pro.sky.course2.examinerservice.domain.Question;
import pro.sky.course2.examinerservice.exception.NotEnoughQuestionsException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;
    private final Random random;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
        this.random = new Random();
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new NotEnoughQuestionsException("Not enough questions in the service to fulfill the request.");
        }

        Set<Question> uniqueQuestions = new HashSet<>();
        while (uniqueQuestions.size() < amount) {
            uniqueQuestions.add(questionService.getRandomQuestion());
        }
        return uniqueQuestions;
    }
}

