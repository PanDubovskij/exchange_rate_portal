package com.example.exchange_rate_portal.domain;

//import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.Objects;

//@Entity
@Table(name = "RATES")
public class ExchangeRate {

    @Id
    @JsonIgnore
    private Long id;

    @Column("TP")
    private String tp;

    @Column("DT")
    private LocalDate dt;

    @Column("CCY1")
    private String ccy1;

    @Column("AMT1")
    private Double amt1;

    @Column("CCY2")
    private String ccy2;

    @Column("AMT2")
    private Double amt2;

    public ExchangeRate() {
    }

    public ExchangeRate(Long id, String tp, LocalDate dt, String ccy1, Double amt1, String ccy2, Double amt2) {
        this.id = id;
        this.tp = tp;
        this.dt = dt;
        this.ccy1 = ccy1;
        this.amt1 = amt1;
        this.ccy2 = ccy2;
        this.amt2 = amt2;
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "id=" + id +
                ", tp='" + tp + '\'' +
                ", dt=" + dt +
                ", cc1='" + ccy1 + '\'' +
                ", amt1=" + amt1 +
                ", cc2='" + ccy2 + '\'' +
                ", amt2=" + amt2 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExchangeRate that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(tp, that.tp) && Objects.equals(dt, that.dt) && Objects.equals(ccy1, that.ccy1) && Objects.equals(amt1, that.amt1) && Objects.equals(ccy2, that.ccy2) && Objects.equals(amt2, that.amt2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tp, dt, ccy1, amt1, ccy2, amt2);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public LocalDate getDt() {
        return dt;
    }

    public void setDt(LocalDate dt) {
        this.dt = dt;
    }

    public String getCcy1() {
        return ccy1;
    }

    public void setCcy1(String cc1) {
        this.ccy1 = cc1;
    }

    public Double getAmt1() {
        return amt1;
    }

    public void setAmt1(Double amt1) {
        this.amt1 = amt1;
    }

    public String getCcy2() {
        return ccy2;
    }

    public void setCcy2(String cc2) {
        this.ccy2 = cc2;
    }

    public Double getAmt2() {
        return amt2;
    }

    public void setAmt2(Double amt2) {
        this.amt2 = amt2;
    }
}
