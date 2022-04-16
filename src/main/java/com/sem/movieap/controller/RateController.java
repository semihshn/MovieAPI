package com.sem.movieap.controller;

import com.sem.movieap.controller.request.RateRequest;
import com.sem.movieap.controller.response.RateResponse;
import com.sem.movieap.service.rate.Rate;
import com.sem.movieap.service.rate.RateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class RateController {

    private final RateService rateService;

    @PostMapping("/rates")
    public void rate(@RequestBody @Valid RateRequest rateRequest) {
        Rate rate = rateRequest.convertToRate();
        rateService.create(rate);
    }

    @GetMapping("/rates")
    public RateResponse retrieveByMovieId(@RequestParam Long movieId) {
        Rate rate = rateService.retrieve(movieId);
        return RateResponse.convertFromRate(rate);
    }
}
