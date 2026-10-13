package com.ilovenews.News.controller;

import com.ilovenews.News.globalexception.custome.NewsNotFoundException;
import com.ilovenews.News.module.News;
import com.ilovenews.News.service.NewsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class NewsControllerAdmin {
    private final NewsService service;

    @PostMapping("/insert")
    public ResponseEntity<String> added(@RequestBody @Valid News news) {
        service.addNews(news);
        return new ResponseEntity<>("Added", HttpStatus.CREATED);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> delete(@RequestHeader int id) {
        boolean isDeleted = service.deleteNews(id);
        if (isDeleted) {
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }
        throw new NewsNotFoundException();
    }

    @PutMapping("/update")
    public ResponseEntity<String> updated(@RequestBody @Valid News news,@RequestHeader int id) {
        boolean isUpdated = service.updateNews(news,id);
        if (isUpdated) {
            return new ResponseEntity<>("News Updated",HttpStatus.OK);
        }
        throw new NewsNotFoundException();
    }
}
