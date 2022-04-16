package com.sem.movieap.service.actor;

import com.sem.movieap.repository.actor.ActorDao;
import com.sem.movieap.repository.actor.ActorEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService{

    private final ActorDao actorDao;

    @Override
    public Long create(Actor actor) {
        ActorEntity actorEntity=actor.convertToActorEntity();
        return actorDao.save(actorEntity);
    }

    @Override
    public Actor retrieve(Long id){
        ActorEntity actorEntity=actorDao.retrieve(id);
        return Actor.convertFrom(actorEntity);
    }
}
