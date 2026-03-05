package com.hotelroom.ordering.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Request payload used to place a tea/coffee order")
public class PlaceOrderRequest {

    @Schema(description = "Menu code. Use TEA or COFFEE", example = "TEA")
    @NotBlank
    private String menuCode;

    @Schema(description = "Room number receiving the beverage", example = "1208")
    @NotBlank
    private String roomNumber;

    @Schema(description = "Number of cups", example = "2")
    @NotNull
    @Min(1)
    private Integer quantity;

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
