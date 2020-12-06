package com.dsumtsov.mapstruct.protobuf.example.mapper;

import com.dsumtsov.mapstruct.protobuf.example.dto.CustomerDTO;
import com.dsumtsov.mapstruct.protobuf.example.protobuf.CustomerProto.Customer;
import com.dsumtsov.mapstruct.protobuf.example.protobuf.CustomerProto.CustomerMap;
import com.dsumtsov.mapstruct.protobuf.example.protobuf.CustomerProto.CustomerList;
import com.dsumtsov.mapstruct.protobuf.example.protobuf.CustomerProto.CustomerListMap;
import com.dsumtsov.mapstruct.protobuf.example.protobuf.CustomerProto.CustomerNestedListMap;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Mapper
public abstract class CustomerMapper {

    public static CustomerMapper MAPPER = Mappers.getMapper(CustomerMapper.class);

    public CustomerList getCustomerList(List<CustomerDTO> list) {
        return CustomerList.newBuilder()
                .addAllCustomer(toProtoList(list))
                .build();
    }

    public CustomerMap getCustomerMap(Map<Long, CustomerDTO> map) {
        return CustomerMap.newBuilder()
                .putAllCustomer(toProtoMap(map))
                .build();
    }

    public CustomerListMap getCustomerListMap(Map<Long, List<CustomerDTO>> listMap) {
        return CustomerListMap.newBuilder()
                .putAllCustomer(
                        listMap.entrySet()
                                .stream()
                                .collect(Collectors.toMap(
                                        Map.Entry::getKey,
                                        e -> getCustomerList(e.getValue()))
                                )
                )
                .build();
    }

    public CustomerNestedListMap getCustomerNestedListMap(Map<Long, Map<Long, List<CustomerDTO>>> nestedListMap) {
        return CustomerNestedListMap.newBuilder()
                .putAllCustomer(
                        nestedListMap.entrySet()
                                .stream()
                                .collect(Collectors.toMap(
                                        Map.Entry::getKey,
                                        e -> getCustomerListMap(e.getValue()))
                                )
                )
                .build();
    }

    @AfterMapping
    protected void toFeaturesProto(CustomerDTO dto,
                                   @MappingTarget Customer.Builder builder) {
        builder.putAllFeatures(dto.getFeatures());
    }

    @Mapping(target = "features", ignore = true)
    public abstract Customer toProto(CustomerDTO dto);
    public abstract List<Customer> toProtoList(List<CustomerDTO> list);
    public abstract Map<Long, Customer> toProtoMap(Map<Long, CustomerDTO> map);
}
