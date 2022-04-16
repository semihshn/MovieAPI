package com.sem.movieap.service.movielist;

import com.sem.movieap.repository.member.MemberDao;
import com.sem.movieap.repository.member.MemberEntity;
import com.sem.movieap.repository.movie.MovieDao;
import com.sem.movieap.repository.movie.MovieEntity;
import com.sem.movieap.repository.movielist.MovieListDao;
import com.sem.movieap.repository.movielist.MovieListEntity;
import com.sem.movieap.repository.watchlist.WatchListDao;
import com.sem.movieap.repository.watchlist.WatchListEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieListServiceImpl implements MovieListService {

    private final MovieListDao movieListDao;
    private final MovieDao movieDao;
    private final WatchListDao watchListDao;

    @Override
    public Long create(MovieList movieList) {
        MovieEntity movieEntity = movieDao.retrieve(movieList.getMovieId());
        WatchListEntity watchListEntity = watchListDao.retrieve(movieList.getWatchListId());

        MovieListEntity movieListEntity=movieList.convertToMovieListEntity(watchListEntity,movieEntity);
        return movieListDao.save(movieListEntity);
    }

    @Override
    public MovieList retrieve(Long id) {
        MovieListEntity entity = movieListDao.retrieve(id);
        return MovieList.convertFrom(entity);
    }
}
