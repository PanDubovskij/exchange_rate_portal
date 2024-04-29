package com.example.exchange_rate_portal.service;

import com.example.exchange_rate_portal.domain.ExchangeRate;

import java.util.List;

public interface ExchangeRatesService {

    List<ExchangeRate> getCurrentFxRatesForEuro();

    List<ExchangeRate> getAllFxRatesForCurrency(String currencyCode);

//    ExchangeRate test();
}
