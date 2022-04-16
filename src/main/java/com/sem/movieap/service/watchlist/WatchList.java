package com.sem.movieap.service.watchlist;

import com.sem.movieap.repository.watchlist.WatchListEntity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
public class WatchList {
    private String name;

    WatchListEntity convertToWatchListEntity() {
        WatchListEntity watchListEntity = new WatchListEntity();
        watchListEntity.setName(getName());
        return watchListEntity;
    }

    public static WatchList convertFrom(WatchListEntity entity) {
        return WatchList.builder()
                .name(entity.getName())
                .build();
    }
}
