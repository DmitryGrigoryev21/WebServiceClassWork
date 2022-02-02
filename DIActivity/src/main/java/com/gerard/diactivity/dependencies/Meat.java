package com.gerard.diactivity.dependencies;

import org.springframework.stereotype.Component;

@Component
public class Meat {

    String meatType = "ham";

    public String getMeatType() {
        return meatType;
    }

    @Override
    public String toString() {
        return "Meat{" +
            "meatType='" + meatType + '\'' +
            '}';
    }
}
