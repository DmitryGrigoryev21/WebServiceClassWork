package com.gerard.diactivity.beanswithdependencies;

import com.gerard.diactivity.dependencies.Flavor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Example of Constructor Injection

@Component
public class Cake {

    Flavor flavor;

    Cake(Flavor flavor) {
        this.flavor = flavor;
    }

    public Flavor getFlavor() {
        return flavor;
    }

    @Override
    public String toString() {
        return "Cake{" +
                "flavor=" + flavor +
                '}';
    }
}