package com.example.exchange_rate_portal.repository;

import com.example.exchange_rate_portal.domain.ExchangeRate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ExchangeRatesRepository extends CrudRepository<ExchangeRate, Long> {
    //    @Query("SELECT tp, MAX(dt), ccy1, amt1, ccy2, amt2 FROM RATES GROUP BY ccy2 ORDER BY ccy2")
    List<ExchangeRate> findAllByDt(/*@Param("dt")*/ LocalDate dt);

    //    @Query("SELECT tp, dt, ccy1, amt1, ccy2, amt2 FROM rates WHERE ccy2=:ccy2 ")
    List<ExchangeRate> findAllByCcy2(/*@Param("ccy2")*/String currency);
}
