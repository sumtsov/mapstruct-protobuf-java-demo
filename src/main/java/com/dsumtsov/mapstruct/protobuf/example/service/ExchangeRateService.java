package com.dsumtsov.mapstruct.protobuf.example.service;

import com.dsumtsov.mapstruct.protobuf.example.dto.ExchangeRateDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class ExchangeRateService {

    public ExchangeRateDTO getExchangeRate() {
        ExchangeRateDTO dto = new ExchangeRateDTO();
        dto.setBasicCurrency("RU");
        dto.setTargetCurrency("USD");
        dto.setRate(BigDecimal.valueOf(74.12));
        return dto;
    }

    public List<ExchangeRateDTO> getExchangeRateList() {
        return Arrays.asList(getExchangeRate());
    }
}
