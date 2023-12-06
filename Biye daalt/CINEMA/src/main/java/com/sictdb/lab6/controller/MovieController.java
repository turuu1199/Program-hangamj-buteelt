package com.sictdb.lab6.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sictdb.lab6.model.Movie;
import com.sictdb.lab6.repository.MovieRepository;

@Controller
public class MovieController {

    @Autowired
    private MovieRepository repository;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/imageUpload")
    public String imageUpload(@RequestParam MultipartFile img,
                              @RequestParam String movieDesc,
                              @RequestParam String movieName) {
        System.out.println(img.getOriginalFilename());
        Movie newMovie = new Movie(movieName, movieDesc, img.getOriginalFilename());
        repository.save(newMovie);

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
    public String getMovies(Model model) {
    	return "all-movies";
    }
}
