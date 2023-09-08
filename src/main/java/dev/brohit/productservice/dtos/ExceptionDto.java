package dev.brohit.productservice.dtos;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@Data
public class ExceptionDto {
    private String message;
    private HttpStatus status;
}
