package by.vadarod.bankapi.clients;

import by.vadarod.bankapi.dto.response.RateApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@FeignClient(value = "bank-api", url = "https://api.nbrb.by")
public interface BankApiClient {

    @GetMapping("/exrates/rates")
    ResponseEntity<List<RateApiResponse>> loadAllExchangeRatesByDate(@RequestParam(name = "ondate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, @RequestParam(name = "periodicity") Integer periodicity);
}
