package com.dsumtsov.mapstruct.protobuf.example.mapper;

import com.dsumtsov.mapstruct.protobuf.example.dto.ExchangeRateDTO;
import com.dsumtsov.mapstruct.protobuf.example.mapper.util.MappingUtils;
import com.dsumtsov.mapstruct.protobuf.example.protobuf.ExchangeRateProto.ExchangeRateList;
import com.dsumtsov.mapstruct.protobuf.example.protobuf.ExchangeRateProto.ExchangeRate;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class ExchangeRateMapper {

    public static ExchangeRateMapper MAPPER = Mappers.getMapper(ExchangeRateMapper.class);

    public ExchangeRateList getExchangeRateList(List<ExchangeRateDTO> list) {
        return ExchangeRateList.newBuilder()
                .addAllExchangeRate(toProtoList(list))
                .build();
    }

    @AfterMapping
    protected void toBDecimal(ExchangeRateDTO dto,
                              @MappingTarget ExchangeRate.Builder builder) {
        builder.setRate(MappingUtils.toBDecimalProto(dto.getRate()));
    }

    @Mapping(target = "rate", ignore = true)
    public abstract ExchangeRate toProto(ExchangeRateDTO dto);
    public abstract List<ExchangeRate> toProtoList(List<ExchangeRateDTO> list);
}
