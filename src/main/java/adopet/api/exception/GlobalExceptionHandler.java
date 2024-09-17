package adopet.api.exception;

import adopet.api.exception.dto.ResponseErrorDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AdocaoException.class)
    public ResponseEntity<ResponseErrorDTO> handleAdocaoException(final AdocaoException e) {
        ResponseErrorDTO error = new ResponseErrorDTO(e.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseErrorDTO> handleEntityNotFoundException(final EntityNotFoundException e) {
        ResponseErrorDTO error = new ResponseErrorDTO(e.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
