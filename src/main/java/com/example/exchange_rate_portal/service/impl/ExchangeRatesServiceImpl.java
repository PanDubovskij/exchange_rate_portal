package com.example.exchange_rate_portal.service.impl;

import com.example.exchange_rate_portal.domain.ExchangeRate;
import com.example.exchange_rate_portal.repository.ExchangeRatesRepository;
import com.example.exchange_rate_portal.service.ExchangeRatesService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExchangeRatesServiceImpl implements ExchangeRatesService {

    private final ExchangeRatesRepository exchangeRatesRepository;

    ExchangeRatesServiceImpl(ExchangeRatesRepository exchangeRatesRepository) {
        this.exchangeRatesRepository = exchangeRatesRepository;
    }

    @Override
    public List<ExchangeRate> getCurrentFxRatesForEuro() {
        return exchangeRatesRepository.findAllByDt(LocalDate.now());
    }

    @Override
    public List<ExchangeRate> getAllFxRatesForCurrency(String currencyCode) {
        return exchangeRatesRepository.findAllByCcy2(currencyCode);
    }

    @Override
    public List<ExchangeRate> getAllRates() {
        return (List<ExchangeRate>) exchangeRatesRepository.findAll();
    }
}
