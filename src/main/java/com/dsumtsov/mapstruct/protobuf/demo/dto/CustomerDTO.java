package com.dsumtsov.mapstruct.protobuf.demo.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class CustomerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String birthDate;
    private Map<String, String> features = new HashMap<>();
}
