package com.example.exchange_rate_portal.service.impl;

import com.example.exchange_rate_portal.domain.ExchangeRate;
import com.example.exchange_rate_portal.repository.ExchangeRatesRepository;
import com.example.exchange_rate_portal.service.ExchangeRatesService;
import com.example.exchange_rate_portal.util.LastUpdatedDate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExchangeRatesServiceImpl implements ExchangeRatesService {

    private final ExchangeRatesRepository exchangeRatesRepository;

    ExchangeRatesServiceImpl(ExchangeRatesRepository exchangeRatesRepository) {
        this.exchangeRatesRepository = exchangeRatesRepository;
    }

    @Override
    public List<ExchangeRate> getCurrentFxRatesForEuro() {
         return exchangeRatesRepository.findAllByDt(LastUpdatedDate.getLastUpdatedDate());
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
