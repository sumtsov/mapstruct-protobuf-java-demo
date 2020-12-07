package com.dsumtsov.mapstruct.protobuf.example.service;

import com.dsumtsov.mapstruct.protobuf.example.dto.CustomerDTO;
import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class CustomerService {

    public CustomerDTO getCustomer() {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(1L);
        dto.setFirstName("First Name");
        dto.setLastName("Last Name");
        dto.setEmail("somebody@mail.com");
        dto.setBirthDate("20.10.1995");
        dto.setFeatures(ImmutableMap.of("1", "feature_1",
                "2", "feature_2"));
        return dto;
    }

    public List<CustomerDTO> getCustomerList() {
        return Arrays.asList(getCustomer());
    }

    public Map<Long, CustomerDTO> getCustomerMap() {
        return ImmutableMap.of(1L, getCustomer());
    }

    public Map<Long, List<CustomerDTO>> getCustomerListMap() {
        return ImmutableMap.of(1L, getCustomerList());
    }

    public Map<Long, Map<Long, List<CustomerDTO>>> getCustomerNestedListMap() {
        return ImmutableMap.of(1L, getCustomerListMap());
    }
}
