package com.sem.movieap.service.rate;

import com.sem.movieap.repository.member.MemberDao;
import com.sem.movieap.repository.member.MemberEntity;
import com.sem.movieap.repository.movie.MovieDao;
import com.sem.movieap.repository.movie.MovieEntity;
import com.sem.movieap.repository.rate.RateDao;
import com.sem.movieap.repository.rate.RateEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RateServiceImpl implements RateService {

    private final RateDao rateDao;
    private final MemberDao memberDao;
    private final MovieDao movieDao;

    @Override
    public Long create(Rate rate) {
        MovieEntity movieEntity = movieDao.retrieve(rate.getMovieId());
        MemberEntity memberEntity = memberDao.retrieve(rate.getMemberId());

        RateEntity rateEntity = rate.convertToRateEntity(memberEntity,movieEntity);
        return rateDao.save(rateEntity);
    }

    @Override
    public Rate retrieve(Long movieId) {
        RateEntity entity = rateDao.retrieve(movieId);
        return Rate.convertFrom(entity);
    }
}

//SOAP - wsdl
//APi