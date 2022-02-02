package com.gerard.diactivity.beanswithdependencies;

import com.gerard.diactivity.dependencies.Flavor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Example of Setter Injection

@Component
public class Cookie {

    Flavor flavor;
    @Autowired
    void setFlavor(Flavor flavor){
        this.flavor = flavor;
    }
    Flavor getFlavor() {
        return flavor;
    }

    @Override
    public String toString() {
        return "Cookie{" +
                "flavor=" + flavor +
                '}';
    }
}