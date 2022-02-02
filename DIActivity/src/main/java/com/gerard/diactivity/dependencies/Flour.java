package com.gerard.diactivity.dependencies;

import org.springframework.stereotype.Component;

@Component
public class Flour {

    String flourType = "wheat";

    public String getFlourType() {
        return flourType;
    }

    @Override
    public String toString() {
        return "Flour{" +
            "flourType='" + flourType + '\'' +
            '}';
    }
}
