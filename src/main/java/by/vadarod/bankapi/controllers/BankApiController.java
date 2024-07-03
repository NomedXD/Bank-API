package by.vadarod.bankapi.controllers;

import by.vadarod.bankapi.services.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BankApiController {
    private final ExchangeRateService exchangeRateService;

    @GetMapping("/load")
    public ResponseEntity<String> loadExchangeRateByDate(@RequestParam(name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Read entities=%d", exchangeRateService.loadExchangeRateByDate(date)));
    }
}
