package com.dsumtsov.mapstruct.protobuf.demo.controller;

import com.dsumtsov.mapstruct.protobuf.demo.mapper.ExchangeRateMapper;
import com.dsumtsov.mapstruct.protobuf.demo.mapper.ResponseMapper;
import com.dsumtsov.mapstruct.protobuf.demo.protobuf.ExchangeRateProto;
import com.dsumtsov.mapstruct.protobuf.demo.protobuf.ResponseProto;
import com.dsumtsov.mapstruct.protobuf.demo.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/exchange-rate")
public class ExchangeRateController {

    private final ExchangeRateService service;

    @GetMapping("/get-exchange-rate")
    public ResponseProto.Response getExchangeRate() {
        ExchangeRateProto.ExchangeRate exchangeRate = ExchangeRateMapper.MAPPER.toProto(
                service.getExchangeRate());
        return ResponseMapper.MAPPER.successResponse(exchangeRate);
    }

    @GetMapping("/get-exchange-rate-list")
    public ResponseProto.Response getExchangeRateList() {
        ExchangeRateProto.ExchangeRateList exchangeRateList = ExchangeRateMapper.MAPPER.getExchangeRateList(
                service.getExchangeRateList());
        return ResponseMapper.MAPPER.successResponse(exchangeRateList);
    }
}
