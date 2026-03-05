package com.hotelroom.ordering.dto;

import com.hotelroom.ordering.entity.OrderStatus;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Schema(description = "Response payload for a placed beverage order")
public class OrderResponse {

    @Schema(example = "1")
    private Long id;

    @Schema(example = "TEA")
    private String menuCode;

    @Schema(example = "Masala Tea")
    private String menuName;

    @Schema(example = "2")
    private Integer quantity;

    @Schema(example = "1208")
    private String roomNumber;

    @Schema(example = "PLACED")
    private OrderStatus status;

    @Schema(example = "5.00")
    private BigDecimal totalPrice;

    @Schema(example = "2026-03-05T10:15:30Z")
    private OffsetDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
