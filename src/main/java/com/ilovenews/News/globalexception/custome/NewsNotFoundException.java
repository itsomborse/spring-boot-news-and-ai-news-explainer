package com.ilovenews.News.globalexception.custome;

public class NewsNotFoundException extends RuntimeException {
    public NewsNotFoundException() {
        super("News Not Found");
    }
}
