package pro.sky.course2.examinerservice.controller;
import org.springframework.web.bind.annotation.*;
import pro.sky.course2.examinerservice.domain.Question;
import pro.sky.course2.examinerservice.service.QuestionService;
import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaController {
    private final QuestionService questionService;

    public JavaController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return questionService.add(question, answer);
    }

    @DeleteMapping("/remove")
    public boolean removeQuestion(@RequestParam String question, @RequestParam String answer) {
        Question q = new Question(question, answer);
        return questionService.remove(q);
    }

    @GetMapping
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }
    
}
