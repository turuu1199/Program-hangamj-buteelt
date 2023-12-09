package com.sictdb.lab6.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sictdb.lab6.model.Movie;
import com.sictdb.lab6.repository.MovieRepository;
import com.sictdb.lab6.services.MovieService;


@Controller
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping("/")
    public String home(Model model) {
    	List<Movie> movies = service.getAllMovies();
  	    model.addAttribute("movies", movies);
        return "home";
    }

    @PostMapping("/imageUpload")
    public String imageUpload(@RequestParam MultipartFile img,
                              @RequestParam String movieDesc,
                              @RequestParam String movieName) {
        System.out.println(img.getOriginalFilename());
        Movie newMovie = new Movie(movieName, movieDesc, img.getOriginalFilename());
        service.saveMovie(newMovie);

        if (newMovie != null) {
            try {
                File saveFile = Paths.get("src/main/resources/static/img").toFile();
                Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + img.getOriginalFilename());
                Files.copy(img.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "redirect:/";
    }
    @GetMapping("/all-movies")
	public String listUsers(Model model) {
	    List<Movie> movies = service.getAllMovies();
	    model.addAttribute("movies", movies);
	    return "all-movies";
	}
    @GetMapping("/add-movie")
    public String home() {
        return "add-movie";
    }
    @PostMapping("/delete/{id}")
    public String deleteMovie(@PathVariable long id) {
    	service.deleteMovieById(id);
    	return "redirect:/all-movies";
    }
    @PostMapping("/update/{id}")
    public String updateMovie(@RequestParam long id,
    						  @RequestParam MultipartFile img,
                              @RequestParam String movieDesc,
                              @RequestParam String movieName) {
    	Movie updateMovie = new Movie(movieName,movieDesc,img.getOriginalFilename());
    	updateMovie.setId(id);
    	service.saveMovie(updateMovie);
    	return "redirect:/all-movies";
    }
    @GetMapping("/update/{id}")
    public String updateMovie(@PathVariable long id, Model model) {
    	Movie movie = service.getMovieById(id);
    	model.addAttribute("movie",movie);
    	return "update-movie";
    }
    @GetMapping("/{id}")
    public String getMovie(Model model,@PathVariable long id) {
    	Movie movie = service.getMovieById(id);
    	model.addAttribute("movie",movie);
    	return "view-movie";
    }
    @GetMapping("/about-me")
    public String aboutMe() {
    	return "about-me";
    }

}
