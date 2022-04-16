package com.sem.movieap.repository.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberDaoImpl implements MemberDao{

    private final MemberJpaRepository memberJpaRepository;

    @Override
    public Long save(MemberEntity entity) {
        MemberEntity savedEntity = memberJpaRepository.save(entity);
        return savedEntity.getId();
    }

    @Override
    public MemberEntity retrieve(Long id) {
        Optional<MemberEntity> memberEntityOptional = memberJpaRepository.findById(id);

        if (memberEntityOptional.isPresent())
            return memberEntityOptional.get();
        else
            throw new RuntimeException();
    }
}
