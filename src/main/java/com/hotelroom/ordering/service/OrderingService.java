package com.hotelroom.ordering.service;

import com.hotelroom.ordering.dto.MenuItemResponse;
import com.hotelroom.ordering.dto.OrderResponse;
import com.hotelroom.ordering.dto.PlaceOrderRequest;
import com.hotelroom.ordering.entity.BeverageOrder;
import com.hotelroom.ordering.entity.MenuItem;
import com.hotelroom.ordering.entity.OrderStatus;
import com.hotelroom.ordering.exception.ResourceNotFoundException;
import com.hotelroom.ordering.repository.BeverageOrderRepository;
import com.hotelroom.ordering.repository.MenuItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Service
public class OrderingService {

    private final MenuItemRepository menuItemRepository;
    private final BeverageOrderRepository beverageOrderRepository;

    public OrderingService(MenuItemRepository menuItemRepository,
                           BeverageOrderRepository beverageOrderRepository) {
        this.menuItemRepository = menuItemRepository;
        this.beverageOrderRepository = beverageOrderRepository;
    }

    @Transactional(readOnly = true)
    public List<MenuItemResponse> listMenu() {
        return menuItemRepository.findAll().stream().map(this::toMenuResponse).toList();
    }

    @Transactional
    public OrderResponse placeOrder(PlaceOrderRequest request) {
        MenuItem menuItem = menuItemRepository.findByCodeIgnoreCase(request.getMenuCode())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Menu item not found for code: " + request.getMenuCode()
                ));

        BeverageOrder order = new BeverageOrder();
        order.setMenuItem(menuItem);
        order.setQuantity(request.getQuantity());
        order.setRoomNumber(request.getRoomNumber());
        order.setStatus(OrderStatus.PLACED);
        order.setCreatedAt(OffsetDateTime.now());

        BeverageOrder saved = beverageOrderRepository.save(order);
        return toOrderResponse(saved);
    }

    private MenuItemResponse toMenuResponse(MenuItem item) {
        MenuItemResponse response = new MenuItemResponse();
        response.setCode(item.getCode());
        response.setName(item.getName());
        response.setPrice(item.getPrice());
        return response;
    }

    private OrderResponse toOrderResponse(BeverageOrder order) {
        OrderResponse response = new OrderResponse();
        response.setId(order.getId());
        response.setMenuCode(order.getMenuItem().getCode());
        response.setMenuName(order.getMenuItem().getName());
        response.setQuantity(order.getQuantity());
        response.setRoomNumber(order.getRoomNumber());
        response.setStatus(order.getStatus());
        response.setCreatedAt(order.getCreatedAt());
        response.setTotalPrice(order.getMenuItem().getPrice().multiply(BigDecimal.valueOf(order.getQuantity())));
        return response;
    }
}
