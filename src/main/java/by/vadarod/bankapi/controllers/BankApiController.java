package by.vadarod.bankapi.controllers;

import by.vadarod.bankapi.dto.response.RateResponse;
import by.vadarod.bankapi.services.ExchangeRateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name="Bank API controller", description="Provides methods to load exchange rates and retrieve rate by code(current_id) and date")
public class BankApiController {
    private final ExchangeRateService exchangeRateService;


    @GetMapping("/load")
    @Operation(summary = "Load exchange rates by date", description = "Returns number of rates read")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully loaded"),
            @ApiResponse(responseCode = "400", description = "Error: date is greater than current or wrong given date format")
    })
    public ResponseEntity<String> loadExchangeRate(@RequestParam(name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Read rate list size=%d", exchangeRateService.loadExchangeRateByDate(date)));
    }

    @GetMapping("/rates/{currentId}")
    @Operation(summary = "Get exchange rate by code(current_id) and date", description = "Returns rate entity")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully read"),
            @ApiResponse(responseCode = "400", description = "Error: date is greater than current or wrong given date format"),
            @ApiResponse(responseCode = "404", description = "Error: rate entity was not found(not loaded before)")
    })
    public ResponseEntity<RateResponse> getExchangeRate(@PathVariable(name = "currentId") Long currentId, @RequestParam(name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return ResponseEntity.status(HttpStatus.OK).body(exchangeRateService.getExchangeRateByCurrentIdAndDate(currentId, date));
    }
}
