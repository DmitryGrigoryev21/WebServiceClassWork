package com.gerard.diactivity.dependencies;

import org.springframework.stereotype.Component;

@Component
public class Topping {

    String toppingType = "sprinkles";

    public String getToppingType() {
        return toppingType;
    }

    @Override
    public String toString() {
        return "Topping{" +
            "toppingType='" + toppingType + '\'' +
            '}';
    }
}
