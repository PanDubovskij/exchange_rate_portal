package com.example.exchange_rate_portal.external_api.impl;

import com.example.exchange_rate_portal.external_api.ExchangeRatesApi;
import com.example.exchange_rate_portal.external_api.entity.FxRates;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Component
public class ExchangeRatesApiImpl implements ExchangeRatesApi {

    private final RestTemplate restTemplate;


    public ExchangeRatesApiImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public FxRates getCurrentFxRates(String tp) {
        String url = "http://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp=" + tp;
        return getFxRates(url);
    }

    @Override
    public FxRates getFxRatesForCurrency(String tp, String ccy, LocalDate dtFrom, LocalDate dtTo) {
        String url = "http://www.lb.lt/webservices/FxRates/FxRates.asmx/getFxRatesForCurrency?" +
                "tp=" + tp +
                "&ccy=" + ccy +
                "&dtFrom=" + dtFrom +
                "&dtTo=" + dtTo;
        return getFxRates(url);
    }

    private FxRates getFxRates(String url) {
        FxRates list = new FxRates();
        FxRates rates = restTemplate.getForObject(url, FxRates.class);
        System.out.println(rates);
        if (rates != null) {
            list = rates;
        }
        return list;
    }
}
