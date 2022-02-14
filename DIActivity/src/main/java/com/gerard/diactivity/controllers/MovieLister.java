package com.gerard.diactivity.controllers;

import com.gerard.diactivity.datamapper.MovieResponseMapper;
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

    @GetMapping("/getmovie/movieId/{Id}")
    public MovieResponseDTO listMoviesByMovieId(@PathVariable String Id){
        return movieFinder.findByMovieId(Id);
    }

    @GetMapping("/getmovie/id/{Id}")
    public MovieResponseDTO listMoviesById(@PathVariable int Id){

        return movieFinder.findById(Id);
    }

    //no need for format validation because it would be done before being passed to api
    @PostMapping("/addmovie")
    public MovieResponseDTO newMovies(@RequestBody MovieRequestDTO movieList)
    {
        try {
            MovieResponseDTO nMovies = movieFinder.saveMovie(movieList);
            return nMovies;
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
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

    @DeleteMapping("/delmovie/movieId/{Id}")
    public String deleteMovieByMovieId(@PathVariable String Id) {
        boolean temp = movieFinder.deleteMovieByMovieId(Id);
        String response;
        if (temp)
            response = "Success";
        else
            response = "Aborted";
        return response;
    }

    @PutMapping("/updatemovie/{Id}")
    public Movie updateMovie(@RequestBody Movie movie, @PathVariable int Id) {
        return movieFinder.updateMovie(Id,movie);
    }

    @PutMapping("/updatemovie/movieId/{Id}")
    public MovieResponseDTO updateMovieByMovieId(@RequestBody MovieRequestDTO movie, @PathVariable String Id) {
        return movieFinder.updateMovieByMovieId(Id,movie);
    }
}
