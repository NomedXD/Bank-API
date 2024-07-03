package by.vadarod.bankapi.repositories;

import by.vadarod.bankapi.domain.Rate;

public interface ExchangeRateRepository {

    Rate create(Rate rate);
}
