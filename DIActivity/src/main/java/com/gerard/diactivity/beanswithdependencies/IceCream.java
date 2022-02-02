package com.gerard.diactivity.beanswithdependencies;

import com.gerard.diactivity.dependencies.Topping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Example of Setter Injection

@Component
public class IceCream {

    @Autowired
    Topping topping;

    IceCream() {
    }

    public Topping getTopping() {
        return topping;
    }

    @Override
    public String toString() {
        return "IceCream{" +
                "topping=" + topping +
                '}';
    }
}