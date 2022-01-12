package com.mariobr.dsmovie.controllers;

import com.mariobr.dsmovie.dto.MovieDTO;
import com.mariobr.dsmovie.dto.ScoreDTO;
import com.mariobr.dsmovie.services.MovieService;
import com.mariobr.dsmovie.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {
        @Autowired
        private ScoreService service;

        @PutMapping
        public MovieDTO saveScore(@RequestBody ScoreDTO scoreDTO){
            MovieDTO movieDTO = service.saveScore(scoreDTO);
            return movieDTO;
    }

}
