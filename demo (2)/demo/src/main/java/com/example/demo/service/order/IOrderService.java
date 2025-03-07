package com.example.demo.service.order;

import com.example.demo.dto.OrderDto;
import com.example.demo.model.Order;

import java.util.List;

public interface IOrderService {
    Order placeOrder(Long userId);

    List<OrderDto> getUserOrders(Long userId);

    OrderDto getOrder(Long orderId);
}
