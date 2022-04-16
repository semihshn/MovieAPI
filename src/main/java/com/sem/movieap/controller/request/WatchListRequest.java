package com.sem.movieap.controller.request;

import com.sem.movieap.service.watchlist.WatchList;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class WatchListRequest {
    @NotBlank
    private String name;

    public WatchList convertToWatchList() {
        return WatchList.builder()
                .name(name)
                .build();
    }
}
