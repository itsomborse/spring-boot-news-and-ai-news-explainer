package com.ilovenews.News.module;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "newsdatabase")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class News {
    @Id
    private int id;
    private String title;
    private String shortDescription;
    private String description;
    private LocalDateTime publishedAt;
}
