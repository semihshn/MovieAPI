package com.sem.movieap.service.actor;

import com.sem.movieap.repository.actor.ActorEntity;
import com.sem.movieap.repository.member.MemberEntity;
import com.sem.movieap.service.member.Member;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Builder
@EqualsAndHashCode
public class Actor {
    private Long id;
    private String name;
    private LocalDateTime birthDate;

    ActorEntity convertToActorEntity() {
        ActorEntity actorEntity = new ActorEntity();
        actorEntity.setName(getName());
        actorEntity.setBirthDate(getBirthDate());
        return actorEntity;
    }

    public static Actor convertFrom(ActorEntity entity) {
        return Actor.builder()
                .name(entity.getName())
                .birthDate(entity.getBirthDate())
                .build();
    }
}
