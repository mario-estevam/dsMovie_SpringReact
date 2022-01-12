package com.mariobr.dsmovie.repositories;

import com.mariobr.dsmovie.entities.Movie;
import com.mariobr.dsmovie.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
