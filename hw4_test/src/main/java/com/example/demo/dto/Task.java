package com.example.demo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String desc;
    String title;

    public Task(String desc, String title) {
        this.desc = desc;
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public String getTitle() {
        return title;
    }
}


