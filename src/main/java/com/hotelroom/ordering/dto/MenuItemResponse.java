package com.hotelroom.ordering.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Menu item available for ordering")
public class MenuItemResponse {

    @Schema(example = "TEA")
    private String code;

    @Schema(example = "Masala Tea")
    private String name;

    @Schema(example = "2.50")
    private BigDecimal price;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
