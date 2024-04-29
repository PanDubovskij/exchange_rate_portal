package com.example.exchange_rate_portal.scheduler;

import com.example.exchange_rate_portal.domain.ExchangeRate;
import com.example.exchange_rate_portal.external_api.entity.FxRate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class FxRate2ExchangeRateMapper {
    public ExchangeRate mapFrom(FxRate rate) {
        LocalDate date = LocalDate.parse(rate.getDt());
        Double amt1 = Double.valueOf(rate.getCcyAmts().get(0).getAmt());
        Double amt2 = Double.valueOf(rate.getCcyAmts().get(1).getAmt());

        return new ExchangeRate(
                null,
                rate.getTp(),
                date,
                rate.getCcyAmts().get(0).getCcy(),
                amt1,
                rate.getCcyAmts().get(1).getCcy(),
                amt2
        );
    }
}
