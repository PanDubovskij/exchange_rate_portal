package com.example.exchange_rate_portal.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;


public class FxRate {
    @JacksonXmlProperty(localName = "Tp")
    @JsonProperty("Tp")
    private String tp;

    @JacksonXmlProperty(localName = "Dt")
    @JsonProperty("Dt")
    private String dt;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "CcyAmt")
    @JsonProperty("CcyAmt")
    private List<CcyAmt> ccyAmts;

    public FxRate() {
    }

    public FxRate(String tp, String dt, List<CcyAmt> ccyAmts) {
        this.tp = tp;
        this.dt = dt;
        this.ccyAmts = ccyAmts;
    }

    @Override
    public String toString() {
        return "FxRate{" +
                "Tp='" + tp + '\'' +
                ", Dt='" + dt + '\'' +
                ", ccyAmts=" + ccyAmts +
                '}';
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public List<CcyAmt> getCcyAmts() {
        return ccyAmts;
    }

    public void setCcyAmts(List<CcyAmt> ccyAmts) {
        this.ccyAmts = ccyAmts;
    }
}