package pro.sky.course2.examinerservice.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotEnoughQuestionsException extends ResponseStatusException {
    public NotEnoughQuestionsException(String reason) {
        super(HttpStatus.BAD_REQUEST, reason);
    }
}
