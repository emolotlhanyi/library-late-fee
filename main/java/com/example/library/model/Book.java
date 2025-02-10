package main.java.com.example.library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class Book {
    private String title;
    private boolean isLost;
}