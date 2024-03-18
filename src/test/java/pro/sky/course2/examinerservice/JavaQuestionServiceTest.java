package pro.sky.course2.examinerservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.course2.examinerservice.domain.Question;
import pro.sky.course2.examinerservice.service.JavaQuestionService;
import pro.sky.course2.examinerservice.service.QuestionService;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {
    private QuestionService questionService;
    private Question question;

    @BeforeEach
    void setUp() {
        questionService = new JavaQuestionService();
        question = new Question("What is Java?", "A programming language.");
    }

    @Test
    void addQuestionAndRetrieve() {
        questionService.add(question);
        Collection<Question> questions = questionService.getAll();
        assertNotNull(questions);
        assertTrue(questions.contains(question));
    }

    @Test
    void removeQuestionAndVerify() {
        questionService.add(question);
        boolean result = questionService.remove(question);
        assertTrue(result);
        Collection<Question> questions = questionService.getAll();
        assertFalse(questions.contains(question));
    }
}
