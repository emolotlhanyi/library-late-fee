package main.java.com.example.library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class User {
    private String name;
    private UserType userType;
}