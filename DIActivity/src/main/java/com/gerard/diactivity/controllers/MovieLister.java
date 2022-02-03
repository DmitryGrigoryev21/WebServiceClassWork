package com.gerard.diactivity.controllers;

import com.gerard.diactivity.entities.Movie;
import com.gerard.diactivity.services.MovieFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
public class MovieLister {
    @Autowired
    private MovieFinder movieFinder;

    @GetMapping("/getmovie/all")
    public List<Movie> listMoviesAll(){
        return movieFinder.findAllMovies();
    }

    @GetMapping("/getmovie/director/{director}")
    public List<Movie> listMoviesDirectedBy(@PathVariable String director){
        List<Movie> allMovies = movieFinder.findAllMovies();
        allMovies.removeIf(movie -> !movie.getDirector().equals(director));
        return allMovies;
    }

    @GetMapping("/getmovie/id/{Id}")
    public Optional<Movie> listMoviesById(@PathVariable int Id){
        return movieFinder.findById(Id);
    }

    //no need for format validation because it would be done before being passed to api
    @PostMapping("/addmovie")
    public String newMovies(@RequestBody List<Movie> movieList)
    {
        StringBuilder out = new StringBuilder();
        try {
            List<Movie> nMovies = movieFinder.saveAllMovies(movieList);
            for(Movie movie : nMovies){
            out.append("Successfully added ").append(movie.getTitle()).append(" by ").append(movie.getDirector()).append(".\n");
            }
            return out.toString();
        }
        catch (Exception e) {
            System.out.println(e);
            return "Aborted";
        }
    }

    @DeleteMapping("/delmovie/{Id}")
    public String deleteMovie(@PathVariable int Id) {
        boolean temp = movieFinder.deleteMovie(Id);
        String response;
        if (temp)
            response = "Success";
        else
            response = "Aborted";
        return response;
    }

    @PutMapping("/updatemovie/{Id}")
    public String updateEmployee(@RequestBody Movie movie, @PathVariable int Id) {
        boolean temp = movieFinder.updateMovie(Id,movie);
        String response;
        if (temp)
            response = "Success";
        else
            response = "Aborted";
        return response;
    }
}
