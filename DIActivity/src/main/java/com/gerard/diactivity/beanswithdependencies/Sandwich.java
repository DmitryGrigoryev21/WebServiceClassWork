package com.gerard.diactivity.beanswithdependencies;

import com.gerard.diactivity.dependencies.Meat;
import com.gerard.diactivity.dependencies.Bread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Example of Constructor Injection

@Component
public class Sandwich {

    Meat meat;
    Bread bread;

    Sandwich(Meat meat) {
        this.meat = meat;
    }

    @Autowired
    Sandwich(Meat meat, Bread bread) {
        this.meat = meat;
        this.bread = bread;
    }

    public Meat getMeat() {
        return meat;
    }

    public Bread getBread() {
        return bread;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "meat=" + meat +
                "bread=" + bread +
                '}';
    }

}