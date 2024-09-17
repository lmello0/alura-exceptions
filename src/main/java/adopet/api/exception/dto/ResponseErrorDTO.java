package adopet.api.exception.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ResponseErrorDTO(String message, HttpStatus httpStatus, LocalDateTime time) {
}
