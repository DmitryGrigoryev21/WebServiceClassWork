package com.gerard.diactivity.dependencies;

import org.springframework.stereotype.Component;

@Component
public class Bread {

    String breadType = "italian";

    public String getBreadType() {
        return breadType;
    }

    @Override
    public String toString() {
        return "Bread{" +
            "breadType='" + breadType + '\'' +
            '}';
    }
}
