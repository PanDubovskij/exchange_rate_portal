package com.example.exchange_rate_portal.external_api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "FxRates", namespace = "http://www.lb.lt/WebServices/FxRates")
public class FxRates {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "FxRate")
    @JsonProperty("FxRate")
    private List<FxRate> fxRates;

    public FxRates() {
    }

    public FxRates(List<FxRate> fxRates) {
        this.fxRates = fxRates;
    }

    @Override
    public String toString() {
        return "FxRates{" +
                "fxRates=" + fxRates +
                '}';
    }

    public List<FxRate> getFxRates() {
        return fxRates;
    }

    public void setFxRates(List<FxRate> fxRates) {
        this.fxRates = fxRates;
    }
}
