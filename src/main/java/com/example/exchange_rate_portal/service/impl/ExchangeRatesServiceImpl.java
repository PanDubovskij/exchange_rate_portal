package com.example.exchange_rate_portal.service.impl;

import com.example.exchange_rate_portal.api.ExchangeRatesApi;
import com.example.exchange_rate_portal.domain.ExchangeRate;
import com.example.exchange_rate_portal.repository.ExchangeRatesRepository;
import com.example.exchange_rate_portal.service.ExchangeRatesService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExchangeRatesServiceImpl implements ExchangeRatesService {

    private final ExchangeRatesApi exchangeRatesApi;
    private final ExchangeRatesRepository exchangeRatesRepository;

    ExchangeRatesServiceImpl(ExchangeRatesApi exchangeRatesApi, ExchangeRatesRepository exchangeRatesRepository) {
        this.exchangeRatesApi = exchangeRatesApi;
        this.exchangeRatesRepository = exchangeRatesRepository;
    }

    @Override
    public List<ExchangeRate> getCurrentFxRatesForEuro() {
//        return exchangeRatesApi.getCurrentFxRates("EU");
        List<ExchangeRate> allLatestRates = exchangeRatesRepository.findAllByDt(LocalDate.now());
        System.out.println(allLatestRates);
        return allLatestRates;
    }

//    @Override
//    public List<ExchangeRate> getAllFxRatesForCurrency(String currencyCode) {
//        List<ExchangeRate> allByCcy2 = exchangeRatesRepository.findAllByCcy2(currencyCode);
//        System.out.println(allByCcy2);
//        return allByCcy2;
//    }

//    @Override
//    public ExchangeRate test() {
//        return null;
//    }
}
