package com.ilovenews.News.repository;

import com.ilovenews.News.module.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News,Integer> {
    List<News> findByTitleContainingIgnoreCase(String title);
}
