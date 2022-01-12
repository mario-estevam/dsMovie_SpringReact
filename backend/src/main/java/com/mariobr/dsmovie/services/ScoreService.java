package com.mariobr.dsmovie.services;

import com.mariobr.dsmovie.dto.MovieDTO;
import com.mariobr.dsmovie.dto.ScoreDTO;
import com.mariobr.dsmovie.entities.Movie;
import com.mariobr.dsmovie.entities.Score;
import com.mariobr.dsmovie.entities.User;
import com.mariobr.dsmovie.repositories.MovieRepository;
import com.mariobr.dsmovie.repositories.ScoreRepository;
import com.mariobr.dsmovie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore(ScoreDTO dto){

        User user  = userRepository.findByEmail(dto.getEmail());
        if(user == null){
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        Movie movie = movieRepository.findById(dto.getMovieId()).get();

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(dto.getScore());
        score = scoreRepository.saveAndFlush(score);

        double sum = 0.0;
        for(Score s : movie.getScores()){ // percorrendo a lista de scores acumulando os valores em sum
            sum = sum + s.getValue(); // soma todas as notas
        }

        double avg = sum/movie.getScores().size(); //calcula a média das avaliações
        movie.setScore(avg);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.save(movie);

        return new MovieDTO(movie);

    }




}
