package by.vadarod.bankapi.services;

import java.time.LocalDate;

public interface ExchangeRateService {
    Integer loadExchangeRateByDate(LocalDate date);
}
