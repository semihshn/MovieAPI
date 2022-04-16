package com.sem.movieap.repository.watchlist;

public interface WatchListDao {

    Long save(WatchListEntity entity);

    WatchListEntity retrieve(Long id);
}
