package pro.sky.course2.examinerservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pro.sky.course2.examinerservice.domain.Question;
import pro.sky.course2.examinerservice.service.ExaminerService;
import pro.sky.course2.examinerservice.service.ExaminerServiceImpl;
import pro.sky.course2.examinerservice.exception.NotEnoughQuestionsException;
import pro.sky.course2.examinerservice.service.QuestionService;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.HashSet;



public class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionService;

    private ExaminerService examinerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        examinerService = new ExaminerServiceImpl(questionService);
    }

    @Test
    void getQuestions_withSufficientQuestions() {

        given(questionService.getAll()).willReturn(generateMockQuestions(10));
        when(questionService.getRandomQuestion()).thenReturn(
                new Question("Q1", "A1"),
                new Question("Q2", "A2"),
                new Question("Q3", "A3"),
                new Question("Q4", "A4"),
                new Question("Q5", "A5")
        );

        Collection<Question> questions = examinerService.getQuestions(5);
        assertNotNull(questions);
        assertEquals(5, questions.size());
    }

    @Test
    void getQuestions_withInsufficientQuestions() {
        given(questionService.getAll()).willReturn(generateMockQuestions(3));

        assertThrows(NotEnoughQuestionsException.class, () -> examinerService.getQuestions(5));
    }

    private Collection<Question> generateMockQuestions(int amount) {
        HashSet<Question> questions = new HashSet<>();
        for (int i = 1; i <= amount; i++) {
            questions.add(new Question("Q" + i, "A" + i));
        }
        return questions;
    }
}
