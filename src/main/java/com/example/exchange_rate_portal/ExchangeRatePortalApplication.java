package com.example.exchange_rate_portal;

//import com.example.exchange_rate_portal.repository.entity.FxRate;
//import com.example.exchange_rate_portal.repository.entity.FxRates;
//import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExchangeRatePortalApplication {

    public static void main(String[] args) {
        /*XmlMapper xmlMapper = new XmlMapper();
        File file = new File("example.xml");
        FxRates besApi = null;
        try {
            besApi = xmlMapper.readValue(file, FxRates.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (FxRate employee : besApi.getFxRates()) {
            System.out.println(employee);
        }*/
        SpringApplication.run(ExchangeRatePortalApplication.class, args);


    }

}
