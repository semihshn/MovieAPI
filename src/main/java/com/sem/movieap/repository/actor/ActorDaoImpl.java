package com.sem.movieap.repository.actor;

import com.sem.movieap.repository.member.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActorDaoImpl implements ActorDao {

    private final ActorJpaRepository actorJpaRepository;

    @Override
    public Long save(ActorEntity entity) {
        ActorEntity actorEntity=actorJpaRepository.save(entity);
        return actorEntity.getId();
    }

    @Override
    public ActorEntity retrieve(Long id) {
        Optional<ActorEntity> actorEntityOptional = actorJpaRepository.findById(id);

        if (actorEntityOptional.isPresent())
            return actorEntityOptional.get();
        else
            throw new RuntimeException();
    }
}
