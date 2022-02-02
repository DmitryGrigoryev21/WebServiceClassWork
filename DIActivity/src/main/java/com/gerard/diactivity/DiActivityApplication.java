package com.gerard.diactivity;

import com.gerard.diactivity.beanswithdependencies.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.gerard.diactivity.entities.Movie;
import com.gerard.diactivity.controllers.MovieLister;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class DiActivityApplication {

    public static void main(String[] args) {

//        ApplicationContext context = SpringApplication.run(DiActivityApplication.class, args);
//
//        Dough dough = context.getBean(Dough.class);
//        Cake cake = context.getBean(Cake.class);
//        Sandwich sandwich = context.getBean(Sandwich.class);
//        Cookie cookie = context.getBean(Cookie.class);
//        IceCream iceCream = context.getBean(IceCream.class);
//        Pizza pizza = context.getBean(Pizza.class);
//
//        System.out.println("Dough Constructor Injection of Flour: " + dough.toString());
//        System.out.println("Cake Constructor Injection of Flavor: " + cake.toString());
//        System.out.println("Sandwich Constructor Injection of Meat & Bread: " + sandwich.toString());
//        System.out.println("Cookie Setter Injection of Flavor: " + cookie.toString());
//        System.out.println("IceCream Field Injection of Topping: " + iceCream.toString());
//        System.out.println("Pizza Constructor Injection of Dough: " + pizza.toString());

        ApplicationContext context = SpringApplication.run(DiActivityApplication.class, args);
//        MovieLister lister = context.getBean(MovieLister.class);
//        List<Movie> movies = lister.listMoviesDirectedBy("Steven Spielberg");


//        for(Movie movie : movies){
//            System.out.println(movie.getTitle());
//        }
    }
}

