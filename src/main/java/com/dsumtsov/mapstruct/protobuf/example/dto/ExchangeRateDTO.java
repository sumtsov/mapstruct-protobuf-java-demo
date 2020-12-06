package com.dsumtsov.mapstruct.protobuf.example.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExchangeRateDTO {
    private String basicCurrency;
    private String targetCurrency;
    private BigDecimal rate;
}
