package com.example.exchange_rate_portal.util.db_loader;

import com.example.exchange_rate_portal.domain.ExchangeRate;
import com.example.exchange_rate_portal.external_api.ExchangeRatesApi;
import com.example.exchange_rate_portal.external_api.entity.FxRate;
import com.example.exchange_rate_portal.external_api.entity.FxRates;
import com.example.exchange_rate_portal.repository.ExchangeRatesRepository;
import com.example.exchange_rate_portal.util.scheduler.FxRate2ExchangeRateMapper;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseLoader {
    private final ExchangeRatesApi api;
    private final FxRate2ExchangeRateMapper mapper;
    private final ExchangeRatesRepository exchangeRatesRepository;

    public DatabaseLoader(ExchangeRatesApi api, FxRate2ExchangeRateMapper mapper, ExchangeRatesRepository exchangeRatesRepository) {
        this.api = api;
        this.mapper = mapper;
        this.exchangeRatesRepository = exchangeRatesRepository;
    }

    @Transactional
    @EventListener(ApplicationReadyEvent.class)
    public void populateDatabase() {
        //exchange rate type. just for backward api compatibility
        String tp = "EU";
        //The earliest date of rates according to the api docs
        LocalDate dtFrom = LocalDate.of(2014, 12, 30);
        LocalDate dtTo = LocalDate.now();
        ArrayList<String> currencyCodes = new ArrayList<>();
        api.getCurrentFxRates(tp).getFxRates().forEach(fxRate -> currencyCodes.add(fxRate.getCcyAmts().get(1).getCcy()));
        for (String currencyCode : currencyCodes) {
            System.out.println(currencyCode);
            FxRates fxRates = api.getFxRatesForCurrency(tp, currencyCode, dtFrom, dtTo);
            saveRatesToDb(fxRates);
        }
    }

    private void saveRatesToDb(FxRates fxRates) {
        List<ExchangeRate> exchangeRates = new ArrayList<>();
        if (fxRates.getFxRates() != null) {
            for (FxRate fxRate : fxRates.getFxRates()) {
                ExchangeRate exchangeRate = mapper.mapFrom(fxRate);
                exchangeRates.add(exchangeRate);
            }
            exchangeRatesRepository.saveAll(exchangeRates);
        }
    }
}
