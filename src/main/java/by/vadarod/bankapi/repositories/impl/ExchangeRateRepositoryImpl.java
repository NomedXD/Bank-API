package by.vadarod.bankapi.repositories.impl;

import by.vadarod.bankapi.domain.Rate;
import by.vadarod.bankapi.repositories.ExchangeRateRepository;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class ExchangeRateRepositoryImpl implements ExchangeRateRepository {
    @PersistenceContext
    private Session session;

    @Override
    public Rate create(Rate rate) {
        return session.merge(rate);
    }
}
