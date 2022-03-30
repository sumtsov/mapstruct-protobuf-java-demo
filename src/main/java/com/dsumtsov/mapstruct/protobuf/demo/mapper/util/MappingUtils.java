package com.dsumtsov.mapstruct.protobuf.demo.mapper.util;

import com.dsumtsov.mapstruct.protobuf.demo.protobuf.BDecimalProto.BDecimal;
import com.dsumtsov.mapstruct.protobuf.demo.protobuf.BIntegerProto.BInteger;

import java.math.BigDecimal;

public class MappingUtils {

    private MappingUtils() {
    }

    public static BDecimal toBDecimalProto(BigDecimal value) {
        return BDecimal.newBuilder()
                .setScale(value.scale())
                .setIntVal(
                        BInteger.newBuilder()
                                .setVal(String.valueOf(value.intValueExact()))
                                .build()
                )
                .build();
    }
}
