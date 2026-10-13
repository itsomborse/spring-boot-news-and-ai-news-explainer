package com.ilovenews.News.module;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Audited;

import java.time.LocalDateTime;

@Entity
@Audited.Table(name = "newsdatabase")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class News {
    private int id;
    private String title;
    private String shortDescription;
    private String description;
    private LocalDateTime localDateTime;
}
