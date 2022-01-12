package com.mariobr.dsmovie.repositories;

import com.mariobr.dsmovie.entities.Movie;
import com.mariobr.dsmovie.entities.Score;
import com.mariobr.dsmovie.entities.ScorePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
}
