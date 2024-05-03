package com.example.exchange_rate_portal.util;

import com.example.exchange_rate_portal.external_api.entity.FxRate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LastUpdatedDate {
    private static LocalDate lastUpdatedDate = LocalDate.now();

    public static LocalDate getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public static void updateDate(List<FxRate> currentRates) {
        List<LocalDate> dates = new ArrayList<>();
        currentRates.forEach(fxRate -> dates.add(LocalDate.parse(fxRate.getDt())));
        lastUpdatedDate = dates.stream().max(LocalDate::compareTo).orElseGet(LocalDate::now);
    }
}
