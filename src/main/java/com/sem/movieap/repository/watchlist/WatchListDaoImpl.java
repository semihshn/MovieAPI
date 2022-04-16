package com.sem.movieap.repository.watchlist;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WatchListDaoImpl implements WatchListDao{

    private final WatchListJpaRepository watchListJpaRepository;

    @Override
    public Long save(WatchListEntity entity) {
        WatchListEntity savedEntity = watchListJpaRepository.save(entity);
        return savedEntity.getId();
    }

    @Override
    public WatchListEntity retrieve(Long id) {
        Optional<WatchListEntity> watchListEntityOptional = watchListJpaRepository.findById(id);

        if (watchListEntityOptional.isPresent())
            return watchListEntityOptional.get();
        else
            throw new RuntimeException();
    }
}
