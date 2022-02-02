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
        List<Movie> allMovies = movieFinder.findAllMovies();
        return allMovies;
    }

    @GetMapping("/getmovie/director/{director}")
    public List<Movie> listMoviesDirectedBy(@PathVariable String director){


        List<Movie> allMovies = movieFinder.findAllMovies();

        allMovies.removeIf(movie -> !movie.getDirector().equals(director));

        return allMovies;
    }

    @GetMapping("/getmovie/id/{Id}")
    public Optional<Movie> listMoviesById(@PathVariable int Id){

        Optional<Movie> iMovie = movieFinder.findById(Id);

        return iMovie;
    }

    @PostMapping("/addmovie")
    public String newMovies(@RequestBody List<Movie> movieList)
    {
        String out = "";
        try {
            List<Movie> nMovies = movieFinder.saveAllMovies(movieList);
            for(Movie movie : nMovies){
            out += "Successfully added " + movie.getTitle() + " by " + movie.getDirector() + ".\n";
            }
            return out;
        }
        catch (Exception e) {
            return "Aborted";
        }
    }

    @DeleteMapping("/delmovie/{Id}")
    public String deleteMovie(@PathVariable int Id) {
        boolean temp = movieFinder.deleteMovie(Id);
        String response;
        if (temp == true)
            response = "Success";
        else
            response = "Aborted";
        return response;
    }

    @PutMapping("/updatemovie/{Id}")
    public String updateEmployee(@RequestBody Movie movie, @PathVariable int Id) {
        boolean temp = movieFinder.updateMovie(Id,movie);
        String response;
        if (temp == true)
            response = "Success";
        else
            response = "Aborted";
        return response;
    }
}
