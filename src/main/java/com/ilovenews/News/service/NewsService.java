package com.ilovenews.News.service;

import com.ilovenews.News.module.News;
import com.ilovenews.News.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsService {
    private final NewsRepository repository;

    public void addNews(News news) {
        repository.save(news);
    }

    public boolean updateNews(News news,int id) {
        News update_news = repository.findById(id).orElse(null);
        if (update_news!=null) {
            update_news.setTitle(news.getTitle());
            update_news.setDescription(news.getDescription());
            update_news.setShortDescription(news.getShortDescription());
            update_news.setPublishedAt(LocalDateTime.now());
            return true;
        }
        return false;
    }

    public List<News> allNews() {
        return repository.findAll();
    }

    public List<News> titleNews(String title) {
        return repository.findByTitleContainingIgnoreCase(title);
    }

    public boolean deleteNews(int id) {
        News delete_news = repository.findById(id).orElse(null);
        if (delete_news==null) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
