package by.vadarod.bankapi.services;

import by.vadarod.bankapi.dto.response.RateResponse;

import java.time.LocalDate;

public interface ExchangeRateService {
    Integer loadExchangeRateByDate(LocalDate date);

    RateResponse getExchangeRateByCurrentIdAndDate(Long currentId, LocalDate date);
}
