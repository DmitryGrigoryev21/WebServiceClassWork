package com.gerard.diactivity.beanswithdependencies;

import com.gerard.diactivity.dependencies.Flour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Example of Constructor Injection

@Component
public class Dough {

    Flour flour;

    Dough(Flour flour) {
        this.flour = flour;
    }

    public Flour getFlour() {
        return flour;
    }

    @Override
    public String toString() {
        return "Dough{" +
                "flour=" + flour +
                '}';
    }
}