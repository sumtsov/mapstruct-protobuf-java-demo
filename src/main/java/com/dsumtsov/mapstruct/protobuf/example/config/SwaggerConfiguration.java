package com.dsumtsov.mapstruct.protobuf.example.config;

import com.hubspot.jackson.datatype.protobuf.ProtobufModule;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.configuration.ObjectMapperConfigured;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration implements ApplicationListener<ObjectMapperConfigured> {

    private static final Contact DEFAULT_CONTACT = new Contact(
            "Dmitry Sumtsov", "https://github.com/sumtsov", "dmsmtsv@gmail.com");

    private static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
            "Mapstruct Protobuf Java REST API", "",
            "1.0", "urn:tos", DEFAULT_CONTACT,
            "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<>(Arrays.asList("application/json", "application/xml"));

    private static final String DEFAULT_BASE_PACKAGE = "com.dsumtsov.mapstruct.protobuf.example";

    @Override
    public void onApplicationEvent(ObjectMapperConfigured event) {
        event.getObjectMapper().registerModule(new ProtobufModule());
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(DEFAULT_BASE_PACKAGE))
                .build()
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }
}
