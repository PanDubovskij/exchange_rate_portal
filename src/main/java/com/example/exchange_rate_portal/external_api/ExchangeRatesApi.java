package com.example.exchange_rate_portal.external_api;

import com.example.exchange_rate_portal.external_api.entity.FxRates;

import java.time.LocalDate;

public interface ExchangeRatesApi {

    FxRates getCurrentFxRates(String tp);

    FxRates getFxRatesForCurrency(String tp, String ccy, LocalDate dtFrom, LocalDate dtTo);
}
