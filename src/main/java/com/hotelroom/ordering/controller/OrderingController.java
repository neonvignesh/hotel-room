package com.hotelroom.ordering.controller;

import com.hotelroom.ordering.dto.MenuItemResponse;
import com.hotelroom.ordering.dto.OrderResponse;
import com.hotelroom.ordering.dto.PlaceOrderRequest;
import com.hotelroom.ordering.exception.ApiErrorResponse;
import com.hotelroom.ordering.service.OrderingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderingController {

    private final OrderingService orderingService;

    public OrderingController(OrderingService orderingService) {
        this.orderingService = orderingService;
    }

    @GetMapping("/menu")
    @Operation(summary = "Get tea/coffee menu", description = "Returns seed menu items available for room service ordering")
    @ApiResponse(responseCode = "200", description = "Menu fetched",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = MenuItemResponse.class))))
    public List<MenuItemResponse> getMenu() {
        return orderingService.listMenu();
    }

    @PostMapping("/orders")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Place tea/coffee order", description = "Places a beverage order for a room")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Order created",
                    content = @Content(schema = @Schema(implementation = OrderResponse.class))),
            @ApiResponse(responseCode = "400", description = "Validation error",
                    content = @Content(schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Menu item not found",
                    content = @Content(schema = @Schema(implementation = ApiErrorResponse.class)))
    })
    public OrderResponse placeOrder(@Valid @RequestBody PlaceOrderRequest request) {
        return orderingService.placeOrder(request);
    }
}
