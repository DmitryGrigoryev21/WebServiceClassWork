package com.gerard.diactivity.dependencies;

import org.springframework.stereotype.Component;

@Component
public class Flavor {

    String flavorType = "chocolate";
    String color = "brown";

    public String getFlavorType() {
        return flavorType;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Flavor{" +
            "flavorType='" + flavorType + '\'' +
            ", color='" + color + '\'' +
            '}';
    }
}