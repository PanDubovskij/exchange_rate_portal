package com.example.exchange_rate_portal.web.controller;

import com.example.exchange_rate_portal.domain.ExchangeRate;
import com.example.exchange_rate_portal.service.ExchangeRatesService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v0.0.2/exchange-rates-portal")
public final class ExchangeRatesController {

    private final ExchangeRatesService exchangeRatesService;

    public ExchangeRatesController(ExchangeRatesService exchangeRatesService) {
        this.exchangeRatesService = exchangeRatesService;
    }

    @GetMapping(value = "/current-rates", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ExchangeRate> getCurrentFxRatesForEuro() {
        return exchangeRatesService.getCurrentFxRatesForEuro();
    }

    @GetMapping(value = "/rates-for-currency", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ExchangeRate> getAllFxRatesForCurrency(@RequestParam String currencyCode) {
        return exchangeRatesService.getAllFxRatesForCurrency(currencyCode);
    }

    @GetMapping(value = "/all-rates", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ExchangeRate> getRates() {
        return exchangeRatesService.getAllRates();
    }

//
//    @GetMapping(value = "/test")
//    public List<ExchangeRate> test() {
//        return exchangeRatesRepository.findAllByCcy2("aud");
//    }
}
