package com.example.exchange_rate_portal.api;

import com.example.exchange_rate_portal.api.entity.FxRates;

import java.time.LocalDate;

public interface ExchangeRatesApi {

    FxRates getCurrentFxRates(String tp);

    FxRates getFxRatesForCurrency(String tp, String ccy, LocalDate dtFrom, LocalDate dtTo);

}
