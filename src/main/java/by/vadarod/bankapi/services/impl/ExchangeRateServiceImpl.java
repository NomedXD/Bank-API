package by.vadarod.bankapi.services.impl;

import by.vadarod.bankapi.clients.BankApiClient;
import by.vadarod.bankapi.domain.Rate;
import by.vadarod.bankapi.dto.mappers.RateListMapper;
import by.vadarod.bankapi.dto.mappers.RateMapper;
import by.vadarod.bankapi.dto.response.RateResponse;
import by.vadarod.bankapi.exceptions.NoSuchEntityException;
import by.vadarod.bankapi.exceptions.WrongDateException;
import by.vadarod.bankapi.repositories.ExchangeRateRepository;
import by.vadarod.bankapi.services.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Transactional
public class ExchangeRateServiceImpl implements ExchangeRateService {
    private final BankApiClient bankApiClient;
    private final ExchangeRateRepository exchangeRateRepository;
    private final RateMapper rateMapper;
    private final RateListMapper rateListMapper;

    @Override
    public Integer loadExchangeRateByDate(LocalDate date) {
        if (date.isAfter(LocalDate.now())) {
            throw new WrongDateException();
        }
        LocalDateTime checkDateTime = date.atStartOfDay();
        Integer existingRatesCount = exchangeRateRepository.countAllByDateTime(checkDateTime);
        if (existingRatesCount > 0) {
            return existingRatesCount;
        }
        List<Rate> rateList = rateListMapper.toRateList(Stream.concat(Objects.requireNonNull(bankApiClient.loadAllExchangeRatesByDate(date, 0).getBody()).stream(),
                Objects.requireNonNull(bankApiClient.loadAllExchangeRatesByDate(date, 1).getBody()).stream()).collect(Collectors.toList()));
        exchangeRateRepository.saveAll(rateList);
        return rateList.size();
    }

    @Override
    public RateResponse getExchangeRateByCurrentIdAndDate(Long currentId, LocalDate date) {
        if (date.isAfter(LocalDate.now())) {
            throw new WrongDateException();
        }
        return rateMapper.toRateResponse(exchangeRateRepository.findByCurrentIdAndDateTime(currentId, date.atStartOfDay()).orElseThrow(() -> new NoSuchEntityException(currentId, date)));
    }
}
