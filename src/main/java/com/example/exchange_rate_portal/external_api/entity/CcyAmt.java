package com.example.exchange_rate_portal.external_api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class CcyAmt {
    @JacksonXmlProperty(localName = "Ccy")
    @JsonProperty("Ccy")
    private String ccy;

    @JacksonXmlProperty(localName = "Amt")
    @JsonProperty("Amt")
    private String amt;

    public CcyAmt() {
    }

    public CcyAmt(String ccy, String amt) {
        this.ccy = ccy;
        this.amt = amt;
    }

    @Override
    public String toString() {
        return "CcyAmt{" +
                "ccy='" + ccy + '\'' +
                ", amt='" + amt + '\'' +
                '}';
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }
}