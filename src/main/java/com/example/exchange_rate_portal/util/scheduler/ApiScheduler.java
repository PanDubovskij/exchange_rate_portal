package com.example.exchange_rate_portal.util.scheduler;

import com.example.exchange_rate_portal.domain.ExchangeRate;
import com.example.exchange_rate_portal.external_api.ExchangeRatesApi;
import com.example.exchange_rate_portal.external_api.entity.FxRate;
import com.example.exchange_rate_portal.external_api.entity.FxRates;
import com.example.exchange_rate_portal.repository.ExchangeRatesRepository;
import com.example.exchange_rate_portal.util.LastUpdatedDate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@EnableScheduling
public class ApiScheduler {

    private final ExchangeRatesRepository exchangeRatesRepository;
    private final ExchangeRatesApi exchangeRatesApi;
    private final FxRate2ExchangeRateMapper mapper;

    public ApiScheduler(ExchangeRatesRepository exchangeRatesRepository, ExchangeRatesApi exchangeRatesApi, FxRate2ExchangeRateMapper mapper) {
        this.exchangeRatesRepository = exchangeRatesRepository;
        this.exchangeRatesApi = exchangeRatesApi;
        this.mapper = mapper;
    }

    @Scheduled(cron = "0 0 7 * * MON-FRI")
    public void updateCurrentFxRates() {
        FxRates fxRates = exchangeRatesApi.getCurrentFxRates("EU");
        List<FxRate> currentRates = fxRates.getFxRates();
        LastUpdatedDate.updateDate(currentRates);

        List<ExchangeRate> currentExchangeRates = new ArrayList<>();
        for (FxRate fx : currentRates) {
            currentExchangeRates.add(mapper.mapFrom(fx));
        }
        exchangeRatesRepository.saveAll(currentExchangeRates);
    }
}
