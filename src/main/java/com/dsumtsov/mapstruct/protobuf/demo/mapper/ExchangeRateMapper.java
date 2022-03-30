package com.dsumtsov.mapstruct.protobuf.demo.mapper;

import com.dsumtsov.mapstruct.protobuf.demo.mapper.util.MappingUtils;
import com.dsumtsov.mapstruct.protobuf.demo.protobuf.ExchangeRateProto;
import com.dsumtsov.mapstruct.protobuf.demo.dto.ExchangeRateDTO;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class ExchangeRateMapper {

    public static ExchangeRateMapper MAPPER = Mappers.getMapper(ExchangeRateMapper.class);

    public ExchangeRateProto.ExchangeRateList getExchangeRateList(List<ExchangeRateDTO> list) {
        return ExchangeRateProto.ExchangeRateList.newBuilder()
                .addAllExchangeRate(toProtoList(list))
                .build();
    }

    @AfterMapping
    protected void toBDecimal(ExchangeRateDTO dto,
                              @MappingTarget ExchangeRateProto.ExchangeRate.Builder builder) {
        builder.setRate(MappingUtils.toBDecimalProto(dto.getRate()));
    }

    @Mapping(target = "rate", ignore = true)
    public abstract ExchangeRateProto.ExchangeRate toProto(ExchangeRateDTO dto);
    public abstract List<ExchangeRateProto.ExchangeRate> toProtoList(List<ExchangeRateDTO> list);
}
