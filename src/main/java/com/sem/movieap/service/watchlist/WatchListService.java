package com.sem.movieap.service.watchlist;

public interface WatchListService {

    Long create(WatchList watchList);

    WatchList retrieve(Long id);
}
