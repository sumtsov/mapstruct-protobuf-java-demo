package com.dsumtsov.mapstruct.protobuf.example.controller;

import com.dsumtsov.mapstruct.protobuf.example.mapper.CustomerMapper;
import com.dsumtsov.mapstruct.protobuf.example.mapper.ResponseMapper;
import com.dsumtsov.mapstruct.protobuf.example.service.CustomerService;
import com.dsumtsov.mapstruct.protobuf.example.protobuf.ResponseProto.Response;
import com.dsumtsov.mapstruct.protobuf.example.protobuf.CustomerProto.Customer;
import com.dsumtsov.mapstruct.protobuf.example.protobuf.CustomerProto.CustomerMap;
import com.dsumtsov.mapstruct.protobuf.example.protobuf.CustomerProto.CustomerList;
import com.dsumtsov.mapstruct.protobuf.example.protobuf.CustomerProto.CustomerListMap;
import com.dsumtsov.mapstruct.protobuf.example.protobuf.CustomerProto.CustomerNestedListMap;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final CustomerService service;

    @GetMapping("/get-customer")
    public Response getCustomer() {
        Customer customer = CustomerMapper.MAPPER.toProto(
                service.getCustomer());
        return ResponseMapper.MAPPER.successResponse(customer);
    }

    @GetMapping("/get-customer-list")
    public Response getCustomerList() {
        CustomerList customerList = CustomerMapper.MAPPER.getCustomerList(
                service.getCustomerList());
        return ResponseMapper.MAPPER.successResponse(customerList);
    }

    @GetMapping("/get-customer-map")
    public Response getCustomerMap() {
        CustomerMap customerMap = CustomerMapper.MAPPER.getCustomerMap(
                service.getCustomerMap());
        return ResponseMapper.MAPPER.successResponse(customerMap);
    }

    @GetMapping("/get-customer-list-map")
    public Response getCustomerListMap() {
        CustomerListMap customerListMap = CustomerMapper.MAPPER.getCustomerListMap(
                service.getCustomerListMap());
        return ResponseMapper.MAPPER.successResponse(customerListMap);
    }

    @GetMapping("/get-customer-nested-list-map")
    public Response getCustomerNestedListMap() {
        CustomerNestedListMap customerNestedListMap = CustomerMapper.MAPPER.getCustomerNestedListMap(
                service.getCustomerNestedListMap());
        return ResponseMapper.MAPPER.successResponse(customerNestedListMap);
    }
}
