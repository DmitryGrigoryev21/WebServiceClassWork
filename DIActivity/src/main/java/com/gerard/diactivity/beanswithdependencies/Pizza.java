package com.gerard.diactivity.beanswithdependencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Example of Constructor Injection

@Component
public class Pizza {

    Dough dough;

    Pizza(Dough dough) {
        this.dough = dough;
    }

    public Dough getDough() {
        return dough;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "dough=" + dough +
                '}';
    }
}