package com.hotelroom.ordering.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI orderingOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Hotel Room Ordering API")
                        .description("API for placing tea/coffee room-service orders")
                        .version("v1")
                        .contact(new Contact().name("Hotel Ops"))
                        .license(new License().name("Internal")));
    }
}
