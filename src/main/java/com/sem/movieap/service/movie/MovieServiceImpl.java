package com.sem.movieap.service.movie;

import com.sem.movieap.repository.movie.MovieDao;
import com.sem.movieap.repository.movie.MovieEntity;
import com.sem.movieap.repository.watchlist.WatchListDao;
import com.sem.movieap.repository.watchlist.WatchListEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final MovieDao movieDao;
    private final WatchListDao watchListDao;
    //private final RedisTemplate<Long, Movie> movieRedisTemplate;

    @Override
    public Long create(Movie movie) {
        WatchListEntity watchListEntity=watchListDao.retrieve(movie.getWatch_list_id());
        MovieEntity movieEntity = movie.convertToMovieEntity(watchListEntity);
        return movieDao.save(movieEntity);
    }

    @Override
    public Movie retrieve(Long id) {
        MovieEntity entity = movieDao.retrieve(id);
        return Movie.convertFrom(entity);
    }
}
