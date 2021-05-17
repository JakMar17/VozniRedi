package team.marela.jpp.backend.jpp_restapi.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import team.marela.jpp.backend.jpp_restapi.exceptions.DataNotFoundException;

@ControllerAdvice
public class ExceptionCatcher {

    @ExceptionHandler(value = {DataNotFoundException.class})
    public ResponseEntity<ExceptionWrapper> handleDataNotFoundException(DataNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionWrapper(exception.getMessage()));
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ExceptionWrapper> handleException(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ExceptionWrapper(exception.getMessage()));
    }
}
