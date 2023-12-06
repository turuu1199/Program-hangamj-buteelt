package com.sictdb.lab6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sictdb.lab6.model.Movie;

public interface MovieRepository extends JpaRepository<Movie,Long>{
}
