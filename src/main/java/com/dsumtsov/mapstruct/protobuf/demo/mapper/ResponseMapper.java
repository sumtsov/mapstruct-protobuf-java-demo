package com.dsumtsov.mapstruct.protobuf.demo.mapper;

import com.dsumtsov.mapstruct.protobuf.demo.protobuf.ResponseProto.ErrorCode;
import com.dsumtsov.mapstruct.protobuf.demo.protobuf.ResponseProto.Response;
import com.google.protobuf.Any;
import com.google.protobuf.Message;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class ResponseMapper {

    public static ResponseMapper MAPPER = Mappers.getMapper(ResponseMapper.class);

    public <T extends Message> Response successResponse(T message) {
        return Response.newBuilder()
                .setSuccess(true)
                .setBody(Any.pack(message))
                .build();
    }

    public Response errorResponse(int code, String message) {
        return Response.newBuilder()
                .setSuccess(false)
                .setError(
                        ErrorCode.newBuilder()
                                .setCode(code)
                                .setMessage(message)
                                .build()
                )
                .build();
    }
}
