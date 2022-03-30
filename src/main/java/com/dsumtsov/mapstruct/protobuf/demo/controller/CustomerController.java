package com.dsumtsov.mapstruct.protobuf.demo.controller;

import com.dsumtsov.mapstruct.protobuf.demo.mapper.ResponseMapper;
import com.dsumtsov.mapstruct.protobuf.demo.protobuf.ResponseProto;
import com.dsumtsov.mapstruct.protobuf.demo.mapper.CustomerMapper;
import com.dsumtsov.mapstruct.protobuf.demo.service.CustomerService;
import com.dsumtsov.mapstruct.protobuf.demo.protobuf.CustomerProto.Customer;
import com.dsumtsov.mapstruct.protobuf.demo.protobuf.CustomerProto.CustomerMap;
import com.dsumtsov.mapstruct.protobuf.demo.protobuf.CustomerProto.CustomerList;
import com.dsumtsov.mapstruct.protobuf.demo.protobuf.CustomerProto.CustomerListMap;
import com.dsumtsov.mapstruct.protobuf.demo.protobuf.CustomerProto.CustomerNestedListMap;
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
    public ResponseProto.Response getCustomer() {
        Customer customer = CustomerMapper.MAPPER.toProto(
                service.getCustomer());
        return ResponseMapper.MAPPER.successResponse(customer);
    }

    @GetMapping("/get-customer-list")
    public ResponseProto.Response getCustomerList() {
        CustomerList customerList = CustomerMapper.MAPPER.getCustomerList(
                service.getCustomerList());
        return ResponseMapper.MAPPER.successResponse(customerList);
    }

    @GetMapping("/get-customer-map")
    public ResponseProto.Response getCustomerMap() {
        CustomerMap customerMap = CustomerMapper.MAPPER.getCustomerMap(
                service.getCustomerMap());
        return ResponseMapper.MAPPER.successResponse(customerMap);
    }

    @GetMapping("/get-customer-list-map")
    public ResponseProto.Response getCustomerListMap() {
        CustomerListMap customerListMap = CustomerMapper.MAPPER.getCustomerListMap(
                service.getCustomerListMap());
        return ResponseMapper.MAPPER.successResponse(customerListMap);
    }

    @GetMapping("/get-customer-nested-list-map")
    public ResponseProto.Response getCustomerNestedListMap() {
        CustomerNestedListMap customerNestedListMap = CustomerMapper.MAPPER.getCustomerNestedListMap(
                service.getCustomerNestedListMap());
        return ResponseMapper.MAPPER.successResponse(customerNestedListMap);
    }
}
