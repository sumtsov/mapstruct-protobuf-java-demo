package com.dsumtsov.mapstruct.protobuf.example.controller;

import com.dsumtsov.mapstruct.protobuf.example.mapper.ExchangeRateMapper;
import com.dsumtsov.mapstruct.protobuf.example.mapper.ResponseMapper;
import com.dsumtsov.mapstruct.protobuf.example.protobuf.ExchangeRateProto.ExchangeRateList;
import com.dsumtsov.mapstruct.protobuf.example.protobuf.ExchangeRateProto.ExchangeRate;
import com.dsumtsov.mapstruct.protobuf.example.protobuf.ResponseProto.Response;
import com.dsumtsov.mapstruct.protobuf.example.service.ExchangeRateService;
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
    public Response getExchangeRate() {
        ExchangeRate exchangeRate = ExchangeRateMapper.MAPPER.toProto(
                service.getExchangeRate());
        return ResponseMapper.MAPPER.successResponse(exchangeRate);
    }

    @GetMapping("/get-exchange-rate-list")
    public Response getExchangeRateList() {
        ExchangeRateList exchangeRateList = ExchangeRateMapper.MAPPER.getExchangeRateList(
                service.getExchangeRateList());
        return ResponseMapper.MAPPER.successResponse(exchangeRateList);
    }
}
