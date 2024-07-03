package by.vadarod.bankapi.repositories;

import by.vadarod.bankapi.domain.Rate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ExchangeRateRepository extends JpaRepository<Rate, Long> {
    Integer countAllByDateTime(LocalDateTime dateTime);
    Optional<Rate> findByCurrentIdAndDateTime(Long currentId, LocalDateTime dateTime);
}
