package com.ilovenews.News.globalexception;


import com.ilovenews.News.globalexception.custome.NewsNotFoundException;
import com.ilovenews.News.globalexception.dto.ExceptionFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;

@Component
public class globalExceptiion {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HashMap<String,String>> hashMapResponseEntity(MethodArgumentNotValidException e) {
        HashMap<String,String> hashMap = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(each -> {
            String field_name = ((FieldError) each).getField();
            String message = each.getDefaultMessage();
            hashMap.put(field_name,message);
        });
        return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NewsNotFoundException.class)
    private ResponseEntity<ExceptionFormat> handler(NewsNotFoundException e) {
        ExceptionFormat exceptionFormat = new ExceptionFormat(
                e.getLocalizedMessage(),HttpStatus.BAD_REQUEST.toString(),HttpStatus.BAD_REQUEST.value(), LocalDateTime.now()
        );
        return new ResponseEntity<>(exceptionFormat,HttpStatus.BAD_REQUEST);
    }
}
