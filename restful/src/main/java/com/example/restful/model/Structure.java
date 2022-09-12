package com.example.restful.model;

import java.util.ArrayList;


public class Structure {
    private String status;
    private ArrayList news;
    private int page;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList getNews() {
        return news;
    }

    public void setNews(ArrayList news) {
        this.news = news;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
    
    
}
