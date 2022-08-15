package com.singh.tenancy.exception;

import com.singh.tenancy.dto.ExceptionResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    private static ResponseEntity<ExceptionResponseDto> getResponseEntity(String ex, HttpStatus notFound) {
        ExceptionResponseDto responseDto = ExceptionResponseDto.builder()
                .message(ex).build();
        return new ResponseEntity<>(responseDto, notFound);
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleNoDataFoundException(
            NoDataFoundException ex, WebRequest request) {
        return getResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    private ResponseEntity<ExceptionResponseDto> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex) {
        return getResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<ExceptionResponseDto> handleAllException(Exception ex) {
        return getResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
