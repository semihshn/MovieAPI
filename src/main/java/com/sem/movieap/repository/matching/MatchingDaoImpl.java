package com.sem.movieap.repository.matching;

import com.sem.movieap.repository.member.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MatchingDaoImpl implements MatchingDao{

    private final MatchingJpaRepository matchingJpaRepository;

    @Override
    public Long save(MatchingEntity entity) {
        MatchingEntity savedEntity = matchingJpaRepository.save(entity);
        return savedEntity.getId();
    }

    @Override
    public MatchingEntity retrieve(Long id) {
        Optional<MatchingEntity> matchingEntityOptional = matchingJpaRepository.findById(id);

        if (matchingEntityOptional.isPresent())
            return matchingEntityOptional.get();
        else
            throw new RuntimeException();
    }
}
