package com.sem.movieap.repository.movielist;

import com.sem.movieap.repository.movie.MovieEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieListDaoImpl implements MovieListDao{

    private final MovieListJpaRepository movieListJpaRepository;

    @Override
    public Long save(MovieListEntity entity) {
        MovieListEntity savedEntity=movieListJpaRepository.save(entity);
        return savedEntity.getId();
    }

    @Override
    public MovieListEntity retrieve(Long id) {
        Optional<MovieListEntity> movieListEntityOptional = movieListJpaRepository.findById(id);

        if (movieListEntityOptional.isPresent())
            return movieListEntityOptional.get();
        else
            throw new RuntimeException();
    }
}
