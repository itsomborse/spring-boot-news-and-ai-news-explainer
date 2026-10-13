package com.ilovenews.News.globalexception.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExceptionFormat {
    private String message;
    private String status;
    private int value;
    private LocalDateTime time;
}
