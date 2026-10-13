package com.ilovenews.News.controller;

import com.ilovenews.News.module.News;
import com.ilovenews.News.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/news")
public class NewsControllerPublic {
    private final NewsService service;

    @GetMapping("/")
    public ResponseEntity<List<News>> allNews() {
        return new ResponseEntity<>(service.allNews(), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<News>> titleNews(@RequestParam String title) {
        return new ResponseEntity<>(service.titleNews(title),HttpStatus.OK);
    }
}
