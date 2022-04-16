package com.sem.movieap.repository.movie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieJpaRepository extends JpaRepository<MovieEntity, Long> {
}
