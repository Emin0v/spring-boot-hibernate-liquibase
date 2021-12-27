package com.company.exception.handler;


import com.company.exception.NotFoundException;
import com.company.exception.model.ExceptionResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ExceptionResponse handle(NotFoundException ex, WebRequest request){
        return handleException(request,HttpStatus.NOT_FOUND, ex.getMessage());
    }

    private ExceptionResponse handleException(WebRequest request, HttpStatus status, String message){
        return ExceptionResponse.builder()
                .timeStamp(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME))
                .error(status.getReasonPhrase())
                .message(message)
                .path(((ServletWebRequest)request).getRequest().getRequestURI())
                .build();
    }

}
